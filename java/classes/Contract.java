package classes;

public class Contract{
	
	//Δήλωση μεταβλητών
	private String password;
	private String code;
	private String phoneNumber;
	private String duration;
	private String discount;
	private String paymentMethod;
	private String cancellationPrice;
	private boolean enabled;
	private String accType;
	private String afm;
	private String date;
	private String price;

	//Βάζουμε το αντικείμενο σε μια αρχική και έγκυρη κατασταση(λειτουργια του constructor)
	public Contract(String price,String date,String phoneNumber,String password,String afm, String duration,String code, String discount, String paymentMethod, String cancellationPrice, boolean enabled, String accType) {
		this.phoneNumber= phoneNumber;
		this.password = password;
		this.afm = afm;
		this.duration = duration;
		this.code = code;
		this.discount = discount;
		this.paymentMethod = paymentMethod;
		this.cancellationPrice = cancellationPrice;
		this.enabled = enabled;
		this.accType = accType;
		this.date = date;
		this.price =price;

	}
	
	//Σε περίπτωση επεξεργασίας των δεδομενων και αλλαγη του αντικειμένου(λειτουργια των setters & getters)
	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}
	
	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getCode() {
		return this.code;
	}


	public void setCode(String code) {
		this.code = code;
	}
	
	public String getAfm() {
		return afm;
	}


	public void setAfm(String afm) {
		this.afm = afm;
	}
	

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	

	public void setDiscount(String discount) {
		this.discount = discount;
	}
	
	public String getDiscount() {
		return discount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getCancellationPrice() {
		return cancellationPrice;
	}

	public void setCancellationPrice(String cancellationPrice) {
		this.cancellationPrice = cancellationPrice;
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}	
	
	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}
	
}
