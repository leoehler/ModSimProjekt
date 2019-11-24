package de.lingen.modsim;

import de.lingen.modsim.controller.Controller;
import de.lingen.modsim.model.Model;
import de.lingen.modsim.view.MainWindow;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {

    private MainWindow mainWindow;
    private Model      model;
    private Controller controller;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws IOException {
        mainWindow = new MainWindow();
        model = new Model();
        controller = new Controller(mainWindow, model);

        mainWindow.setController(controller);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(mainWindow.getScene()));

        stage.show();
    }

}
