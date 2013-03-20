package edu.byu.isys413.rtyler1;

public class OnLine extends Sale{

	@BusinessObjectField
	private boolean pickUp = false;
	
	
	/** Creates the Business Object instance of this object*/
	public OnLine(String id) {
		super(id);
	}

	
	/** Gets the pickUp for the Online Object*/
	public boolean isPickUp() {
		return pickUp;
	}

	/** Sets the pickUp for the Online Object*/
	public void setPickUp(boolean pickUp) {
		this.pickUp = pickUp;
		setDirty();
	}
	
}
