package edu.byu.isys413.rtyler1;

import java.util.List;

//import edu.byu.isys413.data.BusinessObjectDAO;
//import edu.byu.isys413.data.BusinessObjectField;
//import edu.byu.isys413.data.DataException;
//import edu.byu.isys413.data.Person;

public class Employee extends BusinessObject {


	//**Add lists to this one?? Look at other classes in Albrecht's example! =)


	@BusinessObjectField
	private String empName = null;
	@BusinessObjectField
	private java.util.Date HireDate = null;
	@BusinessObjectField
	private String Phone = null;
	@BusinessObjectField
	private double Salary = 0; //what would this type need to be if it's "NUMERIC(8,2)" in the MyStuffSprintOne.sql doc?
	@BusinessObjectField
	private double CommissionRate = 0;
	@BusinessObjectField
	private String LoginName = null;
	@BusinessObjectField
	private String storeId = null;


	/** Creates the Business Object instance of this object*/
	public Employee(String id) {
		super(id);		
	}//constructor

	/** Gets the EmpName for the Employee Object*/
	public String getEmpName() {
		return empName;
	}//getEmpName

	/** Sets the EmpName for the Employee Object*/
	public void setEmpName(String empName) {
		this.empName = empName;
		setDirty();
	}//setEmpName

	/** Gets the hireDate for the Employee Object*/
	public java.util.Date getHireDate() {
		return HireDate;
	}//getHireDate

	/** Sets the hireDate for the Employee Object*/
	public void setHireDate(java.util.Date hiredate) {
		this.HireDate = hiredate;
		setDirty();
	}//setHireDate

	/** Gets the phone for the Employee Object*/
	public String getPhone() {
		return Phone;
	}//getPhone

	/** Sets the phone for the Employee Object*/
	public void setPhone(String phone) {
		this.Phone = phone;
		setDirty();
	}//setPhone

	/** Gets the salary for the Employee Object*/
	public double getSalary() {
		return Salary;
	}//getSalary

	/** Sets the salary for the Employee Object*/
	public void setSalary(double salary) {
		this.Salary = salary;
		setDirty();
	}//setSalary

	/** Gets the commissionRate for the Employee Object*/
	public double getCommissionRate() {
		return CommissionRate;
	}//getCommissionRate

	/** Sets the commissionRate for the Employee Object*/
	public void setCommissionRate(double commissionRate) {
		this.CommissionRate = commissionRate;
		setDirty();
	}//setCommissionRate

	/** Gets the loginName for the Employee Object*/
	public String getLoginName() {
		return LoginName;
	}//getLoginName

	/** Sets the loginName for the Employee Object*/
	public void setLoginName(String loginName) {
		this.LoginName = loginName;
		setDirty();
	}//setLoginName

	/** Gets the storeid for the Employee Object*/
	public String getStoreId() {
		return storeId;
	}//getStoreid

	/** Sets the storeid for the Employee Object*/
	public void setStoreId(String storeid) {
		this.storeId = storeid;
		setDirty();
	}//setStoreid


	//need to get the store object to go with the associated storeid


	/** Sets the store object */
	public void setStore(Store store) {
		this.storeId = store.getId();
		setDirty();
	}

	/** Returns the store object */
	public Store getStore() throws DataException {
		return BusinessObjectDAO.getInstance().read(storeId);
	}


	/**
	 * Retrieves the transactions for this employee
	 */
	public List<Transaction1> getTransactions() throws DataException {
		return BusinessObjectDAO.getInstance().searchForList("Transaction1", new SearchCriteria("empid", id));
	}
	
	/**
	 * Retrieves the commissions for this employee
	 */
	public List<Commission> getCommissions() throws DataException {
		return BusinessObjectDAO.getInstance().searchForList("Commission", new SearchCriteria("empid", id));
	}

}
