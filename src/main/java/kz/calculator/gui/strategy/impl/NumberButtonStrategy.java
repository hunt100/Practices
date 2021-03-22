package kz.calculator.gui.strategy.impl;

import kz.calculator.core.CalculatorService;
import kz.calculator.domain.CalculatorConstants;
import kz.calculator.gui.strategy.ButtonStrategy;

import javax.swing.*;

public class NumberButtonStrategy implements ButtonStrategy {

    @Override
    public JButton createSpecificButton(String text, JLabel mainLabel, JLabel additionalLabel, CalculatorService calculatorService) {
        JButton btn = new JButton(text);
        btn.addActionListener(e -> {
            if (mainLabel.getText().equals(CalculatorConstants.ONLY_ZERO)) {
                mainLabel.setText(btn.getText());
            } else {
                mainLabel.setText(mainLabel.getText().concat(btn.getText()));
            }

            if (additionalLabel.getText().equals(CalculatorConstants.ONLY_ZERO)) {
                additionalLabel.setText(mainLabel.getText());
            } else {
                additionalLabel.setText(additionalLabel.getText() + mainLabel.getText().charAt(mainLabel.getText().length() - 1));
            }
        });
        return btn;
    }
}
