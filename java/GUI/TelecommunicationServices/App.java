package GUI.TelecommunicationServices;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App extends Application  { //κανουμε extend την application διότι αλληλοσυνδέονται μεταξύ τους οι κλάσεις.

	static Stage stage1;
	static Scene mainScene,teleScene,clientScene,PlanScene,contScene;
	// Δηλώνουμε τα stage static για να είναι αναγνωρισμένα από όλες τις κλάσεις.
	
	@Override
    public void start(Stage stage1){
      
      App.stage1 = stage1;
      
      MainScene mainSceneCreate = new MainScene(1080,720); 
      //Δημιουργούμε νέο αντικείμενο mainSceneCreate και περνάμε ως ορίσματα τις διαστάσεις του παραθύρου οι οποίες είναι εμφανείς απο την SceneCreator όπου είναι υπεύθυνο για τις διαστάσεις του κάθε παραθύρου
      mainScene=mainSceneCreate.CreateScene();
      //Δημιουργούμε την mainScene με την παραπάνω δήλωση
     
      //Η παραπάνω διαδικασία επαναλαμβάνεται και για τα υπόλοιπα παράθυρα
      PlanFX PlanSceneCreate = new PlanFX(1080,720);
      PlanScene=PlanSceneCreate.CreateScene();
  
      TelecommunicationCompaniesFX teleSceneCreate = new TelecommunicationCompaniesFX(1080,720);
      teleScene=teleSceneCreate.CreateScene();
      
      ClientsFX clientSceneCreate = new ClientsFX(1080,720);
      clientScene=clientSceneCreate.CreateScene();
      
      ContractFX2 contSceneCreate = new ContractFX2(1080,720);
      contScene=contSceneCreate.CreateScene();
      
      stage1.setScene(mainScene); //Κάνουμε εμφανείς το παράθυρο στην Javafx
      stage1.setTitle("Κατάστημα Παροχής Τηλεπικοινωνιών Υπηρεσιών"); //Δίνουμε όνομα στο πάράθυρο όπου και το κάνουμε εμφανές στον χρήστη
      stage1.show();//και τέλος εμφανίζουμε το παράθυρο
    }

	//Η μέθοδος αυτή αναγνώρίζεται από την java ωστα να τρέξει η javafx και να μην χρειαστεί να δηλώσουμε ακριβώς από ποιά κλάση ξεκινήσει το πρόγραμμα, ουσιαστικά είναι ενα σήμα για να ξέρει το πρόγραμμα από που να αρχίσει να τρέχει το πρόγραμμα. 
    public static void main(){
    	launch();
    }

 

}