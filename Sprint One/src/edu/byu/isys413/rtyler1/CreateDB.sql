-- Note that comment lines need to end with a semicolon for CreateDB.java to work;

-- The primary keys (id) should really be CHAR(40), not VARCHAR(40), but;
-- to make life easier in testing, I've placed them as VARCHAR(40) for now;

-- First drop everything (order matters here for foreign keys!);

SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS rental;
DROP TABLE IF EXISTS forsale;
DROP TABLE IF EXISTS forrent;
DROP TABLE IF EXISTS transaction;
DROP TABLE IF EXISTS payment;
DROP TABLE IF EXISTS checks;
DROP TABLE IF EXISTS personcar;
DROP TABLE IF EXISTS car;
DROP TABLE IF EXISTS dog;
DROP TABLE IF EXISTS commission;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS membership;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS person;
DROP TABLE IF EXISTS sale;
DROP TABLE IF EXISTS revenuesource;
DROP TABLE IF EXISTS physicalproduct;
DROP TABLE IF EXISTS storeproduct;
DROP TABLE IF EXISTS conceptualproduct;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS computer;
DROP TABLE IF EXISTS store;
DROP TABLE IF EXISTS debitcredit;
DROP TABLE IF EXISTS journalentry;
DROP TABLE IF EXISTS updategl;
DROP TABLE IF EXISTS generalledger;
DROP TABLE IF EXISTS businessobject;



-- BUSINESSOBJECT TABLE (everything extends this);
CREATE TABLE businessobject (
  id           VARCHAR(40) PRIMARY KEY,
  botype       VARCHAR(250)
);

--GENERALLEDGER TABLE;
CREATE TABLE generalledger (
  id		VARCHAR(40) PRIMARY KEY REFERENCES businessobject(id),
  acctname	VARCHAR(25),
  balance	INTEGER,
  accttype	VARCHAR(30)
);
INSERT INTO businessobject(id, botype) VALUES ('gledger1', 'edu.byu.isys413.roytm.GeneralLedger');
INSERT INTO generalledger(id, acctname, balance, accttype) VALUES ('gledger1', 'cash', 1000000, 'AccountType.ASSET');
INSERT INTO businessobject(id, botype) VALUES ('gledger2', 'edu.byu.isys413.roytm.GeneralLedger');
INSERT INTO generalledger(id, acctname, balance, accttype) VALUES ('gledger2', 'salesrevenue', 950000, 'AccountType.REVENUE');
INSERT INTO businessobject(id, botype) VALUES ('gledger3', 'edu.byu.isys413.roytm.GeneralLedger');
INSERT INTO generalledger(id, acctname, balance, accttype) VALUES ('gledger3', 'taxpayable', 50000, 'AccountType.LIABILITY');
INSERT INTO businessobject(id, botype) VALUES ('gledger4', 'edu.byu.isys413.roytm.GeneralLedger');
INSERT INTO generalledger(id, acctname, balance, accttype) VALUES ('gledger4', 'commissionexpense', 10000, 'AccountType.EXPENSE');
INSERT INTO businessobject(id, botype) VALUES ('gledger5', 'edu.byu.isys413.roytm.GeneralLedger');
INSERT INTO generalledger(id, acctname, balance, accttype) VALUES ('gledger5', 'commissionspayable', 10000, 'AccountType.LIABILITY');

CREATE TABLE updategl (
  id					VARCHAR(40) PRIMARY KEY REFERENCES businessobject(id),
  updatedate			DATE,
  transactioncount		INTEGER
);
INSERT INTO businessobject(id, botype) VALUES ('update1', 'edu.byu.isys413.roytm.UpdateGL');
INSERT INTO updategl(id, updatedate, transactioncount) VALUES ('update1', '2013/02/07', 1);
INSERT INTO businessobject(id, botype) VALUES('update2', 'edu.byu.isys413.roytm.UpdateGL');
INSERT INTO updategl(id, updatedate, transactioncount) VALUES ('update2', '2013/02/09', 1);

--JOURNALENTRY TABLE;
CREATE TABLE journalentry (
  id		VARCHAR(40) PRIMARY KEY REFERENCES businessobject(id),
  jedate	DATE,
  updatenum	VARCHAR(40) REFERENCES updategl(id)
);
INSERT INTO businessobject(id, botype) VALUES('je1', 'edu.byu.isys413.roytm.JournalEntry');
INSERT INTO journalentry(id, jedate, updatenum) VALUES('je1', '2013/02/07', 'update1');
INSERT INTO businessobject(id, botype) VALUES('je2', 'edu.byu.isys413.roytm.JournalEntry');
INSERT INTO journalentry(id, jedate, updatenum) VALUES('je2', '2013/02/09', 'update2');

