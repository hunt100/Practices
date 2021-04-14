package kz.test.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextArea textArea;

    @FXML
    private TextField messageField;

    private static final String NEW_LINE = "\n";
    private static final String USER = "User: ";
    private static final String EMPTY_STRING = "";

    @FXML
    private void initialize() {
        textArea.setEditable(false);
        textArea.setFocusTraversable(false);
    }

    @FXML
    public void sendMessage() {
        if (messageField.getText().isEmpty()) {
            return;
        }
        final String messageText = messageField.getText();
        String newText = USER + messageText + NEW_LINE;
        textArea.appendText(newText);
        messageField.setText(EMPTY_STRING);
    }
}
