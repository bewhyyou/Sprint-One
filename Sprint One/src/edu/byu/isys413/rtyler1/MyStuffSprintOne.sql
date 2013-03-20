-- Note that comment lines need to end with a semicolon for CreateDB.java to work;

-- The primary keys (id) should really be CHAR(40), not VARCHAR(40), but;
-- to make life easier in testing, I've placed them as VARCHAR(40) for now;

-- First drop everything (order matters here for foreign keys!);

SET FOREIGN_KEY_CHECKS = 0;

--DROP TABLE IF EXISTS rental;
--DROP TABLE IF EXISTS forsale;
--DROP TABLE IF EXISTS forrent;
--DROP TABLE IF EXISTS transaction;
--DROP TABLE IF EXISTS payment;
--DROP TABLE IF EXISTS checks;
--DROP TABLE IF EXISTS personcar;
--DROP TABLE IF EXISTS car;
--DROP TABLE IF EXISTS dog;
--DROP TABLE IF EXISTS commission;
--DROP TABLE IF EXISTS employee;
--DROP TABLE IF EXISTS membership;
--DROP TABLE IF EXISTS customer;
--DROP TABLE IF EXISTS person;
--DROP TABLE IF EXISTS sale;
--DROP TABLE IF EXISTS revenuesource;
--DROP TABLE IF EXISTS physicalproduct;
--DROP TABLE IF EXISTS storeproduct;
--DROP TABLE IF EXISTS conceptualproduct;
--DROP TABLE IF EXISTS product;
--DROP TABLE IF EXISTS computer;
--DROP TABLE IF EXISTS store;
--DROP TABLE IF EXISTS debitcredit;
--DROP TABLE IF EXISTS journalentry;
--DROP TABLE IF EXISTS updategl;
--DROP TABLE IF EXISTS generalledger;
--DROP TABLE IF EXISTS businessobject;


DROP TABLE IF EXISTS generalledger;

--alter table rental;
--drop column id;

DROP TABLE IF EXISTS instore;
DROP TABLE IF EXISTS online;
DROP TABLE IF EXISTS late;
DROP TABLE IF EXISTS fee;
DROP TABLE IF EXISTS sale; --references product, revenuesource;
DROP TABLE IF EXISTS rental; --references revenuesource, forrent;
DROP TABLE IF EXISTS revenuesource; --references transaction;
DROP TABLE IF EXISTS transaction1; --references customer, employee, store, commission, journalentry, payment;

DROP TABLE IF EXISTS customer; --references membership;
DROP TABLE IF EXISTS membership;

DROP TABLE IF EXISTS debitcredit; --references journalentry;
DROP TABLE IF EXISTS journalentry; --no references;

DROP TABLE IF EXISTS payment; --no references;
DROP TABLE IF EXISTS computer; --references store;
DROP TABLE IF EXISTS commission; --references employee;
DROP TABLE IF EXISTS storeproduct; --references store, conceptualproduct;
DROP TABLE IF EXISTS forsale; --references physicalproduct;
DROP TABLE IF EXISTS forrent; --references physicalproduct;
DROP TABLE IF EXISTS conceptualrental; --references conceptualproduct;
DROP TABLE IF EXISTS physicalproduct; --references store, conceptualproduct;
DROP TABLE IF EXISTS conceptualproduct; --no references;
DROP TABLE IF EXISTS product; --no references;

--alter table store;
--drop column empid;

DROP TABLE IF EXISTS employee; --references store;
DROP TABLE IF EXISTS store; --references employee;

DROP TABLE IF EXISTS businessobject; --everything references this, so it must be dropped last;


-- businessobject TABLE (everything extends this);
CREATE TABLE businessobject (
  id           VARCHAR(40) PRIMARY KEY,
  botype       VARCHAR(250)
);


--GENERAL LEDGER TABLE;
CREATE TABLE generalledger (
  id		VARCHAR(40) PRIMARY KEY REFERENCES businessobject(id),
  accountname VARCHAR(40),
  balance	double,
  gltype	VARCHAR(40)
);
INSERT INTO businessobject(id, botype) VALUES ('generalledger1', 'edu.byu.isys413.rtyler1.GeneralLedger'); --generalledger1 business object;
INSERT INTO generalledger(id, accountname, balance, gltype) VALUES ('generalledger1', 'Cash', 1680.00, 'Asset'); --generalledger1 GeneralLedger object;
INSERT INTO businessobject(id, botype) VALUES ('generalledger2', 'edu.byu.isys413.rtyler1.GeneralLedger'); --generalledger2 business object;
INSERT INTO generalledger(id, accountname, balance, gltype) VALUES ('generalledger2', 'Sales Revenue', 1480.00, 'Asset'); --generalledger2 GeneralLedger object;
INSERT INTO businessobject(id, botype) VALUES ('generalledger3', 'edu.byu.isys413.rtyler1.GeneralLedger'); --generalledger3 business object;
INSERT INTO generalledger(id, accountname, balance, gltype) VALUES ('generalledger3', 'Tax Payable', 200.00, 'Liability'); --generalledger3 GeneralLedger object;
INSERT INTO businessobject(id, botype) VALUES ('generalledger4', 'edu.byu.isys413.rtyler1.GeneralLedger'); --generalledger4 business object;
INSERT INTO generalledger(id, accountname, balance, gltype) VALUES ('generalledger4', 'Commission Payable', 700.00, 'Liability'); --generalledger4 GeneralLedger object;
INSERT INTO businessobject(id, botype) VALUES ('generalledger5', 'edu.byu.isys413.rtyler1.GeneralLedger'); --generalledger5 business object;
INSERT INTO generalledger(id, accountname, balance, gltype) VALUES ('generalledger5', 'Commission Expense', 700.00, 'Owners Equity'); --generalledger5 GeneralLedger object;


--MEMBERSHIP TABLE;
CREATE TABLE membership (
	id			VARCHAR(40) PRIMARY KEY REFERENCES businessobject(id),
	creditcard  VARCHAR(40)
);
INSERT INTO businessobject(id, botype) VALUES ('membership1', 'edu.byu.isys413.rtyler1.Membership'); --creditcard1 business object;
INSERT INTO membership(id, creditcard) VALUES ('membership1', '4573957309755555'); --creditcard1 creditcard object;
INSERT INTO businessobject(id, botype) VALUES ('membership2', 'edu.byu.isys413.rtyler1.Membership'); --creditcard2 business object;
INSERT INTO membership(id, creditcard) VALUES ('membership2', '4573957309755556'); --creditcard2 creditcard object;
INSERT INTO businessobject(id, botype) VALUES ('membership3', 'edu.byu.isys413.rtyler1.Membership'); --creditcard3 business object;
INSERT INTO membership(id, creditcard) VALUES ('membership3', '4573957309755557'); --creditcard3 creditcard object;