--DEBITCREDIT TABLE;
CREATE TABLE debitcredit (
  id			VARCHAR(40) PRIMARY KEY REFERENCES businessobject(id),
  jeid			VARCHAR(40) REFERENCES journalentry,
  drcrtype		VARCHAR(30),
  glacct		VARCHAR(25),
  amount		INTEGER
);
INSERT INTO businessobject(id, botype) VALUES('drcr1', 'edu.byu.isys413.DebitCredit');
INSERT INTO debitcredit(id, jeid, drcrtype, glacct, amount) VALUES('drcr1', 'je1', 'debit', 'cash', 10675);
INSERT INTO businessobject(id, botype) VALUES('drcr2', 'edu.byu.isys413.DebitCredit');
INSERT INTO debitcredit(id, jeid, drcrtype, glacct, amount) VALUES('drcr2', 'je1', 'credit', 'salesrevenue', 10000);
INSERT INTO businessobject(id, botype) VALUES('drcr3', 'edu.byu.isys413.DebitCredit');
INSERT INTO debitcredit(id, jeid, drcrtype, glacct, amount) VALUES('drcr3', 'je1', 'credit', 'taxpayable', 675);
INSERT INTO businessobject(id, botype) VALUES('drcr4', 'edu.byu.isys413.DebitCredit');
INSERT INTO debitcredit(id, jeid, drcrtype, glacct, amount) VALUES('drcr4', 'je1', 'debit', 'commissionexpense', 350);
INSERT INTO businessobject(id, botype) VALUES('drcr5', 'edu.byu.isys413.DebitCredit');
INSERT INTO debitcredit(id, jeid, drcrtype, glacct, amount) VALUES('drcr5', 'je1', 'credit', 'commissionspayable', 350);
INSERT INTO businessobject(id, botype) VALUES('drcr6', 'edu.byu.isys413.DebitCredit');
INSERT INTO debitcredit(id, jeid, drcrtype, glacct, amount) VALUES('drcr6', 'je2', 'debit', 'cash', 234300);
INSERT INTO businessobject(id, botype) VALUES('drcr7', 'edu.byu.isys413.DebitCredit');
INSERT INTO debitcredit(id, jeid, drcrtype, glacct, amount) VALUES('drcr7', 'je2', 'credit', 'salesrevenue', 220000);
INSERT INTO businessobject(id, botype) VALUES('drcr8', 'edu.byu.isys413.DebitCredit');
INSERT INTO debitcredit(id, jeid, drcrtype, glacct, amount) VALUES('drcr8', 'je2', 'credit', 'taxpayable', 14300);
INSERT INTO businessobject(id, botype) VALUES('drcr9', 'edu.byu.isys413.DebitCredit');
INSERT INTO debitcredit(id, jeid, drcrtype, glacct, amount) VALUES('drcr9', 'je2', 'debit', 'commissionexpense', 30800);
INSERT INTO businessobject(id, botype) VALUES('drcr10', 'edu.byu.isys413.DebitCredit');
INSERT INTO debitcredit(id, jeid, drcrtype, glacct, amount) VALUES('drcr10', 'je2', 'credit', 'commissionspayable', 30800);

--STORE TABLE;
CREATE TABLE store (
  id			VARCHAR(40) PRIMARY KEY REFERENCES businessobject(id),
  location		VARCHAR(25),
  managerid		VARCHAR(40),
  phone			VARCHAR(20),
  address		VARCHAR(50),
  city			VARCHAR(15),
  state			VARCHAR(10),
  zipcode		VARCHAR(10),
  salestaxrate	NUMERIC(6,5),
  subnetid		VARCHAR(15)
);
--Insert test data for Store table;
INSERT INTO businessobject(id, botype) VALUES ('store1', 'edu.byu.isys413.roytm.Store');
	INSERT INTO store(id,location,managerid,phone,address,city,state,zipcode, salestaxrate, subnetid) 
		VALUES ('store1','Draper','employee2','(801)224-4098','123 Happy Place','Draper','UT','84001', 0.06750, '172.10.8.2');
INSERT INTO businessobject(id, botype) VALUES ('store2', 'edu.byu.isys413.roytm.Store');
	INSERT INTO store(id,location,managerid,phone,address,city,state,zipcode, salestaxrate, subnetid) 
		VALUES ('store2','Orem','employee1','(801)224-4123','010 State St.','Orem','UT','84002', 0.06500, '172.10.8.3');
INSERT INTO businessobject(id, botype) VALUES ('store3', 'edu.byu.isys413.roytm.Store');
	INSERT INTO store(id,location,managerid,phone,address,city,state,zipcode, salestaxrate, subnetid) 
		VALUES ('store3','Provo','employee1','(801)224-4987','57 Cougar Place','Provo','UT','84003', 0.06500, '172.10.8.4');
INSERT INTO businessobject(id, botype) VALUES ('store4', 'edu.byu.isys413.roytm.Store');
	INSERT INTO store(id,location,managerid,phone,address,city,state,zipcode, salestaxrate, subnetid) 
		VALUES ('store4','West Jordan','employee2','(801)224-4456','89 Jordanian Stuff','West Jordan','UT','84005', 0.06750, '172.10.8.5');

