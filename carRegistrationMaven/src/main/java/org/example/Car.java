package org.example;

import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.ScatterChart;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Car<WebView> implements Initializable{



    @FXML
    private Button car1;

    @FXML
    private Button car2;

    @FXML
    private Button car3;

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

    public Car() {
    }

    @FXML
    public void logOut() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        Stage loggingOut = (Stage) topMenu.getScene().getWindow();
        loggingOut.setScene(new Scene(root,900,600));
        loggingOut.show();

    }

    public void viewMyCars(){
        borderPane.setCenter(new Label("ME"));
    }

    public void manageAccount() throws Exception {

//        Parent root = FXMLLoader.load(getClass().getResource("manageAccount.fxml"));
//        Stage managingAccount = (Stage) topMenu.getScene().getWindow();
//        managingAccount.setScene(new Scene(root, 900, 600));
//        managingAccount.show();
    }

    @FXML
    public void addACar() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("addingACar.fxml"));
        Stage addingCars = (Stage) topMenu.getScene().getWindow();
        addingCars.setScene(new Scene(root, 900, 600));
        addingCars.show();
    }


    @FXML
    private ComboBox<String> carTypeBox;

    @FXML
    private ComboBox<String> carModel;
    @FXML
    private ComboBox<String> carColor;

    @FXML
    private ComboBox<String> carCity;

    @Override
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

    public void saveChanges() throws Exception{
        try {
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

}