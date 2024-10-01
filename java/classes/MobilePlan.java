package classes;


public class MobilePlan extends Plan {
	
	//Δήλωση μεταβλητών
	private String sms;
	private String GB;
	
	
	//Βάζουμε το αντικείμενο σε μια αρχική και έγκυρη κατασταση(λειτουργια του constructor)
	public MobilePlan(String unPass,String company,String freeCalls,String price,String sms,String GB)
	{
		super(unPass,company,freeCalls,price);
		this.sms=sms;
		this.GB=GB;
	}
	
	//Σε περίπτωση επεξεργασίας των δεδομενων και αλλαγη του αντικειμένου(λειτουργια των setters & getters)
	public void setSms(String sms)
	{
		this.sms=sms;
	}
	
	public void setGB(String GB)
	{
		this.GB=GB;
	}
	
	//getters
	public String getSms()
	{
		return this.sms;
	}
	
	public String getGB()
	{
		return this.GB;
	}
}
