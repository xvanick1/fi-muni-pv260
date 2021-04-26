package cz.muni.fi.muni.pv260.a01;

import cz.muni.fi.muni.pv260.a01.Controller.ControllerBuilder;
import cz.muni.fi.muni.pv260.a01.Controller.InputController;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class TronGame extends Core {
	ArrayList<Player> players = new ArrayList<>();
	int moveAmount = 5;

	public void init() {
		super.init();

		Window w = screenManager.getFullScreenWindow();

		createPlayer(40,40,Direction.UP, Color.GREEN, ControllerBuilder.newWASDController());
		createPlayer(600,440,Direction.DOWN, Color.RED, ControllerBuilder.newArrowsController());

		for(Player player :players){
			if(player.getController() instanceof KeyListener){
				w.addKeyListener( (KeyListener) player.getController());
			}
			if(player.getController() instanceof MouseListener){
				w.addMouseListener( (MouseListener) player.getController());
			}
		}
	}

	private void createPlayer(int x, int y, Direction startDirection, Color color, InputController inputController) {
		players.add(new Player(x,y,startDirection, color, inputController));
	}

	public static void main(String[] args) {
		new TronGame().run();
	}

	public void draw(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, screenManager.getWidth(), screenManager.getHeight());

		for(Player player : players){
			player.updatePosition(moveAmount, screenManager);
		}
		for (Player player : players) {
			checkForCollisions(player.getCurrentPosition());
		}
		for(Player player :players) {
			player.addCurrentPositionsToPath();
			player.draw(g);
		}
	}

	private void checkForCollisions(Point checkedPoint) {
		for (Player otherPlayer : players) {
			if (otherPlayer.getPath().contains(checkedPoint)) {
				System.out.println("Players collided");
				System.exit(0);
			}
		}
	}
}
