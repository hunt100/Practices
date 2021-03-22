package kz.calculator.gui.strategy.impl;

import kz.calculator.core.CalculatorService;
import kz.calculator.domain.CalculatorConstants;
import kz.calculator.domain.enums.OperationType;
import kz.calculator.gui.strategy.ButtonStrategy;

import javax.swing.*;
import java.util.Optional;

public class ClearCurrentButtonStrategy implements ButtonStrategy {

    @Override
    public JButton createSpecificButton(String text, JLabel mainLabel, JLabel additionalLabel, CalculatorService calculatorService) {
        JButton btn = new JButton(text);
        btn.addActionListener(e -> {
            mainLabel.setText(CalculatorConstants.ONLY_ZERO);
            if (OperationType.NOOP.equals(calculatorService.getOperationType())) {
                additionalLabel.setText(CalculatorConstants.ONLY_ZERO);
            } else {
                Optional<String> operation = CalculatorConstants.SIGN_STRINGS
                        .stream()
                        .filter(s -> s.equals(calculatorService.getOperationType().getOperationSign()))
                        .findFirst();
                int signIndex = additionalLabel.getText().indexOf(operation.orElse(OperationType.NOOP.getOperationSign()));
                String cutString = additionalLabel.getText().substring(0, signIndex + 1);
                additionalLabel.setText(cutString.concat(CalculatorConstants.ONLY_ZERO));
            }




        });
        return btn;
    }
}
