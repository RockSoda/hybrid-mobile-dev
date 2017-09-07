package week5_1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static Tally tally = new Tally();
    public static ProcessHint aHint;
    public static GridPane grid = new GridPane();
    public static final TextField input = new TextField();
    public static final Label output = new Label();
    public static final Label hint = new Label();
    public static Button Continue = new Button();
    public static Button getTally = new Button("Get Tally");


    public static void main(String[] args) {
        launch(args);
    }

    public static void menu() {
        Continue.setVisible(true);
        getTally.setVisible(true);

        final Label warning1 = new Label();
        GridPane.setConstraints(warning1, 0, 4);
        grid.getChildren().add(warning1);

        final Label warning2 = new Label();
        GridPane.setConstraints(warning2, 0, 5);
        grid.getChildren().add(warning2);

        final Label warning3 = new Label();
        GridPane.setConstraints(warning3, 0, 6);
        grid.getChildren().add(warning3);

        Continue.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                warning1.setVisible(false);
                warning2.setVisible(false);
                warning3.setVisible(false);
                Continue.setVisible(false);
                getTally.setVisible(false);
                output.setText("");
                aHint = new ProcessHint();
                hint.setText(aHint.toString());
            }
        });

        getTally.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                Continue.setText("New Game");
                warning1.setText("Tally:");
                warning2.setText("Words you guessed correctly: " + tally.getcWord());
                warning3.setText("Incorrect guesses you made for all games: " + tally.getInGuess());
            }
        });

    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Word Guessing Game");

        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);


        GridPane.setConstraints(hint, 0, 1);
        grid.getChildren().add(hint);

        GridPane.setConstraints(input, 0, 0);
        grid.getChildren().add(input);

        Button guess = new Button("Take a guess");
        GridPane.setConstraints(guess, 0, 2);
        grid.getChildren().add(guess);

        GridPane.setConstraints(output, 0, 3);
        grid.getChildren().add(output);

        Continue.setVisible(false);
        GridPane.setConstraints(Continue, 1, 2);
        grid.getChildren().add(Continue);

        getTally.setVisible(false);
        GridPane.setConstraints(getTally, 1, 3);
        grid.getChildren().add(getTally);


        aHint = new ProcessHint();
        hint.setText(aHint.toString());

        guess.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                String str = String.valueOf(input.getText());
                aHint.setInput(str);
                hint.setText(aHint.toString());
                if (aHint.checkWin()) {
                    Continue.setText("Continue");
                    output.setText("Bingo! You won.");
                    tally.setcWord(1);
                    tally.setInGuess(aHint.getCounter());
                    menu();

                }
                if (aHint.getCounter() == 10) {
                    Continue.setText("Continue");
                    output.setText("Sorry, You lost.");
                    tally.setInGuess(aHint.getCounter());
                    menu();
                }
            }
        });

        grid.setAlignment(Pos.CENTER);
        primaryStage.setScene(new Scene(grid, 600, 600));
        primaryStage.show();

    }
}
