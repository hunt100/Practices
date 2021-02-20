package kz.test.practice2;

import java.util.Arrays;

public class Practice2 {

    //1
    public static void swapSymbolsInArray(int[] arr) {
        System.out.println("Start printing array : ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //2
    public static void initializeArray(int[] arr) {
        System.out.println("Start printing array : ");
        int bias = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = bias;
            bias += 3;
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //3
    public static void multiplySmallValues(int[] arr) {
        System.out.println("Start printing array : ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] < 6 ? arr[i] * 2 : arr[i];
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //4
    public static void fillDiagonalElements(int[][] arr) {
        System.out.println("Start printing array : ");

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == j || j + i == arr.length - 1) {
                    arr[i][j] = 1;
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    //5
    public static void findOutliers(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max ) {
                max = arr[i];
            }
        }
        System.out.println("Min value: " + min + "\nMax value: " + max);
    }

    //6
    public static boolean checkOnPossibleBalance(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int[] subArr1 = Arrays.copyOfRange(arr, 0, i + 1);
            int[] subArr2 = Arrays.copyOfRange(arr, i + 1, arr.length);
            if (sumOfElements(subArr1) == sumOfElements(subArr2)) {
                return true;
            }
        }
        return false;
    }


    private static int sumOfElements(int[] subArr) {
        return Arrays.stream(subArr).sum();
    }

    //7
    public static void moveArray(int[] arr, int offset) {
        boolean isRightDirection = offset > 0;
        offset = Math.abs(offset);
        for (int j = 0; j < offset; j++) {
            if (isRightDirection) {
                int last = arr[arr.length - 1];
                for (int i = arr.length - 2; i >= 0; i--) {
                    arr[i+1] = arr[i];
                }
                arr[0] = last;
            } else {
                int first = arr[0];
                for (int i = 1; i < arr.length; i++) {
                    arr[i-1] = arr[i];
                }
                arr[arr.length - 1] = first;
            }
        }

        System.out.println("Moved array edition: ");
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
