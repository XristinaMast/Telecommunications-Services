package classes;

public class TelecommunicationCompany {
	
	//Δήλωση μεταβλητών
	private String password;
	private String companyName; 
	private String mobile;
	private String email;
	
	//Βάζουμε το αντικείμενο σε μια αρχική και έγκυρη κατασταση(λειτουργια του constructor)
	public TelecommunicationCompany(String password, String companyName, String mobile, String email) {
		this.password = password;
		this.companyName = companyName;
		this.mobile = mobile;
		this.email = email;
	}
	
	//Σε περίπτωση επεξεργασίας των δεδομενων και αλλαγη του αντικειμένου(λειτουργια των setters & getters)
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}