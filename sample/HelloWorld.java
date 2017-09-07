package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;

import javafx.scene.control.Label;


import javafx.scene.control.Button;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class HelloWorld extends Application{

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World Application");

        Label text = new Label("Hi there!");
        text.setVisible(false);

        Button helloButton = new Button();
        helloButton.setText("Hi there");
        helloButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                text.setVisible(true);
            }

        });


        VBox root = new VBox();

        root.getChildren().add(helloButton);
        root.getChildren().add(text);
        root.setAlignment(Pos.CENTER);
        primaryStage.setScene(new Scene(root, 300, 200));
        primaryStage.show();


    }
}