package kz.test;

import kz.test.practice2.Practice2;

public class Main {

    public static void main(String[] args) {
        int[] arr;

        //1
        arr = new int[] {1, 1, 0, 0, 1, 0, 1, 1, 0};
        printInitialArray(arr);
        Practice2.swapSymbolsInArray(arr);

        //2
        arr = new int[7];
        printInitialArray(arr);
        Practice2.initializeArray(arr);

        //3
        arr = new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        printInitialArray(arr);
        Practice2.multiplySmallValues(arr);

        //4
        int[][] arr4 = new int[5][5];
        Practice2.fillDiagonalElements(arr4);

        //5
        arr = new int[getRandomNumber(5,10)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = getRandomNumber(-100, 100);
        }
        printInitialArray(arr);
        Practice2.findOutliers(arr);

        //6
        arr = new int[] {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println("Check on balance: " + Practice2.checkOnPossibleBalance(arr));

        //7
        arr = new int[] {1,2,3,4,5};
        printInitialArray(arr);
        Practice2.moveArray(arr, 3);
    }


    public static void printInitialArray(int[] arr) {
        System.out.println("Initial array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
