package cz.muni.fi.muni.pv260.a01;

import java.awt.*;
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
    private Color color;
    private KeyBinding keyBinding;



    ArrayList<Integer> pathX = new ArrayList();
    ArrayList<Integer> pathY = new ArrayList();

    public Player(int xPosition, int yPosition, int currentDirection, Color color, KeyBinding keyBinding){
        setxPosition(xPosition);
        setyPosition(yPosition);
        setCurrentDirection(currentDirection);
        setColor(color);
        setKeyBinding(keyBinding);
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

    public void updatePosition(int moveAmount, ScreenManager sm){
        switch(this.currentDirection){
            case 0:
                if (this.yPosition>0){
                    this.yPosition-=moveAmount;
                } else {
                    this.yPosition = sm.getHeight();
                }
                break;
            case 1:
                if (this.xPosition < sm.getWidth()){
                    this.xPosition+=moveAmount;
                } else {
                    this.xPosition = 0;
                }
                break;
            case 2:
                if (this.yPosition < sm.getHeight()){
                    this.yPosition+=moveAmount;
                } else {
                    this.yPosition = 0;
                }
                break;
            case 3:
                if (this.xPosition>0){
                    this.xPosition-=moveAmount;
                } else {
                    this.xPosition = sm.getWidth();
                }
                break;
        }

    }

    public boolean collisionDetected(ArrayList<Player> players) {
        for(Player player:players) {
            for (int i = 0; i < pathX.size(); i++) {
                if ((player.getPathX().get(i) == xPosition) && (player.getPathY().get(i) == yPosition)) {
                    return true;
                }
            }
        }
        return false;
    }


    public void changeDirection(int keyPressed){
        if (keyPressed == this.keyBinding.getUp()) {
            if (this.getCurrentDirection() != 2){
                this.setCurrentDirection(0);
            }
        } else if (keyPressed == this.keyBinding.getDown()) {
            if (this.getCurrentDirection()  != 0){
                this.setCurrentDirection(2);
            }
        } else if (keyPressed == this.keyBinding.getRight()) {
            if (this.getCurrentDirection()  != 3){
                this.setCurrentDirection(1);
            }
        } else if (keyPressed == this.keyBinding.getLeft()) {
            if (this.getCurrentDirection()  != 1){
                this.setCurrentDirection(3);
            }
        }
    }

    public void addCurrentPositionsToPaths() {
        this.addPathX(this.getxPosition());
        this.addPathY(this.getyPosition());
    }

    public void draw(Graphics2D g) {
        g.setColor(getColor());
        for(int i=0;i<this.getPathX().size();i++){
            g.fillRect(this.getPathX().get(i), this.getPathY().get(i), 10, 10);
        }
    }
}
