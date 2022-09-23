package com.example.demo;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Error{

    public static void display(String title, String message){

        Stage errorMessage = new Stage();

        errorMessage.initModality(Modality.APPLICATION_MODAL);
        errorMessage.setTitle(title);
        errorMessage.setMinWidth(300);

        Label label = new Label();
        label.setText(message);

        Button closeButton = new Button ("I Understand. I'm sorry.");
        closeButton.setOnAction(e -> errorMessage.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        errorMessage.setScene(scene);
        errorMessage.showAndWait();

    }

}
