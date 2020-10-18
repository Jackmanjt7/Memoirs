package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class InitialSetupController {

	private String FirstName, LastName, Birthplace, CurrentHome, Father, Mother, 
	AdoptiveParent1, AdoptiveParent2;
	
	
	@FXML private Button ContinueButton;
	@FXML private TextField FirstNameTextField;
	@FXML private TextField LastNameTextField;
	@FXML private TextField BirthCountryTextField;
	@FXML private TextField BirthHometownTextField;
	@FXML private TextField BirthStateTextField;
	@FXML private TextField CurrentCountryTextField;
	@FXML private TextField CurrentHometownTextField;
	@FXML private TextField CurrentStateTextField;
	@FXML private TextField FatherTextField;
	@FXML private TextField MotherTextField;
	@FXML private TextField AdoptiveParent1TextField;
	@FXML private TextField AdoptiveParent2TextField;
	@FXML private RadioButton AdoptedRadioButton;
	
	
	@FXML
	private void Continue() {
		FirstName = FirstNameTextField.getText();
		LastName = LastNameTextField.getText();
		Birthplace = constructBirthPlaceString();
		System.out.println(FirstName + LastName + Birthplace);
		try{
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/Homepage.fxml"));
			Parent root = fxmlLoader.load();

			Main.stage.setScene(new Scene(root));
			Main.stage.show();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private String constructBirthPlaceString() {
		String hometown, state, country;
		String finalAddress = "";
		if(!(BirthHometownTextField.getText().equals(null))) {
			hometown = BirthHometownTextField.getText();
			finalAddress = hometown;
		}
		if(!(BirthStateTextField.getText().equals(null))) {
			state = BirthStateTextField.getText();
			finalAddress = finalAddress + ", " + state;
		}
		if(!(BirthCountryTextField.getText().equals(null))) {
			country = BirthCountryTextField.getText();
			finalAddress = finalAddress + ", " + country;
		}
		return finalAddress;
	}
}

