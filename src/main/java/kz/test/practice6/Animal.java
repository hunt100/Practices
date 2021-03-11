package kz.test.practice6;

import kz.test.practice6.utils.Practice6Utils;

public abstract class Animal {

    private String name;

    protected Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void run(int distance) {
        if (Practice6Utils.isPositive(distance)) {
            System.out.println(this.getName() + " пробежал " + distance + " м.");
        }
    }

    public void swim(int distance) {
        System.out.println(name + " не умеет плавать. А так хотелось :(");
    }

}
