package de.lingen.modsim.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.net.URL;

public interface IView {

    Parent getScene();

    default Parent loadScene(final String view) throws IOException {
        final URL url = getClass().getResource(view);
        return (Parent) FXMLLoader.load(url);
    }
}
