package edu.byu.isys413.rtyler1;



import swing2swt.layout.BorderLayout;

import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnPixelData;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class MainWindowMine {

	protected Shell shlMystuffMain;
	private Text text;
	private Text text_1;
	private Table table;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Text text_7;
	private Text text_8;
	private Text text_9;
	private Text text_10;
	private Text text_11;
	private Text text_12;
	private Text text_13;
	private Text text_14;
	private Text text_15;
	private Text text_16;
	private Text text_17;
	private Text text_18;
	private Text text_19;
	private Text text_20;
	private Text text_21;
	private Text text_22;
	private Text text_23;
	private Text text_24;
	private Text text_25;
	private Text text_26;
	private Text text_27;
	private Text text_28;
	private Text text_29;
	private Text text_30;
	private Text text_31;
	private Text text_32;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainWindowMine window = new MainWindowMine();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlMystuffMain.open();
		shlMystuffMain.layout();
		while (!shlMystuffMain.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlMystuffMain = new Shell();
		shlMystuffMain.setSize(791, 505);
		shlMystuffMain.setText("MyStuff - Sale System");
		shlMystuffMain.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		TabFolder tabFolder = new TabFolder(shlMystuffMain, SWT.NONE);
		
		TabItem tbtmMainWindow = new TabItem(tabFolder, SWT.NONE);
		tbtmMainWindow.setText("Main Window");
		
		Composite composite = new Composite(tabFolder, SWT.NONE);
		tbtmMainWindow.setControl(composite);
		composite.setLayout(new FormLayout());
		
		Label lblSku = new Label(composite, SWT.NONE);
		FormData fd_lblSku = new FormData();
		lblSku.setLayoutData(fd_lblSku);
		lblSku.setText("SKU:");
		
		text = new Text(composite, SWT.BORDER);
		fd_lblSku.right = new FormAttachment(text, -24);
		fd_lblSku.top = new FormAttachment(text, 3, SWT.TOP);
		FormData fd_text = new FormData();
		fd_text.left = new FormAttachment(0, 89);
		text.setLayoutData(fd_text);
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		FormData fd_lblNewLabel = new FormData();
		fd_lblNewLabel.top = new FormAttachment(lblSku, 11);
		fd_lblNewLabel.left = new FormAttachment(lblSku, 0, SWT.LEFT);
		lblNewLabel.setLayoutData(fd_lblNewLabel);
		lblNewLabel.setText("Serial #:");
		
		text_1 = new Text(composite, SWT.BORDER);
		FormData fd_text_1 = new FormData();
		fd_text_1.right = new FormAttachment(text, 0, SWT.RIGHT);
		fd_text_1.top = new FormAttachment(text, 6);
		fd_text_1.left = new FormAttachment(text, 0, SWT.LEFT);
		text_1.setLayoutData(fd_text_1);
		
		Composite composite_1 = new Composite(composite, SWT.NONE);
		fd_text.right = new FormAttachment(composite_1, -6);
		TableColumnLayout tcl_composite_1 = new TableColumnLayout();
		composite_1.setLayout(tcl_composite_1);
		FormData fd_composite_1 = new FormData();
		fd_composite_1.right = new FormAttachment(100, -38);
		fd_composite_1.left = new FormAttachment(0, 237);
		composite_1.setLayoutData(fd_composite_1);
		
		TableViewer tableViewer = new TableViewer(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnProductName = new TableColumn(table, SWT.NONE);
		tcl_composite_1.setColumnData(tblclmnProductName, new ColumnPixelData(236, true, true));
		tblclmnProductName.setText("Product Name");
		
		TableColumn tblclmnQuantity = new TableColumn(table, SWT.NONE);
		tcl_composite_1.setColumnData(tblclmnQuantity, new ColumnPixelData(50, true, true));
		tblclmnQuantity.setText("Quantity");
		
		TableColumn tblclmnPrice = new TableColumn(table, SWT.NONE);
		tcl_composite_1.setColumnData(tblclmnPrice, new ColumnPixelData(49, true, true));
		tblclmnPrice.setText("Price");
		
		Button btnNewButton = new Button(composite, SWT.FLAT);
		FormData fd_btnNewButton = new FormData();
		fd_btnNewButton.top = new FormAttachment(text_1, 6);
		fd_btnNewButton.right = new FormAttachment(text, 0, SWT.RIGHT);
		fd_btnNewButton.left = new FormAttachment(0, 89);
		btnNewButton.setLayoutData(fd_btnNewButton);
		btnNewButton.setText("Add Product");
		
		Composite composite_2 = new Composite(composite, SWT.BORDER);
		composite_2.setLayout(new BorderLayout(0, 0));
		FormData fd_composite_2 = new FormData();
		fd_composite_2.top = new FormAttachment(btnNewButton, 6);
		fd_composite_2.right = new FormAttachment(composite_1, -6);
		fd_composite_2.left = new FormAttachment(0, 36);
		composite_2.setLayoutData(fd_composite_2);
		
		Composite composite_3 = new Composite(composite_2, SWT.BORDER);
		composite_3.setLayoutData(BorderLayout.NORTH);
		composite_3.setLayout(new FillLayout(SWT.VERTICAL));
		
		Label customerHead = new Label(composite_3, SWT.BORDER);
		customerHead.setFont(SWTResourceManager.getFont("Lucida Grande", 15, SWT.NORMAL));
		customerHead.setText("Customer");
		
		Composite composite_4 = new Composite(composite_2, SWT.NONE);
		composite_4.setLayoutData(BorderLayout.SOUTH);
		composite_4.setLayout(new FillLayout(SWT.VERTICAL));
		
		Button btnNewCustomer = new Button(composite_4, SWT.FLAT);
		btnNewCustomer.setText("New Customer");
		
		Button btnSaveCustomer = new Button(composite_4, SWT.FLAT);
		btnSaveCustomer.setText("Save Customer");
		
		Composite composite_5 = new Composite(composite_2, SWT.NONE);
		composite_5.setLayoutData(BorderLayout.CENTER);
		composite_5.setLayout(new GridLayout(2, false));
		
		Label lblPhone = new Label(composite_5, SWT.NONE);
		lblPhone.setText("Phone:");
		
		text_2 = new Text(composite_5, SWT.BORDER);
		text_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite_5, SWT.NONE);
		
		Button btnLookup = new Button(composite_5, SWT.FLAT);
		btnLookup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnLookup.setText("Lookup");
		
		Label lblName = new Label(composite_5, SWT.NONE);
		lblName.setText("First Name:");
		
		text_3 = new Text(composite_5, SWT.BORDER);
		text_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblNewLabel_1 = new Label(composite_5, SWT.NONE);
		lblNewLabel_1.setText("Last Name:");
		
		text_10 = new Text(composite_5, SWT.BORDER);
		text_10.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblEmail = new Label(composite_5, SWT.NONE);
		lblEmail.setText("Email:");
		
		text_4 = new Text(composite_5, SWT.BORDER);
		text_4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblAddress = new Label(composite_5, SWT.NONE);
		lblAddress.setText("Address:");
		
		text_5 = new Text(composite_5, SWT.BORDER);
		text_5.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblMembershipNumber = new Label(composite_5, SWT.WRAP);
		lblMembershipNumber.setText("City:");
		
		text_6 = new Text(composite_5, SWT.BORDER);
		text_6.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblStateZip = new Label(composite_5, SWT.NONE);
		lblStateZip.setText("State, Zip:");
		
		text_11 = new Text(composite_5, SWT.BORDER);
		text_11.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblMembership = new Label(composite_5, SWT.NONE);
		lblMembership.setText("Member #:");
		
		text_12 = new Text(composite_5, SWT.BORDER);
		text_12.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label label = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
		fd_composite_1.top = new FormAttachment(0, 37);
		FormData fd_label = new FormData();
		fd_label.left = new FormAttachment(0, 10);
		fd_label.right = new FormAttachment(100, -10);
		fd_label.bottom = new FormAttachment(100, -411);
		label.setLayoutData(fd_label);
		
		Label lblSubtotal = new Label(composite, SWT.NONE);
		FormData fd_lblSubtotal = new FormData();
		lblSubtotal.setLayoutData(fd_lblSubtotal);
		lblSubtotal.setText("Subtotal:");
		
		text_7 = new Text(composite, SWT.BORDER);
		fd_lblSubtotal.top = new FormAttachment(text_7, 3, SWT.TOP);
		fd_composite_1.bottom = new FormAttachment(100, -144);
		FormData fd_text_7 = new FormData();
		fd_text_7.right = new FormAttachment(composite_1, 0, SWT.RIGHT);
		text_7.setLayoutData(fd_text_7);
		
		Label lblTax = new Label(composite, SWT.NONE);
		fd_lblSubtotal.left = new FormAttachment(lblTax, 0, SWT.LEFT);
		FormData fd_lblTax = new FormData();
		lblTax.setLayoutData(fd_lblTax);
		lblTax.setText("Tax:");
		
		Label lblTotal = new Label(composite, SWT.NONE);
		FormData fd_lblTotal = new FormData();
		fd_lblTotal.top = new FormAttachment(0, 374);
		lblTotal.setLayoutData(fd_lblTotal);
		lblTotal.setText("Total:");
		
		text_8 = new Text(composite, SWT.BORDER);
		fd_lblTax.right = new FormAttachment(text_8, -30);
		fd_text_7.bottom = new FormAttachment(text_8, -6);
		fd_text_7.left = new FormAttachment(text_8, 0, SWT.LEFT);
		fd_lblTax.top = new FormAttachment(text_8, 3, SWT.TOP);
		FormData fd_text_8 = new FormData();
		fd_text_8.right = new FormAttachment(composite_1, 0, SWT.RIGHT);
		fd_text_8.left = new FormAttachment(0, 489);
		text_8.setLayoutData(fd_text_8);
		
		text_9 = new Text(composite, SWT.BORDER);
		fd_text_8.bottom = new FormAttachment(text_9, -6);
		fd_lblTotal.right = new FormAttachment(text_9, -23);
		FormData fd_text_9 = new FormData();
		fd_text_9.top = new FormAttachment(0, 371);
		fd_text_9.right = new FormAttachment(composite_1, 0, SWT.RIGHT);
		fd_text_9.left = new FormAttachment(0, 489);
		text_9.setLayoutData(fd_text_9);
		
		Button btnFinalizeTransaction = new Button(composite, SWT.BORDER | SWT.FLAT);
		fd_composite_2.bottom = new FormAttachment(btnFinalizeTransaction, 0, SWT.BOTTOM);
		FormData fd_btnFinalizeTransaction = new FormData();
		fd_btnFinalizeTransaction.left = new FormAttachment(composite_2, 258);
		fd_btnFinalizeTransaction.right = new FormAttachment(100, -38);
		fd_btnFinalizeTransaction.bottom = new FormAttachment(100, -10);
		btnFinalizeTransaction.setLayoutData(fd_btnFinalizeTransaction);
		btnFinalizeTransaction.setText("Finalize Transaction");
		
		Label lblProductLookup = new Label(composite, SWT.NONE);
		fd_text.top = new FormAttachment(lblProductLookup, 6);
		lblProductLookup.setFont(SWTResourceManager.getFont("Lucida Grande", 15, SWT.NORMAL));
		FormData fd_lblProductLookup = new FormData();
		fd_lblProductLookup.left = new FormAttachment(0, 36);
		fd_lblProductLookup.top = new FormAttachment(composite_1, 0, SWT.TOP);
		lblProductLookup.setLayoutData(fd_lblProductLookup);
		lblProductLookup.setText("Product Lookup");
		
		Button btnNewButton_1 = new Button(composite, SWT.FLAT);
		fd_label.top = new FormAttachment(0, 32);
		FormData fd_btnNewButton_1 = new FormData();
		fd_btnNewButton_1.right = new FormAttachment(100, -10);
		fd_btnNewButton_1.bottom = new FormAttachment(composite_1, -6);
		btnNewButton_1.setLayoutData(fd_btnNewButton_1);
		btnNewButton_1.setText("Sign Out");
		
		Label lblJanuary = new Label(composite, SWT.NONE);
		FormData fd_lblJanuary = new FormData();
		fd_lblJanuary.bottom = new FormAttachment(label, -6);
		fd_lblJanuary.left = new FormAttachment(label, 0, SWT.LEFT);
		lblJanuary.setLayoutData(fd_lblJanuary);
		lblJanuary.setText("January 31, 2013 6:31PM");
		
		
		TabItem tbtmNewItem_2 = new TabItem(tabFolder, SWT.NONE);
		tbtmNewItem_2.setText("Update General Ledger");
		
		Composite composite_6 = new Composite(tabFolder, SWT.NONE);
		tbtmNewItem_2.setControl(composite_6);
		composite_6.setLayout(new BorderLayout(0, 0));
		
		Composite composite_7 = new Composite(composite_6, SWT.NONE);
		composite_7.setLayoutData(BorderLayout.WEST);
		composite_7.setLayout(new GridLayout(1, false));
		
		Button btnUpdate = new Button(composite_7, SWT.FLAT);
		btnUpdate.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnUpdate.setText("Update Now");
		
		Label label_1 = new Label(composite_7, SWT.NONE);
		label_1.setFont(SWTResourceManager.getFont("Lucida Grande", 15, SWT.NORMAL));
		label_1.setText("View Update History:");
		
		List list = new List(composite_7, SWT.BORDER);
		GridData gd_list = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_list.heightHint = 220;
		gd_list.widthHint = 159;
		list.setLayoutData(gd_list);
		
		Composite composite_8 = new Composite(composite_6, SWT.NONE);
		composite_8.setLayoutData(BorderLayout.NORTH);
		composite_8.setLayout(new FillLayout(SWT.VERTICAL));
		
		Label lblUpdateGL = new Label(composite_8,SWT.CENTER);
		lblUpdateGL.setFont(SWTResourceManager.getFont("Lucida Grande", 20, SWT.NORMAL));
		lblUpdateGL.setText("Update General Ledger");
		
		Label label_2 = new Label(composite_8, SWT.SEPARATOR | SWT.HORIZONTAL);
		
		Composite composite_9 = new Composite(composite_6, SWT.NONE);
		composite_9.setLayoutData(BorderLayout.CENTER);
		composite_9.setLayout(new GridLayout(2, false));
		
		Label lblNewLabel_2 = new Label(composite_9, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("Lucida Grande", 15, SWT.NORMAL));
		lblNewLabel_2.setText("Update Details:");
		new Label(composite_9, SWT.NONE);
		
		Label label_3 = new Label(composite_9, SWT.NONE);
		new Label(composite_9, SWT.NONE);
		
		Label lblLastUpdatePerformed = new Label(composite_9, SWT.NONE);
		lblLastUpdatePerformed.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblLastUpdatePerformed.setText("Date Performed:");
		
		text_13 = new Text(composite_9, SWT.BORDER);
		GridData gd_text_13 = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_text_13.widthHint = 147;
		text_13.setLayoutData(gd_text_13);
		
		Label lblNewLabel_3 = new Label(composite_9, SWT.NONE);
		lblNewLabel_3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_3.setText("Time:");
		
		text_14 = new Text(composite_9, SWT.BORDER);
		GridData gd_text_14 = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_text_14.widthHint = 147;
		text_14.setLayoutData(gd_text_14);
		
		Label lblTransactionsUpdatedTo = new Label(composite_9, SWT.WRAP);
		lblTransactionsUpdatedTo.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTransactionsUpdatedTo.setText("Number of Transactions:");
		
		text_15 = new Text(composite_9, SWT.BORDER);
		text_15.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		TabItem tbtmNewItem_3 = new TabItem(tabFolder, SWT.NONE);
		tbtmNewItem_3.setText("Pay Commissions");
		
		Composite composite_10 = new Composite(tabFolder, SWT.NONE);
		composite_10.setFont(SWTResourceManager.getFont("Lucida Grande", 20, SWT.NORMAL));
		tbtmNewItem_3.setControl(composite_10);
		composite_10.setLayout(new BorderLayout(0, 0));
		
		Composite composite_11 = new Composite(composite_10, SWT.NONE);
		composite_11.setLayoutData(BorderLayout.NORTH);
		composite_11.setLayout(new FillLayout(SWT.VERTICAL));
		
		Label payCommsHeader = new Label(composite_11,SWT.NONE);
		payCommsHeader.setAlignment(SWT.CENTER);
		payCommsHeader.setFont(SWTResourceManager.getFont("Lucida Grande", 20, SWT.NORMAL));
		payCommsHeader.setText("Pay Commissions");
		
		Label label_4 = new Label(composite_11, SWT.SEPARATOR | SWT.HORIZONTAL);
		
		Composite composite_12 = new Composite(composite_10, SWT.NONE);
		composite_12.setLayoutData(BorderLayout.WEST);
		composite_12.setLayout(new GridLayout(1, false));
		
		Label label_5 = new Label(composite_12, SWT.NONE);
		label_5.setText("Last Payment Date:");
		
		text_31 = new Text(composite_12, SWT.BORDER);
		text_31.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button btnNewButton_2 = new Button(composite_12, SWT.FLAT);
		btnNewButton_2.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
		GridData gd_btnNewButton_2 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnNewButton_2.widthHint = 115;
		btnNewButton_2.setLayoutData(gd_btnNewButton_2);
	
		btnNewButton_2.setText("Pay Commissions");
		
		Button btnNewButton_3 = new Button(composite_12, SWT.FLAT);
		btnNewButton_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnNewButton_3.setText("Print Statements");
		
		Composite composite_13 = new Composite(composite_10, SWT.NONE);
		composite_13.setLayoutData(BorderLayout.EAST);
		composite_13.setLayout(new GridLayout(2, false));
		
		Label lblNewLabel_5 = new Label(composite_13, SWT.WRAP);
		lblNewLabel_5.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
		lblNewLabel_5.setText("Security Concerns/\nNotifications");
		new Label(composite_13, SWT.NONE);
		
		Label lblNewLabel_7 = new Label(composite_13, SWT.NONE);
		lblNewLabel_7.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_7.setText("Total Payments:");
		
		text_19 = new Text(composite_13, SWT.BORDER);
		GridData gd_text_19 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_text_19.widthHint = 91;
		text_19.setLayoutData(gd_text_19);
		
		Label lblTotalTransactions = new Label(composite_13, SWT.NONE);
		lblTotalTransactions.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTotalTransactions.setText("Total Transactions:");
		
		text_20 = new Text(composite_13, SWT.BORDER);
		text_20.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblNewLabel_4 = new Label(composite_13, SWT.NONE);
		lblNewLabel_4.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_4.setText("Difference:");
		
		text_21 = new Text(composite_13, SWT.BORDER);
		text_21.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite_13, SWT.NONE);
		new Label(composite_13, SWT.NONE);
		
		Label lblTotalAmount_1 = new Label(composite_13, SWT.NONE);
		lblTotalAmount_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTotalAmount_1.setText("Total Amount:");
		
		text_22 = new Text(composite_13, SWT.BORDER);
		text_22.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblTotalOfItems = new Label(composite_13, SWT.NONE);
		lblTotalOfItems.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTotalOfItems.setText("Total of Items Sold:");
		
		text_23 = new Text(composite_13, SWT.BORDER);
		text_23.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblNewLabel_8 = new Label(composite_13, SWT.NONE);
		lblNewLabel_8.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_8.setText("Avg. Commission (%):");
		
		text_24 = new Text(composite_13, SWT.BORDER);
		text_24.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite_13, SWT.NONE);
		new Label(composite_13, SWT.NONE);
		
		Label lblCommissionsOver = new Label(composite_13, SWT.WRAP);
		lblCommissionsOver.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
		lblCommissionsOver.setText("Commissions Over \n40% of Total Sales:");
		
		List list_2 = new List(composite_13, SWT.BORDER);
		GridData gd_list_2 = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_list_2.heightHint = 170;
		gd_list_2.widthHint = 59;
		list_2.setLayoutData(gd_list_2);
		
		Composite composite_14 = new Composite(composite_10, SWT.NONE);
		composite_14.setLayoutData(BorderLayout.CENTER);
		composite_14.setLayout(new BorderLayout(0, 0));
		
		Composite composite_15 = new Composite(composite_14, SWT.NONE);
		composite_15.setLayoutData(BorderLayout.WEST);
		composite_15.setLayout(new GridLayout(1, false));
		
		Label lblNewLabel_6 = new Label(composite_15, SWT.NONE);
		lblNewLabel_6.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.ITALIC));
		lblNewLabel_6.setText("Select Employee:");
		
		List list_1 = new List(composite_15, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		GridData gd_list_1 = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_list_1.heightHint = 355;
		gd_list_1.widthHint = 145;
		list_1.setLayoutData(gd_list_1);
		
		Composite composite_16 = new Composite(composite_14, SWT.NONE);
		composite_16.setLayoutData(BorderLayout.CENTER);
		composite_16.setLayout(new GridLayout(2, false));
		
		Label lblCommissionDetails = new Label(composite_16, SWT.WRAP);
		lblCommissionDetails.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
		lblCommissionDetails.setText("Overall Commission\nPayment Detail:");
		new Label(composite_16, SWT.NONE);
		
		Label lblDate = new Label(composite_16, SWT.NONE);
		lblDate.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblDate.setText("Date:");
		
		text_16 = new Text(composite_16, SWT.BORDER);
		GridData gd_text_16 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_text_16.widthHint = 75;
		text_16.setLayoutData(gd_text_16);
		
		Label lblTotalPayments = new Label(composite_16, SWT.NONE);
		lblTotalPayments.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTotalPayments.setText("Total Payments Made:");
		
		text_17 = new Text(composite_16, SWT.BORDER);
		GridData gd_text_17 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_text_17.widthHint = 106;
		text_17.setLayoutData(gd_text_17);
		
		Label lblTotalAmount = new Label(composite_16, SWT.NONE);
		lblTotalAmount.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTotalAmount.setText("Total Amount:");
		
		text_18 = new Text(composite_16, SWT.BORDER);
		GridData gd_text_18 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_text_18.widthHint = 105;
		text_18.setLayoutData(gd_text_18);
		new Label(composite_16, SWT.NONE);
		new Label(composite_16, SWT.NONE);
		
		Label lblEmployeeDetail = new Label(composite_16, SWT.WRAP);
		lblEmployeeDetail.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
		lblEmployeeDetail.setText("Employee Commission\nDetail:");
		new Label(composite_16, SWT.NONE);
		
		Label lblStore = new Label(composite_16, SWT.NONE);
		lblStore.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblStore.setText("Store:");
		
		text_25 = new Text(composite_16, SWT.BORDER);
		text_25.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblManager = new Label(composite_16, SWT.NONE);
		lblManager.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblManager.setText("Manager:");
		
		text_26 = new Text(composite_16, SWT.BORDER);
		text_26.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblHoursWorked = new Label(composite_16, SWT.NONE);
		lblHoursWorked.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblHoursWorked.setText("Hours Worked:");
		
		text_27 = new Text(composite_16, SWT.BORDER);
		text_27.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblTotalTransactions_1 = new Label(composite_16, SWT.NONE);
		lblTotalTransactions_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTotalTransactions_1.setText("Total Transactions:");
		
		text_28 = new Text(composite_16, SWT.BORDER);
		text_28.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblTotalSales = new Label(composite_16, SWT.NONE);
		lblTotalSales.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTotalSales.setText("Total Sales:");
		
		text_29 = new Text(composite_16, SWT.BORDER);
		text_29.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblNewLabel_9 = new Label(composite_16, SWT.NONE);
		lblNewLabel_9.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_9.setText("Total Commission:");
		
		text_30 = new Text(composite_16, SWT.BORDER);
		text_30.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblCheck = new Label(composite_16, SWT.NONE);
		lblCheck.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblCheck.setText("Check #:");
		
		text_32 = new Text(composite_16, SWT.BORDER);
		text_32.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

	}
}
