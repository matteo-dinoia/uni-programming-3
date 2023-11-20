package com.example.javafxmles;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.DataModel;

import java.io.IOException;

public class ExcerciseApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ExcerciseApplication.class.getResource("main-page.fxml"));
        DataModel data = new DataModel();

        Scene scene = new Scene(fxmlLoader.load(), 340, 200);
        stage.setScene(scene);

        ExcerciseController contr = fxmlLoader.getController();
        contr.setup(data);

        stage.titleProperty().bind(data.getTitoloProperty());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}