--CUSTOMER TABLE;
CREATE TABLE customer (
  id             VARCHAR(40) PRIMARY KEY REFERENCES businessobject(id),
  membershipid   VARCHAR(40) REFERENCES membership(id),
  name			 VARCHAR(40),
  phone			 VARCHAR(40),
  email			 VARCHAR(50),
  billingaddress VARCHAR(350),
  shippingaddress VARCHAR(350),
  password		 VARCHAR(50),
  validationcode VARCHAR(50),
  validated		 boolean
);
INSERT INTO businessobject(id, botype) VALUES ('customer1', 'edu.byu.isys413.rtyler1.Customer'); --customer1 business object;
INSERT INTO customer(id, membershipid, name, phone, email, billingaddress, shippingaddress, password, validationcode, validated) VALUES ('customer1', 'membership1', 'Kaylie', '801-345-6784', 'thatsall@awesomeness.com', '23 ThisRoad Street, Logan, UT 84003', '23 ThisRoad Street, Logan, UT 84003', 'YoMama', 'validationcode1', false); --customer1 customer object;
INSERT INTO businessobject(id, botype) VALUES ('customer2', 'edu.byu.isys413.rtyler1.Customer'); --customer2 business object;
INSERT INTO customer(id, membershipid, name, phone, email, billingaddress, shippingaddress, password, validationcode, validated) VALUES ('customer2', 'membership2', 'Kate', '801-835-2578', 'ilovecats@meow.com', '523 OverThat Way, Provo, UT 84606', '345 Down Yonder, Orem, UT 84606', 'Passwordddd', 'validationcode2', true); --customer2 customer object;
INSERT INTO businessobject(id, botype) VALUES ('customer3', 'edu.byu.isys413.rtyler1.Customer'); --customer3 business object;
INSERT INTO customer(id, membershipid, name, phone, email, billingaddress, shippingaddress, password, validationcode, validated) VALUES ('customer3', 'membership3', 'Dixon', '801-321-3469', 'herpderp@memelover.com', '523 DownYonder Circle, Park City, UT 84612', '523 DownYonder Circle, Park City, UT 84612', 'Thisorthat', 'validationcode3', true); --customer3 customer object;
INSERT INTO businessobject(id, botype) VALUES ('customer4', 'edu.byu.isys413.rtyler1.Customer'); --customer4 business object;
INSERT INTO customer(id, membershipid, name, phone, email, billingaddress, shippingaddress, password, validationcode, validated) VALUES ('customer4', 'membership3', 'Becca', '801-321-3469', 'ilovejoe@gmail.com', '50 West Temple, Salt Lake City, UT 84003', '50 West Temple, Salt Lake City, UT 84003', 'august17', 'validationcode4', true); --customer3 customer object;



-- PRODUCT TABLE;
CREATE TABLE product (
  id           VARCHAR(40) PRIMARY KEY REFERENCES businessobject(id),
  price		   double,
  prodtype	   VARCHAR(40)
);
INSERT INTO businessobject(id, botype) VALUES ('product1', 'edu.byu.isys413.rtyler1.Product'); -- product1 Business Object;
INSERT INTO product(id, price, prodtype) VALUES ('product1', 42.65, 'Physical'); -- product1 Product Object;
INSERT INTO businessobject(id, botype) VALUES ('product2', 'edu.byu.isys413.rtyler1.Product'); -- product2 Business Object;
INSERT INTO product(id, price, prodtype) VALUES ('product2', 12.14, 'Conceptual'); -- product2 Product Object;
INSERT INTO businessobject(id, botype) VALUES ('product3', 'edu.byu.isys413.rtyler1.Product'); -- product3 Business Object;
INSERT INTO product(id, price, prodtype) VALUES ('product3', 25.61, 'Physical'); -- product3 Product Object;


--JOURNALENTRY TABLE;
CREATE TABLE journalentry (
  id             VARCHAR(40) PRIMARY KEY REFERENCES businessobject(id),
  jedate		 date
);
INSERT INTO businessobject(id, botype) VALUES ('journalentry1', 'edu.byu.isys413.rtyler1.JournalEntry'); --journalentry1 Business Object;
INSERT INTO journalentry(id, jedate) VALUES ('journalentry1', '2012-01-23 13:12:31.523'); --journalentry1 Journal Entry Object;
INSERT INTO businessobject(id, botype) VALUES ('journalentry2', 'edu.byu.isys413.rtyler1.JournalEntry'); --journalentry2 Business Object;
INSERT INTO journalentry(id, jedate) VALUES ('journalentry2', '2012-01-24 16:23:30.264'); --journalentry2 Journal Entry Object;
INSERT INTO businessobject(id, botype) VALUES ('journalentry3', 'edu.byu.isys413.rtyler1.JournalEntry'); --journalentry3 Business Object;
INSERT INTO journalentry(id, jedate) VALUES ('journalentry3', '2012-01-24 16:23:30.264'); --journalentry3 Journal Entry Object;



--DEBITCREDIT TABLE;
CREATE TABLE debitcredit (
  id             		VARCHAR(40) PRIMARY KEY REFERENCES businessobject(id),
  jeid			 		VARCHAR(40) REFERENCES journalentry(id),
  debitcredit			VARCHAR(40),
  generalledgername		VARCHAR(40),
  amount				double
);
INSERT INTO businessobject(id, botype) VALUES ('debitcredit1', 'edu.byu.isys413.rtyler1.DebitCredit'); --debitcredit1 Business Object;
INSERT INTO debitcredit(id, jeid, debitcredit, generalledgername, amount) VALUES ('debitcredit1', 'journalentry1', 'debit', 'Cash', 12.45); --debitcredit1 Debit Credit Object;
INSERT INTO businessobject(id, botype) VALUES ('debitcredit2', 'edu.byu.isys413.rtyler1.DebitCredit'); --debitcredit2 Business Object;
INSERT INTO debitcredit(id, jeid, debitcredit, generalledgername, amount) VALUES ('debitcredit2', 'journalentry1', 'credit', 'Sales Revenue', 11.00); --debitcredit2 Debit Credit Object;
INSERT INTO businessobject(id, botype) VALUES ('debitcredit3', 'edu.byu.isys413.rtyler1.DebitCredit'); --debitcredit3 Business Object;
INSERT INTO debitcredit(id, jeid, debitcredit, generalledgername, amount) VALUES ('debitcredit3', 'journalentry1', 'credit', 'Tax Payable', 1.45); --debitcredit3 Debit Credit Object;
INSERT INTO businessobject(id, botype) VALUES ('debitcredit4', 'edu.byu.isys413.rtyler1.DebitCredit'); --debitcredit4 Business Object;
INSERT INTO debitcredit(id, jeid, debitcredit, generalledgername, amount) VALUES ('debitcredit4', 'journalentry1', 'credit', 'Commission Payable', 10.00); --debitcredit4 Debit Credit Object;
INSERT INTO businessobject(id, botype) VALUES ('debitcredit5', 'edu.byu.isys413.rtyler1.DebitCredit'); --debitcredit5 Business Object;
INSERT INTO debitcredit(id, jeid, debitcredit, generalledgername, amount) VALUES ('debitcredit5', 'journalentry1', 'debit', 'Commission Expense', 10.00); --debitcredit5 Debit Credit Object;

