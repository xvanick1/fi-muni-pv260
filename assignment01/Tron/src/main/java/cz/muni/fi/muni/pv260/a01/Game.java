package cz.muni.fi.muni.pv260.a01;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class Game extends Core implements KeyListener, MouseListener, MouseMotionListener {
	ArrayList<Player> players = new ArrayList<Player>();
	int moveAmount = 5;

	public void init() {
		super.init();

		Window w = screenManager.getFullScreenWindow();
		w.addKeyListener(this);
		w.addMouseListener(this);
		w.addMouseMotionListener(this);

		createPlayer(40,40,Direction.UP, Color.GREEN, new KeyBinding(KeyEvent.VK_UP,KeyEvent.VK_DOWN,KeyEvent.VK_LEFT,KeyEvent.VK_RIGHT));
		createPlayer(600,440,Direction.DOWN, Color.RED, new KeyBinding(KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D));

	}

	private void createPlayer(int x, int y, Direction startDirection, Color color, KeyBinding keyBinding) {
		players.add(new Player(x,y,startDirection, color, keyBinding));
	}

	public static void main(String[] args) {
		new Game().run();
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

	public void keyPressed(KeyEvent e) {
		for(Player player: players)
			player.changeDirection(e.getKeyCode());
	}

	public void keyReleased(KeyEvent e) {

	}

	public void keyTyped(KeyEvent arg0) {

	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseDragged(MouseEvent e) {

	}

	public void mouseMoved(MouseEvent e) {

	}
}
