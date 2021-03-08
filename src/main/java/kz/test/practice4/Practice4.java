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
    private static boolean isXTurn;
    private static int[] scoreArray;
    private static final int MAX_DEPTH = 6;

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
//        makeDummyComputerTurn();
        makeBestMove();
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
        return isWinnerFounded(scoreArray);
    }

    public static int isWinnerFounded(int[] scoreArray) {
        for (int j : scoreArray) {
            if (j == GRID_SIZE) {
                return 1;
            } else if (j == -GRID_SIZE) {
                return -1;
            }
        }
        return 0;
    }

    private static void addToScoreArray(int i, int j) {
        addToScoreArray(scoreArray, i, j, isXTurn);
    }

    private static void addToScoreArray(int[] scoreArray, int i, int j, boolean isXTurn) {
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

    private static void makeBestMove() {
        int bestValue = Integer.MAX_VALUE;
        int xPos = -1;
        int yPos = -1;
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (isValidCell(i, j)) {
                    gameField[i][j] = O_SYMBOL;
                    int currentValue = miniMax(gameField, MAX_DEPTH - 1, true);
                    gameField[i][j] = EMPTY_SYMBOL;
                    if (currentValue < bestValue) {
                        bestValue = currentValue;
                        xPos = i;
                        yPos = j;
                    }
                }
            }
        }
        gameField[xPos][yPos] = O_SYMBOL;
        addToScoreArray(xPos, yPos);
    }

    private static int miniMax(char[][] gameCopy, int maxDepth, boolean isMax) {
        int score = evaluateGameField(gameCopy);

        if (Math.abs(score) == 1 || !canContinue() || maxDepth == 0) {
            return score;
        }

        int best;
        if (isMax) {
            best = Integer.MIN_VALUE;
            for (int i = 0; i < GRID_SIZE; i++) {
                for (int j = 0; j < GRID_SIZE; j++) {
                    if (isValidCell(i, j)) {
                        gameCopy[i][j] = X_SYMBOL;
                        best = Math.max(best, miniMax(gameCopy, maxDepth - 1, false));
                        gameCopy[i][j] = EMPTY_SYMBOL;
                    }
                }
            }
        }
        else {
            best = Integer.MAX_VALUE;
            for (int i = 0; i < GRID_SIZE; i++) {
                for (int j = 0; j < GRID_SIZE; j++) {
                    if (isValidCell(i, j)) {
                        gameCopy[i][j] = O_SYMBOL;
                        best = Math.min(best, miniMax(gameCopy, maxDepth - 1, true));
                        gameCopy[i][j] = EMPTY_SYMBOL;
                    }
                }
            }
        }
        return best;
    }

    private static int evaluateGameField(char[][] gameField) {
        int[] scoreCopy = new int[scoreArray.length];
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (gameField[i][j] == X_SYMBOL) {
                    addToScoreArray(scoreCopy, i, j, true);
                }
                if (gameField[i][j] == O_SYMBOL) {
                    addToScoreArray(scoreCopy, i, j, false);
                }
            }
        }
        return isWinnerFounded(scoreCopy);
    }
}