INSERT INTO businessobject(id, botype) VALUES ('debitcredit6', 'edu.byu.isys413.rtyler1.DebitCredit'); --debitcredit6 Business Object;
INSERT INTO debitcredit(id, jeid, debitcredit, generalledgername, amount) VALUES ('debitcredit6', 'journalentry2', 'debit', 'Cash', 11.00); --debitcredit6 Debit Credit Object;
INSERT INTO businessobject(id, botype) VALUES ('debitcredit7', 'edu.byu.isys413.rtyler1.DebitCredit'); --debitcredit7 Business Object;
INSERT INTO debitcredit(id, jeid, debitcredit, generalledgername, amount) VALUES ('debitcredit7', 'journalentry2', 'credit', 'Sales Revenue', 10.00); --debitcredit7 Debit Credit Object;
INSERT INTO businessobject(id, botype) VALUES ('debitcredit8', 'edu.byu.isys413.rtyler1.DebitCredit'); --debitcredit8 Business Object;
INSERT INTO debitcredit(id, jeid, debitcredit, generalledgername, amount) VALUES ('debitcredit8', 'journalentry2', 'credit', 'Tax Payable', 1.00); --debitcredit8 Debit Credit Object;
INSERT INTO businessobject(id, botype) VALUES ('debitcredit9', 'edu.byu.isys413.rtyler1.DebitCredit'); --debitcredit9 Business Object;
INSERT INTO debitcredit(id, jeid, debitcredit, generalledgername, amount) VALUES ('debitcredit9', 'journalentry2', 'credit', 'Commission Payable', 12.00); --debitcredit9 Debit Credit Object;
INSERT INTO businessobject(id, botype) VALUES ('debitcredit10', 'edu.byu.isys413.rtyler1.DebitCredit'); --debitcredit10 Business Object;
INSERT INTO debitcredit(id, jeid, debitcredit, generalledgername, amount) VALUES ('debitcredit10', 'journalentry2', 'debit', 'Commission Expense', 12.00); --debitcredit10 Debit Credit Object;

INSERT INTO businessobject(id, botype) VALUES ('debitcredit11', 'edu.byu.isys413.rtyler1.DebitCredit'); --debitcredit11 Business Object;
INSERT INTO debitcredit(id, jeid, debitcredit, generalledgername, amount) VALUES ('debitcredit11', 'journalentry3', 'debit', 'Cash', 15.75); --debitcredit11 Debit Credit Object;
INSERT INTO businessobject(id, botype) VALUES ('debitcredit12', 'edu.byu.isys413.rtyler1.DebitCredit'); --debitcredit12 Business Object;
INSERT INTO debitcredit(id, jeid, debitcredit, generalledgername, amount) VALUES ('debitcredit12', 'journalentry3', 'credit', 'Sales Revenue', 14.00); --debitcredit12 Debit Credit Object;
INSERT INTO businessobject(id, botype) VALUES ('debitcredit13', 'edu.byu.isys413.rtyler1.DebitCredit'); --debitcredit13 Business Object;
INSERT INTO debitcredit(id, jeid, debitcredit, generalledgername, amount) VALUES ('debitcredit13', 'journalentry3', 'credit', 'Tax Payable', 1.75); --debitcredit13 Debit Credit Object;
INSERT INTO businessobject(id, botype) VALUES ('debitcredit14', 'edu.byu.isys413.rtyler1.DebitCredit'); --debitcredit14 Business Object;
INSERT INTO debitcredit(id, jeid, debitcredit, generalledgername, amount) VALUES ('debitcredit14', 'journalentry3', 'credit', 'Commission Payable', 13.00); --debitcredit14 Debit Credit Object;
INSERT INTO businessobject(id, botype) VALUES ('debitcredit15', 'edu.byu.isys413.rtyler1.DebitCredit'); --debitcredit15 Business Object;
INSERT INTO debitcredit(id, jeid, debitcredit, generalledgername, amount) VALUES ('debitcredit15', 'journalentry3', 'debit', 'Commission Expense', 13.00); --debitcredit15 Debit Credit Object;



--STORE TABLE;
CREATE TABLE store (
  id             VARCHAR(40) PRIMARY KEY REFERENCES businessobject(id),
  empid			 VARCHAR(40),
  location		 VARCHAR(40),
  managerid		 VARCHAR(40) REFERENCES employee(id),
  address		 VARCHAR(250),
  phone			 VARCHAR(15),
  salestaxrate	 double,
  subnetid		 VARCHAR(50)  
);

--ALTER TABLE employee;
--ADD FOREIGN KEY (storeid);
--REFERENCES store(id);
INSERT INTO businessobject(id, botype) VALUES ('store1', 'edu.byu.isys413.rtyler1.Store'); --store1 business object;
INSERT INTO store(id, empid, location, managerid, address, phone, salestaxrate, subnetid) VALUES ('store1', 'employee1', 'Provo', 'Katy', '572 YourStuff Way, Provo, UT 84003', '801-852-2312', 11.00, '123.531.1.2'); --store1 store object;
INSERT INTO businessobject(id, botype) VALUES ('store2', 'edu.byu.isys413.rtyler1.Store'); --store2 business object;
INSERT INTO store(id, empid, location, managerid, address, phone, salestaxrate, subnetid) VALUES ('store2', 'employee2', 'Ogden', 'Jake', '572 MyStuff Way, Ogden, UT 84003', '801-853-2322', 11.00, '123.531.1.3'); --store2 store object;
INSERT INTO businessobject(id, botype) VALUES ('store3', 'edu.byu.isys413.rtyler1.Store'); --store3 business object;
INSERT INTO store(id, empid, location, managerid, address, phone, salestaxrate, subnetid) VALUES ('store3', 'employee3', 'Sandy', 'Jake', '943 MyStuff Street, Sandy, UT 84003', '801-754-3953', 11.00, '122.321.1.4'); --store3 store object;


