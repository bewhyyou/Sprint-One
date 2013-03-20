package edu.byu.isys413.rtyler1;

import java.util.LinkedList;
import java.util.List;

//import edu.byu.isys413.data.Car;
//import edu.byu.isys413.data.DataException;
//import edu.byu.isys413.data.PersonCar;

//import edu.byu.isys413.data.BusinessObjectDAO;
//import edu.byu.isys413.data.DataException;
//import edu.byu.isys413.data.Dog;
//import edu.byu.isys413.data.SearchCriteria;

//import edu.byu.isys413.data.BusinessObjectDAO;
//import edu.byu.isys413.data.BusinessObjectField;
//import edu.byu.isys413.data.DataException;

public class Store extends BusinessObject {


	@BusinessObjectField
	private String Location = null;
	@BusinessObjectField
	private String managerId = null;
	@BusinessObjectField
	private String Address = null;
	@BusinessObjectField
	private String Phone = null;
	@BusinessObjectField		
	private double SalesTaxRate = 0.00; //double for this? Numeric(1,2)?
	@BusinessObjectField
	private String SubnetId = null;
//	@BusinessObjectField
//	private String empId = null;


	/** Creates the Business Object instance of this object*/
	public Store(String id) {
		super(id);
	}

	/** Gets the storeLocation for the Store Object*/
	public String getLocation() {
		return Location;
	}

	/** Sets the storeLocation for the Store Object*/
	public void setLocation(String storeLocation) {
		this.Location = storeLocation;
		setDirty();
	}

	/** Gets the storeManager for the Store Object*/
	public String getManagerId() {
		return managerId;
	}

	/** Sets the storeManager for the Store Object*/
	public void setManagerId(String storeManager) {
		this.managerId = storeManager;
		setDirty();
	}
	
	/** Sets the employee (manager) object */
	public void setManager(Employee employee) {
		this.managerId = employee.getId();
		setDirty();
	}


	/** Returns the employee (manager) object */
	public Employee getManager() throws DataException {
		return BusinessObjectDAO.getInstance().read(managerId);
	}

	/** Gets the storeAddress for the Store Object*/
	public String getAddress() {
		return Address;
	}

	/** Sets the storeAddress for the Store Object*/
	public void setAddress(String storeAddress) {
		this.Address = storeAddress;
		setDirty();
	}

	/** Gets the storePhone for the Store Object*/
	public String getPhone() {
		return Phone;
	}

	/** Sets the storePhone for the Store Object*/
	public void setPhone(String storePhone) {
		this.Phone = storePhone;
		setDirty();
	}

	/** Gets the storeSalesTaxRate for the Store Object*/
	public double getSalesTaxRate() {
		return SalesTaxRate;
	}

	/** Sets the storeSalesTaxRate for the Store Object*/
	public void setSalesTaxRate(double storeSalesTaxRate) {
		this.SalesTaxRate = storeSalesTaxRate;
		setDirty();
	}

	/** Gets the storeSubnetId for the Store Object*/
	public String getSubnetId() {
		return SubnetId;
	}

	/** Sets the storeSubnetId for the Store Object*/
	public void setSubnetId(String storeSubnetId) {
		this.SubnetId = storeSubnetId;
		setDirty();
	}

//	/** Gets the empid for the Store Object*/
//	public String getEmpId() {
//		return empId;
//	}
//
//	/** Sets the empid for the Store Object*/
//	public void setEmpId(String empid) {
//		this.empId = empid;
//		setDirty();
//	}
//
//
//	/** Sets the employee object */
//	public void setEmployee(Employee employee) {
//		this.empId = employee.getId();
//		setDirty();
//	}
//
//
//	/** Returns the employee object */
//	public Employee getEmployee() throws DataException {
//		return BusinessObjectDAO.getInstance().read(empId);
//	}


	/**
	 * Retrieves the computers for this owner.
	 */
	public List<Computer> getComputers() throws DataException {
		return BusinessObjectDAO.getInstance().searchForList("Computer", new SearchCriteria("storeid", id));
	}


	/**
	 * Retrieves the StoreProduct relationship object for this store.
	 */
	public List<StoreProduct> getStoreProducts() throws DataException {
		return BusinessObjectDAO.getInstance().searchForList("StoreProduct", new SearchCriteria("storeid", id));
	}


	/**
	 * Retrieves the actual ConceptualProduct objects for this Store.
	 * This is a convenience method to traverse the intermediary table.
	 */
	public List<ConceptualProduct> getConceptualProducts() throws DataException {
		List<ConceptualProduct> conceptualproducts = new LinkedList<ConceptualProduct>();
		for (StoreProduct sp: this.getStoreProducts()) {
			conceptualproducts.add(sp.getConceptualProduct());
		}
		return conceptualproducts;
	}
	
	
	/**
	 * Retrieves the transactions for this store
	 */
	public List<Transaction1> getTransactions() throws DataException {
		return BusinessObjectDAO.getInstance().searchForList("Transaction1", new SearchCriteria("storeid", id));
	}
	
	
	/**
	 * Retrieves the physicalproducts for this store
	 */
	public List<PhysicalProduct> getPhysicalProducts() throws DataException {
		return BusinessObjectDAO.getInstance().searchForList("PhysicalProduct", new SearchCriteria("storeid", id));
	}

}
