package cz.muni.fi.pv260.a01.GameEngine.Controller;

import java.awt.event.KeyEvent;

public class ControllerBuilder {

    public static KeyController newArrowsController() {
        return new KeyController(KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT);
    }

    public static KeyController newWASDController() {
        return new KeyController(KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D);
    }

    public static MouseController newMouseController() {
        return new MouseController();
    }

}