-- EMPLOYEE TABLE; 
CREATE TABLE employee (
  id             VARCHAR(40) PRIMARY KEY REFERENCES businessobject(id),
  storeid		 VARCHAR(40) REFERENCES store(id),
  empname      	 VARCHAR(50),
  hiredate       date,
  phone      	 VARCHAR(40),
  salary         NUMERIC(8,2),
  commissionrate double,
  loginname      VARCHAR(40)  
);
INSERT INTO businessobject(id, botype) VALUES ('employee1', 'edu.byu.isys413.rtyler1.Employee'); -- employee1 Employee Business Object;
INSERT INTO employee(id, empname, hiredate, phone, salary, commissionrate, loginname) VALUES ('employee1', 'Joe Denker', '2012-11-24 16:23:30.264', '703-242-4352', 80000.00, 10.00, 'username1'); -- employee1 Employee Object;
INSERT INTO businessobject(id, botype) VALUES ('employee2', 'edu.byu.isys413.rtyler1.Employee'); -- employee2 Employee Business Object;
INSERT INTO employee(id, storeid, empname, hiredate, phone, salary, commissionrate, loginname) VALUES ('employee2', 'store2', 'Levi Barraclough', '2013-01-24 14:23:30.264', '703-478-2853', 60000.00, 12.00, 'username2'); -- employee2 Employee Object;
INSERT INTO businessobject(id, botype) VALUES ('employee3', 'edu.byu.isys413.rtyler1.Employee'); -- employee3 Employee Business Object;
INSERT INTO employee(id, storeid, empname, hiredate, phone, salary, commissionrate, loginname) VALUES ('employee3', 'store3', 'Rebecca Tyler', '2012-06-24 10:23:30.264', '703-578-9086', 30000.00, 9.00, 'rtyler1'); -- employee3 Employee Object;

ALTER TABLE store
ADD FOREIGN KEY (empid)
REFERENCES employee(id);

--COMPUTER TABLE;
CREATE TABLE computer (
  id    		VARCHAR(40) PRIMARY KEY REFERENCES businessobject(id),
  storeid 		VARCHAR(40) REFERENCES store(id),
  macaddress 	VARCHAR(40)
);
INSERT INTO businessobject(id, botype) VALUES ('computer1', 'edu.byu.isys413.rtyler1.Computer'); --computer1 Business Object;
INSERT INTO computer(id, storeid, macaddress) VALUES ('computer1', 'store1', 'AC-81-12-63-81-DC'); --computer 1 Computer Object;
INSERT INTO businessobject(id, botype) VALUES ('computer2', 'edu.byu.isys413.rtyler1.Computer'); --computer2 Business Object;
INSERT INTO computer(id, storeid, macaddress) VALUES ('computer2', 'store2', 'AD-81-12-63-81-DC'); --computer2 Computer Object;
INSERT INTO businessobject(id, botype) VALUES ('computer3', 'edu.byu.isys413.rtyler1.Computer'); --computer3 Business Object;
INSERT INTO computer(id, storeid, macaddress) VALUES ('computer3', 'store3', 'BC-81-12-63-81-DC'); --computer3 Computer Object;



-- COMMISSION TABLE;
CREATE TABLE commission(
  id           VARCHAR(40) PRIMARY KEY REFERENCES businessobject(id),
  empid        VARCHAR(40) REFERENCES employee(id),
  amount	   double,
  commdate     date
  
);
INSERT INTO businessobject(id, botype) VALUES ('commission1', 'edu.byu.isys413.rtyler1.Commission'); -- commission1 Business Object;
INSERT INTO commission(id, empid, amount, commdate) VALUES ('commission1', 'employee1', 12.00, '2012-01-24 16:25:30.264'); -- commission1 Commission Object;
INSERT INTO businessobject(id, botype) VALUES ('commission2', 'edu.byu.isys413.rtyler1.Commission'); -- commission2 Business Object;
INSERT INTO commission(id, empid, amount, commdate) VALUES ('commission2', 'employee2', 10.00, '2012-02-24 16:21:30.264'); -- commission2 Commission Object;
INSERT INTO businessobject(id, botype) VALUES ('commission3', 'edu.byu.isys413.rtyler1.Commission'); -- commission3 Business Object;
INSERT INTO commission(id, empid, amount, commdate) VALUES ('commission3', 'employee3', 11.00, '2012-03-24 16:28:30.264'); -- commission3 Commission Object;


-- CONCEPTUALPRODUCT TABLE (extends PRODUCT table);
CREATE TABLE conceptualproduct (
  id           VARCHAR(40) PRIMARY KEY REFERENCES product(id),
  productname  VARCHAR(40),
  description  VARCHAR(250),
  manufacturer VARCHAR(50),
  averagecost  double,
  sku		   VARCHAR(15)
);
INSERT INTO businessobject(id, botype) VALUES ('conceptualproduct1', 'edu.byu.isys413.rtyler1.ConceptualProduct'); -- conceptualproduct1 Business Object;
INSERT INTO product(id, price, prodtype) VALUES ('conceptualproduct1', 2.50, 'Conceptual'); -- conceptualproduct1 Product Object;
INSERT INTO conceptualproduct(id, productname, description, manufacturer, averagecost, sku) VALUES ('conceptualproduct1', 'Camera', 'Takes pictures', 'Cameras Inc.', 2.50, '5F9S75'); -- conceptualproduct1 Conceptual Product Object;
INSERT INTO businessobject(id, botype) VALUES ('conceptualproduct2', 'edu.byu.isys413.rtyler1.ConceptualProduct'); -- conceptualproduct2 Business Object;
INSERT INTO product(id, price, prodtype) VALUES ('conceptualproduct2', 5.00, 'Conceptual'); -- conceptualproduct2 Product Object;
INSERT INTO conceptualproduct(id, productname, description, manufacturer, averagecost, sku) VALUES ('conceptualproduct2', 'Nicer Camera', 'A better quality camera that takes better quality pictures', 'Cameras-R-Us', 5.00, '89GF02'); -- conceptualproduct2 Conceptual Product Object;
INSERT INTO businessobject(id, botype) VALUES ('conceptualproduct3', 'edu.byu.isys413.rtyler1.ConceptualProduct'); -- conceptualproduct3 Business Object;
INSERT INTO product(id, price, prodtype) VALUES ('conceptualproduct3', 1.50, 'Conceptual'); -- conceptualproduct3 Product Object;
INSERT INTO conceptualproduct(id, productname, description, manufacturer, averagecost, sku) VALUES ('conceptualproduct3', 'Computer', 'Many choices of brands, including HP, Dell, etc.', 'Pencil Place', 1.50, '4K304G'); -- conceptualproduct3 Conceptual Product Object;
INSERT INTO businessobject(id, botype) VALUES ('conceptualproduct4', 'edu.byu.isys413.rtyler1.ConceptualProduct'); -- conceptualproduct3 Business Object;
INSERT INTO product(id, price, prodtype) VALUES ('conceptualproduct4', 1.50, 'Conceptual'); -- conceptualproduct3 Product Object;
INSERT INTO conceptualproduct(id, productname, description, manufacturer, averagecost, sku) VALUES ('conceptualproduct4', 'Faster Computer', 'Higher memory, better processor.', 'Pencil Place', 1.50, '4K304G'); -- conceptualproduct3 Conceptual Product Object;

