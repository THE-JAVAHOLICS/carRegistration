
package org.example;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;

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
        /*String css = App.class.getResource("newCSS.css").toExternalForm();
        root.getStylesheets().add(css);*/
        signingInStage.setScene(new Scene(root,900,600));
        signingInStage.show();
    }

    @FXML
    private Button accountManage;

    @FXML
    public void accountManagement(ActionEvent event) throws Exception {
        menuItem(event);
    }

    @FXML
    private Button addACarButton;

    @FXML
    public void addingACar(ActionEvent event) throws Exception{
     menuItem(event);
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
        Stage newRegisterStage = (Stage) topMenu.getScene().getWindow();
        newRegisterStage.setScene(new Scene(root, 900, 600));
        newRegisterStage.show();

    }

    @FXML
    private MenuItem accountManager;

    @FXML
    private MenuItem addCars;

    @FXML
    private MenuItem viewMyCars;

    @FXML
    private MenuItem loggingOut1;


    @FXML
    BorderPane mainPane;


    @FXML
    private MenuButton topMenu;

    @FXML
    public void menuItem(ActionEvent event) throws Exception {
        if (event.getSource() == loggingOut1) {
           logOut();
        } else if(event.getSource() == accountManager || event.getSource() == accountManage){

            System.out.println("You clicked accountManagement");
            Pane view = getPage("accountManagement");
            mainPane.setCenter(view);

        }else if(event.getSource() == addCars || event.getSource()==addACarButton) {

            System.out.println("You clicked addCars");
            Pane view = getPage("addingAcar");
            mainPane.setCenter(view);
        }

    }




    private Pane view;

    @FXML
    public Pane getPage(String fileName) {
        try {
            URL fileUrl = Controller.class.getResource("/org/example/"+fileName+".fxml");
            if (fileUrl == null) {
                throw new java.io.FileNotFoundException("FXML file can't be found");
            }
            view =new FXMLLoader().load(fileUrl);
        } catch (Exception e){
            System.out.println("No page " + fileName + " please check FxmlLoader.");
        }

        return view;

    }





}
