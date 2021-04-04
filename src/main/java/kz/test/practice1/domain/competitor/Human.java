package kz.test.practice1.domain.competitor;

import kz.test.practice1.domain.enums.CompetitorType;
import kz.test.practice1.service.Jumpable;
import kz.test.practice1.service.Runnable;

public class Human extends Competitor implements Runnable, Jumpable {

    private int runSkill;
    private int jumpSkill;

    public Human(int runSkill, int jumpSkill) {
        super(CompetitorType.HUMAN);
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
        System.out.println("Человек " + getObjectId() + " прыгнул. ");
    }

    @Override
    public boolean jump(int obstacleHeight) {
        return jumpSkill > obstacleHeight;
    }

    @Override
    public void run() {
        System.out.println("Человек " + getObjectId() + " пробежал. ");
    }

    @Override
    public boolean run(int trackDistance) {
        return runSkill > trackDistance;
    }

    public String jumpMessage(int obstacleHeight) {
        return jump(obstacleHeight) ?
                "Человек " + getObjectId() + " перепрыгнул препятствие высотой " + obstacleHeight :
                "Человек " + getObjectId() + " не сумел перепрыгнуть препятствие";
    }

    public String runMessage(int trackDistance) {
        return run(trackDistance) ?
                "Человек " + getObjectId() + " пробежал дистанцию длиной " + trackDistance :
                "Человек " + getObjectId() + " не сумел пробежать дистанцию";
    }

    private String getObjectId() {
        return this.toString().substring(this.toString().indexOf('@') + 1);
    }
}
