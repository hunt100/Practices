package kz.calculator.core.impl;

import kz.calculator.core.CalculatorService;
import kz.calculator.domain.enums.OperationType;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class CalculatorServiceImpl implements CalculatorService {

    private BigDecimal firstNumber;
    private BigDecimal secondNumber;
    private OperationType operationType;

    public CalculatorServiceImpl() {
        this.firstNumber = null;
        this.secondNumber = null;
        this.operationType = OperationType.NOOP;
    }

    @Override
    public void setNumber(String mainLabel) {
        try {
            if (firstNumber == null) {
                firstNumber = new BigDecimal(mainLabel);
            } else {
                secondNumber = new BigDecimal(mainLabel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setAction(OperationType operationType) {
        this.operationType = operationType;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    @Override
    public String getResult(boolean square) {
        return square ? getSquareResult() : getSimpleResult();
    }

    private String getSquareResult() {
        return getResult().sqrt(MathContext.DECIMAL64).toPlainString();
    }

    private String getSimpleResult() {
        return getResult().toPlainString();
    }

    private BigDecimal getResult() {
        BigDecimal result = BigDecimal.ZERO;
        if (secondNumber == null) {
            if (OperationType.MULTIPLICATION.equals(operationType) || OperationType.DIVISION.equals(operationType)) {
                secondNumber = BigDecimal.ONE;
            } else {
                secondNumber = BigDecimal.ZERO;
            }
        }
        switch (operationType) {
            case ADDITION: result = firstNumber.add(secondNumber); break;
            case SUBTRACT: result = firstNumber.subtract(secondNumber); break;
            case MULTIPLICATION: result = firstNumber.multiply(secondNumber); break;
            case DIVISION: result = firstNumber.divide(secondNumber); break;
            case NOOP: result = firstNumber;
        }
        if (result.stripTrailingZeros().scale() <= 0) {
            return result;
        } else {
            return result.setScale(2, RoundingMode.HALF_UP);
        }
    }

    @Override
    public void clearUsedData() {
        this.firstNumber = null;
        this.secondNumber = null;
        this.operationType = OperationType.NOOP;
    }

    @Override
    public String getFirstNumber() {
        return firstNumber.toPlainString();
    }
}
