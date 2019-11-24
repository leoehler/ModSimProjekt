package de.lingen.modsim.controller;

import de.lingen.modsim.model.IModel;
import de.lingen.modsim.model.Model;
import de.lingen.modsim.view.IView;
import javafx.scene.control.Button;

public class Controller implements IController {
    private final IView scene;
    private final Model model;

    public Controller(IView view, Model model) {
       scene = view;
       this.model = model;

       init();
    }

    private void init() {
        ((Button) scene.getScene().lookup("#btMove")).setOnAction(e -> System.out.println(model.hello()));
    }
}
