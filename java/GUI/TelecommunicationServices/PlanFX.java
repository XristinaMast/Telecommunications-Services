package GUI.TelecommunicationServices;

import javafx.geometry.Insets;
import java.util.ArrayList;
import java.util.List;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import classes.*;

public class PlanFX extends SceneCreator implements EventHandler<MouseEvent> {
	
	static ArrayList<Plan> PlanList;

	//Δήλωση των FlowPane
	FlowPane buttonFlowPane,topFlowPane;
	//Δήλωση των GridPane
	GridPane inputFieldsPane;
	//Δήλωση των BoarderPane
	BorderPane rootBorderPane;
	//Δήλωση των Buttons
	Button newPlanBtn,upPlanBtn,delPlanBtn,exitBtn,searchPlanBtn,listPlansBtn,backBtn;
	//Δήλωση των  Labels
	Label sms_Speed_Lbl,gigabytes_lineType_Lbl,costLbl,companyLbl,passLbl,freeCallsLbl;
	//Δήλωση των TextFields
	TextField passField,companyField,costField,sms_Speed_Field,gigabytes_lineType_Field,freeCallsField,searchField;
	//Δήλωση των TableView, έχουμε 2 πίνακες ο ένας είναι για τα κινητά τηλέφωνα και ο άλλος για τα σταθερά τηλέφωνα
	TableView<MobilePlan> mobilePlanTableView;
	TableView<LandPlan> landPlanTableView;
	//Δήλωση των RadioButtons, για να επιλέγει ο χρήστης αν θέλει κινητή ή σταθερή τηλεφωνία. Είναι κάτι παρόμοιο με το ComboBox όνο που διαφέρει στην εμφάνιση καθώς φαίνονται όλες οι επιλογές.
	RadioButton radioButton1,radioButton2;
	//Δήλωση του insets
	Insets insets;
	
