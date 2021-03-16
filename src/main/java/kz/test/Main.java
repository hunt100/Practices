package kz.test;

import kz.test.practice7.Cat;
import kz.test.practice7.Plate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    private static final Random RANDOM = new Random();
    private static final int MAX_SIZE = 10;

    public static void main(String[] args) {
        Plate plate = new Plate(30);
        plate.info();

        List<Cat> cats = new ArrayList<>();
        for (int i = 0; i < MAX_SIZE; i++) {
            cats.add(new Cat(getRandomString(), getRandomInt()));
            cats.get(i).eat(plate);
            plate.info();
            if (plate.getFood() == 0) {
                int increaseFood = 5;
                plate.fillPlate(increaseFood);
                System.out.println("Заполнили еду на " + increaseFood);
            }
        }

        System.out.println();

        for (Cat cat : cats) {
            cat.getHungryStatus();
        }

    }

    private static String getRandomString() {
        final int leftLimit = 97;
        final int rightLimit = 122;
        final int targetStringLength = 7;
        return RANDOM.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    private static int getRandomInt() {
        return RANDOM.nextInt(MAX_SIZE) + 1;
    }
}
