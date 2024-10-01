package classes;


public class Client {
	
	//Δήλωση μεταβλητών
	private String IDnumber;
	private String AFM;
	private String name;
	private String lastName;
	private String status;
	private String address;
	private String phoneNumber;
	private String email;
	
	//Βάζουμε το αντικείμενο σε μια αρχική και έγκυρη κατασταση(λειτουργια του constructor)
	public Client(String iDnumber, String AFM, String name,String lastName, String status, String address, String phoneNumber,String email) {
		this.IDnumber = iDnumber;
		this.AFM = AFM;
		this.name = name;
		this.lastName= lastName;
		this.status = status;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	//Σε περίπτωση επεξεργασίας των δεδομενων και αλλαγη του αντικειμένου(λειτουργια των setters & getters)
	public String getIDnumber() {
		return IDnumber;
	}
	
	public void setIDnumber(String iDnumber) {
		IDnumber = iDnumber;
	}
	
	public String getAFM() {
		return AFM;
	}
	
	public void setAFM(String AFM) {
		this.AFM = AFM;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}