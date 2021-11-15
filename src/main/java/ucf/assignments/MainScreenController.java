/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Andrew Hicks
 */

package ucf.assignments;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.Parent;
import java.util.ArrayList;

public class MainScreenController {

    @FXML
    private Button CreateListButton;
    @FXML
    private Button DeleteListButton;
    @FXML
    private Button EditListButton;
    @FXML
    private Button ViewListButton;
    @FXML
    private Button OpenFileButton;
    @FXML
    private Button SaveFileButton;

    @FXML
    private Label welcomeText;
    @FXML
    public TableView<ToDoList> mainTableListView;

    private ArrayList<ToDoList> mainList = new ArrayList<>();

    private TableView.TableViewSelectionModel<ToDoList> selection;

    private final ListTableBuilder tableOperator = new ListTableBuilder();
    private final SceneOperator sceneOperator = new SceneOperator();

    public void initialize(){
        tableOperator.setTable(mainTableListView);
        tableOperator.buildTable();
        mainTableListView = tableOperator.getTable();

    }
    @FXML
    public void CreateListButtonPressed() {
        // create list
        ToDoList newList = new ToDoList();
        // ready the addlist box
        Parent page = sceneOperator.readyScene(Views.ADDLIST);
        //
        CreateListController createListController = sceneOperator.getLoader().getController();
        // initalize the new list
        createListController.initalize(newList);
        // show the create list scene
        sceneOperator.popUpScene("Create List", page);
        // add list to mainlist
        mainList.add(newList);
        // add list to table
        mainTableListView.getItems().add(newList);




    }
    @FXML
    public void DeleteListButtonPressed() {
        // get selection
        ToDoList selectedItem = mainTableListView.getSelectionModel().getSelectedItem();
        // remove from list
        mainList.remove(selectedItem);
        // remove from screen
        mainTableListView.getItems().removeAll(selectedItem);

    }
    @FXML
    public void ViewListButtonPressed(){
        // get selected item
        ToDoList selectedItem = mainTableListView.getSelectionModel().getSelectedItem();

        // get scene and controller
        Parent page = sceneOperator.readyScene(Views.ListScreen);
        ToDoListController toDoListController = sceneOperator.getLoader().getController();

        // give ToDoListController the list to show
        toDoListController.setViewList(selectedItem);

        // remove the list from main screen
        mainList.remove(selectedItem);
        mainTableListView.getItems().removeAll(selectedItem);

        // Popup list screen
        sceneOperator.popUpScene("ToDoList", page);

        // Add updated list back to main screen
        mainList.add(toDoListController.getList());
        mainTableListView.getItems().add(toDoListController.getList());


    }
    public void OpenFileButtonPressed(){
        // open file window
    }
    public void SaveFileButtonPressed(){
        // open file window
        // run FileOperator functions
    }
    public void EditListButtonPressed(){
        // get selection
        ToDoList selectedItem = mainTableListView.getSelectionModel().getSelectedItem();
        // remove selected from table
        mainTableListView.getItems().removeAll(selectedItem);
        // ready the editlist page
        Parent page = sceneOperator.readyScene(Views.EDITLIST);
        EditListTitleController editItemController = sceneOperator.getLoader().getController();
        // initalize selectedItem
        editItemController.initialize(selectedItem);
        // show edit list page
        sceneOperator.popUpScene("Edit List", page);
        // add item to list
        mainList.add(selectedItem);
        // add item to view
        mainTableListView.getItems().add(selectedItem);

    }
}
