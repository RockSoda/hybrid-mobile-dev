package week9_1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class GUI extends Application {
    private CreateMail m = new CreateMail();
    private int personID = 0;
    private String mail = "";

    //protected Text text = new Text(50,50, m.getMail(0));

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

    protected GridPane getPane() throws IOException {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        mail = m.getMail(personID);
        Label Mail = new Label(mail) ;
        GridPane.setConstraints(Mail, 2, 1);
        grid.getChildren().add(Mail);

        Button previous = new Button("<");
        previous.setVisible(false);
        GridPane.setConstraints(previous, 3, 2);
        grid.getChildren().add(previous);

        Button next = new Button(">");
        GridPane.setConstraints(next, 4, 2);
        grid.getChildren().add(next);

        Button OpenTemplate = new Button("Open Template file");
        GridPane.setConstraints(OpenTemplate, 0, 0);
        grid.getChildren().add(OpenTemplate);

        Button OpenData = new Button("Open Data file");
        GridPane.setConstraints(OpenData, 1, 0);
        grid.getChildren().add(OpenData);

        Button Save = new Button("Save mail");
        GridPane.setConstraints(Save, 2, 0);
        grid.getChildren().add(Save);

        OpenTemplate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                try {
                    showFile("/Users/sigh/IdeaProjects/JavaFX/File.txt");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });

        OpenData.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                try {
                    showFile("/Users/sigh/IdeaProjects/JavaFX/Data.txt");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });

        Save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                String path = "/Users/sigh/IdeaProjects/JavaFX/outMail"+personID+".txt";
                out(mail, path);
                try {
                    showFile(path);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });

        previous.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                try {
                    personID--;
                    mail = m.getMail(personID);
                    Mail.setText(mail);
                    next.setVisible(true);
                    if(!m.hasPrevious(personID)){
                        previous.setVisible(false);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });

        next.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                try {
                    personID++;
                    mail = m.getMail(personID);
                    Mail.setText(mail);
                    previous.setVisible(true);
                    if(!m.hasNext(personID)){
                        next.setVisible(false);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });

        return grid;
    }
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        Scene scene = new Scene(getPane(),920,250);
        primaryStage.setTitle("Mail");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showFile(String path) throws IOException {
        Runtime rt = Runtime.getRuntime();
        Process p = rt.exec("open " + path);

    }

    public static void out(String content, String path) {

        try {
            File newTextFile = new File(path);

            FileWriter fw = new FileWriter(newTextFile);
            fw.write(content);
            fw.close();

        } catch (IOException iox) {
            iox.printStackTrace();
        }
    }


}