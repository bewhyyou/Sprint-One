package edu.byu.isys413.rtyler1;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import swing2swt.layout.BorderLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import swing2swt.layout.FlowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.wb.swt.SWTResourceManager;

public class EmployeeLoginMine extends Dialog {

	protected Object result;
	protected Shell shlEmployeeLogin;
	private Text text;
	private Text text_1;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public EmployeeLoginMine(Shell parent, int style) {
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
		shlEmployeeLogin = new Shell(getParent(), getStyle());
		shlEmployeeLogin.setSize(243, 197);
		shlEmployeeLogin.setText("Employee Login");
		shlEmployeeLogin.setLayout(new BorderLayout(0, 0));
		
		Composite composite = new Composite(shlEmployeeLogin, SWT.NONE);
		composite.setLayoutData(BorderLayout.SOUTH);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Button btnNewButton = new Button(composite, SWT.NONE);
		btnNewButton.setBounds(0, 0, 94, 28);
		btnNewButton.setText("Ok");
		
		Button btnNewButton_1 = new Button(composite, SWT.NONE);
		btnNewButton_1.setText("Cancel");
		
		Composite composite_1 = new Composite(shlEmployeeLogin, SWT.BORDER);
		composite_1.setLayoutData(BorderLayout.CENTER);
		composite_1.setLayout(new GridLayout(2, false));
		
		Label lblUsername = new Label(composite_1, SWT.NONE);
		lblUsername.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblUsername.setText("Username:");
		
		text = new Text(composite_1, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblPassword = new Label(composite_1, SWT.NONE);
		lblPassword.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblPassword.setText("Password:");
		
		text_1 = new Text(composite_1, SWT.BORDER | SWT.PASSWORD);
		text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
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
}
