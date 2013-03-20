package edu.byu.isys413.rtyler1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

//import edu.byu.isys403.rtyler1.gui.Accounts;

import swing2swt.layout.BorderLayout;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
//import edu.byu.isys413.data.Person;

public class MainScreen {

	protected Shell shlSalesTransaction;
	public static Text addressField;
	public static Text emailField;
	public static Text phoneField;
	public static Text nameField;
	public static Text lookUpPhoneField;
	public static Text skuField;
	public static Text serialNumField;
	public static Text totalField;
	public static Text taxField;
	public static Text subTotalField;
	public static Text quantityField;
	public static Table productTable;

	public static List<ConceptualProduct> cps = new ArrayList<ConceptualProduct>();
	public static List<PhysicalProduct> pps = new ArrayList<PhysicalProduct>();
	public static List<Product> products = new ArrayList<Product>();

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainScreen window = new MainScreen();
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
		shlSalesTransaction.open();
		shlSalesTransaction.layout();
		while (!shlSalesTransaction.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}





	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlSalesTransaction = new Shell();
		shlSalesTransaction.setSize(612, 479);
		shlSalesTransaction.setText("Sprint One");
		shlSalesTransaction.setLayout(new BorderLayout(0, 0));

		TabFolder tabFolder = new TabFolder(shlSalesTransaction, SWT.NONE);
		tabFolder.setLayoutData(BorderLayout.CENTER);

		TabItem tbtmMainscreen = new TabItem(tabFolder, SWT.NONE);
		tbtmMainscreen.setText("MainScreen");

		Composite composite = new Composite(tabFolder, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		tbtmMainscreen.setControl(composite);
		composite.setLayout(null);

		Button btnSaveCustomer = new Button(composite, SWT.NONE);
		btnSaveCustomer.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Customer.saveCustomerButtonClicked();				
			}
		});
		btnSaveCustomer.setBounds(10, 378, 158, 25);
		btnSaveCustomer.setText("Save Customer");

		Button btnNewCustomer = new Button(composite, SWT.NONE);
		btnNewCustomer.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				Customer.newCustomerButtonClicked();

			}
		});
		btnNewCustomer.setBounds(10, 351, 158, 25);
		btnNewCustomer.setText("New Customer");

		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setAlignment(SWT.RIGHT);
		lblNewLabel.setBounds(10, 327, 45, 15);
		lblNewLabel.setText("Address:");

		addressField = new Text(composite, SWT.BORDER);
		addressField.setBounds(58, 324, 110, 21);

		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		lblNewLabel_1.setAlignment(SWT.RIGHT);
		lblNewLabel_1.setBounds(10, 306, 45, 15);
		lblNewLabel_1.setText("Email:");

		Label lblPhone = new Label(composite, SWT.NONE);
		lblPhone.setAlignment(SWT.RIGHT);
		lblPhone.setBounds(10, 279, 45, 15);
		lblPhone.setText("Phone:");

		Label lblName = new Label(composite, SWT.NONE);
		lblName.setAlignment(SWT.RIGHT);
		lblName.setBounds(10, 252, 45, 15);
		lblName.setText("Name:");

		emailField = new Text(composite, SWT.BORDER);
		emailField.setBounds(58, 300, 110, 21);

		phoneField = new Text(composite, SWT.BORDER);
		phoneField.setBounds(58, 276, 110, 21);

		nameField = new Text(composite, SWT.BORDER);
		nameField.setBounds(58, 249, 110, 21);

		Button btnLookUpCustomer = new Button(composite, SWT.NONE);
		btnLookUpCustomer.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				Customer.lookUpCustomerButtonClicked();

			}
		});
		btnLookUpCustomer.setBounds(58, 221, 110, 25);
		btnLookUpCustomer.setText("Lookup Customer");

		lookUpPhoneField = new Text(composite, SWT.BORDER);
		lookUpPhoneField.setBounds(58, 194, 110, 21);

		Label lblPhone_1 = new Label(composite, SWT.NONE);
		lblPhone_1.setAlignment(SWT.RIGHT);
		lblPhone_1.setBounds(10, 197, 47, 15);
		lblPhone_1.setText("Phone:");

		Label lblNewLabel_2 = new Label(composite, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("Arial", 10, SWT.BOLD));
		lblNewLabel_2.setBounds(10, 173, 158, 15);
		lblNewLabel_2.setText("Customer");

		Button btnAddProduct = new Button(composite, SWT.NONE);
		btnAddProduct.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Product.addProductButtonClicked();
			}
		});
		btnAddProduct.setBounds(10, 137, 158, 25);
		btnAddProduct.setText("Add Product");

		skuField = new Text(composite, SWT.BORDER);
		skuField.setBounds(58, 79, 110, 21);

		serialNumField = new Text(composite, SWT.BORDER);
		serialNumField.setBounds(58, 52, 110, 21);

		Label lblNewLabel_3 = new Label(composite, SWT.NONE);
		lblNewLabel_3.setAlignment(SWT.RIGHT);
		lblNewLabel_3.setBounds(0, 82, 55, 15);
		lblNewLabel_3.setText("SKU:");

		Label lblSerial = new Label(composite, SWT.NONE);
		lblSerial.setAlignment(SWT.RIGHT);
		lblSerial.setBounds(0, 55, 55, 15);
		lblSerial.setText("Serial #:");

		Label lblProductLookup = new Label(composite, SWT.NONE);
		lblProductLookup.setFont(SWTResourceManager.getFont("Arial", 10, SWT.BOLD));
		lblProductLookup.setBounds(10, 31, 158, 15);
		lblProductLookup.setText("Product Lookup");

		Button btnSignOut = new Button(composite, SWT.NONE);
		btnSignOut.setBounds(507, 5, 71, 25);
		btnSignOut.setText("Sign Out");

		Button btnFinishTransaction = new Button(composite, SWT.NONE);
		btnFinishTransaction.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {				
				Transaction1.finishTransactionButtonClicked();				
			}
		});
		btnFinishTransaction.setBounds(451, 378, 127, 25);
		btnFinishTransaction.setText("Finish Transaction");

		totalField = new Text(composite, SWT.BORDER);
		totalField.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		totalField.setBounds(396, 345, 182, 31);

		taxField = new Text(composite, SWT.BORDER);
		taxField.setBounds(451, 321, 128, 21);

		subTotalField = new Text(composite, SWT.BORDER);
		subTotalField.setBounds(451, 297, 127, 21);

		Label lblFebruary = new Label(composite, SWT.NONE);
		lblFebruary.setBounds(10, 10, 158, 15);
		lblFebruary.setText("February 03, 2013   4:05:36 PM");

		Label lblSubtotal = new Label(composite, SWT.NONE);
		lblSubtotal.setAlignment(SWT.RIGHT);
		lblSubtotal.setBounds(381, 300, 64, 15);
		lblSubtotal.setText("Subtotal:");

		Label lblTax = new Label(composite, SWT.NONE);
		lblTax.setAlignment(SWT.RIGHT);
		lblTax.setBounds(390, 324, 55, 15);
		lblTax.setText("Tax:");

		Label lblTotal = new Label(composite, SWT.NONE);
		lblTotal.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		lblTotal.setAlignment(SWT.RIGHT);
		lblTotal.setBounds(335, 344, 55, 31);
		lblTotal.setText("Total:");

		quantityField = new Text(composite, SWT.BORDER);
		quantityField.setBounds(58, 106, 110, 21);

		Label lblQuantity = new Label(composite, SWT.NONE);
		lblQuantity.setAlignment(SWT.RIGHT);
		lblQuantity.setBounds(0, 109, 55, 15);
		lblQuantity.setText("Quantity:");

		TableViewer tableViewer = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
		productTable = tableViewer.getTable();
