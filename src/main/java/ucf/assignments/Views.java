/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Andrew Hicks
 */

package ucf.assignments;

public enum Views {
    MAIN("MainScreen.fxml"),
    ADDLIST("CreateList.fxml"),
    EDITLIST("EditList.fxml"),
    ADDITEM("AddItem.fxml"),
    EDITITEM("EditItem.fxml"),
    ListScreen("ListScreen.fxml");

    private final String fileName;

    Views(String fileName) {
        this.fileName = fileName;
    }
    public String getFileName() {
        return fileName;
    }
}