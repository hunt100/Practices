package kz.test.gui;

import kz.test.enums.DotType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class ConfigurationDialog extends JDialog implements Configurable {

    private final static int MARGIN = 10;
    private int gridSize = 3;
    private DotType player = DotType.X;
    private JTextField gridSizeTextField;

    public ConfigurationDialog(JFrame frame) {
        super(frame, "Окно конфигурации", true);
        setBounds(200, 300, 400, 200);

        gridSizeTextField = new JTextField(String.valueOf(gridSize));

        JPanel configPanel = getConfigurationPanel();

        JButton applyButton = createApplyButton();

        add(configPanel, BorderLayout.NORTH);
        add(applyButton, BorderLayout.SOUTH);
        configPanel.setBorder(BorderFactory.createEmptyBorder(MARGIN, MARGIN, MARGIN, MARGIN));
        setVisible(true);
    }

    private JButton createApplyButton() {
        JButton applyButton = new JButton("Принять");
        WindowEvent closeEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        applyButton.addActionListener(e -> {
            gridSize = Integer.parseInt(gridSizeTextField.getText());
            dispatchEvent(closeEvent);
        });
        return applyButton;
    }

    private JPanel getConfigurationPanel() {
        int configSize = 2;
        int hGap = 10;
        int vGap = 20;
        JPanel configPanel = new JPanel(new GridLayout(configSize,configSize, hGap, vGap));
        configPanel.add(new JLabel("Выберите игрока:"));
        configPanel.add(getRadioButtonConfigPanel());
        configPanel.add(new JLabel("Размер поля:"));
        configPanel.add(gridSizeTextField);
        return configPanel;
    }

    private JPanel getRadioButtonConfigPanel() {
        JRadioButton radioBtnX = createRadioButton(DotType.X, true);
        JRadioButton radioBtnO = createRadioButton(DotType.O, false);

        JPanel radioButtonsPanel = new JPanel();
        radioButtonsPanel.add(radioBtnX);
        radioButtonsPanel.add(radioBtnO);

        ButtonGroup group = new ButtonGroup();
        group.add(radioBtnX);
        group.add(radioBtnO);

        return radioButtonsPanel;

    }

    private JRadioButton createRadioButton(DotType dotType, boolean selected) {
        JRadioButton radioBtnX = new JRadioButton(dotType.toString(), selected);
        radioBtnX.addActionListener(e -> player = dotType);
        return radioBtnX;
    }

    @Override
    public DotType getDotType() {
        return player;
    }

    @Override
    public int getGridSize() {
        return gridSize;
    }
}
