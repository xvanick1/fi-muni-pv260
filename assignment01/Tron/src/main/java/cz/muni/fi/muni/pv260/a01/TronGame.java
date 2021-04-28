package cz.muni.fi.muni.pv260.a01;

import cz.muni.fi.muni.pv260.a01.Controller.ControllerBuilder;
import cz.muni.fi.muni.pv260.a01.Controller.InputController;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.DisplayMode;
import java.awt.image.BufferedImage;

public class TronGame implements Game{
	private ScreenManager screenManager;
	private static final GameEngine gameEngine = new GameEngine();
	int speed = 5;

 	public static void main(String[] args){
 		gameEngine.newGame(new TronGame());
	}

	public void init() {
		screenManager = new ScreenManager();
		DisplayMode displayMode = screenManager.findFirstCompatibaleMode(GameEngine.getModes());
		screenManager.setFullScreen(displayMode);

		Window w = screenManager.getFullScreenWindow();
		w.setBackground(Color.WHITE);
		w.setForeground(Color.RED);
		w.setCursor(w.getToolkit().createCustomCursor(new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new java.awt.Point(0, 0),"null"));

		createPlayer(600, 440, Direction.LEFT, Color.RED, ControllerBuilder.newArrowsController());
		createPlayer(40, 40, Direction.RIGHT, Color.GREEN, ControllerBuilder.newWASDController());

		for(Player player : gameEngine.getPlayers()){
			if(player.getController() instanceof KeyListener){
				w.addKeyListener( (KeyListener) player.getController());
			}
			if(player.getController() instanceof MouseListener){
				w.addMouseListener( (MouseListener) player.getController());
			}
		}
	}

	@Override
	public void updateGame() {
		for (Player player : gameEngine.getPlayers()) {
			player.updatePosition(speed, screenManager);
			checkForCollisions(player.getActualPosition());
			player.addCurrentPositionToPath();
		}
	}

	public void restoreScreen(){
 		screenManager.restoreScreen();
 	}


	@Override
	public void createPlayer(int x, int y, Direction startDirection, Color color, InputController inputController) {
		gameEngine.addPlayer(new Player(x,y,startDirection, color, inputController));
	}

	protected Window getFullScreenWindow() {
		return screenManager.getFullScreenWindow();
	}

	public void updateScreen() {
 		draw(getGraphics());
	}

	@Override
	public ScreenManager getScreenManager() {
		return this.screenManager;
	}

	public Graphics2D getGraphics() {
		return screenManager.getGraphics();
	}


	public void draw(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, screenManager.getWidth(), screenManager.getHeight());

		for(Player player : gameEngine.getPlayers()){
			player.updatePosition(speed, screenManager);
		}
		for (Player player : gameEngine.getPlayers()) {
			checkForCollisions(player.getActualPosition());
		}
		for(Player player : gameEngine.getPlayers()) {
			player.addCurrentPositionToPath();
			player.draw(g);
		}
	}

	private void checkForCollisions(Point checkedPoint) {
		for (Player otherPlayer : gameEngine.getPlayers()) {
			if (otherPlayer.getPath().contains(checkedPoint)) {
				System.out.println("Players collided");
				System.exit(0);
			}
		}
	}
}