	public PlanFX(double width,double height) {
		super(width,height);
		//Δημιουργούμε έναν πίνακα εμ τα πακέτα που θα δηλώνει ο χρήστης
		PlanList = new ArrayList<>();
		insets =new Insets(10);
		 
		//Δημιουργούμε τα κατάλληλα Panes
		rootBorderPane = new BorderPane();
		buttonFlowPane = new FlowPane();
		topFlowPane = new FlowPane();
		 
		//Δημιουργούμε τα Labels
		passLbl = new Label("Κωδικός");
		companyLbl = new Label("Εταιρία");
		costLbl = new Label("Κόστος Προγράμματος");
		sms_Speed_Lbl = new Label("SMS");
		gigabytes_lineType_Lbl = new Label("Gigabyte");
		freeCallsLbl = new Label("Δωρεάν Λεπτά Ομιλίας");
		 
		//Δημιουργούμε τα RadioButtons
		radioButton1 = new RadioButton("Πρόγραμμα Κινητής");
		radioButton2 = new RadioButton("Πρόγραμμα Σταθερής");
		 
		//Δημιουργούμε τα Fields
		passField = new TextField();
		companyField = new TextField();
		costField = new TextField();
		sms_Speed_Field = new TextField();
		gigabytes_lineType_Field = new TextField();
		freeCallsField = new TextField();
		searchField = new TextField();
	
		//Δημιουργούμε τα Buttons
		newPlanBtn = new Button("Νέο Πρόγραμμα");
		upPlanBtn = new Button("Ενημέρωση");
		delPlanBtn = new Button("Διαγραφή");
		exitBtn = new Button("Επιστροφή");
		searchPlanBtn = new Button("Αναζήτηση");
		listPlansBtn = new Button("Προγράμματα");
		backBtn = new Button("Πίσω");
		//Δημιουργούμε τα inputFieldPane
		inputFieldsPane = new GridPane();
		//Δημιουργούμε τα κατάλληλα TableView έτσι ώστε ο χρήστης να βλέπει τα αντίστοιχα πακέτα όταν επιλέγει απο τα RadioButtons σταθερή ή κινητή τηλεφωνία.
		mobilePlanTableView = new TableView<>();
		landPlanTableView = new TableView<>();
		 
		//Επίσης εδώ groupαρω τα radiobuttons ωστε όταν επιλέγω ένα το άλλο να σβήνεται
		final ToggleGroup group = new ToggleGroup();
		radioButton1.setToggleGroup(group); //Το radioButton1.setSelected(true) χρησιμοποιείται για να προεπιλέγει το 1ο radioButton
		radioButton1.setSelected(true);
		radioButton2.setToggleGroup(group);
		 
		//Attach events
	    exitBtn.setOnMouseClicked(this);
	    backBtn.setOnMouseClicked(this);
	    newPlanBtn.setOnMouseClicked(this);
	    upPlanBtn.setOnMouseClicked(this);
	    delPlanBtn.setOnMouseClicked(this);
	    searchPlanBtn.setOnMouseClicked(this);
	    listPlansBtn.setOnMouseClicked(this);
	    mobilePlanTableView.setOnMouseClicked(this);
	    landPlanTableView.setOnMouseClicked(this);
	    radioButton1.setOnMouseClicked(this);
	    radioButton2.setOnMouseClicked(this);
			 
		//Τοποθετούμε τα FlowPane στο παράθυρο
		buttonFlowPane.setHgap(10);
		buttonFlowPane.getChildren().add(newPlanBtn);
		buttonFlowPane.getChildren().add(upPlanBtn);
		buttonFlowPane.getChildren().add(delPlanBtn);
		buttonFlowPane.getChildren().add(listPlansBtn);
		buttonFlowPane.getChildren().add(backBtn);
		buttonFlowPane.getChildren().add(exitBtn);
		
		buttonFlowPane.setAlignment(Pos.BOTTOM_LEFT);
		
		topFlowPane.setHgap(10);
		topFlowPane.getChildren().add(searchPlanBtn);
		topFlowPane.getChildren().add(searchField);
		topFlowPane.setAlignment(Pos.TOP_RIGHT);
		 
		//Τοποθετούμε τα inputFieldsPane στο παράθυρο
		inputFieldsPane.setAlignment(Pos.TOP_RIGHT);
		inputFieldsPane.setVgap(10);
		inputFieldsPane.setHgap(10);
		//Labels
		inputFieldsPane.add(passLbl,0,1);
		inputFieldsPane.add(companyLbl,0,2);
		inputFieldsPane.add(costLbl,0,3);
		inputFieldsPane.add(freeCallsLbl,0,4);
		inputFieldsPane.add(sms_Speed_Lbl,0,5);
		inputFieldsPane.add(gigabytes_lineType_Lbl,0,6);

		//Τοποθετούμε τα Fields στο παράθυρο
		searchField.setPromptText("Αναζήτηση με όνομα");
		
		inputFieldsPane.add(passField,1,1);
		inputFieldsPane.add(companyField,1,2);
		inputFieldsPane.add(costField,1,3);
		inputFieldsPane.add(freeCallsField,1,4);
		inputFieldsPane.add(sms_Speed_Field,1,5);
		inputFieldsPane.add(gigabytes_lineType_Field,1,6);

		inputFieldsPane.setVgap(20);
		inputFieldsPane.add(radioButton1,1,9);
		inputFieldsPane.add(radioButton2,1,10);
		
		//Τοποθετούμε τα rootBorderPane στο παράθυρο
		BorderPane.setAlignment(mobilePlanTableView, Pos.CENTER);
        BorderPane.setAlignment(inputFieldsPane, Pos.CENTER_LEFT);
        
        BorderPane.setMargin(mobilePlanTableView, insets);
        BorderPane.setMargin(inputFieldsPane, insets);
        BorderPane.setMargin(buttonFlowPane, insets);
        BorderPane.setMargin(topFlowPane, insets);
         
        rootBorderPane.setTop(topFlowPane);
        rootBorderPane.setRight(inputFieldsPane);
        rootBorderPane.setBottom(buttonFlowPane);
        rootBorderPane.setCenter(mobilePlanTableView);
		 
	 
		//Τοποθετούμε τα στοιχεία του MobilePlanTableView στο παράθυρο
		TableColumn<MobilePlan,String> passColumn = new TableColumn<>("Κωδικός");
		passColumn.setCellValueFactory(new PropertyValueFactory<>("unPass")); //pass the var from class MobilePlan
		mobilePlanTableView.getColumns().add(passColumn);
		 
		
		TableColumn<MobilePlan,String> companyColumn = new TableColumn<>("Εταιρία");
		companyColumn.setCellValueFactory(new PropertyValueFactory<>("company")); //companycompany the var from class MobilePlan
		mobilePlanTableView.getColumns().add(companyColumn);
		 
		
		TableColumn<MobilePlan,String> costColumn = new TableColumn<>("Κόστος");
		costColumn.setCellValueFactory(new PropertyValueFactory<>("price")); //mobile the var from class MobilePlan
		mobilePlanTableView.getColumns().add(costColumn);
		 
		TableColumn<MobilePlan,String> freeCallsColumn = new TableColumn<>("Δωρεάν Λεπτά");
		freeCallsColumn.setCellValueFactory(new PropertyValueFactory<>("freeCalls")); //pass the var from class MobilePlan
		mobilePlanTableView.getColumns().add(freeCallsColumn);
		
		TableColumn<MobilePlan,String> smsColumn = new TableColumn<>("SMS");
		smsColumn.setCellValueFactory(new PropertyValueFactory<>("sms")); //sms the var from class MobilePlan
		mobilePlanTableView.getColumns().add(smsColumn); 
		 
		TableColumn<MobilePlan,String> gigabytesColumn = new TableColumn<>("GB");
		gigabytesColumn.setCellValueFactory(new PropertyValueFactory<>("GB")); //gigabytes the var from class MobilePlan
		mobilePlanTableView.getColumns().add(gigabytesColumn);
		 
		 
		//Τοποθετούμε τα στοιχεία του LandLinePlanTableView στο παράθυρο
		TableColumn<LandPlan,String> passColumn2 = new TableColumn<>("Κωδικός");
		passColumn2.setCellValueFactory(new PropertyValueFactory<>("unPass")); //pass the var from class LandPlan
		landPlanTableView.getColumns().add(passColumn2);
		 
		
		TableColumn<LandPlan,String> companyColumn2 = new TableColumn<>("Εταιρία");
		companyColumn2.setCellValueFactory(new PropertyValueFactory<>("company")); //companycompany the var from class LandPlan
		landPlanTableView.getColumns().add(companyColumn2);
		 
		
		TableColumn<LandPlan,String> costColumn2 = new TableColumn<>("Κόστος");
		costColumn2.setCellValueFactory(new PropertyValueFactory<>("price")); //Land the var from class LandPlan
		landPlanTableView.getColumns().add(costColumn2);
		
		TableColumn<LandPlan,String> freeCalls2Column = new TableColumn<>("Δωρεάν Λεπτά");
		freeCalls2Column.setCellValueFactory(new PropertyValueFactory<>("freeCalls")); //pass the var from class MobilePlan
		landPlanTableView.getColumns().add(freeCalls2Column);
		
		
		TableColumn<LandPlan,String> speedColumn = new TableColumn<>("Speed");
		speedColumn.setCellValueFactory(new PropertyValueFactory<>("speed")); //sms the var from class LandPlan
		landPlanTableView.getColumns().add(speedColumn); 
		 
		TableColumn<LandPlan,String> lineTypeColumn = new TableColumn<>("Line");
		lineTypeColumn.setCellValueFactory(new PropertyValueFactory<>("lineType")); //gigabytes the var from class LandPlan
		landPlanTableView.getColumns().add(lineTypeColumn);
		
		//Απενεργοποίηση κουμπιών
		upPlanBtn.setDisable(true);
		passField.setDisable(true);
		delPlanBtn.setDisable(true);
		backBtn.setDisable(true);
		
	} 

