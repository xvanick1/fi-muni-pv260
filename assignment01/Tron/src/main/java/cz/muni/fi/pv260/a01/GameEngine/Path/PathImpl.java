package cz.muni.fi.pv260.a01.GameEngine.Path;

import cz.muni.fi.pv260.a01.GameEngine.Point;

import java.util.ArrayList;
import java.util.List;

public class PathImpl implements Path {
    protected ArrayList<Point> traveledPoints = new ArrayList<>();

    @Override
    public void addPoint(Point point) {
        traveledPoints.add(point);
    }

    @Override
    public Point getPointOnPosition(int position) {
        return traveledPoints.get(position);
    }


    @Override
    public int size() {
        return traveledPoints.size();
    }

    @Override
    public boolean contains(Point point) {
        return traveledPoints.contains(point);
    }

    @Override
    public Point getHead() {
        return traveledPoints.get(traveledPoints.size() - 1);
    }

    @Override
    public List<Point> getLastNPoints(int n) {
        while(traveledPoints.size()-n<0){
            n+=1;
        }
        return traveledPoints.subList(traveledPoints.size() - n, traveledPoints.size());
    }

    @Override
    public List<Point> getAllPoints(){
        return traveledPoints;
    }

}
