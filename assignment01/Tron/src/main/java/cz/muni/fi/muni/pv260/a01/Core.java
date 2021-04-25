package cz.muni.fi.muni.pv260.a01;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Core {

	private static final DisplayMode modes[] = 
		{
		//new DisplayMode(1920,1080,32,0),
		new DisplayMode(1680,1050,32,0),
		//new DisplayMode(1280,1024,32,0),
		new DisplayMode(800,600,32,0),
		new DisplayMode(800,600,24,0),
		new DisplayMode(800,600,16,0),
		new DisplayMode(640,480,32,0),
		new DisplayMode(640,480,24,0),
		new DisplayMode(640,480,16,0),
		};
	private boolean running;
	protected ScreenManager screenManager;
	
	public void stop(){
		running = false;
	}
	
	public void run(){
		try{
			init();
			gameLoop();
		}finally{
			screenManager.restoreScreen();
		}
	}
	
	public void init(){
		screenManager = new ScreenManager();
		DisplayMode dm = screenManager.findFirstCompatibaleMode(modes);
		screenManager.setFullScreen(dm);
		Window w = screenManager.getFullScreenWindow();
		w.setFont(new Font("Arial",Font.PLAIN,20));
		w.setBackground(Color.WHITE);
		w.setForeground(Color.RED);
		w.setCursor(w.getToolkit().createCustomCursor(new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new java.awt.Point(0, 0),"null"));
		running = true;
	}
	
	public void gameLoop(){
		long startTime = System.currentTimeMillis();
		long cumTime = startTime;
		
		while (running){
			long timePassed = System.currentTimeMillis()-cumTime;
			cumTime+= timePassed;
			update(timePassed);
			Graphics2D g = screenManager.getGraphics();
			draw(g);
			g.dispose();
			screenManager.update();
			
			try{
				Thread.sleep(20);
			}catch(Exception ex){}
		}
	}
	
	public void update(long timePassed){}
	
	public abstract void draw(Graphics2D g);
	
}
