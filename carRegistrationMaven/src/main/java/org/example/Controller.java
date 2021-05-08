
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
    Hyperlink noAccountClick;

    @FXML
    private Button signIn;

    @FXML
    private Button accountManage;

    @FXML
    private Button addACarButton;

    @FXML
    private PasswordField password_main;

    @FXML
    private TextField usernam_main;


    @FXML
    private Button loggingOut;

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
    public void addingACar(ActionEvent event) throws Exception{
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
        } else if(event.getSource() == accountManagement_Menu || event.getSource() == accountManage){

            Parent view = getPage("accountManagement", event);
            mainPane.setCenter(view);
        }else if(event.getSource() == addCars_Menu || event.getSource()==addACarButton) {

            Parent view = getPage("addingAcar",event);
            mainPane.setCenter(view);
        }else if(event.getSource() == viewMyCars_Menu){

            Parent view = getPage("viewingCars",event);
            mainPane.setCenter(view);
        }

    }


    private Parent view;
    @FXML
    public Parent getPage(String fileName, ActionEvent event) {
        try {
            System.out.println("1");
            FXMLLoader fileUrl = new FXMLLoader(getClass().getResource(fileName+".fxml"));
            System.out.println("2");
            if (fileUrl == null) {
                throw new java.io.FileNotFoundException("FXML file can't be found");
            }
            System.out.println("3");
            view = fileUrl.load();
            System.out.println("4");
            if(event.getSource() == addCars_Menu) {
                Car car = fileUrl.getController();
                car.personUser = topMenu.getText();
            }else if(event.getSource() == viewMyCars_Menu){
                ViewCars viewCars = fileUrl.getController();
                viewCars.setCarNames(topMenu.getText());
            }

        } catch (Exception e){
            System.out.println("No page " + fileName + " please check FxmlLoader.");
        }

        return view;

    }


/*

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
                JOptionPane.showMessageDialog(null, "Username And Password is correct");
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
*/
}
