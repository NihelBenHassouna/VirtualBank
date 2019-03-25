package GUI;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.control.Label;

import javafx.scene.layout.AnchorPane;

import javafx.scene.control.RadioButton;

import javafx.scene.shape.Rectangle;

import javafx.scene.control.DatePicker;

import javafx.scene.control.ChoiceBox;

public class AddLoanRequestController implements Initializable{
	@FXML
	private AnchorPane birthdate1;
	@FXML
	private Label label1;
	@FXML
	private Rectangle rec1;
	@FXML
	private Rectangle rec2;
	@FXML
	private Rectangle rec3;
	@FXML
	private Rectangle rec4;
	@FXML
	private Label label2;
	@FXML
	private Label bank;
	@FXML
	private RadioButton bankyes;
	@FXML
	private RadioButton bankno;
	@FXML
	private Label bankname;
	@FXML
	private ChoiceBox<String> bankname1;
	@FXML
	private Label multibanked;
	@FXML
	private RadioButton multibankedyes;
	@FXML
	private RadioButton multibankedno;
	@FXML
	private Label Title;
	@FXML
	private ChoiceBox title1;
	@FXML
	private Label Name;
	@FXML
	private TextField name1;
	@FXML
	private Label LastName;
	@FXML
	private TextField lastname1;
	@FXML
	private Label Birth;
	@FXML
	private Label Nationality;
	@FXML
	private ChoiceBox nationality1;
	@FXML
	private Label Credential;
	@FXML
	private ChoiceBox credential1;
	@FXML
	private Label CredentialNumber;
	@FXML
	private TextField credentialNum1;
	@FXML
	private Label Adress;
	@FXML
	private TextField adress1;
	@FXML
	private Label Professional;
	@FXML
	private ChoiceBox professional1;
	@FXML
	private Label job;
	@FXML
	private Label hiringDate;
	@FXML
	private Label position;
	@FXML
	private TextField job1;
	@FXML
	private Label Employer;
	@FXML
	private TextField employer1;
	@FXML
	private Label Rc;
	@FXML
	private DatePicker hiringdate1;
	@FXML
	private ChoiceBox position1;
	@FXML
	private DatePicker registre1;
	@FXML
	private Label actiitysector;
	@FXML
	private TextField activitysector;
	@FXML
	private Label seniority;
	@FXML
	private TextField seniority1;
	@FXML
	private Label campany;
	@FXML
	private TextField company1;
	@FXML
	private DatePicker companycreation1;
	@FXML
	private Label camapnycreation;
	@FXML
	private Label marital;
	@FXML
	private ChoiceBox marital1;
	@FXML
	private Label kids;
	@FXML
	private TextField kids1;
	@FXML
	private Label phone;
	@FXML
	private TextField phone1;
	@FXML
	private Label email;
	@FXML
	private TextField email1;
	@FXML
	private Button Validate;
	ObservableList<String> cursors = FXCollections.observableArrayList("Credx Ariana", "Credx Beja", "Credx Manouba", "Credx Ben Arous");
	ObservableList<String> cursors1 = FXCollections.observableArrayList("Biat", "ATB", "Attijari");
	ObservableList<String> cursors2 = FXCollections.observableArrayList("Mr", "Mme", "Melle");
	ObservableList<String> cursors3 = FXCollections.observableArrayList("Tunisian", "Foreign");
	ObservableList<String> cursors4 = FXCollections.observableArrayList("Cin", "Passeport");
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		title1.setItems(cursors3);
		
	}
	@FXML
	public void verifyBankCustomer(ActionEvent event)
	{
		if(bankyes.isSelected())
			{bankname.setText("CredxAgencies");
			bankname1.setItems(cursors);
		      bankno.setSelected(false);
			}
	}
				@FXML
				public void verifyBankCustomer1(ActionEvent event)
				{if(bankno.isSelected())
				{
					bankname.setText("Choose your bank");
					bankname1.setItems(cursors1);
					bankyes.setSelected(false);
				}
				
			
				
		
	}

}
