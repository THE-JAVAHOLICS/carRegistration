
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

import javax.swing.*;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pst = null;

    public void registerAction(ActionEvent event) throws Exception {
        conn = mySqlConnect.ConnectDb();
        String sql ="INSERT INTO `users`(`username`, `password`, `email`, `Surname`, `First name`, `Nationality`) VALUES (?,?,?,?,?,?)";

        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, usernameReg.getText());
            pst.setString(2, passwordReg.getText());
            pst.setString(3, emailReg.getText());
            pst.setString(4, surNameReg.getText());
            pst.setString(5, firstNameReg.getText());
            pst.setString(6, nationalityReg.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Saved");
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    cancelAction();
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



}