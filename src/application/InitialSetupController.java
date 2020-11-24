package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileNotFoundException;

import data.JsonWriter;
import data.PersonalInfo;

public class InitialSetupController {

	private String FirstName, LastName, Birthday, Birthplace, CurrentHome, Father, Mother, 
	AdoptiveParent1, AdoptiveParent2;
	private boolean Adopted = false;
	
	@FXML private Button ContinueButton;
	@FXML private TextField FirstNameTextField;
	@FXML private TextField LastNameTextField;
	@FXML private DatePicker DateOfBirthDatePicker;
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
		parseInputFromFXMLPanel(); //matches UI component input to class fields 
		try {
			JsonWriter.addPersonalInfoToJson(FirstName, LastName, 
					Birthday, Birthplace, CurrentHome, Father, 
					Mother, AdoptiveParent1, AdoptiveParent2);
			setValuesToPersonalInfoClass();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("Json Writer has Failed");
			System.exit(0);
		}
		try{
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/TimelineHome.fxml"));
			Parent root = fxmlLoader.load();
			Main.stage.setScene(new Scene(root));
			Main.stage.show();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void parseInputFromFXMLPanel() {
		FirstName = FirstNameTextField.getText();
		LastName = LastNameTextField.getText();
		Birthday = DateOfBirthDatePicker.getValue().toString();
		Birthplace = constructBirthPlaceString();
		CurrentHome = constructCurrentHomeString();
		Father = FatherTextField.getText();
		Mother = MotherTextField.getText();
		if(AdoptedRadioButton.isSelected()) {
			AdoptiveParent1 = AdoptiveParent1TextField.getText();
			AdoptiveParent2 = AdoptiveParent2TextField.getText();
		}
		//This is where we will write personal info to xml
	}
	
	
	
	private String constructBirthPlaceString() {
		String hometown, state, country;
		String finalAddress = "";
		if(!(BirthHometownTextField.getText().equals(""))) {
			hometown = BirthHometownTextField.getText();
			finalAddress = hometown;
		}
		if(!(BirthStateTextField.getText().equals(""))) {
			state = BirthStateTextField.getText();
			finalAddress = finalAddress + ", " + state;
		}
		if(!(BirthCountryTextField.getText().equals(""))) {
			country = BirthCountryTextField.getText();
			finalAddress = finalAddress + ", " + country;
		}
		return finalAddress;
	}
	
	private String constructCurrentHomeString() {
		String hometown, state, country;
		String finalAddress = "";
		if(!(CurrentHometownTextField.getText().equals(""))) {
			hometown = CurrentHometownTextField.getText();
			finalAddress = hometown;
		}
		if(!(CurrentStateTextField.getText().equals(""))) {
			state = CurrentStateTextField.getText();
			finalAddress = finalAddress + ", " + state;
		}
		if(!(CurrentCountryTextField.getText().equals(""))) {
			country = CurrentCountryTextField.getText();
			finalAddress = finalAddress + ", " + country;
		}
		return finalAddress;
	}
	

	@FXML
	private void toggleAdopted() {
		//System.out.println("toggled");
		if(this.Adopted) {
			Adopted = false;
			AdoptiveParent1TextField.editableProperty().set(false);
			AdoptiveParent2TextField.editableProperty().set(false);
			AdoptiveParent1TextField.clear();
			AdoptiveParent2TextField.clear();
		}else {
			Adopted = true;
			AdoptiveParent1TextField.editableProperty().set(true);
			AdoptiveParent2TextField.editableProperty().set(true);
		}
	}
	
	public void setValuesToPersonalInfoClass() {
		PersonalInfo.setFIRST_NAME(FirstName);
		PersonalInfo.setLAST_NAME(LastName);
		PersonalInfo.setBIRTHDAY(Birthday);
		PersonalInfo.setBIRTHPLACE(Birthplace);
		PersonalInfo.setCURRENT_HOME(CurrentHome);
		PersonalInfo.setFATHER(Father);
		PersonalInfo.setMOTHER(Mother);
		
		PersonalInfo.setAdopted(Adopted);
		if(Adopted) {
			PersonalInfo.setADOPTIVE_PARENT_1(AdoptiveParent1);
			PersonalInfo.setADOPTIVE_PARENT_2(AdoptiveParent2);
		}
		
	}
	
}

