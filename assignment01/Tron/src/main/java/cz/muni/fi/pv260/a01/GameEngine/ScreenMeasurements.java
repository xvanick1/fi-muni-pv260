package cz.muni.fi.pv260.a01.GameEngine;

public class ScreenMeasurements {
    private int Height;
    private int Width;

    public ScreenMeasurements(int height, int width) {
        Height = height;
        Width = width;
    }

    public int getHeight() {
        return Height;
    }

    public void setHeight(int height) {
        Height = height;
    }

    public int getWidth() {
        return Width;
    }

    public void setWidth(int width) {
        Width = width;
    }
}
