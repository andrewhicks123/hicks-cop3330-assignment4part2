/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Andrew Hicks
 */

package ucf.assignments;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditItemController {
    @FXML
    private TextField itemDescriptionTextField;
    @FXML
    private TextField itemDueDateTextField;
    @FXML
    private Button editItemOkButton;
    @FXML
    private Button editItemCancelButton;
    private Item item;

    public void initialize(Item item){
        this.item = item;
        itemDescriptionTextField.setText(item.getDescription());
        itemDueDateTextField.setText(item.getDueDate());
    }
    @FXML
    public void editItemOkButtonPressed(){
        item.setDescription(itemDescriptionTextField.getText());
        item.setDueDate(itemDueDateTextField.getText());
        Stage stage = (Stage) editItemOkButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void editItemCancelButtonPressed(){
        Stage stage = (Stage) editItemCancelButton.getScene().getWindow();
        stage.close();
    }

}
