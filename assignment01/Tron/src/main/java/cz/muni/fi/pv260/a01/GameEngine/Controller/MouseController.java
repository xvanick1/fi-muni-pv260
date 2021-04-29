package cz.muni.fi.pv260.a01.GameEngine.Controller;

import cz.muni.fi.pv260.a01.GameEngine.Direction;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static cz.muni.fi.pv260.a01.GameEngine.Direction.*;

public class MouseController implements InputController, MouseListener {

    private Direction direction;
    private int LEFTMOUSEBUTTON = MouseEvent.BUTTON1;
    private int RIGHTMOUSEBUTTON = MouseEvent.BUTTON3;

    public MouseController() {
    }

    @Override
    public Direction getDirection() {
        return direction;
    }

    @Override
    public void setDirection(Direction direction) {
        this.direction=direction;
    }

    @Override
    public void processEvent(Object e) {

        int keyPressed;
        try {
            keyPressed = ((MouseEvent) e).getButton();
        } catch (ClassCastException exception) {
            return;
        }

        if (keyPressed == LEFTMOUSEBUTTON) {
            turnLeft();
        } else if (keyPressed == RIGHTMOUSEBUTTON) {
            turnRight();
        }
    }



    @Override
    public void setInitialDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        processEvent(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    private void turnRight() {
        if (getDirection().equals(RIGHT)) {
            setDirection(DOWN);
        } else if (getDirection().equals(DOWN)) {
            setDirection(LEFT);
        } else if (getDirection().equals(LEFT)) {
            setDirection(UP);
        } else if (getDirection().equals(UP)) {
            setDirection(RIGHT);
        }
    }

    private void turnLeft() {
        if (getDirection().equals(RIGHT)) {
            setDirection(UP);
        } else if (getDirection().equals(UP)) {
            setDirection(LEFT);
        } else if (getDirection().equals(LEFT)) {
            setDirection(DOWN);
        } else if (getDirection().equals(DOWN)) {
            setDirection(RIGHT);
        }
    }
}
