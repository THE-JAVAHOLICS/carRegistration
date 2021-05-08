package org.example;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewCars {


    @FXML
    private Text carType_1;

    @FXML
    private Text carModel_1;

    @FXML
    private Text plateCode_1;

    @FXML
    private Text plateNumber_1;

    @FXML
    private Text carColor_1;

    @FXML
    private Text carChassis_1;

    @FXML
    private Text carCity_1;

    @FXML
    private Text carType_2;

    @FXML
    private Text carModel_2;

    @FXML
    private Text plateCode_2;

    @FXML
    private Text plateNumber_2;

    @FXML
    private Text carChassis_2;

    @FXML
    private Text carCity_2;

    @FXML
    private Text carColor_2;

    @FXML
    private Text carType_3;

    @FXML
    private Text carModel_3;

    @FXML
    private Text plateCode_3;

    @FXML
    private Text plateNumber_3;

    @FXML
    private Text carColor_3;

    @FXML
    private Text carCity_3;

    @FXML
    private Text carChassis_3;

    void setCarNames(String personUser){

        carType_1.setText(personUser);

    }


}