-- PHYSICALPRODUCT TABLE (extends PRODUCT table);
CREATE TABLE physicalproduct (
  id           					VARCHAR(40) PRIMARY KEY REFERENCES product(id),
  storeid						VARCHAR(40) REFERENCES store(id),
  conceptualproductid			VARCHAR(40) REFERENCES conceptualproduct(id),
  serialnumber					VARCHAR(40),
  shelflocation 				VARCHAR(50),
  datepurchased 				date,
  cost							double,
  status 						VARCHAR(50),
  physicalproductcommissionrate double,
  pptype						VARCHAR(40)
);
INSERT INTO businessobject(id, botype) VALUES ('physicalproduct1', 'edu.byu.isys413.rtyler1.PhysicalProduct'); -- physicalproduct1 Business Object;
INSERT INTO product(id, price, prodtype) VALUES ('physicalproduct1', 45.24, 'Physical'); -- physicalproduct1 Product Object;
INSERT INTO physicalproduct(id, storeid, conceptualproductid, serialnumber, shelflocation, datepurchased, cost, status, physicalproductcommissionrate, pptype) VALUES ('physicalproduct1', 'store1', 'conceptualproduct1', '273023419671', 'Aisle 7 Shelf 4', '2012-03-05 15:23:53.523', 3.75, 'Available', 6.5, 'For Rent'); -- physicalproduct1 Physical Product Object;
INSERT INTO businessobject(id, botype) VALUES ('physicalproduct2', 'edu.byu.isys413.rtyler1.PhysicalProduct'); -- physicalproduct2 Business Object;
INSERT INTO product(id, price, prodtype) VALUES ('physicalproduct2', 45.24, 'Physical'); -- physicalproduct2 Product Object;
INSERT INTO physicalproduct(id, storeid, conceptualproductid, serialnumber, shelflocation, datepurchased, cost, status, physicalproductcommissionrate, pptype) VALUES ('physicalproduct2', 'store2', 'conceptualproduct2', '573021409675', 'Aisle 3 Shelf 1', '2012-01-03 12:02:34.132', 1.75, 'Sold', 2.5, 'For Sale'); -- physicalproduct2 Physical Product Object;
INSERT INTO businessobject(id, botype) VALUES ('physicalproduct3', 'edu.byu.isys413.rtyler1.PhysicalProduct'); -- physicalproduct3 Business Object;
INSERT INTO product(id, price, prodtype) VALUES ('physicalproduct3', 45.24, 'Physical'); -- physicalproduct3 Product Object;
INSERT INTO physicalproduct(id, storeid, conceptualproductid, serialnumber, shelflocation, datepurchased, cost, status, physicalproductcommissionrate, pptype) VALUES ('physicalproduct3', 'store3', 'conceptualproduct3', '373023409111', 'Aisle 8 Shelf 3', '2012-02-01 11:21:13.312', 3.05, 'Available', 1.5, 'For Sale'); -- physicalproduct3 Physical Product Object;

--CONCEPTUALRENTAL TABLE (extends conceptualproduct table);
CREATE TABLE conceptualrental (
	id					VARCHAR(40) PRIMARY KEY REFERENCES conceptualproduct(id),
	priceperday			double,
	replacementprice	double
);
INSERT INTO businessobject(id, botype) VALUES ('conceptualrental1', 'edu.byu.isys413.rtyler1.ConceptualRental');
INSERT INTO product(id, price, prodtype) VALUES ('conceptualrental1', 13.53, 'Conceptual');
INSERT INTO conceptualproduct(id, productname, description, manufacturer, averagecost, sku) VALUES ('conceptualrental1', 'Simple camera', 'Not a very complicated camera', 'Simps cams', 12.45, '9K604H');
INSERT INTO conceptualrental(id, priceperday, replacementprice) VALUES ('conceptualrental1', 2.10, 11.60);
INSERT INTO businessobject(id, botype) VALUES ('conceptualrental2', 'edu.byu.isys413.rtyler1.ConceptualRental');
INSERT INTO product(id, price, prodtype) VALUES ('conceptualrental2', 113.15, 'Conceptual');
INSERT INTO conceptualproduct(id, productname, description, manufacturer, averagecost, sku) VALUES ('conceptualrental2', 'Hardcore harddrive', 'Very reliable and high storage harddrive', 'Hardcore or go home', 110.67, '8D0SF3');
INSERT INTO conceptualrental(id, priceperday, replacementprice) VALUES ('conceptualrental2', 15.30, 120.60);
INSERT INTO businessobject(id, botype) VALUES ('conceptualrental3', 'edu.byu.isys413.rtyler1.ConceptualRental');
INSERT INTO product(id, price, prodtype) VALUES ('conceptualrental3', 9.47, 'Conceptual');
INSERT INTO conceptualproduct(id, productname, description, manufacturer, averagecost, sku) VALUES ('conceptualrental3', 'Not-so-simple camera', 'Slightly more complicated camera', 'Not-So-Simps cams', 15.45, '6D89S0');
INSERT INTO conceptualrental(id, priceperday, replacementprice) VALUES ('conceptualrental3', 5.80, 20.75);


