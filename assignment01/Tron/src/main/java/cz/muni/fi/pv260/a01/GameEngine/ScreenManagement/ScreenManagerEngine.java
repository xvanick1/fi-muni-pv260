package cz.muni.fi.pv260.a01.GameEngine.ScreenManagement;

import cz.muni.fi.pv260.a01.GameEngine.Game.GameEngine;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class ScreenManagerEngine {

	private GraphicsDevice graphicsDevice;
	private DisplayModesManager displayModesManager;

	public ScreenManagerEngine(){
		GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
		graphicsDevice = e.getDefaultScreenDevice();
		displayModesManager = new DisplayModesManager();
	}


	public void setFullScreen(DisplayMode dm){
		JFrame f = new JFrame();
		f.setUndecorated(true);
		f.setIgnoreRepaint(true);
		f.setResizable(false);
		graphicsDevice.setFullScreenWindow(f);

		if(dm != null && graphicsDevice.isDisplayChangeSupported()){
			try{
				graphicsDevice.setDisplayMode(dm);
			}catch(Exception ex){}
			f.createBufferStrategy(2);
		}
	}

	public Graphics2D getGraphics(){
		Window w = graphicsDevice.getFullScreenWindow();
		if(w != null){
			BufferStrategy bs = w.getBufferStrategy();
			return (Graphics2D)bs.getDrawGraphics();
		}
		else{
			return null;
		}
	}

	public void update(){
		Window w = graphicsDevice.getFullScreenWindow();
		if(w != null){
			BufferStrategy bs = w.getBufferStrategy();
			if(!bs.contentsLost()){
				bs.show();
			}
		}
	}

	public Window getFullScreenWindow(){
		return graphicsDevice.getFullScreenWindow();
	}

	public int getWidth(){
		Window w = getFullScreenWindow();
		if(w != null){
			return w.getWidth();
		}else{
			return 0;
		}
	}

	public int getHeight(){
		Window w = getFullScreenWindow();
		if(w != null){
			return w.getHeight();
		}else{
			return 0;
		}
	}

	public void restoreScreen(){
		Window w = graphicsDevice.getFullScreenWindow();
		if(w != null){
			w.dispose();
		}
		graphicsDevice.setFullScreenWindow(w);
	}

	public DisplayMode findFirstCompatibleMode(DisplayMode[] modes) {
		return displayModesManager.findFirstCompatibleMode(modes);
	}

	public Window initializeGameGraphics(ScreenManager screenManager) {
		DisplayMode displayMode = screenManager.findFirstCompatibleMode(GameEngine.getModes());
		screenManager.setFullScreen(displayMode);
		Window w= screenManager.getFullScreenWindow();
		w.setBackground(Color.WHITE);
		w.setForeground(Color.RED);
		w.setCursor(w.getToolkit().createCustomCursor(new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0),"null"));
		return w;
	}
}
