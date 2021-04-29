package cz.muni.fi.pv260.a01.GameEngine.Controller;

import cz.muni.fi.pv260.a01.GameEngine.Direction;

import static cz.muni.fi.pv260.a01.GameEngine.Direction.*;


public interface InputController {
    Direction getDirection();

    void setDirection(Direction direction);

    void setInitialDirection(Direction direction);


    void processEvent(Object e);


    default void turnRight() {
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

    default void turnLeft() {
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
