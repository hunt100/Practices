package kz.calculator.core;

public interface ConstraintValidator {

    boolean isCurrentStateValid(String text, String additionalLabel);
}
