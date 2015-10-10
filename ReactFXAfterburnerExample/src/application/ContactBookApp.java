package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ContactBookApp extends Application {

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setScene(new Scene(new ContactBook().getView(), 800, 600));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
