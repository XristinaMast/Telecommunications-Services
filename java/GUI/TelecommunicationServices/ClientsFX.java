package GUI.TelecommunicationServices;

import java.util.ArrayList;



import java.util.List;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import classes.Client;
import classes.Contract;



public class ClientsFX extends SceneCreator implements EventHandler<MouseEvent> {
	
	static ArrayList<Client> ClientList;
	
	//Για την οριζόντια στοίχιση των button και των TextField κάνουμε import το rootFlowPane.
	FlowPane buttonFlowPane,topFlowPane;
	//Για να χωρίσουμε την οθόνη σε στήλες για την εμφάνιση πελατών κάνουμε import το GridPane. 
	GridPane inputFieldsPane;
	//Το borderPane είναι σαν το gridPane,ένα layer είναι
	BorderPane rootBorderPane;
	//Δήλωση των κουμπιών
	Button newClientBtn,upClientBtn,delClientBtn,backBtn,searchClientBtn,listClientsBtn,exitBtn;
	//Δήλωση των Label για να καταλαβαίνει ο χρήστης το είδος του στοιχείου που πρέπει να δηλώνει 
	Label idLbl,nameLbl,phoneLbl,emailLbl,addressLbl,statusLbl,afmLbl,lastNameLbl;
	//Δήλωση των TextField για να λαμβάνει το πρόγραμμα τα δεδομένα
	TextField idField,nameField,lastNameField,phoneField,emailField,addressField,statusField,afmField,searchAfmField,searchIdField;
	//Δήλωση του TableView για να εμφανίζεται στο GridPane η λίστα με τους εγγεγραμένους πελάτες
	TableView<Client> ClientTableView;
	//Το insets το βάζουμε για τα gaps αναμεσα στα Panes που βρίσκονται μέσα στο borderPane
	Insets insets;
	//Δημιουργούμε ένα κουμπί όπου ο χρηστης θα διαλέγει μία απο τις επιλογές που δίνονται για την αποφυγή εισαγωγής λάθος δεδομένων
	ComboBox<String> comboBox;
	
	
	public ClientsFX(double width,double height) {
		 super(width,height);
		 //δημιουργούμε νέο πίνακα με τους πελάτες
		 ClientList = new ArrayList<>();
		 insets = new Insets(10);
		 
		 comboBox = new ComboBox<String>();
		 
		 //Προσθέυουμε τις επιλογές του χρήστη στο ComboBox
		 comboBox.getItems().addAll(
				    "Ιδιώτης",
				    "Επαγγελματίας",
				    "Φοιτητής"
				);
		 comboBox.setValue("Ιδιώτης");
		 //Ενδεικτικά επίλεγουμε το "Ιδιώτης"
		 
		 //Δημιουργούμε τα Panes
		 rootBorderPane =new BorderPane();
		 buttonFlowPane=new FlowPane();
		 topFlowPane=new FlowPane();
		 //Δημιουργούμε τα Labels
		 idLbl=new Label("Αριθμός Δελτίου Ταυτότητας");
		 nameLbl= new Label("Όνομα");
		 lastNameLbl= new Label("Επίθετο");
		 afmLbl=new Label("Α.Φ.Μ");
		 phoneLbl=new Label("Τηλέφωνο");
		 emailLbl=new Label("E-mail");
		 addressLbl=new Label("Διεύθυνση");
		 statusLbl=new Label("Ιδιότητα");
		 //Δημιουργούμε τα Fields
		 idField=new TextField();
		 nameField=new TextField();
		 lastNameField=new TextField();
		 afmField=new TextField();
		 phoneField=new TextField();
		 emailField=new TextField();
		 addressField=new TextField();
		 //statusField=new TextField();
		 searchAfmField=new TextField();
		 searchIdField=new TextField();
		 //Δημιουργούμε τα Buttons
		 newClientBtn=new Button("Νέος Πελάτης");
		 upClientBtn=new Button("Ενημέρωση");
		 delClientBtn=new Button("Διαγραφή");
		 exitBtn=new Button("Επιστροφή");
		 searchClientBtn=new Button("Αναζήτηση");
		 listClientsBtn=new Button("Λίστα πελατών");
		 backBtn=new Button("Πίσω");
		 
		 //Δημιουργούμε τα inputFieldPane
		 inputFieldsPane=new GridPane();
		 //Δημιουργούμε το table
		 ClientTableView= new TableView<>();
		 
		 //Attach events
	      backBtn.setOnMouseClicked(this);
	      exitBtn.setOnMouseClicked(this);
	      newClientBtn.setOnMouseClicked(this);
	      upClientBtn.setOnMouseClicked(this);
	      delClientBtn.setOnMouseClicked(this);
	      searchClientBtn.setOnMouseClicked(this);
	      ClientTableView.setOnMouseClicked(this);
	      listClientsBtn.setOnMouseClicked(this);
		 
		 //Τοποθετούμε τα FlowPane στο παράθυρο
		 buttonFlowPane.setHgap(10);
		 buttonFlowPane.getChildren().add(newClientBtn);
		 buttonFlowPane.getChildren().add(upClientBtn);
		 buttonFlowPane.getChildren().add(delClientBtn);
		 buttonFlowPane.getChildren().add(listClientsBtn);
		 buttonFlowPane.getChildren().add(backBtn);
		 buttonFlowPane.getChildren().add(exitBtn);
		 buttonFlowPane.setAlignment(Pos.BOTTOM_LEFT);
		 
		 topFlowPane.setHgap(15);
		 topFlowPane.getChildren().add(searchClientBtn);
		 topFlowPane.getChildren().add(searchAfmField);
		 topFlowPane.getChildren().add(searchIdField);
		 
		 topFlowPane.setAlignment(Pos.TOP_RIGHT);
		 
		//Τοποθετούμε τα inputFieldsPane στο παράθυρο
		 inputFieldsPane.setAlignment(Pos.TOP_RIGHT);
		 inputFieldsPane.setVgap(10);
		 inputFieldsPane.setHgap(10);
		 //Τοποθετούμε τα Labels στο παράθυρο
		 inputFieldsPane.add(idLbl,0,1);
		 inputFieldsPane.add(afmLbl,0,2);
		 inputFieldsPane.add(nameLbl,0,3);
		 inputFieldsPane.add(lastNameLbl,0,4);
		 inputFieldsPane.add(statusLbl,0,5);
		 inputFieldsPane.add(addressLbl,0,6);
		 inputFieldsPane.add(phoneLbl,0,7);
		 inputFieldsPane.add(emailLbl,0,8);

		 
		 searchAfmField.setPromptText("Αναζήτηση με ΑΦΜ");
		 searchIdField.setPromptText("Αναζήτηση με Α.T");
		 //Τοποθετούμε τα Fields στο παράθυρο
		 inputFieldsPane.add(idField,1,1);
		 inputFieldsPane.add(afmField,1,2);
		 inputFieldsPane.add(nameField,1,3);
		 inputFieldsPane.add(lastNameField,1,4);
		 inputFieldsPane.add(comboBox,1,5);
		 inputFieldsPane.add(addressField,1,6);
		 inputFieldsPane.add(phoneField,1,7);
		 inputFieldsPane.add(emailField,1,8);

	
		 
		//Τοποθετούμε τα rootBorderPane στο παράθυρο
		 BorderPane.setAlignment(ClientTableView, Pos.CENTER);
         BorderPane.setAlignment(inputFieldsPane, Pos.CENTER_LEFT);
        
         BorderPane.setMargin(topFlowPane, insets);
         BorderPane.setMargin(ClientTableView, insets);
         BorderPane.setMargin(inputFieldsPane, insets);
         BorderPane.setMargin(buttonFlowPane, insets);
         
         rootBorderPane.setTop(topFlowPane);
        rootBorderPane.setRight(inputFieldsPane);
        rootBorderPane.setBottom(buttonFlowPane);
        rootBorderPane.setCenter(ClientTableView);
	

		 
		 //Οργανώνουμε τα στοιχεία του Table στο παράθυρο
		 TableColumn<Client,String> idColumn = new TableColumn<>("Αριθμός Δελτίου Ταυτότητας");
		 idColumn.setCellValueFactory(new PropertyValueFactory<>("IDnumber")); //pass the var from class Client
		 ClientTableView.getColumns().add(idColumn);
        
		
		 TableColumn<Client,String> afmColumn = new TableColumn<>("Α.Φ.Μ");
		 afmColumn.setCellValueFactory(new PropertyValueFactory<>("AFM")); //companyafm the var from class Client
		 ClientTableView.getColumns().add(afmColumn);
		 
		
		 TableColumn<Client,String> nameColumn = new TableColumn<>("Όνομα");
		 nameColumn.setCellValueFactory(new PropertyValueFactory<>("name")); //mobile the var from class Client
		 ClientTableView.getColumns().add(nameColumn);
		 
		 TableColumn<Client,String> lastColumn = new TableColumn<>("Επίθετο");
		 lastColumn.setCellValueFactory(new PropertyValueFactory<>("lastName")); //mobile the var from class Client
		 ClientTableView.getColumns().add(lastColumn);
		
		 TableColumn<Client,String> statusColumn = new TableColumn<>("Ιδιότητα");
		 statusColumn.setCellValueFactory(new PropertyValueFactory<>("status")); //status the var from class Client
		 ClientTableView.getColumns().add(statusColumn); 
		 
		 TableColumn<Client,String> addressColumn = new TableColumn<>("Διεύθυνση");
		 addressColumn.setCellValueFactory(new PropertyValueFactory<>("address")); //address the var from class Client
		 ClientTableView.getColumns().add(addressColumn);
		 
		 TableColumn<Client,String> phoneColumn = new TableColumn<>("Τηλέφωνο");
		 phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber")); //phone the var from class Client
		 ClientTableView.getColumns().add(phoneColumn);
		 
		 TableColumn<Client,String> emailColumn = new TableColumn<>("E-mail");
		 emailColumn.setCellValueFactory(new PropertyValueFactory<>("email")); //email the var from class Client
		 ClientTableView.getColumns().add(emailColumn);
		 
		 delClientBtn.setDisable(true);
		 upClientBtn.setDisable(true);
		 backBtn.setDisable(true);
	} 

