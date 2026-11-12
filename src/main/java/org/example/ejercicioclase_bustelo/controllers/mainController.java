package org.example.ejercicioclase_bustelo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.example.ejercicioclase_bustelo.SceneNavigator;
import org.example.ejercicioclase_bustelo.data.DataSourceFactory;
import org.example.ejercicioclase_bustelo.data.RegistroJdbcDAO;
import org.example.ejercicioclase_bustelo.models.Registro;

import java.net.URL;
import java.util.ResourceBundle;

public class mainController implements Initializable {

    @FXML
    private TableColumn<Registro,String> columnId;
    @FXML
    private Button btnNuevo;
    @FXML
    private TableColumn<Registro,String> columnEstado;
    @FXML
    private TableColumn<Registro,String> columnNombre;
    @FXML
    private TableColumn<Registro,String> columnCategoria;
    @FXML
    private TableView tabla;

    @FXML
    private void initialize() {

    }

    @FXML
    public void onNuevoRegistroClick(ActionEvent actionEvent) {
        SceneNavigator.navigateTo("createView.fxml", "Create");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        columnId.setCellValueFactory(row->{
            Registro registro = row.getValue();
            Long id = registro.getId();
            return new javafx.beans.property.SimpleStringProperty(String.valueOf(id));
        });
        columnNombre.setCellValueFactory(row->{
            Registro registro = row.getValue();
            String nombre = registro.getNombre();
            return new javafx.beans.property.SimpleStringProperty(nombre);
        });
        columnCategoria.setCellValueFactory(row->{
            Registro registro = row.getValue();
            String categoria = registro.getCategoria();
            return new javafx.beans.property.SimpleStringProperty(categoria);
        });
        columnEstado.setCellValueFactory(row->{
            boolean disponible = row.getValue().getDisponible();
            String estado = disponible? "Disponible":"No disponible";
            return new javafx.beans.property.SimpleStringProperty(estado);
        });

        RegistroJdbcDAO dao = new RegistroJdbcDAO(DataSourceFactory.getDataSource());
        dao.findAll().forEach(result->{;
            System.out.println(result);
            tabla.getItems().add(result);
            });
        }
    }

