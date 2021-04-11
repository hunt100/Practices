package kz.test;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> words = List.of("java", "c#", "javascript", "java", "spring", "hibernate", "java", "c#", "spring", "spring");
        printEachWordCount(words);

        Phonebook phonebook = new Phonebook();
        final String valba = "Valba";
        final String kim = "Kim";
        phonebook.add(valba, "7707111");
        phonebook.add(valba, "7707222");
        phonebook.add(kim, "7707111");
        phonebook.add(kim, "7707111");
        phonebook.add(kim, "7707333");
        phonebook.add(kim, "7707333");

        System.out.println(valba + " " + phonebook.get(valba));
        System.out.println(kim + " " + phonebook.get(kim));
    }

    private static void printEachWordCount(final List<String> words) {
        Map<String, Long> wordCount = words
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(wordCount);
    }
}
