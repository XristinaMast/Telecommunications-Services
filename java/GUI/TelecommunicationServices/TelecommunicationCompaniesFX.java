package GUI.TelecommunicationServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
import classes.TelecommunicationCompany;

public class TelecommunicationCompaniesFX extends SceneCreator implements EventHandler<MouseEvent> {
	static ArrayList<TelecommunicationCompany> TeleList;
	
	//Δήλωση των FlowPane
	FlowPane buttonFlowPane,topFlowPane;
	//Δήλωση των GridPane
	GridPane inputFieldsPane;
	//Δήλωση του BorderPane
	BorderPane rootBorderPane;
	//Δήλωση των Buttons
	Button newCompBtn,upCompBtn,delCompBtn,exitBtn,searchCompBtn,listCompBtn,backBtn;
	//Δήλωση των Label
	Label passLbl,nameLbl,phoneLbl,emailLbl;
	//Δήλωση των TextField
	TextField passField,nameField,phoneField,emailField,searchField;
	//Δήλωση του TableView
	TableView<TelecommunicationCompany> TeleTableView;
	//Δήλωση του insets
	Insets insets; 
	
	
	public TelecommunicationCompaniesFX(double width,double height) {
		 super(width,height);
		 //Δημιουργία της λίστας με τα νούμερα 
		 TeleList = new ArrayList<>();
		 insets = new Insets(10);
		 
		 //Δημιουργία των Panes
		 rootBorderPane =new BorderPane();
		 buttonFlowPane=new FlowPane();
		 topFlowPane=new FlowPane();
		 inputFieldsPane=new GridPane();
		 //Δημιουργία των Labels
		 nameLbl= new Label("Επωνυμία");
		 phoneLbl=new Label("Τηλέφωνο");
		 emailLbl=new Label("E-mail");
		 passLbl=new Label("Κωδικός");
		
		 //Δημιουργία των Fields
		 passField=new TextField();
		 passField.setDisable(true);
		 nameField=new TextField();
		 phoneField=new TextField();
		 emailField=new TextField();
		 searchField=new TextField();
		 
		 //Δημιουργία των Buttons
		 newCompBtn=new Button("Νέα Εταιρία");
		 upCompBtn=new Button("Ενημέρωση");
		 delCompBtn=new Button("Διαγραφή");
		 exitBtn=new Button("Επιστροφή");
		 searchCompBtn=new Button("Αναζήτηση");
		 listCompBtn=new Button("Εταιρίες");
		 backBtn=new Button("Πίσω");
		 
		 //Δημιουργία του Table
		 TeleTableView= new TableView<>();
		 
		 //Attach events
	     exitBtn.setOnMouseClicked(this);
	     backBtn.setOnMouseClicked(this);
	     newCompBtn.setOnMouseClicked(this);
	     upCompBtn.setOnMouseClicked(this);
	     delCompBtn.setOnMouseClicked(this);
	     searchCompBtn.setOnMouseClicked(this);
	     listCompBtn.setOnMouseClicked(this);
	     TeleTableView.setOnMouseClicked(this);
	      
		 //Τοποθέτηση των FlowPane
	     buttonFlowPane.setHgap(10);
		 buttonFlowPane.getChildren().add(newCompBtn);
		 buttonFlowPane.getChildren().add(upCompBtn);
		 buttonFlowPane.getChildren().add(delCompBtn);
		 buttonFlowPane.getChildren().add(listCompBtn);
		 buttonFlowPane.getChildren().add(backBtn);
		 buttonFlowPane.getChildren().add(exitBtn);
		 buttonFlowPane.setAlignment(Pos.BOTTOM_LEFT);
		 		 
		 
		 topFlowPane.setHgap(10);
		 topFlowPane.getChildren().add(searchCompBtn);
		 topFlowPane.getChildren().add(searchField);
		 searchField.setPromptText("Αναζήτηση με επωνυμία");
		 topFlowPane.setAlignment(Pos.TOP_RIGHT);
		 
		//Τοποθέτηση των inputFieldsPane
		 inputFieldsPane.setAlignment(Pos.TOP_RIGHT);
		 inputFieldsPane.setVgap(10);
		 inputFieldsPane.setHgap(10);
		 //Τοποθέτηση των Labels
		 inputFieldsPane.add(passLbl,0,1);
		 inputFieldsPane.add(nameLbl,0,2);
		 inputFieldsPane.add(phoneLbl,0,3);
		 inputFieldsPane.add(emailLbl,0,4);
		
		 //Τοποθέτηση των Fields
		 inputFieldsPane.add(passField,1,1);
		 inputFieldsPane.add(nameField,1,2);
		 inputFieldsPane.add(phoneField,1,3);
		 inputFieldsPane.add(emailField,1,4);

		
         BorderPane.setAlignment(TeleTableView, Pos.CENTER);
         BorderPane.setAlignment(inputFieldsPane, Pos.CENTER_LEFT);
        
         BorderPane.setMargin(TeleTableView, insets);
         BorderPane.setMargin(inputFieldsPane, insets);
         BorderPane.setMargin(buttonFlowPane, insets);
         BorderPane.setMargin(topFlowPane, insets);
         
         rootBorderPane.setTop(topFlowPane);
        rootBorderPane.setRight(inputFieldsPane);
        rootBorderPane.setBottom(buttonFlowPane);
        rootBorderPane.setCenter(TeleTableView);

		 //Τοποθέτηση των στοιχείων του Table στο παράθυρο
		 TableColumn<TelecommunicationCompany,String> passColumn = new TableColumn<>("Κωδικός");
		 passColumn.setCellValueFactory(new PropertyValueFactory<>("password")); //pass the var from class TelecommunicationCompany
		 TeleTableView.getColumns().add(passColumn);
		 
		
		 TableColumn<TelecommunicationCompany,String> nameColumn = new TableColumn<>("Επωνυμία");
		 nameColumn.setCellValueFactory(new PropertyValueFactory<>("companyName")); //companyName the var from class TelecommunicationCompany
		 TeleTableView.getColumns().add(nameColumn);
		 
		
		 TableColumn<TelecommunicationCompany,String> phoneColumn = new TableColumn<>("Τηλέφωνο");
		 phoneColumn.setCellValueFactory(new PropertyValueFactory<>("mobile")); //mobile the var from class TelecommunicationCompany
		 TeleTableView.getColumns().add(phoneColumn);
		 
		
		 TableColumn<TelecommunicationCompany,String> emailColumn = new TableColumn<>("E-mail");
		 emailColumn.setCellValueFactory(new PropertyValueFactory<>("email")); //email the var from class TelecommunicationCompany
		 TeleTableView.getColumns().add(emailColumn); 
		 
		 upCompBtn.setDisable(true);
		 delCompBtn.setDisable(true);
		 backBtn.setDisable(true);
	}

