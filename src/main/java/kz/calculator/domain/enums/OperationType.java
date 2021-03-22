package kz.calculator.domain.enums;

public enum OperationType {
    ADDITION("+"),
    SUBTRACT("-"),
    MULTIPLICATION("*"),
    DIVISION("/"),
    NOOP("");

    private final String operationSign;

    OperationType(String operationSign) {
        this.operationSign = operationSign;
    }

    public String getOperationSign() {
        return operationSign;
    }
}