--FORRENT TABLE;
CREATE TABLE forrent (
	id			VARCHAR(40) PRIMARY KEY REFERENCES physicalproduct(id),
	timesrented integer,
	rentalid	VARCHAR(40) REFERENCES rental(id)
);
INSERT INTO businessobject(id, botype) VALUES ('forrent1', 'edu.byu.isys413.rtyler1.ForRent'); 
INSERT INTO product(id, price, prodtype) VALUES ('forrent1', 45.33, 'Physical');
INSERT INTO physicalproduct(id, storeid, conceptualproductid, serialnumber, shelflocation, datepurchased, cost, status, physicalproductcommissionrate) VALUES ('forrent1', 'store1', 'conceptualproduct1', '573023419672', 'Aisle 7 Shelf 4', '2012-03-05 15:23:53.523', 3.75, 'Available', 6.5);
INSERT INTO forrent(id, timesrented, rentalid) VALUES ('forrent1', 3, 'rental1');
INSERT INTO businessobject(id, botype) VALUES ('forrent2', 'edu.byu.isys413.rtyler1.ForRent'); 
INSERT INTO product(id, price, prodtype) VALUES ('forrent2', 15.33, 'Physical');
INSERT INTO physicalproduct(id, storeid, conceptualproductid, serialnumber, shelflocation, datepurchased, cost, status, physicalproductcommissionrate) VALUES ('forrent2', 'store2', 'conceptualproduct2', '573021409675', 'Aisle 3 Shelf 1', '2012-01-03 12:02:34.132', 1.75, 'Not Available', 2.5);
INSERT INTO forrent(id, timesrented, rentalid) VALUES ('forrent2', 4, 'rental2');
INSERT INTO businessobject(id, botype) VALUES ('forrent3', 'edu.byu.isys413.rtyler1.ForRent'); 
INSERT INTO product(id, price, prodtype) VALUES ('forrent3', 54.32, 'Physical');
INSERT INTO physicalproduct(id, storeid, conceptualproductid, serialnumber, shelflocation, datepurchased, cost, status, physicalproductcommissionrate) VALUES ('forrent3', 'store3', 'conceptualproduct3', '373023409111', 'Aisle 8 Shelf 3', '2012-02-01 11:21:13.312', 3.05, 'Available', 1.5);
INSERT INTO forrent(id, timesrented, rentalid) VALUES ('forrent3', 5, 'rental3');


--FORSALE TABLE;
CREATE TABLE forsale (
	id VARCHAR(40) PRIMARY KEY REFERENCES physicalproduct(id),
	neworused VARCHAR(40)
);
INSERT INTO businessobject(id, botype) VALUES ('forsale1', 'edu.byu.isys413.rtyler1.ForSale'); 
INSERT INTO product(id, price, prodtype) VALUES ('forsale1', 45.33, 'Physical');
INSERT INTO physicalproduct(id, storeid, conceptualproductid, serialnumber, shelflocation, datepurchased, cost, status, physicalproductcommissionrate) VALUES ('forsale1', 'store1', 'conceptualproduct3', '573456139672', 'Aisle 4 Shelf 1', '2012-03-05 15:23:53.523', 3.75, 'Sold', 6.5);
INSERT INTO forsale(id, neworused) VALUES ('forsale1', 'new');
INSERT INTO businessobject(id, botype) VALUES ('forsale2', 'edu.byu.isys413.rtyler1.ForSale'); 
INSERT INTO product(id, price, prodtype) VALUES ('forsale2', 45.33, 'Physical');
INSERT INTO physicalproduct(id, storeid, conceptualproductid, serialnumber, shelflocation, datepurchased, cost, status, physicalproductcommissionrate) VALUES ('forsale2', 'store2', 'conceptualproduct1', '463456139672', 'Aisle 3 Shelf 8', '2012-02-05 11:23:53.842', 3.35, 'Available', 1.5);
INSERT INTO forsale(id, neworused) VALUES ('forsale2', 'used');
INSERT INTO businessobject(id, botype) VALUES ('forsale3', 'edu.byu.isys413.rtyler1.ForSale'); 
INSERT INTO product(id, price, prodtype) VALUES ('forsale3', 45.33, 'Physical');
INSERT INTO physicalproduct(id, storeid, conceptualproductid, serialnumber, shelflocation, datepurchased, cost, status, physicalproductcommissionrate) VALUES ('forsale3', 'store3', 'conceptualproduct2', '652356139673', 'Aisle 1 Shelf 2', '2012-12-05 11:56:53.263', 2.35, 'Available', 1.9);
INSERT INTO forsale(id, neworused) VALUES ('forsale3', 'new');

-- STOREPRODUCT TABLE;
CREATE TABLE storeproduct (
  id           					VARCHAR(40) PRIMARY KEY REFERENCES businessobject(id),
  storeid						VARCHAR(40) REFERENCES store(id),
  conceptualproductid			VARCHAR(40) REFERENCES conceptualproduct(id),
  quantityonhand				INT,
  shelflocation					VARCHAR(50)
);
INSERT INTO businessobject(id, botype) VALUES ('storeproduct1', 'edu.byu.isys413.rtyler1.StoreProduct'); --storeproduct1 Business Object;
INSERT INTO storeproduct(id, storeid, conceptualproductid, quantityonhand, shelflocation) VALUES ('storeproduct1', 'store1', 'conceptualproduct1', 67, 'Aisle 3, Shelf 6'); --storeproduct1 Store Product Object;
INSERT INTO businessobject(id, botype) VALUES ('storeproduct2', 'edu.byu.isys413.rtyler1.StoreProduct'); --storeproduct2 Business Object;
INSERT INTO storeproduct(id, storeid, conceptualproductid, quantityonhand, shelflocation) VALUES ('storeproduct2', 'store2', 'conceptualproduct2', 45, 'Aisle 2, Shelf 1'); --storeproduct2 Store Product Object;
INSERT INTO businessobject(id, botype) VALUES ('storeproduct3', 'edu.byu.isys413.rtyler1.StoreProduct'); --storeproduct3 Business Object;
INSERT INTO storeproduct(id, storeid, conceptualproductid, quantityonhand, shelflocation) VALUES ('storeproduct3', 'store3', 'conceptualproduct2', 39, 'Aisle 5, Shelf 9'); --storeproduct3 Store Product Object;

--PAYMENT TABLE;
CREATE TABLE payment(
	id			VARCHAR(40) PRIMARY KEY REFERENCES businessobject(id),
	amount		double,
	paymentchange double,
	paymenttype VARCHAR(40)
);
INSERT INTO businessobject(id, botype) VALUES ('payment1', 'edu.byu.isys413.rtyler1.Payment'); 
INSERT INTO payment(id, amount, paymentchange, paymenttype) VALUES ('payment1', 20.00, 7.50, 'Cash'); 
INSERT INTO businessobject(id, botype) VALUES ('payment2', 'edu.byu.isys413.rtyler1.Payment'); 
INSERT INTO payment(id, amount, paymentchange, paymenttype) VALUES ('payment2', 15.53, null, 'Credit'); 
INSERT INTO businessobject(id, botype) VALUES ('payment3', 'edu.byu.isys413.rtyler1.Payment'); 
INSERT INTO payment(id, amount, paymentchange, paymenttype) VALUES ('payment3', 5.00, 1.50, 'Cash'); 


