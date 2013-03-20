/*package edu.byu.isys413.rtyler1;

import edu.byu.isys413.roytm.*;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Button;
import swing2swt.layout.BorderLayout;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import edu.byu.isys403.swt.manager.*;
import java.text.*;
import java.util.Calendar;
import java.util.Date;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ColumnLabelProvider;

import com.ibm.icu.text.DecimalFormat;

public class MainWindow {

	protected Shell shlMystuffMain;
	private Text skuInput;
	private Text serialNumber;
	private Text phoneNum;
	private Text firstName;
	private Text email;
	private Text address;
	private Text city;
	private Text subtotal;
	private Text taxTotal;
	private Text total;
	private Text lastName;
	private Text state;
	private Text zipcode;
	private Text updateDate;
	private Text transactionCount;
	private Text commPayDate;
	private Text totalCommPmtCount;
	private Text totalCommPmtAmt;
	private Text totalPmt;
	private Text totalTxn;
	private Text pmtLessTxn;
	private Text totalAmt;
	private Text totalItemCount;
	private Text avgComm;
	private Text empCommStore;
	private Text empCommManager;
	private Text empTotalTxn;
	private Text empTotalSales;
	private Text empTotalComm;
	private Text lastPmtDate;
	private Text dateTime;
	private Button btnNewButton;
	private Button btnLookup;
	private Button btnNewCustomer;
	private Button btnSaveCustomer;
	private Button btnFinalizeTransaction;
	private TabItem tbtmNewItem_2;
	private TabItem tbtmNewItem_3;
	private Button btnUpdate;
	private Button payCommissionsButton;
	private Button printStatementButton;
	private List updateHistoryList;
	private List employeeList;
	private List hitList;
	//Objects we need to have initialized
	private Computer computer;
	private Store store;
	private Employee employee;
	private Transaction txn;
	private Customer customer;
	private Checks check;
	private java.util.List<RevenueSource> revSrcList = 
			new java.util.ArrayList<RevenueSource>();
	//table
	private Table table;
	private TableViewer transactionTable;
	private TableViewerColumn productName;
	private TableViewerColumn productQuantity;
	private TableViewerColumn productPrice;

	*//**
	 * Launch the application.
	 * @param args
	 *//*
	public static void main(String[] args) {
		//create the database
		try {
			CreateDB.main(null);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			MainWindow window = new MainWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	*//**
	 * Open the window.
	 *//*
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlMystuffMain.open();
		shlMystuffMain.layout();
		//identify computer, set store
		try {
			identifyStore("08:4D:0F:02");
		} catch (DataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//login
		login();
		//initialize the transaction
		try {
			if (employee!=null) {
				initializeTransaction();
			}
		} catch (DataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (!shlMystuffMain.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	*//**
	 * Create contents of the window.
	 * @wbp.parser.entryPoint
	 *//*
	protected void createContents() {
		shlMystuffMain = new Shell();
		shlMystuffMain.setSize(796, 551);
		//center the window using WindowManager, courtesy of David Goodrich
		try {
			WindowManager.getInstance().centerWindow(shlMystuffMain);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//Main SALE WINDOW

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

		skuInput = new Text(composite, SWT.BORDER);
		fd_lblSku.right = new FormAttachment(skuInput, -24);
		fd_lblSku.top = new FormAttachment(skuInput, 3, SWT.TOP);
		FormData fd_skuInput = new FormData();
		fd_skuInput.right = new FormAttachment(100, -545);
		fd_skuInput.left = new FormAttachment(0, 89);
		skuInput.setLayoutData(fd_skuInput);

		Label lblNewLabel = new Label(composite, SWT.NONE);
		FormData fd_lblNewLabel = new FormData();
		fd_lblNewLabel.top = new FormAttachment(lblSku, 11);
		fd_lblNewLabel.left = new FormAttachment(lblSku, 0, SWT.LEFT);
		lblNewLabel.setLayoutData(fd_lblNewLabel);
		lblNewLabel.setText("Serial #:");

		serialNumber = new Text(composite, SWT.BORDER);
		FormData fd_serialNumber = new FormData();
		fd_serialNumber.right = new FormAttachment(skuInput, 0, SWT.RIGHT);
		fd_serialNumber.top = new FormAttachment(skuInput, 6);
		fd_serialNumber.left = new FormAttachment(skuInput, 0, SWT.LEFT);
		serialNumber.setLayoutData(fd_serialNumber);

		btnNewButton = new Button(composite, SWT.FLAT);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					addProduct();
				} catch (DataException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		FormData fd_btnNewButton = new FormData();
		fd_btnNewButton.top = new FormAttachment(serialNumber, 6);
		fd_btnNewButton.right = new FormAttachment(skuInput, 0, SWT.RIGHT);
		fd_btnNewButton.left = new FormAttachment(0, 89);
		btnNewButton.setLayoutData(fd_btnNewButton);
		btnNewButton.setText("Add Product");

		Composite composite_2 = new Composite(composite, SWT.BORDER);
		composite_2.setLayout(new BorderLayout(0, 0));
		FormData fd_composite_2 = new FormData();
		fd_composite_2.left = new FormAttachment(0, 36);
		fd_composite_2.bottom = new FormAttachment(100, -10);
		fd_composite_2.top = new FormAttachment(btnNewButton, 6);
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

		btnNewCustomer = new Button(composite_4, SWT.FLAT);
		btnNewCustomer.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				newCustomer();
			}
		});
		btnNewCustomer.setText("New Customer");

		btnSaveCustomer = new Button(composite_4, SWT.FLAT);
		btnSaveCustomer.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				saveCustomerInformation();
				txn.setCustomer(customer);
			}
		});
		btnSaveCustomer.setText("Save Customer");

		Composite composite_5 = new Composite(composite_2, SWT.NONE);
		composite_5.setLayoutData(BorderLayout.CENTER);
		composite_5.setLayout(new GridLayout(2, false));

		Label lblPhone = new Label(composite_5, SWT.NONE);
		lblPhone.setText("Phone:");

		phoneNum = new Text(composite_5, SWT.BORDER);
		phoneNum.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite_5, SWT.NONE);

		btnLookup = new Button(composite_5, SWT.FLAT);
		btnLookup.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					Person p = BusinessObjectDAO.getInstance().searchForBO("Person", new SearchCriteria("phone", phoneNum.getText()));
					if (p==null) {
						newCustomer();
					} else {
						customer = BusinessObjectDAO.getInstance().searchForBO("Customer", new SearchCriteria("id", p.getId()));
						populateCustomerInformation();
						txn.setCustomer(customer);
					}
				} catch (DataException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLookup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnLookup.setText("Lookup");

		Label lblName = new Label(composite_5, SWT.NONE);
		lblName.setText("First Name:");

		firstName = new Text(composite_5, SWT.BORDER);
		firstName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblNewLabel_1 = new Label(composite_5, SWT.NONE);
		lblNewLabel_1.setText("Last Name:");

		lastName = new Text(composite_5, SWT.BORDER);
		lastName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblEmail = new Label(composite_5, SWT.NONE);
		lblEmail.setText("Email:");

		email = new Text(composite_5, SWT.BORDER);
		email.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblAddress = new Label(composite_5, SWT.NONE);
		lblAddress.setText("Address:");

		address = new Text(composite_5, SWT.BORDER);
		address.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblMembershipNumber = new Label(composite_5, SWT.WRAP);
		lblMembershipNumber.setText("City:");

		city = new Text(composite_5, SWT.BORDER);
		city.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblStateZip = new Label(composite_5, SWT.NONE);
		lblStateZip.setText("State:");

		state = new Text(composite_5, SWT.BORDER);
		state.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblMembership = new Label(composite_5, SWT.NONE);
		lblMembership.setText("Zipcode:");

		zipcode = new Text(composite_5, SWT.BORDER);
		zipcode.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblSubtotal = new Label(composite, SWT.NONE);
		fd_composite_2.right = new FormAttachment(lblSubtotal, -200);
		FormData fd_lblSubtotal = new FormData();
		lblSubtotal.setLayoutData(fd_lblSubtotal);
		lblSubtotal.setText("Subtotal:");

		subtotal = new Text(composite, SWT.BORDER);
		fd_lblSubtotal.right = new FormAttachment(100, -293);
		FormData fd_subtotal = new FormData();
		fd_subtotal.top = new FormAttachment(0, 369);
		fd_subtotal.left = new FormAttachment(lblSubtotal, 6);
		fd_subtotal.right = new FormAttachment(100, -38);
		subtotal.setLayoutData(fd_subtotal);

		Label lblTax = new Label(composite, SWT.NONE);
		FormData fd_lblTax = new FormData();
		fd_lblTax.right = new FormAttachment(lblSubtotal, 0, SWT.RIGHT);
		lblTax.setLayoutData(fd_lblTax);
		lblTax.setText("Tax:");

		Label lblTotal = new Label(composite, SWT.NONE);
		fd_lblTax.bottom = new FormAttachment(lblTotal, -6);
		FormData fd_lblTotal = new FormData();
		fd_lblTotal.top = new FormAttachment(0, 422);
		fd_lblTotal.right = new FormAttachment(lblSubtotal, 0, SWT.RIGHT);
		lblTotal.setLayoutData(fd_lblTotal);
		lblTotal.setText("Total:");

		taxTotal = new Text(composite, SWT.BORDER);
		FormData fd_taxTotal = new FormData();
		fd_taxTotal.right = new FormAttachment(100, -38);
		fd_taxTotal.left = new FormAttachment(lblTax, 6);
		fd_taxTotal.top = new FormAttachment(subtotal, 6);
		taxTotal.setLayoutData(fd_taxTotal);

		total = new Text(composite, SWT.BORDER);
		FormData fd_total = new FormData();
		fd_total.top = new FormAttachment(lblTotal, -3, SWT.TOP);
		fd_total.left = new FormAttachment(subtotal, 0, SWT.LEFT);
		fd_total.right = new FormAttachment(100, -38);
		total.setLayoutData(fd_total);

		btnFinalizeTransaction = new Button(composite, SWT.BORDER | SWT.FLAT);
		btnFinalizeTransaction.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					finalizeTransaction();
				} catch (DataException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		FormData fd_btnFinalizeTransaction = new FormData();
		fd_btnFinalizeTransaction.left = new FormAttachment(composite_2, 258);
		fd_btnFinalizeTransaction.right = new FormAttachment(100, -38);
		fd_btnFinalizeTransaction.bottom = new FormAttachment(composite_2, 0, SWT.BOTTOM);
		btnFinalizeTransaction.setLayoutData(fd_btnFinalizeTransaction);
		btnFinalizeTransaction.setText("Finalize Transaction");

		Label lblProductLookup = new Label(composite, SWT.NONE);
		fd_skuInput.top = new FormAttachment(lblProductLookup, 6);
		lblProductLookup.setFont(SWTResourceManager.getFont("Lucida Grande", 15, SWT.NORMAL));
		FormData fd_lblProductLookup = new FormData();
		fd_lblProductLookup.left = new FormAttachment(0, 36);
		lblProductLookup.setLayoutData(fd_lblProductLookup);
		lblProductLookup.setText("Product Lookup");

		Button signOutButton = new Button(composite, SWT.FLAT);
		signOutButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					WindowManager.getInstance().clearForms(shlMystuffMain);
				} catch (edu.byu.isys403.swt.manager.DataException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				clearTable();
				login();
				try {
					initializeTransaction();
				} catch (DataException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dateTime.setText(getCurrentTime());
			}
		});
		FormData fd_signOutButton = new FormData();
		fd_signOutButton.top = new FormAttachment(0, 10);
		fd_signOutButton.right = new FormAttachment(100, -10);
		signOutButton.setLayoutData(fd_signOutButton);
		signOutButton.setText("Sign In/Out");

		dateTime = new Text(composite, SWT.BORDER);
		FormData fd_dateTime = new FormData();
		fd_dateTime.bottom = new FormAttachment(100, -465);
		fd_dateTime.right = new FormAttachment(lblProductLookup, 0, SWT.RIGHT);
		fd_dateTime.left = new FormAttachment(0, 10);
		dateTime.setLayoutData(fd_dateTime);
		dateTime.setText(getCurrentTime());
		dateTime.setEditable(false);
		fd_lblProductLookup.top = new FormAttachment(0, 37);

		transactionTable = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table = transactionTable.getTable();
		fd_signOutButton.bottom = new FormAttachment(table, -30);
		fd_lblSubtotal.top = new FormAttachment(0, 372);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		FormData fd_transactionTable = new FormData();
		fd_transactionTable.bottom = new FormAttachment(100, -128);
		fd_transactionTable.top = new FormAttachment(skuInput, 0, SWT.TOP);
		fd_transactionTable.right = new FormAttachment(subtotal, 0, SWT.RIGHT);
		fd_transactionTable.left = new FormAttachment(skuInput, 6);
		table.setLayoutData(fd_transactionTable);

		productName = new TableViewerColumn(transactionTable, SWT.NONE);
		TableColumn tblclmnProductName = productName.getColumn();
		tblclmnProductName.setWidth(296);
		tblclmnProductName.setText("Product Name");

		productQuantity = new TableViewerColumn(transactionTable, SWT.NONE);
		TableColumn tblclmnQuantity = productQuantity.getColumn();
		tblclmnQuantity.setWidth(100);
		tblclmnQuantity.setText("Quantity");

		productPrice = new TableViewerColumn(transactionTable, SWT.NONE);
		TableColumn tblclmnPrice = productPrice.getColumn();
		tblclmnPrice.setWidth(98);
		tblclmnPrice.setText("Price");

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//UPDATE GENERAL LEDGER WINDOW

		tbtmNewItem_2 = new TabItem(tabFolder, SWT.NONE);
		tbtmNewItem_2.setText("Update General Ledger");

		Composite composite_6 = new Composite(tabFolder, SWT.NONE);
		tbtmNewItem_2.setControl(composite_6);
		composite_6.setLayout(new BorderLayout(0, 0));

		Composite composite_7 = new Composite(composite_6, SWT.NONE);
		composite_7.setLayoutData(BorderLayout.WEST);
		composite_7.setLayout(new GridLayout(1, false));

		btnUpdate = new Button(composite_7, SWT.FLAT);
		btnUpdate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					UpdateGL update = updateGeneralLedger(new Date());
					//update the information in the window
					DateFormat dF = new SimpleDateFormat("yyyy/MM/dd");
					updateHistoryList.add(dF.format(update.getUpdatedate()));
					updateHistoryList.setData(dF.format(update.getUpdatedate()), update);
					updateHistoryList.select(updateHistoryList.indexOf(dF.format(update.getUpdatedate())));
					updateDate.setText(dF.format(update.getUpdatedate()));
					transactionCount.setText(String.valueOf(update.getTransactioncount()));
				} catch (DataException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnUpdate.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnUpdate.setText("Update Now");

		Label label_1 = new Label(composite_7, SWT.NONE);
		label_1.setFont(SWTResourceManager.getFont("Lucida Grande", 15, SWT.NORMAL));
		label_1.setText("View Update History:");

		updateHistoryList = new List(composite_7, SWT.BORDER);
		updateHistoryList.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				UpdateGL update = (UpdateGL) updateHistoryList.getData(updateHistoryList.getSelection()[0]);
				DateFormat dF = new SimpleDateFormat("yyyy/MM/dd");
				updateDate.setText(dF.format(update.getUpdatedate()));
				transactionCount.setText(String.valueOf(update.getTransactioncount()));
			}
		});
		GridData gd_updateHistoryList = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_updateHistoryList.heightHint = 220;
		gd_updateHistoryList.widthHint = 159;
		updateHistoryList.setLayoutData(gd_updateHistoryList);

		Composite composite_8 = new Composite(composite_6, SWT.NONE);
		composite_8.setLayoutData(BorderLayout.NORTH);
		composite_8.setLayout(new FillLayout(SWT.VERTICAL));

		Label lblUpdateGL = new Label(composite_8,SWT.CENTER);
		lblUpdateGL.setFont(SWTResourceManager.getFont("Lucida Grande", 20, SWT.NORMAL));
		lblUpdateGL.setText("Update General Ledger");

		Label label_2 = new Label(composite_8, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_2.setEnabled(false);

		Composite composite_9 = new Composite(composite_6, SWT.NONE);
		composite_9.setLayoutData(BorderLayout.CENTER);
		composite_9.setLayout(new GridLayout(2, false));

		Label lblNewLabel_2 = new Label(composite_9, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("Lucida Grande", 15, SWT.NORMAL));
		lblNewLabel_2.setText("Update Details:");
		new Label(composite_9, SWT.NONE);

		Label label_3 = new Label(composite_9, SWT.NONE);
		new Label(composite_9, SWT.NONE);
		label_3.setEnabled(false);

		Label lblLastUpdatePerformed = new Label(composite_9, SWT.NONE);
		lblLastUpdatePerformed.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblLastUpdatePerformed.setText("Date Performed:");

		updateDate = new Text(composite_9, SWT.BORDER);
		GridData gd_updateDate = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_updateDate.widthHint = 147;
		updateDate.setLayoutData(gd_updateDate);
		updateDate.setEditable(false);

		Label lblTransactionsUpdatedTo = new Label(composite_9, SWT.WRAP);
		lblTransactionsUpdatedTo.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTransactionsUpdatedTo.setText("Number of Transactions:");

		transactionCount = new Text(composite_9, SWT.BORDER);
		transactionCount.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		transactionCount.setEditable(false);

		//insert test updates into the update list
		java.util.List<UpdateGL> updates = null;
		try {
			updates = BusinessObjectDAO.getInstance().searchForAll("UpdateGL");
		} catch (DataException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(UpdateGL update:updates) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			updateHistoryList.add(dateFormat.format(update.getUpdatedate()));
			updateHistoryList.setData(dateFormat.format(update.getUpdatedate()), update);
		}

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//PAY COMMISSIONS WINDOW

		tbtmNewItem_3 = new TabItem(tabFolder, SWT.NONE);
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
		label_4.setEnabled(false);

		Composite composite_12 = new Composite(composite_10, SWT.NONE);
		composite_12.setLayoutData(BorderLayout.WEST);
		composite_12.setLayout(new GridLayout(1, false));

		Label label_5 = new Label(composite_12, SWT.NONE);
		label_5.setText("Last Payment Date:");

		lastPmtDate = new Text(composite_12, SWT.BORDER);
		lastPmtDate.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		lastPmtDate.setEditable(false);

		payCommissionsButton = new Button(composite_12, SWT.FLAT);
		payCommissionsButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					payCommissions();
				} catch (DataException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				//fill the employee list
				try {
					fillEmployeeList();
				} catch (DataException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		payCommissionsButton.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
		GridData gd_payCommissionsButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_payCommissionsButton.widthHint = 115;
		payCommissionsButton.setLayoutData(gd_payCommissionsButton);

		payCommissionsButton.setText("Pay Commissions");

		printStatementButton = new Button(composite_12, SWT.FLAT);
		printStatementButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		printStatementButton.setText("Print Statements");

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

		totalPmt = new Text(composite_13, SWT.BORDER);
		GridData gd_totalPmt = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_totalPmt.widthHint = 91;
		totalPmt.setLayoutData(gd_totalPmt);
		totalPmt.setEditable(false);

		Label lblTotalTransactions = new Label(composite_13, SWT.NONE);
		lblTotalTransactions.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTotalTransactions.setText("Total Transactions:");

		totalTxn = new Text(composite_13, SWT.BORDER);
		totalTxn.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		totalTxn.setEditable(false);

		Label lblNewLabel_4 = new Label(composite_13, SWT.NONE);
		lblNewLabel_4.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_4.setText("Difference:");

		pmtLessTxn = new Text(composite_13, SWT.BORDER);
		pmtLessTxn.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite_13, SWT.NONE);
		new Label(composite_13, SWT.NONE);
		pmtLessTxn.setEditable(false);

		Label lblTotalAmount_1 = new Label(composite_13, SWT.NONE);
		lblTotalAmount_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTotalAmount_1.setText("Total Amount:");

		totalAmt = new Text(composite_13, SWT.BORDER);
		totalAmt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		totalAmt.setEditable(false);

		Label lblTotalOfItems = new Label(composite_13, SWT.NONE);
		lblTotalOfItems.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTotalOfItems.setText("Total of Items Sold:");

		totalItemCount = new Text(composite_13, SWT.BORDER);
		totalItemCount.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		totalItemCount.setEditable(false);

		Label lblNewLabel_8 = new Label(composite_13, SWT.NONE);
		lblNewLabel_8.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_8.setText("Avg. Commission (%):");

		avgComm = new Text(composite_13, SWT.BORDER);
		avgComm.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		avgComm.setEditable(false);

		new Label(composite_13, SWT.NONE);
		new Label(composite_13, SWT.NONE);

		Label lblCommissionsOver = new Label(composite_13, SWT.WRAP);
		lblCommissionsOver.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
		lblCommissionsOver.setText("Commissions Over \n40% of Total Sales:");

		hitList = new List(composite_13, SWT.BORDER);
		GridData gd_hitList = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_hitList.heightHint = 170;
		gd_hitList.widthHint = 59;
		hitList.setLayoutData(gd_hitList);

		Composite composite_14 = new Composite(composite_10, SWT.NONE);
		composite_14.setLayoutData(BorderLayout.CENTER);
		composite_14.setLayout(new BorderLayout(0, 0));

		Composite composite_15 = new Composite(composite_14, SWT.NONE);
		composite_15.setLayoutData(BorderLayout.WEST);
		composite_15.setLayout(new GridLayout(1, false));

		Label lblNewLabel_6 = new Label(composite_15, SWT.NONE);
		lblNewLabel_6.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.ITALIC));
		lblNewLabel_6.setText("Select Employee:");

		employeeList = new List(composite_15, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		employeeList.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (employeeList.getSelection()[0].equals("All Employees")) {
					empCommStore.setText("");
					empCommManager.setText("");
					empTotalTxn.setText("");
					empTotalSales.setText("");
					empTotalComm.setText("");
				} else {
					Employee employee = (Employee)employeeList.getData(employeeList.getSelection()[0]);
					try {
						fillEmployeeCommDetails(employee);
					} catch (DataException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		GridData gd_employeeList = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_employeeList.heightHint = 355;
		gd_employeeList.widthHint = 145;
		employeeList.setLayoutData(gd_employeeList);
		
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

		commPayDate = new Text(composite_16, SWT.BORDER);
		GridData gd_commPayDate = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_commPayDate.widthHint = 75;
		commPayDate.setLayoutData(gd_commPayDate);
		commPayDate.setEditable(false);

		Label lblTotalPayments = new Label(composite_16, SWT.NONE);
		lblTotalPayments.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTotalPayments.setText("Total Payments Made:");

		totalCommPmtCount = new Text(composite_16, SWT.BORDER);
		GridData gd_totalCommPmtCount = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_totalCommPmtCount.widthHint = 106;
		totalCommPmtCount.setLayoutData(gd_totalCommPmtCount);
		totalCommPmtCount.setEditable(false);

		Label lblTotalAmount = new Label(composite_16, SWT.NONE);
		lblTotalAmount.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTotalAmount.setText("Total Amount:");

		totalCommPmtAmt = new Text(composite_16, SWT.BORDER);
		GridData gd_totalCommPmtAmt = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_totalCommPmtAmt.widthHint = 105;
		totalCommPmtAmt.setLayoutData(gd_totalCommPmtAmt);
		new Label(composite_16, SWT.NONE);
		new Label(composite_16, SWT.NONE);
		totalCommPmtAmt.setEditable(false);

		Label lblEmployeeDetail = new Label(composite_16, SWT.WRAP);
		lblEmployeeDetail.setFont(SWTResourceManager.getFont("Lucida Grande", 11, SWT.BOLD));
		lblEmployeeDetail.setText("Employee Commission\nDetail:");
		new Label(composite_16, SWT.NONE);

		Label lblStore = new Label(composite_16, SWT.NONE);
		lblStore.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblStore.setText("Store:");

		empCommStore = new Text(composite_16, SWT.BORDER);
		empCommStore.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		empCommStore.setEditable(false);

		Label lblManager = new Label(composite_16, SWT.NONE);
		lblManager.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblManager.setText("Manager:");

		empCommManager = new Text(composite_16, SWT.BORDER);
		empCommManager.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		empCommManager.setEditable(false);

		Label lblTotalTransactions_1 = new Label(composite_16, SWT.NONE);
		lblTotalTransactions_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTotalTransactions_1.setText("Total Transactions:");

		empTotalTxn = new Text(composite_16, SWT.BORDER);
		empTotalTxn.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		empTotalTxn.setEditable(false);

		Label lblTotalSales = new Label(composite_16, SWT.NONE);
		lblTotalSales.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTotalSales.setText("Total Sales:");

		empTotalSales = new Text(composite_16, SWT.BORDER);
		empTotalSales.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		empTotalSales.setEditable(false);

		Label lblNewLabel_9 = new Label(composite_16, SWT.NONE);
		lblNewLabel_9.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_9.setText("Total Commission:");

		empTotalComm = new Text(composite_16, SWT.BORDER);
		empTotalComm.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		empTotalComm.setEditable(false);

	}

	////////////////////////////////////////////////////////////////////////////////////////////////
	///////My Methods
	*//**
	 * identify the store by the Media Access Control Address
	 * @param macaddress
	 *//*
	private void identifyStore(String MACAddress) throws DataException {
		computer = BusinessObjectDAO.getInstance().searchForBO("Computer", new SearchCriteria("macaddress", MACAddress));
		store = BusinessObjectDAO.getInstance().searchForBO("Store", new SearchCriteria("subnetid", computer.getSubnet()));
	}

	*//**
	 * disable all fields in main window
	 *//*
	private void disableMainWindow() {
		//buttons
		btnNewButton.setEnabled(false);
		btnLookup.setEnabled(false);
		btnNewCustomer.setEnabled(false);
		btnSaveCustomer.setEnabled(false);
		btnFinalizeTransaction.setEnabled(false);
		btnUpdate.setEnabled(false);
		payCommissionsButton.setEnabled(false);
		printStatementButton.setEnabled(false);
		//text fields
		skuInput.setEnabled(false);
		serialNumber.setEnabled(false);
		table.setEnabled(false);
		phoneNum.setEnabled(false);
		firstName.setEnabled(false);
		email.setEnabled(false);
		address.setEnabled(false);
		city.setEnabled(false);
		subtotal.setEnabled(false);
		taxTotal.setEnabled(false);
		total.setEnabled(false);
		lastName.setEnabled(false);
		state.setEnabled(false);
		zipcode.setEnabled(false);
	}//disableMainWindow

	*//**
	 * enable all fields in main window
	 *//*
	private void enableMainWindow() {
		//buttons
		btnNewButton.setEnabled(true);
		btnLookup.setEnabled(true);
		btnNewCustomer.setEnabled(true);
		btnSaveCustomer.setEnabled(true);
		btnFinalizeTransaction.setEnabled(true);
		btnUpdate.setEnabled(true);
		payCommissionsButton.setEnabled(true);
		printStatementButton.setEnabled(true);
		//text fields
		skuInput.setEnabled(true);
		serialNumber.setEnabled(true);
		table.setEnabled(true);
		phoneNum.setEnabled(true);
		firstName.setEnabled(true);
		email.setEnabled(true);
		address.setEnabled(true);
		city.setEnabled(true);
		subtotal.setEnabled(true);
		taxTotal.setEnabled(true);
		total.setEnabled(true);
		lastName.setEnabled(true);
		state.setEnabled(true);
		zipcode.setEnabled(true);		
	}//enableMainWindow

	*//**
	 * gets the current date and time
	 * thanks to Yong Mook Kim (aka mkyong)
	 * @return
	 *//*
	private String getCurrentTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
		return dateFormat.format(cal.getTime());
	}

	*//**
	 * login
	 *//*
	private void login() {
		//now open the employee login window and login
		disableMainWindow();
		EmployeeLogin empLogin = new EmployeeLogin(shlMystuffMain, SWT.APPLICATION_MODAL);
		empLogin.open();
		if(empLogin.getAuthentication()) {
			employee = empLogin.getEmployee();
			System.out.println("This is the authenticated employee: " + employee.getFirstName() + " " + employee.getLastName());
			enableMainWindow();
		} else {
			employee = null;
		}

	}

	*//**
	 * set up a new customer
	 *//*
	private void newCustomer() {
		//first, clear fields
		firstName.setText("New Customer");
		email.setText("");
		address.setText("");
		city.setText("");
		lastName.setText("");
		state.setText("");
		zipcode.setText("");
		//then, create a new customer object and set customer
		try {
			customer = BusinessObjectDAO.getInstance().create("Customer");
		} catch (DataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//newCustomer

	*//**
	 * save the customer's information and customer
	 *//*
	private void saveCustomerInformation() {
		customer.setFirstName(firstName.getText());
		customer.setLastName(lastName.getText());
		customer.setPhone(phoneNum.getText());
		customer.setEmail(email.getText());
		customer.setAddress(address.getText());
		customer.setCity(city.getText());
		customer.setState(state.getText());
		customer.setZipcode(zipcode.getText());
		try {
			customer.save();
		} catch (DataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	*//**
	 * populateCustomerInformation
	 *//*
	private void populateCustomerInformation() {
		firstName.setText(customer.getFirstName());
		lastName.setText(customer.getLastName());
		email.setText(customer.getEmail());
		address.setText(customer.getAddress());
		city.setText(customer.getCity());
		state.setText(customer.getState());
		zipcode.setText(customer.getZipcode());
	}//populateCustomerInformation

	*//**
	 * initialize the transaction
	 *//*
	private void initializeTransaction() throws DataException{
		this.txn = BusinessObjectDAO.getInstance().create("Transaction");
		txn.setEmployee(employee);
		txn.setStore(store);
		Commission commission = BusinessObjectDAO.getInstance().create("Commission");
		commission.setEmp(employee);
		commission.setTxnid(txn.getId());
		txn.setCommission(commission);
	}

	*//**
	 * add a product
	 * @throws DataException 
	 *//*
	private void addProduct() throws DataException {
		Sale s = BusinessObjectDAO.getInstance().create("Sale");
		s.setRevsrctype("sale");
		s.setTransaction(txn);
		s.setQuantity(1);
		if (serialNumber.getText()==null || serialNumber.getText().equals("")) {
			ConceptualProduct cP = BusinessObjectDAO.getInstance().searchForBO("ConceptualProduct", 
					new SearchCriteria("sku", skuInput.getText()));
			Product p = BusinessObjectDAO.getInstance().searchForBO("Product", new SearchCriteria("id", cP.getId()));
			cP.setPrice(p.getPrice());
			s.setProduct(cP);
		} else {
			PhysicalProduct physP = BusinessObjectDAO.getInstance().searchForBO("PhysicalProduct", 
					new SearchCriteria("serialnumber", serialNumber.getText()));
			Product p = BusinessObjectDAO.getInstance().searchForBO("Product", new SearchCriteria("id", physP.getId()));
			ConceptualProduct cP = BusinessObjectDAO.getInstance().searchForBO("ConceptualProduct", new SearchCriteria("sku", skuInput.getText()));
			physP.setConceptualProduct(cP);
			physP.setPrice(p.getPrice());
			s.setProduct(physP);
		}
		//add to the transaction's revenuesource list
		revSrcList.add(s);
		//display the product's information 
		fillProductInformation();
		calculateCommission(s);
		updateTotals(s);
	}//addProduct

	*//**
	 * fills the product's information in the table
	 * @throws DataException 
	 *//*
	private void fillProductInformation() throws DataException {
		//column label provider for productName column
		productName.setLabelProvider(new ColumnLabelProvider() {
			public String getText(Object element) {
				Sale s = (Sale) element;
				return s.getProduct().getProductName();
			}
		});
		//column label provider for quantity
		productQuantity.setLabelProvider(new ColumnLabelProvider () {
			public String getText(Object element) {
				Sale s = (Sale) element;
				return String.valueOf(s.getQuantity());
			}
		});
		//column label provider for price
		productPrice.setLabelProvider(new ColumnLabelProvider() {
			public String getText(Object element) {
				Sale s = (Sale) element;
				DecimalFormat dFormat = new DecimalFormat("0.00");
				double price = s.getProduct().getPrice();
				price/=100;
				return String.valueOf("$" + (dFormat.format(price)));
			}
		});
		//now set the content provider for the table (so it knows where to get the information
		transactionTable.setContentProvider(new ArrayContentProvider());
		transactionTable.setInput(revSrcList);		
	}

	*//**
	 * remove all items from the transaction table
	 *//*
	public void clearTable() {
		transactionTable.getTable().removeAll();
	}

	*//**
	 * calculates/updates the commission object
	 * @throws DataException 
	 *//*
	private void calculateCommission(Sale s) throws DataException {
		double rate = s.getProduct().getCommissionrate();
		Commission c = txn.getCommission();
		c.setAmount((int) (txn.getCommission().getAmount() + (s.getProduct().getPrice()*rate)));
	}

	*//**
	 * updates the transaction totals
	 * @throws DataException 
	 *//*
	private void updateTotals(Sale s) throws DataException {
		//subtotal
		txn.setSubtotal(txn.getSubtotal() + (s.getProduct().getPrice()));
		DecimalFormat dFormat = new DecimalFormat("0.00");
		double sbttl = txn.getSubtotal()/100;
		subtotal.setText("$" + dFormat.format(sbttl));
		//tax total
		txn.setTax((int) (txn.getTax() + (txn.getSubtotal()*txn.getStore().getSalestaxrate())));
		double tax = txn.getTax()/100;
		taxTotal.setText("$" + dFormat.format(tax));
		//total
		txn.setTotal(txn.getSubtotal() + txn.getTax());
		total.setText("$" + dFormat.format((txn.getSubtotal()/100) + (txn.getTax()/100)));
	}

	*//**
	 * finalize the transaction
	 * @throws DataException 
	 *//*
	private void finalizeTransaction() throws DataException {
		txn.setTxndate(new Date());
		txn.getCommission().setCommdate(new Date());
		txn.getCommission().setPaid(false);
		//Process the customer's payment
		Payment payment = BusinessObjectDAO.getInstance().create("Payment");
		payment.setPmttype("cash");
		payment.setAmount(txn.getTotal());
		txn.setPayment(payment);
		//Create journal entry with corresponding debits and credits
		JournalEntry jE = BusinessObjectDAO.getInstance().create("JournalEntry");
		jE.setJeDate(txn.getTxndate());
		//cash
		DebitCredit cash = BusinessObjectDAO.getInstance().create("DebitCredit");
		cash.setJournalEntry(jE);
		cash.setDrcrtype(TransactionType.DEBIT.toString());
		cash.setGlacct("cash");
		cash.setAmount(txn.getTotal());
		cash.save();
		jE.getDebitCredits().add(cash);
		//salesRevenue
		DebitCredit salesRev = BusinessObjectDAO.getInstance().create("DebitCredit");
		salesRev.setJournalEntry(jE);
		salesRev.setDrcrtype(TransactionType.CREDIT.toString());
		salesRev.setGlacct("salesrevenue");
		salesRev.setAmount(txn.getSubtotal());
		salesRev.save();
		jE.getDebitCredits().add(salesRev);
		//taxpayable
		DebitCredit taxPay = BusinessObjectDAO.getInstance().create("DebitCredit");
		taxPay.setJournalEntry(jE);
		taxPay.setDrcrtype(TransactionType.CREDIT.toString());
		taxPay.setGlacct("taxpayable");
		taxPay.setAmount(txn.getTax());
		taxPay.save();
		jE.getDebitCredits().add(taxPay);
		//commissionexpense
		DebitCredit commExp = BusinessObjectDAO.getInstance().create("DebitCredit");
		commExp.setJournalEntry(jE);
		commExp.setDrcrtype(TransactionType.DEBIT.toString());
		commExp.setGlacct("commissionexpense");
		commExp.setAmount(txn.getCommission().getAmount());
		commExp.save();
		jE.getDebitCredits().add(commExp);
		//commissionspayable
		DebitCredit commPay = BusinessObjectDAO.getInstance().create("DebitCredit");
		commPay.setJournalEntry(jE);
		commPay.setDrcrtype(TransactionType.CREDIT.toString());
		commPay.setGlacct("commissionspayable");
		commPay.setAmount(txn.getCommission().getAmount());
		commPay.save();
		jE.getDebitCredits().add(commPay);

		Go through transaction and save to the database the following:
		 * JournalEntry
		 * Commission
		 * Payment
		 * Revenue Sources (iterate through and save each)
		 * 
		 * Also, be sure to update the products' quantity
		 
		txn.setJournalEntry(jE);
		jE.save();
		txn.getCommission().save();
		txn.getPayment().save();
		for (RevenueSource revSrc:txn.getRevsrclist()) {
			//update quantities

			//save
			revSrc.save();
		}
		//Save the transaction
		txn.save();
		int size = revSrcList.size();
		for(int i=0;i<size;i++) {
			revSrcList.remove(i);
			size--;
		}

		//this is a test method!
		testTransaction(txn.getId());

		//initialize the transaction
		initializeTransaction();
		try {
			WindowManager.getInstance().clearForms(shlMystuffMain);
			dateTime.setText(getCurrentTime());
		} catch (edu.byu.isys403.swt.manager.DataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clearTable();
	}//finalizeTransaction

	*//**
	 * tests the transaction
	 * @throws DataException 
	 *//*
	public void testTransaction(String txnId) throws DataException {
		//TEST
		Transaction t = BusinessObjectDAO.getInstance().read(txnId);
		System.out.println("Transaction: " + t.getId());
		System.out.println("Date: " + t.getTxndate());
		System.out.println("\tSubtotal: " + t.getSubtotal());
		System.out.println("\tTax: " + t.getTax());
		System.out.println("\tTotal: " + t.getTotal());
		//get employee, store, and customer information
		System.out.println("Store: " + t.getStore().getLocation());
		System.out.println("Employee: " + t.getEmployee().getFirstName() + " " + t.getEmployee().getLastName());
		Customer c = t.getCustomer();
		System.out.println("Customer: " + c.getFirstName() + " " + c.getLastName());
		//get product information
		java.util.List<RevenueSource> revsrcList = t.getRevsrclist();
		for (int i=0; i<revsrcList.size();i++) {
			RevenueSource r = revsrcList.get(i);
			System.out.println("Product " + (i+1) + ": " + r.getProduct().getProductName());
		}
		//get journal entry
		JournalEntry jE = t.getJournalEntry();
		System.out.println("Test for journalEntry: " + jE.getId());
		for (DebitCredit drCrTest:jE.getDebitCredits()) {
			System.out.println("Type: " + drCrTest.getDrcrtype() + "| Account: " + drCrTest.getGlacct()
					+ "| Amount: " + drCrTest.getAmount());
		}
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////
	//Methods to update the general ledger
	*//**
	 * updates the general ledger
	 * @param date
	 * @throws DataException 
	 *//*
	public UpdateGL updateGeneralLedger(Date date) throws DataException {
		//Create map of general ledger accounts needed: cash, salesrevenue, taxpayable, commissionexpense, commissionspayable
		System.out.println("\nBegin updating general ledger");
		java.util.Map<String, GeneralLedger> gLMap = new java.util.TreeMap<String, GeneralLedger>();
		java.util.List<GeneralLedger> gLList = BusinessObjectDAO.getInstance().searchForList("GeneralLedger", 
				new SearchCriteria("acctname","cash"));
		gLList.add((GeneralLedger) BusinessObjectDAO.getInstance().searchForBO("GeneralLedger", new SearchCriteria("acctname","salesrevenue")));
		gLList.add((GeneralLedger) BusinessObjectDAO.getInstance().searchForBO("GeneralLedger", new SearchCriteria("acctname","taxpayable")));
		gLList.add((GeneralLedger) BusinessObjectDAO.getInstance().searchForBO("GeneralLedger", new SearchCriteria("acctname","commissionexpense")));
		gLList.add((GeneralLedger) BusinessObjectDAO.getInstance().searchForBO("GeneralLedger", new SearchCriteria("acctname","commissionspayable")));
		System.out.println(gLList.size());
		for(GeneralLedger gL:gLList) {
			gLMap.put(gL.getAcctname(), gL);
		}
		//test
		for(GeneralLedger gL:gLMap.values()) {
			System.out.println("GeneralLedger account: " + gL.getAcctname());
		}
		//test
		System.out.println("\nTransactions:");
		java.util.List<Transaction> testList = BusinessObjectDAO.getInstance().searchForAll("Transaction");
		for(Transaction t:testList) {
			System.out.println(t.getTxndate());
		}
		//Create a list of all of the transactions for the same day as the parameter, date
		DateFormat dF = new SimpleDateFormat("yyyy/MM/dd");
		java.util.List<Transaction> transactions = BusinessObjectDAO.getInstance().searchForAll("Transaction");
		java.util.List<Transaction> txnList = new java.util.ArrayList<Transaction>();
		for(Transaction t:transactions) {
			if (dF.format(t.getTxndate()).equals(dF.format(date))) {
				txnList.add(t);
			} else {
				continue;
			}
		}
		//test
		System.out.println("\nTransactions for the day: ");
		for (Transaction txn:txnList) {
			System.out.println(txn.getId());
		}
		//iterate through each transaction, getting the journalentry, then the debits and credits, and updating the general ledger accounts.
		//create a new update object
		UpdateGL update = BusinessObjectDAO.getInstance().create("UpdateGL");
		update.setUpdatedate(date);
		update.setTransactioncount(txnList.size());
		//loop through each transaction
		for (Transaction txn:txnList) {
			System.out.println(txn.getId());
			JournalEntry jE = txn.getJournalEntry();
			System.out.println("\nJournalEntry: " + jE.getId());
			//go through journal entry and reference debits and credits.  Perform update, and update the UpdateGL object
			if(jE.getUpdatenum()!=null) {
				java.util.List<DebitCredit> dcList = BusinessObjectDAO.getInstance().searchForList("DebitCredit", new SearchCriteria("jeid",jE.getId()));
				for (DebitCredit dc:dcList) {
					//add to the drcrlist
					update.getDrcrList().add(dc);
					//get the account
					GeneralLedger gL = gLMap.get(dc.getGlacct());
					//check to see if it's a debit or a credit
					if(dc.getDrcrtype().equals(TransactionType.DEBIT.toString())) {
						//determine the account type being referenced
						if(gL.getAccttype().equals(AccountType.ASSET) || gL.getAccttype().equals(AccountType.EXPENSE)) { //if it is an ASSET or EXPENSE
							gL.setBalance(gL.getBalance() + dc.getAmount());
						} else { //if it is a LIABILITY or REVENUE or EQUITY
							gL.setBalance(gL.getBalance() - dc.getAmount());
						}//if
					} else {//if it is a CREDIT
						//determine the account type being referenced
						if(gL.getAccttype().equals(AccountType.ASSET) || gL.getAccttype().equals(AccountType.EXPENSE)) { //if it is an ASSET or EXPENSE
							gL.setBalance(gL.getBalance() - dc.getAmount());
						} else { //if it is a LIABILITY or REVENUE or EQUITY
							gL.setBalance(gL.getBalance() + dc.getAmount());
						}//if
					}//if
				}//for1
				//save the general ledger objects to the database
				for (GeneralLedger gL:gLMap.values()) {
					gL.save();
				}
				//set the updatenum reference in journal entry and save the update
				jE.setUpdatenum(update.getId());
				update.save();
				System.out.println("Update performed and saved");
			} 
		}
		return update;
	}//updateGeneralLedger

	///////////////////////////////////////////////////////////////////////////////////////
	//Pay Commissions
	*//**
	 * pay commissions
	 * @throws DataException 
	 *//*
	private void payCommissions() throws DataException {
		java.util.List<Commission> commissions = BusinessObjectDAO.getInstance().searchForList("Commission", new SearchCriteria("paid", false));
		java.util.List<Employee> employees = BusinessObjectDAO.getInstance().searchForAll("Employee");
		java.util.List<Checks> checks = new java.util.LinkedList<Checks>();
		Date date = new Date();
		//create a list of transactions
		java.util.List<Transaction> tList = new java.util.ArrayList<Transaction>();
		for (Commission c: commissions) {
			tList.add((Transaction)BusinessObjectDAO.getInstance().searchForBO("Transaction", new SearchCriteria("id", c.getTxnid())));
		}
		//create employee checks
		for (Employee e:employees) {
			check = BusinessObjectDAO.getInstance().create("Checks");
			check.setEmp(e);
			check.setCheckdate(date);
			check.setAmount(0);
			for (Commission c: commissions) {
				if (c.getEmpid().equals(e.getId())) {
					//add the commission amount to their check
					check.setAmount(check.getAmount() + c.getAmount());
					System.out.println("Amount: " + check.getAmount());
					//mark it as paid and save it to the db
					c.setPaid(true);
					c.save();
				} else {
					continue;
				}
			}
			checks.add(check);
			check.save();
		}//for
		//create the general ledger object map
		java.util.Map<String, GeneralLedger> gLMap = new java.util.TreeMap<String, GeneralLedger>();
		java.util.List<GeneralLedger> glList = BusinessObjectDAO.getInstance().searchForList("GeneralLedger", 
				new SearchCriteria("acctname", "cash"));
		glList.add((GeneralLedger)BusinessObjectDAO.getInstance().searchForBO("GeneralLedger", 
				new SearchCriteria("acctname", "commissionspayable")));
		for(GeneralLedger gL:glList) {
			gLMap.put(gL.getAcctname(), gL);
		}
		//then, take each check and perform necessary updates/processing:
		for (Checks check:checks) {
			//create journal entry
			JournalEntry jE = BusinessObjectDAO.getInstance().create("JournalEntry");
			//create debits and credits, save them to jE
			//	commissionspayable
			DebitCredit drCommPay = BusinessObjectDAO.getInstance().create("DebitCredit");
			drCommPay.setAmount(check.getAmount());
			drCommPay.setDrcrtype(TransactionType.DEBIT.toString());
			drCommPay.setGlacct("commissionspayable");
			drCommPay.setJournalEntry(jE);
			drCommPay.save();
			//		update general ledger for commissionspayable
			gLMap.get(drCommPay.getGlacct()).setBalance(gLMap.get(drCommPay.getGlacct()).getBalance() + drCommPay.getAmount());
			//	cash
			DebitCredit crCash = BusinessObjectDAO.getInstance().create("DebitCredit");
			crCash.setAmount(check.getAmount());
			crCash.setDrcrtype(TransactionType.CREDIT.toString());
			crCash.setGlacct("cash");
			crCash.setJournalEntry(jE);
			crCash.save();
			//		update general ledger for cash
			gLMap.get(crCash.getGlacct()).setBalance(gLMap.get(crCash.getGlacct()).getBalance() + crCash.getAmount());
			
			//save the journal entry
			jE.save();
		}
		//save the gl objects
		for(GeneralLedger gL:gLMap.values()) {
			gL.save();
		}
		//set the window fields
		DateFormat dF = new SimpleDateFormat("yyyy/MM/dd");
		Date d = new Date();
		lastPmtDate.setText(dF.format(d));
		commPayDate.setText(dF.format(d));
		totalCommPmtCount.setText(String.valueOf(checks.size()));
		DecimalFormat dFormat = new DecimalFormat("0.00");
		double ttl = 0;
		for(Checks c:checks) {
			ttl+=c.getAmount();
		}
		totalCommPmtAmt.setText("$" + dFormat.format(ttl/100));
		//security fields
		double ttxnamt = 0;
		for(Transaction t:tList) {
			ttxnamt+=t.getSubtotal();
		}
		totalPmt.setText(String.valueOf(checks.size()));
		totalTxn.setText(String.valueOf(tList.size()));
		pmtLessTxn.setText(String.valueOf(checks.size() - checks.size()));
		totalAmt.setText("$" + dFormat.format(ttl/100));
		//product count
		totalItemCount.setText("$" + dFormat.format(ttxnamt/100));
		avgComm.setText("%" + String.valueOf(dFormat.format((ttl/ttxnamt)*100)));
	}
	
	*//**
	 * fillEmployeeList
	 * @throws DataException 
	 *//*
	private void fillEmployeeList() throws DataException {
		employeeList.add("All Employees");
		java.util.List<Employee> eList = BusinessObjectDAO.getInstance().searchForAll("Employee");
		for(Employee e:eList) {
			employeeList.add(e.getFirstName() + " " + e.getLastName());
			employeeList.setData(e.getFirstName() + " " + e.getLastName(), e);
		}
	}
	
	*//**
	 * fillEmployee Commission details
	 * @throws DataException 
	 *//*
	private void fillEmployeeCommDetails(Employee employee) throws DataException {
		empCommStore.setText(employee.getStore().getLocation());
		Employee manager = BusinessObjectDAO.getInstance().read(employee.getStore().getManagerid());
		empCommManager.setText(manager.getFirstName() + " " + manager.getLastName());
		java.util.List<Transaction> transactions = BusinessObjectDAO.getInstance().searchForList("Transaction", new SearchCriteria("employeeid", employee.getId()));
		empTotalTxn.setText(String.valueOf(transactions.size()));
		int totalSales = 0;
		for (Transaction t:transactions) {
			totalSales+=t.getSubtotal();
		}
		DecimalFormat dF = new DecimalFormat("0.00");
		empTotalSales.setText("$" + dF.format(totalSales/100));
		int totalCommission = 0;
		for (Transaction t:transactions) {
			totalCommission+=t.getCommission().getAmount();
		}
		empTotalComm.setText("$" + dF.format(totalCommission/100));
	}
	
}//end
*/