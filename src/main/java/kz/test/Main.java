package kz.test;

import kz.test.practice5.Employee;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final List<Employee> EMPLOYEES = new ArrayList<>();

    static {
        EMPLOYEES.add(new Employee("Ivanov Ivan", "Engineer", "ivivan1@mailbox.com", "892312312", BigDecimal.valueOf(3000), 30));
        EMPLOYEES.add(new Employee("Danilov Daniil", "Manager", "ivivan3@mailbox.com", "325346353", BigDecimal.valueOf(4342.12), 52));
        EMPLOYEES.add(new Employee("Petrov Petr", "Manager", "ivivan2@mailbox.com", "324523121", BigDecimal.valueOf(1023.12), 45));
        EMPLOYEES.add(new Employee("Alexandrov Alexandr", "Engineer", "ivivan4@mailbox.com", "765234234", BigDecimal.valueOf(4545.45), 23));
        EMPLOYEES.add(new Employee("John Doe", "Programmer", "ivivan5@mailbox.com", "673242323", BigDecimal.valueOf(1111.11), 39));
    }

    public static void main(String[] args) {
        for (Employee e : EMPLOYEES) {
            if (e.getAge() > 40) {
                System.out.println(e.toString());
            }
        }
    }
}
