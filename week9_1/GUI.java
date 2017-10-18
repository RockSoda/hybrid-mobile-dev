package week9_1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.text.Text;

import java.io.IOException;
public class GUI extends Application {
    private Merge m = new Merge();

    //protected Text text = new Text(50,50, m.getMail(0));

    protected Label Mail = new Label(m.getMail(0)) ;

    public GUI() throws IOException {
    }

    /*protected BorderPane getPane(){
        HBox paneForButtons = new HBox(20);
        Button btLeft = new Button("Left");
        Button btRight = new Button("Right");
        paneForButtons.getChildren().addAll(btLeft,btRight);
        paneForButtons.setAlignment(Pos.CENTER);
        paneForButtons.setStyle("-fx-border-color: green");

        BorderPane pane = new BorderPane();
        pane.setBottom(paneForButtons);

        Pane paneForText = new Pane();
        paneForText.getChildren().add(text);
        pane.setCenter(paneForText);

        btLeft.setOnAction(e ->text.setX(text.getX() - 10));
        btRight.setOnAction(e ->text.setX(text.getX() - 10));

        return pane;

    }*/

    protected GridPane getPane(){
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        GridPane.setConstraints(Mail, 0, 0);
        grid.getChildren().add(Mail);

        Button previous = new Button("<");
        GridPane.setConstraints(previous, 1, 1);
        grid.getChildren().add(previous);

        Button next = new Button(">");
        GridPane.setConstraints(next, 2, 1);
        grid.getChildren().add(next);

        return grid;
    }
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Scene scene = new Scene(getPane(),650,200);
        primaryStage.setTitle("Mail");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}













