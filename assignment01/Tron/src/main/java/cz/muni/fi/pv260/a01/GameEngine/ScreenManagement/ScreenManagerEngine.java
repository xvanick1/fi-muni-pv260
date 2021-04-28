package cz.muni.fi.pv260.a01.GameEngine.ScreenManagement;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class ScreenManagerEngine {

	private GraphicsDevice graphicsDevice;

	public ScreenManagerEngine(){
		GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
		graphicsDevice = e.getDefaultScreenDevice();
	}

	public DisplayMode[] getCompatibleDisplayModes(){
		return graphicsDevice.getDisplayModes();
	}

	public DisplayMode findFirstCompatibleMode(DisplayMode[] modes){

		DisplayMode[] goodModes = graphicsDevice.getDisplayModes();
		for (DisplayMode mode : modes) {
			for (DisplayMode goodMode : goodModes) {
				if (displayModesMatch(mode, goodMode)) {
					return mode;
				}
			}
		}
		return null;
	}

	public DisplayMode getCurrentDM(){
		return graphicsDevice.getDisplayMode();
	}

	public boolean displayModesMatch(DisplayMode m1, DisplayMode m2){
		if(m1.getWidth() != m2.getWidth() || m1.getHeight() != m2.getHeight()){
			return false;
		}
		if(m1.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI && m2.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI && m1.getBitDepth() != m2.getBitDepth()){
			return false;
		}
		return m1.getRefreshRate() == DisplayMode.REFRESH_RATE_UNKNOWN || m2.getRefreshRate() == DisplayMode.REFRESH_RATE_UNKNOWN || m1.getRefreshRate() == m2.getRefreshRate();
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
		Window w = graphicsDevice.getFullScreenWindow();
		if(w != null){
			return w.getWidth();
		}else{
			return 0;
		}
	}

	public int getHeight(){
		Window w = graphicsDevice.getFullScreenWindow();
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


}
