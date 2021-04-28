package cz.muni.fi.pv260.a01.GameEngine.ScreenManagement;

import java.awt.*;

public class DisplayModesManager {
    private GraphicsDevice graphicsDevice;

    public DisplayModesManager(){
        GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
        graphicsDevice = e.getDefaultScreenDevice();
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

    public DisplayMode[] getCompatibleDisplayModes(){
        return graphicsDevice.getDisplayModes();
    }

    public DisplayMode getCurrentDM(){
        return graphicsDevice.getDisplayMode();
    }


}
