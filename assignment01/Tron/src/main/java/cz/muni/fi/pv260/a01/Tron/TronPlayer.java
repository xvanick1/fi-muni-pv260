package cz.muni.fi.pv260.a01.Tron;

import cz.muni.fi.pv260.a01.GameEngine.PlayerImpl;
import cz.muni.fi.pv260.a01.GameEngine.Point;

public class TronPlayer extends PlayerImpl {
    private TronPath traveledPath;

    public TronPlayer() {
        this.traveledPath = new TronPath();
    }

    @Override
    public void addCurrentPositionToPath() {
        this.traveledPath.addPoint(new Point(getActualPosition().getX(), getActualPosition().getY()));
        super.setNumberOfVisiblePoints(super.getNumberOfVisiblePoints()+1);
    }

    @Override
    public TronPath getPath() {
        return traveledPath;
    }


}
