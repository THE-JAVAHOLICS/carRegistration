package org.example;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import impl.org.controlsfx.*;
import org.controlsfx.validation.ValidationResult;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import java.net.URL;
import java.util.ResourceBundle;


public class accountManagement implements Initializable {

    @FXML
    private TextField ID_Username;

    @FXML
    private TextField ID_Password;

    @FXML
    private TextField ID_PasswordConfirm;

    @FXML
    private CheckBox ID_Username_Check;

    @FXML
    private CheckBox ID_Email_Check;

    @FXML
    private CheckBox ID_Password_Check;

    ValidationSupport validationSupport = new ValidationSupport();

    @FXML
    void saveChanges(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        validationSupport.registerValidator(ID_Password, Validator.createEmptyValidator("Password Required") );



        validationSupport.registerValidator(ID_PasswordConfirm, Validator.createEmptyValidator("Confirm Password") );

        validationSupport.registerValidator(ID_Username, Validator.createEmptyValidator("Username Required") );

        validationSupport.registerValidator(ID_Username_Check, (Control c, Boolean newValue) ->
                ValidationResult.fromErrorIf(c, "checkbox should be checked", !newValue));

        validationSupport.registerValidator(ID_Email_Check, (Control c, Boolean newValue) ->
                ValidationResult.fromErrorIf(c, "checkbox should be checked", !newValue));

        validationSupport.registerValidator(ID_Password_Check, (Control c, Boolean newValue) ->
                ValidationResult.fromErrorIf(c, "checkbox should be checked", !newValue));





    }
}
