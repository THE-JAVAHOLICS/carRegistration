package org.example;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class SignInController {
    @FXML
    private TextField usernam_main;
    @FXML
    private PasswordField password_main;
    @FXML
    private Button signIn;

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pst = null;

        @FXML
        private void signingIn (ActionEvent event) throws Exception {
            conn = mySqlConnect.ConnectDb();

            String sql = "Select * from users where username = ? and password = ? ";
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1, usernam_main.getText());
                pst.setString(2, password_main.getText());
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Username And Password is correct");
                    String name = usernam_main.getText();
                    System.out.println(name);
                    signIn.getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/signingIn.fxml"));
                    Parent root = (Parent) loader.load();
                    Controller setController = loader.getController();
                    setController.setTopMenu(usernam_main.getText());
                    Stage signingInStage = (Stage) signIn.getScene().getWindow();
                    signingInStage.setScene(new Scene(root, 900, 600));
                    signingInStage.show();

                } else
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password ");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

        @FXML
        Hyperlink noAccountClick;
        @FXML
        public void noAccount () throws Exception {
            Parent root = FXMLLoader.load(getClass().getResource("newRegistration.fxml"));
            Stage newRegisterStage = (Stage) noAccountClick.getScene().getWindow();
            newRegisterStage.setScene(new Scene(root, 900, 600));
            newRegisterStage.show();
        }
    }

