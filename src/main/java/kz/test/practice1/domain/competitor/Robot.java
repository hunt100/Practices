package kz.test.practice1.domain.competitor;

import kz.test.practice1.domain.enums.CompetitorType;
import kz.test.practice1.service.Jumpable;
import kz.test.practice1.service.Runnable;

public class Robot extends Competitor implements Runnable, Jumpable {

    private int runSkill;
    private int jumpSkill;

    public Robot(int runSkill, int jumpSkill) {
        super(CompetitorType.ROBOT);
        this.runSkill = runSkill;
        this.jumpSkill = jumpSkill;
    }

    public int getRunSkill() {
        return runSkill;
    }

    public void setRunSkill(int runSkill) {
        this.runSkill = runSkill;
    }

    public int getJumpSkill() {
        return jumpSkill;
    }

    public void setJumpSkill(int jumpSkill) {
        this.jumpSkill = jumpSkill;
    }

    @Override
    public void jump() {
        System.out.println("Робот " + getObjectId() + " прыгнул. ");
    }

    @Override
    public boolean jump(int obstacleHeight) {
        return jumpSkill > obstacleHeight;
    }

    @Override
    public void run() {
        System.out.println("Робот " + getObjectId() + " пробежал. ");
    }

    @Override
    public boolean run(int trackDistance) {
        return runSkill > trackDistance;
    }

    public String jumpMessage(int obstacleHeight) {
        return jump(obstacleHeight) ?
                "Робот " + getObjectId() + " перепрыгнул препятствие высотой " + obstacleHeight :
                "Робот " + getObjectId() + " не сумел перепрыгнуть препятствие";
    }

    public String runMessage(int trackDistance) {
        return run(trackDistance) ?
                "Робот " + getObjectId() + " пробежал дистанцию длиной " + trackDistance :
                "Робот " + getObjectId() + " не сумел пробежать дистанцию";
    }

    private String getObjectId() {
        return this.toString().substring(this.toString().indexOf('@') + 1);
    }
}
