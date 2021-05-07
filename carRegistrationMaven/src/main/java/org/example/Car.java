
package org.example;

import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import java.sql.*;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.ScatterChart;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Car<WebView> implements Initializable {


    @FXML
    private BorderPane mainPane;


    @FXML
    private TextField usernam_main;

    @FXML
    private Button saveChanges;

    @FXML
    private ComboBox<Character> carCode;

    @FXML
    private TextField carNumber;


    @FXML
    private MenuButton topMenu;

    @FXML
    BorderPane borderPane;

    @FXML
    private TextField username_car;

    public Car() {
    }




    @FXML
    private ComboBox<String> carTypeBox;

    @FXML
    private ComboBox<String> carModel;
    @FXML
    private ComboBox<String> carColor;

    @FXML
    private ComboBox<String> carCity;
    @FXML
    private TextField CarChassis;

    /*@Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList carTypeList = FXCollections.observableArrayList("Ferrari", "Toyota","lamb","");
        carTypeBox.setItems(carTypeList);

        ObservableList carColorList = FXCollections.observableArrayList("Bronze", "Red", "Gold", "Silver", "White", "Black");
        carColor.setItems(carColorList);

        ObservableList carCityList = FXCollections.observableArrayList("Abu Dhabi", "Dubai", "Sharjah", "Umm al-Qaiwain", "Fujairah", "Ajman", "Ra's al-Khaimah");
        carCity.setItems(carCityList);

        ObservableList carAlphaList = FXCollections.observableArrayList(alphabeticalGenerator());
        carCode.setItems(carAlphaList);


    }
*/


    public List<Character> alphabeticalGenerator(){
        List<Character> characters = new ArrayList<>();
        int num = 65;
        for(int i = 0;i < 26; i++){
            characters.add((char)num);
            num++;
        }
        return characters;
    }

    @FXML
    public void carType(){
        String selected = carTypeBox.getSelectionModel().getSelectedItem();
        System.out.println(selected);
        carModel(selected);
    }

    public void carModel(String carSelected){
        switch(carSelected){
            case "Ferrari":
            {
                ObservableList carList = FXCollections.observableArrayList("812 Superfast", "812 GTS", "SF90 Stradle");
                carModel.setItems(carList);
                break;
            }
            case "Toyota":
                ObservableList carList = FXCollections.observableArrayList("Avalon", "Land cruiser","Corolla");
                carModel.setItems(carList);
                break;
        }

    }
    @FXML
    private Text numberError;
    String name;
    public void saveChanges() throws Exception{
        try {
            System.out.println(name);
            if (Integer.parseInt(carNumber.getText()) <= 99999 && Integer.parseInt(carNumber.getText()) > 0) {
                System.out.println(Integer.parseInt(carNumber.getText()));
                numberError.setText(null);
            }else{
                numberError.setText("Please type a valid number");
            }
        }catch (Exception e){
            numberError.setText("Please type a number");
        }


    }




    ValidationSupport valid = new ValidationSupport();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList carTypeList = FXCollections.observableArrayList("Ferrari", "Toyota","lamb","");
        carTypeBox.getItems().addAll(carTypeList);

        ObservableList carColorList = FXCollections.observableArrayList("Bronze", "Red", "Gold", "Silver", "White", "Black");
        carColor.getItems().addAll(carColorList);

        ObservableList carCityList = FXCollections.observableArrayList("Abu Dhabi", "Dubai", "Sharjah", "Umm al-Qaiwain", "Fujairah", "Ajman", "Ra's al-Khaimah");
        carCity.getItems().addAll(carCityList);

        ObservableList carAlphaList = FXCollections.observableArrayList(alphabeticalGenerator());
        carCode.getItems().addAll(carAlphaList);

        valid.registerValidator(carNumber, Validator.createEmptyValidator("Text Required") );

    }
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    PreparedStatement pst_id = null;
    public void saveChanges(ActionEvent event) throws Exception {
        conn = mySqlConnect.ConnectDb();

        String sql ="INSERT INTO `cars`(`Car type`, `model`, `Plate code`, `Plate number`, `Color`, `City`, `Chassis`, `username`)" +
                " VALUES (?,?,?,?,?,?,?,?)";
       // String sql_id = "SELECT user_id FROM users WHERE ";

        try {
        //    pst_id=conn.prepareStatement(sql_id);
          //  ResultSet rs_id = pst_id.executeQuery(sql_id);
           // while(rs_id.next()) {
                //Retrieve by column name
            //    int id = rs_id.getInt("user_id");
                //Display values
            //    System.out.print("ID: " + id);
              //  if (true) {
                    pst = conn.prepareStatement(sql);
                    pst.setString(1, carTypeBox.getValue().toString());
                    pst.setString(2, carModel.getValue().toString());
                    pst.setString(3, carCode.getValue().toString());
                    pst.setString(4, carNumber.getText());
                    pst.setString(5, carColor.getValue().toString());
                    pst.setString(6, carCity.getValue().toString());
                    pst.setString(7, CarChassis.getText());
                    pst.setString(8, name );
                    pst.execute();
               // }
             //   break;
          //  }
          //  int val =  ((Number) rs_id.getObject(1)).intValue();
          //  rs_id.close();
            JOptionPane.showMessageDialog(null, "Saved");
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }



}