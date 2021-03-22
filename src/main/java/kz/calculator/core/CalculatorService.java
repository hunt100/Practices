package kz.calculator.core;

import kz.calculator.domain.enums.OperationType;

public interface CalculatorService {

    void setNumber(String mainLabel);

    void setAction(OperationType operationType);

    OperationType getOperationType();

    String getResult(boolean square);

    void clearUsedData();

    String getFirstNumber();
}
