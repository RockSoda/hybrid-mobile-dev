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
import javafx.stage.Stage;

import javafx.scene.control.Button;

public class BMICalculator extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("BMI Calculator");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        final Label Height = new Label("Height: ") ;
        GridPane.setConstraints(Height, 0, 0);
        grid.getChildren().add(Height);

        final Label Weight = new Label("Weight: ") ;
        GridPane.setConstraints(Weight, 0, 1);
        grid.getChildren().add(Weight);

        final Label bmi = new Label("BMI: ") ;
        bmi.setVisible(false);
        GridPane.setConstraints(bmi, 0, 3);
        grid.getChildren().add(bmi);


        final TextField h = new TextField();
        h.setPrefColumnCount(10);
        GridPane.setConstraints(h, 1, 0);
        grid.getChildren().add(h);

        final TextField w = new TextField();
        GridPane.setConstraints(w, 1, 1);
        grid.getChildren().add(w);

        Button calculate = new Button("Calculate");
        GridPane.setConstraints(calculate, 1, 2);
        grid.getChildren().add(calculate);

        final Label BMI = new Label();
        BMI.setVisible(false);
        GridPane.setConstraints(BMI, 1, 3);
        grid.getChildren().add(BMI);

        final Label Hcm = new Label("cm") ;
        GridPane.setConstraints(Hcm, 2, 0);
        grid.getChildren().add(Hcm);

        final Label Wkg = new Label("kg") ;
        GridPane.setConstraints(Wkg, 2, 1);
        grid.getChildren().add(Wkg);

        final Label description = new Label();
        description.setVisible(false);
        GridPane.setConstraints(description, 1, 4);
        grid.getChildren().add(description);

        calculate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                bmi.setVisible(true);
                BMI.setVisible(true);

                Double cm = Double.valueOf(h.getText());
                Double kg = Double.valueOf(w.getText());
                double bmi = (kg/(cm/100.0))/(cm/100.0);
                double bmiOut = (bmi/0.01-(bmi/0.01%1))/100;
                if(bmi<=15){
                    description.setText("Very severely underweight");

                }else if(bmi>15 && bmi<=16){
                    description.setText("Severely underweight");

                }else if(bmi>16 && bmi<=18.5){
                    description.setText("Underweight");

                }else if(bmi>18.5 && bmi<=25){
                    description.setText("Normal (healthy weight)");

                }else if(bmi>25 && bmi<=30){
                    description.setText("Overweight");

                }else if(bmi>30 && bmi<=35){
                    description.setText("Obese Class I (Moderately obese)");

                }else if(bmi>35 && bmi<=40){
                    description.setText("Obese Class II (Severely obese)");

                }else if(bmi>40){
                    description.setText("Obese Class III (Very severely obese)");

                }else {
                    description.setText("Invalid input");
                }
                description.setVisible(true);

                BMI.setText(bmiOut + "");

            }

        });

        grid.setAlignment(Pos.CENTER);
        primaryStage.setScene(new Scene(grid, 600, 600));
        primaryStage.show();
    }
}
