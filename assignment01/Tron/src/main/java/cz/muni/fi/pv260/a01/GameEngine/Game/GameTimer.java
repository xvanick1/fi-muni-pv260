package cz.muni.fi.pv260.a01.GameEngine.Game;

public class GameTimer {
    private long startTime = System.currentTimeMillis();
    private long cumTime = startTime;

    public void GameTimer(){
        startTime = System.currentTimeMillis();
        cumTime = startTime;
    }
    public void sleepGame(int sleepingTime) {
        try {
            Thread.sleep(sleepingTime);
        } catch (Exception ex) {

        }
    }

    public void measureTime() {
        long timePassed = System.currentTimeMillis() - cumTime;
        cumTime += timePassed;
    }
}
