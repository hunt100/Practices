package kz.test.practice1;

public class Practice1 {

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
