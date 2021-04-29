package cz.muni.fi.pv260.a01.GameEngine;

import java.awt.*;
import java.util.ArrayList;

public class GameEngine{
    public ArrayList<Player> players = new ArrayList<>();
    private boolean running;
    private Game game;

    protected static final DisplayMode modes[] =
            {
                    new DisplayMode(1680, 1050, 32, 0),
                    new DisplayMode(800, 600, 32, 0),
                    new DisplayMode(800, 600, 24, 0),
                    new DisplayMode(800, 600, 16, 0),
                    new DisplayMode(640, 480, 32, 0),
                    new DisplayMode(640, 480, 24, 0),
                    new DisplayMode(640, 480, 16, 0),
            };



    public void run() {
        try {
            setRunning(true);
            game.init();
            gameLoop();
        } finally {
            game.restoreScreen();
        }
    }

    public void setRunning(boolean running) {
        this.running=running;
    }

    public boolean getRunning() {
        return running;
    }

    public static DisplayMode[] getModes() {
        return modes;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }


    public void gameLoop() {
        GameTimer gameTimer = new GameTimer();

        while (getRunning()) {
            gameTimer.measureTime();
            game.updateGame();
            game.updateScreen();
            gameTimer.sleepGame(20);
        }
    }

    public void newGame(Game game) {
        this.game=game;
        run();
    }
}
