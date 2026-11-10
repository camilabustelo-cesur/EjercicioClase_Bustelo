package org.example.ejercicioclase_bustelo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.example.ejercicioclase_bustelo.SceneNavigator;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @javafx.fxml.FXML
    private Button btnLoginClick;

    @javafx.fxml.FXML
    public void onLoginClick(ActionEvent actionEvent) {
        SceneNavigator.navigateTo("mainView.fxml", "Main");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