	//Δημιουργούμε το παράθυρο
	public Scene CreateScene() {
		Scene tmp=new Scene(rootBorderPane,width,height);
		return tmp;
	}
	
	//Παίρνουμε περιπτώσεις για τα κουμπιά που μπορεί να πατήσει ο χρήστης ώστε το πρόγραμμα να αντιδράσει καταλλήλως
	@Override
	public void handle(MouseEvent event) {
		if (event.getSource()==exitBtn) {
			App.stage1.setTitle("Κατάστημα Παροχής Τηλεπικοινωνιών Υπηρεσιών");
			App.stage1.setScene (App.mainScene);
			clearFields();
			disableBtn(false,true);
			tableSync();
			
		}
		
		if (event.getSource()==backBtn) {
			tableSync();
			clearFields();
			disableBtn(false,true);
			
		}
		
		//Δημιουργία ενός πελάτη
		if (event.getSource()==newClientBtn) {
			String id =  TelecommunicationCompaniesFX.removeSpaces(idField.getText());
			String name =  TelecommunicationCompaniesFX.removeSpaces(nameField.getText());
			String lastname =  TelecommunicationCompaniesFX.removeSpaces(lastNameField.getText());
			String afm = TelecommunicationCompaniesFX.removeSpaces(afmField.getText());
			String status = comboBox.getValue();
			String address = TelecommunicationCompaniesFX.removeSpaces(addressField.getText());
			String email = TelecommunicationCompaniesFX.removeSpaces(emailField.getText());
			String phone= TelecommunicationCompaniesFX.removeSpaces(phoneField.getText());
			if (id.equals("") || name.equals("") || lastname.equals("") || afm.equals("") || address.equals("") || email.equals("") || phone.equals("")) {
				TelecommunicationCompaniesFX.alert("Παρακαλώ Συμπληρώστε όλα τα απαραίτητα πεδία!");
			}
			else {
				if (checkNewFields(name,lastname,id,afm,phone) == 1) {
					TelecommunicationCompaniesFX.alert("Κάποια απο τα στοιχεία που συμπληρώσατε δεν είναι σωστά");
				}
				else { //Αφού σιγουρευτούμε ότι ο χρήστης έδωσε σωστά τα ζητούμενα δεδομένα τότε:
					createClient(id,afm,name,lastname,status,address,phone,email); // δημιουργούμε το αντικειμενο για να το αποθηκέυσουμε στον πίνακα
					clearFields(); //Διαγράφουμε τα δεδομένα από τα TextFields για να μπορεί ο χρήστης να εισάγει νέα
					tableSync();// τα δηλώνουμε στον πίνακα όπου και εμφανίζουμε τα στοιχεία που εισάχθηκαν
				}
			}
		}
		
		if (event.getSource()==listClientsBtn) {
			tableSync();
		}
		
		//Αναζήτηση και εμφάνιση ενός πελάτη
		if (event.getSource()==searchClientBtn) {
			listClientsBtn.setDisable(false);
			if (searchIdField.getText().equals("") && !(searchAfmField.getText().equals(""))){
				searchByAfm(searchAfmField.getText());
			}
			if (!(searchIdField.getText().equals("")) && searchAfmField.getText().equals("")) {
				searchById(searchIdField.getText());
			}
			if (searchIdField.getText().equals("") && searchAfmField.getText().equals("")) {
				TelecommunicationCompaniesFX.alert("Συμπληρώστε τουλάχιστον ένα πεδίο");
			}
			if (!(searchIdField.getText().equals("") || searchAfmField.getText().equals(""))) {
				searchByIdAndAfm(searchIdField.getText(),searchAfmField.getText());
			}
			searchIdField.setText("");
			searchAfmField.setText("");
		}
		
		//Αλλαγή στοιχείων ενός πελάτη
		if (event.getSource()==upClientBtn) 
		{
			String id = idField.getText();
			String afm = afmField.getText();
			String name =  TelecommunicationCompaniesFX.removeSpaces(nameField.getText());
			String lastname =  TelecommunicationCompaniesFX.removeSpaces(lastNameField.getText());
			String status = comboBox.getValue();
			String address = TelecommunicationCompaniesFX.removeSpaces(addressField.getText());
			String email = TelecommunicationCompaniesFX.removeSpaces(emailField.getText());
			String phone= TelecommunicationCompaniesFX.removeSpaces(phoneField.getText());
			if (name.equals("") || lastname.equals("") || address.equals("") || email.equals("") || phone.equals("")) {
				TelecommunicationCompaniesFX.alert("Παρακαλώ Συμπληρώστε όλα τα απαραίτητα πεδία!");
			}
			else 
			{
				if (checkUpdateFields(name,lastname,phone)==1) 
				{
					TelecommunicationCompaniesFX.alert("Κάποια απο τα στοιχεία που συμπληρώσατε δεν είναι σωστά");
				}
				else 
				{
					updateClient(id,afm,name,lastname,status,address,phone,email);	
					disableBtn(false,true);
					clearFields();
					tableSync();
				}
			}
		}
		
		//Εμφάνιση του πίνακα με τους εγγεγραμμένους πελάτες
		if (event.getSource()==ClientTableView) {
			 Client selectedItem = ClientTableView.getSelectionModel().getSelectedItem();
			 if (selectedItem != null) {
				  disableBtn(true,false);
				  idField.setText(selectedItem.getIDnumber());
				  afmField.setText(selectedItem.getAFM());
				  nameField.setText(selectedItem.getName());
				  lastNameField.setText(selectedItem.getLastName());
	              phoneField.setText(selectedItem.getPhoneNumber());
	              emailField.setText(selectedItem.getEmail());
	              addressField.setText(selectedItem.getAddress());
	        }
		}
		
		if (event.getSource()==delClientBtn) {
			delClient();
			clearFields();
			disableBtn(false,true);
			tableSync();
		}
	}