--COMPUTER TABLE;
CREATE TABLE computer (
  id			VARCHAR(40) PRIMARY KEY REFERENCES businessobject(id),
  macaddress	VARCHAR(11),
  subnet		VARCHAR(15) REFERENCES store(subnetid)
);
--Insert test data for computer table;
INSERT INTO businessobject(id, botype) VALUES ('computer1', 'edu.byu.isys413.roytm.Computer');
	INSERT INTO computer(id, macaddress, subnet) VALUES('computer1', '08:4D:0F:02', '172.10.8.2');
INSERT INTO businessobject(id, botype) VALUES ('computer2', 'edu.byu.isys413.roytm.Computer');
	INSERT INTO computer(id, macaddress, subnet) VALUES('computer2', '03:6D:18:03', '172.10.8.3');
INSERT INTO businessobject(id, botype) VALUES ('computer3', 'edu.byu.isys413.roytm.Computer');
	INSERT INTO computer(id, macaddress, subnet) VALUES('computer3', '04:1D:58:04', '172.10.8.4');
INSERT INTO businessobject(id, botype) VALUES ('computer4', 'edu.byu.isys413.roytm.Computer');
	INSERT INTO computer(id, macaddress, subnet) VALUES('computer4', '09:3D:12:05', '172.10.8.5');

--PRODUCT TABLE;
CREATE TABLE product (
  id			VARCHAR(40) PRIMARY KEY REFERENCES businessobject(id),
  price			double,
  prodtype		VARCHAR(40)
);
INSERT INTO businessobject(id, botype) VALUES('product1', 'edu.byu.isys413.roytm.Product');
INSERT INTO product(id, price, prodtype) VALUES('product1', 10000, 'Conceptual');
INSERT INTO businessobject(id, botype) VALUES('product2', 'edu.byu.isys413.roytm.Product');
INSERT INTO product(id, price, prodtype) VALUES('product2', 10000, 'Physical');
INSERT INTO businessobject(id, botype) VALUES('product3', 'edu.byu.isys413.roytm.Product');
INSERT INTO product(id, price, prodtype) VALUES('product3', 10000, 'Conceptual');

--CONCEPTUALPRODUCT TABLE (extends product table);
CREATE TABLE conceptualproduct (
  id				VARCHAR(40) PRIMARY KEY REFERENCES product(id),
  description		VARCHAR(50),
  productname		VARCHAR(25),
  manufacturer		VARCHAR(25),
  averagecost		INTEGER,
  commissionrate	NUMERIC(6,5),
  sku				VARCHAR(10) 
);
--Insert test date into conceptualproduct table;
INSERT INTO businessobject(id, botype) VALUES('conceptualproduct1', 'edu.byu.isys413.roytm.ConceptualProduct');
	INSERT INTO product(id, price) VALUES('conceptualproduct1', 10000);
	INSERT INTO conceptualproduct (id, description, productname, manufacturer, averagecost, commissionrate, sku)
		VALUES('conceptualproduct1', 'product 1', 'Elph HS100', 'Canon', 90000, 0.03500, '001001');
INSERT INTO businessobject(id, botype) VALUES('conceptualproduct2', 'edu.byu.isys413.roytm.ConceptualProduct');
	INSERT INTO product(id, price) VALUES('conceptualproduct2', 20000);
	INSERT INTO conceptualproduct (id, description, productname, manufacturer, averagecost, commissionrate, sku)
		VALUES('conceptualproduct2', 'product 2', 'Powershot 200', 'Canon', 18500, 0.05000, '001002');
INSERT INTO businessobject(id, botype) VALUES('conceptualproduct3', 'edu.byu.isys413.roytm.ConceptualProduct');
	INSERT INTO product(id, price) VALUES('conceptualproduct3', 5000);
	INSERT INTO conceptualproduct (id, description, productname, manufacturer, averagecost, commissionrate, sku)
		VALUES('conceptualproduct3', 'product 3', '64GB SDHC', 'SanDisk', 4500, 0.00500, '001012');
INSERT INTO businessobject(id, botype) VALUES('conceptualproduct4', 'edu.byu.isys413.roytm.ConceptualProduct');
	INSERT INTO product(id, price) VALUES('conceptualproduct4', 2500);
	INSERT INTO conceptualproduct (id, description, productname, manufacturer, averagecost, commissionrate, sku)
		VALUES('conceptualproduct4', 'product 4', 'Camera Bag', 'Canon', 199000, 0.00200, '00113');
INSERT INTO businessobject(id, botype) VALUES('conceptualproduct5', 'edu.byu.isys413.roytm.ConceptualProduct');
	INSERT INTO product(id, price) VALUES('conceptualproduct5', 1000);
	INSERT INTO conceptualproduct (id, description, productname, manufacturer, averagecost, commissionrate, sku)
		VALUES('conceptualproduct5', 'product 5', 'Tulip Lens Hood', 'CamerasRUs', 800, 0.00200, '00201');
