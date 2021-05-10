
package org.example;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.swing.text.View;


public class Controller {

    @FXML
    private Button accountManage;

    @FXML
    private Button addACarButton;


    @FXML
    private MenuItem accountManagement_Menu;

    @FXML
    private MenuItem addCars_Menu;

    @FXML
    private MenuItem viewMyCars_Menu;

    @FXML
    private MenuItem loggingOut_Menu;


    @FXML
    BorderPane mainPane;


    @FXML
    private MenuButton topMenu;

    public void setTopMenu(String text) {
        topMenu.setText(text);
    }

    @FXML
    public void accountManagement(ActionEvent event) throws Exception {
        menuItem(event);
    }

    @FXML
    public void addingACar(ActionEvent event) throws Exception {
        menuItem(event);
    }


    @FXML
    public void logOut() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        Stage newRegisterStage = (Stage) topMenu.getScene().getWindow();
        newRegisterStage.setScene(new Scene(root, 900, 600));
        newRegisterStage.show();

    }


    @FXML
    public void menuItem(ActionEvent event) throws Exception {

        if (event.getSource() == loggingOut_Menu) {
            logOut();
        } else if (event.getSource() == accountManagement_Menu || event.getSource() == accountManage) {

            Parent view = getPage("accountManagement", event);
            mainPane.setCenter(view);
        } else if (event.getSource() == addCars_Menu || event.getSource() == addACarButton) {

            Parent view = getPage("addingAcar", event);
            mainPane.setCenter(view);
        } else if (event.getSource() == viewMyCars_Menu) {

            Parent view = getPage("viewingCars", event);
            mainPane.setCenter(view);
        }

    }


    private Parent view;

    @FXML
    public Parent getPage(String fileName, ActionEvent event) {
        try {
            FXMLLoader fileUrl = new FXMLLoader(getClass().getResource(fileName + ".fxml"));
            if (fileUrl == null) {
                throw new java.io.FileNotFoundException("FXML file can't be found");
            }
            view = fileUrl.load();
            if (event.getSource() == addCars_Menu) {
                Car car = fileUrl.getController();
                car.personUser = topMenu.getText();
            } else if (event.getSource() == viewMyCars_Menu) {
                ViewCars viewCars = fileUrl.getController();
                viewCars.setCarNames(topMenu.getText());
            }

        } catch (Exception e) {
            System.out.println("No page " + fileName + " please check FxmlLoader.");
        }

        return view;

    }
}
