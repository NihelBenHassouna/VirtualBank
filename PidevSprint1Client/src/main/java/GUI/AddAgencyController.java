package GUI;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import Entities.Agency;
import Interfaces.AdminInterface;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.Initializable;


public class AddAgencyController implements Initializable{
	 @FXML
	    private Button addButton;

	    @FXML
	    private TextField name;

	    @FXML
	    private TextField adress;

	    @FXML
	    private TextField phone;

	    @FXML
	    private TextField email;

	    @FXML
	    private DatePicker date;
	    
	    @FXML
	    private TextArea info;
	   

	public void initialize(URL location, ResourceBundle resources) {
		


	}
	public void AddAgency(ActionEvent event) throws NamingException
	{
    
    
  }
    public void ConsultAgencies(ActionEvent event) throws IOException
    {	URL url = Paths.get("./src/main/java/GUI/ConsultAgencies.fxml").toUri().toURL();
	    Parent root = FXMLLoader.load(url);
           Scene PageScene = new Scene(root);
           Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
           window.setScene(PageScene);
           window.show();
    }
    public void GoAddAgency(ActionEvent event) throws IOException
    {
    	URL url = Paths.get("./src/main/java/GUI/ADDAgency.fxml").toUri().toURL();
		Parent root = FXMLLoader.load(url);
         Scene PageScene = new Scene(root);
         Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
         window.setScene(PageScene);
         window.show();
    	
    }
}

