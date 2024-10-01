package GUI.TelecommunicationServices;

import java.util.ArrayList;
import java.util.Calendar;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import classes.*;
import javafx.scene.layout.BorderPane;


@SuppressWarnings("unused")
public class ContractFX2 extends SceneCreator implements EventHandler<MouseEvent>{
	
	static ArrayList<Contract> ContList;
	
	//Δήλωση των FlowPane
	FlowPane buttonFlowPane,topFlowPane;
	//Δήλωση των GridPane
	GridPane inputFieldsPane1,inputFieldsPane2;
	//Δήλωση του BorderPane
	BorderPane borderPane;
	//Δήλωση των Buttons
	Button newContBtn,cancelContBtn,exitBtn,searchContBtn,listContsBtn,backBtn;
	//Δήλωση των TextField
	TextField discountField,dateField,priceField,paymentMethodField,contPassField,planPassField,planPassField2,accTypeField,phoneNumberField2,phoneNumberField,durationField,cancelPriceField,enabledField,afmField,afmField2,searchField;
	//Δήλωση του TableView
	TableView<Contract> ContTableView;
	//Δήλωση των Label
	Label discountLbl,dateLbl,priceLbl,planLbl,paymentMethodLbl,paymentMethodLbl2,contPassLbl,planPassLbl2,planPassLbl,accTypeLbl,contTypeLbl2,phoneNumberLbl,durationLbl,phoneNumberLbl2,durationLbl2,cancelPriceLbl,enabledLbl,afmLbl,afmLbl2;
	//Δήλωση του insets
	Insets insets; 
	//Δήλωση των ComboBox για την αποφυγή εσφαλμένων δεδομένων
	ComboBox<String> accTypeBox,durationBox,paymentMethodBox,contTypeBox;
	
