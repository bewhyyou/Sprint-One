package edu.byu.isys413.rtyler1;

import java.util.List;

public class Transaction extends BusinessObject{
	@BusinessObjectField
	private java.util.Date txndate = null;
	@BusinessObjectField
	private String employeeid = null;
	@BusinessObjectField
	private String storeid = null;
	@BusinessObjectField
	private String customerid = null;
	@BusinessObjectField
	private int subtotal = 0;
	@BusinessObjectField
	private int tax = 0;
	@BusinessObjectField
	private int total = 0;
	@BusinessObjectField
	private String commissionid = null;
	@BusinessObjectField
	private String journalentryid = null;
	@BusinessObjectField
	private String paymentid = null;
	

	/**
	 * Creates a new instance of BusinessObject
	 */
	public Transaction(String id) {
		super(id);
	}//constructor

	//////////////////////////////////////////////////////
	//These next methods are our public interface
	/**
	 * @return the txndate
	 */
	public java.util.Date getTxndate() {
		return txndate;
	}

	/**
	 * @param txndate the txndate to set
	 */
	public void setTxndate(java.util.Date txndate) {
		this.txndate = txndate;
		setDirty();
	}

	/**
	 * @return the employee
	 */
	public Employee getEmployee() throws DataException {
		return BusinessObjectDAO.getInstance().read(employeeid);
	}
	
	/**
	 * employee the employee to set
	 */
	public void setEmployee(Employee e) {
		this.employeeid = e.getId();
		setDirty();
	}
	
	/**
	 * @return the store
	 */
	public Store getStore() throws DataException {
		return BusinessObjectDAO.getInstance().read(storeid);
	}
	
	/**
	 * store the store to set
	 */
	public void setStore(Store store) {
		this.storeid = store.getId();
		setDirty();
	}
	
	/**
	 * get the Customer object
	 */
	public Customer getCustomer() throws DataException {
		return BusinessObjectDAO.getInstance().read(customerid);
	}
	
	/**
	 * set the Customer object
	 */
	public void setCustomer(Customer customer) {
		this.customerid = customer.getId();
		setDirty();
	}
	
	/**
	 * @return the subtotal
	 */
	public int getSubtotal() {
		return subtotal;
	}

	/**
	 * @param subtotal the subtotal to set
	 */
	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
		setDirty();
	}

	/**
	 * @return the tax
	 */
	public int getTax() {
		return tax;
	}

	/**
	 * @param tax the tax to set
	 */
	public void setTax(int tax) {
		this.tax = tax;
		setDirty();
	}

	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
		setDirty();
	}

	/**
	 * get the commission object
	 */
	public Commission getCommission() throws DataException {
		return BusinessObjectDAO.getInstance().read(commissionid);
	}
	
	/**
	 * set the commission object
	 */
	public void setCommission(Commission comm) {
		this.commissionid = comm.getId();
		setDirty();
	}

	/**
	 * get the journalentry object
	 */
	public JournalEntry getJournalEntry() throws DataException{
		return BusinessObjectDAO.getInstance().read(journalentryid);
	}
	
	/**
	 * set the journalentry object
	 */
	public void setJournalEntry(JournalEntry jE) {
		this.journalentryid = jE.getId();
		setDirty();
	}
	
	/**
	 * @return the payment
	 */
	public Payment getPayment() throws DataException{
		return BusinessObjectDAO.getInstance().read(paymentid);
	}
	
	/**
	 * payment the payment to set
	 */
	public void setPayment(Payment payment) {
		this.paymentid = payment.getId();
		setDirty();
	}

	/**
	 * Retrieves the checks for this employee.
	 */
	public List<RevenueSource> getRevsrclist() throws DataException {
		return BusinessObjectDAO.getInstance().searchForList("RevenueSource",
				new SearchCriteria("txnid", id));
	}
	
	////////////////////////////////////////////////////////
	//These methods will be used by the DAO

	/**
	 * @return the employeeid
	 */
	public String getEmployeeid() {
		return employeeid;
	}

	/**
	 * @param employeeid the employeeid to set
	 */
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}

	/**
	 * @return the storeid
	 */
	public String getStoreid() {
		return storeid;
	}

	/**
	 * @param storeid the storeid to set
	 */
	public void setStoreid(String storeid) {
		this.storeid = storeid;
		setDirty();
	}

	/**
	 * @return the customerid
	 */
	public String getCustomerid() {
		return customerid;
	}

	/**
	 * @param customerid the customerid to set
	 */
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
		setDirty();
	}

	/**
	 * @return the commissionid
	 */
	public String getCommissionid() {
		return commissionid;
	}

	/**
	 * @param commissionid the commissionid to set
	 */
	public void setCommissionid(String commissionid) {
		this.commissionid = commissionid;
		setDirty();
	}

	/**
	 * @return the journalentryid
	 */
	public String getJournalentryid() {
		return journalentryid;
	}
	
	/**
	 * @param journalentryid the journalentryid to set
	 */
	public void setJournalentryid(String journalentryid) {
		this.journalentryid = journalentryid;
		setDirty();
	}
	
	/**
	 * @return the paymentid
	 */
	public String getPaymentid() {
		return paymentid;
	}

	/**
	 * @param paymentid the paymentid to set
	 */
	public void setPaymentid(String paymentid) {
		this.paymentid = paymentid;
		setDirty();
	}
	
}
