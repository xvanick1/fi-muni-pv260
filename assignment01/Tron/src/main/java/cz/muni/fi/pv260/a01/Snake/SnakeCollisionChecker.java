package cz.muni.fi.pv260.a01.Snake;

import cz.muni.fi.pv260.a01.GameEngine.Point;

public abstract class SnakeCollisionChecker {

    public static void checkForSelfCollision(Point checkedPoint, SnakePlayer snakePlayer) {
        int pathLength = snakePlayer.getPath().size();
        for (int i = 0; i < pathLength; i++) {
            if (i + snakePlayer.getNumberOfVisiblePoints() >= pathLength && snakePlayer.getPath().getPointOnPosition(i).equals(checkedPoint)) {
                System.exit(0);
            }
        }
    }

    public static boolean foodIsEaten(SnakePlayer snakePlayer, Food food, int touch_distance_acceptance) {
        return snakePlayer.getActualPosition().distanceFromPoint(food) < touch_distance_acceptance;
    }
}
