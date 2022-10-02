show databases;

Create database sb007;

USE sb007;



CREATE TABLE Employees(
     	id int NOT NULL PRIMARY KEY,
     	age int NOT NULL,
    	firstName varchar (255),
     	lastName varchar (255)
     );
     
     
           
SELECT * FROM Employees;


INSERT INTO Employees VALUES (100, 21, 'JACK', 'EDITION');
INSERT INTO Employees VALUES (101, 22, 'RUSTY', 'COLTONS');
INSERT INTO Employees VALUES (102, 23, 'MOHAN', 'P');
INSERT INTO Employees VALUES (103, 24, 'PALANI', 'K');
INSERT INTO Employees VALUES (104, 25, 'SHRI', 'KANTA');
INSERT INTO Employees VALUES (105, 26, 'WILMAN', 'KALA');
INSERT INTO Employees VALUES (106, 69, 'anil', 'rawat');



CREATE TABLE STUDENT(
		STUDENT_ID int NOT NULL PRIMARY KEY,
		STUDENT_AGE int NOT NULL,
		STUDENT_FNAME varchar (255),
		STUDENT_LNAME varchar (255)
);


select * from STUDENT;


SELECT * FROM STUDENT WHERE STUDENT_ID=501;




DELIMITER //

CREATE PROCEDURE GetAllStudent()
BEGIN
	SELECT *  FROM STUDENT;
END //

DELIMITER ;



CREATE TABLE BOOKS(
     	BOOK_ID int NOT NULL PRIMARY KEY,
     	BOOK_NAME varchar (255),
     	BOOK_AUTHOR varchar (255),
     	BOOK_PUBLICATION varchar (255),
     	BOOK_PRICE int ,
     	BOOK_ISBN int
     );
     
     select * from BOOKS;
     
     
      CREATE TABLE USERS(
     	USER_NAME varchar (255),
     	USER_PASSWORD varchar (255)
     );
     
     select * from USERS;
     
     INSERT INTO USERS VALUES ('admin','admin@1234');
		INSERT INTO USERS VALUES ('root','root@1234');
        
        SELECT * FROM USERS WHERE USER_NAME = 'admin' AND USER_PASSWORD = 'admin@1234';
     