	public ContractFX2(double width, double height) {
		
		super(width, height);
		
		 insets = new Insets(10);
		 //Δημιουργία του πίνακα που θα εμφανίζεται μμε τα συμβόλαια
		 ContTableView = new TableView<>();
         //Δμιουργία του BorderPane
         borderPane = new BorderPane();
         //Δμιουργία των ComboBox
         accTypeBox = new ComboBox<String>();
		 accTypeBox.getItems().addAll(
				    "'Εντυπος",
				    "Ηλεκτρονικός"
				);
		 accTypeBox.setValue("'Εντυπος"); //Ενδεικτική επιλογή
		 
		 durationBox = new ComboBox<String>();
		 durationBox.getItems().addAll(
				    "12",
				    "24"
				);
		 durationBox.setValue("12");//Ενδεικτική τιμή
		 
		 paymentMethodBox = new ComboBox<String>();
		 paymentMethodBox.getItems().addAll(
				    "Μετρητά",
				    "Πιστωτική/Χρεωστική"
				);
		 paymentMethodBox.setValue("Μετρητά");//Ενδεικτική επιλογή
		 
		 contTypeBox = new ComboBox<String>();
		 contTypeBox.getItems().addAll(
				    "Mobile",
				    "LandLine"
				);
		 contTypeBox.setValue("Mobile");//Ενδεικτική επιλογή
		 
		//Δημιουργία των Buttons
	    newContBtn = new Button("Νέο Συμβόλαιο");
		cancelContBtn = new Button("Ακύρωση");
		exitBtn = new Button("Επιστροφή");
		searchContBtn = new Button("Αναζήτηση");
		listContsBtn = new Button("Συμβόλαια");
		backBtn = new Button("Πίσω");
		 
		//Δημιουργία των Labels
		discountLbl = new Label("Έκπτωση");
		paymentMethodLbl = new Label("Τρόπος Πληρωμής");
		contPassLbl = new Label("Κωδικός συμβολαίου");
		planPassLbl = new Label("Κωδικός Προγράμματος");
		accTypeLbl = new Label("Τύπος Λογαριασμού");
		phoneNumberLbl = new Label("Νέος Αριθμός");
		durationLbl = new Label("Διάρκεια συμβολαίου");
		cancelPriceLbl = new Label("Τιμή ακύρωσης συμβολαίου");
		enabledLbl = new Label("Ενεργοποιημένο συμβόλαιο");
		afmLbl = new Label("Α.Φ.Μ πελάτη");
		priceLbl = new Label("Τελική τιμή");
		dateLbl = new Label("Έναρξη Συμβολαίου");
		planLbl = new Label("Τύπος Συμβολαίου");
		planPassLbl2 = new Label("Κωδικός Προγράμματος");
		contTypeLbl2 = new Label("Τύπος Λογαριασμού");
		phoneNumberLbl2 = new Label("Νέος Αριθμός");
		durationLbl2 = new Label("Διάρκεια συμβολαίου");
		afmLbl2 = new Label("Α.Φ.Μ πελάτη");
		paymentMethodLbl2 = new Label("Τρόπος Πληρωμής");
		
		//Δημιουργία των TextField
		discountField = new TextField();
		contPassField = new TextField();
		planPassField = new TextField();
		planPassField2 = new TextField();
		phoneNumberField = new TextField();
		phoneNumberField2 = new TextField();
		cancelPriceField = new TextField();
		enabledField = new TextField();
		afmField = new TextField();
		afmField2 = new TextField();
		searchField = new TextField();
		durationField = new TextField();
		accTypeField = new TextField();
		paymentMethodField = new TextField();
		priceField = new TextField();
		dateField = new TextField();
		 
		//Δημιουργία του Πινακα με τα συμβόλαια
		ContList = new ArrayList<>();
		
		//Δημιουργία των FlowPane
		topFlowPane = new FlowPane();
		buttonFlowPane = new FlowPane();
		inputFieldsPane1 = new GridPane();
		inputFieldsPane2 = new GridPane();
		 
		//Attach events
	    exitBtn.setOnMouseClicked(this);
	    backBtn.setOnMouseClicked(this);
	    newContBtn.setOnMouseClicked(this);
	    cancelContBtn.setOnMouseClicked(this);
	    searchContBtn.setOnMouseClicked(this);
	    listContsBtn.setOnMouseClicked(this);
	    ContTableView.setOnMouseClicked(this);
	    contTypeBox.setOnMouseClicked(this);
	    
	  //Τοποθέτηση των: FlowPane,inputFields και rootBorderPane στο παράθυρο
		buttonFlowPane.setHgap(10);
		buttonFlowPane.getChildren().add(newContBtn);
		buttonFlowPane.getChildren().add(cancelContBtn);
		buttonFlowPane.getChildren().add(listContsBtn);
		buttonFlowPane.getChildren().add(backBtn);
		buttonFlowPane.getChildren().add(exitBtn);
		
		buttonFlowPane.setAlignment(Pos.BOTTOM_LEFT);
		
		topFlowPane.getChildren().add(searchContBtn);
		topFlowPane.getChildren().add(searchField);
		topFlowPane.setHgap(10);
		topFlowPane.setAlignment(Pos.TOP_RIGHT);
		
		inputFieldsPane2.setAlignment(Pos.TOP_LEFT);
		inputFieldsPane2.setVgap(10);
	    inputFieldsPane2.setHgap(10);
		inputFieldsPane2.add(contPassLbl,0,1);
		inputFieldsPane2.add(planPassLbl2,0,2);
		inputFieldsPane2.add(afmLbl2,0,3);
		inputFieldsPane2.add(dateLbl,0,4);
		inputFieldsPane2.add(phoneNumberLbl2,0,5);
		inputFieldsPane2.add(durationLbl2,0,6);
		inputFieldsPane2.add(discountLbl,0,7);
		inputFieldsPane2.add(priceLbl,0,8);
		inputFieldsPane2.add(paymentMethodLbl2,0,9);
		inputFieldsPane2.add(cancelPriceLbl,0,10);
		inputFieldsPane2.add(contTypeLbl2,0,11);
		inputFieldsPane2.add(enabledLbl,0,12);
		 
		inputFieldsPane2.add(contPassField,1,1);
		inputFieldsPane2.add(planPassField2,1,2);
		inputFieldsPane2.add(afmField2,1,3);
		inputFieldsPane2.add(dateField,1,4);
		inputFieldsPane2.add(phoneNumberField2,1,5);
		inputFieldsPane2.add(durationField,1,6);
		inputFieldsPane2.add(discountField,1,7);
		inputFieldsPane2.add(priceField,1,8);
		inputFieldsPane2.add(paymentMethodField,1,9);
		inputFieldsPane2.add(cancelPriceField,1,10);
		inputFieldsPane2.add(accTypeField,1,11);
		inputFieldsPane2.add(enabledField,1,12);
		 
		cancelPriceField.setDisable(true);
	    contPassField.setDisable(true);
	 	discountField.setDisable(true);
	  	enabledField.setDisable(true);
	   	planPassField2.setDisable(true);
	  	priceField.setDisable(true);
	  	paymentMethodField.setDisable(true);
	  	durationField.setDisable(true);
	  	afmField2.setDisable(true);
	  	dateField.setDisable(true);
	  	phoneNumberField2.setDisable(true);
	  	accTypeField.setDisable(true);
		
		inputFieldsPane1.setAlignment(Pos.TOP_LEFT);
	    inputFieldsPane1.setVgap(10);
	    inputFieldsPane1.setHgap(10);
		inputFieldsPane1.add(planPassLbl,0,1);
		inputFieldsPane1.add(afmLbl,0,2);
		inputFieldsPane1.add(phoneNumberLbl,0,3);
		inputFieldsPane1.add(durationLbl,0,4);
		inputFieldsPane1.add(accTypeLbl,0,5);
		inputFieldsPane1.add(paymentMethodLbl,0,6);
		inputFieldsPane1.add(planLbl,0,7);
		
		inputFieldsPane1.add(planPassField,1,1);
		inputFieldsPane1.add(afmField,1,2);
		inputFieldsPane1.add(phoneNumberField,1,3);
		
		inputFieldsPane1.add(accTypeBox,1,4);
		inputFieldsPane1.add(durationBox,1,5);
		inputFieldsPane1.add(paymentMethodBox,1,6);
		inputFieldsPane1.add(contTypeBox,1,7);
	
		BorderPane.setAlignment(inputFieldsPane1, Pos.CENTER_LEFT);
		BorderPane.setAlignment(inputFieldsPane2, Pos.CENTER_LEFT);
        BorderPane.setAlignment(topFlowPane, Pos.CENTER);
        BorderPane.setAlignment(ContTableView, Pos.CENTER);
        
        BorderPane.setMargin(inputFieldsPane1, insets);
        BorderPane.setMargin(inputFieldsPane2, insets);
        BorderPane.setMargin(ContTableView, insets);
        BorderPane.setMargin(topFlowPane, insets);
        BorderPane.setMargin(buttonFlowPane, insets);
        
        borderPane.setRight(inputFieldsPane1);
        borderPane.setBottom(buttonFlowPane);
        borderPane.setTop(topFlowPane);
        borderPane.setCenter(ContTableView);
		
      //Οργανώνουμε τα στοιχεία του Table στο παράθυρο
        TableColumn<Contract,String> codeColumn = new TableColumn<>("Κωδικός Συμβολαίου");
		codeColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
		ContTableView.getColumns().add(codeColumn);
        		
        TableColumn<Contract,String> planPassColumn = new TableColumn<>("Κωδικός Προγράμματος");
		planPassColumn.setCellValueFactory(new PropertyValueFactory<>("password")); //pass the var from class MobilePlan
		ContTableView.getColumns().add(planPassColumn);
		
		TableColumn<Contract,String> afmColumn = new TableColumn<>("Α.Φ.Μ");
		afmColumn.setCellValueFactory(new PropertyValueFactory<>("afm")); //pass the var from class MobilePlan
		ContTableView.getColumns().add(afmColumn);
		
		TableColumn<Contract,String> dateColumn = new TableColumn<>("Έναρξη συμβολαίου");
		dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
		ContTableView.getColumns().add(dateColumn);
		
		TableColumn<Contract,String> phoneColumn = new TableColumn<>("Αριθμός Τηλεφώνου");
		phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber")); //pass the var from class Plan
		ContTableView.getColumns().add(phoneColumn);
		
		TableColumn<Contract,String> durationColumn = new TableColumn<>("Διάρκεια Συμβολαίου");
		durationColumn.setCellValueFactory(new PropertyValueFactory<>("duration")); //pass the var from class Plan
		ContTableView.getColumns().add(durationColumn);
		
		TableColumn<Contract,String> discountColumn = new TableColumn<>("'Εκπτωση");
		discountColumn.setCellValueFactory(new PropertyValueFactory<>("discount")); //pass the var from class Plan
		ContTableView.getColumns().add(discountColumn);
		
		TableColumn<Contract,String> priceColumn = new TableColumn<>("Τελική τιμή");
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("price")); //pass the var from class Plan
		ContTableView.getColumns().add(priceColumn);
		
