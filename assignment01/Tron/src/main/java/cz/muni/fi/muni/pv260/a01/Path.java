package cz.muni.fi.muni.pv260.a01;


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
