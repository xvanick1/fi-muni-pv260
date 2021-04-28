package cz.muni.fi.muni.pv260.a01.GameEngine;

import java.awt.*;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Point {
    protected int x;
    protected int y;
    protected Color color;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return getX() == point.getX() && getY() == point.getY();
    }

    public void move(int x, int y) {
        setX(x);
        setY(y);
    }

    public double distanceFromPoint(Point point) {
        return sqrt(pow(point.getX() - this.getX(), 2) + pow(point.getY() - this.getY(), 2));
    }
}
