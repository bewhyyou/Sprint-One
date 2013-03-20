package edu.byu.isys413.rtyler1;

/**
 * Check written to employee when commission is paid.
 */

public class Checks extends BusinessObject{
	@BusinessObjectField
	private String empid = null;
	@BusinessObjectField
	private java.util.Date checkdate = null;
	@BusinessObjectField
	private int amount = 0;
	
	/** Creates a new instance of BusinessObject */
	public Checks(String id) {
		super(id);
	}// constructor

	////////////////////////////////////////////
	//These methods are our public interface
	/**
	 * @return the employee
	 */
	public Employee getEmp() throws DataException {
		return BusinessObjectDAO.getInstance().read(empid);
	}
	
	/**
	 * @param employee the employee to set
	 */
	public void setEmp(Employee employee) {
		this.empid = employee.getId();
		setDirty();
	}
	
	/**
	 * @return the checkdate
	 */
	public java.util.Date getCheckdate() {
		return checkdate;
	}

	/**
	 * @param checkdate the checkdate to set
	 */
	public void setCheckdate(java.util.Date checkdate) {
		this.checkdate = checkdate;
		setDirty();
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
		setDirty();
	}
	
	/////////////////////////////////////////////
	//These methods are referenced by the DAO
	/**
	 * @return the empid
	 */
	public String getEmpid() {
		return empid;
	}

	/**
	 * @param empid the empid to set
	 */
	public void setEmpid(String empid) {
		this.empid = empid;
		setDirty();
	}


}
