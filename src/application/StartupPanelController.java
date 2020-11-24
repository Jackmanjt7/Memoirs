package application;

import java.io.File;

import data.JsonReader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
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
	
	@FXML 
	private void SelectExistingMemoir() {
		
		//SELECT PROJECT DIRECTORY
		DirectoryChooser dirChooser = new DirectoryChooser();
		dirChooser.setTitle("Open Project File");
		File initialDirectory = new File("C:\\Memoir");
		dirChooser.setInitialDirectory(initialDirectory);
		File directory = dirChooser.showDialog(new Stage());
		//System.out.println(directory.getAbsolutePath().toString());
		Main.PROJECT_PATH = directory.getAbsolutePath().toString();
		
		// READ FROM JSON --- FILL PERSONAL INFO CLASS
		try {
			System.out.println(Main.PROJECT_PATH);
			JsonReader.fillPersonalInfoClassFromJson();
		} catch (Exception e1) {
			//e1.printStackTrace();
			System.out.println("Couldnt Fill Personal Info Class from JSON");
		}
		
		// NEXT PAGE
		try{
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/TimelineHome.fxml"));
			Parent root = fxmlLoader.load();
			
			Main.stage.setScene(new Scene(root));
			Main.stage.show();
			//fill list upon display
			((TimelineHomeController) fxmlLoader.getController()).fillEventListView();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}
}