INSERT INTO businessobject(id, botype) VALUES('conceptualproduct6', 'edu.byu.isys413.roytm.ConceptualProduct');
	INSERT INTO product(id, price) VALUES('conceptualproduct6', 100000);
	INSERT INTO conceptualproduct (id, description, productname, manufacturer, averagecost, commissionrate, sku)
		VALUES('conceptualproduct6', 'product 6', 'D4100', 'Nikon', 95000, 0.06500, '002301');
INSERT INTO businessobject(id, botype) VALUES('conceptualproduct7', 'edu.byu.isys413.roytm.ConceptualProduct');
	INSERT INTO product(id, price) VALUES('conceptualproduct7', 200000);
	INSERT INTO conceptualproduct (id, description, productname, manufacturer, averagecost, commissionrate, sku)
		VALUES('conceptualproduct7', 'product 7', 'D7000', 'Canon', 165000, 0.09000, '201201');
INSERT INTO businessobject(id, botype) VALUES('conceptualproduct8', 'edu.byu.isys413.roytm.ConceptualProduct');
	INSERT INTO product(id, price) VALUES('conceptualproduct8', 250000);
	INSERT INTO conceptualproduct (id, description, productname, manufacturer, averagecost, commissionrate, sku)
		VALUES('conceptualproduct8', 'product 8', 'Canon EOS 5D', 'Canon', 245000, 0.10000, '201801');

--STOREPRODUCT TABLE;
CREATE TABLE storeproduct (
  id				VARCHAR(40) PRIMARY KEY REFERENCES businessobject(id),
  cproductid		VARCHAR(40) REFERENCES conceptualproduct(id),
  storeid			VARCHAR(40) REFERENCES store(id),
  quantityonhand	INTEGER,
  shelflocation		VARCHAR(25)
);
--Insert test data into storeproduct table;
INSERT INTO businessobject(id, botype) VALUES('sp1', 'edu.byu.isys413.roytm.StoreProduct');
INSERT INTO storeproduct(id, cproductid, storeid, quantityonhand, shelflocation) VALUES ('sp1', 'conceptualproduct1', 'store1', 10, 'D002');
INSERT INTO businessobject(id, botype) VALUES('sp2', 'edu.byu.isys413.roytm.StoreProduct');
INSERT INTO storeproduct(id, cproductid, storeid, quantityonhand, shelflocation) VALUES ('sp2', 'conceptualproduct2', 'store1', 5, 'D002');
INSERT INTO businessobject(id, botype) VALUES('sp3', 'edu.byu.isys413.roytm.StoreProduct');
INSERT INTO storeproduct(id, cproductid, storeid, quantityonhand, shelflocation) VALUES ('sp3', 'conceptualproduct3', 'store1', 6, 'D002');
INSERT INTO businessobject(id, botype) VALUES('sp4', 'edu.byu.isys413.roytm.StoreProduct');
INSERT INTO storeproduct(id, cproductid, storeid, quantityonhand, shelflocation) VALUES ('sp4', 'conceptualproduct4', 'store1', 8, 'D002');
INSERT INTO businessobject(id, botype) VALUES('sp5', 'edu.byu.isys413.roytm.StoreProduct');
INSERT INTO storeproduct(id, cproductid, storeid, quantityonhand, shelflocation) VALUES ('sp5', 'conceptualproduct5', 'store2', 9, 'D002');
INSERT INTO businessobject(id, botype) VALUES('sp6', 'edu.byu.isys413.roytm.StoreProduct');
INSERT INTO storeproduct(id, cproductid, storeid, quantityonhand, shelflocation) VALUES ('sp6', 'conceptualproduct6', 'store2', 2, 'D002');
INSERT INTO businessobject(id, botype) VALUES('sp7', 'edu.byu.isys413.roytm.StoreProduct');
INSERT INTO storeproduct(id, cproductid, storeid, quantityonhand, shelflocation) VALUES ('sp7', 'conceptualproduct7', 'store2', 11, 'D002');
INSERT INTO businessobject(id, botype) VALUES('sp8', 'edu.byu.isys413.roytm.StoreProduct');
INSERT INTO storeproduct(id, cproductid, storeid, quantityonhand, shelflocation) VALUES ('sp8', 'conceptualproduct8', 'store2', 12, 'D002');
INSERT INTO businessobject(id, botype) VALUES('sp9', 'edu.byu.isys413.roytm.StoreProduct');
INSERT INTO storeproduct(id, cproductid, storeid, quantityonhand, shelflocation) VALUES ('sp9', 'conceptualproduct1', 'store3', 16, 'D002');
INSERT INTO businessobject(id, botype) VALUES('sp10', 'edu.byu.isys413.roytm.StoreProduct');
INSERT INTO storeproduct(id, cproductid, storeid, quantityonhand, shelflocation) VALUES ('sp10', 'conceptualproduct2', 'store3', 13, 'D002');
INSERT INTO businessobject(id, botype) VALUES('sp11', 'edu.byu.isys413.roytm.StoreProduct');
INSERT INTO storeproduct(id, cproductid, storeid, quantityonhand, shelflocation) VALUES ('sp11', 'conceptualproduct3', 'store3', 3, 'D002');
INSERT INTO businessobject(id, botype) VALUES('sp12', 'edu.byu.isys413.roytm.StoreProduct');
INSERT INTO storeproduct(id, cproductid, storeid, quantityonhand, shelflocation) VALUES ('sp12', 'conceptualproduct4', 'store3', 8, 'D002');
INSERT INTO businessobject(id, botype) VALUES('sp13', 'edu.byu.isys413.roytm.StoreProduct');
INSERT INTO storeproduct(id, cproductid, storeid, quantityonhand, shelflocation) VALUES ('sp13', 'conceptualproduct5', 'store4', 18, 'D002');
INSERT INTO businessobject(id, botype) VALUES('sp14', 'edu.byu.isys413.roytm.StoreProduct');
INSERT INTO storeproduct(id, cproductid, storeid, quantityonhand, shelflocation) VALUES ('sp14', 'conceptualproduct6', 'store4', 2, 'D002');
INSERT INTO businessobject(id, botype) VALUES('sp15', 'edu.byu.isys413.roytm.StoreProduct');
INSERT INTO storeproduct(id, cproductid, storeid, quantityonhand, shelflocation) VALUES ('sp15', 'conceptualproduct7', 'store4', 3, 'D002');
INSERT INTO businessobject(id, botype) VALUES('sp16', 'edu.byu.isys413.roytm.StoreProduct');
INSERT INTO storeproduct(id, cproductid, storeid, quantityonhand, shelflocation) VALUES ('sp16', 'conceptualproduct8', 'store4', 1, 'D002');

