package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javafx.scene.control.Button;

public class Welcome extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Welcome");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);
        final Label title = new Label("Welcome") ;
        GridPane.setConstraints(title, 0, 0);
        grid.getChildren().add(title);

        final TextField name = new TextField();
        name.setPrefColumnCount(10);
        name.getText();
        GridPane.setConstraints(name, 0, 1);
        grid.getChildren().add(name);

        final TextField passWord = new TextField();
        GridPane.setConstraints(passWord, 0, 2);
        grid.getChildren().add(passWord);

        Button signIn = new Button("sign in");
        GridPane.setConstraints(signIn, 1, 3);

        grid.getChildren().add(signIn);

        final Label warning = new Label("sign in button pressed");
        warning.setTextFill(Color.RED);
        warning.setVisible(false);
        GridPane.setConstraints(warning, 1, 4);
        grid.getChildren().add(warning);
        signIn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                warning.setVisible(true);
            }

        });

        grid.setAlignment(Pos.CENTER);
        primaryStage.setScene(new Scene(grid, 400, 400));
        primaryStage.show();


    }
}
