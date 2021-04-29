package cz.muni.fi.pv260.a01.Tron;

import java.awt.*;
import cz.muni.fi.pv260.a01.GameEngine.Controller.ControllerBuilder;
import cz.muni.fi.pv260.a01.GameEngine.Controller.InputController;
import cz.muni.fi.pv260.a01.GameEngine.*;
import cz.muni.fi.pv260.a01.GameEngine.Point;
import cz.muni.fi.pv260.a01.GameEngine.ScreenManagement.ScreenManager;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class TronGame implements Game {
	private TronScreenManager tronScreenManager;
	private static GameEngine gameEngine = new GameEngine();
	private final int speed = 4;

	public static void main(String[] args) {
		gameEngine.newGame(new TronGame());
	}

	@Override
	public void init() throws Exception {
		tronScreenManager= new TronScreenManager();
		DisplayMode displayMode = tronScreenManager.findFirstCompatibleMode(GameEngine.getModes());
		tronScreenManager.setFullScreen(displayMode);
		Window w= tronScreenManager.getFullScreenWindow();
		w.setBackground(Color.WHITE);
		w.setForeground(Color.RED);
		w.setCursor(w.getToolkit().createCustomCursor(new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new java.awt.Point(0, 0),"null"));

		createPlayer(600, 440, Direction.LEFT, Color.RED, ControllerBuilder.newMouseController());
		createPlayer(40, 40, Direction.RIGHT, Color.GREEN, ControllerBuilder.newWASDController());

		for(Player player :gameEngine.getPlayers()){
			if(player.getController() instanceof KeyListener){
				w.addKeyListener( (KeyListener) player.getController());
			}
			else if(player.getController() instanceof MouseListener){
				w.addMouseListener( (MouseListener) player.getController());
			}
			else{
				throw new Exception("Unknown controller Mistake");
			}
		}
	}

	@Override
	public void updateGame() {
		for (Player player : gameEngine.getPlayers()) {
			player.makeMovement(speed, tronScreenManager.getMeasurements());
			checkForCollisions(player.getActualPosition());
			player.addCurrentPositionToPath();
		}
	}

	public void restoreScreen() {
		tronScreenManager.restoreScreen();
	}

	protected Window getFullScreenWindow() {
		return tronScreenManager.getFullScreenWindow();
	}

	public void updateScreen() {
		tronScreenManager.updateWindow(this);
	}

	@Override
	public ScreenManager getScreenManager() {
		return this.tronScreenManager;
	}

	public Graphics2D getGraphics() {
		return tronScreenManager.getGraphics();
	}

	private void checkForCollisions(Point checkedPoint) {
		for (Player otherPlayer : gameEngine.getPlayers()) {
			if (otherPlayer.getPath().contains(checkedPoint)) {
				System.out.println("Players collided");
				System.exit(0);
			}
		}
	}

	@Override
	public void createPlayer(int xPosition, int yPosition, Direction direction, Color color, InputController inputController) {
		TronPlayer player = new TronPlayer();
		player.setColor(color);
		player.setController(inputController);
		player.setInitialPosition(xPosition, yPosition);
		player.setInitialDirection(direction);
		gameEngine.addPlayer(player);
	}

	public ArrayList<Player> getPlayers(){
		return gameEngine.getPlayers();
	}

}