	//Δημιουργία της σκηνής
	public Scene CreateScene() {
		Scene tmp=new Scene(rootBorderPane,width,height);
		return tmp;
	}
	
	//Παίρνουμε περιπτώσεις για τα κουμπιά που μπορεί να πατήσει ο χρήστης ώστε το πρόγραμμα να αντιδράσει καταλλήλως
	@Override
	public void handle(MouseEvent event) {
		if (event.getSource() == exitBtn) {
			App.stage1.setTitle("Κατάστημα Παροχής Τηλεπικοινωνιών Υπηρεσιών");
			App.stage1.setScene (App.mainScene);
			radioButton1.setSelected(true);
			disableBtn(false,true);
			setMobilePlanScene();
			clearFields();
		}
		if (event.getSource() == radioButton2) {
			setLandPlanScene();
			disableBtn(false,true);
			clearFields();
		}
		if (event.getSource() == radioButton1) {
			setMobilePlanScene();
			disableBtn(false,true);
			clearFields();
			
		}
		
		if (event.getSource() == newPlanBtn) {
		
			String password = TelecommunicationCompaniesFX.passwordGenerator();
			String company = TelecommunicationCompaniesFX.removeSpaces(companyField.getText());
			String freeCalls = TelecommunicationCompaniesFX.removeSpaces(freeCallsField.getText());
			String cost = TelecommunicationCompaniesFX.removeSpaces(costField.getText());
			String sms_Speed = TelecommunicationCompaniesFX.removeSpaces(sms_Speed_Field.getText());
			String gigabytes_LineType = TelecommunicationCompaniesFX.removeSpaces(gigabytes_lineType_Field.getText());
			
			if (company.equals("") || cost.equals("") || sms_Speed.equals("") || gigabytes_LineType.equals("") || freeCalls.equals("")) {
				TelecommunicationCompaniesFX.alert("Παρακαλώ Συμπληρώστε όλα τα απαραίτητα πεδία!");
			}
			else {
				if (radioButton1.isSelected()) 
				{
					if (TelecommunicationCompaniesFX.searchCompany(company) == -1) {
						TelecommunicationCompaniesFX.alert("Η εταιρία της οποίας το πρόγραμμα θέλετε να καταχωρήσετε δεν υπάρχει στο σύστημα");
					}
					else {
						if (FieldsCheck(company,cost,sms_Speed,gigabytes_LineType,freeCalls) == 1) {
						TelecommunicationCompaniesFX.alert("Tα δεδομένα που εισάγατε δεν είναι αποδεκτά");
						}
						else {
							createPlan(password,company,freeCalls,cost,sms_Speed,gigabytes_LineType);
							tableSync();
							clearFields();
						}
					}
				}
				else if (radioButton2.isSelected())
				{
					if (TelecommunicationCompaniesFX.searchCompany(company) == -1) {
						TelecommunicationCompaniesFX.alert("Η εταιρία της οποίας το πρόγραμμα θέλετε να καταχωρήσετε δεν υπάρχει στο σύστημα");
					}
					else {
						if (FieldsCheck(company,cost,sms_Speed,gigabytes_LineType,freeCalls) == 1) {
							TelecommunicationCompaniesFX.alert("Tα δεδομένα που εισάγατε δεν είναι αποδεκτά");
						}
						else {
							createPlan(password,company,freeCalls,cost,sms_Speed,gigabytes_LineType.toUpperCase());
							tableSync();
							clearFields();
						}
					}
					
				}
		
			}
			
		}
		
		if (event.getSource() == upPlanBtn) {	
			String company = companyField.getText();
			String password = passField.getText();
			String freeCalls = TelecommunicationCompaniesFX.removeSpaces(freeCallsField.getText());
			String cost = TelecommunicationCompaniesFX.removeSpaces(costField.getText());
			String sms_Speed = TelecommunicationCompaniesFX.removeSpaces(sms_Speed_Field.getText());
			String gigabytes_LineType = TelecommunicationCompaniesFX.removeSpaces(gigabytes_lineType_Field.getText());
			if (cost.equals("") || sms_Speed.equals("") || gigabytes_LineType.equals("") || freeCalls.equals("")) {
				TelecommunicationCompaniesFX.alert("Παρακαλώ Συμπληρώστε όλα τα απαραίτητα πεδία!");
			}
			else {
				if (radioButton1.isSelected()) 
				{
					if (FieldsCheck(company,cost,sms_Speed,gigabytes_LineType,freeCalls) == 1) {
					TelecommunicationCompaniesFX.alert("Tα δεδομένα που εισάγατε δεν είναι αποδεκτά");
					}
					else {
						updatePlan(password,cost,sms_Speed,gigabytes_LineType,freeCalls);
						tableSync();
						disableBtn(false,true);
						clearFields();
					}
				}
				else if (radioButton2.isSelected())
				{
					if (FieldsCheck(company,cost,sms_Speed,gigabytes_LineType,freeCalls) == 1) {
						TelecommunicationCompaniesFX.alert("Tα δεδομένα που εισάγατε δεν είναι αποδεκτά");
					}
					else {
						updatePlan(password,cost,sms_Speed,gigabytes_LineType.toUpperCase(),freeCalls);
						tableSync();
						disableBtn(false,true);
						clearFields();
					}
				}
					
			}
			
		}
		
		if (event.getSource() == searchPlanBtn) {
			if (searchField.getText().equals("")) {
				TelecommunicationCompaniesFX.alert("Συμπηρώστε το όνομα της εταιρίας της οποίας το πρόγραμμα θέλετε να αναζητήσετε");
			}
			else {
				searchPlan(TelecommunicationCompaniesFX.removeSpaces(searchField.getText()));
			}
		}
		
		if (event.getSource() == backBtn) {;
			tableSync();
			clearFields();
			disableBtn(false,true);
			
		}
		
		if (event.getSource() == listPlansBtn){
			tableSync();
		}
		
		if (event.getSource() == mobilePlanTableView) {
			 MobilePlan selectedItem = mobilePlanTableView.getSelectionModel().getSelectedItem();
			 if (selectedItem != null) {
				  disableBtn(true,false);
				  passField.setText(selectedItem.getUnPass());
				  companyField.setText(selectedItem.getCompany());
	              costField.setText(selectedItem.getPrice());
	              sms_Speed_Field.setText(selectedItem.getSms());
	              gigabytes_lineType_Field.setText(selectedItem.getGB());
	              freeCallsField.setText(selectedItem.getFreeCalls());
	         }
		}
		
		if (event.getSource() == landPlanTableView) {
			 LandPlan selectedItem = landPlanTableView.getSelectionModel().getSelectedItem();
			 if (selectedItem != null) {
				  disableBtn(true,false);
				  passField.setText(selectedItem.getUnPass());
				  companyField.setText(selectedItem.getCompany());
	              costField.setText(selectedItem.getPrice());
	              sms_Speed_Field.setText(selectedItem.getSpeed());
	              gigabytes_lineType_Field.setText(selectedItem.getLineType());
	              freeCallsField.setText(selectedItem.getFreeCalls());
	         }
		}
		
		if (event.getSource() == delPlanBtn) {
			delPlan();
			clearFields();
			disableBtn(false,true);
			tableSync();
		}
	
		
	}
	
