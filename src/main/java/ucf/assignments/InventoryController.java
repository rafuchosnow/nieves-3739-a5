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
import javafx.scene.control.TreeItem;

import java.time.LocalDate;

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
    TableColumn<Item,String> valueCol;
    @FXML
    TableColumn<Item,String> serialCol;
    @FXML
    TableColumn<Item,String> nameCol;

    ObservableList<Item> itemList = FXCollections.observableArrayList();

    @FXML
    public void initialize(){
        //Initialize tableview
        itemTable.setItems(itemList);
    }

    @FXML
    public void addItem(ActionEvent actionEvent) {
        //Prompt the user type in list item properties
        itemTable.setItems(itemList);

        Item newItem = new Item(valueField.getText(), serialField.getText(), nameField.getText());
        itemList.add(newItem);

        //Add item to the list
        //Reset description fields

        valueField.setText("");
        serialField.setText("");
        nameField.setText("");

        itemTable.refresh();
    }

    public void removeItem(ActionEvent actionEvent) {
    }

    public void editItem(ActionEvent actionEvent) {
    }

    public void loadList(ActionEvent actionEvent) {
    }

    public void saveTSV(ActionEvent actionEvent) {
    }

    public void saveHTML(ActionEvent actionEvent) {
    }

    public void saveJSON(ActionEvent actionEvent) {
    }

    public void searchSerial(ActionEvent actionEvent) {
    }

    public void searchName(ActionEvent actionEvent) {
    }
}
