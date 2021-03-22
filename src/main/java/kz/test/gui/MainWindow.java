package kz.test.gui;

import kz.test.core.GameService;
import kz.test.core.GameServiceFactory;
import kz.test.domain.DotCoordinate;
import kz.test.enums.DotType;
import kz.test.gui.component.TextComponent;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private final String EMPTY_SIGN = "*";
    private final String USER_TURN = "Ход Игрока";
    private final String COMPUTER_TURN = "Ход Компьютера";
    private final String USER_WIN = "Игрок победил";
    private final String COMPUTER_WIN = "Компьютер победил";
    private final String GAME_OVER = "Игра окончена";
    private GameService gameService;
    private DotType player;
    private DotType computer;
    private JButton[][] grid;
    private TextComponent statusBar;

    public MainWindow() {

        setTitle("Tic-tac-toe");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200, 300, 450, 550);

        Configurable dialog = new ConfigurationDialog(this);
        player = dialog.getDotType();
        computer = DotType.getEnemySign(player);
        int gridSize = dialog.getGridSize();
        gameService = GameServiceFactory.getGameService(player, gridSize);

        statusBar = new TextComponent();
        statusBar.setText(USER_TURN);
        grid = new JButton[gridSize][gridSize];
        JPanel mainPanel = initGameBoard(gridSize);

        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);
        add(statusBar, BorderLayout.SOUTH);

        setVisible(true);
    }

    private JPanel initGameBoard(int gridSize) {
        JPanel mainPanel = new JPanel(new GridLayout(gridSize, gridSize));
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                JButton btn = new JButton(EMPTY_SIGN);
                Font font = new Font(btn.getFont().getName(), btn.getFont().getStyle(), 40);
                btn.setFont(font);
                btn.putClientProperty("INDEX_ROW", i);
                btn.putClientProperty("INDEX_COL", j);

                btn.addActionListener(e -> {
                    final JButton sourceBtn = (JButton) e.getSource();
                    makeUserTurn(sourceBtn);

                    if (gameService.canContinue()) {
                        if (gameService.isWinnerFounded() == 1) {
                            statusBar.setText(USER_WIN);
                            disableAllButtons();
                        }else {
                            makeComputerTurn();
                            statusBar.setText(USER_TURN);
                        }
                    } else {
                        statusBar.setText(GAME_OVER);
                        disableAllButtons();
                    }
                });

                mainPanel.add(btn);
                grid[i][j] = btn;
            }
        }
        return mainPanel;
    }

    private void makeUserTurn(JButton sourceBtn) {

        int indexRow = (int) sourceBtn.getClientProperty("INDEX_ROW");
        int indexCol = (int) sourceBtn.getClientProperty("INDEX_COL");
        statusBar.setText(USER_TURN);
        gameService.userTurn(indexRow, indexCol);
        disableAndPrintSelectedBtn(sourceBtn, player);
        statusBar.setText(USER_TURN);
    }

    private void makeComputerTurn() {
        statusBar.setText(COMPUTER_TURN);
        DotCoordinate dotCoordinate = gameService.computerTurn();
        JButton btn = grid[dotCoordinate.getRowIndex()][dotCoordinate.getColIndex()];
        disableAndPrintSelectedBtn(btn, computer);

        if (gameService.canContinue()) {
            if (gameService.isWinnerFounded() == -1) {
                statusBar.setText(COMPUTER_WIN);
                disableAllButtons();
            }
        } else {
            statusBar.setText(GAME_OVER);
            disableAllButtons();
        }
    }

    private void disableAndPrintSelectedBtn(JButton sourceBtn, DotType dotType) {
        sourceBtn.setText(dotType.toString());
        sourceBtn.setEnabled(false);
    }

    private void disableAllButtons() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                grid[i][j].setEnabled(false);
            }
        }
    }


}
