package edu.byu.isys413.rtyler1;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

import org.eclipse.jface.window.WindowManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import swing2swt.layout.BorderLayout;
//import org.eclipse.jface.window.WindowManager;
//import edu.byu.isys413.swt.manager.WindowManager;
import org.eclipse.wb.swt.*;

public class EmployeeLogin extends Dialog {

	protected Object result;
	protected Shell shlEmployeeLogin;
	private Text username;
	private Text password;
	private Employee e;
	private boolean authentication = false;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public EmployeeLogin(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}
	
	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlEmployeeLogin.open();
		shlEmployeeLogin.layout();
		Display display = getParent().getDisplay();
		while (!shlEmployeeLogin.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shlEmployeeLogin = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.RESIZE | SWT.APPLICATION_MODAL);
		shlEmployeeLogin.setSize(290, 244);
		//center the window using WindowManager, courtesy of David Goodrich (creator of WindowManager library)
//		try {
//			WindowManager.getInstance().centerWindow(shlEmployeeLogin);
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		shlEmployeeLogin.setText("Employee Login");
		shlEmployeeLogin.setLayout(new BorderLayout(0, 0));
		
		Composite composite = new Composite(shlEmployeeLogin, SWT.NONE);
		composite.setLayoutData(BorderLayout.SOUTH);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite composite_1 = new Composite(shlEmployeeLogin, SWT.BORDER);
		composite_1.setLayoutData(BorderLayout.CENTER);
		composite_1.setLayout(new GridLayout(2, false));
		
		Label lblUsername = new Label(composite_1, SWT.NONE);
		lblUsername.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblUsername.setText("Username:");
		
		username = new Text(composite_1, SWT.BORDER);
		username.setText("roytm");
		GridData gd_username = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_username.widthHint = 176;
		username.setLayoutData(gd_username);
		
		Label lblPassword = new Label(composite_1, SWT.NONE);
		lblPassword.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblPassword.setText("Password:");
		
		password = new Text(composite_1, SWT.BORDER | SWT.PASSWORD);
		password.setText("august232011");
		GridData gd_password = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_password.widthHint = 178;
		password.setLayoutData(gd_password);
		new Label(composite_1, SWT.NONE);
		
		final Label warningLabel = new Label(composite_1, SWT.NONE);
		warningLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		warningLabel.setText("Incorrect Username or Password.\nPlease try again.");
		warningLabel.setVisible(false);
		
		Button loginButton = new Button(composite, SWT.NONE);
		loginButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (username.getText()==null||password.getText()==null) {
					authentication = false;
					return;
				} else if (authenticate(username.getText(), password.getText())) {
					authentication = true;
					try {
						Employee employee = BusinessObjectDAO.getInstance().searchForBO("Employee", 
								new SearchCriteria("username", username.getText()));
						setEmployee(employee);
					} catch (DataException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					shlEmployeeLogin.dispose();
				} else {
					authentication = false;
					warningLabel.setVisible(true);
				}
			}
		});
		loginButton.setBounds(0, 0, 94, 28);
		loginButton.setText("Ok");
		
		Button cancelButton = new Button(composite, SWT.NONE);
		cancelButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlEmployeeLogin.dispose();
			}
		});
		cancelButton.setText("Cancel");
		
		Composite composite_2 = new Composite(shlEmployeeLogin, SWT.NONE);
		composite_2.setLayoutData(BorderLayout.NORTH);
		composite_2.setLayout(new FillLayout(SWT.VERTICAL));
		
		Label lblWelcome = new Label(composite_2, SWT.NONE);
		lblWelcome.setFont(SWTResourceManager.getFont("Lucida Grande", 18, SWT.BOLD));
		lblWelcome.setAlignment(SWT.CENTER);
		lblWelcome.setText("\nWelcome!");
		
		Label lblNewLabel = new Label(composite_2, SWT.WRAP | SWT.HORIZONTAL);
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setText("Please login using your username and password.");

	}
	
	public boolean getAuthentication() {
		return authentication;
	}
	
	/**
	 * @return the e
	 */
	public Employee getEmployee() {
		return e;
	}

	/**
	 * @param e the e to set
	 */
	private void setEmployee(Employee e) {
		this.e = e;
	}

	/**
     *  Authenticates a user.  If the "new InitialDirContext" doesn't throw
     *  an exception, the user and password validated with LDAP.  We could then
     *  use this DirContext to query the user's email and address information,
     *  but all we care about is authentication.
     */
    public boolean authenticate(String NetID, String Password) {
        try{
            Hashtable<String,String> env = new Hashtable<String,String>();
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
	
}
