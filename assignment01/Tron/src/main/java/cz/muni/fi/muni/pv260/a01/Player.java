package cz.muni.fi.muni.pv260.a01;

import cz.muni.fi.muni.pv260.a01.Controller.InputController;

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
