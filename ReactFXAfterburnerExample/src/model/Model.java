package model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model {

    private final ObservableList<Person> personList ;
    private final ObjectProperty<Person> currentPerson = new SimpleObjectProperty<>();
    
    public Model() {
        personList = FXCollections.observableArrayList(
            new Person("Jacob", "Smith", "jacob.smith@example.com"),
            new Person("Isabella", "Johnson", "isabella.johnson@example.com"),
            new Person("Ethan", "Williams", "ethan.williams@example.com"),
            new Person("Emma", "Jones", "emma.jones@example.com"),
            new Person("Michael", "Brown", "michael.brown@example.com")    
        );
    }
    
    public ObservableList<Person> getPersonList() {
        return personList ;
    }

    public final ObjectProperty<Person> currentPersonProperty() {
        return this.currentPerson;
    }

    public final model.Person getCurrentPerson() {
        return this.currentPersonProperty().get();
    }

    public final void setCurrentPerson(final model.Person currentPerson) {
        this.currentPersonProperty().set(currentPerson);
    }
    
    
}
