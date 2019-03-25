package GUI;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.hibernate.loader.Loader;

import Entities.Agency;
import Interfaces.AdminInterface;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;




public class ConsultAgenciesController implements Initializable{

    @FXML
    private TableView<Agency> t;
    @FXML
    private TableColumn<Agency,String> name;

    @FXML
    private TableColumn<Agency,String> adress;

    @FXML
    private TableColumn<Agency,String> email;

    @FXML
    private TableColumn<Agency,String> information;
    @FXML
    private TableColumn<Agency,String> phone;
    @FXML
    private TableColumn<Agency,Date> creation;
    @FXML
    private Button displayButton;
    @FXML
    private TextField Nom;

    @FXML
    private TextField Adresse;

    @FXML
    private TextField Email;

    @FXML
    private TextField Info;

    @FXML
    private TextField Phone;

    @FXML
    private DatePicker Picker;
    private ObservableList<Agency> data;
    private Agency agency;

	public void initialize(URL location, ResourceBundle resources) {
		

		String jndiName= "Pidev-Sprint1-ear/Pidev-Sprint1-ejb/AdminAgencyService!Interfaces.AdminInterface";
   	 Context context;
	try {
		context = new InitialContext();
		  AdminInterface proxy= (AdminInterface)context.lookup(jndiName);
	       data = FXCollections.observableArrayList();
	          name.setCellValueFactory(new PropertyValueFactory<>("name"));
	           phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
	           email.setCellValueFactory(new PropertyValueFactory<>("email"));
	           adress.setCellValueFactory(new PropertyValueFactory<>("adress"));
	           information.setCellValueFactory(new PropertyValueFactory<>("Information"));
	           creation.setCellValueFactory(new PropertyValueFactory<>("Creation"));
	           List <Agency> agencies =new ArrayList<>();
	           agencies=proxy.findAllAgencies();
	           for (Agency a :agencies) {
	               data.add(new Agency(a.getAdress(),a.getEmail(),a.getPhone(),a.getName(),a.getCreation(),a.getInformation())); }
	           t.setItems(null);
	           t.setItems(data);
	} catch (NamingException e) {
		
		e.printStackTrace();
	}
     
        
	}
	@FXML
	   public void ontableclicked() throws NamingException
	   { String jndiName= "Pidev-Sprint1-ear/Pidev-Sprint1-ejb/AdminAgencyService!Interfaces.AdminInterface";
	   
	   	 Context context= new InitialContext();
	       AdminInterface proxy= (AdminInterface)context.lookup(jndiName);
		agency=t.getSelectionModel().getSelectedItem();
		System.out.println(agency.toString());
		int id=proxy.getAgencyByEmail(agency.getEmail()).getId();
		agency.setId(id);
		if(agency!=null)
		{
			Adresse.setText(agency.getAdress());
			Email.setText(agency.getEmail());
			Phone.setText(agency.getPhone());
			Nom.setText(agency.getName());
			Info.setText(agency.getInformation());
			Picker.setValue(agency.getCreation().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
			
		   
		}
		
		 
		
	   }
	 
	@FXML
	   public void removeAgency(ActionEvent event) throws NamingException{
		   String jndiName= "Pidev-Sprint1-ear/Pidev-Sprint1-ejb/AdminAgencyService!Interfaces.AdminInterface";
		   	 Context context= new InitialContext();
		       AdminInterface proxy= (AdminInterface)context.lookup(jndiName);
		      int  id_agence=agency.getId();
		     System.out.println(id_agence);
		 
		 Alert alert=new Alert(Alert.AlertType.WARNING,"Are you ready to delete "+agency.getName(),ButtonType.YES,ButtonType.NO);
		   Optional<ButtonType> btnType=alert.showAndWait();
		   if(btnType.get()==ButtonType.YES)
		   {
			   if(proxy.DeleteAgency(id_agence))
			   {new Alert(Alert.AlertType.CONFIRMATION,"Agency "+agency.getName()+"has been deleted",ButtonType.CLOSE).show();
				ClearFields();
			  data.remove(agency);
		   }
		   else
		   {
			   new Alert(Alert.AlertType.ERROR,"Deleting Agency was failed",ButtonType.CLOSE).show();
		   }}
		   else if(btnType.get()==ButtonType.NO)
		   {
			   new Alert(Alert.AlertType.CONFIRMATION,"Deleting Agency was canceled",ButtonType.CLOSE).show(); 
		   }
		   
		   
	   }
	@FXML
	public void UpdateAgency(ActionEvent event) throws ParseException, NamingException
	{    
	   
	   String jndiName= "Pidev-Sprint1-ear/Pidev-Sprint1-ejb/AdminAgencyService!Interfaces.AdminInterface";
	   	 Context context= new InitialContext();
	       AdminInterface proxy= (AdminInterface)context.lookup(jndiName);
		agency.setAdress(Adresse.getText());
		agency.setEmail(Email.getText());
		agency.setName(Nom.getText());
		agency.setInformation(Info.getText());
		agency.setPhone(Phone.getText());
		agency.setCreation(Date.from(Picker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		if(proxy.updateEmploye(agency))
		{
			new Alert(Alert.AlertType.CONFIRMATION,"Agency was updated",ButtonType.CLOSE).show();
			ClearFields();
			data.set(t.getSelectionModel().getFocusedIndex(),agency);
			
		}
		else
		{
			  new Alert(Alert.AlertType.CONFIRMATION,"Deleting Agency was canceled",ButtonType.CLOSE).show(); 
		}
		
	}
	
				public void ClearFields()
				{ Phone.clear();
				Info.clear();
				Nom.clear();
				Email.clear();
				Adresse.clear();
			
					}
				@FXML
				public void AddAgency(ActionEvent event) throws NamingException
				{ String jndiName= "Pidev-Sprint1-ear/Pidev-Sprint1-ejb/AdminAgencyService!Interfaces.AdminInterface";
			    Context context= new InitialContext();
			    AdminInterface proxy= (AdminInterface)context.lookup(jndiName);
			    //connected id
			         int admin_id=1;
			    Agency agence=new Agency();
			    agence.setName(Nom.getText());
			    agence.setEmail(Email.getText());
			    agence.setPhone(Phone.getText());
			    agence.setInformation(Info.getText());
			    agence.setAdress(Adresse.getText());
			    agence.setCreation(java.sql.Date.valueOf(Picker.getValue()));
			    System.out.println(agence.getCreation());
			    int  id_agence= proxy.addAgency(agence);
			    proxy.affecterAgenceAdmin(admin_id, id_agence);
			    new Alert(Alert.AlertType.CONFIRMATION,"Agency was created",ButtonType.CLOSE).show();
			       ClearFields();
			       data.add(agence);
					
				}
			
}
