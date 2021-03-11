package kz.test;

import kz.test.practice6.Animal;
import kz.test.practice6.Cat;
import kz.test.practice6.Dog;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Cat cat = new Cat("cat", 200);
        Dog dog = new Dog("dog", 500, 10);
        Animal aniCat = new Cat("Meow", 200);
        Animal aniDog = new Dog("Bark", 500, 10);

        cat.run(200);
        aniCat.swim(10);

        dog.run(250);
        aniDog.swim(10);

        System.out.println();
        getAnimalCount(List.of(cat, dog, aniCat, aniDog));
    }

    private static void getAnimalCount(List<Animal> animals) {
        int catCount = 0;
        int dogCount = 0;
        for (Animal a : animals) {
            if (a instanceof Cat) {
                catCount += 1;
            }
            if (a instanceof Dog) {
                dogCount += 1;
            }
        }
        System.out.println("Количество животных: " + animals.size() + "\nКоличество кошек: " + catCount + "\nКоличество собак:" + dogCount);
    }
}
