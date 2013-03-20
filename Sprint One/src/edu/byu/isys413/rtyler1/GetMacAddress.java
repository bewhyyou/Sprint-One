package edu.byu.isys413.rtyler1;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class GetMacAddress {

	public byte[] mac;
	public String stringMacAddress;
	
	/** Gets the MAC address of the computer (from http://www.mkyong.com/java/how-to-get-mac-address-in-java/) */
	public void getMacAddress() {
		InetAddress ip;
		try {

			ip = InetAddress.getLocalHost();
			System.out.println("Current IP address : " + ip.getHostAddress());

			NetworkInterface network = NetworkInterface.getByInetAddress(ip);

			mac = network.getHardwareAddress();

			System.out.print("Current MAC address : ");

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < mac.length; i++) {
				sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
			}
			
			stringMacAddress = sb.toString();
			
			System.out.println(sb.toString());

		} catch (UnknownHostException e) {

			e.printStackTrace();

		} catch (SocketException e){

			e.printStackTrace();

		}
		
		
		Computer comp;
		
		try {
			
			comp = BusinessObjectDAO.getInstance().searchForBO("Computer", new SearchCriteria("username", stringMacAddress));
			Store store = comp.getStore();
			
			
		} catch (DataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//Computer comp = BusinessObjectDAO.getInstance().read("Computer", stringMacAddress);
		

	}//getMacAddress
}
