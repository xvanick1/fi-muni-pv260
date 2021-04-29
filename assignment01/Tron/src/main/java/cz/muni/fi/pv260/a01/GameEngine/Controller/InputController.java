package cz.muni.fi.pv260.a01.GameEngine.Controller;

import cz.muni.fi.pv260.a01.GameEngine.Direction;

import static cz.muni.fi.pv260.a01.GameEngine.Direction.*;


public interface InputController {
    Direction getDirection();

    void setDirection(Direction direction);

    void setInitialDirection(Direction direction);


    void processEvent(Object e);


}