	//Δημιουργία του παραθύρου
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
		}
		
		if (event.getSource()==listCompBtn) {
			tableSync();
		}
		
		if (event.getSource()==backBtn) {
			clearFields();
			tableSync();
			disableBtn(false,true);
		}
		
		if (event.getSource()==newCompBtn) {
			
			String password=passwordGenerator();
			String phone =removeSpaces(phoneField.getText());
			String email= removeSpaces(emailField.getText());;
			String companyName = removeSpaces(nameField.getText());;
			
			if (companyName.equals("") || phone.equals("") || email.equals("")) {
				alert("Παρακαλώ Συμπληρώστε όλα τα απαραίτητα πεδία!");
			}
			else {
				if (searchCompany(companyName)==-1) {
					if (checkFields(phone,companyName)==1) { 
						alert("Τα στοιχεία που καταχωρήσατε δεν είναι σωστά");
						phoneField.setText("");
					}
					else {
						createCompany(password,companyName,phone,email);
						tableSync();
						clearFields();
					}
				}
				else {
				  alert("Η εταιρία που επιθυμήτε να καταχωρίσετε, υπάρχει ήδη στο σύστημα");
			}
		  }
			
		}
			
		if (event.getSource()==searchCompBtn)
		{
			if (searchField.getText().equals("")) 
			{
				alert("Προσθέστε το όνομα μιας εταιρίας για να αναζητήσετε");
			}
			else 
			{
				String companyName =removeSpaces(searchField.getText());
				List<TelecommunicationCompany> items = TeleTableView.getItems();
				int i=searchCompany(companyName);
				if (i==-1) 
					alert("Η εταιρία που αναζητήσατε δεν υπάρχει");
				else {
					items.clear();
					items.add((TelecommunicationCompany) TeleList.get(i));
				}
				searchField.setText("");
			}
			clearFields();
		}
		
		if (event.getSource()==TeleTableView) {
			 TelecommunicationCompany selectedItem = TeleTableView.getSelectionModel().getSelectedItem();
			 if (selectedItem != null) {
				  disableBtn(true,false);
				  passField.setText(selectedItem.getPassword());
				  nameField.setText(selectedItem.getCompanyName());
	              phoneField.setText(selectedItem.getMobile());
	              emailField.setText(selectedItem.getEmail());
	         }
		}
		
	    if (event.getSource()==upCompBtn) {		
	    	String name = removeSpaces(nameField.getText());
			String phone =removeSpaces(phoneField.getText());
			String email= removeSpaces(emailField.getText());
			if (name.equals("") || phone.equals("") || email.equals("")) {
				alert("Παρακαλώ Συμπληρώστε όλα τα απαραίτητα πεδία!");
			}
			else {
				if (checkFields(phone,name)==1) { 
					alert("Τα στοιχεία που καταχωρήσατε δεν είναι σωστά");
				}
				else {
					updateCompany(name,phone,email);
					tableSync();
					clearFields();
					disableBtn(false,true);

					
				}
			}
			
		}
	    
	    if (event.getSource()==delCompBtn) {
	    	deleteCompany(nameField.getText());
	    	tableSync();
            clearFields();
            disableBtn(false,true);
	    }
	 }
	
	
	//Αποθήκευση στοιχείων μιας εταιρίας
	public void createCompany(String password,String companyName,String mobile,String email)
    {
		TelecommunicationCompany Comp = new TelecommunicationCompany(password,companyName,mobile,email);
		TeleList.add(Comp);
    }
	
	//Δημιουργία τυχαίου κωδικού για την κάθε εταιρία
	public static String passwordGenerator() {
		Random rand = new Random();
		int password=rand.nextInt(10000);
		String pass =String.valueOf(password);
		return pass;
	}
	
	//Αναζήτηση μιας εταιρίας με βάση το όνομα της
	public static int searchCompany(String name) {
	    int i;
		for (i=0;i<TeleList.size();i++) {
			if (TeleList.get(i).getCompanyName().equals(name)) {
			    return i;
			} 
		}
		return -1;
	}
	
	//Αποθήκευση νέων στοιχείων μιας υπάρχουσας εταιρίας
	public void updateCompany(String name,String mobile,String email) {
		 for (TelecommunicationCompany company : TeleList) {
	            if ((company.getCompanyName()).equals(name)) {
	            	company.setEmail(email);
	        		company.setMobile(mobile);
	            }
	        }
		
	}
	
	//Αναζήτηση ενός πλάνου μιας εταιρίας με βάση το όνομα της εταιρίας
	public int searchPlanList(String name) {
		for (int i = 0; i < PlanFX.PlanList.size(); i++) {
            if (PlanFX.PlanList.get(i).getCompany().equals(name)) {
                return 1;
            }
        }
		return -1;
	}
	
	//Διαγραφή μιας εταιρίας από τον πίνακα
	public void deleteCompany(String name) {
		if (searchPlanList(name)==-1)
		{
		  for (int i = 0; i < TeleList.size(); i++) {
	            if (TeleList.get(i).getCompanyName().equals(name)) {
	                TeleList.remove(i);
	                break;
	            }
	       }
		}
		else alert("Η εταιρία αυτή δεν μπορεί να διαγραφεί καθώς εκρεμμούν ενεργά προγράμματα");
	}
	
	//Έλεγχος έγκυρου αριθμού τηλεφώνου
	public static int checkPhone(String phone) {
		try {
			@SuppressWarnings("unused")
			long number=Long.parseLong(phone);
		}
		catch(NumberFormatException ex){
			return 0;
		}
		if (phone.length()!=10) {
			return 0;
		}
		else {
			return 1;
		}
	}
	
	//Έλεγχος μοναδικότητας του ονόματος
	public static int checkName(String name){
		   char[] chars = name.toCharArray();
			  for(char c : chars){
				  if(!(Character.isLetter(c))){
				     return 0;
				  }  
			 }
		     return 1;
	}
	
	//Ελέγχουμε αν τα fields ειναι σωστά
	public int checkFields(String phone,String name) {
		int i = 0;
		if (checkPhone(phone)==0) {
			phoneField.setText("");
			i = 1;
		}
		if (checkName(name)==0) {
			nameField.setText("");
			i = 1;
		}
		return i;
	}
	
	//Εμφανίζουμε τα στοιχεία στον πίνακα που εχουμε δημιουργήσει με το συμβόλαιο 
	public void tableSync() {
		  List<TelecommunicationCompany> items = TeleTableView.getItems();
	      items.clear();
	      for (TelecommunicationCompany company : TeleList) items.add((TelecommunicationCompany) company);
	 }
	
	//Δημιουργία παραθύρου Error σε περίπτωση λάθων στα στοιχεία που εισάχθηκαν
	public static void alert(String message) {
		 Alert alertType = new Alert(Alert.AlertType.ERROR);
         alertType.setTitle("Warning");
         alertType.setContentText(message);
         alertType.show();
	}
	
	//Απενεργοποιούμε τα κουμπιά του παραθύρου
	public void disableBtn(boolean btn1,boolean btn2) {
		nameField.setDisable(btn1);
		upCompBtn.setDisable(btn2);
		newCompBtn.setDisable(btn1);
		delCompBtn.setDisable(btn2);
		listCompBtn.setDisable(btn1);
		backBtn.setDisable(btn2);
	}
	
	//Αφαιρούμε τα κενά
	public static String removeSpaces(String string) {
		String noSpaceString = string.replaceAll("\\s", "");
		return noSpaceString;
	}
	
	//Αδειάζουμε τα TextField
    public void clearFields() {
    	passField.setText("");
        nameField.setText("");
        phoneField.setText("");
        emailField.setText("");
    }
	
}