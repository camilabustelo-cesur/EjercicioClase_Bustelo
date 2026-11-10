package org.example.ejercicioclase_bustelo;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        SceneNavigator.setStage(stage);
        SceneNavigator.navigateTo("loginView.fxml","Login");
        stage.show();
    }
}