	//προσθήκη πελάτη στην λίστα 
	public void createClient(String id,String afm,String name,String lastname,String status,String address,String phone,String email) {
		Client client = new Client(id,afm,name,lastname,status,address,phone,email);
		ClientList.add(client);
	}
	
	//Αναζήτηση πελατών με Αριθμό Ταυτότητας 
	public void searchById(String id) {
		List<Client> items = ClientTableView.getItems();
		items.clear();
		for (int i=0;i<ClientList.size();i++) {
			if (ClientList.get(i).getIDnumber().equals(id)) {
				items.add((Client) ClientList.get(i));
			}
		}
	}
	
	//Αναζήτηση πελατών με ΑΦΜ
	public void searchByAfm(String afm) {
		List<Client> items = ClientTableView.getItems();
		items.clear();
		for (int i=0;i<ClientList.size();i++) {
			if (ClientList.get(i).getAFM().equals(afm)) {
				items.add((Client) ClientList.get(i));
			}
		}
	}
	
	//Αναζήτηση πελατών με Αριθμό Ταυτότητας  και ΑΦΜ
    public void searchByIdAndAfm(String id,String afm) {
		List<Client> items = ClientTableView.getItems();
		items.clear();
		for (int i=0;i<ClientList.size();i++) {
			if (ClientList.get(i).getIDnumber().equals(id) && ClientList.get(i).getAFM().equals(afm)) {
				items.add((Client) ClientList.get(i));
			}
		}
	}
	
