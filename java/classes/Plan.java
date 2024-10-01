package classes;

public class Plan { //η κλάση Plan είναι η κύρια κλάση για την LandPlan και την MobilePlan για αυτό θα την κάνουμε extend.
	
	//Δήλωση μεταβλητών
	private String unPass;
	private String freeCalls;
	private String company;
	private String price;
	
	
	//Βάζουμε το αντικείμενο σε μια αρχική και έγκυρη κατασταση(λειτουργια του constructor)
	public Plan(String unPass,String company,String freeCalls,String price)
	{
		this.unPass=unPass;
		this.company=company;
		this.freeCalls=freeCalls;
		this.price=price;
	}
	
	//Σε περίπτωση επεξεργασίας των δεδομενων και αλλαγη του αντικειμένου(λειτουργια των setters & getters)
	public void setUnPass(String unPass)
	{
		this.unPass=unPass;
	}
	
	public void setCompany(String company)
	{
		this.company=company;
	}
	
	public void setPrice(String price)
	{
		this.price=price;
	}
	
	public void setFreeCalls(String freeCalls)
	{
		this.freeCalls=freeCalls;
	}
	
	public String getUnPass()
	{
		return this.unPass;
	}
	
	public String getCompany()
	{
		return this.company;
	}
	
	
	public String getPrice()
	{
		return this.price;
	}
	
	public String getFreeCalls()
	{
		return this.freeCalls;
	}
}