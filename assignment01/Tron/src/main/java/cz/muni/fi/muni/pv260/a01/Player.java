package cz.muni.fi.muni.pv260.a01;

import java.util.ArrayList;

/**
 * @author Jozef Vanický
 * @author Michal Zelenák
 * @created 18.04.2021
 * @project assignment01
 **/
public class Player {
    private int xPosition;
    private int yPosition;
    private int currentDirection;

    ArrayList<Integer> pathX = new ArrayList();
    ArrayList<Integer> pathY = new ArrayList();

    public Player(int xPosition, int yPosition, int currentDirection){
        setxPosition(xPosition);
        setyPosition(yPosition);
        setCurrentDirection(currentDirection);
    }
    public ArrayList<Integer> getPathX() {
        return pathX;
    }

    public ArrayList<Integer> getPathY() {
        return pathY;
    }


    public void addPathX(Integer pathX) {
        this.pathX.add(pathX);
    }

    public void addPathY(Integer pathY) {
        this.pathY.add(pathY);
    }



    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public int getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(int currentDirection) {
        this.currentDirection = currentDirection;
    }
}
