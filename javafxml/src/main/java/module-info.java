module frontend.javafxml {
    requires javafx.controls;
    requires javafx.fxml;


    opens frontend.javafxml to javafx.fxml;
    exports frontend.javafxml;
}