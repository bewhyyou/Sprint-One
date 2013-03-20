package edu.byu.isys413.rtyler1;

//import edu.byu.isys413.data.BusinessObjectDAO;
//import edu.byu.isys413.data.DataException;

public class RevenueSource extends BusinessObject{

	@BusinessObjectField
	private String transId = null; //references Transaction
	@BusinessObjectField
	private double chargeAmount = 0.0;
	@BusinessObjectField
	private String rsType = null;
	
	
	/** Creates the Business Object instance of this object*/
	public RevenueSource(String id) {
		super(id);
	}

	/** Gets the transId for the RevenueSource Object*/
	public String getTransId() {
		return transId;
	}

	/** Sets the transId for the RevenueSource Object*/
	public void setTransId(String transId) {
		this.transId = transId;
		setDirty();
	}
	
	
	/** Sets the transaction object */
	public void setTransaction(Transaction1 trans) {
		this.transId = trans.getId();
		setDirty();
	}

	/** Returns the store object */
	public Transaction1 getTransaction() throws DataException {
		return BusinessObjectDAO.getInstance().read(transId);
	}
	
	
	
	/** Gets the chargeAmount for the RevenueSource Object*/
	public double getChargeAmount() {
		return chargeAmount;
	}

	/** Sets the chargeAmount for the RevenueSource Object*/
	public void setChargeAmount(double chargeAmount) {
		this.chargeAmount = chargeAmount;
		setDirty();
	}

	/** Gets the rsType for the RevenueSource Object*/
	public String getRsType() {
		return rsType;
	}

	/** Sets the rsType for the RevenueSource Object*/
	public void setRsType(String rsType) {
		this.rsType = rsType;
		setDirty();
	}

	
	
	
}
