package edu.byu.isys413.rtyler1;

public class Late extends Fee{

	
	@BusinessObjectField
	private int daysLate = 0;
	
	
	/** Creates the Business Object instance of this object*/
	public Late(String id) {
		super(id);
	}

	/** Gets the daysLate for the Late Object*/
	public int getDaysLate() {
		return daysLate;
	}

	/** Sets the daysLate for the Late Object*/
	public void setDaysLate(int daysLate) {
		this.daysLate = daysLate;
		setDirty();
	}
	
	

}
