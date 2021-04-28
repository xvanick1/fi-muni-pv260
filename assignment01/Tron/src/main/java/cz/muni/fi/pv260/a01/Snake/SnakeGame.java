package cz.muni.fi.pv260.a01.Snake;

import cz.muni.fi.pv260.a01.GameEngine.Controller.ControllerBuilder;
import cz.muni.fi.pv260.a01.GameEngine.Controller.InputController;
import cz.muni.fi.pv260.a01.GameEngine.Direction;
import cz.muni.fi.pv260.a01.GameEngine.Game;
import cz.muni.fi.pv260.a01.GameEngine.GameEngine;
import cz.muni.fi.pv260.a01.GameEngine.ScreenManager;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class SnakeGame implements Game {

    private static final int TOUCH_DISTANCE_ACCEPTANCE = 15;
    private static final int OPTIM_EXCESS_POINTS_STORED = 200;
    private SnakePlayer snakePlayer;
    private Food food;
    private int pathLengthToMemorize = OPTIM_EXCESS_POINTS_STORED;
    private final int speed = 4;
    protected SnakeScreenManager snakeScreenManager;
    private static final GameEngine gameEngine= new GameEngine();

    public static void main(String[] args)  {
        gameEngine.newGame(new SnakeGame());
    }


    public void init() {
        snakeScreenManager= new SnakeScreenManager();
        createPlayer(600, 440, Direction.LEFT, Color.GREEN, ControllerBuilder.newArrowsController());
        snakePlayer = (SnakePlayer) gameEngine.getPlayers().get(0);

        DisplayMode displayMode = snakeScreenManager.findFirstCompatibleMode(GameEngine.getModes());
        snakeScreenManager.setFullScreen(displayMode);
        Window w= snakeScreenManager.getFullScreenWindow();
        w.setBackground(Color.WHITE);
        w.setForeground(Color.RED);
        w.setCursor(w.getToolkit().createCustomCursor(new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new java.awt.Point(0, 0),"null"));

        if(this.snakePlayer.getController() instanceof KeyListener){
            w.addKeyListener((KeyListener) this.snakePlayer.getController());
        }
        else{
            System.out.println("Mistake");
        }
        generateNewPointForEating();
    }

    @Override
    public void updateGame() {
        snakePlayer.makeMovement(speed, snakeScreenManager.getMeasurements());
        checkForSelfCollision(snakePlayer.getActualPosition());
        if (snakePlayer.getActualPosition().distanceFromPoint(food) < TOUCH_DISTANCE_ACCEPTANCE) {
            snakePlayer.setNumberOfVisiblePoints(snakePlayer.getNumberOfVisiblePoints() + this.speed);
            generateNewPointForEating();
            pathLengthToMemorize = snakePlayer.getNumberOfVisiblePoints() + OPTIM_EXCESS_POINTS_STORED;
        }
        if (snakePlayer.getPath().size() > pathLengthToMemorize) {
            System.out.println("MEMORY cleared");
            snakePlayer.setPath(snakePlayer.getPath().getLastNPoints(snakePlayer.getNumberOfVisiblePoints()));
        }
        snakePlayer.addCurrentPositionToPath();
    }


    public void restoreScreen() {
        snakeScreenManager.restoreScreen();
    }

    protected Window getFullScreenWindow() {
        return snakeScreenManager.getFullScreenWindow();
    }

    public void updateScreen() {
        snakeScreenManager.updateWindow(this);
    }

    @Override
    public ScreenManager getScreenManager() {
        return this.snakeScreenManager;
    }

    public Graphics2D getGraphics() {
        return snakeScreenManager.getGraphics();
    }

    private void generateNewPointForEating() {
        food = new Food(getFullScreenWindow(), snakePlayer.getPath());
        food.setColor(Color.RED);
    }

    private void checkForSelfCollision(cz.muni.fi.pv260.a01.GameEngine.Point checkedPoint) {
        int pathLength = snakePlayer.getPath().size();
        for (int i = 0; i < pathLength; i++) {
            if (i + this.snakePlayer.getNumberOfVisiblePoints() >= pathLength && snakePlayer.getPath().getPointOnPosition(i).equals(checkedPoint)) {
                System.exit(0);
            }
        }
    }

    @Override
    public void createPlayer(int xPosition, int yPosition, Direction direction, Color color, InputController inputController) {
        SnakePlayer player = new SnakePlayer();
        player.setColor(color);
        player.setController(inputController);
        player.setInitialPosition(xPosition, yPosition);
        player.setInitialDirection(direction);
        gameEngine.addPlayer(player);
    }

    public SnakePlayer getSnake(){
        return snakePlayer;
    }

    public Food getFood(){
        return this.food;
    }

}