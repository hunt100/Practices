package kz.calculator.gui.strategy.impl;

import kz.calculator.core.CalculatorFactory;
import kz.calculator.core.CalculatorService;
import kz.calculator.core.ConstraintValidator;
import kz.calculator.domain.CalculatorConstants;
import kz.calculator.domain.enums.OperationType;
import kz.calculator.gui.strategy.ButtonStrategy;

import javax.swing.*;

public class MultiplicationButtonStrategy implements ButtonStrategy {

    @Override
    public JButton createSpecificButton(String text, JLabel mainLabel, JLabel additionalLabel, CalculatorService calculatorService) {
        ConstraintValidator validator = CalculatorFactory.getConstraintValidator();
        JButton btn = new JButton(text);
        btn.addActionListener(e -> {
            if (validator.isCurrentStateValid(text, additionalLabel.getText())) {
                calculatorService.setNumber(mainLabel.getText());
                calculatorService.setAction(OperationType.MULTIPLICATION);
                mainLabel.setText(CalculatorConstants.ONLY_ZERO);

                if (additionalLabel.getText().contains(CalculatorConstants.EQUAL_SIGN)) {
                    additionalLabel.setText(calculatorService.getFirstNumber().concat(OperationType.MULTIPLICATION.getOperationSign()));
                } else {
                    additionalLabel.setText(additionalLabel.getText().concat(OperationType.MULTIPLICATION.getOperationSign()));
                }
            }
        });
        return btn;
    }
}
