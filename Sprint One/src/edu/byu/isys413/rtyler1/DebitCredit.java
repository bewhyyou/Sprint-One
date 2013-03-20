package edu.byu.isys413.rtyler1;

//import edu.byu.isys413.data.BusinessObjectDAO;
//import edu.byu.isys413.data.DataException;
//import edu.byu.isys413.data.Person;

public class DebitCredit extends BusinessObject{

	@BusinessObjectField
	private String jeId = null; //referencing worked!! =D This is the one to many relationship??
	@BusinessObjectField
	private String debitCredit = null;
	@BusinessObjectField
	private String generalLedgerName = null;
	@BusinessObjectField
	private double amount = 0.0;	

	//list?? Yes. Will need to do this for all the one to many relationships. 


	/** Creates the Business Object instance of this object*/
	public DebitCredit(String id) {
		super(id);
	}

	/** Gets the jeId for the DebitCredit Object*/
	//Gets the id from the JournalEntry Object?? 
	public String getJeId() {
		return jeId;
	}

	/** Sets the jeId for the DebitCredit Object*/
	public void setJeId(String jeId) {
		this.jeId = jeId;
		setDirty();
	}


	/** Sets the JournalEntry object */
	public void setJournalEntry(JournalEntry je) {
		this.jeId = je.getId();
		setDirty();
	}

	/** Returns the JournalEntry object */
	public JournalEntry getJournalEntry() throws DataException {
		return BusinessObjectDAO.getInstance().read(jeId);
	}


	/** Gets the debitCreditBoolean for the DebitCredit Object*/
	public String getDebitCredit() {
		return debitCredit;
	}

	/** Sets the debitCreditBoolean for the DebitCredit Object*/
	public void setDebitCredit(String debitCredit) {
		this.debitCredit = debitCredit;
		setDirty();
	}

	/** Gets the generalLedgerName for the DebitCredit Object*/
	public String getGeneralLedgerName() {
		return generalLedgerName;
	}

	/** Sets the generalLedgerName for the DebitCredit Object*/
	public void setGeneralLedgerName(String generalLedgerName) {
		this.generalLedgerName = generalLedgerName;
		setDirty();
	}

	/** Gets the amount for the DebitCredit Object*/
	public double getAmount() {
		return amount;
	}

	/** Sets the amount for the DebitCredit Object*/
	public void setAmount(double amount) {
		this.amount = amount;
		setDirty();
	}



}
