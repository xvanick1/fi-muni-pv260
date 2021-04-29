package cz.muni.fi.pv260.a01.GameEngine.Player;

import cz.muni.fi.pv260.a01.GameEngine.Controller.InputController;
import cz.muni.fi.pv260.a01.GameEngine.Direction;
import cz.muni.fi.pv260.a01.GameEngine.Point;
import cz.muni.fi.pv260.a01.GameEngine.ScreenManagement.ScreenMeasurements;

import java.awt.*;

/**
 * @author Jozef Vanický
 * @author Michal Zelenák
 * @created 18.04.2021
 * @project assignment01
 **/
public abstract class PlayerImpl implements Player{
    protected cz.muni.fi.pv260.a01.GameEngine.Point actualPosition;
    protected Color color;
    protected InputController controller;
    protected int numberOfVisiblePoints = 1;



    @Override
    public cz.muni.fi.pv260.a01.GameEngine.Point getActualPosition() {
        return actualPosition;
    }

    @Override
    public void makeMovement(int moveAmount, ScreenMeasurements screenMeasurements) {
        switch (this.controller.getDirection()) {
            case UP:
                if (this.actualPosition.getY() > 0) {
                    this.actualPosition.move(this.actualPosition.getX(), this.actualPosition.getY() - moveAmount);
                } else {
                    this.actualPosition.move(this.actualPosition.getX(), screenMeasurements.getHeight());
                }
                break;
            case RIGHT:
                if (this.actualPosition.getX() < screenMeasurements.getWidth()) {
                    this.actualPosition.move(this.actualPosition.getX() + moveAmount, this.actualPosition.getY());
                } else {
                    this.actualPosition.move(0, this.actualPosition.getY());
                }
                break;
            case DOWN:
                if (this.actualPosition.getY() < screenMeasurements.getHeight()) {
                    this.actualPosition.move(this.actualPosition.getX(), this.actualPosition.getY() + moveAmount);
                } else {
                    this.actualPosition.move(this.actualPosition.getX(), 0);
                }
                break;
            case LEFT:
                if (this.actualPosition.getX() > 0) {
                    this.actualPosition.move(this.actualPosition.getX() - moveAmount, this.actualPosition.getY());
                } else {
                    this.actualPosition.move(screenMeasurements.getWidth(), this.actualPosition.getY());
                }
                break;
        }
    }


    @Override
    public abstract void addCurrentPositionToPath();

    @Override
    public void setInitialPosition(int xPosition, int yPosition) {
        actualPosition = new Point(xPosition,yPosition);
    }

    @Override
    public void setInitialDirection(Direction direction) {
        this.controller.setInitialDirection(direction);
    }

    @Override
    public void setNumberOfVisiblePoints(int numberOfVisiblePoints) {
        this.numberOfVisiblePoints = numberOfVisiblePoints;
    }

    @Override
    public int getNumberOfVisiblePoints() {
        return numberOfVisiblePoints;
    }

    @Override
    public InputController getController() {
        return this.controller;
    }
    @Override
    public void setController(InputController inputController) {
        this.controller = inputController;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }
}
