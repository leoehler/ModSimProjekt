package de.lingen.modsim.controllers;

import de.lingen.modsim.Simulation;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private Simulation simulation;

    @FXML
    private Rectangle  rect;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        simulation = Simulation.getInstance();
    }

    @FXML
    private void hello() {
        simulation.next();
    }

    public Rectangle getRect() {
        return rect;
    }
}
