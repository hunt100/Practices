package kz.test.practice3;

import java.util.Random;

public class Practice3 {

    private static final int MIN_SECRET_LENGTH = 15;
    private static final Random RANDOM = new Random(123456789L);
    private static final String[] WORDS = new String[]
            {"apple", "apricot", "avocado", "banana", "broccoli", "carrot", "cherry", "garlic", "grape", "kiwi",
                    "leak", "lemon", "mango", "melon", "mushroom", "nut", "olive", "orange", "pea", "peanut", "pear",
                    "pepper", "pineapple", "potato", "pumpkin"};

    private Practice3() {
        throw new IllegalStateException("Utility class");
    }

    public static int getRandomNumber(int min, int max) {
        return (RANDOM.nextInt(max) + min);
    }

    public static String getRandomWord() {
        return WORDS[getRandomNumber(0, WORDS.length)];
    }

    public static boolean isRightGuess(int guess, int exact) {
        if (guess == exact) {
            System.out.println("Ура, число было угадано! Это же " + exact);
            return true;
        }
        System.out.println("Вы не угадали число :(");
        String errorResult = guess > exact ? "Предположенное число больше загаданного" : "Предположенное число меньше загаданного";
        System.out.println(errorResult);
        return false;
    }

    public static boolean isRightGuess(String guess, String exact) {
        if (guess.equals(exact))  {
            System.out.println("Ура, слово было угадано! Это же " + exact);
            return true;
        }
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < guess.length() && i < exact.length(); i++) {
            if (guess.charAt(i) == exact.charAt(i)) {
                builder.append(guess.charAt(i));
            } else {
                builder.append('#');
            }
        }
        if (builder.length() < MIN_SECRET_LENGTH) {
            builder.append(repeat('#', MIN_SECRET_LENGTH - builder.length()));
        }
        System.out.println("Отгаданные буквы:\n" + builder.toString());
        return false;
    }

    private static String repeat(final char ch, final int repeat) {
        final char[] buf = new char[repeat];
        for (int i = repeat - 1; i >= 0; i--) {
            buf[i] = ch;
        }
        return new String(buf);
    }

}
