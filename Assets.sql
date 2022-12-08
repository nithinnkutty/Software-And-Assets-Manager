Create schema IF NOT EXISTS assetsManager;
use assetsManager;

DROP TABLE IF EXISTS assets;
DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS assigned;

CREATE TABLE IF NOT EXISTS `assets` (
  `ID`				INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `employeeID`		INTEGER,
  `assetName`		TEXT NOT NULL,
  `assetType`		TEXT NOT NULL,
  `modelNumber`		TEXT,
  `version`			TEXT,
  `status`			TEXT NOT NULL,
  `dateOfPurchase`	DATE NOT NULL,
  `dateOfExpiry`	DATE NOT NULL
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

CREATE TABLE `assigned` (
	`assetID`		INTEGER NOT NULL,
	`employeeID`	INTEGER NOT NULL,
	`assignedOn`	DATE NOT NULL,
    FOREIGN KEY(`assetID`) REFERENCES `assets`(`ID`),
	FOREIGN KEY(`employeeID`) REFERENCES `employees`(`ID`)
);

-- Look at the quotes 
INSERT INTO employees (firstName, surname,username, password, department, authority, region ) VALUES ('Elliot','Noyes','elliot@noyes', 'password','Engineering','Super', 'Cardiff');
INSERT INTO employees (firstName, surname,username, password, department, authority, region ) VALUES ('Nithin','Narayanan Kutty','nithin@kutty', 'password', 'IT','General','India');
INSERT INTO employees (firstName, surname,username, password, department, authority, region ) VALUES ('Yanwen','Qiu','yanwen@qiu','password',  'Finance', 'General','China');
INSERT INTO employees (firstName, surname, department, authority, region) VALUES ('wenqi','Jia', 'Engineering', 'None','China');


SELECT * FROM employees WHERE firstName = 'Elliot';
SELECT region, ID FROM employees WHERE surname = 'Noyes';




INSERT INTO assets (employeeID, assetName, assetType, status, modelNumber, dateOfPurchase, dateOfExpiry ) VALUES (1, 'apple Iphone 11','Phone','New','WE1230','2020-12-17','2024-12-17');
INSERT INTO assets (employeeID, assetName, assetType, status, modelNumber, dateOfPurchase, dateOfExpiry ) VALUES (1, 'dell 7440','Laptop','Needs Repair','BW1253','2021-05-17','2025-05-17');
INSERT INTO assets (employeeID, assetName, assetType, status, version, dateOfPurchase, dateOfExpiry ) VALUES (2, 'PhotoShop','Software','Damage','V 12.03.02','2020-02-16','2024-05-17');
INSERT INTO assets (assetName, assetType, status, version, dateOfPurchase, dateOfExpiry ) VALUES ('kaspersky','Software','New','V 10.30','2019-06-21','2023-05-17');




INSERT INTO `assigned`(assetID, employeeID, assignedOn ) VALUES (1,1,'2019-06-21');
INSERT INTO `assigned`(assetID, employeeID, assignedOn ) VALUES (2,1,'2020-02-25');
INSERT INTO `assigned`(assetID, employeeID, assignedOn ) VALUES (3,2,'2022-12-23');
INSERT INTO `assigned`(assetID, employeeID, assignedOn ) VALUES (4,4,'2021-09-06');


INSERT INTO  employees (firstName, surname, authority, department, region ) VALUES ('Mathew','Philip','None', 'IT', 'India');


SELECT employeeID FROM assigned WHERE assetID = 1;
SELECT * FROM assets WHERE ID IN (1,4);
SELECT * FROM assets WHERE employeeID = NULL;

SELECT assets.assetName, assets.assetType, employees.firstName, employees.region FROM employees JOIN assets ON assets.employeeID = employees.ID



