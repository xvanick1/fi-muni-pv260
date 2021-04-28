package cz.muni.fi.pv260.a01.Tron;

import cz.muni.fi.muni.pv260.a01.GameEngine.*;
import cz.muni.fi.pv260.a01.GameEngine.*;
import cz.muni.fi.pv260.a01.GameEngine.Point;

import java.awt.*;

public class TronScreenManager implements ScreenManager {
    private static final int PIXEL_SIZE=15;
    ScreenManagerEngine screenManagerEngine = new ScreenManagerEngine();

    public void updateWindow(Game game) {
        if(!(game instanceof TronGame)){
            System.out.println("bad type in TronScreenManager updateWindow method call");
            System.exit(1);
        }
        TronGame tronGame = (TronGame) game;

        Graphics2D graphics2D= screenManagerEngine.getGraphics();
        drawBackground(graphics2D);

        for(Player player : tronGame.getPlayers()){
            drawPlayer(player);
        }
        graphics2D.dispose();
        screenManagerEngine.update();
    }

    private void drawBackground(Graphics2D graphics2D) {
        graphics2D.setColor(Color.BLACK);
        graphics2D.fillRect(0, 0, screenManagerEngine.getWidth(), screenManagerEngine.getHeight());
    }

    private void drawPlayer(Player player) {
        for(Point point : player.getPath().getAllPoints()){
            drawPoint(point, player.getColor());
        }
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
    public DisplayMode findFirstCompatibleMode(DisplayMode[] modes) {
        return screenManagerEngine.findFirstCompatibleMode(modes);
    }

    @Override
    public void restoreScreen() {
        screenManagerEngine.restoreScreen();
    }

    @Override
    public Graphics2D getGraphics() {
        return screenManagerEngine.getGraphics();
    }



    private void drawPoint(Point point, Color color){
        Graphics2D graphics2D= getGraphics();
        graphics2D.setColor(color);
        graphics2D.fillRect(point.getX(), point.getY(), PIXEL_SIZE, PIXEL_SIZE);
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

}