    //'Ελεγχος σωστής εισαγωγής ταυτότητας
	public int checkId(String id) {
		try {
			@SuppressWarnings("unused")
			long number=Long.parseLong(id);
		}
		catch(NumberFormatException ex){
			return 0;
		}
	
		if (id.length()!= 6) {
			return 0;
		}
		else {
			for (Client client: ClientList) {
				if (client.getIDnumber().equals(id)) {
					return 0;
				}
			}
		}
		return 1;
	}
	
	//'Ελεγχος σωστής εισαγωγής ΑΦΜ
	public int checkAfm(String afm) {
		try {
			@SuppressWarnings("unused")
			long number=Long.parseLong(afm);
		}
		catch(NumberFormatException ex){
			return 0;
		}
	
		if (afm.length()!= 9) {
			return 0;
		}
		else {
			for (Client client: ClientList) {
				if (client.getAFM().equals(afm)) {
					return 0;
				}
			}
		}
	   return 1;
	}
	
	//Έλεγχος για το άν έχουν συμπληρωθεί όλα τα πεδία στην δημιουργία νέου πελάτη
	public int checkNewFields(String name,String lastname,String id,String afm,String phone) {
		int i = 0;
		if (checkId(id)==0) {
			idField.setText("");
			i = 1;
		}
		if (TelecommunicationCompaniesFX.checkName(name)==0) {
			nameField.setText("");
			i = 1;
		}
		if (TelecommunicationCompaniesFX.checkName(lastname)==0) {
			lastNameField.setText("");
			i = 1;
		}
		if (checkAfm(afm)==0) {
		    afmField.setText("");
		    i = 1;
		}
		if (TelecommunicationCompaniesFX.checkPhone(phone)==0) {
			phoneField.setText("");
			i = 1;
		}
	    return i;
		
	}
	
