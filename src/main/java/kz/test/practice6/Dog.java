package kz.test.practice6;

import kz.test.practice6.utils.Practice6Utils;

public class Dog extends Animal {

    private int maxRunDistance;
    private int maxSwimDistance;

    public Dog(String name, int maxRunDistance, int maxSwimDistance) {
        super(name);
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
    }

    public int getMaxRunDistance() {
        return maxRunDistance;
    }

    public void setMaxRunDistance(int maxRunDistance) {
        this.maxRunDistance = maxRunDistance;
    }

    public int getMaxSwimDistance() {
        return maxSwimDistance;
    }

    public void setMaxSwimDistance(int maxSwimDistance) {
        this.maxSwimDistance = maxSwimDistance;
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

    @Override
    public void swim(int distance) {
        try {
            Practice6Utils.validateValue(this.getClass().getSimpleName(), distance, maxSwimDistance);
            System.out.println(this.getName() + " проплыл " + distance + " м.");
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}
