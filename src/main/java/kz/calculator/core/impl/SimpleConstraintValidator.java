package kz.calculator.core.impl;

import kz.calculator.core.ConstraintValidator;

public class SimpleConstraintValidator implements ConstraintValidator {

    @Override
    public boolean isCurrentStateValid(String text, String additionalLabel) {
        return true;
    }
}
