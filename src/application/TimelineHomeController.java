package application;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;

import data.FileOperator;
import data.JsonReader;
import data.JsonWriter;
import data.Metadata;
import data.PersonalInfo;
import data.TimelineEvent;
import javafx.collections.ObservableList;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class TimelineHomeController {
	
	private static Stage secondaryStage = new Stage();
	
	@FXML ListView<String> EventListView;
	@FXML TextField EventTitleTextField;
	@FXML TextField EventLocationTextField;
	@FXML DatePicker EventDatePicker;
	@FXML TextArea EventDescriptionTextArea;
	@FXML ListView<File> FileList;
	@FXML Pane AddEventPane;
	@FXML TextArea EventTextArea;	//In the Main Pane Under the Image Viewer
	@FXML ImageView MainImageView;
	@FXML ListView<File> PicturesListView;
	Image displayedImage;
	
	@FXML
	public void displayInfo(){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Personal Information");
		alert.setHeaderText("Personal Information");
		alert.setContentText(PersonalInfo.allInfoToString());
		alert.showAndWait();
	}
	
	@FXML
	private void displaySelectedEvent() {
		if(EventListView.getSelectionModel().getSelectedItem() != null) {
			//System.out.println(Metadata.EVENT_LIST.size());
			TimelineEvent event = Metadata.getEvent(EventListView.getSelectionModel().getSelectedItem());
			EventTextArea.setText(event.getLocation() + "  -  " + event.getPrettyDate() + "\n" + event.getDescription());
			
			//Fill PicturesListView
			PicturesListView.getItems().clear();
			for(int i = 0; i < event.getFiles().size(); i++) {
				PicturesListView.getItems().add(event.getFiles().get(i));
			}
			//PicturesListView.setItems((ObservableList<File>) event.getFiles());
			PicturesListView.getSelectionModel().select(event.getFiles().get(0));
			displaySelectedImage();
			
		}
	}
	
	private void displayImage(File file) {
		String filename = file.getName();
		String path = "file:///" + Main.PROJECT_PATH + "\\Pictures\\" + filename;
		
		System.out.println(path);
	    Image image = new Image(path);
	    displayedImage = image;
	    MainImageView.setImage(image);
	}
	
	@FXML
	private void displaySelectedImage() {
		File file = PicturesListView.getSelectionModel().getSelectedItem();
		displayImage(file);
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
	
	void fillEventListView() {
		EventListView.getItems().clear();
		ArrayList<TimelineEvent> events = new ArrayList<TimelineEvent>();
		try {
			events = JsonReader.getEventsFromJson();
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			for(int i =0; i < events.size(); i++) {
				EventListView.getItems().add(events.get(i).getTitle());
			}
		}
	}
	
	//Saves Event data to Json, directories, and program memory
	@FXML
	private void createEvent() throws IOException, ParseException {
		TimelineEvent newEvent;
		if(FileList.getItems().isEmpty()) {
		//instantiate TimelineEvent Class
			newEvent = new TimelineEvent(EventTitleTextField.getText(), 
				EventLocationTextField.getText(), 
				EventDatePicker.getValue().toString(), 
				EventDescriptionTextArea.getText());
		}else {
			newEvent = new TimelineEvent(EventTitleTextField.getText(), 
					EventLocationTextField.getText(), 
					EventDatePicker.getValue().toString(), 
					EventDescriptionTextArea.getText(),
					FileList.getItems());
			
			String pictureDirectory = Main.PROJECT_PATH + "\\Pictures\\";
			for(int i = 0; i < newEvent.getFiles().size(); i++) {
				File temp = new File(pictureDirectory + newEvent.getFiles().get(i).getName());
				FileOperator.copy(newEvent.getFiles().get(i), temp );
				//System.out.println(pictureDirectory + newEvent.getFiles().get(i).getName());
				//System.out.println(temp.getAbsolutePath());
			}
			
		}
		
		JsonWriter.writeEvent(newEvent);
		AddEventPane.setVisible(false);
		Metadata.EVENT_LIST.add(newEvent);
		//EventListView.getItems().add(newEvent.getTitle());
		secondaryStage.close();
	}
	
	
	@FXML 
	private void closeStage() {
		AddEventPane.setVisible(false);
		secondaryStage.close();
	}
	
	@FXML 
	private void uploadPhoto() {
		FileChooser fileChooser = new FileChooser();
		//Sets file extension type filters (Pictures)
		fileChooser.getExtensionFilters().addAll
				(new FileChooser.ExtensionFilter("Picture Files", "*.jpg", "*.png"));
		
		//Setting initial directory (finds current system user)
		File initialDirectory;
		String user = System.getProperty("user.name"); //platform independent
		List<File> selectedFiles;
		try {
			initialDirectory = new File("C:\\Users\\" + user + "\\Pictures" );
			fileChooser.setInitialDirectory(initialDirectory);	
			selectedFiles = fileChooser.showOpenMultipleDialog(Main.stage);
		} catch(Exception e) {
			initialDirectory = new File("C:\\Users\\" + user);
			fileChooser.setInitialDirectory(initialDirectory);
			selectedFiles = fileChooser.showOpenMultipleDialog(Main.stage);
		}
		
		//Add to Field
		
		for(int i = 0; i < selectedFiles.size(); i++) {
			String filename = selectedFiles.get(i).getName(); //get filename
			FileList.getItems().add(selectedFiles.get(i)); //add File to list view
		}
	}
	
	@FXML
	private void nextImage() {
		int index = PicturesListView.getSelectionModel().getSelectedIndex();
		if(index + 1 >= PicturesListView.getItems().size()) {
			PicturesListView.getSelectionModel().select(0);		
		} else {
			PicturesListView.getSelectionModel().select(index + 1);
		}
		displaySelectedImage();
	}
	
	@FXML
	private void prevImage() {
		int index = PicturesListView.getSelectionModel().getSelectedIndex();
		if(index - 1 < 0) {
			PicturesListView.getSelectionModel().select(PicturesListView.getItems().size() - 1);		
		} else {
			PicturesListView.getSelectionModel().select(index - 1);
		}
		displaySelectedImage();
	}

	
	

}
