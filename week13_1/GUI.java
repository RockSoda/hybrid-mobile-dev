package week13_1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class GUI extends Application {

    public static Button college = new Button("College student");
    public static Button adult = new Button("Adult");
    public static Button senior = new Button("Senior");
    public static Button moppi = new Button("50CC Moppi");
    public static Button magnum = new Button("150CC Magnum");

    int renter = -1;
    int type = -1;


    private static void SaveToDatabase(int user, int point) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/MopedRental", "sqluser", "sqluserpw");

            PreparedStatement preparedStmt = con.prepareStatement("INSERT INTO user " +
                    " VALUES (?, ?, default)");

            preparedStmt.setInt(1, user);
            preparedStmt.setInt(2, point);
            preparedStmt.execute();

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Point Tracking System");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);



        GridPane.setConstraints(college, 1, 0);
        grid.getChildren().add(college);

        GridPane.setConstraints(adult, 2, 0);
        grid.getChildren().add(adult);

        GridPane.setConstraints(senior, 3, 0);
        grid.getChildren().add(senior);

        GridPane.setConstraints(moppi, 1, 0);
        moppi.setVisible(false);
        grid.getChildren().add(moppi);

        GridPane.setConstraints(magnum, 3, 0);
        magnum.setVisible(false);
        grid.getChildren().add(magnum);

        college.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                renter = 1;
                college.setVisible(false);
                adult.setVisible(false);
                senior.setVisible(false);
                moppi.setVisible(true);
                magnum.setVisible(true);
            }
        });

        adult.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                renter = 2;
                college.setVisible(false);
                adult.setVisible(false);
                senior.setVisible(false);
                moppi.setVisible(true);
                magnum.setVisible(true);
            }
        });

        senior.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                renter = 3;
                college.setVisible(false);
                adult.setVisible(false);
                senior.setVisible(false);
                moppi.setVisible(true);
                magnum.setVisible(true);
            }
        });

        moppi.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                type = 1;
            }
        });

        magnum.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                type = 2;
            }
        });

        Renter r = new Renter(renter, type);

        SaveToDatabase(renter, r.getPoints());


        grid.setAlignment(Pos.CENTER);
        primaryStage.setScene(new Scene(grid, 600, 600));
        primaryStage.show();

    }
}
