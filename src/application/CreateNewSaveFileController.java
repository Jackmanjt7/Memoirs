package application;

import java.io.File;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CreateNewSaveFileController {

	//public String projectPath;
	
	@FXML private Button NextButton, CancelButton;
	@FXML private TextField ProjectNameTextField;
	
	@FXML
	private void next() {
		if(isValidProjectName(ProjectNameTextField.getText())) {
			createProjectDirectory(ProjectNameTextField.getText());
			try{
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/InitialSetup.fxml"));
				Parent root = fxmlLoader.load();

				Main.stage.setScene(new Scene(root));
				Main.stage.show();
			}catch(Exception e){
				e.printStackTrace();
			}
		}else {
			this.next();
		}
		
	}
	
	private void createProjectDirectory(String projectName) {
		
		String path = "C:\\Memoir";
		File file = new File(path);
		if(file.mkdir()) {
			System.out.println("Directory created at " + path);
		}
		
		path = "C:\\Memoir\\" + projectName;
		file = new File(path);
		if(file.mkdir()) {
			System.out.println("Directory created at " + path);
			Main.PROJECT_PATH = path; //This is so that a running instance of the app knows WHICH project folder to look in for data
		}else {
			System.out.println("mkdir failed --- duplicate project?");
		}
		//Creates Pictures Directory
		file = new File(path + "\\Pictures");
		if(file.mkdir()) {
			System.out.println("Directory created at " + path);
			Main.PROJECT_PATH = path; //This is so that a running instance of the app knows WHICH project folder to look in for data
		}else {
			System.out.println("mkdir for pictures failed...");
		}
		
	}
	
	// THIS IS NOT SUFFICIENT STRING VERIFICATION (Add more l8r)
	private boolean isValidProjectName(String projectName) {
		if(projectName.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
	
	@FXML 
	private void cancel() {
		System.exit(0);
	}
		
}
