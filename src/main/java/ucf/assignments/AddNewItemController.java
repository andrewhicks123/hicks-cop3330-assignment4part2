/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Andrew Hicks
 */

package ucf.assignments;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddNewItemController {
    @FXML private TextField itemDescriptionTextField;
    @FXML private TextField itemDueDateTextField;
    @FXML private Button addNewItemOkButton;
    @FXML private Button addNewItemCancelButton;
    private Item newItem;

    public void initialize(Item item) {
        this.newItem = item;
    }

    @FXML
    public void addNewItemOkButtonPressed(){
        newItem.setDescription(itemDescriptionTextField.getText());
        newItem.setDueDate(itemDueDateTextField.getText());
        Stage stage = (Stage) addNewItemOkButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void addNewItemCancelButtonPressed(){
        Stage stage = (Stage) addNewItemCancelButton.getScene().getWindow();
        stage.close();
    }
}