-- TRANSACTION TABLE;
CREATE TABLE transaction1 (
  id           VARCHAR(40) PRIMARY KEY REFERENCES businessobject(id),
  customerid   VARCHAR(40) REFERENCES customer(id),
  empid		   VARCHAR(40) REFERENCES employee(id),
  storeid	   VARCHAR(40) REFERENCES store(id),
  commid	   VARCHAR(40) REFERENCES commission(id),
  jeid		   VARCHAR(40) REFERENCES journalentry(id),
  paymentid	   VARCHAR(40) REFERENCES payment(id),
  transdate    date,
  subtotal     double,
  tax          double,
  total        double 
);
INSERT INTO businessobject(id, botype) VALUES ('trans1', 'edu.byu.isys413.rtyler1.Transaction1'); --trans1 business object;
INSERT INTO transaction1(id, customerid, empid, storeid, commid, jeid, paymentid, transdate, subtotal, tax, total) VALUES ('trans1', 'customer1', 'employee1', 'store1', 'commission1', 'journalentry1', 'payment1', '2012-02-05 11:24:52.213', 100.00, 10.00, 110.00); --transaction1 transaction object;
INSERT INTO businessobject(id, botype) VALUES ('trans2', 'edu.byu.isys413.rtyler1.Transaction1'); --trans2 business object;
INSERT INTO transaction1(id, customerid, empid, storeid, commid, jeid, paymentid, transdate, subtotal, tax, total) VALUES ('trans2', 'customer2', 'employee2', 'store2', 'commission2', 'journalentry2', 'payment2', '2013-03-05 12:43:13.423', 130.00, 12.00, 150.00); --transaction1 transaction object;
INSERT INTO businessobject(id, botype) VALUES ('trans3', 'edu.byu.isys413.rtyler1.Transaction1'); --trans3 business object;
INSERT INTO transaction1(id, customerid, empid, storeid, commid, jeid, paymentid, transdate, subtotal, tax, total) VALUES ('trans3', 'customer3', 'employee3', 'store3', 'commission3', 'journalentry3', 'payment3', '2012-03-14 05:05:58.502', 90.00, 6.00, 96.00); --transaction1 transaction object;
 


-- REVENUESOURCE TABLE;
CREATE TABLE revenuesource (
  id           VARCHAR(40) PRIMARY KEY REFERENCES businessobject(id),
  transid	   VARCHAR(40) REFERENCES transaction1,
  chargeamount double,
  rstype	   VARCHAR(40) 
);
INSERT INTO businessobject(id, botype) VALUES ('revsource1', 'edu.byu.isys413.rtyler1.RevenueSource'); -- revsource1 Business Object;
INSERT INTO revenuesource(id, transid, chargeamount, rstype) VALUES ('revsource1', 'trans1', 25.00, 'Sale'); -- revsource1 Revenue Source Object;
INSERT INTO businessobject(id, botype) VALUES ('revsource2', 'edu.byu.isys413.rtyler1.RevenueSource'); -- revsource2 Business Object;
INSERT INTO revenuesource(id, transid, chargeamount, rstype) VALUES ('revsource2', 'trans2', 12.00, 'Sale'); -- revsource2 Revenue Source Object;
INSERT INTO businessobject(id, botype) VALUES ('revsource3', 'edu.byu.isys413.rtyler1.RevenueSource'); -- revsource3 Business Object;
INSERT INTO revenuesource(id, transid, chargeamount, rstype) VALUES ('revsource3', 'trans3', 5.00, 'Sale'); -- revsource3 Revenue Source Object;


--RENTAL TABLE (extends REVENUESOURCE table);
CREATE TABLE rental(
	id		VARCHAR(40) PRIMARY KEY REFERENCES revenuesource(id),
	forrentid VARCHAR(40) REFERENCES forrent(id),
	dateout date,
	datedue date,
	datein  date,
	remindersent VARCHAR(40)
);
INSERT INTO businessobject(id, botype) VALUES ('rental1', 'edu.byu.isys413.rtyler1.Rental'); 
INSERT INTO revenuesource(id, chargeamount, rstype) VALUES ('rental1', 12.00, 'Rental');
INSERT INTO rental(id, forrentid, dateout, datedue, datein, remindersent) VALUES ('rental1', 'forrent1', '2012-03-05 15:23:53.523', '2012-03-19 15:23:53.523', null, 'no'); --hasn't hit duedate yet;
INSERT INTO businessobject(id, botype) VALUES ('rental2', 'edu.byu.isys413.rtyler1.Rental'); 
INSERT INTO revenuesource(id, chargeamount, rstype) VALUES ('rental2', 12.00, 'Rental');
INSERT INTO rental(id, forrentid, dateout, datedue, datein, remindersent) VALUES ('rental2', 'forrent2', '2012-03-06 11:53:23.635', '2012-03-08 15:23:53.523', null, 'yes'); --overdue!;
INSERT INTO businessobject(id, botype) VALUES ('rental3', 'edu.byu.isys413.rtyler1.Rental'); 
INSERT INTO revenuesource(id, chargeamount, rstype) VALUES ('rental3', 12.00, 'Rental');
INSERT INTO rental(id, forrentid, dateout, datedue, datein, remindersent) VALUES ('rental3', 'forrent3', '2012-03-05 15:23:53.523', '2012-03-10 15:23:53.523', '2012-03-08 09:23:53.523', 'no'); --turned in ontime;

--FEE TABLE;
CREATE TABLE fee(
	id			VARCHAR(40) PRIMARY KEY REFERENCES revenuesource(id),
	rentalid	VARCHAR(40) REFERENCES rental(id),
	amount		double,
	empid		VARCHAR(40) REFERENCES employee(id)
);
INSERT INTO businessobject(id, botype) VALUES ('fee1', 'edu.byu.isys413.rtyler1.Fee');
INSERT INTO revenuesource(id, chargeamount, rstype) VALUES ('fee1', 12.00, 'Rental');
INSERT INTO fee(id, rentalid, amount, empid) VALUES ('fee1', 'rental1', 2.00, 'employee1');
INSERT INTO businessobject(id, botype) VALUES ('fee2', 'edu.byu.isys413.rtyler1.Fee');
INSERT INTO revenuesource(id, chargeamount, rstype) VALUES ('fee2', 17.00, 'Rental');
INSERT INTO fee(id, rentalid, amount, empid) VALUES ('fee2', 'rental1', 12.00, 'employee2');
INSERT INTO businessobject(id, botype) VALUES ('fee3', 'edu.byu.isys413.rtyler1.Fee');
INSERT INTO revenuesource(id, chargeamount, rstype) VALUES ('fee3', 32.00, 'Rental');
INSERT INTO fee(id, rentalid, amount, empid) VALUES ('fee3', 'rental1', 6.50, 'employee3');


