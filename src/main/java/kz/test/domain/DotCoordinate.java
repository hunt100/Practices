package kz.test.domain;

public final class DotCoordinate {

    private final int rowIndex;
    private final int colIndex;

    public DotCoordinate(int rowIndex, int colIndex) {
        this.rowIndex = rowIndex;
        this.colIndex = colIndex;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public int getColIndex() {
        return colIndex;
    }
}
