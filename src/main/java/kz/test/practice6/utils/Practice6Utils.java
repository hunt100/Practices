package kz.test.practice6.utils;

public final class Practice6Utils {

    private Practice6Utils() {
        throw new IllegalStateException("Util class");
    }

    public static void validateValue(String className, int value, int maxValue) {
        if (!isPositive(value)) {
            throw new IllegalArgumentException("Нарушено одно из ограничений. Дистанция должна быть положительной: " + value);
        }
        if (value > maxValue) {
            throw new IllegalStateException(
                    "Нарушено одно из ограничений. Дистанция не должна превышать максимальное допустимое значение для " +
                            className + ": " + maxValue + ". Текущая дистанция: " + value);
        }
    }

    public static boolean isPositive(int value) {
        return value >= 0;
    }
}
