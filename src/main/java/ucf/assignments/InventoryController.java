/*
 *
 *  *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  *  Copyright 2021 Rafael Nieves
 *
 */

package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


import java.io.IOException;


public class InventoryController {

    @FXML
    TextField valueField;
    @FXML
    TextField serialField;
    @FXML
    TextField nameField;
    @FXML
    TableView<Item> itemTable;
    @FXML
    TableColumn<Item, String> valueCol;
    @FXML
    TableColumn<Item, String> serialCol;
    @FXML
    TableColumn<Item, String> nameCol;
    ObservableList<Item> itemList = FXCollections.observableArrayList();


    public void initialize() {
        //Initialize tableview and columns

        valueCol.setCellValueFactory(new PropertyValueFactory<>("valueProperty"));
        serialCol.setCellValueFactory(new PropertyValueFactory<>("serialProperty"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("nameProperty"));

        itemTable.setItems(itemList);
    }

    @FXML
    public void addItem(ActionEvent actionEvent) throws IOException {
        String value = valueField.getText();
        String serial = serialField.getText();
        String name = nameField.getText();

        try {
            addText(itemList, value, serial, name);

        }
        catch(Exception e) {
            nameField.setText("Between 2 and 256 characters");
            serialField.setText("Use format XXXXXXXXXX");
        }

        //Reset description fields

        valueField.setText("");
        serialField.setText("");
        nameField.setText("");

        itemTable.refresh();

    }

    @FXML
    public void addText(ObservableList<Item> itemList, String value, String serial, String name) throws IOException {
        //Prompt the user type in list item properties
        Item newItem = new Item("$" + value, serial, name);

        //Filter out wrong inputs
        if(name.length() >= 2 || name.length() <= 256){
            if(serial.length() == 10) {
                //Add item to the list
                itemList.add(newItem);
            }
        }
    }

    @FXML
    public void removeItem(ActionEvent actionEvent) {
        //Select item you want to remove
        //Remove item from list and table

        itemList.remove(itemTable.getSelectionModel().getSelectedItem());
        itemTable.refresh();
    }

    @FXML
    public void editItem(ActionEvent actionEvent) {
        //Select item to edit
        //Populate fields

        valueField.setText(itemTable.getSelectionModel().getSelectedItem().getValueProperty());
        serialField.setText(itemTable.getSelectionModel().getSelectedItem().getSerialProperty());
        nameField.setText(itemTable.getSelectionModel().getSelectedItem().getNameProperty());

        //Remove old item from list

        itemList.remove(itemTable.getSelectionModel().getSelectedItem());
        itemTable.refresh();
    }

    public void loadList(ActionEvent actionEvent) {
        //Have user type path for loading
        //Load file into inventory

    }

    public void saveTSV(ActionEvent actionEvent) {
        //Create text file
        //Add to list item by item separated by tabs
        //Type in path for saving

    }

    public void saveHTML(ActionEvent actionEvent) {
        //Create HTML file
        //Add to list item by item
        //Type in path for saving
    }

    public void saveJSON(ActionEvent actionEvent) {
        //Create JSON file
        //Add to list item by item
        //Type in path for saving
    }


}
