package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.text.DateFormat;
import java.time.LocalDate;

public class Personal {
    private LocalDate registrationDate = java.time.LocalDate.now();
    private DateFormat dateOfBirth;

    @FXML
    private TextField usernameReg;

    @FXML
    private TextField emailReg;

    @FXML
    private TextField surNameReg;

    @FXML
    private TextField firstNameReg;

    @FXML
    private PasswordField passwordReg;

    @FXML
    private TextField nationalityReg;


    @FXML
    private Button registrationButton;

    public void registerAction() throws Exception {
        printing();
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        Stage newRegisterStage = (Stage) registrationButton.getScene().getWindow();
        newRegisterStage.setScene(new Scene(root, 700, 450));

    }

    @FXML
    private Button cancelButton;

    public void cancelAction() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        Stage newRegisterStage = (Stage) cancelButton.getScene().getWindow();
        newRegisterStage.setScene(new Scene(root, 700, 450));

    }

    public void filePrinting() {
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream("registration.txt"), false);
            pw.write("\nRegistration date: " + registrationDate +
                    "\nUsername: " + usernameReg.getText() +
                    "\nemail: " + emailReg.getText() +
                    "\nsurname: " + surNameReg.getText() +
                    "\nfirst name: " + firstNameReg.getText() +
                    "\npassword: " + passwordReg.getText() +
                    "\nnationality: " + nationalityReg.getText());
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void printing() {
        if (usernameReg.getText().equals(""))
            System.out.println("please fill");
        System.out.println("Registration date: " + registrationDate +
                "\nUsername: " + usernameReg.getText() +
                "\nemail: " + emailReg.getText() +
                "\nsurname: " + surNameReg.getText() +
                "\nfirst name: " + firstNameReg.getText() +
                "\npassword: " + passwordReg.getText() +
                "\nnationality: " + nationalityReg.getText());
        filePrinting();
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public DateFormat getDateOfBirth() {
        return dateOfBirth;
    }

    public TextField getUsernameReg() {
        return usernameReg;
    }

    public TextField getEmailReg() {
        return emailReg;
    }

    public TextField getSurNameReg() {
        return surNameReg;
    }

    public TextField getFirstNameReg() {
        return firstNameReg;
    }

    public PasswordField getPasswordReg() {
        return passwordReg;
    }

    public TextField getNationalityReg() {
        return nationalityReg;
    }

    public Button getRegistrationButton() {
        return registrationButton;
    }

    public Button getCancelButton() {
        return cancelButton;
    }

}