--PHYSICALPRODUCT TABLE (extends product table);
CREATE TABLE physicalproduct (
  id					VARCHAR(40) PRIMARY KEY REFERENCES product(id),
  storeid				VARCHAR(40) REFERENCES store(id),
  conceptualproductid	VARCHAR(40) REFERENCES conceptualproduct(id),
  serialnumber			VARCHAR(40),
  shelflocation			VARCHAR(25),
  datepurchased			DATE,
  cost					double,
  status				VARCHAR(15),
  physicalproductcommissionrate		double
);
--Insert test data into the physicalproduct table;
INSERT INTO businessobject(id, botype) VALUES('physicalproduct1', 'edu.byu.isys413.roytm.PhysicalProduct');
	INSERT INTO product(id, price) VALUES('physicalproduct1', 220000);
	INSERT INTO physicalproduct(id, storeid, conceptualproductid, serialnumber, shelflocation, datepurchased, cost, status, physicalproductcommissionrate) 
		VALUES('physicalproduct1', 'store1', 'conceptualproduct1', '0123456', 'E002', '2013-01-13', 165000, 'Used - For Sale', 0.03000);
INSERT INTO businessobject(id, botype) VALUES('physicalproduct2', 'edu.byu.isys413.roytm.PhysicalProduct');
	INSERT INTO product(id, price) VALUES('physicalproduct2', 250000);
	INSERT INTO physicalproduct(id, storeid, conceptualproductid, serialnumber, shelflocation, datepurchased, cost, status, physicalproductcommissionrate) 
		VALUES('physicalproduct2', 'store2', 'conceptualproduct1', '98765', 'A001', '2013-02-06', 195000, 'New - For Sale', 0.05000);

--REVENUESOURCE TABLE;
CREATE TABLE revenuesource (
  id			VARCHAR(40) PRIMARY KEY REFERENCES businessobject(id),
  txnid			VARCHAR(40) REFERENCES transaction(id),
  revsrctype	VARCHAR(40)
);
--Insert test data into revenuesource table;

--SALE TABLE (extends revenuesource table);
CREATE TABLE sale (
	id			VARCHAR(40) PRIMARY KEY REFERENCES revenuesource(id),
	quantity	INTEGER,
	productid		VARCHAR(40) REFERENCES product(id)
);
INSERT INTO businessobject(id, botype) VALUES('sale1', 'edu.byu.isys413.roytm.Sale');
INSERT INTO revenuesource(id, txnid, revsrctype) VALUES('sale1', 'txn1', 'sale');
INSERT INTO sale(id, quantity, productid) VALUES('sale1', 1, 'conceptualproduct1');
INSERT INTO businessobject(id, botype) VALUES('sale2', 'edu.byu.isys413.roytm.Sale');
INSERT INTO revenuesource(id, txnid, revsrctype) VALUES('sale2', 'txn2', 'sale');
INSERT INTO sale(id, quantity, productid) VALUES('sale2', 1, 'physicalproduct1');

