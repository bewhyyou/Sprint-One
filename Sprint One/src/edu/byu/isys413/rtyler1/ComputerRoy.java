package edu.byu.isys413.rtyler1;

public class ComputerRoy extends BusinessObject{
	@BusinessObjectField
	private String macAddress = null;
	@BusinessObjectField
	private String subnet = null;
	
	/**Creates a new instance of BusinessObject*/
	public ComputerRoy(String id) {
		super(id);
	}//constructor

	/**
	 * @return the macAddress
	 */
	public String getMacAddress() {
		return macAddress;
	}

	/**
	 * @param macAddress the macAddress to set
	 */
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
		setDirty();
	}

	/**
	 * @return the subnet
	 */
	public String getSubnet() {
		return subnet;
	}

	/**
	 * @param subnet the subnet to set
	 */
	public void setSubnet(String subnet) {
		this.subnet = subnet;
		setDirty();
	}
	
}
