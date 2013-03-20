package edu.byu.isys413.rtyler1;

import java.util.List;

public class Rental extends RevenueSource {

	@BusinessObjectField
	private String forRentId = null;
	@BusinessObjectField
	private java.util.Date dateOut = null;
	@BusinessObjectField
	private java.util.Date dateDue = null;
	@BusinessObjectField
	private java.util.Date dateIn = null;
	@BusinessObjectField
	private String reminderSent = null; //either yes or no
	
	
	/** Creates the Business Object instance of this object*/
	public Rental(String id) {
		super(id);
	}

	/** Gets the forRentId for the Rental Object*/
	public String getForRentId() {
		return forRentId;
	}

	/** Sets the forRentId for the Rental Object*/
	public void setForRentId(String forRentId) {
		this.forRentId = forRentId;
		setDirty();
	}

	/** Sets the For Rent object */
	public void setForRent(ForRent fr) {
		this.forRentId = fr.getId();
		setDirty();
	}

	/** Returns the For Rent object */
	public ForRent getForRent() throws DataException {
		return BusinessObjectDAO.getInstance().read(forRentId);
	}	
	
	/** Gets the dateOut for the Rental Object*/
	public java.util.Date getDateOut() {
		return dateOut;
	}

	/** Sets the dateOut for the Rental Object*/
	public void setDateOut(java.util.Date dateOut) {
		this.dateOut = dateOut;
		setDirty();
	}

	/** Gets the dateDue for the Rental Object*/
	public java.util.Date getDateDue() {
		return dateDue;
	}

	/** Sets the dateDue for the Rental Object*/
	public void setDateDue(java.util.Date dateDue) {
		this.dateDue = dateDue;
		setDirty();
	}

	/** Gets the dateIn for the Rental Object*/
	public java.util.Date getDateIn() {
		return dateIn;
	}

	/** Sets the dateIn for the Rental Object*/
	public void setDateIn(java.util.Date dateIn) {
		this.dateIn = dateIn;
		setDirty();
	}

	/** Gets the reminderSent for the Rental Object*/
	public String getReminderSent() {
		return reminderSent;
	}

	/** Sets the reminderSent for the Rental Object*/
	public void setReminderSent(String reminderSent) {
		this.reminderSent = reminderSent;
		setDirty();
	}
	
	
	/**
	 * Retrieves the fees for this Rental product
	 */
	public List<Fee> getFees() throws DataException {
		return BusinessObjectDAO.getInstance().searchForList("Fee", new SearchCriteria("rentalId", id));
	}
	
	

}
