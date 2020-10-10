package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class uploadViewController {

    @FXML
    private ChoiceBox<?> fileChooser;
    @FXML
    private Button submitBTN;
    @FXML
    private TextArea memoryTXT;
    @FXML
    private TextField memoryTitleTXT;

    @FXML
    void submitMemory(ActionEvent event) {
    	String memoryTitle = memoryTitleTXT.getText();
    	String memory = memoryTXT.getText();
    	try{
    	String filename = memoryTitle.concat(".txt");
    	File submit = new File(filename);
    	submit.createNewFile();
    	FileWriter submitWriter = new FileWriter(filename);
    	submitWriter.write(memory);
    	submitWriter.close();
    	System.out.println("Successfully made file");


    	}catch(IOException e){
    		e.printStackTrace();
    	}
    }

}