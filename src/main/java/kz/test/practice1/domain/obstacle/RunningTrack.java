package kz.test.practice1.domain.obstacle;

import kz.test.practice1.domain.enums.ObstacleType;

public class RunningTrack extends Obstacle {

    private final int trackDistance;

    public RunningTrack(int trackDistance) {
        super(ObstacleType.RUNNING_TRACK);
        this.trackDistance = trackDistance;
    }

    public int getTrackDistance() {
        return trackDistance;
    }

    @Override
    public int getObstacleSize() {
        return getTrackDistance();
    }
}
