module com.example.javafxmles {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxmles to javafx.fxml;
    exports com.example.javafxmles;
}