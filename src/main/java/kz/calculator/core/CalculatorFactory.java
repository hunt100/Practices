package kz.calculator.core;

import kz.calculator.core.impl.CalculatorServiceImpl;
import kz.calculator.core.impl.SimpleConstraintValidator;

public class CalculatorFactory {

    public static CalculatorService getCalculatorService() {
        return new CalculatorServiceImpl();
    }

    public static ConstraintValidator getConstraintValidator() {
        return new SimpleConstraintValidator();
    }
}
