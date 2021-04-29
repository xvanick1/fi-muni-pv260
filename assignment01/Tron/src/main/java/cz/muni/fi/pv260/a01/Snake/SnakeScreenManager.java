package cz.muni.fi.pv260.a01.Snake;

import cz.muni.fi.pv260.a01.GameEngine.Game.Game;
import cz.muni.fi.pv260.a01.GameEngine.ScreenManagement.ScreenManagerEngine;
import cz.muni.fi.pv260.a01.GameEngine.Point;
import cz.muni.fi.pv260.a01.GameEngine.ScreenManagement.ScreenManager;
import cz.muni.fi.pv260.a01.GameEngine.ScreenManagement.ScreenMeasurements;

import java.awt.*;

public class SnakeScreenManager implements ScreenManager {
    private static final int PIXEL_SIZE=15;
    ScreenManagerEngine screenManagerEngine = new ScreenManagerEngine();

    @Override
    public void updateWindow(Game game){
        if(!(game instanceof SnakeGame)){
            System.out.println("bad type in SnakeScreenManager updateWindow method call");
            System.exit(1);
        }
        SnakeGame snakeGame=(SnakeGame) game;
        Graphics2D graphics2D= screenManagerEngine.getGraphics();
        drawBackground();
        drawSnake(snakeGame);
        drawFood(snakeGame);
        graphics2D.dispose();
        screenManagerEngine.update();
    }

    private void drawBackground() {
        drawRectangle(0, 0, screenManagerEngine.getWidth(), screenManagerEngine.getHeight(),Color.BLACK);
    }

    private void drawRectangle(int startX, int startY, int sizeX, int sizeY, Color color) {
        Graphics2D graphics2D= screenManagerEngine.getGraphics();
        graphics2D.setColor(color);
        graphics2D.fillRect(startX, startY, sizeX, sizeY);
    }

    private void drawFood(SnakeGame snakeGame) {
        drawRectangle( snakeGame.getFood().getX(), snakeGame.getFood().getY(), PIXEL_SIZE, PIXEL_SIZE,snakeGame.getFood().getColor());
    }

    private void drawSnake(SnakeGame snakeGame) {
        Color snakeColor = snakeGame.getSnake().getColor();
        int snakeLength=snakeGame.getSnake().getNumberOfVisiblePoints();
        snakeGame.getSnake().getPath().getLastNPoints(snakeLength).forEach(point -> drawSnakePoint(point,snakeColor));
    }

    private void drawSnakePoint(Point point, Color color){
        drawRectangle(point.getX(), point.getY(), PIXEL_SIZE, PIXEL_SIZE,color);
    }

    @Override
    public Window getFullScreenWindow() {
        return screenManagerEngine.getFullScreenWindow();
    }

    @Override
    public void setFullScreen(DisplayMode displayMode) {
        screenManagerEngine.setFullScreen(displayMode);
    }

    @Override
    public DisplayMode findFirstCompatibleMode(DisplayMode[] modes) { return screenManagerEngine.findFirstCompatibleMode(modes); }

    @Override
    public void restoreScreen() {
        screenManagerEngine.restoreScreen();
    }

    @Override
    public Graphics2D getGraphics() {
        return screenManagerEngine.getGraphics();
    }

    @Override
    public int getWidth() {
        return screenManagerEngine.getWidth();
    }

    @Override
    public int getHeight() {
        return screenManagerEngine.getHeight();
    }

    @Override
    public ScreenMeasurements getMeasurements() {
        return new ScreenMeasurements(this.getHeight(),this.getWidth());
    }

    @Override
    public Window initializeGameGraphics(ScreenManager screenManager) {
        return screenManagerEngine.initializeGameGraphics(screenManager);
    }
}
