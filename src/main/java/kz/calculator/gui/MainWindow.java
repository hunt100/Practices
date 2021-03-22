package kz.calculator.gui;

import kz.calculator.core.CalculatorFactory;
import kz.calculator.core.CalculatorService;
import kz.calculator.domain.CalculatorConstants;
import kz.calculator.gui.strategy.ButtonStrategy;
import kz.calculator.gui.strategy.impl.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MainWindow extends JFrame {


    private JLabel additionalLabel;
    private JLabel mainLabel;
    private final Map<String, JButton> buttonMap = new HashMap<>();

    public MainWindow() {
        setTitle("Калькулятор");
        setBounds(200, 300, 270, 350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel viewPanel = getUpperView();

        JPanel buttonPanel = initBtnPanel();

        add(viewPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    private JPanel initBtnPanel() {
        int rowSize = 5;
        int colSize = 4;
        JPanel buttonPanel = new JPanel(new GridLayout(rowSize,colSize));
        CalculatorService calculatorService = CalculatorFactory.getCalculatorService();
        for (String[] symbol : CalculatorConstants.SYMBOLS) {
            for (String s : symbol) {
                ButtonStrategy btnStrategy = chooseButtonStrategy(s);
                JButton btn = btnStrategy.createSpecificButton(s, mainLabel, additionalLabel, calculatorService);
                buttonPanel.add(btn);
            }
        }
        return buttonPanel;
    }

    private ButtonStrategy chooseButtonStrategy(String str) {
        if (CalculatorConstants.NUMBER_STRINGS.contains(str)) {
            return new NumberButtonStrategy();
        }
        switch (str) {
            case "+": return new AddButtonStrategy();
            case "-": return new SubtractButtonStrategy();
            case "*": return new MultiplicationButtonStrategy();
            case "/": return new DivisionButtonStrategy();
            case "=": return new EqualButtonStrategy();
            case "√": return new SquareButtonStrategy();
            case "←": return new ClearLastSymbolButtonStrategy();
            case "CE": return new ClearCurrentButtonStrategy();
            case "C": return new ClearAllButtonStrategy();
            case ".": return new DotButtonStrategy();
        }
        throw new RuntimeException("Unexpected type of operator!");
    }


    private JPanel getUpperView() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));

        additionalLabel = createLabel(CalculatorConstants.ONLY_ZERO, 10);
        panel.add(additionalLabel, BorderLayout.NORTH);

        mainLabel = createLabel(CalculatorConstants.ONLY_ZERO, 30);
        panel.add(mainLabel, BorderLayout.CENTER);

        return panel;
    }

    private JLabel createLabel(String initText, int fontSize) {
        JLabel label = new JLabel(initText, SwingConstants.RIGHT);
        Font mainFont = new Font(label.getFont().getName(), label.getFont().getStyle(), fontSize);
        label.setFont(mainFont);
        label.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        return label;
    }
}
