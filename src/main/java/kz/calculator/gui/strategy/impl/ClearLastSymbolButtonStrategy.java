package kz.calculator.gui.strategy.impl;

import kz.calculator.core.CalculatorService;
import kz.calculator.domain.CalculatorConstants;
import kz.calculator.gui.strategy.ButtonStrategy;

import javax.swing.*;

public class ClearLastSymbolButtonStrategy implements ButtonStrategy {

    @Override
    public JButton createSpecificButton(String text, JLabel mainLabel, JLabel additionalLabel, CalculatorService calculatorService) {
        JButton btn = new JButton(text);
        btn.addActionListener(e -> {
            if (!mainLabel.getText().equals(CalculatorConstants.ONLY_ZERO) && mainLabel.getText().length() == 1) {
                mainLabel.setText(CalculatorConstants.ONLY_ZERO);
                additionalLabel.setText(additionalLabel.getText().substring(0, additionalLabel.getText().length() - 1).concat(CalculatorConstants.ONLY_ZERO));
            } else if (mainLabel.getText().length() > 1) {
                mainLabel.setText(mainLabel.getText().substring(0, mainLabel.getText().length() - 1));
                additionalLabel.setText(additionalLabel.getText().substring(0, additionalLabel.getText().length() - 1));
            }
        });
        return btn;
    }
}
