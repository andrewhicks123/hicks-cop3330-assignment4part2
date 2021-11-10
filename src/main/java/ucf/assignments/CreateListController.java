/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Andrew Hicks
 */


package ucf.assignments;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class CreateListController {
    @FXML private TextField newListNameTextField;
    @FXML private Button newListOkButton;
    @FXML private Button newListCancelButton;

    private ToDoList newList;

    @FXML
    public void newListOkButtonPressed(){
        newList.setName(newListNameTextField.getText());

        System.out.println(newListNameTextField.getText());

        Stage stage = (Stage) newListOkButton.getScene().getWindow();

        stage.close();

    }

    @FXML
    public void newListCancelButtonPressed(){
        Stage stage= (Stage) newListCancelButton.getScene().getWindow();
        stage.close();
    }

    public void initalize(ToDoList list) {
        newList = list;
    }
}
