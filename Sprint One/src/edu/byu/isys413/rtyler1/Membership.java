package edu.byu.isys413.rtyler1;

public class Membership extends BusinessObject{

	@BusinessObjectField
	private String creditCard = null;
	
	
	/** Creates the Business Object instance of this object*/
	public Membership(String id) {
		super(id);
	}
	

	/** Gets the creditCard for the Membership Object*/
	public String getCreditCard() {
		return creditCard;
	}

	/** Sets the creditCard for the Membership Object*/
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
		setDirty();
	}
	
	

}