	//Έλεγχος για το άν έχουν συμπληρωθεί όλα τα πεδία στην αλλαγή στοιχείων ενός πελάτη
	public int checkUpdateFields(String name,String lastname,String phone) {
		int i = 0;
		if (TelecommunicationCompaniesFX.checkName(name)==0) {
			nameField.setText("");
			i = 1;
		}
		if (TelecommunicationCompaniesFX.checkName(lastname)==0) {
			lastNameField.setText("");
			i = 1;
		}
		if (TelecommunicationCompaniesFX.checkPhone(phone)==0) {
			phoneField.setText("");
			i = 1;
		}
	    return i;
		
	}
	
	//Αποθήκευση των νέων στοιχείων του πελάτη
	public void updateClient(String id,String afm,String name,String lastname,String status,String address,String phone,String email) {
		for (Client client: ClientList) {
			if (client.getIDnumber().equals(id) && client.getAFM().equals(afm)) {
				client.setAddress(address);
				client.setEmail(email);
				client.setPhoneNumber(phone);
				client.setStatus(status);
				client.setName(name);
				client.setLastName(lastname);
			}
			
		}
	}
	
	//Διαγραφή ενός πελάτη εφόσον δεν υπάρχει κάποιο ενεργό συμβόλαιο στο όνομα του
	public void delClient() {
		if (searchContList()==1) {
			for (Client client: ClientList) {
				if (client.getAFM().equals(afmField.getText())) {
					ClientList.remove(client);
					break;
				}
			}	

		}
		else TelecommunicationCompaniesFX.alert("Ο πελάτης δεν μπορεί να διαγραφεί καθώς υπάρχουν καταχωρημένα συμβόλαια στο όνομά του!");
	}
	
	//Προσθήκη των στοιχείων ενος πελάτη στον πίνακα
	public void tableSync() {
		List<Client> items = ClientTableView.getItems();
	    items.clear();
		for (Client client: ClientList) {
			items.add((Client) client);
			
		}
	}
	
	//Αναζήτηση ενεργών συμβολαίων για την διαγραφή ενός πελάτη
	public int searchContList() {
		for (Contract contract: ContractFX2.ContList) {
			if (contract.getCode().contains(afmField.getText())) {
				return 0;
				
			}
		}
		return 1;
	}
	
	//Τα κουμπιά απενεργοποιούνται σε ορισμένες καταστάσεις για παράδειγμα όταν: πατήσεις σε ένα στοιχείο του πίνακα να μην μπορείς να πατήσεις δημιουργεία νεου αντικειμένου, βγάζει error στον χρήστη όταν έχει εισάγει λάθος δεδομένα και
	public void disableBtn(boolean btn1,boolean btn2) {
		idField.setDisable(btn1);
		afmField.setDisable(btn1);
		upClientBtn.setDisable(btn2);
		newClientBtn.setDisable(btn1);
		delClientBtn.setDisable(btn2);
		listClientsBtn.setDisable(btn1);
		backBtn.setDisable(btn2);
	}
	
	//Μετά την δημιουργία νέου πελάτη ή τις αλλαγές στα στοιχεία ενός πελάτη, "καθαρίζουμε" τα TextFields για να μπορεί ο χρήστης μα εισάγει νέα δεδομένα
	public void clearFields() {
		idField.setText("");
		afmField.setText("");
		nameField.setText("");
		lastNameField.setText("");
		addressField.setText("");
		phoneField.setText("");
		emailField.setText("");
		
	}
}


