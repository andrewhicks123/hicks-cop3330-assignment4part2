/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Andrew Hicks
 */

package ucf.assignments;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;

import javafx.scene.Parent;

import java.util.ArrayList;
import java.util.stream.IntStream;

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

    private ToDoList selected = new ToDoList();

    public void initialize(){
        tableOperator.setTable(mainTableListView);
        tableOperator.buildTable();
        mainTableListView = tableOperator.getTable();

    }
    @FXML
    public void CreateListButtonPressed() {
        ToDoList newList = new ToDoList();

        Parent page = sceneOperator.readyScene(Views.ADDLIST);

        CreateListController createListController = sceneOperator.getLoader().getController();
        createListController.initalize(newList);
        sceneOperator.popUpScene("Create List", page);
        mainList.add(newList);
        mainTableListView.getItems().add(newList);




    }
    @FXML
    public void DeleteListButtonPressed() {
        ToDoList selectedItem = mainTableListView.getSelectionModel().getSelectedItem();
        mainList.remove(selectedItem);
        mainTableListView.getItems().removeAll(selectedItem);

    }
    @FXML
    public void ViewListButtonPressed(){
        ToDoList selectedItem = mainTableListView.getSelectionModel().getSelectedItem();
        selected = selectedItem;
        Parent page = sceneOperator.readyScene(Views.ListScreen);
        ToDoListController toDoListController = sceneOperator.getLoader().getController();

        toDoListController.setViewList(selectedItem);

        mainList.remove(selectedItem);
        mainTableListView.getItems().removeAll(selectedItem);

        sceneOperator.popUpScene("ToDoList", page);


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

        mainTableListView.getItems().removeAll(selectedItem);

        Parent page = sceneOperator.readyScene(Views.EDITLIST);

        EditListTitleController editItemController = sceneOperator.getLoader().getController();

        editItemController.initialize(selectedItem);

        sceneOperator.popUpScene("Edit List", page);

        mainList.add(selectedItem);

        mainTableListView.getItems().add(selectedItem);

    }
}
