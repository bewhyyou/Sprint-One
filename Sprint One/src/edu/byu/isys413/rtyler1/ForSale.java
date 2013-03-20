package edu.byu.isys413.rtyler1;

public class ForSale extends PhysicalProduct{

	@BusinessObjectField
	private String newOrUsed = null;
	
	/** Creates the Business Object instance of this object*/
	public ForSale(String id) {
		super(id);
	}

	/** Gets the newOrUsed for the ForRent Object*/
	public String getNewOrUsed() {
		return newOrUsed;
	}

	/** Sets the newOrUsed for the ForRent Object*/
	public void setNewOrUsed(String newOrUsed) {
		this.newOrUsed = newOrUsed;
		setDirty();
	}
	
}
