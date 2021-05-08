package org.example;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewCars {
//    String personUser;
    @FXML
    public Text car1;

    @FXML
    public Text car2;

    @FXML
    public Text car3;

    void setCarNames(String personUser){

        car1.setText(personUser);

    }



}
