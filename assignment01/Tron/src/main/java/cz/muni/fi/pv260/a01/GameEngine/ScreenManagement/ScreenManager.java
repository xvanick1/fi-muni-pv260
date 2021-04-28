package cz.muni.fi.pv260.a01.GameEngine.ScreenManagement;

import cz.muni.fi.pv260.a01.GameEngine.Game;

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
