package cz.muni.fi.pv260.a01.GameEngine;

import cz.muni.fi.pv260.a01.GameEngine.Controller.InputController;
import cz.muni.fi.pv260.a01.GameEngine.ScreenManagement.ScreenManager;

import java.awt.*;

public interface Game {

    void init();

    void updateGame();

    void createPlayer(int xPosition, int yPosition, Direction direction, Color color, InputController inputController);

    void restoreScreen();

    Graphics2D getGraphics();

    void updateScreen();

    ScreenManager getScreenManager();
}