	//Διαγραφή ενός πακέτου 
	public void delPlan() {
		if (searchContList() == 1) {
			for (Plan plan: PlanList) {
				if (plan.getCompany().equals(companyField.getText())) {
					PlanList.remove(plan);
					break;
				}
			}	

		}
		else TelecommunicationCompaniesFX.alert("Το πρόγραμμα δεν μπορεί να διαγραφεί καθώς υπάρχουν καταχωρημένα συμβόλαια που το αφορούν!");
	}
	
	//Αναζήτηση συμβολαίου
	public int searchContList() {
		for (Contract contract: ContractFX2.ContList) {
			if (contract.getPassword().equals(passField.getText())) {
				return 0;
				
			}
		}
		return 1;
	}
	
	//Όταν ο χρήστης επιλέγει Mobile στήνουμε την κατάλληλη σκηνή ώστε να συμπληρώσει τα κατάλληλα στοιχεία και να του εμφανίζονται τα κατάλληλα πακέτα
	public void setMobilePlanScene() {
		try {
			sms_Speed_Lbl.setText("SMS");
			gigabytes_lineType_Lbl.setText("Gigabytes");
			rootBorderPane.getChildren().remove(landPlanTableView);
			BorderPane.setMargin(mobilePlanTableView, insets);
			rootBorderPane.setCenter(mobilePlanTableView);
			gigabytes_lineType_Field.setPromptText("");
		}
		catch(java.lang.IllegalArgumentException ex) {
			
		}
	}
	
