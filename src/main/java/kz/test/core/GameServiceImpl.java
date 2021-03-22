package kz.test.core;

import kz.test.domain.DotCoordinate;
import kz.test.enums.DotType;

import java.util.Random;

public final class GameServiceImpl implements GameService {

    private final Random RANDOM = new Random();

    private DotType[][] gameField;
    private DotType playerSign;
    private DotType computerSign;
    private int gridSize;

    private int[] scoreArray;
    private final int MAX_DEPTH = 4;

    public GameServiceImpl(DotType playerSign, int gridSize) {
        this.playerSign = playerSign;
        this.computerSign = DotType.getEnemySign(playerSign);
        this.gridSize = gridSize;
        initializeGame();
    }

    public void initializeGame() {
        gameField = new DotType[gridSize][gridSize];
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                gameField[i][j] = DotType.EMPTY;
            }
        }
        scoreArray = new int[2 * gridSize + 2];
        printGameField();
    }

    public void printGameField() {
        for (int i = 0; i <= gridSize; i++) {
            System.out.print(i + " ");
        }

        System.out.println();

        for (int i = 0; i < gridSize; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < gridSize; j++) {
                System.out.print(gameField[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean canContinue() {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (gameField[i][j] == DotType.EMPTY) {
                    return true;
                }
            }
        }
        return false;
    }

    public void userTurn(int row, int col) {
        gameField[row][col] = playerSign;
        addToScoreArray(row, col, playerSign);
        printGameField();
    }



    public DotCoordinate computerTurn() {
        DotCoordinate dotCoordinate = makeBestMove();
//        DotCoordinate dotCoordinate = makeDummyComputerTurn();
        printGameField();
        return dotCoordinate;
    }

    private DotCoordinate makeDummyComputerTurn() {
        int xPos;
        int yPos;
        do {
            xPos = getRandomNumber(0, gridSize);
            yPos = getRandomNumber(0, gridSize);
        } while (!isValidCell(xPos, yPos));
        gameField[xPos][yPos] = computerSign;
        addToScoreArray(xPos, yPos, computerSign);
        return new DotCoordinate(xPos, yPos);
    }

    private boolean isValidCell(int x, int y) {
        if (x < 0 || x >= gridSize || y < 0 || y >= gridSize) {
            return false;
        }

        return gameField[x][y] == DotType.EMPTY;
    }

    public int getRandomNumber(int min, int max) {
        return (RANDOM.nextInt(max) + min);
    }

    public int isWinnerFounded() {
        return isWinnerFounded(scoreArray);
    }

    public int isWinnerFounded(int[] scoreArray) {
        for (int j : scoreArray) {
            if (j == gridSize) {
                return 1;
            } else if (j == -gridSize) {
                return -1;
            }
        }
        return 0;
    }

    private void addToScoreArray(int i, int j, DotType dotType) {
        addToScoreArray(scoreArray, i, j, dotType);
    }

    private void addToScoreArray(int[] scoreArray, int i, int j, DotType dotType) {
        final int currentPoint = DotType.getNumberTypeBySign(dotType);
        scoreArray[i] += currentPoint;
        scoreArray[gridSize + j] += currentPoint;
        if (i == j) {
            scoreArray[2 * gridSize] += currentPoint;
        }
        if (gridSize - 1 - j == i) {
            scoreArray[2 * gridSize + 1] += currentPoint;
        }
    }

    private DotCoordinate makeBestMove() {
        int bestValue = Integer.MAX_VALUE;
        int xPos = -1;
        int yPos = -1;
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (isValidCell(i, j)) {
                    gameField[i][j] = computerSign;
                    int currentValue = miniMax(gameField, MAX_DEPTH - 1, true);
                    gameField[i][j] = DotType.EMPTY;
                    if (currentValue < bestValue) {
                        bestValue = currentValue;
                        xPos = i;
                        yPos = j;
                    }
                }
            }
        }
        gameField[xPos][yPos] = computerSign;
        addToScoreArray(xPos, yPos, computerSign);
        return new DotCoordinate(xPos, yPos);
    }

    private int miniMax(DotType[][] gameCopy, int maxDepth, boolean isMax) {
        int score = evaluateGameField(gameCopy);

        if (Math.abs(score) == 1 || !canContinue() || maxDepth == 0) {
            return score;
        }

        int best;
        if (isMax) {
            best = Integer.MIN_VALUE;
            for (int i = 0; i < gridSize; i++) {
                for (int j = 0; j < gridSize; j++) {
                    if (isValidCell(i, j)) {
                        gameCopy[i][j] = playerSign;
                        best = Math.max(best, miniMax(gameCopy, maxDepth - 1, false));
                        gameCopy[i][j] = DotType.EMPTY;
                    }
                }
            }
        }
        else {
            best = Integer.MAX_VALUE;
            for (int i = 0; i < gridSize; i++) {
                for (int j = 0; j < gridSize; j++) {
                    if (isValidCell(i, j)) {
                        gameCopy[i][j] = computerSign;
                        best = Math.min(best, miniMax(gameCopy, maxDepth - 1, true));
                        gameCopy[i][j] = DotType.EMPTY;
                    }
                }
            }
        }
        return best;
    }

    private int evaluateGameField(DotType[][] gameField) {
        int[] scoreCopy = new int[scoreArray.length];
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (gameField[i][j] == playerSign) {
                    addToScoreArray(scoreCopy, i, j, playerSign);
                }
                if (gameField[i][j] == computerSign) {
                    addToScoreArray(scoreCopy, i, j, computerSign);
                }
            }
        }
        return isWinnerFounded(scoreCopy);
    }

    //region getters/setters
    public DotType[][] getGameField() {
        return gameField;
    }

    public void setGameField(DotType[][] gameField) {
        this.gameField = gameField;
    }

    public DotType getPlayerSign() {
        return playerSign;
    }

    public void setPlayerSign(DotType playerSign) {
        this.playerSign = playerSign;
    }

    public DotType getComputerSign() {
        return computerSign;
    }

    public void setComputerSign(DotType computerSign) {
        this.computerSign = computerSign;
    }

    public int getGridSize() {
        return gridSize;
    }

    public void setGridSize(int gridSize) {
        this.gridSize = gridSize;
    }

    public int[] getScoreArray() {
        return scoreArray;
    }

    public void setScoreArray(int[] scoreArray) {
        this.scoreArray = scoreArray;
    }
    //endregion
}