		TableColumn<Contract,String> paymentMethodColumn = new TableColumn<>("Τρόπος Πληρωμής");
		paymentMethodColumn.setCellValueFactory(new PropertyValueFactory<>("paymentMethod")); //pass the var from class Plan
		ContTableView.getColumns().add(paymentMethodColumn);
		
		TableColumn<Contract,String> conTypeColumn = new TableColumn<>("Τιμή ακύρωσης συμβολαίου");
		conTypeColumn.setCellValueFactory(new PropertyValueFactory<>("cancellationPrice")); //pass the var from class Plan
		ContTableView.getColumns().add(conTypeColumn);
		
		TableColumn<Contract,String> cancellationPriceColumn = new TableColumn<>("Είδος Λογαριασμού");
		cancellationPriceColumn.setCellValueFactory(new PropertyValueFactory<>("accType")); //pass the var from class Plan
		ContTableView.getColumns().add(cancellationPriceColumn);
		
		TableColumn<Contract,Boolean> enabledColumn = new TableColumn<>("Ενεργό Συμβόλαιο");
		enabledColumn.setCellValueFactory(new PropertyValueFactory<>("enabled")); //pass the var from class Plan
		ContTableView.getColumns().add(enabledColumn);
		
		phoneNumberField.setPromptText("6xxxxxxxxx");
		afmField.setPromptText("9 ψηφία");
		
		
		cancelContBtn.setDisable(true);
		backBtn.setDisable(true);
  
		
	}
	
	//Παίρνουμε περιπτώσεις για τα κουμπιά που μπορεί να πατήσει ο χρήστης ώστε το πρόγραμμα να αντιδράσει καταλλήλως
	@Override
	public void handle(MouseEvent event) {
		if (event.getSource()==exitBtn) {
			App.stage1.setTitle("Κατάστημα Παροχής Τηλεπικοινωνιών Υπηρεσιών");
			App.stage1.setScene (App.mainScene);
			setGridPane1();
			disableBtn(false,true);
			clearFields();
			tableSync();
		}
		
		if (event.getSource()==contTypeBox) {
			contTypeBox.setOnAction(e -> { 
				String selectedItem = contTypeBox.getSelectionModel().getSelectedItem().toString();
				if (contTypeBox.getValue().equals("LandLine")) {
					phoneNumberField.setPromptText("2xxxxxxxxx");}
				else {
					phoneNumberField.setPromptText("6xxxxxxxxx");}
				tableSync();
				clearFields();
			});
		}
		
		
		
		if (event.getSource()==newContBtn) {
			String afm = TelecommunicationCompaniesFX.removeSpaces(afmField.getText());
			String planPass = TelecommunicationCompaniesFX.removeSpaces(planPassField.getText());
			String phoneNumber = TelecommunicationCompaniesFX.removeSpaces(phoneNumberField.getText());
			String paymentMethod=paymentMethodBox.getValue();;
			String duration=durationBox.getValue();; 
			String accType=accTypeBox.getValue();
			boolean enabled = true;
			
			if (afm.equals("") || planPass.equals("") || phoneNumber.equals("") ) {
				TelecommunicationCompaniesFX.alert("Παρακαλώ Συμπληρώστε όλα τα απαραίτητα πεδία!");
			}
			else {
				if (checkFields(afm,planPass,phoneNumber)==1) {
					LocalDate date = LocalDate.now();
					String contPass = passwordGen(afm,removeSymbols(date.toString()));
					String discount = calcDiscount(planPass,afm);
					String price = newPrice(discount,planPass);
					String cancellationPrice =String.valueOf((Double.parseDouble(price)*10)/100) ;
	
					createContract(price,date.toString(),phoneNumber,planPass,afm,duration,contPass,discount,paymentMethod,cancellationPrice,enabled,accType);
					tableSync();
					clearFields();
				}
			}
		}
		if (event.getSource()==ContTableView) {
			 Contract selectedItem = ContTableView.getSelectionModel().getSelectedItem();
			if (selectedItem != null) {
				 setGridPane2();
				 disableBtn(true,false);
				 updateCancelPrice(selectedItem.getDate(),selectedItem);
				  contPassField.setText(selectedItem.getCode());
				  afmField2.setText(selectedItem.getAfm());
				  planPassField2.setText(selectedItem.getPassword());
				  phoneNumberField2.setText(selectedItem.getPhoneNumber());
				  paymentMethodField.setText(selectedItem.getPaymentMethod());
	              discountField.setText(selectedItem.getDiscount());
	              durationField.setText(selectedItem.getDuration());
	              String enabledString =String.valueOf(selectedItem.getEnabled());
	              enabledField.setText(enabledString);
	              accTypeField.setText(selectedItem.getAccType());
	              cancelPriceField.setText(selectedItem.getCancellationPrice());
	              priceField.setText(selectedItem.getPrice());
	              dateField.setText(selectedItem.getDate());
			}
		}
		
		if (event.getSource()==backBtn) {
			disableBtn(false,true);
			setGridPane1();
			clearFields();
			tableSync();
		}
		
		if (event.getSource()==searchContBtn) {
			if (searchField.getText().equals("")) {
				TelecommunicationCompaniesFX.alert("Συμπηρώστε τον αριθμό τηλεφώνου που θέλετε να αναζητήσετε");
			}
			else {
				searchCont(TelecommunicationCompaniesFX.removeSpaces(searchField.getText()));
				searchField.setText("");
			}
			
		}
		
		if (event.getSource()==cancelContBtn) {
			cancelCont();
			tableSync();
			clearFields();
			disableBtn(false,true);
			setGridPane1();
		}
		
		if(event.getSource()==listContsBtn) {
			tableSync();
		}
	}

	//Αναγνώριση Ημερομηνίας για την ακύρωση του συμβολαίου
	public void updateCancelPrice(String startDate,Contract selectedItem) {
		LocalDate today = LocalDate.now();
		
		  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
		  //Μετατροπή String σε LocalDate
		  LocalDate localDate = LocalDate.parse(startDate, formatter);
		  LocalDate returnvalue = localDate.plusMonths(5);
		  
		  if (today.compareTo(returnvalue) >= 0)  selectedItem.setCancellationPrice("0");
		  	
	}
	
	//Το παρακάτω αφαιρεί τα "-" γιατί οταν κάνουμε το date αυτό είναι της μορφής "yyyy-MM-d" ενώ θέλουμε να είναι της μορφής "yyyyMMd"
	public String removeSymbols(String string) {
		String noSpaceString = string.replaceAll("-", "");
		return noSpaceString;
	}
	
	//Δημιουργούμε την σκηνή
	public Scene CreateScene() {
		Scene tmp=new Scene(borderPane,width,height);
		return tmp;
	}

	//Δημιουργία του συμβουλαίου με τα εισαχθέντα στοιχεία.
	public void createContract(String price,String date,String phoneNumber,String password,String afm, String duration,String contPass, String discount,String paymentMethod, String cancellationPrice, boolean enabled, String conType) {

		Contract cont = new Contract(price,date,phoneNumber,password,afm,duration,contPass,discount,paymentMethod,cancellationPrice,enabled,conType);	
		ContList.add(cont);
	}
	
	
	//Αναζήτηση συμβολαίου
	public void searchCont(String phone) {

		List<Contract> items = ContTableView.getItems();
	    items.clear();
		if (contTypeBox.getValue()=="Mobile") {
			for (Contract contract: ContList) {
				if (contract.getCode().contains("Mobile") && contract.getPhoneNumber().equals(phone)) {
					items.add((Contract) contract);
					break;
				}
			}
		}
		else {
			for (Contract contract: ContList) {
				if (contract.getCode().contains("LandLine") && contract.getPhoneNumber().equals(phone)) {
					items.add((Contract) contract);
					break;
				}
			}
		}
		
	}
	
	//Ακύρωση συμβουλαίου
	public void cancelCont() {
		for (Contract contract: ContList) {
			if (phoneNumberField2.getText().equals(contract.getPhoneNumber())) {
				contract.setEnabled(false);
				break;
			}
		}
	}
	
	
	//Υπολογισμός ποσοστού έκπτωσης
	public String calcDiscount(String planPass,String afm) {
		int i = checkPlan(planPass);
		int discount = 0;
		String freeCalls = PlanFX.PlanList.get(i).getFreeCalls();
		int j = checkAfm(afm);
		String status = ClientsFX.ClientList.get(j).getStatus();
		if (status == "Επαγγελματίας") {
			discount += 10;
		}
		else if (status=="Φοιτητής") {
			discount += 15;
		}
		if (Integer.parseInt(freeCalls) > 1000) {
			if (contTypeBox.getValue().equals("Mobile")) {
				discount += 11;
			}
			else 
			{
				discount += 8;
			}
		}
		if (paymentMethodBox.getValue().equals("Πιστωτική/Χρεωστική")) {
			discount += 5;
		}
		if (accTypeBox.getValue().equals("Ηλεκτρονικός")) {
			discount += 2;
		}
		
		return String.valueOf(discount);
	}
	
	//Υπολογισμός νέας τιμής
	public String newPrice(String discount,String planPass) {
		int i = checkPlan(planPass);
		String price = PlanFX.PlanList.get(i).getPrice();
		double newPrice = Double.parseDouble(price)-(Double.parseDouble(price) * Double.parseDouble(discount)) / 100;
		return String.valueOf(newPrice);
	}
	
	//Δημιουργία κωδικού του συμβολαίου
	public String passwordGen(String afm,String date) {
		String pass;
		if (contTypeBox.getValue()=="Mobile") {
			pass = new String(date+"-"+afm+"-Mobile");
		}
		else {
			pass = new String(date+"-"+afm+"-"+"LandLine");
		}
		return pass;
	}

	//Έλεγχος μοναδικότητας ΑΦΜ
	public int checkAfm(String afm) {
		try {
			long number=Long.parseLong(afm);
		}
		catch(NumberFormatException ex){
			return -1;
		}
	
		if (afm.length()!= 9) {
			return -1;
		}
		else {
			for (int i=0;i < ClientsFX.ClientList.size();i++) {
				if (ClientsFX.ClientList.get(i).getAFM().equals(afm)) {
					return i;
				}
			}
		}
	   return -1;
	}
	
	//Έλεγχος μοναδικότητας Αριθμού Τηλεφώνου
	public int checkPhoneNumber(String number) {

		if (TelecommunicationCompaniesFX.checkPhone(number)==0)
			return 0;
		else {
			if (contTypeBox.getValue()=="Mobile")
			{
				if (number.startsWith("6")) {
					for (Contract con: ContList) {
						if (number.equals(con.getPhoneNumber()) && con.getEnabled()==true) {
							return 0;
						}
					}
				}
				else {
					return 0;
				}
			}
			else {
				if (number.startsWith("2")) {
					for (Contract con: ContList) {
						if (number.equals(con.getPhoneNumber()) && con.getEnabled()==true) {
							return 0;
						}
					}
				}
				else {
					return 0;
				}
			}
			
		}
		return 1;
	}
	
	//Έλεγχος μοναδικότητας Κωδικού
	public int checkPlan(String planPass) {

		if (contTypeBox.getValue()=="Mobile") {
			 for (int i=0;i<PlanFX.PlanList.size();i++) {
					if (PlanFX.PlanList.get(i) instanceof MobilePlan) {
						if (PlanFX.PlanList.get(i).getUnPass().equals(planPass)) {
							return i;
						}
			        }
			 }
		}
		else 
		{
			 for (int i=0;i<PlanFX.PlanList.size();i++) {
					if (PlanFX.PlanList.get(i) instanceof LandPlan) {
						if (PlanFX.PlanList.get(i).getUnPass().equals(planPass)) {
							return i;
						}
					}
			 }
		}
		return -1;
	}
	
	//Έλεγχος για το αν το πρόγραμμα υπάρχει 
	public int checkFields(String afm,String planPass,String phoneNumber) {
		int i = 1;
		if (checkAfm(afm)==-1) {
			TelecommunicationCompaniesFX.alert("Ο αριθμός Α.Φ.Μ δεν ανήκει σε κάποιον πελάτη");
			afmField.setText("");
			i = 0;
		}
		if (checkPhoneNumber(phoneNumber)==0) {
			TelecommunicationCompaniesFX.alert("Ο αριθμός Τηλεφώνου που καταχωρήσατε χρησιμοποιήτε ήδη ή δεν είναι σωστός");
			phoneNumberField.setText("");
			i = 0;
		}
		if (checkPlan(planPass)==-1) {
			TelecommunicationCompaniesFX.alert("Το πρόγραμμα δεν υπάρχει");
			planPassField.setText("");
			i = 0; 
		}
		return i;
	}
	
	//Το setGridPane1 διαγράφει απο το scene το inputFieldPane2 και θέτει το inputFieldsPane1
	public void setGridPane1() {
		try {
		 borderPane.getChildren().remove(inputFieldsPane2);
		 borderPane.setRight(inputFieldsPane1);
		}
		catch(java.lang.IllegalArgumentException ex) {
			
		}
	}
	
	//Ενώ το setGridPane2 διαγράφει απο το scene το inputFieldsPane1 και θέτει  το inputFieldsPane2
	public void setGridPane2() {

		try {
			borderPane.getChildren().remove(inputFieldsPane1);
			borderPane.setRight(inputFieldsPane2);
		}
		catch(java.lang.IllegalArgumentException ex) {
			
		}
	}
	
	//Αδειάζουμε τα TextField για να μπορεί ο χρήστης να εισάγει νέα δεδομένα
	public void clearFields() {
		afmField.setText("");
		phoneNumberField.setText("");
		planPassField.setText("");
	}
	
	//Απενεργοποιούμε τα κουμπιά του παραθύρου
	public void disableBtn(boolean btn1,boolean btn2) {
		newContBtn.setDisable(btn1);
		cancelContBtn.setDisable(btn2);
		listContsBtn.setDisable(btn1);
		backBtn.setDisable(btn2);
	}
	
	//Εμφανίζουμε τα στοιχεία στον πίνακα που εχουμε δημιουργήσει με το συμβόλαιο 
 	public void tableSync() {

		List<Contract> items = ContTableView.getItems();
	    items.clear();
		for (Contract contract: ContList) {
			if (contTypeBox.getValue()=="Mobile") {
				if (contract.getCode().contains("Mobile")) {
					items.add((Contract) contract);
				}
			}
			else {
				if (contract.getCode().contains("LandLine")) {
					items.add((Contract) contract);
				}
			}
		}
	}
}
