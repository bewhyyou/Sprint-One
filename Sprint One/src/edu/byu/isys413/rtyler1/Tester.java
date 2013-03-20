package edu.byu.isys413.rtyler1;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

//import edu.byu.isys413.data.Car;
//import edu.byu.isys413.data.Dog;
//import edu.byu.isys413.data.Person;

import edu.byu.isys413.rtyler1.BusinessObjectDAO;
import edu.byu.isys413.rtyler1.Cache;

import edu.byu.isys413.rtyler1.Employee;
import edu.byu.isys413.rtyler1.Commission;
import edu.byu.isys413.rtyler1.Store;
import edu.byu.isys413.rtyler1.Transaction1;
import edu.byu.isys413.rtyler1.Computer;
import edu.byu.isys413.rtyler1.JournalEntry;
import edu.byu.isys413.rtyler1.DebitCredit;
import edu.byu.isys413.rtyler1.Product;
import edu.byu.isys413.rtyler1.ConceptualProduct;
import edu.byu.isys413.rtyler1.PhysicalProduct;
import edu.byu.isys413.rtyler1.RevenueSource;
import edu.byu.isys413.rtyler1.Sale;
import edu.byu.isys413.rtyler1.StoreProduct;
import edu.byu.isys413.rtyler1.Customer;

import edu.byu.isys413.rtyler1.SearchCriteria;


public class Tester {

	SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");	

	public Tester() throws Exception {
		CreateDB.main(null);
	}

//	/** Example test */
//	@Test
//	public void TestExample() throws Exception {
//		String st1 = "Hi There";
//		String st2 = "Hi There";
//		assertEquals(st1, st2);
//	}
//
//	/** Test the Employee BO (also tests the Store BO) */
//	@Test
//	public void TestEmployee() throws Exception {
//		Employee e = BusinessObjectDAO.getInstance().create("Employee", "emp1");
//		Store store = BusinessObjectDAO.getInstance().read("store1");
//		e.setStore(store);
//		e.setEmpName("Joe");
//		e.setHireDate(new Date());
//		e.setPhone("708-345-2563");
//		e.setSalary(32435.00);
//		e.setCommissionRate(3.45);
//		e.setLoginName("Groovy");
//		e.save();
//
//		// since emp1 is in the Cache, this tests reading from the cache
//		Employee e2 = BusinessObjectDAO.getInstance().read("emp1");
//		assertSame(e, e2);
//
//		// now clear the cache (you'd never do this in the real world)
//		// then we can test reading from the database
//		Cache.getInstance().clear();
//		Employee e3 = BusinessObjectDAO.getInstance().read("emp1");
//		assertEquals(e.getId().trim(), e3.getId().trim());
//		assertEquals(e.getEmpName(), e3.getEmpName());
//		assertEquals(SDF.format(e.getHireDate()), SDF.format(e3.getHireDate()));
//		assertEquals(e.getPhone(), e3.getPhone());
//		assertTrue(e.getSalary() - e3.getSalary() < 0.1);
//		assertTrue(e.getCommissionRate() - e3.getCommissionRate() < 0.1);
//		assertEquals(e.getLoginName(), e3.getLoginName());
//		assertEquals(e.getStore().getId().trim(), e3.getStore().getId().trim());
//
//		// test deleting
//		BusinessObjectDAO.getInstance().delete(e);
//
//		// create another one with the same id (the other should be deleted)
//		Employee e4 = BusinessObjectDAO.getInstance().create("Employee", "emp5");
//		Store store1 = BusinessObjectDAO.getInstance().read("store1");
//		e4.setStore(store1);
//		e4.setEmpName("Joe");
//		e4.setHireDate(new Date());
//		e4.setPhone("708-345-2563");
//		e4.setSalary(32435.00);
//		e4.setCommissionRate(3.45);
//		e4.setLoginName("Groovy");
//		e4.save();
//
//
//		// test the search methods
//		List<Employee> emps = BusinessObjectDAO.getInstance().searchForAll("Employee");
//		assertEquals(emps.size(), 4);  // 3 from CreateDB, Joe above
//		Employee emp1 = BusinessObjectDAO.getInstance().searchForBO("Employee", new SearchCriteria("id", "employee1")); //creating an object (searchCriteria)
//		assertEquals(emp1.getId().trim(), "employee1");
//		List<Employee> emps2 = BusinessObjectDAO.getInstance().searchForList("Employee", new SearchCriteria("empname", "Joe", SearchCriteria.LIKE));
//		assertEquals(emps2.size(), 1);
//
//
//	}//TestEmployee
//

