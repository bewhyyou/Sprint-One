package edu.byu.isys413.rtyler1;

import java.util.List;

public class Transaction1 extends BusinessObject{

	@BusinessObjectField
	private String customerId = null; //references Customer
	@BusinessObjectField
	private String empId = null; //references Employee
	@BusinessObjectField
	private String storeId = null; //references Store
	@BusinessObjectField
	private String commId = null; //references Commission
	@BusinessObjectField
	private String jeId = null; //references JournalEntry
	@BusinessObjectField
	private String paymentId = null; //references Payment
	@BusinessObjectField
	private java.util.Date transDate = null; 
	@BusinessObjectField
	private double subTotal = 0.0;
	@BusinessObjectField
	private double tax = 0.0;
	@BusinessObjectField
	private double total = 0.0;


	public static void finishTransactionButtonClicked() {

		//get stuff on list, save = update db for each product (HINT: "FOR EACH")

		//get Total

		//calculate commissions payable (trans.getEmployee().getCommissionRate())
		

		//calculate total tax payable (not necessarily save?) if so
		//(I think I already did that?)
		

		//new transaction object created


	}//finishTransactionButtonClicked




	///////////////////////////////Constructor, getters, and setters///////////////////////////////////////

	/** Creates the Business Object instance of this object*/
	public Transaction1(String id) {
		super(id);
	}

	/** Gets the customerId for the Transaction1 Object*/
	public String getCustomerId() {
		return customerId;
	}

	/** Sets the customerId for the Transaction1 Object*/
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
		setDirty();
	}

	//functional method
	/** Sets the Customer object */
	public void setCustomer(Customer cust) {
		this.customerId = cust.getId();
		setDirty();
	}

	//functional method
	/** Returns the Customer object */
	public Customer getCustomer() throws DataException {
		return BusinessObjectDAO.getInstance().read(customerId);
	}


	/** Gets the empId for the Transaction1 Object*/
	public String getEmpId() {
		return empId;
	}

	/** Sets the empId for the Transaction1 Object*/
	public void setEmpId(String empId) {
		this.empId = empId;
	}

	/** Sets the Employee object */
	public void setEmployee(Employee emp) {
		this.empId = emp.getId();
		setDirty();
	}

	/** Returns the Employee object */
	public Employee getEmployee() throws DataException {
		return BusinessObjectDAO.getInstance().read(empId);
	}


	/** Gets the storeId for the Transaction1 Object*/
	public String getStoreId() {
		return storeId;
	}

	/** Sets the storeId for the Transaction1 Object*/
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}


	/** Sets the store object */
	public void setStore(Store store) {
		this.storeId = store.getId();
		setDirty();
	}

	/** Returns the store object */
	public Store getStore() throws DataException {
		return BusinessObjectDAO.getInstance().read(storeId);
	}


	/** Gets the commId for the Transaction1 Object*/
	public String getCommId() {
		return commId;
	}

	/** Sets the commId for the Transaction1 Object*/
	public void setCommId(String commId) {
		this.commId = commId;
	}


	/** Sets the Commission object */
	public void setCommission(Commission comm) {
		this.commId = comm.getId();
		setDirty();
	}

	/** Returns the Commission object */
	public Commission getCommission() throws DataException {
		return BusinessObjectDAO.getInstance().read(commId);
	}


	/** Gets the jeId for the Transaction1 Object*/
	public String getJeId() {
		return jeId;
	}

	/** Sets the jeId for the Transaction1 Object*/
	public void setJeId(String jeId) {
		this.jeId = jeId;
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

	/** Gets the paymentId for the Transaction1 Object*/	
	public String getPaymentId() {
		return paymentId;
	}

	/** Sets the paymentId for the Transaction1 Object*/
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	
	
	/** Sets the Payment object */
	public void setPayment(Payment payment) {
		this.paymentId = payment.getId();
		setDirty();
	}

	/** Returns the Payment object */
	public Payment getPayment() throws DataException {
		return BusinessObjectDAO.getInstance().read(paymentId);
	}
	
	/** Gets the transDate for the Transaction1 Object*/
	public java.util.Date getTransDate() {
		return transDate;
	}

	/** Sets the transDate for the Transaction1 Object*/
	public void setTransDate(java.util.Date transDate) {
		this.transDate = transDate;
	}

	/** Gets the subTotal for the Transaction1 Object*/
	public double getSubTotal() {
		return subTotal;
	}

	/** Sets the subTotal for the Transaction1 Object*/
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	/** Gets the tax for the Transaction1 Object*/
	public double getTax() {
		return tax;
	}

	/** Sets the tax for the Transaction1 Object*/
	public void setTax(double tax) {
		this.tax = tax;
	}

	/** Gets the total for the Transaction1 Object*/
	public double getTotal() {
		return total;
	}

	/** Sets the total for the Transaction1 Object*/
	public void setTotal(double total) {
		this.total = total;
	}

	/**
	 * Retrieves the revenuesources for this transaction
	 */
	public List<RevenueSource> getRevenueSources() throws DataException {
		return BusinessObjectDAO.getInstance().searchForList("RevenueSource", new SearchCriteria("transid", id));
	}


}
