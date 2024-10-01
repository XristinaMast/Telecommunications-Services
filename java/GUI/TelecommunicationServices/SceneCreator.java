package GUI.TelecommunicationServices;

import javafx.scene.Scene;

public abstract class SceneCreator{ 
	
	  //δηλώνουμε τις μεταβλητές που θα χρησιμοποιήσουμε παρακατω και που χρησιμοποιήσαμε στην κλάση App όπου δηλώνονται σαν ορίσματα οι τιμές τους 
	  double width;
	  double height;
	  
	  public SceneCreator(double width,double height) {
		  this.width = width;
		  this.height = height;
		//έτσι εκχωρούνται οι διαστάσεις του κάθε παραθύρου για να εμφανιστούν καταλλήλως
	  }
	  
	public abstract Scene CreateScene();
}