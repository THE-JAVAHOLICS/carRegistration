
package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.swing.*;

public class Controller {

    @FXML
    Hyperlink noAccountClick;
    @FXML
    public void noAccount() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("newRegistration.fxml"));
        Stage newRegisterStage = (Stage) noAccountClick.getScene().getWindow();
        newRegisterStage.setScene(new Scene(root,900,600));
        newRegisterStage.show();

    }


    @FXML
    private Button signIn;

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    @FXML
    private void signingIn (ActionEvent event) throws Exception{
        conn = mySqlConnect.ConnectDb();
        String sql = "Select * from users where username = ? and password = ? ";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, usernam_main.getText());
            pst.setString(2, password_main.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Username And Password is corect");
                signIn.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("signingIn.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();

            } else
                JOptionPane.showMessageDialog(null, "Invalid Username or Password ");
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }



    @FXML
    public void signingIn() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("signingIn.fxml"));
        Stage signingInStage = (Stage) signIn.getScene().getWindow();
        /*String css = App.class.getResource("newCSS.css").toExternalForm();
        root.getStylesheets().add(css);*/
        signingInStage.setScene(new Scene(root,900,600));
        signingInStage.show();
    }



    @FXML
    private Button addACarButton;

    @FXML
    public void addingACar() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("addingACar.fxml"));
        Stage carAdd = (Stage) addACarButton.getScene().getWindow();
        carAdd.setScene(new Scene(root,900,600));
        carAdd.show();
    }

     @FXML
    private PasswordField password_main;
     
    @FXML
    private TextField usernam_main;

    
    @FXML
    private Button loggingOut;
    @FXML
    public void logOut() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        Stage newRegisterStage = (Stage) loggingOut.getScene().getWindow();
        newRegisterStage.setScene(new Scene(root, 900, 600));
        newRegisterStage.show();

    }

}