-- PERSON TABLE;
CREATE TABLE person (
  id           VARCHAR(40) PRIMARY KEY REFERENCES businessobject(id),
  firstname    VARCHAR(250),
  lastname     VARCHAR(250),
  phone        VARCHAR(100)
);
INSERT INTO businessobject(id, botype) VALUES ('person1', 'edu.byu.isys413.roytm.Person');
INSERT INTO person(id, firstname, lastname, phone) VALUES ('person1', 'Lisa', 'Simpson', '801-555-1234');
INSERT INTO businessobject(id, botype) VALUES ('person2', 'edu.byu.isys413.roytm.Person');
INSERT INTO person(id, firstname, lastname, phone) VALUES ('person2', 'Master', 'Chief', '801-555-4321');

--CUSTOMER TABLE (extends PERSON table);
CREATE TABLE customer (
  id		VARCHAR(40) PRIMARY KEY REFERENCES person(id),
  email		VARCHAR(250),
  address	VARCHAR(250),
  city		VARCHAR(250),
  state		VARCHAR(250),
  zipcode	VARCHAR(250)
);
--Insert test data into customer table;
INSERT INTO businessobject(id, botype) VALUES('customer1', 'edu.byu.isys413.roytm.Customer');
INSERT INTO person(id, firstname, lastname, phone) VALUES('customer1', 'Anna', 'Banana', '801-012-3947');
INSERT INTO customer(id, email, address, city, state, zipcode) VALUES('customer1', 'annabanana@gmail.com', '123 Happy Place', 'Provo', 'UT', '84604');
INSERT INTO businessobject(id, botype) VALUES('customer2', 'edu.byu.isys413.roytm.Customer');
INSERT INTO person(id, firstname, lastname, phone) VALUES('customer2', 'Manny', 'Manager', '801-221-1234');
INSERT INTO customer(id, email, address, city, state, zipcode) VALUES('customer2', 'mannytheman@gmail.com', '12 Buckle My Shoe Ln.', 'Draper', 'UT', '85123');

--MEMBERSHIP TABLE;
CREATE TABLE membership(
  id				VARCHAR(40) PRIMARY KEY REFERENCES businessobject(id),
  customerid		VARCHAR(40) REFERENCES customer(id),
  datecreated		DATE,
  membershipnumber	VARCHAR(40)
);
--Insert test data into the membership table;
INSERT INTO businessobject(id, botype) VALUES('membership1', 'edu.byu.isys413.roytm.Membership');
INSERT INTO membership(id, customerid, datecreated, membershipnumber) VALUES('membership1', 'customer1', '2013-01-10', '12345');
INSERT INTO businessobject(id, botype) VALUES('membership2', 'edu.byu.isys413.roytm.Membership');
INSERT INTO membership(id, customerid, datecreated, membershipnumber) VALUES('membership2', 'customer2', '2013-02-09', '67890');

-- EMPLOYEE TABLE (extends PERSON table);
CREATE TABLE employee (
  id             VARCHAR(40) PRIMARY KEY REFERENCES person(id),
  username       VARCHAR(250),
  birthdate      DATE,
  salary         NUMERIC(8,2),
  favoritenumber INT,
  iq             INT,
  distance       INT,
  storeid		 VARCHAR(40) REFERENCES store(id)
);
INSERT INTO businessobject(id, botype) VALUES ('employee1', 'edu.byu.isys413.roytm.Employee');
INSERT INTO person(id, firstname, lastname, phone) VALUES ('employee1', 'Bart', 'Simpson', '801-555-0222');
INSERT INTO employee(id, username, storeid) VALUES ('employee1', 'bartsipmson', 'store1');
INSERT INTO businessobject(id, botype) VALUES ('employee2', 'edu.byu.isys413.roytm.Employee');
INSERT INTO person(id, firstname, lastname, phone) VALUES ('employee2', 'Homer', 'Simpson', '801-555-3456');
INSERT INTO employee(id, username, storeid) VALUES ('employee2', 'homersimpson', 'store2');
INSERT INTO businessobject(id, botype) VALUES ('employee3', 'edu.byu.isys413.roytm.Employee');
INSERT INTO person(id, firstname, lastname, phone) VALUES ('employee3', 'Roy', 'Matsunaga', '801-555-0222');
INSERT INTO employee(id, username, storeid) VALUES ('employee3', 'roytm', 'store3');
INSERT INTO businessobject(id, botype) VALUES ('employee4', 'edu.byu.isys413.roytm.Employee');
INSERT INTO person(id, firstname, lastname, phone) VALUES ('employee4', 'Kelly', 'Deakyne', '801-555-0222');
INSERT INTO employee(id, username, storeid) VALUES ('employee4', 'kdeakyne', 'store3');

