package cz.muni.fi.muni.pv260.a01.GameEngine.Controller;

import cz.muni.fi.muni.pv260.a01.GameEngine.Direction;

public interface InputController {
    Direction getDirection();

    void setInitialDirection(Direction direction);

    void processEvent(Object e);
}
