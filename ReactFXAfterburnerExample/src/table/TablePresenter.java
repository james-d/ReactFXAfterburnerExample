package table;

import java.util.function.Function;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javax.inject.Inject;

import model.Model;
import model.Person;

public class TablePresenter {

    @FXML
    private TableView<Person> table ;
    @FXML
    private TableColumn<Person, String> firstNameCol ;
    @FXML
    private TableColumn<Person, String> lastNameCol ;
    @FXML
    private TableColumn<Person, String> emailCol ;
    
    @Inject
    private Model model ;
    
    public void initialize() {
        initCol(firstNameCol, Person::firstNameProperty);
        initCol(lastNameCol, Person::lastNameProperty);
        initCol(emailCol, Person::emailProperty);
        
        table.setItems(model.getPersonList());
        
        model.currentPersonProperty().bind(table.getSelectionModel().selectedItemProperty());
    }
    
    private <S,T> void initCol(TableColumn<S,T> col, Function<S,ObservableValue<T>> prop) {
        col.setCellValueFactory(cellData -> prop.apply(cellData.getValue()));
    }
}
