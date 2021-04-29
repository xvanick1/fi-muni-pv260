package cz.muni.fi.pv260.a01.GameEngine;

import java.util.List;

public interface Path {

    void addPoint(Point point);

    Point getPointOnPosition(int position);

    int size();

    boolean contains(Point point);

    Point getHead();

    List<Point> getLastNPoints(int n);

    List<Point> getAllPoints();
}