--LATE TABLE (extends FEE table);
CREATE TABLE late(
	id			VARCHAR(40) PRIMARY KEY REFERENCES fee(id),
	dayslate	integer
);
INSERT INTO businessobject(id, botype) VALUES ('late1', 'edu.byu.isys413.rtyler1.Late');
INSERT INTO revenuesource(id, chargeamount, rstype) VALUES ('late1', 12.00, 'Rental');
INSERT INTO fee(id, rentalid, amount) VALUES ('late1', 'rental1', 2.00);
INSERT INTO late(id, dayslate) VALUES ('late1', 3);
INSERT INTO businessobject(id, botype) VALUES ('late2', 'edu.byu.isys413.rtyler1.Late');
INSERT INTO revenuesource(id, chargeamount, rstype) VALUES ('late2', 17.00, 'Rental');
INSERT INTO fee(id, rentalid, amount) VALUES ('late2', 'rental1', 12.00);
INSERT INTO late(id, dayslate) VALUES ('late2', 5);
INSERT INTO businessobject(id, botype) VALUES ('late3', 'edu.byu.isys413.rtyler1.Late');
INSERT INTO revenuesource(id, chargeamount, rstype) VALUES ('late3', 32.00, 'Rental');
INSERT INTO fee(id, rentalid, amount) VALUES ('late3', 'rental1', 6.00);
INSERT INTO late(id, dayslate) VALUES ('late3', 1);


-- SALE TABLE (extends REVENUESOURCE table);
CREATE TABLE sale (
  id           VARCHAR(40) PRIMARY KEY REFERENCES revenuesource(id),
  prodid	   VARCHAR(40) REFERENCES product(id),
  quantity     integer, 
  saletype	   VARCHAR(40)
);
INSERT INTO businessobject(id, botype) VALUES ('sale1', 'edu.byu.isys413.rtyler1.Sale'); -- sale1 Business Object;
INSERT INTO revenuesource(id, chargeamount, rstype) VALUES ('sale1', 62.00, 'Sale'); -- sale1 Revenue Source Object;
INSERT INTO sale(id, prodid, quantity, saletype) VALUES ('sale1', 'product1', 42, 'In Store'); -- sale1 Sale Object;
INSERT INTO businessobject(id, botype) VALUES ('sale2', 'edu.byu.isys413.rtyler1.Sale'); -- sale2 Business Object;
INSERT INTO revenuesource(id, chargeamount, rstype) VALUES ('sale2', 23.00, 'Sale'); -- sale2 Revenue Source Object;
INSERT INTO sale(id, prodid, quantity, saletype) VALUES ('sale2', 'product2', 12, 'Online'); -- sale2 Sale Object;
INSERT INTO businessobject(id, botype) VALUES ('sale3', 'edu.byu.isys413.rtyler1.Sale'); -- sale3 Business Object;
INSERT INTO revenuesource(id, chargeamount, rstype) VALUES ('sale3', 31.00, 'Sale'); -- sale3 Revenue Source Object;
INSERT INTO sale(id, prodid, quantity, saletype) VALUES ('sale3', 'product3', 23, 'In Store'); -- sale3 Sale Object;

-- INSTORE TABLE (extends SALE table);
CREATE TABLE instore(
	id			VARCHAR(40) PRIMARY KEY REFERENCES sale(id)
);
INSERT INTO businessobject(id, botype) VALUES ('instore1', 'edu.byu.isys413.rtyler1.InStore'); 
INSERT INTO revenuesource(id, chargeamount, rstype) VALUES ('instore1', 23.00, 'Sale');
INSERT INTO sale(id, prodid, quantity) VALUES ('instore1', 'product1', 12); 
INSERT INTO instore(id) VALUES ('instore1');
INSERT INTO businessobject(id, botype) VALUES ('instore2', 'edu.byu.isys413.rtyler1.InStore'); 
INSERT INTO revenuesource(id, chargeamount, rstype) VALUES ('instore2', 23.00, 'Sale');
INSERT INTO sale(id, prodid, quantity) VALUES ('instore2', 'product2', 12); 
INSERT INTO instore(id) VALUES ('instore2');
INSERT INTO businessobject(id, botype) VALUES ('instore3', 'edu.byu.isys413.rtyler1.InStore'); 
INSERT INTO revenuesource(id, chargeamount, rstype) VALUES ('instore3', 23.00, 'Sale');
INSERT INTO sale(id, prodid, quantity) VALUES ('instore3', 'product3', 12); 
INSERT INTO instore(id) VALUES ('instore3');

-- ONLINE TABLE (extends SALE table);
CREATE TABLE online(
	id 			VARCHAR(40) PRIMARY KEY REFERENCES sale(id),
	pickup		boolean
);
INSERT INTO businessobject(id, botype) VALUES ('online1', 'edu.byu.isys413.rtyler1.OnLine'); 
INSERT INTO revenuesource(id, chargeamount, rstype) VALUES ('online1', 98.00, 'Sale');
INSERT INTO sale(id, prodid, quantity) VALUES ('online1', 'product2', 56); 
INSERT INTO online(id, pickup) VALUES ('online1', true);
INSERT INTO businessobject(id, botype) VALUES ('online2', 'edu.byu.isys413.rtyler1.OnLine'); 
INSERT INTO revenuesource(id, chargeamount, rstype) VALUES ('online2', 47.00, 'Sale');
INSERT INTO sale(id, prodid, quantity) VALUES ('online2', 'product1', 43); 
INSERT INTO online(id, pickup) VALUES ('online2', true);
INSERT INTO businessobject(id, botype) VALUES ('online3', 'edu.byu.isys413.rtyler1.OnLine'); 
INSERT INTO revenuesource(id, chargeamount, rstype) VALUES ('online3', 12.00, 'Sale');
INSERT INTO sale(id, prodid, quantity) VALUES ('online3', 'product3', 13); 
INSERT INTO online(id, pickup) VALUES ('online3', true);

SET FOREIGN_KEY_CHECKS = 1;