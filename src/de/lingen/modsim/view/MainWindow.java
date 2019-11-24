package de.lingen.modsim.view;

import de.lingen.modsim.controller.Controller;
import javafx.scene.Parent;

import java.io.IOException;

public class MainWindow implements IView {
    private static final String     MAIN_WINDOW_VIEW = "/de/lingen/modsim/view/mainWindow.fxml";
    private final        Parent     scene;
    private              Controller controller;

    public MainWindow() throws IOException {
        scene      = loadScene(MAIN_WINDOW_VIEW);
    }

    @Override
    public Parent getScene() {
        return scene;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
