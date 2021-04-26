package cz.muni.fi.muni.pv260.a01;

import cz.muni.fi.muni.pv260.a01.Controller.InputController;
import cz.muni.fi.muni.pv260.a01.Controller.InputController;

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
