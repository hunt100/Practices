package kz.calculator.gui.strategy.impl;

import kz.calculator.core.CalculatorFactory;
import kz.calculator.core.CalculatorService;
import kz.calculator.core.ConstraintValidator;
import kz.calculator.gui.strategy.ButtonStrategy;

import javax.swing.*;

public class DotButtonStrategy implements ButtonStrategy {

    @Override
    public JButton createSpecificButton(String text, JLabel mainLabel, JLabel additionalLabel, CalculatorService calculatorService) {
        ConstraintValidator validator = CalculatorFactory.getConstraintValidator();
        JButton btn = new JButton(text);
        btn.addActionListener(e -> {
            if (validator.isCurrentStateValid(text, additionalLabel.getText())) {
                mainLabel.setText(mainLabel.getText().concat(text));
                additionalLabel.setText(mainLabel.getText());
            }
        });
        return btn;
    }
}
