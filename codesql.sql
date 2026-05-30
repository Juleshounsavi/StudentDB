

CREATE DATABASE StudentDB;


USE StudentDB;


CREATE TABLE Student(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(25),
    prenom VARCHAR(25),
    filiere VARCHAR(25),
    moyenne FLOAT
);



SELECT * FROM Student;
