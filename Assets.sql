Create schema IF NOT EXISTS assetsManager;
use assetsManager;

DROP TABLE IF EXISTS assets;
DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS assigned;

CREATE TABLE IF NOT EXISTS `employees` (
  `ID`		INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `firstName`	TEXT NOT NULL,
  `surname`	TEXT NOT NULL,
  `adminStatus`  TEXT,
  `department`	TEXT NOT NULL,
  `region`	TEXT NOT NULL,
  `homeLocation`  TEXT NOT NULL,
  `pin`  numeric
);

-- Look at the quotes 
INSERT INTO employees (firstName, surname,adminStatus, department, region, homeLocation ) VALUES ('Ian','Cooper','super', 'COMSC','UK', 'Devon');
INSERT INTO employees (firstName, surname,adminStatus, department, region, homeLocation ) VALUES ('Chris','Gwilliams','general',  'Law', 'UK','cardiff');
INSERT INTO employees (firstName, surname,adminStatus, department, region, homeLocation ) VALUES ('Dave','Sheppard','',  'Medicine', 'INDIA','Chennai');
INSERT INTO employees (firstName, surname,adminStatus, department, region, homeLocation) VALUES ('Wendy','Ivins','', 'Finance', 'US','New Mexico');


SELECT * FROM employees WHERE firstName = 'Ian';
SELECT homeLocation, ID FROM employees WHERE surname = 'Cooper';

CREATE TABLE IF NOT EXISTS `assets` (
  `ID`		INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `assetName`	TEXT NOT NULL,
  `assetType`	TEXT NOT NULL,
   `status`		TEXT NOT NULL,
  `dateOfPurchase`	DATE NOT NULL,
  `dateOfExpiry`	DATE NOT NULL
);


INSERT INTO assets (assetName, assetType, status, dateOfPurchase, dateOfExpiry ) VALUES ('apple Iphone 11','Phone','New','2020-12-17','2024-12-17');
INSERT INTO assets (assetName, assetType, status, dateOfPurchase, dateOfExpiry ) VALUES ('dell 7440','Laptop','Repair','2021-05-17','2025-05-17');
INSERT INTO assets (assetName, assetType, status, dateOfPurchase, dateOfExpiry ) VALUES ('PhotoShop','Software','Damage','2020-02-16','2024-05-17');
INSERT INTO assets (assetName, assetType, status, dateOfPurchase, dateOfExpiry ) VALUES ('kaspersky','Software','New','2019-06-21','2023-05-17');


CREATE TABLE `assigned` (
	`assetID`	INTEGER NOT NULL,
	`employeeID`	INTEGER NOT NULL,
	`dateOfAssigning`	DATE
  -- ,
	-- FOREIGN KEY(`assetID`) REFERENCES `assets`(`ID`),
	-- FOREIGN KEY(`employeeID`) REFERENCES `employees`(`ID`)
);

INSERT INTO `assigned`(assetID, employeeID, dateOfAssigning ) VALUES (1,1,'2019-06-21');
INSERT INTO `assigned`(assetID, employeeID, dateOfAssigning ) VALUES (2,1,'2020-02-25');
INSERT INTO `assigned`(assetID, employeeID, dateOfAssigning ) VALUES (2,2,'2022-12-23');
INSERT INTO `assigned`(assetID, employeeID, dateOfAssigning ) VALUES (1,2,'2021-09-06');


INSERT INTO  employees (firstName, surname, adminStatus, department, region, homeLocation, pin ) VALUES ('Nithin','Narayanan kutty','super', 'comsc',  'UK', 'India', '689109');


SELECT employeeID FROM assigned WHERE assetID = 1;
SELECT * FROM assets WHERE ID IN (1,2);
SELECT * FROM assets WHERE ID IN (SELECT assetID FROM assigned WHERE employeeID = 1);
