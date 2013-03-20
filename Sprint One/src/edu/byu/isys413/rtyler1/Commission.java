package edu.byu.isys413.rtyler1;

//import edu.byu.isys413.data.BusinessObjectDAO;
//import edu.byu.isys413.data.DataException;
//import edu.byu.isys413.data.Person;

public class Commission extends BusinessObject{

	@BusinessObjectField
	private String empId = null; //references Employee
	@BusinessObjectField
	private double amount = 0.0;
	@BusinessObjectField
	private java.util.Date commDate = null;

	/** Creates the Business Object instance of this object*/
	public Commission(String id) {
		super(id);
	}

	/** Gets the empId for the Commission Object*/
	public String getEmpId() {
		return empId;
	}

	/** Sets the empId for the Commission Object*/
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


	/** Gets the amount for the Commission Object*/
	public double getAmount() {
		return amount;
	}

	/** Sets the amount for the Commission Object*/
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/** Gets the date for the Commission Object*/
	public java.util.Date getCommDate() {
		return commDate;
	}

	/** Sets the date for the Commission Object*/
	public void setCommDate(java.util.Date date) {
		this.commDate = date;
	}



}
