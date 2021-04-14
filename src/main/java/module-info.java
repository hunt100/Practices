module MyModule {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens kz.test.controller to javafx.fxml;
    opens kz.test to javafx.fxml;

    exports kz.test;
}