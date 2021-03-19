package me.byaz.launcher.scenes;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public abstract class AbstractScene {

    /* This is the scene's main pane */

    protected Pane pane = new Pane();

    /* This is the scene */

    protected Scene scene = new Scene(new Group(pane));

    /* This is the abstract method that will have to register every pane's component */

    public abstract void registerNodes();

    /* This is the getter of the scene */

    public Scene getScene(){
        return this.scene;
    }

    /* This is the getter of the pane */

    public Pane getPane(){
        return this.pane;
    }
}
