/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Andrew Hicks
 */
package ucf.assignments;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditListTitleController {
    @FXML
    private TextField editListTitleTextField;
    @FXML
    private Button editListTitleOkButton;
    @FXML
    private Button editListTitleCancelButton;

    private ToDoList newList;

    public void initialize(ToDoList newList){
        this.newList = newList;
        editListTitleTextField.setText(newList.getName());
    }
    @FXML
    public void editListTitleOkButtonPressed(){
        newList.setName(editListTitleTextField.getText());
        Stage stage = (Stage) editListTitleOkButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void editListTitleCancelButtonPressed(){
        Stage stage = (Stage) editListTitleOkButton.getScene().getWindow();
        stage.close();
    }
}
