package kz.calculator.domain;

import java.util.List;

import static kz.calculator.domain.enums.OperationType.*;

public interface CalculatorConstants {

    String ONLY_ZERO = "0";
    String EQUAL_SIGN = "=";
    List<String> NUMBER_STRINGS = List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
    List<String> SIGN_STRINGS = List.of(ADDITION.getOperationSign(), SUBTRACT.getOperationSign(), MULTIPLICATION.getOperationSign(), DIVISION.getOperationSign());
    String[][] SYMBOLS = new String[][] {
            {"←", "C", "CE", "√"},
            {"7", "8", "9", "/"},
            {"4", "5", "6", "*"},
            {"1", "2", "3", "-"},
            {"0", ".", "+", "="},
    };
}
