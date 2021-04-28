package cz.muni.fi.pv260.a01.GameEngine.ScreenManagement;

import java.awt.*;
import java.awt.image.BufferedImage;

public class CompatibleImageBuilder {
    public BufferedImage createCompatibleImage(int w, int h, int t){
        GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice graphicsDevice = e.getDefaultScreenDevice();
        Window win = graphicsDevice.getFullScreenWindow();
        if(win != null){
            GraphicsConfiguration gc = win.getGraphicsConfiguration();
            return gc.createCompatibleImage(w,h,t);
        }else{
            return null;
        }
    }
}
