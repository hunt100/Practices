package kz.test.core;

import kz.test.domain.DotCoordinate;

public interface GameService {

    void userTurn(int row, int col);

    DotCoordinate computerTurn();

    boolean canContinue();

    int isWinnerFounded();

    int getGridSize();
}
