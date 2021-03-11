package kz.test.practice6;

import kz.test.practice6.utils.Practice6Utils;

public class Cat extends Animal {

    private int maxRunDistance;

    public Cat(String name, int maxRunDistance) {
        super(name);
        this.maxRunDistance = maxRunDistance;
    }

    public int getMaxRunDistance() {
        return maxRunDistance;
    }

    public void setMaxRunDistance(int maxRunDistance) {
        this.maxRunDistance = maxRunDistance;
    }

    @Override
    public void run(int distance) {
        try {
            Practice6Utils.validateValue(this.getClass().getSimpleName(), distance, maxRunDistance);
            System.out.println(this.getName() + " пробежал " + distance + " м.");
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}
