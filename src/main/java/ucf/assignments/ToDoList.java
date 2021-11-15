/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Andrew Hicks
 */

package ucf.assignments;
import java.util.ArrayList;

public class ToDoList {
    private String name;
    private int capacity;
    private ArrayList<Item> items = new ArrayList<>();
    public ToDoList(){
        this.name = "name";
        this.capacity = items.size();
    }
    public ArrayList<Item> getList(){

        return this.items;
    }
    public void setName(String newname){

        this.name = newname;
    }
    public String getName(){

        return this.name;
    }
    public int getCapacity(){
        if(items == null){
            return 0;
        }
        return items.size();
    }
    public void addItem(Item item){
        items.add(item);
    }
    public void deleteItem(String description){
        for(int i = 0; i<items.size(); i++){
            if(items.get(i).getDescription().equals(description)){
                items.remove(i);
            }
        }
    }
    public void deleteAllItems(){
        items.clear();
    }
    public ArrayList<Item> getCompleteItems(){
        ArrayList<Item> complete = new ArrayList<>();
        for(Item item : items){
            if(item.isStatus()){
                complete.add(item);
            }
        }

        return complete;
    }
    public ArrayList<Item> getIncompleteItems(){
        ArrayList<Item> incomplete = new ArrayList<>();
        for(Item item : items){
            if(!item.isStatus()){
                incomplete.add(item);
            }
        }
        return incomplete;
    }
}
