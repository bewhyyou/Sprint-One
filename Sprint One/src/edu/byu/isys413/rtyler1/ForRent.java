package edu.byu.isys413.rtyler1;

import java.util.List;

public class ForRent extends PhysicalProduct{

	@BusinessObjectField
	private int timesRented = 0;
	@BusinessObjectField
	private String rentalId = null; //references Rental
	
	/** Creates the Business Object instance of this object*/
	public ForRent(String id) {
		super(id);
	}

	/** Gets the timesRented for the ForRent Object*/
	public int getTimesRented() {
		return timesRented;
	}

	/** Sets the timesRented for the ForRent Object*/
	public void setTimesRented(int timesRented) {
		this.timesRented = timesRented;
		setDirty();
	}
	
	/** Gets the rentalId for the ForRent Object*/
	public String getRentalId() {
		return rentalId;
	}

	/** Sets the rentalId for the ForRent Object*/
	public void setRentalId(String rentalId) {
		this.rentalId = rentalId;
		setDirty();
	}
		
	/** Sets the Rental object */
	public void setRental(Rental rental) {
		this.rentalId = rental.getId();
		setDirty();
	}

	/** Returns the Rental object */
	public Rental getRental() throws DataException {
		return BusinessObjectDAO.getInstance().read(rentalId);
	}

	/**
	 * Retrieves the rentals for this ForRent product
	 */
	public List<Rental> getRentals() throws DataException {
		return BusinessObjectDAO.getInstance().searchForList("Rental", new SearchCriteria("forrentid", id));
	}
}
