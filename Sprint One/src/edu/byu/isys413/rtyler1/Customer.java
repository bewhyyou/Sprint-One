package edu.byu.isys413.rtyler1;

import java.util.List;

//import edu.byu.isys413.rtyler1.gui.Customer;
//import edu.byu.isys413.rtyler1.gui.DataException;
//import edu.byu.isys413.rtyler1.gui.SearchCriteria;

import edu.byu.isys413.rtyler1.MainScreen;

public class Customer extends BusinessObject{

		
	@BusinessObjectField
	private String Name = null;
	@BusinessObjectField
	private String Phone = null;
	@BusinessObjectField
	private String Email = null;
	@BusinessObjectField
	private String billingAddress = null;
	@BusinessObjectField
	private String shippingAddress = null;
	@BusinessObjectField
	private String Password = null;
	@BusinessObjectField
	private String membershipId = null;
	@BusinessObjectField
	private String validationCode = null;
	@BusinessObjectField
	private boolean validated = false;
	
	
	
	/** Clears the customer fields, so new information can be added in*/
	public static void newCustomerButtonClicked() {

		MainScreen.nameField.setText("");
		MainScreen.phoneField.setText("");
		MainScreen.emailField.setText("");
		MainScreen.addressField.setText("");

	}//newCustomerButtonClicked


	/** Saves the info in the customer fields to the database */
	public static void saveCustomerButtonClicked() {

		//create customer
		Customer cust;
		try {

			cust = BusinessObjectDAO.getInstance().create("Customer");

			//get its info from fields
			String custName = MainScreen.nameField.getText();
			String custPhone = MainScreen.phoneField.getText();
			String custEmail = MainScreen.emailField.getText();
			String custAddress = MainScreen.addressField.getText();

			//set them in Customer object class (cust.save())
			cust.setName(custName);
			cust.setPhone(custPhone);
			cust.setEmail(custEmail);
			cust.setBillingAddress(custAddress); //can change to ".setAddress" or other stuff. But for now, this.
			cust.save();

		} catch (DataException e) {
			e.printStackTrace();
		}

		MainScreen.nameField.setText("");
		MainScreen.phoneField.setText("");
		MainScreen.emailField.setText("");
		MainScreen.addressField.setText("");

	}//saveCustomerButtonClicked

	/** Looks up the info of a customer by phone number, and populates the fields in the GUI */
	public static void lookUpCustomerButtonClicked() {


		try {

			String custPhoneNumber = MainScreen.lookUpPhoneField.getText();
			//"employee1" be changed to the string variable I'll create and getting the phone number from the text field. :)


			Customer cust = BusinessObjectDAO.getInstance().searchForBO("Customer", new SearchCriteria("phone", custPhoneNumber)); //creating an object (searchCriteria)

			//Employee emp1 = BusinessObjectDAO.getInstance().searchForBO("Employee", new SearchCriteria("id", "employee1"));


			//get the different variables for that customer
			String custName = cust.getName();
			String custPhone = cust.getPhone();
			String custEmail = cust.getEmail();
			String custAddress = cust.getBillingAddress();

			//set them into the text fields in the GUI. :)
			MainScreen.nameField.setText(custName);
			MainScreen.phoneField.setText(custPhone);
			MainScreen.emailField.setText(custEmail);
			MainScreen.addressField.setText(custAddress);		

			//the "Add Customer" button can clear the fields. :)

		} catch (DataException e) {
			e.printStackTrace();
		} 

	}//lookUpCustomerButtonClicked
	
	
	/////////////////////GETTERS AND SETTERS///////////////////////////
	
	
	/** Creates the Business Object instance of this object*/
	public Customer(String id) {
		super(id);
	}


	/** Gets the custName for the Customer Object*/
	public String getName() {
		return Name;
	}


	/** Sets the custName for the Customer Object*/
	public void setName(String custName) {
		this.Name = custName;
		setDirty();
	}


	/** Gets the custPhone for the Customer Object*/
	public String getPhone() {
		return Phone;
	}


	/** Sets the custPhone for the Customer Object*/
	public void setPhone(String custPhone) {
		this.Phone = custPhone;
		setDirty();
	}


	/** Gets the custEmail for the Customer Object*/
	public String getEmail() {
		return Email;
	}


	/** Sets the custEmail for the Customer Object*/
	public void setEmail(String custEmail) {
		this.Email = custEmail;
		setDirty();
	}


	/** Gets the billingAddress for the Customer Object*/
	public String getBillingAddress() {
		return billingAddress;
	}


	/** Sets the billingAddress for the Customer Object*/
	public void setBillingAddress(String custAddress) {
		this.billingAddress = custAddress;
		setDirty();
	}

	
	/** Gets the shippingAddress for the Customer Object*/
	public String getShippingAddress() {
		return shippingAddress;
	}

	
	/** Sets the shippingAddress for the Customer Object*/
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}


	/** Gets the Password for the Customer Object*/
	public String getPassword() {
		return Password;
	}

	/** Sets the Password for the Customer Object*/
	public void setPassword(String password) {
		Password = password;
		setDirty();
	}


	/** Gets the membershipId for the Customer Object*/
	public String getMembershipId() {
		return membershipId;
	}

	/** Gets the membershipId for the Customer Object*/
	public void setMembershipId(String membershipId) {
		this.membershipId = membershipId;
		setDirty();
	}

	/** Sets the Membership object */
	public void setMembership(Membership membership) {
		this.membershipId = membership.getId();
		setDirty();
	}

	/** Returns the Membership object */
	public Membership getMembership() throws DataException {
		return BusinessObjectDAO.getInstance().read(membershipId);
	}

	/**
	 * Retrieves the transactions for this customer
	 */
	public List<Transaction1> getTransactions() throws DataException {
		return BusinessObjectDAO.getInstance().searchForList("Transaction1", new SearchCriteria("customerid", id));
	}

	/** Gets the validationCode for the Customer Object*/
	public String getValidationCode() {
		return validationCode;
	}

	/** Sets the validationCode for the Customer Object*/
	public void setValidationCode(String validationCode) {
		this.validationCode = validationCode;
		setDirty();
	}

	/** Gets the validated boolean for the Customer Object*/
	public boolean isValidated() {
		return validated;
	}

	/** Sets the validated boolean for the Customer Object*/
	public void setValidated(boolean validated) {
		this.validated = validated;
	}

	
	
	
	
	
}
