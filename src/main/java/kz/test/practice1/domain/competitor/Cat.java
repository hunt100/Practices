package kz.test.practice1.domain.competitor;

import kz.test.practice1.domain.enums.CompetitorType;
import kz.test.practice1.service.Jumpable;
import kz.test.practice1.service.Runnable;

public class Cat extends Competitor implements Runnable, Jumpable {

    private int runSkill;
    private int jumpSkill;

    public Cat(int runSkill, int jumpSkill) {
        super(CompetitorType.CAT);
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
        System.out.println("Кошка " + getObjectId() + " прыгнула. ");
    }

    @Override
    public boolean jump(int obstacleHeight) {
        return jumpSkill > obstacleHeight;
    }

    @Override
    public void run() {
        System.out.println("Кошка " + getObjectId() + " побежала. ");
    }

    @Override
    public boolean run(int trackDistance) {
        return runSkill > trackDistance;
    }

    public String jumpMessage(int obstacleHeight) {
        return jump(obstacleHeight) ?
                "Кошка " + getObjectId() + " перепрыгнула препятствие высотой " + obstacleHeight :
                "Кошка " + getObjectId() + " не сумела перепрыгнуть препятствие";
    }

    public String runMessage(int trackDistance) {
        return run(trackDistance) ?
                "Кошка " + getObjectId() + " пробежала дистанцию длиной " + trackDistance :
                "Кошка " + getObjectId() + " не сумела пробежать дистанцию";
    }

    private String getObjectId() {
        return this.toString().substring(this.toString().indexOf('@') + 1);
    }
}
