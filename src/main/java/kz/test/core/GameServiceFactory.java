package kz.test.core;

import kz.test.enums.DotType;

public class GameServiceFactory {

    public static GameService getGameService(DotType playerSign, int gridSize) {
        return new GameServiceImpl(playerSign, gridSize);
    }
}
