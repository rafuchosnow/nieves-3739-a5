package ucf.assignments;

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

    public String getValueProperty() {
        return valueProperty.get();
    }

    public String getSerialProperty() {
        return serialProperty.get();
    }

    public String getNameProperty() {
        return nameProperty.get();
    }

}
