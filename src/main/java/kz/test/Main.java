package kz.test;

import kz.test.practice1.domain.competitor.*;
import kz.test.practice1.domain.obstacle.Course;
import kz.test.practice1.domain.obstacle.Obstacle;
import kz.test.practice1.domain.obstacle.RunningTrack;
import kz.test.practice1.domain.obstacle.Wall;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Cat cat = new Cat(200, 180);
        Human human = new Human(100, 100);
        Robot robot = new Robot(1000, 1000);

        cat.run();
        human.jump();
        robot.run();
        robot.jump();

        Obstacle obstacleA = new Wall(120);
        Obstacle obstacleB = new RunningTrack(500);

        System.out.println(cat.jumpMessage(obstacleA.getObstacleSize()));

        List<Competitor> competitors = List.of(cat, human, robot);
        Team team = new Team(competitors);

        List<Obstacle> obstacles = List.of(obstacleA, obstacleB);
        Course course = new Course(obstacles);

        System.out.println("---------------------------------------------------------");
        course.doIt(team);
        System.out.println("---------------------------------------------------------");

    }
}
