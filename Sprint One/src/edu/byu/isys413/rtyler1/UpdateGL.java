package edu.byu.isys413.rtyler1;

public class UpdateGL extends BusinessObject{

	@BusinessObjectField
	private java.util.Date updatedate;
	@BusinessObjectField
	private int transactioncount;
	private java.util.List<DebitCredit> drcrList = new java.util.ArrayList<DebitCredit>();
	
	/**Creates a new instance of businessobject*/
	public UpdateGL (String id) {
		super(id);
	}//constructor

	/**
	 * @return the date
	 */
	public java.util.Date getUpdatedate() {
		return updatedate;
	}

	/**
	 * @param date the date to set
	 */
	public void setUpdatedate(java.util.Date updatedate) {
		this.updatedate = updatedate;
	}

	/**
	 * @return the drcrList
	 */
	public java.util.List<DebitCredit> getDrcrList() {
		return drcrList;
	}

	/**
	 * @param drcrList the drcrList to set
	 */
	public void setDrcrList(java.util.List<DebitCredit> drcrList) {
		this.drcrList = drcrList;
	}

	/**
	 * @return the transactioncount
	 */
	public int getTransactioncount() {
		return transactioncount;
	}

	/**
	 * @param transactioncount the transactioncount to set
	 */
	public void setTransactioncount(int transactioncount) {
		this.transactioncount = transactioncount;
	}
}
