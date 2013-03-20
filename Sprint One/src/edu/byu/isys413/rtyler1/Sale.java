package edu.byu.isys413.rtyler1;

//import edu.byu.isys413.data.BusinessObjectDAO;
//import edu.byu.isys413.data.DataException;

public class Sale extends RevenueSource{


	@BusinessObjectField
	private String prodId = null; //references Product
	@BusinessObjectField
	private int quantity = 0;
	@BusinessObjectField
	private String saleType = null;


	/** Creates the Business Object instance of this object*/
	public Sale(String id) {
		super(id);
	}

	/** Gets the prodId for the Sale Object*/
	public String getProdId() {
		return prodId;
	}

	/** Sets the prodId for the Sale Object*/
	public void setProdId(String prodId) {
		this.prodId = prodId;
		setDirty();
	}

	/** Sets the Product object */
	public void setProduct(Product prod) {
		this.prodId = prod.getId();
		setDirty();
	}

	/** Returns the Product object */
	public Product getProduct() throws DataException {
		return BusinessObjectDAO.getInstance().read(prodId);
	}
	
	
	/** Gets the quantity for the Sale Object*/
	public int getQuantity() {
		return quantity;
	}

	/** Sets the quantity for the Sale Object*/
	public void setQuantity(int quantity) {
		this.quantity = quantity;
		setDirty();
	}

	/** Gets the saleType for the Sale Object*/
	public String getSaleType() {
		return saleType;
	}

	/** Sets the saleType for the Sale Object*/
	public void setSaleType(String saleType) {
		this.saleType = saleType;
		setDirty();
	}
	
	
	


}
