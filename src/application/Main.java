package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	public static Stage stage;
	public static String PROJECT_PATH; //This is where we store which project folder we are using
	
	@Override
	public void start(Stage newStage) {
		try {
			stage = newStage;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/StartupPanel.fxml"));
	        Parent root = loader.load();
	        Scene scene = new Scene(root);
	        stage.setScene(scene);
//	        loader.setRoot(root);
	        stage.setTitle("Memoir: Digital Photo Album");
	        stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		launch(args);
	}
}
