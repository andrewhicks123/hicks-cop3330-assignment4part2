/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Andrew Hicks
 */

package ucf.assignments;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ToDoListController {

    @FXML
    private Button HomeButton;
    @FXML
    private Button AddItemButton;
    @FXML
    private Button EditItemButton;
    @FXML
    private Button DeleteItemButton;
    @FXML
    private Button ClearListButton;
    @FXML
    private Button ChangeStatusButton;
    @FXML
    private Button ViewAllButton;
    @FXML
    private Button ViewCompletedButton;
    @FXML
    private Button ViewIncompletedButton;

    @FXML
    private Label welcomeText;
    @FXML
    private TableView<Item> toDoListItemsView;

    public ToDoList list = new ToDoList();

    private final ItemTableBuilder tableOperator = new ItemTableBuilder();
    private final SceneOperator sceneOperator = new SceneOperator();

    public void initialize(){
        welcomeText.setText(list.getName());

        tableOperator.setTable(toDoListItemsView);
        tableOperator.buildTable();
        toDoListItemsView = tableOperator.getTable();

    }
    public void setViewList(ToDoList list){
        // set list in controller to list
        this.list = list;
        // set label on page to list title
        welcomeText.setText(list.getName());
        // clear view
        toDoListItemsView.getItems().clear();
        // tell operator what table to operate on
        tableOperator.setTable(toDoListItemsView);
        // load the table
        tableOperator.loadTable(list.getList());

    }
    public ToDoList getList(){

        return list;
    }
    @FXML
    public void HomeButtonPressed(){
        // close list screen
        Stage stage = (Stage) HomeButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void AddItemButtonPressed() {
        // create new item
        Item newItem = new Item();

        Parent page = sceneOperator.readyScene(Views.ADDITEM);

        // get controller
        AddNewItemController addNewItemController = sceneOperator.getLoader().getController();
        // initalize controller
        addNewItemController.initialize(newItem);
        // pop up text box
        sceneOperator.popUpScene("Add Item", page);
        // add item to items of list
        list.addItem(newItem);
        // refresh table
        toDoListItemsView.getItems().add(newItem);


    }
    @FXML
    public void DeleteItemButtonPressed() {
        // get selection
        Item selectedItem = toDoListItemsView.getSelectionModel().getSelectedItem();
        // delete item
        list.deleteItem(selectedItem.getDescription());
        // remove item from table
        toDoListItemsView.getItems().removeAll(selectedItem);
    }
    @FXML
    public void EditItemButtonPressed() {
        // get selected item
        Item selectedItem = toDoListItemsView.getSelectionModel().getSelectedItem();
        // delete item from list
        list.deleteItem(selectedItem.getDescription());
        // delete item from view
        toDoListItemsView.getItems().removeAll(selectedItem);
        // ready the edititem screen
        Parent page = sceneOperator.readyScene(Views.EDITITEM);
        EditItemController editItemController = sceneOperator.getLoader().getController();
        // initalize selectedItem
        editItemController.initialize(selectedItem);
        // show edit item scene
        sceneOperator.popUpScene("Edit item", page);
        // add item to list
        list.addItem(selectedItem);
        // add item to view
        toDoListItemsView.getItems().add(selectedItem);
    }
    @FXML
    public void ChangeStatusButtonPressed() {
        Item selectedItem = toDoListItemsView.getSelectionModel().getSelectedItem();
        selectedItem.setStatus(!selectedItem.isStatus());
        toDoListItemsView.getItems().removeAll(selectedItem);
        toDoListItemsView.getItems().add(selectedItem);
    }
    @FXML
    public void ClearListButtonPressed() {
        list.deleteAllItems();
        toDoListItemsView.getItems().clear();
    }
    @FXML
    public void ViewAllButtonPressed(){
        toDoListItemsView.getItems().clear();
        tableOperator.setTable(toDoListItemsView);
        tableOperator.loadTable(list.getList());
    }
    public void ViewIncompletedButtonPressed(){
        ArrayList<Item> incomplete = list.getIncompleteItems();
        toDoListItemsView.getItems().clear();
        tableOperator.setTable(toDoListItemsView);
        tableOperator.loadTable(incomplete);

    }
    public void ViewCompletedButtonPressed(){
        ArrayList<Item> complete = list.getCompleteItems();
        toDoListItemsView.getItems().clear();
        tableOperator.setTable(toDoListItemsView);
        tableOperator.loadTable(complete);

    }

}