	//Όταν ο χρήστης επιλέγει LandLine στήνουμε την κατάλληλη σκηνή ώστε να συμπληρώσει τα κατάλληλα στοιχεία και να του εμφανίζονται τα κατάλληλα πακέτα
	public void setLandPlanScene() {
		try {
	    	rootBorderPane.getChildren().remove(mobilePlanTableView);
		    sms_Speed_Lbl.setText("Speed");
		    gigabytes_lineType_Lbl.setText("Line");
		    BorderPane.setMargin(landPlanTableView, insets);
		    rootBorderPane.setCenter(landPlanTableView);
		    gigabytes_lineType_Field.setPromptText("VDSL ή ADSL");
		}
		catch (java.lang.IllegalArgumentException ex) {
			
		}

	}
	
	//Ανάλογα με την επιλογή του χρήστη (Mobile ή Landline) αποθηκεύουμε τα κατάλληλα στοιχεία
	public void createPlan(String password,String company,String freeCalls,String price,String speed_sms,String GB_lineType)
    {
		if (radioButton1.isSelected()) {
			MobilePlan Comp = new MobilePlan(password,company,freeCalls,price,speed_sms,GB_lineType);
			PlanList.add(Comp);
		}
		else {
			LandPlan Comp = new LandPlan(password,company,freeCalls,price,speed_sms,GB_lineType);
			PlanList.add(Comp);
		}
    }
	
