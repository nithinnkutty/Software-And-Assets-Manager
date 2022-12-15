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
INSERT INTO employees (firstName, surname,username, password, department, authority, region ) VALUES ('Elliot','Noyes','elliot@noyes', 'password','Engineering','Super', 'Cardiff');
INSERT INTO employees (firstName, surname,username, password, department, authority, region ) VALUES ('Nithin','Narayanan Kutty','nithin@kutty', 'password', 'IT','General','India');
INSERT INTO employees (firstName, surname,username, password, department, authority, region ) VALUES ('Yanwen','Qiu','yanwen@qiu','password',  'Finance', 'General','China');
INSERT INTO employees (firstName, surname, department, authority, region) VALUES ('wenqi','Jia', 'Engineering', 'None','China');


SELECT * FROM employees WHERE firstName = 'Elliot';
SELECT region, ID FROM employees WHERE surname = 'Noyes';




INSERT INTO assets (employeeID, assetName, assetType, status, modelNumber, dateOfPurchase, dateOfExpiry, assignedOn ) VALUES (1, 'apple Iphone 11','Phone','New','WE1230','2020-12-17','2024-12-17','2021-12-17');
INSERT INTO assets (employeeID, assetName, assetType, status, modelNumber, dateOfPurchase, dateOfExpiry, assignedOn ) VALUES (1, 'dell 7440','Laptop','Needs Repair','BW1253','2021-05-17','2025-05-17','2021-12-17');
INSERT INTO assets (employeeID, assetName, assetType, status, version, dateOfPurchase, dateOfExpiry, assignedOn ) VALUES (2, 'PhotoShop','Software','Damage','V 12.03.02','2020-02-16','2024-05-17','2021-12-17');
INSERT INTO assets (assetName, assetType, status, version, dateOfPurchase, dateOfExpiry ) VALUES ('kaspersky','Software','New','V 10.30','2019-06-21','2023-05-17');
INSERT INTO assets (employeeID, assetName, assetType, status, modelNUmber, dateOfPurchase, dateOfExpiry ) VALUES (3,'Hp inspiron','Laptop','New','FG1456','2019-06-21','2023-05-17');
INSERT INTO assets (employeeID, assetName, assetType, status, modelNumber, dateOfPurchase, dateOfExpiry, assignedOn ) VALUES (4, 'dell 7440','Laptop','Needs Repair','BW1253','2021-05-17','2025-05-17','2021-12-17');
INSERT INTO assets ( assetName, assetType, status, modelNumber, dateOfPurchase, dateOfExpiry, assignedOn ) VALUES ( 'dell 7440','Laptop','Needs Repair','BW1253','2021-05-17','2025-05-17','2021-12-17');


INSERT INTO  employees (firstName, surname, authority, department, region ) VALUES ('Mathew','Philip','None', 'IT', 'India');


SELECT * FROM assets WHERE ID IN (1,4);
SELECT * FROM assets WHERE employeeID is null;
SELECT * FROM assets WHERE employeeID = 1;

SELECT assets.ID,assets.employeeID, assets.assetName, assets.assetType, assets.modelNumber, assets.version, assets.status, assets.dateOfPurchase,assets.dateOfExpiry,assets.assignedOn,employees.firstName,employees.surname,employees.department, employees.region FROM assets LEFT OUTER JOIN employees ON assets.employeeID = employees.ID;
SELECT assets.ID, assets.assetName, assets.assetType,employees.region, count(assets.employeeID) as assigned,count(assets.employeeID) as Unassigned FROM assets LEFT OUTER JOIN employees ON assets.employeeID = employees.ID group by assets.assetName,assets.assetType;
SELECT assets.assetName, assets.assetType, employees.region, count(assets.employeeID) as assigned, count(case when assets.employeeID = 0 then 1 end)+count(case when assets.employeeID is null then 1 end) as Unassigned, count(*) as total FROM assets LEFT OUTER JOIN employees ON assets.employeeID = employees.ID group by assets.assetName,assets.assetType,employees.region