--COMMISSION TABLE;
CREATE TABLE commission (
  id			VARCHAR(40) PRIMARY KEY REFERENCES businessobject(id),
  empid			VARCHAR(40) REFERENCES employee(id),
  amount		INTEGER,
  commdate		DATE,
  paid			BOOLEAN,
  txnid			VARCHAR(40) REFERENCES transaction(id)
);
--Insert test data;
INSERT INTO businessobject(id, botype) VALUES('comm1', 'edu.byu.isys413.roytm.Commission');
INSERT INTO commission(id, empid, amount, commdate, paid, txnid) VALUES('comm1', 'employee1', 675, '2013-02-07', false, 'txn1');
INSERT INTO businessobject(id, botype) VALUES('comm2', 'edu.byu.isys413.roytm.Commission');
INSERT INTO commission(id, empid, amount, commdate, paid, txnid) VALUES('comm2', 'employee2', 30800, '2013-02-09', false, 'txn2');

-- DOG TABLE;
CREATE TABLE dog (
  id           VARCHAR(40) PRIMARY KEY REFERENCES businessobject(id),
  personid     VARCHAR(40) REFERENCES person(id),
  dogname      VARCHAR(250),
  breed        VARCHAR(250)
);
INSERT INTO businessobject(id, botype) VALUES ('dog1', 'edu.byu.isys413.roytm.Dog');
INSERT INTO dog(id, personid, dogname, breed) VALUES ('dog1', 'person1', 'Fluffy', 'Great Dane');
INSERT INTO businessobject(id, botype) VALUES ('dog2', 'edu.byu.isys413.roytm.Dog');
INSERT INTO dog(id, personid, dogname, breed) VALUES ('dog2', 'person1', 'Dasher', 'Beagle');
INSERT INTO businessobject(id, botype) VALUES ('dog3', 'edu.byu.isys413.roytm.Dog');
INSERT INTO dog(id, personid, dogname, breed) VALUES ('dog3', 'employee1', 'Nacho',  'Bloodhound');
INSERT INTO businessobject(id, botype) VALUES ('dog4', 'edu.byu.isys413.roytm.Dog');
INSERT INTO dog(id, personid, dogname, breed) VALUES ('dog4', 'employee2', 'T-Bone', 'Terrier');



-- CAR TABLE;
CREATE TABLE car (
  id           VARCHAR(40) PRIMARY KEY REFERENCES businessobject(id),
  brand        VARCHAR(250),
  model        VARCHAR(250)
);
INSERT INTO businessobject(id, botype) VALUES ('car1', 'edu.byu.isys413.roytm.Car');
INSERT INTO car(id, brand, model) VALUES ('car1', 'Honda', 'Accord');
INSERT INTO businessobject(id, botype) VALUES ('car2', 'edu.byu.isys413.roytm.Car');
INSERT INTO car(id, brand, model) VALUES ('car2', 'Dodge', 'Ram');
INSERT INTO businessobject(id, botype) VALUES ('car3', 'edu.byu.isys413.roytm.Car');
INSERT INTO car(id, brand, model) VALUES ('car3', 'Mazda', 'Miata');




-- PERSONCAR TABLE (many-to-many table that links owners to cars);
CREATE TABLE personcar (
  id           VARCHAR(40) PRIMARY KEY REFERENCES businessobject(id),
  carid        VARCHAR(40) REFERENCES car(id),
  ownerid      VARCHAR(40) REFERENCES person(id)
);
INSERT INTO businessobject(id, botype) VALUES ('personcar1', 'edu.byu.isys413.roytm.PersonCar');
INSERT INTO personcar(id, carid, ownerid) VALUES ('personcar1', 'car1', 'person1');
INSERT INTO businessobject(id, botype) VALUES ('personcar2', 'edu.byu.isys413.roytm.PersonCar');
INSERT INTO personcar(id, carid, ownerid) VALUES ('personcar2', 'car1', 'person2');
INSERT INTO businessobject(id, botype) VALUES ('personcar3', 'edu.byu.isys413.roytm.PersonCar');
INSERT INTO personcar(id, carid, ownerid) VALUES ('personcar3', 'car2', 'person2');
INSERT INTO businessobject(id, botype) VALUES ('personcar4', 'edu.byu.isys413.roytm.PersonCar');
INSERT INTO personcar(id, carid, ownerid) VALUES ('personcar4', 'car3', 'person2');

--CHECKS TABLE;
CREATE TABLE checks (
  id			VARCHAR(40) PRIMARY KEY REFERENCES businessobject(id),
  empid			VARCHAR(40) REFERENCES employee(id),
  checkdate		DATE,
  amount		INTEGER
);
INSERT INTO businessobject(id, botype) VALUES('check1', 'edu.byu.isys413.roytm.Checks');
INSERT INTO checks(id, empid, checkdate, amount) VALUES('check1', 'employee1', '2013/03/01', 675);
INSERT INTO businessobject(id, botype) VALUES('check2', 'edu.byu.isys413.roytm.Checks');
INSERT INTO checks(id, empid, checkdate, amount) VALUES('check2', 'employee2', '2013/03/01', 30800);

