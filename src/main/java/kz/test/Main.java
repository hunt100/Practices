package kz.test;

import java.util.Scanner;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);
    //1
    public static void main(String[] args) {
        /* 2 */
        short sh = 32767;
        int i = 2147483647;
        long l = 100000000000L;

        char c = 'c';
        String str = "string";

        float fl = 12.213f;
        double d = -35.21312;

        boolean b = true;
        System.out.println("2: Short: " + sh + "\n" +
                "Int: " + i + "\n" +
                "Long:" + l + "\n" +
                "Char:" + c + "\n" +
                "String: " + str + "\n" +
                "Float: " + fl + "\n" +
                "Double: " + d + "\n" +
                "Boolean: " + b);
        /* - */

        System.out.println("3: " + calculate(1, 2, 4, 4));

        System.out.println("4: " + liesInSelectedRange(12, 9));

        printNumberSign(-12);

        System.out.println("Waiting input name...");
        printWelcomeMessage(SCANNER.nextLine());
        System.out.println("Write your year...");
        int year = SCANNER.nextInt();
        System.out.println("Is year [" + year + "] is a leap year? => " + isLeapYear(year));

    }

    // 3
    public static float calculate(float a,
                                  float b,
                                  float c,
                                  float d) {
        return a * (b + (c / d));
    }

    //4
    public static boolean liesInSelectedRange(int first, int second) {
        return first + second >= 10 && first + second <= 20;
    }

    //5
    public static void printNumberSign(int number) {
        String output = isNegative(number) ? "negative" : "positive";
        System.out.println("5: " + output);
    }

    //6
    public static boolean isNegative(int number) {
        return number < 0;
    }

    //7
    public static void printWelcomeMessage(String name) {
        System.out.println("7: Hello, " + name);
    }

    //8
    public static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
}