	//Αποθήκευση των νέων στοιχείων ενός πακέτου 
	public void updatePlan(String password,String cost,String speed_sms,String GB_lineType,String freeCalls) {
		 for(int i=0;i<PlanList.size();i++) {
			 if (radioButton1.isSelected()) {
				 if (PlanList.get(i) instanceof MobilePlan) {
					 if ((PlanList.get(i).getUnPass()).equals(password)) {
						 PlanList.get(i).setPrice(cost);
						 ((MobilePlan) PlanList.get(i)).setSms(speed_sms);
						 ((MobilePlan) PlanList.get(i)).setGB(GB_lineType);
						 ((MobilePlan) PlanList.get(i)).setFreeCalls(freeCalls);
					 }
	            }
			 
	        }
			 else {
				 if (PlanList.get(i) instanceof LandPlan) {
					 if ((PlanList.get(i).getUnPass()).equals(password)) {
						 PlanList.get(i).setPrice(cost);
						 ((LandPlan) PlanList.get(i)).setSpeed(speed_sms);
						 ((LandPlan) PlanList.get(i)).setLineType(GB_lineType);
						 ((LandPlan) PlanList.get(i)).setFreeCalls(freeCalls);
	        		
					 }
				 }
			 }
		 }
	}
	
	//Αναζήτηση πακέτου
	public void searchPlan(String companyName) {
		if (radioButton1.isSelected()) {
			 List<MobilePlan> items = mobilePlanTableView.getItems();
		     items.clear();
			 int i;
			 for (i=0;i<PlanList.size();i++) {
				if (PlanList.get(i) instanceof MobilePlan) {
					if (PlanList.get(i).getCompany().equals(companyName)) {
						items.add((MobilePlan) PlanList.get(i));
					}
				} 
			 }
		}
		else {
		   List<LandPlan> items2 = landPlanTableView.getItems();
		   items2.clear();
		   int i;
		   for (i=0;i<PlanList.size();i++) {
			   if (PlanList.get(i) instanceof LandPlan) {
			  		if (PlanList.get(i).getCompany().equals(companyName)) {
						items2.add((LandPlan) PlanList.get(i));
					}
			  	 } 
			  }
		  
		}
	}
	