--PAYMENT TABLE;
CREATE TABLE payment (
  id		VARCHAR(40) PRIMARY KEY REFERENCES businessobject(id),
  amount	INTEGER,
  pmttype	VARCHAR(25)
);
--Insert test data;
INSERT INTO businessobject(id, botype) VALUES('pmt1', 'edu.byu.isys413.roytm.Payment');
INSERT INTO payment(id, amount, pmttype) VALUES('pmt1', 10675, 'cash');
INSERT INTO businessobject(id, botype) VALUES('pmt2', 'edu.byu.isys413.roytm.Payment');
INSERT INTO payment(id, amount, pmttype) VALUES('pmt2', 234300, 'cash');

--TRANSACTION TABLE;
CREATE TABLE transaction (
  id				VARCHAR(40) PRIMARY KEY REFERENCES businessobject(id),
  txndate			DATETIME,
  employeeid		VARCHAR(40) REFERENCES employee(id),
  storeid			VARCHAR(40) REFERENCES store(id),
  customerid		VARCHAR(40) REFERENCES customer(id),
  subtotal			INTEGER,
  tax				INTEGER,
  total				INTEGER,
  commissionid		VARCHAR(40) REFERENCES commission(id),
  journalentryid	VARCHAR(40) REFERENCES journalentry(id),
  paymentid			VARCHAR(40) REFERENCES payment(id)
);
--Insert test data;
INSERT INTO businessobject(id, botype) VALUES('txn1', 'edu.byu.isys413.roytm.Transaction');
	INSERT INTO transaction(id, txndate, employeeid, storeid, customerid, subtotal, tax, total, commissionid, journalentryid, paymentid)
		VALUES('txn1', '2013/02/07', 'employee1', 'store1', 'customer1', 10000, 675, 10675, 'comm1', 'je1', 'pmt1');
INSERT INTO businessobject(id, botype) VALUES('txn2', 'edu.byu.isys413.roytm.Transaction');
	INSERT INTO transaction(id, txndate, employeeid, storeid, customerid, subtotal, tax, total, commissionid, journalentryid, paymentid)
		VALUES('txn2', '2013/02/09', 'employee2', 'store2', 'customer2', 220000, 14300, 234300, 'comm2', 'je2', 'pmt2');

--ALTER store table to contain foreign key reference to employee table;
ALTER TABLE store ADD FOREIGN KEY (managerid) REFERENCES employee(id);


--FORRENT TABLE;
CREATE TABLE forrent (
	id			VARCHAR(40) PRIMARY KEY REFERENCES physicalproduct(id),
	timesrented integer
);
INSERT INTO businessobject(id, botype) VALUES ('forrent1', 'edu.byu.isys413.rtyler1.ForRent'); 
INSERT INTO product(id, price, prodtype) VALUES ('forrent1', 45.33, 'Physical');
INSERT INTO physicalproduct(id, storeid, conceptualproductid, serialnumber, shelflocation, datepurchased, cost, status, physicalproductcommissionrate) VALUES ('forrent1', 'store1', 'conceptualproduct1', '573023419672', 'Aisle 7 Shelf 4', '2012-03-05 15:23:53.523', 3.75, 'Available', 6.5);
INSERT INTO forrent(id, timesrented) VALUES ('forrent1', 3);
INSERT INTO businessobject(id, botype) VALUES ('forrent2', 'edu.byu.isys413.rtyler1.ForRent'); 
INSERT INTO product(id, price, prodtype) VALUES ('forrent2', 15.33, 'Physical');
INSERT INTO physicalproduct(id, storeid, conceptualproductid, serialnumber, shelflocation, datepurchased, cost, status, physicalproductcommissionrate) VALUES ('forrent2', 'store2', 'conceptualproduct2', '573021409675', 'Aisle 3 Shelf 1', '2012-01-03 12:02:34.132', 1.75, 'Not Available', 2.5);
INSERT INTO forrent(id, timesrented) VALUES ('forrent2', 4);
INSERT INTO businessobject(id, botype) VALUES ('forrent3', 'edu.byu.isys413.rtyler1.ForRent'); 
INSERT INTO product(id, price, prodtype) VALUES ('forrent3', 54.32, 'Physical');
INSERT INTO physicalproduct(id, storeid, conceptualproductid, serialnumber, shelflocation, datepurchased, cost, status, physicalproductcommissionrate) VALUES ('forrent3', 'store3', 'conceptualproduct3', '373023409111', 'Aisle 8 Shelf 3', '2012-02-01 11:21:13.312', 3.05, 'Available', 1.5);
INSERT INTO forrent(id, timesrented) VALUES ('forrent3', 5);


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




SET FOREIGN_KEY_CHECKS = 1;