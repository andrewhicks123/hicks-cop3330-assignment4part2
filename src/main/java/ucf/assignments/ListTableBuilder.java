/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Andrew Hicks
 */

package ucf.assignments;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class ListTableBuilder {

    private TableView<ToDoList> table;
    private TableView.TableViewSelectionModel<ToDoList> selection;

    public TableColumn<ToDoList, String> nameCol = new TableColumn<>("Name");
    public TableColumn<ToDoList, Integer> sizeCol = new TableColumn<>("Size");

    public void buildTable(){
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        sizeCol.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.getColumns().add(nameCol);
        table.getColumns().add(sizeCol);
    }
    public void setTable(TableView<ToDoList> table){
        this.table = table;
    }

    public TableView<ToDoList> getTable(){
        return table;
    }

    public TableView.TableViewSelectionModel<ToDoList> getSelectedItem(){
        return selection;
    }

    public void loadTable(ArrayList<ToDoList> list){
        for(ToDoList item : list){
            table.getItems().add(item);
        }
    }
}