	//Απενεργοποίση των κουμπιών
	public void disableBtn(boolean btn1,boolean btn2) {
		companyField.setDisable(btn1);
		upPlanBtn.setDisable(btn2);
		newPlanBtn.setDisable(btn1);
		delPlanBtn.setDisable(btn2);
		listPlansBtn.setDisable(btn1);
		backBtn.setDisable(btn2);
	}
	
	//Ελεγχος ακεραίου μετατρεποντας το String σε int
	public int intCheck(String var) {
		try {
			Integer.parseInt(var);
			return 1;
		}
		catch(NumberFormatException ex) {
			return 0;
		}
	}
	
	// Ελεγχος ακεραίου μετατρεποντας το String σε double
	public int doubleCheck(String var) {
		try {
			Double.parseDouble(var);
			return 1;
		}
		catch(NumberFormatException ex) {
			return 0;
		}
	}
	
	//Έλεγχος αν όλα τα κελιά είναι γεμάτα
	public int FieldsCheck(String name,String cost,String sms_speed,String giga_lineType,String freeCalls) {
		int i = 0;
		if (intCheck(freeCalls)==0) {
			freeCallsField.setText("");
			i = 1;
		}
		if (doubleCheck(cost)==0) {
		    	costField.setText("");
		    	i = 1 ;
		    }
		if (radioButton1.isSelected()) {
			if (intCheck(sms_speed)==0) {
		    	sms_Speed_Field.setText("");
		    	i = 1 ;
		    }
		    if (intCheck(giga_lineType)==0) {
		    	gigabytes_lineType_Field.setText("");
		    	i = 1 ;
		    }
		}
		else {
			if (intCheck(sms_speed)==0) {
				sms_Speed_Field.setText("");
				i = 1 ;
			}
			if (!(giga_lineType.equalsIgnoreCase("VDSL")) && !(giga_lineType.equalsIgnoreCase("ADSL")) ) {
				gigabytes_lineType_Field.setText("");
				i = 1 ;
			}
			
			if (TelecommunicationCompaniesFX.checkName(name)==0) {
				companyField.setText("");
				i = 1;
			}
		}
	    return i;
	}
	
	//Προσθήκη του αντίστοιχου πακέτου στην κατάλληλη επιλογή του χρήστη (πχ αν έχει επιλέξει Mobile αποθήκευεται το πακέτο στον πίνακα MobilePlan)
	public void tableSync() {
		if (radioButton1.isSelected()) {
		  List<MobilePlan> items = mobilePlanTableView.getItems();
	      items.clear();
	      for(int i=0;i<PlanList.size();i++) {
	    	  if (PlanList.get(i) instanceof MobilePlan) {
	    		  items.add((MobilePlan) PlanList.get(i));
	    	  }
	      }
		}
		else{
			List<LandPlan> items = landPlanTableView.getItems();
		     items.clear();
		     for(int i=0;i<PlanList.size();i++) {
		    	 if (PlanList.get(i) instanceof LandPlan) {
		    		 items.add((LandPlan) PlanList.get(i));
		    	 }
		     }
		}
	 }

	//Καθαρισμός των πεδίων για να εισαχθούν τα επόμενα δεδομένα απο τον χρήστη
	public void clearFields() {
		passField.setText("");
		companyField.setText("");
		costField.setText("");
		sms_Speed_Field.setText("");
		gigabytes_lineType_Field.setText("");
		freeCallsField.setText("");
	}
}


