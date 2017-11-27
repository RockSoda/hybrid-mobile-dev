package week12_1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.*;

public class Main extends Application {

    public static final TextField input1 = new TextField();
    public static final TextField input2 = new TextField();
    public static final TextField input3 = new TextField();
    public static final TextField modify = new TextField();
    public static final TextField lock = new TextField();

    public static Button addA = new Button("New Appointment");
    public static Button addT = new Button("New To-Do Entry");
    public static Button addM = new Button("New Memo");



    private static String getDataFromDatabase(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/scheduler","sqluser","sqluserpw");

            Statement stmt=con.createStatement();

            ResultSet rs = stmt.executeQuery("select * " +
                    "from entries");

            String str = "";
            while(rs.next()) {
                str += rs.getString(2) +"."+rs.getString(1) + "\n";

            }
            con.close();

            return str;

        }catch(Exception e){ System.out.println(e);}

        return null;
    }

    private static Boolean getDataFromDatabaseByID(int id){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/scheduler","sqluser","sqluserpw");

            Statement stmt=con.createStatement();

            ResultSet rs = stmt.executeQuery("select * " +
                    "from entries " + "where id=" + id);
            Boolean b = false;
            String s = "";
            while (rs.next()){
                b = rs.getBoolean(4);
                s = rs.getString(3);
            }

            addA.setVisible(false);
            addT.setVisible(false);
            addM.setVisible(false);

            if(b){
                addA.setVisible(true);
                addT.setVisible(true);
                addM.setVisible(true);
                modify.setText("Locked Entry");

                return false;
            }else {
                stmt.executeUpdate("delete from entries " +
                        "where id=" + id);
                switch (s){
                    case "a":{
                        addA.setText("Start Edit Entry");
                        addA.setVisible(true);
                        addM.setVisible(false);
                        addT.setVisible(false);
                        return true;
                    }
                    case "t":{
                        addT.setText("Start Edit Entry");
                        addT.setVisible(true);
                        addM.setVisible(false);
                        addA.setVisible(false);
                        return true;

                    }
                    case "m":{
                        addM.setText("Start Edit Entry");
                        addM.setVisible(true);
                        addA.setVisible(false);
                        addT.setVisible(false);
                        return true;

                    }
                }

            }
            con.close();

            return false;

        }catch(Exception e){ System.out.println(e);}

        return null;
    }


    private static void SaveToDatabase(String entry, String type, boolean isLocked) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/scheduler", "sqluser", "sqluserpw");

            PreparedStatement preparedStmt = con.prepareStatement("INSERT INTO entries " +
                    " VALUES (?, default, ?, ?)");

            preparedStmt.setString(1, entry);
            preparedStmt.setString(2, type);
            preparedStmt.setBoolean(3, isLocked);
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
        primaryStage.setTitle("Personal Scheduler");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        GridPane.setConstraints(addA, 1, 0);
        grid.getChildren().add(addA);

        GridPane.setConstraints(addT, 2, 0);
        grid.getChildren().add(addT);

        GridPane.setConstraints(addM, 3, 0);
        grid.getChildren().add(addM);

        GridPane.setConstraints(input1, 0, 0);
        input1.setVisible(false);
        grid.getChildren().add(input1);

        GridPane.setConstraints(input2, 0, 1);
        input2.setVisible(false);
        grid.getChildren().add(input2);

        GridPane.setConstraints(input3, 0, 2);
        input3.setVisible(false);
        grid.getChildren().add(input3);

        GridPane.setConstraints(lock, 0, 3);
        lock.setText("Lock?(Y/N)");
        lock.setVisible(false);
        grid.getChildren().add(lock);

        Button addAConfirm = new Button("Add");
        GridPane.setConstraints(addAConfirm, 0, 5);
        addAConfirm.setVisible(false);
        grid.getChildren().add(addAConfirm);

        Button addTConfirm = new Button("Add");
        GridPane.setConstraints(addTConfirm, 0, 5);
        addTConfirm.setVisible(false);
        grid.getChildren().add(addTConfirm);

        Button addMConfirm = new Button("Add");
        GridPane.setConstraints(addMConfirm, 0, 5);
        addMConfirm.setVisible(false);
        grid.getChildren().add(addMConfirm);

        Label show = new Label();
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(show);
        scrollPane.setVisible(false);
        GridPane.setConstraints(scrollPane, 0, 4);
        grid.getChildren().add(scrollPane);

        GridPane.setConstraints(modify, 2, 3);
        modify.setVisible(false);
        modify.setText("Input the no. of the entry (id) you want to edit");
        grid.getChildren().add(modify);

        Button edit = new Button("modify");
        GridPane.setConstraints(edit, 2, 4);
        edit.setVisible(false);
        grid.getChildren().add(edit);

        edit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                edit.setVisible(false);
                addA.setVisible(false);
                addT.setVisible(false);
                addM.setVisible(false);

                String str = String.valueOf(modify.getText());
                getDataFromDatabaseByID(Integer.parseInt(str));
            }

        });


        addA.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                input1.setText("input date");
                input2.setText("input person");
                input3.setText("input place");

                input1.setVisible(true);
                input2.setVisible(true);
                input3.setVisible(true);
                lock.setVisible(true);
                addM.setVisible(false);
                addT.setVisible(false);
                addA.setVisible(false);

                modify.setVisible(false);
                edit.setVisible(false);

                addAConfirm.setVisible(true);

            }

        });

        addAConfirm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String str1 = String.valueOf(input1.getText());
                String str2 = String.valueOf(input2.getText());
                String str3 = String.valueOf(input3.getText());
                String str4 = String.valueOf(lock.getText());


                Appointment a = new Appointment(str1, str2, str3);
                if (str4.equalsIgnoreCase("Y")) {
                    a.setLock(true);
                    SaveToDatabase("\n"+"Appointment"+"\n"+a.toString(), "a", true);
                }

                SaveToDatabase("\n"+"Appointment"+"\n"+a.toString(), "a", false);

                input1.setVisible(false);
                input2.setVisible(false);
                input3.setVisible(false);
                addAConfirm.setVisible(false);
                lock.setVisible(false);
                addA.setVisible(true);

                show.setText(getDataFromDatabase());
                scrollPane.setVisible(true);

                addM.setVisible(true);
                addT.setVisible(true);
                modify.setVisible(true);
                edit.setVisible(true);

                addA.setText("New Appointment");

            }

        });

        addT.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                input1.setText("input date");
                input2.setText("input description");
                input3.setText("input due date");

                input1.setVisible(true);
                input2.setVisible(true);
                input3.setVisible(true);
                lock.setVisible(true);
                addT.setVisible(false);

                addM.setVisible(false);
                addA.setVisible(false);
                addTConfirm.setVisible(true);
                modify.setVisible(false);
                edit.setVisible(false);


            }

        });

        addTConfirm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String str1 = String.valueOf(input1.getText());
                String str2 = String.valueOf(input2.getText());
                String str3 = String.valueOf(input3.getText());
                String str4 = String.valueOf(lock.getText());


                ToDo t = new ToDo(str1, str2, str3);
                if (str4.equalsIgnoreCase("Y")) {
                    t.setLock(true);
                    SaveToDatabase("\n"+"ToDo"+"\n"+t.toString(), "t", true);

                }

                SaveToDatabase("\n"+"ToDo"+"\n"+t.toString(), "t", false);

                input1.setVisible(false);
                input2.setVisible(false);
                input3.setVisible(false);
                addTConfirm.setVisible(false);
                lock.setVisible(false);
                addT.setVisible(true);

                show.setText(getDataFromDatabase());
                scrollPane.setVisible(true);

                addM.setVisible(true);
                addA.setVisible(true);
                modify.setVisible(true);
                edit.setVisible(true);

                addT.setText("New To-Do Entry");

            }

        });

        addM.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                input1.setText("input date");
                input2.setText("input text");

                input1.setVisible(true);
                input2.setVisible(true);
                lock.setVisible(true);
                addM.setVisible(false);


                addA.setVisible(false);
                addT.setVisible(false);
                addMConfirm.setVisible(true);
                modify.setVisible(false);
                edit.setVisible(false);


            }

        });

        addMConfirm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String str1 = String.valueOf(input1.getText());
                String str2 = String.valueOf(input2.getText());
                String str4 = String.valueOf(lock.getText());


                Memo m = new Memo(str1, str2);
                if (str4.equalsIgnoreCase("Y")) {
                    m.setLock(true);
                    SaveToDatabase("\n"+"Memo"+"\n"+m.toString(), "m", true);

                }

                SaveToDatabase("\n"+"Memo"+"\n"+m.toString(), "m", false);

                input1.setVisible(false);
                input2.setVisible(false);
                input3.setVisible(false);
                addMConfirm.setVisible(false);
                lock.setVisible(false);
                addM.setVisible(true);

                show.setText(getDataFromDatabase());
                scrollPane.setVisible(true);

                addA.setVisible(true);
                addT.setVisible(true);
                modify.setVisible(true);
                edit.setVisible(true);

                addM.setText("New Memo");

            }

        });




        grid.setAlignment(Pos.CENTER);
        primaryStage.setScene(new Scene(grid, 600, 600));
        primaryStage.show();

    }
}
