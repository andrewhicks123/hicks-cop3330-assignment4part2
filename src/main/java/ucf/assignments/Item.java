/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Andrew Hicks
 */

package ucf.assignments;

public class Item {

    private String description;
    private String dueDate;
    private boolean status;

    public Item(){
        this.description = "description";
        this.dueDate = "YYYY-MM-DD";
        this.status = false;
    }
    public void setDescription(String desc){
        this.description = desc;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDueDate(String dueDate){
        this.dueDate = dueDate;
    }
    public String getDueDate(){
        return dueDate;
    }
    public void setStatus(boolean status){
        this.status = status;
    }
    public boolean isStatus(){
        return status;
    }
    public boolean getStatus(){
        return this.status;
    }
}
