package kz.test.practice1.domain.obstacle;

import kz.test.practice1.domain.competitor.*;
import kz.test.practice1.domain.enums.CompetitorType;
import kz.test.practice1.domain.enums.ObstacleType;

import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;

public class Course {

    private List<Obstacle> obstacles;
    private final BiFunction<Obstacle, Competitor, Boolean> isCompetitionDone = (obstacle, competitor) -> {
        final ObstacleType obstacleType = obstacle.getObstacleType();
        final CompetitorType competitorType = competitor.getCompetitorType();
        if (obstacleType.equals(ObstacleType.WALL)) {
            switch (competitorType) {
                case CAT:
                    System.out.println(((Cat)competitor).jumpMessage(obstacle.getObstacleSize()));
                    return ((Cat)competitor).jump(obstacle.getObstacleSize());
                case HUMAN:
                    System.out.println(((Human)competitor).jumpMessage(obstacle.getObstacleSize()));
                    return ((Human)competitor).jump(obstacle.getObstacleSize());
                case ROBOT:
                    System.out.println(((Robot)competitor).jumpMessage(obstacle.getObstacleSize()));
                    return ((Robot)competitor).jump(obstacle.getObstacleSize());
            }
        }
        if (obstacleType.equals(ObstacleType.RUNNING_TRACK)) {
            switch (competitorType) {
                case CAT:
                    System.out.println(((Cat)competitor).runMessage(obstacle.getObstacleSize()));
                    return ((Cat)competitor).run(obstacle.getObstacleSize());
                case HUMAN:
                    System.out.println(((Human)competitor).runMessage(obstacle.getObstacleSize()));
                    return ((Human)competitor).run(obstacle.getObstacleSize());
                case ROBOT:
                    System.out.println(((Robot)competitor).runMessage(obstacle.getObstacleSize()));
                    return ((Robot)competitor).run(obstacle.getObstacleSize());
            }
        }
        return false;
    };

    public Course() {
        this.obstacles = Collections.emptyList();
    }

    public Course(List<Obstacle> obstacles) {
        this.obstacles = obstacles;
    }

    public List<Obstacle> getObstacles() {
        return obstacles;
    }

    public void setObstacles(List<Obstacle> obstacles) {
        this.obstacles = obstacles;
    }

    public void doIt(Team team) {
        for (Competitor t : team.getCompetitors()) {
            for (Obstacle o : obstacles) {
                boolean result = isCompetitionDone.apply(o, t);
                if (!result) {
                    break;
                }
            }
        }
    }
}
