package edu.byu.isys413.rtyler1;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class EmployeeLoginScreen {

	protected Shell shell;
	private Text userNameField;
	private Text passwordField;
	public static byte[] mac;
	public static String stringMacAddress;
	public static Store store;
	//public Transaction1 trans;


	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
	
		EmployeeLoginScreen.getMacAddress();
		
		try {
			EmployeeLoginScreen window = new EmployeeLoginScreen();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}


	}//main

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

		
	//get mac address
	//get the store with the associated mac address
	//set the store to the transaction object 
	
	
	
	/** Gets the MAC address of the computer (from http://www.mkyong.com/java/how-to-get-mac-address-in-java/) */
	public static void getMacAddress() {
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
			
			Transaction1 trans11 = BusinessObjectDAO.getInstance().create("Transaction1", "trans11");
			comp = BusinessObjectDAO.getInstance().searchForBO("Computer", new SearchCriteria("macaddress", stringMacAddress));
			store = comp.getStore();
			trans11.setStore(store);
			trans11.save();
			
		} catch (DataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//Computer comp = BusinessObjectDAO.getInstance().read("Computer", stringMacAddress);
		

	}//getMacAddress
	

	public void loginButtonPushed(String routeY, String passWord) {

		String ryid = routeY;
		String password = passWord;
		Employee emp;
		Store store;

		passwordField.setEchoChar('*');


		// run the LDAP
		LDAP ldap = new LDAP();
		if (ldap.authenticate(ryid, password)) {


			try {

				//create transaction object 
				

				//set store to transaction object
				//store = BusinessObjectDAO.getInstance().searchForBO("Computer", new SearchCriteria("macaddress", storeMacAddress));
				//computer.setStore(store)
				//trans.setStore(store)

				//get employee, set to transaction object
				Transaction1 trans = BusinessObjectDAO.getInstance().read("trans11");
				emp = BusinessObjectDAO.getInstance().searchForBO("Employee", new SearchCriteria("loginname", ryid)); //creating an object (searchCriteria)
				trans.setEmployee(emp);

				//MainScreen.open()


				System.out.println("Authentication worked!");


			} catch (DataException e) {

				e.printStackTrace();
			}


		}else{
			System.out.println("Authentication didn't work.");
		}

	}


	/**
	 *  Authenticates a user.  If the "new InitialDirContext" doesn't throw
	 *  an exception, the user and password validated with LDAP.  We could then
	 *  use this DirContext to query the user's email and address information,
	 *  but all we care about is authentication.
	 */
	public boolean authenticate(String NetID, String Password) {
		try{
			Hashtable env = new Hashtable();
			env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
			env.put(Context.PROVIDER_URL, "ldaps://ldap.byu.edu/");
			env.put(Context.SECURITY_AUTHENTICATION, "simple");
			env.put(Context.SECURITY_PRINCIPAL, "uid=" + NetID + ", ou=People, o=byu.edu");
			env.put(Context.SECURITY_CREDENTIALS, Password);
			DirContext ctx = new InitialDirContext(env);
			return true;

		}catch (NamingException e) {
			return false;
		}
	}



	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		shell.setLayout(null);

		Label lblPleaseLoginWith = new Label(shell, SWT.NONE);
		lblPleaseLoginWith.setBounds(93, 48, 253, 15);
		lblPleaseLoginWith.setText("Please login with your Username and Password");

		userNameField = new Text(shell, SWT.BORDER);
		userNameField.setBounds(151, 91, 195, 21);

		Label lblUsername = new Label(shell, SWT.NONE);
		lblUsername.setBounds(90, 94, 56, 15);
		lblUsername.setText("Username:");

		passwordField = new Text(shell, SWT.BORDER);
		passwordField.setBounds(151, 118, 195, 21);

		Label lblPassword = new Label(shell, SWT.NONE);
		lblPassword.setAlignment(SWT.RIGHT);
		lblPassword.setBounds(91, 121, 56, 15);
		lblPassword.setText("Password:");

		Button btnLogin = new Button(shell, SWT.NONE);
		btnLogin.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				loginButtonPushed(userNameField.getText(), passwordField.getText());			

			}
		});
		btnLogin.setBounds(148, 171, 75, 25);
		btnLogin.setText("Login");

		Button btnCancel = new Button(shell, SWT.NONE);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				shell.close();

			}
		});
		btnCancel.setBounds(229, 171, 75, 25);
		btnCancel.setText("Cancel");

	}
	
	
	

}
