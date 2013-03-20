package edu.byu.isys413.rtyler1;

public class Fee extends RevenueSource{

	@BusinessObjectField
	private double amount = 0.0;
	@BusinessObjectField
	private String rentalId = null;
	@BusinessObjectField
	private String empId = null;
	
	/** Creates the Business Object instance of this object*/
	public Fee(String id) {
		super(id);
	}
	
	/** Gets the amount for the Fee Object*/
	public double getAmount() {
		return amount;
	}

	/** Sets the amount for the Fee Object*/
	public void setAmount(double amount) {
		this.amount = amount;
		setDirty();
	}

	/** Gets the rentalId for the Fee Object*/
	public String getRentalId() {
		return rentalId;
	}

	/** Sets the rentalId for the Fee Object*/
	public void setRentalId(String rentalId) {
		this.rentalId = rentalId;
		setDirty();
	}

	/** Sets the Rental object */
	public void setRental(Rental rental) {
		this.rentalId = rental.getId();
		setDirty();
	}

	/** Returns the Rental object */
	public Rental getRental() throws DataException {
		return BusinessObjectDAO.getInstance().read(rentalId);
	}

	/** Gets the empId for the Fee Object*/
	public String getEmpId() {
		return empId;
	}

	/** Sets the empId for the Fee Object*/
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
	
	
	
}
