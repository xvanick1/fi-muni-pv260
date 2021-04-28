package cz.muni.fi.muni.pv260.a01.GameEngine.Controller;

import cz.muni.fi.muni.pv260.a01.GameEngine.Direction;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static cz.muni.fi.muni.pv260.a01.GameEngine.Direction.*;

public class KeyController implements InputController, KeyListener {
    private final int up;
    private final int down;
    private final int left;
    private final int right;
    private Direction direction;

    public KeyController(int up, int down, int left, int right) {
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
    }

    @Override
    public Direction getDirection() {
        return direction;
    }

    @Override
    public void processEvent(Object e) {

        int keyPressed;

        try {
            keyPressed = ((KeyEvent) e).getKeyCode();
        } catch (ClassCastException exception) {
            return;
        }

        if (keyPressed == this.up) {
            if (direction != DOWN) {
                direction = UP;
            }
        } else if (keyPressed == this.down) {
            if (direction != UP) {
                direction = DOWN;
            }
        } else if (keyPressed == this.right) {
            if (direction != LEFT) {
                direction = RIGHT;
            }
        } else if (keyPressed == this.left) {
            if (direction != RIGHT) {
                direction = LEFT;
            }
        }
    }

    @Override
    public void setInitialDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        processEvent(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
