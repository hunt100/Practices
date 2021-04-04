package kz.test.practice1.domain.obstacle;

import kz.test.practice1.domain.enums.ObstacleType;

public abstract class Obstacle {

    private final ObstacleType obstacleType;

    public Obstacle(ObstacleType obstacleType) {
        this.obstacleType = obstacleType;
    }

    public ObstacleType getObstacleType() {
        return obstacleType;
    }

    public abstract int getObstacleSize();
}
