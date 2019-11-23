package de.lingen.modsim;

import de.lingen.modsim.controllers.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    private Simulation simulation;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() {
        simulation = Simulation.getInstance();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("gui/mainWindow.fxml"));

        stage.setScene(new Scene(fxmlLoader.load()));

        Controller controller = fxmlLoader.getController();

        simulation.setRectangle(controller.getRect());

        stage.show();
    }

}
