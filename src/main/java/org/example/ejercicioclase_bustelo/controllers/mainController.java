package org.example.ejercicioclase_bustelo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import org.example.ejercicioclase_bustelo.SceneNavigator;

import java.net.URL;
import java.util.ResourceBundle;

public class mainController implements Initializable {

    @FXML
    private TableColumn columnFecha;
    @FXML
    private TableColumn columnId;
    @FXML
    private Button btnNuevo;
    @FXML
    private TableColumn columnEstado;
    @FXML
    private TableColumn columnNombre;

    @FXML
    private void initialize() {

    }

    @FXML
    public void onNuevoRegistroClick(ActionEvent actionEvent) {
        SceneNavigator.navigateTo("createView.fxml", "Create");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        columnNombre.setCellValueFactory(row);
    }
}
