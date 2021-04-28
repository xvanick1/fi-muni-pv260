package cz.muni.fi.pv260.a01.Snake;

import cz.muni.fi.pv260.a01.GameEngine.Player;
import cz.muni.fi.pv260.a01.GameEngine.Point;

/**
 * @author Jozef Vanický
 * @created 28.04.2021
 * @project pv260
 **/
public class SnakeGame {
    private Food food;
    private SnakePlayer snakePlayer;

    public Point getFood() {
        return this.food;
    }

    public Player getSnake() {
        return this.snakePlayer;
    }
}
