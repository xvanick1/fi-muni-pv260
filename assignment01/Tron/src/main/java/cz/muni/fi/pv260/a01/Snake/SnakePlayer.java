package cz.muni.fi.pv260.a01.Snake;
import cz.muni.fi.pv260.a01.GameEngine.PlayerImpl;
import cz.muni.fi.pv260.a01.GameEngine.Point;

import java.util.List;

public class SnakePlayer extends PlayerImpl {
    private SnakePath traveledPath;
    public SnakePlayer() {
        this.traveledPath = new SnakePath();
    }

    public SnakePath getPath() {
        return traveledPath;
    }

    @Override
    public void addCurrentPositionToPath() {
        this.traveledPath.addPoint(new Point(actualPosition.getX(), actualPosition.getY()));
    }

    @Override
    public void setInitialPosition(int xPosition, int yPosition) {
        Point newPosition = new Point(xPosition,yPosition);
        actualPosition = newPosition;
        this.traveledPath.addPoint(new Point(xPosition, yPosition));
    }

    public void setPath(List<Point> newPath) {
        traveledPath = new SnakePath();
        for (Point point : newPath) {
            traveledPath.addPoint(point);
        }
    }

}
