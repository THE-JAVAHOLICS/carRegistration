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
    @FXML
    public void signingIn() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("signingIn.fxml"));
        Stage signingInStage = (Stage) signIn.getScene().getWindow();
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
    private Button loggingOut;
    @FXML
    public void logOut() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        Stage newRegisterStage = (Stage) loggingOut.getScene().getWindow();
        newRegisterStage.setScene(new Scene(root, 900, 600));
        newRegisterStage.show();

    }

}
