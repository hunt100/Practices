package kz.calculator.gui.strategy;

import kz.calculator.core.CalculatorService;

import javax.swing.*;

public interface ButtonStrategy {

    JButton createSpecificButton(String text, JLabel mainLabel, JLabel additionalLabel, CalculatorService calculatorService);
}
