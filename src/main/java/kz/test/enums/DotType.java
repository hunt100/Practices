package kz.test.enums;

public enum DotType {
    X, O, EMPTY;

    public static DotType getEnemySign(DotType playerSign) {
        return playerSign == X ? O : X;
    }

    public static int getNumberTypeBySign(DotType dotType) {
        return dotType == X ? 1 : -1;
    }
}
