package edu.byu.isys413.rtyler1;

import java.util.List;

//import edu.byu.isys413.data.BusinessObjectDAO;
//import edu.byu.isys413.data.DataException;

public class PhysicalProduct extends Product {

	@BusinessObjectField
	private String storeId = null; //references Store
	@BusinessObjectField
	private String conceptualProductId = null; //references ConceptualProduct
	@BusinessObjectField
	private String serialNumber = null;
	@BusinessObjectField
	private String shelfLocation = null;
	@BusinessObjectField
	private java.util.Date datePurchased = null;
	@BusinessObjectField
	private double cost = 0.0;
	@BusinessObjectField
	private String status = null;
	@BusinessObjectField
	private double physicalProductCommissionRate = 0.0;
	@BusinessObjectField
	private String PPType = null;
	
	
	
	/** Creates the Business Object instance of this object*/
	public PhysicalProduct(String id) {
		super(id);
	}

	
	/** Gets the storeId for the PhysicalProduct Object*/
	public String getStoreId() {
		return storeId;
	}


	/** Sets the storeId for the PhysicalProduct Object*/
	public void setStoreId(String storeId) {
		this.storeId = storeId;
		setDirty();
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
	
	/** Gets the conceptualProductId for the PhysicalProduct Object*/
	public String getConceptualProductId() {
		return conceptualProductId;
	}

	/** Sets the conceptualProductId for the PhysicalProduct Object*/
	public void setConceptualProductId(String conceptualProductId) {
		this.conceptualProductId = conceptualProductId;
	}

	
	/** Sets the ConceptualProduct object */
	public void setConceptualProduct(ConceptualProduct cp) {
		this.conceptualProductId = cp.getId();
		setDirty();
	}

	/** Returns the ConceptualProduct object */
	public ConceptualProduct getConceptualProduct() throws DataException {
		return BusinessObjectDAO.getInstance().read(conceptualProductId);
	}
	
	

	/** Gets the serialNumber for the PhysicalProduct Object*/
	public String getSerialNumber() {
		return serialNumber;
	}

	/** Sets the serialNumber for the PhysicalProduct Object*/
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
		setDirty();
	}

	/** Gets the shelfLocation for the PhysicalProduct Object*/
	public String getShelfLocation() {
		return shelfLocation;
	}

	/** Sets the shelfLocation for the PhysicalProduct Object*/
	public void setShelfLocation(String shelfLocation) {
		this.shelfLocation = shelfLocation;
		setDirty();
	}
	
	/** Gets the datePurchased for the PhysicalProduct Object*/
	public java.util.Date getDatePurchased() {
		return datePurchased;
	}

	/** Sets the datePurchased for the PhysicalProduct Object*/
	public void setDatePurchased(java.util.Date datePurchased) {
		this.datePurchased = datePurchased;
		setDirty();
	}

	/** Gets the cost for the PhysicalProduct Object*/
	public double getCost() {
		return cost;
	}

	/** Sets the cost for the PhysicalProduct Object*/
	public void setCost(double cost) {
		this.cost = cost;
		setDirty();
	}

	/** Gets the status for the PhysicalProduct Object*/
	public String getStatus() {
		return status;
	}

	/** Sets the status for the PhysicalProduct Object*/
	public void setStatus(String status) {
		this.status = status;
		setDirty();
	}

	/** Gets the physicalProductCommissionRate for the PhysicalProduct Object*/
	public double getPhysicalProductCommissionRate() {
		return physicalProductCommissionRate;
	}

	/** Sets the physicalProductCommissionRate for the PhysicalProduct Object*/
	public void setPhysicalProductCommissionRate(double physicalProductCommissionRate) {
		this.physicalProductCommissionRate = physicalProductCommissionRate;
		setDirty();
	}

	/** Gets the PPType for the PhysicalProduct Object*/
	public String getPPType() {
		return PPType;
	}

	/** Sets the PPType for the PhysicalProduct Object*/
	public void setPPType(String PPType) {
		this.PPType = PPType;
		setDirty();
	}

	
	
	
	

}
