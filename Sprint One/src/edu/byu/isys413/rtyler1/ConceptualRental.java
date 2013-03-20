package edu.byu.isys413.rtyler1;

public class ConceptualRental extends ConceptualProduct{

	@BusinessObjectField
	private double pricePerDay = 0.0;
	@BusinessObjectField
	private double replacementPrice = 0.0;
	
	
	/** Creates the Business Object instance of this object*/
	public ConceptualRental(String id) {
		super(id);
	}

	/** Gets the pricePerDay for the ConceptualRental Object*/
	public double getPricePerDay() {
		return pricePerDay;
	}

	/** Sets the pricePerDay for the ConceptualRental Object*/
	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
		setDirty();
	}

	/** Gets the replacementPrice for the ConceptualRental Object*/
	public double getReplacementPrice() {
		return replacementPrice;
	}

	/** Sets the replacementPrice for the ConceptualRental Object*/
	public void setReplacementPrice(double replacementPrice) {
		this.replacementPrice = replacementPrice;
		setDirty();
	}

	
	
}
