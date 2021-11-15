/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Andrew Hicks
 */

package ucf.assignments;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.stage.Stage;


import java.io.IOException;

public class ToDoListApplication extends Application {
    private final SceneOperator sceneOperator = new SceneOperator();

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = sceneOperator.readyScene(Views.MAIN);
        sceneOperator.popUpScene("To Do Lists", root);
    }

    public static void main(String[] args) {
        launch();
    }
}