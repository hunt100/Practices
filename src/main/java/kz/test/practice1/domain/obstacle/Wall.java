package kz.test.practice1.domain.obstacle;

import kz.test.practice1.domain.enums.ObstacleType;

public class Wall extends Obstacle {

    private final int height;

    public Wall(int height) {
        super(ObstacleType.WALL);
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public int getObstacleSize() {
        return getHeight();
    }
}