//		productTable.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				IStructuredSelection sel = (IStructuredSelection) tableViewer.getSelection();
//				//Person person = (Person) sel.getFirstElement();
//				//ConceptualProduct cp = (ConceptualProduct) sel.getFirstElement();
//				//persons.remove(person);
//				tableViewer.refresh();
//			}
//		});
		productTable.setBounds(174, 31, 404, 263);
		productTable.setHeaderVisible(true);
		productTable.setLinesVisible(true);

		TableViewerColumn tableViewerColumnProductName = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnProductName = tableViewerColumnProductName.getColumn();
		tblclmnProductName.setResizable(false);
		tblclmnProductName.setWidth(258);
		tblclmnProductName.setText("Product Name");

		tableViewerColumnProductName.setLabelProvider(new ColumnLabelProvider(){
			public String getText(Object element) {
				ConceptualProduct cp = (ConceptualProduct) element;
				return String.valueOf(cp.getProductName());
			}
		});

		TableViewerColumn tableViewerColumnPrice = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnPrice = tableViewerColumnPrice.getColumn();
		tblclmnPrice.setResizable(false);
		tblclmnPrice.setWidth(77);
		tblclmnPrice.setText("Price");

		tableViewerColumnPrice.setLabelProvider(new ColumnLabelProvider(){
			public String getText(Object element) {
				ConceptualProduct cp = (ConceptualProduct) element;
				return String.valueOf(cp.getPrice());
			}
		});

		TableViewerColumn tableViewerColumnQuantity = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnQuantity = tableViewerColumnQuantity.getColumn();
		tblclmnQuantity.setResizable(false);
		tblclmnQuantity.setWidth(65);
		tblclmnQuantity.setText("Quantity");


		//		tableViewerColumnPrice.setLabelProvider(new ColumnLabelProvider(){
		//			public String getText(Object thisObject) {
		//				PhysicalProduct pp = (PhysicalProduct) thisObject;
		//				return String.valueOf(pp.getQuantity());
		//				
		//				}
		//			});

		TabItem tbtmGeneralLedgerUpdate = new TabItem(tabFolder, SWT.NONE);
		tbtmGeneralLedgerUpdate.setText("General Ledger Update");
		
		Composite composite_1 = new Composite(tabFolder, SWT.NONE);
		composite_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		tbtmGeneralLedgerUpdate.setControl(composite_1);
		
		Button btnUpdateGeneralLedger = new Button(composite_1, SWT.NONE);
		btnUpdateGeneralLedger.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				GeneralLedger.updateGeneralLedgerButtonClicked();
				
			}
		});
		btnUpdateGeneralLedger.setBounds(174, 182, 178, 25);
		btnUpdateGeneralLedger.setText("Update General Ledger");

		tableViewer.setContentProvider(new ArrayContentProvider());
		tableViewer.setInput(cps);

//		IStructuredSelection sel = (IStructuredSelection)
//				tableViewer.getSelection();
//		ConceptualProduct conceptualproducts = (ConceptualProduct) sel.getFirstElement();

	}//createcontents
}
