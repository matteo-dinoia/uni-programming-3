package com.example.javafxmles;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import model.DataModel;

public class ExcerciseController {
    private DataModel data = null;

    @FXML private Label resultText;
    @FXML private Label questionText;
    @FXML private TextField answerText;

    @FXML private VBox vBox;

    public void setup(DataModel data){
        this.data = data;
        questionText.textProperty().bind(data.getTestoEsercizioProperty());
        data.getRispostaProperty().bind(answerText.textProperty());
        resultText.textProperty().bind(data.getVerificaRispostaProperty());
        data.setEsercizio();

        setupGui();
    }

    private void setupGui(){
        questionText.prefWidthProperty().bind(vBox.widthProperty());
        resultText.prefWidthProperty().bind(vBox.widthProperty());
    }


    @FXML
    public void onNextBtnClick(ActionEvent actionEvent) {
        data.setEsercizio();
        answerText.setText("");
    }

    @FXML
    public void onConfermaBtnClick(ActionEvent actionEvent) {
        data.checkRisposta();
    }
}