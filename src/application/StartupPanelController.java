package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class StartupPanelController {
	
	@FXML private Button CreateMemoirButton;

	@FXML 
	private void CreateNewMemoir() {
		try{
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/CreateNewSaveFile.fxml"));
			Parent root = fxmlLoader.load();

			Main.stage.setScene(new Scene(root));
			Main.stage.show();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
