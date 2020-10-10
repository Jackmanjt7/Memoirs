package ui;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainViewController {

    @FXML
    private Button uploadBTN;

    @FXML
    private Button viewTimelineBTN;

    @FXML
    private Button helpBTN;


	@FXML
    void newWindow(ActionEvent event) {
		try{
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Upload.fxml"));
			Parent root = fxmlLoader.load();
			Stage stage = new Stage();

			stage.setScene(new Scene(root));
			stage.show();
		}catch(Exception e){
			e.printStackTrace();
		}
    }







}
