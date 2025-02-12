package com.example.module03_hw;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField IntRate;

    @FXML
    private TextField NumYears;

    @FXML
    private TextField LoanAmount;

    @FXML
    private TextField MonthlyPayment;

    @FXML
    private TextField TotalPayment;

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        try {
            // retrieves input by the user

            double loanAmount = Double.parseDouble(LoanAmount.getText());
            double annualInterestRate = Double.parseDouble(IntRate.getText()) / 100;
            int numYears = Integer.parseInt(NumYears.getText());

            double monthlyInterestRate = annualInterestRate / 12;

            int numMonths = numYears * 12;

            double monthlyPayment = (loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numMonths))  / (Math.pow(1 + monthlyInterestRate, numMonths) - 1);

            double totalPayment = monthlyPayment * numMonths;

            MonthlyPayment.setText(String.format("%.2f", monthlyPayment));
            TotalPayment.setText(String.format("%.2f", totalPayment));
            welcomeText.setText("Calculation Complete!");

        } catch (NumberFormatException e) {
            welcomeText.setText("Invalid input!");
        }
    }
}
