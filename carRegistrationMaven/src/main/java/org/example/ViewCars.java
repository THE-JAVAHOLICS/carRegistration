package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import javax.swing.*;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class ViewCars {
    String personUser;

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


    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    PreparedStatement pst_id = null;

    public void setCarNames(String personUser) throws Exception {
        conn = mySqlConnect.ConnectDb();
        String sql =("SELECT Car type, model, Plate code FROM cars WHERE username= '" + personUser + "'");
        try {
            String query =("SELECT * FROM cars WHERE username= '" + personUser + "'");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            int i = 1;
            while (rs.next()) {
                String carType = rs.getString("Car type");
                String model = rs.getString("model");
                String code = rs.getString("Plate code");
                String PlateNumber = rs.getString("Plate number");
                String Color = rs.getString("Color");
                String City = rs.getString("City");

                if(i == 1) {
                    settingCar2(carType, model, code, PlateNumber, Color, City);
                }else if(i == 2){
                    settingCar3(carType, model, code, PlateNumber, Color, City);
                }else if(i == 3){
                    settingCar1(carType, model, code, PlateNumber, Color, City);

                }

                i++;
            }
            st.close();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }finally {
            try{
                if (conn !=null){
                    conn.close();}
                }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }


    private void settingCar1(String carType, String carModel, String plateCode,
                             String plateNumber,String carColor,String city ){
        this.carType_1.setText(carType);
        this.carModel_1.setText(carModel);
        this.plateCode_1.setText(plateCode);
        this.plateNumber_1.setText(plateNumber);
        this.carColor_1.setText(carColor);
        this.carCity_1.setText(city);

    }

    private void settingCar2(String carType, String carModel, String plateCode,
                             String plateNumber,String carColor,String city ){
        this.carType_2.setText(carType);
        this.carModel_2.setText(carModel);
        this.plateCode_2.setText(plateCode);
        this.plateNumber_2.setText(plateNumber);
        this.carColor_2.setText(carColor);
        this.carCity_2.setText(city);

    }

    private void settingCar3(String carType, String carModel, String plateCode,
                             String plateNumber,String carColor, String city ){
        this.carType_3.setText(carType);
        this.carModel_3.setText(carModel);
        this.plateCode_3.setText(plateCode);
        this.plateNumber_3.setText(plateNumber);
        this.carColor_3.setText(carColor);
        this.carCity_3.setText(city);

    }

}
