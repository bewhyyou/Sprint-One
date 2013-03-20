package edu.byu.isys413.rtyler1;

//import edu.byu.isys413.data.BusinessObjectDAO;
//import edu.byu.isys413.data.DataException;
//import edu.byu.isys413.data.Person;

public class Computer extends BusinessObject{

	@BusinessObjectField
	private String storeId = null; //references Store
	@BusinessObjectField
	private String macAddress = null;


	/** Creates the Business Object instance of this object*/
	public Computer(String id) {
		super(id);
	}


	/** Gets the storeId for the Computer Object*/
	public String getStoreId() {
		return storeId;
	}

	/** Sets the storeId for the Computer Object*/
	public void setStoreId(String storeId) {
		this.storeId = storeId;
		setDirty();
	}

	/** Sets the store object */
	public void setStore(Store store) {
		this.storeId = store.getId();
		setDirty();
	}

	/** Returns the person object */
	public Store getStore() throws DataException { //doesn't work when I change public Person to public Store
		return BusinessObjectDAO.getInstance().read(storeId);
	}


	/** Gets the macAddress for the Computer Object*/
	public String getMacAddress() {
		return macAddress;
	}

	/** Sets the macAddress for the Computer Object*/
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
		setDirty();
	}



}
