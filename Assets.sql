Create schema IF NOT EXISTS assetsManager;
use assetsManager;

 DROP TABLE IF EXISTS assets;
 DROP TABLE IF EXISTS employees;

-- Database changing to one to many relationship.
-- Removed the assigned table 
CREATE TABLE IF NOT EXISTS `assets` (
  `ID`				INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `employeeID`		INTEGER,
  `assetName`		TEXT NOT NULL,
  `assetType`		TEXT NOT NULL,
  `modelNumber`		TEXT,
  `version`			TEXT,
  `status`			TEXT NOT NULL,
  `dateOfPurchase`	DATE NOT NULL,
  `dateOfExpiry`	DATE,
  `assignedOn`		DATE
);



CREATE TABLE IF NOT EXISTS `employees` (
  `ID`				INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `firstName`		TEXT NOT NULL,
  `surname`			TEXT NOT NULL,
  `username`  		TEXT,
  `password`		TEXT,
  `department`		TEXT,
  `authority`		TEXT NOT NULL,
  `region`  		TEXT NOT NULL
);


-- Look at the quotes 
INSERT INTO employees (firstName, surname,username, password, department, authority, region ) VALUES ('Ben','Shariff','ben@shariff', 'password','Engineering','Super', 'Cardiff');
INSERT INTO employees (firstName, surname,username, password, department, authority, region ) VALUES ('Heather','Perkins','heather@perkins', 'password', 'Engineering','Super','Cardiff');
INSERT INTO employees (firstName, surname,username, password, department, authority, region ) VALUES ('Wendy','Ivins','wendy@ivins','password',  'comsc', 'General','Cardiff');
INSERT INTO employees (firstName, surname,username, password, department, authority, region ) VALUES ('Louise','Knight','louise@knight','password',  'comsc', 'General','Cardiff');
INSERT INTO employees (firstName, surname,username, password, department, authority, region ) VALUES ('Daniela','Tsaneva','daniela@tsaneva','password',  'comsc', 'General','Cardiff');



INSERT INTO assets (employeeID, assetName, assetType, status, modelNumber, dateOfPurchase, dateOfExpiry, assignedOn ) VALUES (1, 'apple Iphone 11','Phone','New','WE1230','2020-12-17','2024-12-17','2021-12-17');
INSERT INTO assets (employeeID, assetName, assetType, status, modelNumber, dateOfPurchase, dateOfExpiry, assignedOn ) VALUES (1, 'dell 7440','Laptop','Needs Repair','BW1253','2021-05-17','2025-05-17','2021-12-17');
INSERT INTO assets (employeeID, assetName, assetType, status, version, dateOfPurchase, dateOfExpiry, assignedOn ) VALUES (2, 'PhotoShop','Software','Damage','V 12.03.02','2020-02-16','2024-05-17','2021-12-17');
INSERT INTO assets (assetName, assetType, status, version, dateOfPurchase, dateOfExpiry ) VALUES ('Kaspersky','Software','New','V 10.30','2019-06-21','2023-05-17');
INSERT INTO assets (employeeID, assetName, assetType, status, modelNUmber, dateOfPurchase, dateOfExpiry ) VALUES (3,'Hp inspiron','Laptop','New','FG1456','2019-06-21','2023-05-17');
INSERT INTO assets (employeeID, assetName, assetType, status, modelNumber, dateOfPurchase, dateOfExpiry, assignedOn ) VALUES (4, 'dell 7440','Laptop','Needs Repair','BW1253','2021-05-17','2025-05-17','2021-12-17');
INSERT INTO assets ( assetName, assetType, status, modelNumber, dateOfPurchase, dateOfExpiry, assignedOn ) VALUES ( 'dell 7440','Laptop','Needs Repair','BW1253','2021-05-17','2025-05-17','2021-12-17');





