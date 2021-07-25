package ucf.assignments;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Item {
    SimpleStringProperty valueProperty;
    SimpleStringProperty serialProperty;
    SimpleStringProperty nameProperty;

    public Item(String value, String serial, String name) {
        this.valueProperty = new SimpleStringProperty(value);
        this.serialProperty = new SimpleStringProperty(serial);
        this.nameProperty = new SimpleStringProperty(name);

    }

    public SimpleStringProperty getValueProperty() {
        return valueProperty;
    }

    public SimpleStringProperty getSerialProperty() {
        return serialProperty;
    }

    public SimpleStringProperty getNameProperty() {
        return nameProperty;
    }
}
