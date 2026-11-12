package org.example.ejercicioclase_bustelo.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.example.ejercicioclase_bustelo.SceneNavigator;
import org.example.ejercicioclase_bustelo.models.Registro;

import java.net.URL;
import java.util.ResourceBundle;

public class createController implements Initializable {

    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnCancelar;
    @FXML
    private Spinner campoId;
    @FXML
    private CheckBox campoDisponible;
    @FXML
    private ChoiceBox campoCategoria;
    @FXML
    private TextField campoNombre;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        campoId.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000, 0,1));

        ObservableList<String> categoria = FXCollections.observableArrayList();
        categoria.add("Computadora");
        categoria.add("Teléfono");
        categoria.add("Tablet");
        campoCategoria.setItems(categoria);
        campoCategoria.getSelectionModel().selectFirst();

    }

    @FXML
    public void onCancelarClick(ActionEvent actionEvent) {
        SceneNavigator.navigateTo("mainView.fxml","MainView");

    }

    @FXML
    public void onGuardarClick(ActionEvent actionEvent) {
        if (campoNombre.getText().isEmpty() || campoCategoria.getValue() == null) {
            return;
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Guardar");
        alert.setHeaderText("Datos guardados correctamente");

        String nombre = campoNombre.getText();
        String categoria = campoCategoria.getValue().toString();
        String estado = campoDisponible.isSelected() ? "Disponible" : "No disponible";


        alert.setContentText(nombre + " " + categoria + " " + estado);
        alert.showAndWait();
        campoNombre.clear();

        Registro registro = new Registro();
        registro.setNombre(nombre);
        registro.setCategoria(categoria);
        registro.setId(Long.valueOf(campoId.getValue().toString()));
        registro.setDisponible(campoDisponible.isSelected());

        SceneNavigator.navigateTo("mainView.fxml", "MainView");

    }


}
