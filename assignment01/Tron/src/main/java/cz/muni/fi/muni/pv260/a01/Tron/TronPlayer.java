package cz.muni.fi.muni.pv260.a01.Tron;

import cz.muni.fi.muni.pv260.a01.*;
import cz.muni.fi.muni.pv260.a01.Point;

import java.awt.*;

public class TronPlayer extends PlayerImpl {
    private PathImpl traveledPath;


    public TronPlayer() {
        this.traveledPath = new PathImpl();
    }



    @Override
    public void addCurrentPositionToPath() {
        this.traveledPath.addPoint(new Point(getActualPosition().getX(), getActualPosition().getY()));
        super.setNumberOfVisiblePoints(super.getNumberOfVisiblePoints()+1);
    }

    @Override
    public PathImpl getPath() {
        return traveledPath;
    }

    public void draw(Graphics2D graphics2D){
        for(Point point : this.getPath().getAllPoints()){
            drawPoint(point, this.getColor(), graphics2D);
        }
    }

    private void drawPoint(Point point, Color color, Graphics2D graphics2D){
        graphics2D.setColor(color);
        graphics2D.fillRect(point.getX(), point.getY(), 10, 10);
    }
}
