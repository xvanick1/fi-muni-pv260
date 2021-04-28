package cz.muni.fi.pv260.a01.Snake;

import cz.muni.fi.pv260.a01.GameEngine.Point;

import java.awt.*;
import java.util.Random;

public class Food extends Point {
    private final int DISTANCE_FROM_EDGE=5;

    public Food(int x, int y){
        super(x,y);
    }

    public Food(Window window, SnakePath existingPoints) {
        super(0,0);
        Random randGenerator = new Random();
        Food pointForEating;
        do {
            pointForEating = new Food(randGenerator.nextInt(window.getWidth()-DISTANCE_FROM_EDGE), randGenerator.nextInt(window.getHeight()-DISTANCE_FROM_EDGE));
        } while (existingPoints.contains(pointForEating));
        setX(pointForEating.getX());
        setY(pointForEating.getY());
    }
}
