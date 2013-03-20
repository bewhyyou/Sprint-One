package edu.byu.isys413.rtyler1;

public class GeneralLedger extends BusinessObject{

	@BusinessObjectField
	private String accountName = null;
	@BusinessObjectField
	private double balance = 0.0;
	@BusinessObjectField
	private String glType = null;
	
	
	public static void updateGeneralLedgerButtonClicked() {
		
		//get journal entries
		
		//update them to the database
		
			
	}
	
	
	
	////////////////Constructor, getters, and setters//////////////////////
	
	/** Creates a new instance of this object */
	public GeneralLedger(String id) {
		super(id);
	}

	/** Gets the accountName for the GeneralLedger Object*/
	public String getAccountName() {
		return accountName;
	}

	/** Sets the accountName for the GeneralLedger Object*/
	public void setAccountName(String accountName) {
		this.accountName = accountName;
		setDirty();
	}

	/** Gets the balance for the GeneralLedger Object*/
	public double getBalance() {
		return balance;
	}

	/** Sets the balance for the GeneralLedger Object*/
	public void setBalance(double balance) {
		this.balance = balance;
		setDirty();
	}

	/** Gets the glType for the GeneralLedger Object*/
	public String getGlType() {
		return glType;
	}

	/** Sets the glType for the GeneralLedger Object*/
	public void setGlType(String glType) {
		this.glType = glType;
		setDirty();
	}
	
	
}
