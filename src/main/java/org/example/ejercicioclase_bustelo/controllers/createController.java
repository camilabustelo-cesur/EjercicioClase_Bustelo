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
    private TextField tfNombre;
    @FXML
    private TextArea taDescripcion;
    @FXML
    private Button btnCancelar;
    @FXML
    private DatePicker dateFecha;
    @FXML
    private ChoiceBox<String> pickEstado;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> estados = FXCollections.observableArrayList();
        pickEstado.setItems(estados);
        estados.add("Disponible");
        estados.add("No disponible");
        pickEstado.getSelectionModel().selectFirst();

    }

    @FXML
    public void onCancelarClick(ActionEvent actionEvent) {
        SceneNavigator.navigateTo("mainView.fxml","MainView");

    }

    @FXML
    public void onGuardarClick(ActionEvent actionEvent) {
        if (tfNombre.getText().isEmpty() || dateFecha.getValue() == null || pickEstado.getValue() == null) {
            return;
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Guardar");
        alert.setHeaderText("Datos guardados correctamente");

        String nombre = tfNombre.getText();
        String descripcion = taDescripcion.getText();
        String fecha = dateFecha.getValue().toString();
        String estado = pickEstado.getValue();

        alert.setContentText(nombre + " " + descripcion + " " + fecha + " " + estado);
        alert.showAndWait();
        tfNombre.clear();

        Registro registro = new Registro();
        registro.setNombre(nombre);
        registro.setDescripcion(descripcion);
        registro.setFecha(fecha);
        registro.setEstado(estado);

    }


}
