package kz.test.practice2;

import kz.test.practice2.exception.MyArrayDataException;
import kz.test.practice2.exception.MyArraySizeException;

public class Practice2Utils {

    private Practice2Utils() {
        throw new IllegalStateException("Util class");
    }

    public static String[][] generateArray(int rowSize, int colSize) throws MyArraySizeException {
        if (colSize != 4 && colSize != rowSize) {
            throw new MyArraySizeException("Размер массива не соответствует требованиям: Введенный размер: " + rowSize + "x" + colSize);
        }

        return new String[rowSize][colSize];
    }

    public static int parseToInt(String str, int i, int j) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            throw new MyArrayDataException(i, j);
        }
    }
}
