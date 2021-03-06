package kz.test;

import java.util.Scanner;

import static kz.test.practice4.Practice4.*;

public class Main {

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
        initializeGame();
        runSingleRound(scanner);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Игра окончена");

    }

    public static void runSingleRound(Scanner scanner) {
        while (canContinue()) {
            getTurn(scanner);
            printGameField();
            if (isWinnerFounded()) {
                return;
            }
        }
    }
}
