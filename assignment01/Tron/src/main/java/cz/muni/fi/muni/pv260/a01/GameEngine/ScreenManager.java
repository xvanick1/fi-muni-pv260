package cz.muni.fi.muni.pv260.a01.GameEngine;

import java.awt.*;

public interface ScreenManager {
    void updateWindow(Game game);

    Window getFullScreenWindow();

    void setFullScreen(DisplayMode displayMode);

    DisplayMode findFirstCompatibleMode(DisplayMode[] modes);

    void restoreScreen();

    Graphics2D getGraphics();

    int getWidth();

    int getHeight();

    ScreenMeasurements getMeasurements();
}
