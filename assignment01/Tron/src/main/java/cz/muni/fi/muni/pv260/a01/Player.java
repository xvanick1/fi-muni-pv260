package cz.muni.fi.muni.pv260.a01;

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
    private KeyBinding keyBinding;
    private PathImpl traveledPath= new PathImpl();

    public Player(int xPosition, int yPosition, Direction currentDirection, Color color, KeyBinding keyBinding){
        actualPosition=new Point(xPosition,yPosition);
        setCurrentDirection(currentDirection);
        setColor(color);
        setKeyBinding(keyBinding);
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
        this.currentDirection = currentDirection;
    }

    public KeyBinding getKeyBinding() {
        return keyBinding;
    }

    public void setKeyBinding(KeyBinding keyBinding) {
        this.keyBinding = keyBinding;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void updatePosition(int moveAmount, ScreenManager screenManager) {
        switch (currentDirection) {
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




    public void changeDirection(int keyPressed){
        if (keyPressed == this.keyBinding.getUp()) {
            if (this.getCurrentDirection() != Direction.UP){
                this.setCurrentDirection(Direction.UP);
            }
        } else if (keyPressed == this.keyBinding.getDown()) {
            if (this.getCurrentDirection()  != Direction.DOWN){
                this.setCurrentDirection(Direction.DOWN);
            }
        } else if (keyPressed == this.keyBinding.getRight()) {
            if (this.getCurrentDirection()  != Direction.RIGHT){
                this.setCurrentDirection(Direction.RIGHT);
            }
        } else if (keyPressed == this.keyBinding.getLeft()) {
            if (this.getCurrentDirection()  != Direction.LEFT){
                this.setCurrentDirection(Direction.LEFT);
            }
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
