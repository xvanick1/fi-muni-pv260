package cz.muni.fi.muni.pv260.a01.Controller;

public interface InputController {
    Direction getDirection();

    void setInitialDirection(Direction direction);

    void processEvent(Object e);
}
