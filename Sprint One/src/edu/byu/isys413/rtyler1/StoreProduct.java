package edu.byu.isys413.rtyler1;

//import edu.byu.isys413.data.BusinessObjectDAO;
//import edu.byu.isys413.data.DataException;

public class StoreProduct extends BusinessObject{

	@BusinessObjectField
	private String storeId = null; //references Store
	@BusinessObjectField
	private String conceptualProductId = null; //references ConceptualProduct
	@BusinessObjectField
	private int quantityOnHand = 0;
	@BusinessObjectField
	private String shelfLocation = null;


	/** Creates the Business Object instance of this object*/
	public StoreProduct(String id) {
		super(id);
	}


	//////////////////////////////////////////////////////
	///  These next methods are our public interface

	
	/** Returns the store object */
	public Store getStore() throws DataException {
		return BusinessObjectDAO.getInstance().read(storeId);
	}

	
	/** Sets the store object */
	public void setStore(Store store) {
		this.storeId = store.getId();
		setDirty();
	}

	
	/** Returns the ConceptualProduct object */
	public ConceptualProduct getConceptualProduct() throws DataException {
		return BusinessObjectDAO.getInstance().read(conceptualProductId);
	}
	
	/** Sets the ConceptualProduct object */
	public void setConceptualProduct(ConceptualProduct cp) {
		this.conceptualProductId = cp.getId();
		setDirty();
	}

	
	
	//////////////////////////////////////////////////
	///  These next methods are for the DAO to use


	/** Gets the storeId for the StoreProduct Object*/
	public String getStoreId() {
		return storeId;
	}


	/** Sets the storeId for the StoreProduct Object*/
	public void setStoreId(String storeId) {
		this.storeId = storeId;
		setDirty();
	}


	/** Gets the conceptualProductId for the StoreProduct Object*/
	public String getConceptualProductId() {
		return conceptualProductId;
	}


	/** Sets the conceptualProductId for the StoreProduct Object*/
	public void setConceptualProductId(String conceptualProductId) {
		this.conceptualProductId = conceptualProductId;
		setDirty();
	}


	/** Gets the quantityOnHand for the StoreProduct Object*/
	public int getQuantityOnHand() {
		return quantityOnHand;
	}

	/** Sets the quantityOnHand for the StoreProduct Object*/
	public void setQuantityOnHand(int quantityOnHand) {
		this.quantityOnHand = quantityOnHand;
		setDirty();
	}

	/** Gets the shelfLocation for the StoreProduct Object*/
	public String getShelfLocation() {
		return shelfLocation;
	}

	/** Sets the shelfLocation for the StoreProduct Object*/
	public void setShelfLocation(String shelfLocation) {
		this.shelfLocation = shelfLocation;
		setDirty();
	}

	
	


}
