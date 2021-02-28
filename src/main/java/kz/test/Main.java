package kz.test;

import kz.test.practice3.Practice3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int readyToContinue = 1;
            while (readyToContinue == 1) {
                playNumberGame(scanner);
                System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
                readyToContinue = scanner.nextInt();
            }
            playWordGame(scanner);
        }
    }

    public static void playNumberGame(final Scanner scanner) {
        final int exact = Practice3.getRandomNumber(0, 10);
        for (int i = 2; i >= 0; i--) {
            System.out.println("Пожалуйста, введите Ваше слово:");
            int userGuess = scanner.nextInt();
            boolean isRightAnswer = Practice3.isRightGuess(userGuess, exact);
            if (isRightAnswer) {
                return;
            }
            System.out.println("Осталось попыток: " + i);
        }
        System.out.println("Это было число = " + exact);
    }

    public static void playWordGame(final Scanner scanner) {
        final String exact = Practice3.getRandomWord();
        boolean win = false;
        while (!win) {
            System.out.println("Пожалуйста, введите Ваше значение:");
            String guessWord = scanner.nextLine();
            win = Practice3.isRightGuess(guessWord, exact);
        }
    }
}
