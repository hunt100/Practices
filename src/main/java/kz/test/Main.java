package kz.test;

import kz.test.practice2.Practice2Utils;
import kz.test.practice2.exception.MyArrayDataException;
import kz.test.practice2.exception.MyArraySizeException;

import java.util.Random;

public class Main {

    private static final int A_LETTER = 97;
    private static final int Z_LETTER = 122;
    private static final int ZERO_LETTER = 48;
    private static final int NINE_LETTER = 57;

    public static void main(String[] args) {
        int sum = 0;
        try {
//            String[][] myArr = Practice2Utils.generateArray(5,3);
            String[][] myArr = Practice2Utils.generateArray(4,4);
            for (int i = 1; i < myArr.length; i++) {
                for (int j = 0; j < myArr[i].length; j++) {
                    myArr[i][j] = generateRandomString(A_LETTER, Z_LETTER, 3);
                }
            }
            myArr[0][0] = "121";
            myArr[0][1] = "221";
//            for (int i = 0; i < myArr.length; i++) {
//                for (int j = 0; j < myArr[i].length; j++) {
//                    myArr[i][j] = generateRandomString(ZERO_LETTER, NINE_LETTER, 3);
//                }
//            }

            int[][] numArr = new int[4][4];
            for (int i = 0; i < numArr.length; i++) {
                for (int j = 0; j < numArr[i].length; j++) {
                    numArr[i][j] = Practice2Utils.parseToInt(myArr[i][j], i, j);
                    sum += numArr[i][j];
                    System.out.print(numArr[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        } catch (MyArraySizeException e) {
            System.err.println(e.getMessage());
        } catch (MyArrayDataException e2) {
            System.err.println(e2.getMessage());
        }
        System.out.println("Финальная сумма: " + sum);
    }

    private static String generateRandomString(int leftLimit, int rightLimit, int length) {
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