	/** Test the Store BO (also tests the Employee BO) */
	@Test
	public void TestStore() throws Exception {
		Store s = BusinessObjectDAO.getInstance().create("Store", "store4");
		Employee emp1 = BusinessObjectDAO.getInstance().read("employee1");
		s.setManager(emp1);
		s.setLocation("Provo");
		//s.setManagerId("Joe Denker");
		s.setAddress("Some street here in Provo, 84606");
		s.setPhone("703-285-1859");
		s.setSalesTaxRate(3.00);
		s.setSubnetId("124.643.23.3");
		s.save();

		// since store1 is in the Cache, this tests reading from the cache
		Store s2 = BusinessObjectDAO.getInstance().read("store4");
		assertSame(s, s2);

		// now clear the cache (you'd never do this in the real world)
		// then we can test reading from the database
		Cache.getInstance().clear();

		Store s3 = BusinessObjectDAO.getInstance().read("store4");
		assertEquals(s.getId().trim(), s3.getId().trim());
		assertEquals(s.getLocation(), s3.getLocation());
		//assertEquals(s.getManagerId(), s3.getManagerId());
		assertEquals(s.getAddress(), s3.getAddress());
		assertEquals(s.getPhone(), s3.getPhone());
		assertTrue(s.getSalesTaxRate() - s3.getSalesTaxRate() < 0.1);
		assertEquals(s.getSubnetId(), s3.getSubnetId());
		assertEquals(s.getManager().getId().trim(), s3.getManager().getId().trim());


		// test deleting
		BusinessObjectDAO.getInstance().delete(s);

		// create another one with the same id (the other should be deleted)
		Store s4 = BusinessObjectDAO.getInstance().create("Store", "store5");
		Employee emp2 = BusinessObjectDAO.getInstance().read("employee1");
		s4.setManager(emp2);
		s4.setLocation("Provo");
		s4.setManagerId("Joe Denker");
		s4.setAddress("Some street here in Provo, 84606");
		s4.setPhone("703-285-1859");
		s4.setSalesTaxRate(3.00);
		s4.setSubnetId("124.643.23.3");
		s4.save();


		// test the search methods
		List<Store> stores = BusinessObjectDAO.getInstance().searchForAll("Store");
		assertEquals(stores.size(), 4);  // 3 from CreateDB, s above
		Store store2 = BusinessObjectDAO.getInstance().searchForBO("Store", new SearchCriteria("id", "store3")); //creating an object (searchCriteria)
		assertEquals(store2.getId().trim(), "store3");
		List<Store> stores4 = BusinessObjectDAO.getInstance().searchForList("Store", new SearchCriteria("managerid", "Jake", SearchCriteria.LIKE));
		assertEquals(stores4.size(), 2);


	}//TestStore
//
//
//	/** Test the Customer BO */
//	@Test
//	public void TestCustomer() throws Exception {
//		Customer c = BusinessObjectDAO.getInstance().create("Customer", "cust");
//		c.setName("Kate");
//		c.setPhone("402-642-2784");
//		c.setEmail("yeehaw@whatthe.com");
//		c.setAddress("Some road in Orem, 84613");
//		c.save();
//
//		// since cust is in the Cache, this tests reading from the cache
//		Customer c2 = BusinessObjectDAO.getInstance().read("cust");
//		assertSame(c, c2);
//
//		// now clear the cache (you'd never do this in the real world)
//		// then we can test reading from the database
//		Cache.getInstance().clear();
//
//		Customer c3 = BusinessObjectDAO.getInstance().read("cust");
//		assertEquals(c.getId().trim(), c3.getId().trim());
//		assertEquals(c.getName(), c3.getName());
//		assertEquals(c.getPhone(), c3.getPhone());
//		assertEquals(c.getAddress(), c3.getAddress());
//
//
//		// test deleting
//		BusinessObjectDAO.getInstance().delete(c);
//
//		// create another one with the same id (the other should be deleted)
//		Customer c4 = BusinessObjectDAO.getInstance().create("Customer", "cust1");
//		c4.setName("Kate");
//		c4.setPhone("402-642-2784");
//		c4.setEmail("yeehaw@whatthe.com");
//		c4.setAddress("Some road in Orem, 84613");
//		c4.save();
//
//		// test the search methods
//		List<Customer> customers = BusinessObjectDAO.getInstance().searchForAll("Customer");
//		assertEquals(customers.size(), 4);  // 3 from CreateDB, c above
//		//search for existing one, compare it to the object that is set to it.
//		Customer cust2 = BusinessObjectDAO.getInstance().searchForBO("Customer", new SearchCriteria("id", "customer3")); //creating an object (searchCriteria)
//		assertEquals(cust2.getId().trim(), "customer3");
//		List<Customer> customers2 = BusinessObjectDAO.getInstance().searchForList("Customer", new SearchCriteria("name", "Kate", SearchCriteria.LIKE));
//		assertEquals(customers2.size(), 2);
//
//
//	}//TestCustomer
//
//
//	/** Test the Product BO */
//	@Test
//	public void TestProduct() throws Exception {
//		Product p = BusinessObjectDAO.getInstance().create("Product", "product4");
//		p.setPrice(4.56);
//		p.setProdType("Physical");
//		p.save();
//
//
//		// since product4 is in the Cache, this tests reading from the cache
//		Product p2 = BusinessObjectDAO.getInstance().read("product4");
//		assertSame(p, p2);
//
//		// now clear the cache (you'd never do this in the real world)
//		// then we can test reading from the database
//		Cache.getInstance().clear();
//
//		Product p3 = BusinessObjectDAO.getInstance().read("product4");
//		assertEquals(p.getId().trim(), p3.getId().trim());
//		assertTrue(p.getPrice() - p3.getPrice() < 0.1);
//		assertEquals(p.getProdType(), p3.getProdType());
//
//
//		// test deleting
//		BusinessObjectDAO.getInstance().delete(p);
//
//		// create another one with the same id (the other should be deleted)
//		Product p4 = BusinessObjectDAO.getInstance().create("Product", "product5");
//		p4.setPrice(4.56);
//		p4.setProdType("Physical");
//		p4.save();
//
//
//	}//TestProduct
//
//
//	/** Test the JournalEntry BO */
//	@Test
//	public void TestJournalEntry() throws Exception {
//		JournalEntry je = BusinessObjectDAO.getInstance().create("JournalEntry", "journalentry4");
//		//java.util.Date jeDate1 = new java.util.Date(12, 1, 14); 
//		je.setJeDate(new Date());
//		je.save();
//
//		// since product4 is in the Cache, this tests reading from the cache
//		JournalEntry je2 = BusinessObjectDAO.getInstance().read("journalentry4");
//		assertSame(je, je2);
//
//		// now clear the cache (you'd never do this in the real world)
//		// then we can test reading from the database
//		Cache.getInstance().clear();
//
//		JournalEntry je3 = BusinessObjectDAO.getInstance().read("journalentry4");
//		assertEquals(je.getId().trim(), je3.getId().trim());
//		assertEquals(SDF.format(je.getJeDate()), SDF.format(je3.getJeDate()));
//
//		// test deleting
//		BusinessObjectDAO.getInstance().delete(je);
//
//		// create another one with the same id (the other should be deleted)
//		JournalEntry je4 = BusinessObjectDAO.getInstance().create("JournalEntry", "journalentry5");
//		//java.util.Date jeDate2 = new java.util.Date(12, 1, 14); 
//		je4.setJeDate(new Date());
//		je4.save();
//
//	}//TestJournalEntry
//
//
//
//	/** Test the Computer BO */
//	@Test
//	public void TestComputer() throws Exception {
//		Computer comp = BusinessObjectDAO.getInstance().create("Computer", "computer4");
//		Store store = BusinessObjectDAO.getInstance().read("store1");
//		comp.setStore(store);
//		comp.setMacAddress("0F:3G:40:2B:45:0G:1D");
//		comp.save();
//
//
//		// since product4 is in the Cache, this tests reading from the cache
//		Computer comp2 = BusinessObjectDAO.getInstance().read("computer4");
//		assertSame(comp, comp2);
//
//		// now clear the cache (you'd never do this in the real world)
//		// then we can test reading from the database
//		Cache.getInstance().clear();
//
//		Computer comp3 = BusinessObjectDAO.getInstance().read("computer4");
//		assertEquals(comp.getId().trim(), comp3.getId().trim());
//		assertEquals(comp.getMacAddress(), comp3.getMacAddress());
//		assertEquals(comp.getStore().getId().trim(), comp3.getStore().getId().trim());
//
//
//		// test deleting
//		BusinessObjectDAO.getInstance().delete(comp);
//
//		// create another one with the same id (the other should be deleted)
//		Computer comp4 = BusinessObjectDAO.getInstance().create("Computer", "computer5");
//		Store store1 = BusinessObjectDAO.getInstance().read("store1");
//		comp4.setStore(store1);
//		comp4.setMacAddress("0F:3G:40:2B:45:0G:1D");
//		comp4.save();
//
//	}//TestComputer
//
//
//	/** Tests the 1-M relationship between Store and Computer */
//	@Test
//	public void TestStoreComputer() throws Exception {
//
//		// this store will own three computers
//		Store s = BusinessObjectDAO.getInstance().create("Store", "Provo Store");
//		Employee emp1 = BusinessObjectDAO.getInstance().read("employee1");
//		s.setManager(emp1);
//		s.setLocation("Provo");
//		s.setManagerId("Levi");
//		s.setAddress("Some street here in Provo, 84606");
//		s.setPhone("703-285-1859");
//		s.setSalesTaxRate(3.00);
//		s.setSubnetId("124.643.23.3");
//		s.save();
//
//		// first computer
//		Computer c1 = BusinessObjectDAO.getInstance().create("Computer", "computerA");
//		c1.setStore(s);
//		c1.setMacAddress("0F:3G:40:2B:45:0G:1D");
//		c1.save();
//
//		// second computer
//		Computer c2 = BusinessObjectDAO.getInstance().create("Computer", "computerB");
//		c2.setStore(s);
//		c2.setMacAddress("1F:3G:90:2B:45:DG:1D");
//		c2.save();
//
//		// third computer
//		Computer c3 = BusinessObjectDAO.getInstance().create("Computer", "computerC");
//		c3.setStore(s);
//		c3.setMacAddress("8S:3G:4B:2B:9K:0G:1D");
//		c3.save();
//
//		// retrieve the three computers from the Store object
//		List<Computer> computers = s.getComputers();
//		assertEquals(computers.size(), 3);
//		//System.out.println(computers.get(0).getStore().getId()); //this works
//		assertSame(computers.get(0).getStore(), s);
//		assertSame(computers.get(1).getStore(), s);
//		assertSame(computers.get(2).getStore(), s);
//	}//TestStoreComputer
//
//
//
//	/** Test the Commission BO */
//	@Test
//	public void TestCommission() throws Exception {
//		Commission comm = BusinessObjectDAO.getInstance().create("Commission", "commission4");
//		Employee employee = BusinessObjectDAO.getInstance().read("employee1");
//		comm.setEmployee(employee);
//		comm.setAmount(5.31);
//		comm.setCommDate(new Date());
//		comm.save();
//
//
//		// since product4 is in the Cache, this tests reading from the cache
//		Commission comm2 = BusinessObjectDAO.getInstance().read("commission4");
//		assertSame(comm, comm2);
//
//		// now clear the cache (you'd never do this in the real world)
//		// then we can test reading from the database
//		Cache.getInstance().clear();
//
//		Commission comm3 = BusinessObjectDAO.getInstance().read("commission4");
//		assertEquals(comm.getId().trim(), comm3.getId().trim());
//		assertEquals(comm.getEmployee().getId().trim(), comm3.getEmployee().getId().trim());
//		assertTrue(comm.getAmount() - comm3.getAmount() < 0.1);
//		assertEquals(SDF.format(comm.getCommDate()), SDF.format(comm3.getCommDate()));
//
//		// test deleting
//		BusinessObjectDAO.getInstance().delete(comm);
//
//		// create another one with the same id (the other should be deleted)
//		Commission comm4 = BusinessObjectDAO.getInstance().create("Commission", "commission5");
//		Employee employee1 = BusinessObjectDAO.getInstance().read("employee1");
//		comm4.setEmployee(employee1);
//		comm4.setAmount(5.31);
//		comm4.setCommDate(new Date());
//		comm4.save();
//
//	}//TestCommission
//
//
//	/** Test the ConceptualProduct BO */
//	@Test
//	public void TestConceptualProduct() throws Exception {
//		ConceptualProduct cp = BusinessObjectDAO.getInstance().create("ConceptualProduct", "conceptualproduct4");
//		cp.setProductName("Pens");
//		cp.setDescription("Awh, you made me ink!");
//		cp.setManufacturer("Penspens");
//		cp.setAverageCost(0.99);
//		cp.setSku("45LK34");
//		cp.save();
//
//
//		// since product4 is in the Cache, this tests reading from the cache
//		ConceptualProduct cp2 = BusinessObjectDAO.getInstance().read("conceptualproduct4");
//		assertSame(cp, cp2);
//
//		// now clear the cache (you'd never do this in the real world)
//		// then we can test reading from the database
//		Cache.getInstance().clear();
//
//		ConceptualProduct cp3 = BusinessObjectDAO.getInstance().read("conceptualproduct4");
//		assertEquals(cp.getId().trim(), cp3.getId().trim());
//		assertEquals(cp.getProductName(), cp3.getProductName());
//		assertEquals(cp.getDescription(), cp3.getDescription());
//		assertEquals(cp.getManufacturer(), cp3.getManufacturer());
//		assertTrue(cp.getAverageCost() - cp3.getAverageCost() < 0.1);
//		assertEquals(cp.getSku(), cp3.getSku());
//
//		// test deleting
//		BusinessObjectDAO.getInstance().delete(cp);
//
//		// create another one with the same id (the other should be deleted)
//		ConceptualProduct cp4 = BusinessObjectDAO.getInstance().create("ConceptualProduct", "conceptualproduct5");
//		cp4.setProductName("Pens");
//		cp4.setDescription("Awh, you made me ink!");
//		cp4.setManufacturer("Penspens");
//		cp4.setAverageCost(0.99);
//		cp4.setSku("45LK34");
//		cp4.save();
//
//	}//TestConceptualProduct
//
//
//
//	/** Test the M-M relationship between ConceptualProduct and Store, aka StoreProduct */
//	@Test
//	public void TestStoreProduct() throws Exception {
//		// this test assumes that certain people and cars are already in the database
//		// in the DB, person1 owns only car1, person2 owns car1, car2, car3
//		Store store1 = BusinessObjectDAO.getInstance().read("store1");
//		Store store2 = BusinessObjectDAO.getInstance().read("store2");
//		Store store3 = BusinessObjectDAO.getInstance().read("store3");
//		ConceptualProduct cp1 = BusinessObjectDAO.getInstance().read("conceptualproduct1");
//		ConceptualProduct cp2 = BusinessObjectDAO.getInstance().read("conceptualproduct2");
//		//ConceptualProduct cp3 = BusinessObjectDAO.getInstance().read("conceptualproduct3");
//
//		// test store1's conceptual products
//		assertEquals(store1.getConceptualProducts().size(), 1);
//		assertSame(store1.getConceptualProducts().get(0), cp1);
//
//
//		// test store2's conceptual products
//		List<ConceptualProduct> conceptualproducts = store2.getConceptualProducts();
//		assertEquals(conceptualproducts.size(), 1); //change number
//		assertTrue(conceptualproducts.contains(cp2));
//		//assertTrue(conceptualproducts.contains(cp1));
//		//assertTrue(conceptualproducts.contains(cp3));
//
//
//		// test conceptualproducts2's stores
//		List<Store> stores = cp2.getStores();
//		assertEquals(stores.size(), 2);
//		//the list just created should contain these two stores:
//		assertTrue(stores.contains(store2)); 
//		assertTrue(stores.contains(store3));
//
//		//makes sense!! =D 
//
//
//	}//TestStoreProduct
//
//
//	/** Test the Sale BO */
//	@Test
//	public void TestSale() throws Exception {
//		Sale sale = BusinessObjectDAO.getInstance().create("Sale", "sale4");
//		Product product = BusinessObjectDAO.getInstance().read("product1");
//		sale.setProduct(product);
//		sale.setQuantity(5);
//		sale.setSaleType("In Store");
//		sale.save();
//
//
//		// since product4 is in the Cache, this tests reading from the cache
//		Sale sale2 = BusinessObjectDAO.getInstance().read("sale4");
//		assertSame(sale, sale2);
//
//		// now clear the cache (you'd never do this in the real world)
//		// then we can test reading from the database
//		Cache.getInstance().clear();
//
//		Sale sale3 = BusinessObjectDAO.getInstance().read("sale4");
//		assertEquals(sale.getId().trim(), sale3.getId().trim());
//		assertEquals(sale.getQuantity(), sale3.getQuantity());
//		assertEquals(sale.getProduct().getId().trim(), sale3.getProduct().getId().trim());
//		assertEquals(sale.getSaleType(), sale3.getSaleType());
//
//
//		// test deleting
//		BusinessObjectDAO.getInstance().delete(sale);
//
//		// create another one with the same id (the other should be deleted)
//		Sale sale4 = BusinessObjectDAO.getInstance().create("Sale", "sale5");
//		Product product1 = BusinessObjectDAO.getInstance().read("product1");
//		sale4.setProduct(product1);
//		sale4.setQuantity(5);
//		sale4.setSaleType("In Store");
//		sale4.save();
//
//	}//TestSale
//
//
//
//	/** Test the RevenueSource BO */
//	@Test
//	public void TestRevenueSource() throws Exception {
//		RevenueSource rs = BusinessObjectDAO.getInstance().create("RevenueSource", "revenuesource4");
//		Transaction1 trans = BusinessObjectDAO.getInstance().read("trans1");
//		rs.setTransaction(trans);
//		rs.setChargeAmount(15.62);
//		rs.setRsType("Sale");
//		rs.save();
//
//
//		// since product4 is in the Cache, this tests reading from the cache
//		RevenueSource rs2 = BusinessObjectDAO.getInstance().read("revenuesource4");
//		assertSame(rs, rs2);
//
//		// now clear the cache (you'd never do this in the real world)
//		// then we can test reading from the database
//		Cache.getInstance().clear();
//
//		RevenueSource rs3 = BusinessObjectDAO.getInstance().read("revenuesource4");
//		assertEquals(rs.getId().trim(), rs3.getId().trim());
//		assertTrue(rs.getChargeAmount() - rs3.getChargeAmount() < 0.1);
//		assertEquals(rs.getRsType(), rs3.getRsType());
//		assertEquals(rs.getTransaction().getId().trim(), rs3.getTransaction().getId().trim());
//
//
//		// test deleting
//		BusinessObjectDAO.getInstance().delete(rs);
//
//		// create another one with the same id (the other should be deleted)
//		RevenueSource rs4 = BusinessObjectDAO.getInstance().create("RevenueSource", "revenuesource5");
//		Transaction1 trans1 = BusinessObjectDAO.getInstance().read("trans1");
//		rs4.setTransaction(trans1);
//		rs4.setChargeAmount(15.62);
//		rs4.setRsType("Sale");
//		rs4.save();
//
//	}//TestRevenueSource
//
//
//
//	/** Test the DebitCredit BO */
//	@Test
//	public void TestDebitCredit() throws Exception {
//		DebitCredit dc = BusinessObjectDAO.getInstance().create("DebitCredit", "debitcredit16");
//		JournalEntry je = BusinessObjectDAO.getInstance().read("journalentry1");
//		dc.setJournalEntry(je);
//		dc.setDebitCredit("Debit");
//		dc.setGeneralLedgerName("Cash"); 
//		dc.setAmount(12.00);
//		dc.save();
//
//
//		// since debitcredit16 is in the Cache, this tests reading from the cache
//		DebitCredit dc2 = BusinessObjectDAO.getInstance().read("debitcredit16");
//		assertSame(dc, dc2);
//
//		// now clear the cache (you'd never do this in the real world)
//		// then we can test reading from the database
//		Cache.getInstance().clear();
//
//		DebitCredit dc3 = BusinessObjectDAO.getInstance().read("debitcredit16");
//		assertEquals(dc.getId().trim(), dc3.getId().trim());
//		assertTrue(dc.getAmount() - dc3.getAmount() < 0.1);
//		assertEquals(dc.getDebitCredit(), dc3.getDebitCredit());
//		assertEquals(dc.getJournalEntry().getId().trim(), dc3.getJournalEntry().getId().trim());
//
//
//		// test deleting
//		BusinessObjectDAO.getInstance().delete(dc);
//
//		// create another one with the same id (the other should be deleted)
//		DebitCredit dc4 = BusinessObjectDAO.getInstance().create("DebitCredit", "debitcredit17");
//		JournalEntry je1 = BusinessObjectDAO.getInstance().read("journalentry1");
//		dc4.setJournalEntry(je1);
//		dc4.setDebitCredit("Debit");
//		dc4.setGeneralLedgerName("Cash"); 
//		dc4.setAmount(12.00);
//		dc4.save();
//
//	}//TestDebitCredit
//
//
//
//	/** Test the PhysicalProduct BO */
//	@Test
//	public void TestPhysicalProduct() throws Exception {
//		PhysicalProduct pp = BusinessObjectDAO.getInstance().create("PhysicalProduct", "physicalproduct4");
//		Store s = BusinessObjectDAO.getInstance().read("store1");
//		pp.setStore(s);
//		pp.setSerialNumber("F35JH2LG0KFJ2");
//		pp.setShelfLocation("Down yonder");
//		pp.setDatePurchased(new Date());
//		pp.setCost(14.99);
//		pp.setStatus("Sold");
//		pp.setPhysicalProductCommissionRate(4.56);
//		pp.setPPType("For Sale");
//		pp.save();
//
//		// since product4 is in the Cache, this tests reading from the cache
//		PhysicalProduct pp2 = BusinessObjectDAO.getInstance().read("physicalproduct4");
//		assertSame(pp, pp2);
//
//		// now clear the cache (you'd never do this in the real world)
//		// then we can test reading from the database
//		Cache.getInstance().clear();
//
//		PhysicalProduct pp3 = BusinessObjectDAO.getInstance().read("physicalproduct4");
//		assertEquals(pp.getId().trim(), pp3.getId().trim());
//		assertEquals(pp.getStore().getId().trim(), pp.getStore().getId().trim());
//		assertEquals(pp.getSerialNumber(), pp3.getSerialNumber());
//		assertEquals(pp.getShelfLocation(), pp3.getShelfLocation());
//		assertEquals(SDF.format(pp.getDatePurchased()), SDF.format(pp3.getDatePurchased()));
//		assertTrue(pp.getCost() - pp3.getCost() < 0.1);		
//		assertEquals(pp.getStatus(), pp3.getStatus());
//		assertTrue(pp.getPhysicalProductCommissionRate() - pp3.getPhysicalProductCommissionRate() < 0.1);
//		assertEquals(pp.getPPType(), pp3.getPPType());
//
//		// test deleting
//		BusinessObjectDAO.getInstance().delete(pp);
//
//		// create another one with the same id (the other should be deleted)
//		PhysicalProduct pp4 = BusinessObjectDAO.getInstance().create("PhysicalProduct", "physicalproduct5");
//		Store s1 = BusinessObjectDAO.getInstance().read("store1");
//		pp4.setStore(s1);
//		pp4.setSerialNumber("F35JH2LG0KFJ2");
//		pp4.setShelfLocation("Down yonder");
//		pp4.setDatePurchased(new Date());
//		pp4.setCost(14.99);
//		pp4.setStatus("Sold");
//		pp4.setPhysicalProductCommissionRate(4.56);
//		pp4.setPPType("For Sale");
//		pp4.save();
//
//	}//TestPhysicalProduct
//
//
//
//	/** Test the Transaction1 BO */
//	@Test
//	public void TestTransaction() throws Exception {
//		Transaction1 trans = BusinessObjectDAO.getInstance().create("Transaction1", "trans4");
//		Customer cu = BusinessObjectDAO.getInstance().read("customer1");
//		Employee e = BusinessObjectDAO.getInstance().read("employee1");
//		Store s = BusinessObjectDAO.getInstance().read("store1");
//		Commission co = BusinessObjectDAO.getInstance().read("commission1");
//		JournalEntry je = BusinessObjectDAO.getInstance().read("journalentry1");
//		trans.setCustomer(cu);
//		trans.setEmployee(e);
//		trans.setStore(s);
//		trans.setCommission(co);
//		trans.setJournalEntry(je);
//		trans.setTransDate(new Date());
//		trans.setSubTotal(14.99);
//		trans.setTax(0.40);
//		trans.setTotal(15.39);		
//		trans.save();
//
//		// since product4 is in the Cache, this tests reading from the cache
//		Transaction1 trans2 = BusinessObjectDAO.getInstance().read("trans4");
//		assertSame(trans, trans2);
//
//		// now clear the cache (you'd never do this in the real world)
//		// then we can test reading from the database
//		Cache.getInstance().clear();
//
//		Transaction1 trans3 = BusinessObjectDAO.getInstance().read("trans4");
//		assertEquals(trans.getId().trim(), trans3.getId().trim());
//		assertEquals(trans.getCustomer().getId().trim(), trans3.getCustomer().getId().trim());
//		//assertEquals(trans.getEmployee().getId().trim(), trans3.getEmployee().getId().trim());
//		assertEquals(trans.getStore().getId().trim(), trans3.getStore().getId().trim());
//		assertEquals(trans.getCommission().getId().trim(), trans3.getCommission().getId().trim());
//		assertEquals(trans.getJournalEntry().getId().trim(), trans3.getJournalEntry().getId().trim());
//		assertEquals(SDF.format(trans.getTransDate()), SDF.format(trans3.getTransDate()));
//		assertTrue(trans.getSubTotal() - trans3.getSubTotal() < 0.1);
//		assertTrue(trans.getTax() - trans3.getTax() < 0.1);
//		assertTrue(trans.getTotal() - trans3.getTotal() < 0.1);
//
//		// test deleting
//		BusinessObjectDAO.getInstance().delete(trans);
//
//		// create another one with the same id (the other should be deleted)
//		Transaction1 trans4 = BusinessObjectDAO.getInstance().create("Transaction1", "trans5");
//		Customer cu1 = BusinessObjectDAO.getInstance().read("customer1");
//		Employee e1 = BusinessObjectDAO.getInstance().read("employee1");
//		Store s1 = BusinessObjectDAO.getInstance().read("store1");
//		Commission co1 = BusinessObjectDAO.getInstance().read("commission1");
//		JournalEntry je1 = BusinessObjectDAO.getInstance().read("journalentry1");
//		trans4.setCustomer(cu1);
//		trans4.setEmployee(e1);
//		trans4.setStore(s1);
//		trans4.setCommission(co1);
//		trans4.setJournalEntry(je1);
//		trans4.setTransDate(new Date());
//		trans4.setSubTotal(14.99);
//		trans4.setTax(0.40);
//		trans4.setTotal(15.39);		
//		trans4.save();
//
//	}//TestTransaction
//
//
//	/** Tests the 1-M relationship between Journal Entry and Debit Credit */
//	@Test
//	public void TestJournalEntryDebitCredit() throws Exception {
//
//		// this journal entry will have five debit credits
//		JournalEntry je = BusinessObjectDAO.getInstance().create("JournalEntry", "Orem Store");
//		je.setJeDate(new Date());
//		je.save();
//
//		// first debit/credit
//		DebitCredit dc1 = BusinessObjectDAO.getInstance().create("DebitCredit", "debitcreditA");
//		dc1.setJournalEntry(je);
//		dc1.setDebitCredit("Debit");
//		dc1.setGeneralLedgerName("Cash");
//		dc1.setAmount(4.50);
//		dc1.save();
//
//		// second debit/credit
//		DebitCredit dc2 = BusinessObjectDAO.getInstance().create("DebitCredit", "debitcreditB");
//		dc2.setJournalEntry(je);
//		dc2.setDebitCredit("Credit");
//		dc2.setGeneralLedgerName("Sales Revenue");
//		dc2.setAmount(4.00);
//		dc2.save();
//
//		// third debit/credit
//		DebitCredit dc3 = BusinessObjectDAO.getInstance().create("DebitCredit", "debitcreditC");
//		dc3.setJournalEntry(je);
//		dc3.setDebitCredit("Credit");
//		dc3.setGeneralLedgerName("Tax Payable");
//		dc3.setAmount(0.50);
//		dc3.save();
//
//		// fourth debit/credit
//		DebitCredit dc4 = BusinessObjectDAO.getInstance().create("DebitCredit", "debitcreditD");
//		dc4.setJournalEntry(je);
//		dc4.setDebitCredit("Credit");
//		dc4.setGeneralLedgerName("Commission Payable");
//		dc4.setAmount(5.00);
//		dc4.save();
//
//		// fifth debit/credit
//		DebitCredit dc5 = BusinessObjectDAO.getInstance().create("DebitCredit", "debitcreditE");
//		dc5.setJournalEntry(je);
//		dc5.setDebitCredit("Debit");
//		dc5.setGeneralLedgerName("Commission Expense");
//		dc5.setAmount(5.00);
//		dc5.save();
//
//		// retrieve the five debit/credits from the Journal Entry object
//		List<DebitCredit> debitcredits = je.getDebitCredits();
//		assertEquals(debitcredits.size(), 5);
//		System.out.println(debitcredits.get(0).getJournalEntry().getId()); //this works
//		assertSame(debitcredits.get(0).getJournalEntry(), je);
//		assertSame(debitcredits.get(1).getJournalEntry(), je);
//		assertSame(debitcredits.get(2).getJournalEntry(), je);
//		assertSame(debitcredits.get(3).getJournalEntry(), je);
//		assertSame(debitcredits.get(4).getJournalEntry(), je);
//	}//TestJournalEntryDebitCredit
//
//
//	/** Tests the 1-M relationship between Customer and Transaction */
//	@Test
//	public void TestCustomerTransaction() throws Exception {
//
//		// this customer will have three transactions
//		Customer cust = BusinessObjectDAO.getInstance().create("Customer", "Orem Store");
//		cust.setName("Bailey");
//		cust.setAddress("Tanner Building");
//		cust.setPhone("487-642-8479");
//		cust.setEmail("whatthecrap@danggirl.com");
//		cust.save();
//
//		// first transaction
//		Transaction1 trans1 = BusinessObjectDAO.getInstance().create("Transaction1", "transactionA");
//		trans1.setCustomer(cust);
//		trans1.setTransDate(new Date());
//		trans1.setSubTotal(9.00);
//		trans1.setTax(0.50);
//		trans1.setTotal(9.50);
//		trans1.save();
//
//		// second transaction
//		Transaction1 trans2 = BusinessObjectDAO.getInstance().create("Transaction1", "transactionB");
//		trans2.setCustomer(cust);
//		trans2.setTransDate(new Date());
//		trans2.setSubTotal(5.60);
//		trans2.setTax(0.50);
//		trans2.setTotal(6.10);
//		trans2.save();
//
//
//		// third transaction
//		Transaction1 trans3 = BusinessObjectDAO.getInstance().create("Transaction1", "transactionC");
//		trans3.setCustomer(cust);
//		trans3.setTransDate(new Date());
//		trans3.setSubTotal(15.00);
//		trans3.setTax(0.50);
//		trans3.setTotal(15.50);
//		trans3.save();
//
//
//		// retrieve the thre transactions from the customer object
//		List<Transaction1> transactions = cust.getTransactions();
//		assertEquals(transactions.size(), 3);
//		System.out.println(transactions.get(0).getCustomer().getId()); //this works
//		assertSame(transactions.get(0).getCustomer(), cust);
//		assertSame(transactions.get(1).getCustomer(), cust);
//		assertSame(transactions.get(2).getCustomer(), cust);
//	}//TestCustomerTransaction
//
//
//	/** Tests the 1-M relationship between Store and Transaction */
//	@Test
//	public void TestStoreTransaction() throws Exception {
//
//		// this store will have three transactions
//		Store store = BusinessObjectDAO.getInstance().create("Store", "Orem Store");
//		Employee emp = BusinessObjectDAO.getInstance().read("employee1");
//		store.setLocation("Over here!");
//		store.setManagerId("Me! Me!");
//		store.setAddress("In Orem somewhere");
//		store.setPhone("704-263-2589");
//		store.setSalesTaxRate(6.5);
//		store.setSubnetId("Something 32 bits long");
//		store.setManager(emp);
//		store.save();
//
//		// first transaction
//		Transaction1 trans1 = BusinessObjectDAO.getInstance().create("Transaction1", "transactionA");
//		trans1.setStore(store);
//		trans1.setTransDate(new Date());
//		trans1.setSubTotal(5.00);
//		trans1.setTax(1.50);
//		trans1.setTotal(6.50);
//		trans1.save();
//
//		// second transaction
//		Transaction1 trans2 = BusinessObjectDAO.getInstance().create("Transaction1", "transactionB");
//		trans2.setStore(store);
//		trans2.setTransDate(new Date());
//		trans2.setSubTotal(5.00);
//		trans2.setTax(2.50);
//		trans2.setTotal(7.50);
//		trans2.save();
//
//
//		// third transaction
//		Transaction1 trans3 = BusinessObjectDAO.getInstance().create("Transaction1", "transactionC");
//		trans3.setStore(store);
//		trans3.setTransDate(new Date());
//		trans3.setSubTotal(1.00);
//		trans3.setTax(0.50);
//		trans3.setTotal(1.50);
//		trans3.save();
//
//
//		// retrieve the thre transactions from the customer object
//		List<Transaction1> transactions = store.getTransactions();
//		assertEquals(transactions.size(), 3);
//		System.out.println(transactions.get(0).getStore().getId()); //this works
//		assertSame(transactions.get(0).getStore(), store);
//		assertSame(transactions.get(1).getStore(), store);
//		assertSame(transactions.get(2).getStore(), store);
//	}//TestStoreTransaction
//
//
//	/** Tests the 1-M relationship between Employee and Transaction */
//	@Test
//	public void TestEmployeeTransaction() throws Exception {
//
//		// this employee will have three transactions
//		Employee emp = BusinessObjectDAO.getInstance().create("Employee", "Sandy Store");
//		Store store = BusinessObjectDAO.getInstance().read("store1");
//		emp.setStore(store);
//		emp.setEmpName("Roy");
//		emp.setHireDate(new Date());
//		emp.setPhone("567-234-7890");
//		emp.setSalary(65432.10);
//		emp.setCommissionRate(6.5);
//		emp.setLoginName("RoyRoyRoyRoyHi");
//		emp.save();
//
//		// first transaction
//		Transaction1 trans1 = BusinessObjectDAO.getInstance().create("Transaction1", "transactionA");
//		trans1.setEmployee(emp);
//		trans1.setTransDate(new Date());
//		trans1.setSubTotal(4.10);
//		trans1.setTax(1.50);
//		trans1.setTotal(5.60);
//		trans1.save();
//
//		// second transaction
//		Transaction1 trans2 = BusinessObjectDAO.getInstance().create("Transaction1", "transactionB");
//		trans2.setEmployee(emp);
//		trans2.setTransDate(new Date());
//		trans2.setSubTotal(6.00);
//		trans2.setTax(2.50);
//		trans2.setTotal(8.50);
//		trans2.save();
//
//
//		// third transaction
//		Transaction1 trans3 = BusinessObjectDAO.getInstance().create("Transaction1", "transactionC");
//		trans3.setEmployee(emp);
//		trans3.setTransDate(new Date());
//		trans3.setSubTotal(1.00);
//		trans3.setTax(0.60);
//		trans3.setTotal(1.60);
//		trans3.save();
//
//
//		// retrieve the thre transactions from the customer object
//		List<Transaction1> transactions = emp.getTransactions();
//		assertEquals(transactions.size(), 3);
//		System.out.println(transactions.get(0).getEmployee().getId()); //this works
//		assertSame(transactions.get(0).getEmployee(), emp);
//		assertSame(transactions.get(1).getEmployee(), emp);
//		assertSame(transactions.get(2).getEmployee(), emp);
//	}//TestEmployeeTransaction
//
//
//
//	/** Tests the 1-M relationship between Employee and Commission */
//	@Test
//	public void TestEmployeeCommission() throws Exception {
//
//		// this employee will have three commissions
//		Employee emp = BusinessObjectDAO.getInstance().create("Employee", "employeeA");
//		Store store = BusinessObjectDAO.getInstance().read("store1");
//		emp.setStore(store);
//		emp.setEmpName("Chandler");
//		emp.setHireDate(new Date());
//		emp.setPhone("565-234-7889");
//		emp.setSalary(64412.10);
//		emp.setCommissionRate(18.6);
//		emp.setLoginName("Chabongo");
//		emp.save();
//
//		// first commission
//		Commission comm = BusinessObjectDAO.getInstance().create("Commission", "commissionA");
//		comm.setEmployee(emp);
//		comm.setAmount(300.00);
//		comm.setCommDate(new Date());
//		comm.save();
//
//		// second commission
//		Commission comm2 = BusinessObjectDAO.getInstance().create("Commission", "commissionB");
//		comm2.setEmployee(emp);
//		comm2.setAmount(700.00);
//		comm2.setCommDate(new Date());
//		comm2.save();
//
//		// third commission
//		Commission comm3 = BusinessObjectDAO.getInstance().create("Commission", "commissionC");
//		comm3.setEmployee(emp);
//		comm3.setAmount(100.00);
//		comm3.setCommDate(new Date());
//		comm3.save();
//
//
//		// retrieve the thre transactions from the customer object
//		List<Commission> commissions = emp.getCommissions();
//		assertEquals(commissions.size(), 3);
//		System.out.println(commissions.get(0).getEmployee().getId()); //this works
//		assertSame(commissions.get(0).getEmployee(), emp);
//		assertSame(commissions.get(1).getEmployee(), emp);
//		assertSame(commissions.get(2).getEmployee(), emp);
//	}//TestEmployeeCommission
//
//
//	/** Tests the 1-M relationship between Transaction and RevenueSource */
//	@Test
//	public void TestTransactionRevenueSource() throws Exception {
//
//		// this transaction will have three revenuesources (all sale in this case)
//		Transaction1 trans1 = BusinessObjectDAO.getInstance().create("Transaction1", "transactionA");
//		trans1.setTransDate(new Date());
//		trans1.setSubTotal(8.30);
//		trans1.setTax(1.50);
//		trans1.setTotal(9.80);
//		trans1.save();
//
//		// first revenuesource
//		RevenueSource rs = BusinessObjectDAO.getInstance().create("RevenueSource", "revsourceA");
//		rs.setTransaction(trans1);
//		rs.setChargeAmount(1.50);
//		rs.setRsType("Sale");
//		rs.save();
//
//		// second revenuesource
//		RevenueSource rs2 = BusinessObjectDAO.getInstance().create("RevenueSource", "revsourceB");
//		rs2.setTransaction(trans1);
//		rs2.setChargeAmount(5.50);
//		rs2.setRsType("Sale");
//		rs2.save();
//
//		// third revenuesource
//		RevenueSource rs3 = BusinessObjectDAO.getInstance().create("RevenueSource", "revsourceC");
//		rs3.setTransaction(trans1);
//		rs3.setChargeAmount(1.90);
//		rs3.setRsType("Sale");
//		rs3.save();
//
//
//		// retrieve the three revenuesources from the transaction object
//		List<RevenueSource> revenuesources = trans1.getRevenueSources();
//		assertEquals(revenuesources.size(), 3);
//		System.out.println(revenuesources.get(0).getTransaction().getId()); //this works
//		assertSame(revenuesources.get(0).getTransaction(), trans1);
//		assertSame(revenuesources.get(1).getTransaction(), trans1);
//		assertSame(revenuesources.get(2).getTransaction(), trans1);
//	}//TestTransactionRevenueSource
//
//
//
//	/** Tests the 1-M relationship between ConceptualProduct and PhysicalProduct */
//	@Test
//	public void TestConProdPhysProd() throws Exception {
//
//		// this conceptualproduct will have three physicalproducts
//		ConceptualProduct cp = BusinessObjectDAO.getInstance().create("ConceptualProduct", "cpA");
//		cp.setProductName("Cam-uh-ruh");
//		cp.setDescription("Take duh pictchuhs");
//		cp.setManufacturer("Cameras'R'Us");
//		cp.setAverageCost(156.03);
//		cp.setSku("Here is the sku");
//		cp.save();
//
//
//		// first physicalproduct
//		PhysicalProduct pp = BusinessObjectDAO.getInstance().create("PhysicalProduct", "physicalproductA");
//		Store store = BusinessObjectDAO.getInstance().read("store1");
//		pp.setStore(store);
//		pp.setConceptualProduct(cp);
//		pp.setSerialNumber("Insert number here");
//		pp.setShelfLocation("Aisle 6 Shelf 7");
//		pp.setDatePurchased(new Date());
//		pp.setCost(93.05);
//		pp.setStatus("What does this even mean??");
//		pp.setPhysicalProductCommissionRate(7.5);
//		pp.setPPType("For Sale");
//		pp.save();
//
//		// second physicalproduct
//		PhysicalProduct pp2 = BusinessObjectDAO.getInstance().create("PhysicalProduct", "physicalproductB");
//		Store store2 = BusinessObjectDAO.getInstance().read("store2");
//		pp2.setStore(store2);
//		pp2.setConceptualProduct(cp);
//		pp2.setSerialNumber("Insert number here 2");
//		pp2.setShelfLocation("Aisle 5 Shelf 2");
//		pp2.setDatePurchased(new Date());
//		pp2.setCost(93.05);
//		pp2.setStatus("What does this even mean??");
//		pp2.setPhysicalProductCommissionRate(8.4);
//		pp2.setPPType("For Sale");
//		pp2.save();
//
//		// third physicalproduct
//		PhysicalProduct pp3 = BusinessObjectDAO.getInstance().create("PhysicalProduct", "physicalproductC");
//		Store store3 = BusinessObjectDAO.getInstance().read("store3");
//		pp3.setStore(store3);
//		pp3.setConceptualProduct(cp);
//		pp3.setSerialNumber("Insert number here 3");
//		pp3.setShelfLocation("Aisle 1 Shelf 3");
//		pp3.setDatePurchased(new Date());
//		pp3.setCost(93.05);
//		pp3.setStatus("What does this even mean??");
//		pp3.setPhysicalProductCommissionRate(18.4);
//		pp3.setPPType("For Rent");
//		pp3.save();
//
//
//		// retrieve the three physicalproducts from the conceptualproduct object
//		List<PhysicalProduct> physicalproducts = cp.getPhysicalProducts();
//		assertEquals(physicalproducts.size(), 3);
//		System.out.println(physicalproducts.get(0).getConceptualProduct().getId()); //this works
//		assertSame(physicalproducts.get(0).getConceptualProduct(), cp);
//		assertSame(physicalproducts.get(1).getConceptualProduct(), cp);
//		assertSame(physicalproducts.get(2).getConceptualProduct(), cp);
//	}//TestConProdPhysProd
//
//
//	/** Tests the 1-M relationship between Store and PhysicalProduct */
//	@Test
//	public void TestStorePhysicalProduct() throws Exception {
//
//		// this store will have three physicalproducts
//		Store store = BusinessObjectDAO.getInstance().create("Store", "storeA");
//		Employee emp = BusinessObjectDAO.getInstance().read("employee1");
//		store.setManager(emp);
//		store.setLocation("Wheeeeee");
//		store.setManagerId("Matt");
//		store.setAddress("Some road here in Provo, 84606");
//		store.setPhone("713-285-1859");
//		store.setSalesTaxRate(3.50);
//		store.setSubnetId("152.643.23.3");
//		store.save();
//
//
//		// first physicalproduct
//		PhysicalProduct pp = BusinessObjectDAO.getInstance().create("PhysicalProduct", "ppA");
//		pp.setStore(store);
//		pp.setSerialNumber("Insert number here");
//		pp.setShelfLocation("Down the stairs, take a left");
//		pp.setDatePurchased(new Date());
//		pp.setCost(93.05);
//		pp.setStatus("What does this even mean??");
//		pp.setPhysicalProductCommissionRate(1.4);
//		pp.setPPType("For Sale");
//		pp.save();
//
//		// second physicalproduct
//		PhysicalProduct pp2 = BusinessObjectDAO.getInstance().create("PhysicalProduct", "ppB");
//		pp2.setStore(store);
//		pp2.setSerialNumber("Insert serial stuff here");
//		pp2.setShelfLocation("Down the hall, take a right");
//		pp2.setDatePurchased(new Date());
//		pp2.setCost(93.05);
//		pp2.setStatus("What does this even mean??");
//		pp2.setPhysicalProductCommissionRate(8.9);
//		pp2.setPPType("For Rent");
//		pp2.save();
//
//		// third physicalproduct
//		PhysicalProduct pp3 = BusinessObjectDAO.getInstance().create("PhysicalProduct", "ppC");
//		pp3.setStore(store);
//		pp3.setSerialNumber("Insert here");
//		pp3.setShelfLocation("Down the hall, take a left");
//		pp3.setDatePurchased(new Date());
//		pp3.setCost(93.05);
//		pp3.setStatus("What does this even mean??");
//		pp3.setPhysicalProductCommissionRate(8.4);
//		pp3.setPPType("For Sale");
//		pp3.save();
//
//
//		// retrieve the three physicalproducts from the store object
//		List<PhysicalProduct> physicalproducts = store.getPhysicalProducts();
//		assertEquals(physicalproducts.size(), 3);
//		System.out.println(physicalproducts.get(0).getStore().getId()); //this works
//		assertSame(physicalproducts.get(0).getStore(), store);
//		assertSame(physicalproducts.get(1).getStore(), store);
//		assertSame(physicalproducts.get(2).getStore(), store);
//	}//TestStorePhysicalProduct
//
//
//	/** Tests the 1-M relationship between Product and Sale */
//	@Test
//	public void TestProductSale() throws Exception {
//
//		// this Product will have three sales
//		Product prod = BusinessObjectDAO.getInstance().create("Product", "productA");
//		prod.setPrice(6.75);
//		prod.setProdType("Physical");
//		prod.save();
//
//
//		// first sale
//		Sale sale = BusinessObjectDAO.getInstance().create("Sale", "saleA");
//		sale.setProduct(prod);
//		sale.setQuantity(45);
//		sale.setSaleType("In Store");
//		sale.save();
//
//		// second sale
//		Sale sale2 = BusinessObjectDAO.getInstance().create("Sale", "saleB");
//		sale2.setProduct(prod);
//		sale2.setQuantity(83);
//		sale2.setSaleType("Online");
//		sale2.save();
//
//		// third sale
//		Sale sale3 = BusinessObjectDAO.getInstance().create("Sale", "saleC");
//		sale3.setProduct(prod);
//		sale3.setQuantity(91);
//		sale3.setSaleType("In Store");
//		sale3.save();
//
//
//		// retrieve the three sales from the physicalproduct object
//		List<Sale> sales = prod.getSales();
//		assertEquals(sales.size(), 3);
//		System.out.println(sales.get(0).getProduct().getId()); //this works
//		assertSame(sales.get(0).getProduct(), prod);
//		assertSame(sales.get(1).getProduct(), prod);
//		assertSame(sales.get(2).getProduct(), prod);
//
//	}//TestProductSale
//
//
//
//	/** Test the GeneralLedger BO */
//	@Test
//	public void TestGeneralLedger() throws Exception {
//		GeneralLedger gl = BusinessObjectDAO.getInstance().create("GeneralLedger", "generalledger12");
//		gl.setAccountName("Extra Cash");
//		gl.setBalance(670.00);
//		gl.setGlType("Asset");
//		gl.save();
//
//		// since generalledger is in the Cache, this tests reading from the cache
//		GeneralLedger gl2 = BusinessObjectDAO.getInstance().read("generalledger12");
//		assertSame(gl, gl2);
//
//		// now clear the cache (you'd never do this in the real world)
//		// then we can test reading from the database
//		Cache.getInstance().clear();
//
//		GeneralLedger gl3 = BusinessObjectDAO.getInstance().read("generalledger12");
//		assertEquals(gl.getId().trim(), gl3.getId().trim());
//		assertEquals(gl.getAccountName(), gl3.getAccountName());
//		assertTrue(gl.getBalance() - gl3.getBalance() < 0.1);
//		assertEquals(gl.getGlType(), gl3.getGlType());
//
//		// test deleting
//		BusinessObjectDAO.getInstance().delete(gl);
//
//		// create another one with the same id (the other should be deleted)
//		GeneralLedger gl4 = BusinessObjectDAO.getInstance().create("GeneralLedger", "generalledger13");
//		gl4.setAccountName("Extra Cash");
//		gl4.setBalance(670.00);
//		gl4.setGlType("Asset");
//		gl4.save();
//
//	}//TestGeneralLedger
//
//
//	/** Test the Rental BO */
//	@Test
//	public void TestRental() throws Exception {
//		Rental rental = BusinessObjectDAO.getInstance().create("Rental", "rental4");
//		ForRent fr = BusinessObjectDAO.getInstance().read("forrent1");
//		rental.setForRent(fr);
//		rental.setDateOut(new Date());
//		rental.setDateDue(new Date());
//		rental.setDateIn(new Date());
//		rental.setReminderSent("No");
//		rental.save();
//
//		// since rental is in the Cache, this tests reading from the cache
//		Rental rental2 = BusinessObjectDAO.getInstance().read("rental4");
//		assertSame(rental, rental2);
//
//		// now clear the cache (you'd never do this in the real world)
//		// then we can test reading from the database
//		Cache.getInstance().clear();
//
//		Rental rental3 = BusinessObjectDAO.getInstance().read("rental4");
//		assertEquals(rental.getId().trim(), rental3.getId().trim());
//		assertEquals(SDF.format(rental.getDateOut()), SDF.format(rental3.getDateOut()));
//		assertEquals(SDF.format(rental.getDateDue()), SDF.format(rental3.getDateDue()));
//		assertEquals(SDF.format(rental.getDateIn()), SDF.format(rental3.getDateIn()));
//		assertEquals(rental.getReminderSent(), rental3.getReminderSent());
//		assertEquals(rental.getForRent().getId().trim(), rental3.getForRent().getId().trim());
//
//		// test deleting
//		BusinessObjectDAO.getInstance().delete(rental);
//
//		// create another one with the same id (the other should be deleted)
//		Rental rental4 = BusinessObjectDAO.getInstance().create("Rental", "rental5");
//		ForRent fr2 = BusinessObjectDAO.getInstance().read("forrent1");
//		rental4.setForRent(fr2);
//		rental4.setDateOut(new Date());
//		rental4.setDateDue(new Date());
//		rental4.setDateIn(new Date());
//		rental4.setReminderSent("No");
//		rental4.save();
//
//	}//TestRental
//
//
//
//	/** Test the Fee BO */
//	@Test
//	public void TestFee() throws Exception {
//		Fee fee = BusinessObjectDAO.getInstance().create("Fee", "fee4");
//		Rental rental = BusinessObjectDAO.getInstance().read("rental1");
//		fee.setRental(rental);
//		fee.setAmount(10.00);
//		fee.save();
//
//		// since rental is in the Cache, this tests reading from the cache
//		Fee fee2 = BusinessObjectDAO.getInstance().read("fee4");
//		assertSame(fee, fee2);
//
//		// now clear the cache (you'd never do this in the real world)
//		// then we can test reading from the database
//		Cache.getInstance().clear();
//
//		Fee fee3 = BusinessObjectDAO.getInstance().read("fee4");
//		assertEquals(fee.getId().trim(), fee3.getId().trim());
//		assertEquals(fee.getRental().getId().trim(), fee3.getRental().getId().trim());
//		assertTrue(fee.getAmount() - fee3.getAmount() < 0.1);
//
//		// test deleting
//		BusinessObjectDAO.getInstance().delete(fee);
//
//		// create another one with the same id (the other should be deleted)
//		Fee fee4 = BusinessObjectDAO.getInstance().create("Fee", "fee5");
//		Rental rental2 = BusinessObjectDAO.getInstance().read("rental1");
//		fee4.setRental(rental2);
//		fee4.setAmount(10.00);
//		fee4.save();
//
//	}//TestFee
//
//
//	/** Test the ForRent BO */
//	@Test
//	public void TestForRent() throws Exception {
//		ForRent fr = BusinessObjectDAO.getInstance().create("ForRent", "fr4");
//		Rental rental = BusinessObjectDAO.getInstance().read("rental1");
//		fr.setTimesRented(7);
//		fr.setRental(rental);
//		fr.save();
//
//		// since rental is in the Cache, this tests reading from the cache
//		ForRent fr2 = BusinessObjectDAO.getInstance().read("fr4");
//		assertSame(fr, fr2);
//
//		// now clear the cache (you'd never do this in the real world)
//		// then we can test reading from the database
//		Cache.getInstance().clear();
//
//		ForRent fr3 = BusinessObjectDAO.getInstance().read("fr4");
//		assertEquals(fr.getId().trim(), fr3.getId().trim());
//		assertEquals(fr.getTimesRented(), fr3.getTimesRented());
//		assertEquals(fr.getRental().getId().trim(), fr3.getRental().getId().trim());
//
//
//		// test deleting
//		BusinessObjectDAO.getInstance().delete(fr);
//
//		// create another one with the same id (the other should be deleted)
//		ForRent fr4 = BusinessObjectDAO.getInstance().create("ForRent", "fr5");
//		Rental rental4 = BusinessObjectDAO.getInstance().read("rental1");
//		fr4.setTimesRented(7);
//		fr4.setRental(rental4);
//		fr4.save();
//
//	}//TestForRent
//
//
//	//	/** Tests the 1-M relationship between Rental and Fee */
//	@Test
//	public void TestRentalFee() throws Exception {
//
//		// this Rental will have three fees
//		Rental rental = BusinessObjectDAO.getInstance().create("Rental", "rentalA");
//		ForRent fr = BusinessObjectDAO.getInstance().read("forrent1");
//		rental.setForRent(fr);
//		rental.setDateOut(new Date());
//		rental.setDateDue(new Date());
//		rental.setDateIn(new Date());
//		rental.setReminderSent("No");
//		rental.save();
//
//
//		// first fee
//		Fee fee = BusinessObjectDAO.getInstance().create("Fee", "feeA");
//		fee.setRental(rental);
//		fee.setAmount(10.00);
//		fee.save();
//
//		// second fee
//		Fee fee2 = BusinessObjectDAO.getInstance().create("Fee", "feeB");
//		fee2.setRental(rental);
//		fee2.setAmount(10.00);
//		fee2.save();
//
//		// third fee
//		Fee fee3 = BusinessObjectDAO.getInstance().create("Fee", "feeC");
//		fee3.setRental(rental);
//		fee3.setAmount(10.00);
//		fee3.save();
//
//
//		// retrieve the three fee from the rental object
//		List<Fee> fees = rental.getFees();
//		assertEquals(fees.size(), 3);
//		System.out.println(fees.get(0).getRental().getId()); //this works
//		assertSame(fees.get(0).getRental(), rental);
//		assertSame(fees.get(1).getRental(), rental);
//		assertSame(fees.get(2).getRental(), rental);
//	}//TestRentalFee
//
//
//	/** Tests the 1-M relationship between ForRent and Rental */
//	@Test
//	public void TestForRentRental() throws Exception {
//
//		// this ForRent will have three rentals
//		ForRent fr = BusinessObjectDAO.getInstance().create("ForRent", "frA");
//		fr.setTimesRented(7);
//		fr.save();
//
//
//		// first rental
//		Rental rental = BusinessObjectDAO.getInstance().create("Rental", "rentalA");
//		rental.setForRent(fr);
//		rental.setDateOut(new Date());
//		rental.setDateDue(new Date());
//		rental.setDateIn(new Date());
//		rental.setReminderSent("Yes");
//		rental.save();
//
//
//		// second rental
//		Rental rental2 = BusinessObjectDAO.getInstance().create("Rental", "rentalB");
//		rental2.setForRent(fr);
//		rental2.setDateOut(new Date());
//		rental2.setDateDue(new Date());
//		rental2.setDateIn(new Date());
//		rental2.setReminderSent("No");
//		rental2.save();
//
//
//		// third rental
//		Rental rental3 = BusinessObjectDAO.getInstance().create("Rental", "rentalC");
//		rental3.setForRent(fr);
//		rental3.setDateOut(new Date());
//		rental3.setDateDue(new Date());
//		rental3.setDateIn(new Date());
//		rental3.setReminderSent("Yes");
//		rental3.save();
//
//
//		// retrieve the three rentals from the forrent object
//		List<Rental> rentals = fr.getRentals();
//		assertEquals(rentals.size(), 3);
//		System.out.println(rentals.get(0).getForRent().getId()); //this works
//		assertSame(rentals.get(0).getForRent(), fr);
//		assertSame(rentals.get(1).getForRent(), fr);
//		assertSame(rentals.get(2).getForRent(), fr);
//	}//TestForRentRental
//
//
//	/** Test the ForSale BO */
//	@Test
//	public void TestForSale() throws Exception {
//		ForSale fs = BusinessObjectDAO.getInstance().create("ForSale", "fs4");
//		fs.setNewOrUsed("New");
//		fs.save();
//
//		// since rental is in the Cache, this tests reading from the cache
//		ForSale fs2 = BusinessObjectDAO.getInstance().read("fs4");
//		assertSame(fs, fs2);
//
//		// now clear the cache (you'd never do this in the real world)
//		// then we can test reading from the database
//		Cache.getInstance().clear();
//
//		ForSale fs3 = BusinessObjectDAO.getInstance().read("fs4");
//		assertEquals(fs.getId().trim(), fs3.getId().trim());
//		assertEquals(fs.getNewOrUsed(), fs3.getNewOrUsed());
//
//
//		// test deleting
//		BusinessObjectDAO.getInstance().delete(fs);
//
//		// create another one with the same id (the other should be deleted)
//		ForSale fs4 = BusinessObjectDAO.getInstance().create("ForSale", "fs5");
//		fs4.setNewOrUsed("New");
//		fs4.save();
//
//	}//TestForSale
//
//
//	/** Test the Payment BO */
//	@Test
//	public void TestPayment() throws Exception {
//		Payment pay = BusinessObjectDAO.getInstance().create("Payment", "pay4");
//		pay.setAmount(40.00);
//		pay.setPaymentChange(5.00);
//		pay.setPaymentType("Cash");
//		pay.save();
//
//		// since rental is in the Cache, this tests reading from the cache
//		Payment pay2 = BusinessObjectDAO.getInstance().read("pay4");
//		assertSame(pay, pay2);
//
//		// now clear the cache (you'd never do this in the real world)
//		// then we can test reading from the database
//		Cache.getInstance().clear();
//
//		Payment pay3 = BusinessObjectDAO.getInstance().read("pay4");
//		assertEquals(pay.getId().trim(), pay3.getId().trim());
//		assertTrue(pay.getAmount() - pay3.getAmount() < 0.1);
//		assertTrue(pay.getPaymentChange() - pay3.getPaymentChange() < 0.1);
//		assertEquals(pay.getPaymentType(), pay3.getPaymentType());
//
//		// test deleting
//		BusinessObjectDAO.getInstance().delete(pay);
//
//		// create another one with the same id (the other should be deleted)
//		Payment pay4 = BusinessObjectDAO.getInstance().create("Payment", "pay5");
//		pay4.setAmount(40.00);
//		pay4.setPaymentChange(5.00);
//		pay4.setPaymentType("Cash");
//		pay4.save();
//
//	}//TestPayment	
//
//
//	/** Test the Membership BO */
//	@Test
//	public void TestMembership() throws Exception {
//		Membership m = BusinessObjectDAO.getInstance().create("Membership", "m4");
//		m.setCreditCard("7492740265916385");
//		m.save();
//
//		// since rental is in the Cache, this tests reading from the cache
//		Membership m2 = BusinessObjectDAO.getInstance().read("m4");
//		assertSame(m, m2);
//
//		// now clear the cache (you'd never do this in the real world)
//		// then we can test reading from the database
//		Cache.getInstance().clear();
//
//		Membership m3 = BusinessObjectDAO.getInstance().read("m4");
//		assertEquals(m.getId().trim(), m3.getId().trim());
//		assertEquals(m.getCreditCard(), m3.getCreditCard());
//
//		// test deleting
//		BusinessObjectDAO.getInstance().delete(m);
//
//		// create another one with the same id (the other should be deleted)
//		Membership m4 = BusinessObjectDAO.getInstance().create("Membership", "m5");
//		m4.setCreditCard("7492740265916385");
//		m4.save();
//
//	}//TestMembership
//
//
//	/** Test the ConceptualRental BO */
//	@Test
//	public void TestConceptualRental() throws Exception {
//		ConceptualRental cr = BusinessObjectDAO.getInstance().create("ConceptualRental", "cr4");
//		cr.setPricePerDay(1.10);
//		cr.setReplacementPrice(30.00);
//		cr.save();
//
//		// since rental is in the Cache, this tests reading from the cache
//		ConceptualRental cr2 = BusinessObjectDAO.getInstance().read("cr4");
//		assertSame(cr, cr2);
//
//		// now clear the cache (you'd never do this in the real world)
//		// then we can test reading from the database
//		Cache.getInstance().clear();
//
//		ConceptualRental cr3 = BusinessObjectDAO.getInstance().read("cr4");
//		assertEquals(cr.getId().trim(), cr3.getId().trim());
//		assertTrue(cr.getPricePerDay() - cr3.getPricePerDay() < 0.1);
//		assertTrue(cr.getReplacementPrice() - cr3.getReplacementPrice() < 0.1);
//
//		// test deleting
//		BusinessObjectDAO.getInstance().delete(cr);
//
//		// create another one with the same id (the other should be deleted)
//		ConceptualRental cr4 = BusinessObjectDAO.getInstance().create("ConceptualRental", "cr5");
//		cr4.setPricePerDay(1.10);
//		cr4.setReplacementPrice(30.00);
//		cr4.save();
//
//	}//TestConceptualRental
//
//
//	/** Test the Late BO */
//	@Test
//	public void TestLate() throws Exception {
//		Late late = BusinessObjectDAO.getInstance().create("Late", "late4");
//		late.setDaysLate(5);
//		late.save();
//
//		// since rental is in the Cache, this tests reading from the cache
//		Late late2 = BusinessObjectDAO.getInstance().read("late4");
//		assertSame(late, late2);
//
//		// now clear the cache (you'd never do this in the real world)
//		// then we can test reading from the database
//		Cache.getInstance().clear();
//
//		Late late3 = BusinessObjectDAO.getInstance().read("late4");
//		assertEquals(late.getId().trim(), late3.getId().trim());
//		assertEquals(late.getDaysLate(), late3.getDaysLate());
//
//		// test deleting
//		BusinessObjectDAO.getInstance().delete(late);
//
//		// create another one with the same id (the other should be deleted)
//		Late late4 = BusinessObjectDAO.getInstance().create("Late", "late5");
//		late4.setDaysLate(5);
//		late4.save();
//
//	}//TestLate


}