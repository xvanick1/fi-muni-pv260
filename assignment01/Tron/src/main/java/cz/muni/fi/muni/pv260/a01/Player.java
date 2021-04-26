package cz.muni.fi.muni.pv260.a01;

import cz.muni.fi.muni.pv260.a01.Controller.InputController;

import java.awt.*;

/**
 * @author Jozef Vanický
 * @author Michal Zelenák
 * @created 18.04.2021
 * @project assignment01
 **/
public class Player {
    private Point actualPosition;
    private Direction currentDirection;
    private Color color;
    private InputController inputController;
    private PathImpl traveledPath= new PathImpl();

    public Player(int xPosition, int yPosition, Direction currentDirection, Color color, InputController inputController){
        actualPosition=new Point(xPosition,yPosition);

        setColor(color);
        setController(inputController);
        setCurrentDirection(currentDirection);
    }

    public PathImpl getPath() {
        return traveledPath;
    }

    public void addPointToPath(Point point) {
        this.traveledPath.addPoint(point);
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.getController().setInitialDirection(currentDirection);
    }

    public InputController getController() {
        return inputController;
    }

    public void setController(InputController inputController) {
        this.inputController = inputController;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void updatePosition(int moveAmount, ScreenManager screenManager) {
        switch (this.inputController.getDirection()) {
            case UP:
                if (this.actualPosition.getY() > 0) {
                    this.actualPosition.move(this.actualPosition.getX(), this.actualPosition.getY() - moveAmount);
                } else {
                    this.actualPosition.move(this.actualPosition.getX(), screenManager.getHeight());
                }
                break;
            case RIGHT:
                if (this.actualPosition.getX() < screenManager.getWidth()) {
                    this.actualPosition.move(this.actualPosition.getX() + moveAmount, this.actualPosition.getY());
                } else {
                    this.actualPosition.move(0, this.actualPosition.getY());
                }
                break;
            case DOWN:
                if (this.actualPosition.getY() < screenManager.getHeight()) {
                    this.actualPosition.move(this.actualPosition.getX(), this.actualPosition.getY() + moveAmount);
                } else {
                    this.actualPosition.move(this.actualPosition.getX(), 0);
                }
                break;
            case LEFT:
                if (this.actualPosition.getX() > 0) {
                    this.actualPosition.move(this.actualPosition.getX() - moveAmount, this.actualPosition.getY());
                } else {
                    this.actualPosition.move(screenManager.getWidth(), this.actualPosition.getY());
                }
                break;
        }
    }

    public void addCurrentPositionsToPath() {
        this.traveledPath.addPoint(new Point(actualPosition.getX(),actualPosition.getY()));
    }

    public void draw(Graphics2D g) {
        g.setColor(getColor());
        for(int i=0;i<this.traveledPath.size();i++){
            g.fillRect(this.traveledPath.getPointOnPosition(i).getX(), this.traveledPath.getPointOnPosition(i).getY(), 10, 10);
        }
    }

    public Point getCurrentPosition() {
        return actualPosition;
    }
}
