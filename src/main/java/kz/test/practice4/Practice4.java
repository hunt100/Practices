package kz.test.practice4;

import java.util.Random;
import java.util.Scanner;

public final class Practice4 {

    private static final Random RANDOM = new Random(123456789L);
    private static final char EMPTY_SYMBOL = '*';
    private static final char X_SYMBOL = 'X';
    private static final char O_SYMBOL = 'O';
    private static char[][] gameField;
    private static final int GRID_SIZE = 3; //5
    private static final int SCORE_TO_WIN = 3; //4
    private static boolean isXTurn;
    private static int[] scoreArray;

    private Practice4() {
        throw new IllegalStateException("Practice 4 is a util task");
    }

    public static void initializeGame() {
        gameField = new char[GRID_SIZE][GRID_SIZE];
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                gameField[i][j] = EMPTY_SYMBOL;
            }
        }
        isXTurn = true;
        scoreArray = new int[2 * GRID_SIZE + 2];
        printGameField();
    }

    public static void printGameField() {
        for (int i = 0; i <= GRID_SIZE; i++) {
            System.out.print(i + " ");
        }

        System.out.println();

        for (int i = 0; i < GRID_SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < GRID_SIZE; j++) {
                System.out.print(gameField[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void getTurn(Scanner scanner) {
        if (isXTurn) {
            makeUserTurn(scanner);
        } else {
            makeComputerTurn();
        }
    }

    public static boolean canContinue() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (gameField[i][j] == EMPTY_SYMBOL) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void makeUserTurn(Scanner scanner) {
        int xPos;
        int yPos;
        do {
            System.out.println("Выберите 'х' координату для " + X_SYMBOL);
            xPos = scanner.nextInt() - 1;
            System.out.println("Выберите 'y' координату для " + X_SYMBOL);
            yPos = scanner.nextInt() - 1;
        } while (!isValidCell(xPos, yPos));
        gameField[xPos][yPos] = X_SYMBOL;
        addToScoreArray(xPos, yPos);
        isXTurn = false;
    }

    private static void makeComputerTurn() {
        makeDummyComputerTurn();
        isXTurn = true;
    }

    private static void makeDummyComputerTurn() {
        int xPos;
        int yPos;
        do {
            xPos = getRandomNumber(0, GRID_SIZE);
            yPos = getRandomNumber(0, GRID_SIZE);
        } while (!isValidCell(xPos, yPos));
        gameField[xPos][yPos] = O_SYMBOL;
        addToScoreArray(xPos, yPos);
    }

    private static boolean isValidCell(int x, int y) {
        if (x < 0 || x >= GRID_SIZE || y < 0 || y >= GRID_SIZE) {
            return false;
        }

        return gameField[x][y] == EMPTY_SYMBOL;
    }

    public static int getRandomNumber(int min, int max) {
        return (RANDOM.nextInt(max) + min);
    }

    public static int isWinnerFounded() {
        for (int j : scoreArray) {
            if (j == SCORE_TO_WIN) {
                System.out.println("X win");
                return 1;
            } else if (j == -SCORE_TO_WIN) {
                System.out.println("O win");
                return -1;
            }
        }
        return 0;
    }

    private static void addToScoreArray(int i, int j) {
        final int currentPoint = isXTurn ? 1 : -1;
        scoreArray[i] += currentPoint;
        scoreArray[GRID_SIZE + j] += currentPoint;
        if (i == j) {
            scoreArray[2 * GRID_SIZE] += currentPoint;
        }
        if (GRID_SIZE - 1 - j == i) {
            scoreArray[2 * GRID_SIZE + 1] += currentPoint;
        }
    }
}
