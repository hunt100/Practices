package kz.test;

import java.util.*;

public class Phonebook {

    private final Map<String, Set<String>> phones;

    public Phonebook() {
        phones = new HashMap<>();
    }

    public void add(String surname, String phone) {
        if (phones.containsKey(surname)) {
            phones.get(surname).add(phone);
        } else {
            phones.put(surname, new HashSet<>(Collections.singletonList(phone)));
        }
    }

    public Set<String> get(String surname) {
        return phones.get(surname);
    }
}
