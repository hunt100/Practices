package kz.test.practice2.exception;

public class MyArrayDataException extends RuntimeException {

    public MyArrayDataException(int row, int col) {
        super("Неверные данные в ячейке с координатами: " + row + ", " + col);
    }
}
