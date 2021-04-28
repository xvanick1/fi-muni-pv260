package cz.muni.fi.pv260.a01.Snake;

import cz.muni.fi.pv260.a01.GameEngine.Game;
import cz.muni.fi.pv260.a01.GameEngine.ScreenManagerEngine;
import cz.muni.fi.pv260.a01.GameEngine.Point;
import cz.muni.fi.pv260.a01.GameEngine.ScreenManager;
import cz.muni.fi.pv260.a01.GameEngine.ScreenMeasurements;

import java.awt.*;

public class SnakeScreenManager implements ScreenManager {
    private static final int PIXEL_SIZE=15;
    ScreenManagerEngine screenManagerEngine = new ScreenManagerEngine();

    @Override
    public void updateWindow(Game game){
        if(!(game instanceof SnakeGame)){
            System.out.println("bad type in SnakeScreenManager updateWindow method call");
            System.exit(1);
        }
        SnakeGame snakeGame=(SnakeGame) game;
        Graphics2D graphics2D= screenManagerEngine.getGraphics();
        graphics2D.setColor(Color.BLACK);//Color(Color.BLACK);
        graphics2D.fillRect(0, 0, screenManagerEngine.getWidth(), screenManagerEngine.getHeight());
        drawSnake(snakeGame);
        drawFood(snakeGame);
        graphics2D.dispose();
        screenManagerEngine.update();
    }

    private void drawFood(SnakeGame snakeGame) {
        Graphics2D graphics2D= screenManagerEngine.getGraphics();
        graphics2D.setColor(snakeGame.getFood().getColor());
        graphics2D.fillRect(snakeGame.getFood().getX(), snakeGame.getFood().getY(), PIXEL_SIZE, PIXEL_SIZE);
    }

    private void drawSnake(SnakeGame snakeGame) {
        Color snakeColor = snakeGame.getSnake().getColor();
        int snakeLenght=snakeGame.getSnake().getNumberOfVisiblePoints();
        snakeGame.getSnake().getPath().getLastNPoints(snakeLenght).forEach(point -> drawSnakePoint(point,snakeColor));
    }

    private void drawSnakePoint(Point point, Color color){
        Graphics2D graphics2D= screenManagerEngine.getGraphics();
        graphics2D.setColor(color);
        graphics2D.fillRect(point.getX(), point.getY(), PIXEL_SIZE, PIXEL_SIZE);
    }

    @Override
    public Window getFullScreenWindow() {
        return screenManagerEngine.getFullScreenWindow();
    }

    @Override
    public void setFullScreen(DisplayMode displayMode) {
        screenManagerEngine.setFullScreen(displayMode);
    }

    @Override
    public DisplayMode findFirstCompatibleMode(DisplayMode[] modes) {
        return screenManagerEngine.findFirstCompatibleMode(modes);
    }

    @Override
    public void restoreScreen() {
        screenManagerEngine.restoreScreen();
    }

    @Override
    public Graphics2D getGraphics() {
        return screenManagerEngine.getGraphics();
    }

    @Override
    public int getWidth() {
        return screenManagerEngine.getWidth();
    }

    @Override
    public int getHeight() {
        return screenManagerEngine.getHeight();
    }

    @Override
    public ScreenMeasurements getMeasurements() {
        return new ScreenMeasurements(this.getHeight(),this.getWidth());
    }
}