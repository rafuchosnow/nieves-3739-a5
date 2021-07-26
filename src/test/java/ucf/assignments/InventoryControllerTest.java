/*
 *
 *  *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  *  Copyright 2021 Rafael Nieves
 *
 */

package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class InventoryControllerTest {

    @Test
    void addItemName() throws IOException {
        
        InventoryController IC = new InventoryController();
        ObservableList<Item> itemList = FXCollections.observableArrayList();

        IC.addText(itemList,"300.00", "123ABC456X","Nintendo Switch");

        assertEquals("Nintendo Switch", itemList.get(0).getNameProperty());

    }

    @Test
    void addItemSerial() throws IOException {

        InventoryController IC = new InventoryController();
        ObservableList<Item> itemList = FXCollections.observableArrayList();

        IC.addText(itemList,"300.00", "123ABC456X","Nintendo Switch");

        assertEquals("123ABC456X", itemList.get(0).getSerialProperty());

    }

    @Test
    void addItemValue() throws IOException {

        InventoryController IC = new InventoryController();
        ObservableList<Item> itemList = FXCollections.observableArrayList();

        IC.addText(itemList,"300.00", "123ABC456X","Nintendo Switch");

        assertEquals("$300.00", itemList.get(0).getValueProperty());

    }

}