package edu.byu.isys413.rtyler1;

import java.util.LinkedList;
import java.util.List;

//import edu.byu.isys413.data.BusinessObjectDAO;
//import edu.byu.isys413.data.DataException;
//import edu.byu.isys413.data.Person;
//import edu.byu.isys413.data.PersonCar;
//import edu.byu.isys413.data.SearchCriteria;

//import edu.byu.isys413.data.BusinessObjectDAO;
//import edu.byu.isys413.data.DataException;
//import edu.byu.isys413.data.Person;

public class ConceptualProduct extends Product{

	@BusinessObjectField
	private String productName = null;
	@BusinessObjectField
	private String description = null;
	@BusinessObjectField
	private String manufacturer = null;
	@BusinessObjectField
	private double averageCost = 0.0;
	@BusinessObjectField
	private String sku = null;



	/** Creates the Business Object instance of this object*/
	public ConceptualProduct(String id) {
		super(id);
	}

	
	/** Gets the productName for the ConceptualProduct Object*/
	public String getProductName() {
		return productName;
	}

	/** Sets the productName for the ConceptualProduct Object*/
	public void setProductName(String productName) {
		this.productName = productName;
		setDirty();
	}

	/** Gets the description for the ConceptualProduct Object*/
	public String getDescription() {
		return description;
	}

	/** Sets the description for the ConceptualProduct Object*/
	public void setDescription(String description) {
		this.description = description;
		setDirty();
	}

	/** Gets the manufacturer for the ConceptualProduct Object*/
	public String getManufacturer() {
		return manufacturer;
	}


	/** Sets the manufacturer for the ConceptualProduct Object*/
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
		setDirty();
	}


	/** Gets the averageCost for the ConceptualProduct Object*/
	public double getAverageCost() {
		return averageCost;
	}

	/** Sets the averageCost for the ConceptualProduct Object*/
	public void setAverageCost(double averageCost) {
		this.averageCost = averageCost;
		setDirty();
	}

	/** Gets the sku for the ConceptualProduct Object*/
	public String getSku() {
		return sku;
	}

	/** Sets the sku for the ConceptualProduct Object*/
	public void setSku(String sku) {
		this.sku = sku;
		setDirty();
	}

	/** 
	 * Returns the StoreProduct relationship objects that describe the stores that carry this particular conceptual product.
	 */
	public List<StoreProduct> getStoreProducts() throws DataException {
		return BusinessObjectDAO.getInstance().searchForList("StoreProduct", new SearchCriteria("conceptualproductid", id));
	}

	/**
	 * Retrieves the actual Store objects that own this conceptual product.
	 * This is a convenience method to traverse the intermediary table.
	 */
	public List<Store> getStores() throws DataException {
		List<Store> stores = new LinkedList<Store>();
		for (StoreProduct sp: this.getStoreProducts()) {
			stores.add(sp.getStore());
		}
		return stores;    
	}
	
	/**
	 * Retrieves the physicalproducts for this conceptualproduct
	 */
	public List<PhysicalProduct> getPhysicalProducts() throws DataException {
		return BusinessObjectDAO.getInstance().searchForList("PhysicalProduct", new SearchCriteria("conceptualproductid", id));
	}





}
