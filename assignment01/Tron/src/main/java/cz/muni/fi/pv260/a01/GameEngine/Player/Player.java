package cz.muni.fi.pv260.a01.GameEngine.Player;

import cz.muni.fi.pv260.a01.GameEngine.Controller.InputController;
import cz.muni.fi.pv260.a01.GameEngine.Direction;
import cz.muni.fi.pv260.a01.GameEngine.Path.Path;
import cz.muni.fi.pv260.a01.GameEngine.Point;
import cz.muni.fi.pv260.a01.GameEngine.ScreenManagement.ScreenMeasurements;

import java.awt.*;

public interface Player {

    void setNumberOfVisiblePoints(int numberOfVisiblePoints);
    Point getActualPosition();
    Path getPath();
    void setController(InputController inputController);
    Color getColor();
    void setColor(Color color);
    void makeMovement(int moveAmount, ScreenMeasurements screenMeasurements);
    void addCurrentPositionToPath();
    void setInitialPosition(int xPosition, int yPosition);
    void setInitialDirection(Direction direction);
    int getNumberOfVisiblePoints();
    InputController getController();
}
