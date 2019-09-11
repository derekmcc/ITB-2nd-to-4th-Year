CREATE TABLE Staff (
  StaffID varchar (255) NOT NULL,
  Staff_First_Name varchar (255) NOT NULL,
  Staff_Surname varchar (255) NOT NULL,
  PRIMARY KEY (StaffID)
);

CREATE TABLE Product_Details(
  ProductID varchar(255) NOT NULL,
  ProductName varchar(255) NOT NULL,
  ProductPrice double NOT NULL,
  PRIMARY KEY (ProductID)
);

CREATE TABLE Transactions (
  ReceiptID varchar(255) NOT NULL,
  ReceiptDate date,
  StaffID varchar (255) NOT NULL,
  PRIMARY KEY (ReceiptID),
  CONSTRAINT Transactions_StaffID_FK FOREIGN KEY (StaffID) REFERENCES Staff(StaffID)
);

CREATE TABLE Products (
  ReceiptID varchar(255) NOT NULL,
  ProductID varchar(255) NOT NULL,
  QuantityOrdered INT (8) NOT NULL,
  PRIMARY KEY (ReceiptID, ProductID),
  CONSTRAINT Products_ReceiptID_FK FOREIGN KEY (ReceiptID) REFERENCES Transactions(ReceiptID),
  CONSTRAINT Products_ProductID_FK FOREIGN KEY (ProductID) REFERENCES Product_Details(ProductID)
);

INSERT INTO Staff (StaffID, Staff_First_Name, Staff_Surname) VALUES
('S123', 'Mary', 'Jones'),
('S345', 'John', 'Doe');

INSERT INTO Product_Details (ProductID, ProductName, ProductPrice) VALUES
('P001', 'Cornflakes', 0.99),
('P002', 'LowFatMilk', 1.89),
('P003', 'Breannans Bread', 1.50);

INSERT INTO Transactions (ReceiptID, ReceiptDate, StaffID) VALUES
('R001', 01/11/2016, 'S123'),
('R002', 02/11/2016, 'S345');

INSERT INTO Products (ReceiptID, ProductID, QuantityOrdered) VALUES
('R001', 'P001', 1),
('R001', 'P002', 2),
('R002', 'P003', 1);