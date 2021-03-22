package kz.calculator.gui.strategy.impl;

import kz.calculator.core.CalculatorService;
import kz.calculator.domain.CalculatorConstants;
import kz.calculator.gui.strategy.ButtonStrategy;

import javax.swing.*;

public class ClearAllButtonStrategy implements ButtonStrategy {

    @Override
    public JButton createSpecificButton(String text, JLabel mainLabel, JLabel additionalLabel, CalculatorService calculatorService) {
        JButton btn = new JButton(text);
        btn.addActionListener(e -> {
            calculatorService.clearUsedData();
            mainLabel.setText(CalculatorConstants.ONLY_ZERO);
            additionalLabel.setText(CalculatorConstants.ONLY_ZERO);
        });
        return btn;
    }
}
