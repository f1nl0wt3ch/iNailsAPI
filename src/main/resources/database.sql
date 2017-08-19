CREATE DATABASE iNails;

CREATE TABLE Category(
  CategoryID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  Name varchar(255) NOT NULL
);

CREATE TABLE Service(
 ServiceID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 Name CHAR(225) NOT NULL,
 CategoryID_FK int,
 Time double,
 Price double,
 FOREIGN KEY(CategoryID_FK) REFERENCES Category(CategoryID)
);

CREATE TABLE Status(
 StatusID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 Name varchar(255)
)

CREATE TABLE Artist(
 ArtistID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 Name varchar(255) NOT NULL UNIQUE,
 Phone varchar(20),
 Picture varchar(255)
)

CREATE TABLE Time(
 TimeID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 Time varchar(255) NOT NULL,
 ArtistID_FK INT NOT NULL,
 Date datetime NOT NULL,
 FOREIGN KEY(ArtistID_FK) REFERENCES Artist(ArtistID)
);

CREATE TABLE Customer(
 CustomerID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 Name varchar(255),
 Birthday Datetime,
 Address text,
 Phone varchar(20),
 Email varchar(255)
)


CREATE TABLE Orders(
OrderID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
CustomerID_FK int,
ArtistID_FK int,
StatusID_FK int,
Date Datetime,
FOREIGN KEY(CustomerID_FK) REFERENCES Customer(CustomerID),
FOREIGN KEY(ArtistID_FK) REFERENCES Artist(ArtistID),
FOREIGN KEY(StatusID_FK) REFERENCES Status(StatusID));

CREATE TABLE Cart(
  ServiceID_FK INT,
  OrderID_FK INT,
  FOREIGN KEY(ServiceID_FK) REFERENCES Service(ServiceID),
  FOREIGN KEY(OrderID_FK) REFERENCES Orders(OrderID)
);

INSERT INTO Status(Name) VALUES ("Paid"),("Pending"),("Cancel");
INSERT INTO Category(Name) VALUES ("Category1"),("Category2"),("Category3");
INSERT INTO Service(Name,CategoryID_FK,Time,Price) VALUES ("Service11",1,15,10),("Service21",1,20,20),("Service22",2,15,15),("Service31",1,25,30),("Service33",3,30,60);
INSERT INTO Artist(Name) VALUES ("Artist1"),("Artist2"),("Artist3"),("Artist4");
INSERT INTO Customer(Name) VALUES ("Customer1"),("Customer2"),("Customer3"),("Customer4");
INSERT INTO Orders(CustomerID_FK,ArtistID_FK,StatusID_FK) VALUES (1,1,1),(2,2,2),(3,1,1),(4,3,1);
INSERT INTO Cart(OrderID_FK, ServiceID_FK) VALUES (1,1),(1,2),(1,3),(2,2),(3,2),(3,3),(4,4),(4,1);
INSERT INTO Time(Time,ArtistID_FK,Date) VALUES ("8:00",1,"2017-12-12"),("12:00",2,"2017-06-14"),("13:00",2,"2017-08-12"),("17:00",3,"2017-08-22");

SELECT o.OrderID,o.Date, GROUP_CONCAT(s.Name) as Services,sum(s.Time) as Duration,sum(s.price) as TotalPayment,c.Name as Customer,c.Phone as CustomerPhone,st.Name as Status, t.Time as TimeReservation, t.Date as DateReservation
FROM Artist as a, Time as t,Orders as o
INNER JOIN Customer as c ON c.CustomerID = o.CustomerID_FK
INNER JOIN Cart as ca ON ca.OrderID_FK = o.OrderID
INNER JOIN Status as st ON st.StatusID = o.StatusID_FK
JOIN Service as s WHERE s.ServiceID = ca.ServiceID_FK AND a.ArtistID= t.ArtistID_FK AND t.TimeID = O.TimeID_FK AND o.OrderID=1;
