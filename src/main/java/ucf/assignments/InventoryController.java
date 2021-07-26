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
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

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
    @FXML
    Button BackButton;

    public void initialize() {
        //Initialize tableview and columns

        valueCol.setCellValueFactory(new PropertyValueFactory<>("valueProperty"));
        serialCol.setCellValueFactory(new PropertyValueFactory<>("serialProperty"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("nameProperty"));

        itemTable.setItems(itemList);
    }

    @FXML
    public void addItem(ActionEvent actionEvent) throws IOException {
        //Prompt the user type in list item properties

        Item newItem = new Item("$" + valueField.getText(), serialField.getText(), nameField.getText());

        //Filter out wrong inputs

        if(nameField.getText().length() >= 2 || nameField.getText().length() <= 256){
            if(serialField.getText().length() == 10) {

                itemList.add(newItem);

                //Add item to the list
                //Reset description fields

                valueField.setText("");
                serialField.setText("");
                nameField.setText("");

                itemTable.refresh();
            }
            else {
                nameField.setText("Between 2 and 256 characters");
                serialField.setText("Use format XXXXXXXXXX");
            }
        }
        else {
            nameField.setText("Between 2 and 256 characters");
            serialField.setText("Use format XXXXXXXXXX");
        }


    }

    public void removeItem(ActionEvent actionEvent) {
        //Select item you want to remove
        //Remove item from list and table

        itemList.remove(itemTable.getSelectionModel().getSelectedItem());
        itemTable.refresh();
    }

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

    }

    public void saveTSV(ActionEvent actionEvent) {
    }

    public void saveHTML(ActionEvent actionEvent) {
    }

    public void saveJSON(ActionEvent actionEvent) {
    }


}
