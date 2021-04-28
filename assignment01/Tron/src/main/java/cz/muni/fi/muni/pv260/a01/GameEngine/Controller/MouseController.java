package cz.muni.fi.muni.pv260.a01.GameEngine.Controller;

import cz.muni.fi.muni.pv260.a01.GameEngine.Direction;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static cz.muni.fi.muni.pv260.a01.GameEngine.Direction.*;

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
    public void processEvent(Object e) {

        int keyPressed;
        try {
            keyPressed = ((MouseEvent) e).getButton();
        } catch (ClassCastException exception) {
            return;
        }

        if (keyPressed == LEFTMOUSEBUTTON) {
            if (direction.equals(RIGHT)) {
                direction = UP;
            } else if (direction.equals(UP)) {
                direction = LEFT;
            } else if (direction.equals(LEFT)) {
                direction = DOWN;
            } else if (direction.equals(DOWN)) {
                direction = RIGHT;
            }
        } else if (keyPressed == RIGHTMOUSEBUTTON) {
            if (direction.equals(RIGHT)) {
                direction = DOWN;
            } else if (direction.equals(DOWN)) {
                direction = LEFT;
            } else if (direction.equals(LEFT)) {
                direction = UP;
            } else if (direction.equals(UP)) {
                direction = RIGHT;
            }
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
}
