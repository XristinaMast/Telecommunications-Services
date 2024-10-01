package GUI.TelecommunicationServices;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

public class MainScene extends SceneCreator implements EventHandler<MouseEvent>{ 
//κανουμε extend την SceneCreator διότι αλληλοσυνδέονται μεταξύ τους οι κλάσεις και implement(εφαρμογή) το EventHandler<MouseEvent> για να έχει ο χρήστης την δυνατότητα να επιλέγει την ενέργεια που θέλει να κάνει και το πρόγραμμα να το αναγνωρίζει ώστε να συνεχίζεται σωστά η ροή του προγράμματος.
	
	FlowPane rootFlowPane;
	Button Btn1,Btn2,Btn3,Btn4;
	//Δηλώνουμε τις μεταβλητες για τα κουμπιά και τα παράθυρα.
	
	public MainScene(double width,double height) {
		  
		//περνάμε τις διαστάσεις που έχουμε δηλώσει στην SceneCreator για να δημιουργήσουμε το παράθυρο.
		  super(width,height);
		  //Για την οριζόντια στοίχιση των button κάνουμε import το rootFlowPane.
		  rootFlowPane = new FlowPane();
	      
		  //δημιουργία κουμπιών.
	      Btn1 = new Button("Εταιρίες Τηλεπικοινωνιών");
	      Btn2 = new Button("Προγράμματα Κινητής και Σταθερής Επικοινωνίας");
	      Btn3 = new Button("Πελάτες");
	      Btn4 = new Button("Συμβόλαια");
	      
	      //και τοποθέτηση στον χώρο
	      rootFlowPane.setHgap(20);
	      rootFlowPane.setAlignment(Pos.CENTER);
	     
	      rootFlowPane.getChildren().add(Btn1);
	      rootFlowPane.getChildren().add(Btn2);  
	      rootFlowPane.getChildren().add(Btn3);
	      rootFlowPane.getChildren().add(Btn4);
	      
	      //Επιτρέπουμε στον χρήστη να μπορεί να τα επιλέξει για να συνεχίσει τις επιθυμητές του ενέργειες. 
	      Btn1.setOnMouseClicked(this);
	      Btn2.setOnMouseClicked(this);
	      Btn3.setOnMouseClicked(this);
	      Btn4.setOnMouseClicked(this);
	}
	
	//Δημιουργούμε την σκηνή
	public Scene CreateScene() {
		Scene tmp = new Scene(rootFlowPane,width,height);
		return tmp;
	}
	
	//και στη συνέχεια ανάλογα με το κουμπί που θα πατήσει ο χρήστης δημιουργείται το αντίστοιχο παράθυρο παίρνοντας τον κατάλληλο τίτλο.
	 @Override
	public void handle(MouseEvent event) {
		if (event.getSource()==Btn1) 
		{
			App.stage1.setTitle("Διαχείρηση εταιριών Τηλεπικοινωνιών");
			App.stage1.setScene(App.teleScene);
			
		}
		if (event.getSource()==Btn2)
		{
			App.stage1.setTitle("Διαχείρηση Προγραμμάτων");
			App.stage1.setScene(App.PlanScene);
		}
		if (event.getSource()==Btn3) 
		{
			App.stage1.setTitle("Διαχείρηση Πελατών");
			App.stage1.setScene(App.clientScene);
		}
		if (event.getSource()==Btn4) 
		{
			App.stage1.setTitle("Διαχείρηση Συμβολαίων");
			App.stage1.setScene(App.contScene);
		}
	 }
}
