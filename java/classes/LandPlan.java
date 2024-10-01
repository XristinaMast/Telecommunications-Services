package classes;


public class LandPlan extends Plan{
	
	//Δήλωση μεταβλητών
	private String speed;
	private	String lineType;
	
	//Βάζουμε το αντικείμενο σε μια αρχική και έγκυρη κατασταση(λειτουργια του constructor)
	public LandPlan(String unPass,String company,String freeCalls,String price,String speed,String lineType)
	{
		super(unPass,company,freeCalls,price);
		this.speed=speed;
		this.lineType=lineType;
	}
	
	//Σε περίπτωση επεξεργασίας των δεδομενων και αλλαγη του αντικειμένου(λειτουργια των setters & getters)
	public void setSpeed(String speed)
	{
		this.speed=speed;
	}
	
	public void setLineType(String lineType)
	{
		this.lineType=lineType;
	}
	
	//getters
	public String getSpeed()
	{
		return this.speed;
	}
	
	public String getLineType()
	{
		return this.lineType;
	}
}