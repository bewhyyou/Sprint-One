package edu.byu.isys413.rtyler1;

import java.util.List;

public class Product extends BusinessObject{

	@BusinessObjectField
	private double price = 0.00;
	@BusinessObjectField
	private String prodType = null;	



	public static void addProductButtonClicked() {

		//take info in each portion (including quantity)
		String serialNumber = MainScreen.serialNumField.getText();
		String skuNumber = MainScreen.skuField.getText();
		String quantity = MainScreen.quantityField.getText();

		System.out.println("Leg one");

		ConceptualProduct conProd;
		PhysicalProduct physProd;

		//in table, put text fields in each of the columns......haha. 

		//if only sku number: conceptual product
		if (serialNumber.equals("") && !skuNumber.equals("")){


			System.out.println("Leg two");

			try {

				//5F9S75
				//productInfo = BusinessObjectDAO.getInstance().read("physicalproduct1");

				//int skuNum = Integer.parseInt(skuNumber);

				//search info!! we want the product name and the price
				conProd = BusinessObjectDAO.getInstance().searchForBO("ConceptualProduct", new SearchCriteria("sku", skuNumber)); //creating an object (searchCriteria)


				//need to keep it in a list, so we can update the database later
				MainScreen.cps.add(conProd);


				//				
				//				System.out.println("Leg three");
				//				
				//				
				//				String conceptualProductName = conProd.getProductName();
				//				Double conceptualProductPriceDouble = conProd.getPrice();
				//				String conceptualProductPrice = Double.toString(conceptualProductPriceDouble);
				//						

				//				System.out.println(conceptualProductName);
				//				System.out.println(conceptualProductPrice);
				//			
				//				productTable.setData(conceptualProductName);

				//Take quantity portion as well; if no quantity was entered, assume quantity of 1?				
				//maybe add it to a map? 

				//calculating/updating SubTotal
				
				
				double prodQuantity;
				
				if (MainScreen.quantityField.getText().equals("")) {
					
					prodQuantity = 1;
					
				}else{
					
					prodQuantity = Double.parseDouble(quantity);
					
				}
				
				
				
				double subTotal = conProd.getPrice() * prodQuantity;

				double runningSubTotalBalance;
				if (MainScreen.subTotalField.getText().equals("")){

					runningSubTotalBalance = 0.00;

				}else {

					runningSubTotalBalance = Double.parseDouble(MainScreen.subTotalField.getText());	

				}

				double updatedSubTotal = runningSubTotalBalance + subTotal;
				MainScreen.subTotalField.setText(Double.toString(updatedSubTotal));

				//calculating/updating Tax
				double tax = updatedSubTotal * 0.12;
				MainScreen.taxField.setText(Double.toString(tax));

				//calculating/updating Total
				double total = updatedSubTotal + tax;
				MainScreen.totalField.setText(Double.toString(total));


			}catch (DataException e) {

				System.out.println("'SKU Number only' did not work");
				e.printStackTrace();
			}//trycatch


		}else if(!serialNumber.equals("") && !skuNumber.equals("")){ //if both the serial number and the sku: physical product

			try {

				//5F9S75
				//573023419672
				physProd = BusinessObjectDAO.getInstance().searchForBO("PhysicalProduct", new SearchCriteria("serialnumber", serialNumber)); //creating an object (searchCriteria)
				conProd = BusinessObjectDAO.getInstance().searchForBO("ConceptualProduct", new SearchCriteria("sku", skuNumber)); //creating an object (searchCriteria)


				//need to keep it in a list, so we can update the database later
				MainScreen.cps.add(conProd);
				MainScreen.pps.add(physProd);


				//calculating/updating SubTotal
				double prodQuantity;

				if (MainScreen.quantityField.equals("")){
					
					prodQuantity = 1;
					
//					prodQuantity = Double.parseDouble(quantity);
//					prodQuantity = prodQuantity + 1;

				}else {

					prodQuantity = Double.parseDouble(quantity);

				}

				double subTotal = physProd.getPrice() * prodQuantity;
				//double runningSubTotalBalance = Double.parseDouble(MainScreen.subTotalField.getText());
				
				double runningSubTotalBalance;
				if (MainScreen.subTotalField.getText().equals("")){

					runningSubTotalBalance = 0.00;

				}else {

					runningSubTotalBalance = Double.parseDouble(MainScreen.subTotalField.getText());	

				}
				
				
				
				double updatedSubTotal = runningSubTotalBalance + subTotal;
				MainScreen.subTotalField.setText(Double.toString(updatedSubTotal));

				//calculating/updating Tax
				double tax = updatedSubTotal * 0.12;
				MainScreen.taxField.setText(Double.toString(tax));

				//calculating/updating Total
				double total = updatedSubTotal + tax;
				MainScreen.totalField.setText(Double.toString(total));



			} catch (DataException e) {

				System.out.println("'SKU Number and Serial Number' did not work");
				e.printStackTrace();
			}//trycatch


		}//elseif

		//calculate subtotal + tax = total here?


	}//addProductButtonClicked




	///////////////////Constructor, getters, and setters//////////////////////////

	/** Creates a new instance of this object */
	public Product(String id) {
		super(id);
	}

	/** Gets the price for the Product Object*/
	public double getPrice() {
		return price;
	}

	/** Sets the price for the Product Object*/
	public void setPrice(double price) {
		this.price = price;
		setDirty();
	}

	/** Gets the prodType for the Product Object*/
	public String getProdType() {
		return prodType;
	}

	/** sets the prodType for the Product Object*/
	public void setProdType(String prodType) {
		this.prodType = prodType;
		setDirty();
	}


	/**
	 * Retrieves the sales for this product
	 */
	public List<Sale> getSales() throws DataException {
		return BusinessObjectDAO.getInstance().searchForList("Sale", new SearchCriteria("prodid", id));
	}


}
