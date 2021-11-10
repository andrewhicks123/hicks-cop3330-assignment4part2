/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Andrew Hicks
 */

package ucf.assignments;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class ItemTableBuilder {

    private TableView<Item> table;
    private TableView.TableViewSelectionModel<Item> selection;

    public TableColumn<Item, String> descCol = new TableColumn<>("Description");
    public TableColumn<Item, String> dateCol = new TableColumn<>("Due Date");
    public TableColumn<Item, String> statusCol = new TableColumn<>("Status");

    public void buildTable(){
        descCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.getColumns().add(descCol);
        table.getColumns().add(dateCol);
        table.getColumns().add(statusCol);

    }
    public void setTable(TableView<Item> table){
        this.table = table;
    }

    public TableView<Item> getTable(){
        return table;
    }

    public TableView.TableViewSelectionModel<Item> getSelectedItem(){
        return selection;
    }

    public void loadTable(ArrayList<Item> list){
        for(Item item : list){
            table.getItems().add(item);
        }
    }
}



