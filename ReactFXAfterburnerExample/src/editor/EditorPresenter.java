package editor;

import java.util.function.Function;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javax.inject.Inject;

import model.Model;
import model.Person;

import org.reactfx.value.Val;

public class EditorPresenter {

    @Inject 
    private Model model ;
    
    @FXML
    private TextField firstNameTextField ;
    @FXML
    private TextField lastNameTextField ;
    @FXML
    private TextField emailTextField ;
    
    public void initialize() {
        bindTF(firstNameTextField, Person::firstNameProperty);
        bindTF(lastNameTextField, Person::lastNameProperty);
        bindTF(emailTextField, Person::emailProperty);
    }
    
    private void bindTF(TextField tf, Function<Person, StringProperty> prop) {
        tf.textProperty().bindBidirectional(Val.selectVar(model.currentPersonProperty(), prop));
    }
}
