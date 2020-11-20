package application;

import java.io.File;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import data.JsonWriter;
import data.PersonalInfo;
import data.TimelineEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TimelineHomeController {
	
	private static Stage secondaryStage = new Stage();

	@FXML
	private void displayInfo(){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Personal Information");
		alert.setHeaderText("Personal Information");
		alert.setContentText(PersonalInfo.allInfoToString());
		alert.showAndWait();
	}
	
	@FXML
	private void addEvent() {
		try{
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/AddEvent.fxml"));
			Parent root = fxmlLoader.load();			
			secondaryStage.setScene(new Scene(root));
			secondaryStage.show();
			//s.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@FXML
	public static void closeSecondaryStage() {
		secondaryStage.close();
	}

	
	

}
