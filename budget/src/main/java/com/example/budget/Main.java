/**
 * Name: Hashir Sami
 * Student Number: 20285281
 * Date: August 15, 2022
 * Assignment #4
 *
 * This is a basic budget management application. By pressing on the buttons, the user can calculate
 * how much money is being spent/saved for different things.
 */


// TA Note: I only commented on the things I worked on. The rest was sample code given to us.
package com.example.budget;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ExpandedBudget.fxml"));
            loader.setController(this);
            Parent root = loader.load();
            Scene scene = new Scene(root,640,400);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML Button btnVisualize;
    @FXML Button btnPlan;
    @FXML Button btnTotal;
    @FXML TextField txtIncome;
    @FXML TextField txtEducation;
    @FXML TextField txtHousing;
    @FXML TextField txtFood;
    @FXML TextField txtTransportation;
    @FXML Label lblResult;


    public void initialize(){
        /*  This function initializes the program and responds to button presses by the user
            No params or returns, though text is printed on the application
         */

        // This lambda function is the event handler for calculating the button total
        // It uses the education, housing, food, and transportation fields and totals them.
        btnTotal.setOnAction(event -> {
            double totalCosts = Double.parseDouble(txtEducation.getText()) + Double.parseDouble(txtHousing.getText()) + Double.parseDouble(txtFood.getText()) + Double.parseDouble(txtTransportation.getText());
            lblResult.setText("Total Expenses:\n\n" + totalCosts);
        });


        // This lambda function is the event handler for visualizing costs.
        // It uses the total costs (recalculated each time to keep info accurate) and calculates the percentage (rounded)
        btnVisualize.setOnAction(event -> {
            double totalCosts = Double.parseDouble(txtEducation.getText()) + Double.parseDouble(txtHousing.getText()) + Double.parseDouble(txtFood.getText()) + Double.parseDouble(txtTransportation.getText());
            double eduCosts = Double.parseDouble(String.format("%.2f",((Double.parseDouble(txtEducation.getText())/totalCosts)*100)));
            double houseCosts = Double.parseDouble(String.format("%.2f",((Double.parseDouble(txtHousing.getText())/totalCosts)*100)));
            double foodCosts = Double.parseDouble(String.format("%.2f",((Double.parseDouble(txtFood.getText())/totalCosts)*100)));
            double transCosts = Double.parseDouble(String.format("%.2f",((Double.parseDouble(txtTransportation.getText())/totalCosts)*100)));

            lblResult.setText("Education: " + eduCosts + "%\n\n" +
                    "Housing: " + houseCosts + "%\n\n" +
                    "Food: " + foodCosts + "%\n\n" +
                    "Transport: " + transCosts + "%");
        });

        // This lambda function uses the 50/30/20 rule to calculate how much money should be spent based on income
        // Uses the income txt field and calculates the percentage (rounded)
        btnPlan.setOnAction(actionEvent -> {
            double income = Double.parseDouble(txtIncome.getText());
            lblResult.setText("Needs: $" + String.format("%.2f", (income*0.50)) +
                    "\n\nWants: $" + String.format("%.2f", (income*0.30)) +
                    "\n\nSavings: $" + String.format("%.2f", (income*0.20)));
        });

    }


    public static void main(String[] args) {
        launch(args);
    }
}
