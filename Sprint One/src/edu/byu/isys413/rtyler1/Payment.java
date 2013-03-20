package edu.byu.isys413.rtyler1;

public class Payment extends BusinessObject{

	@BusinessObjectField
	private double amount = 0.0;
	@BusinessObjectField
	private double paymentChange = 0.0;
	@BusinessObjectField
	private String paymentType = null;
	
	/** Creates the Business Object instance of this object*/
	public Payment(String id) {
		super(id);
	}

	/** Gets the amount for the Payment Object*/
	public double getAmount() {
		return amount;
	}

	/** Sets the amount for the Payment Object*/
	public void setAmount(double amount) {
		this.amount = amount;
		setDirty();
	}

	/** Gets the change for the Payment Object*/
	public double getPaymentChange() {
		return paymentChange;
	}

	/** Sets the change for the Payment Object*/
	public void setPaymentChange(double change) {
		this.paymentChange = change;
		setDirty();
	}

	/** Gets the paymentType for the Payment Object*/
	public String getPaymentType() {
		return paymentType;
	}

	/** Sets the paymentType for the Payment Object*/
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
		setDirty();
	}

	
}
