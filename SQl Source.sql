create database hotelmanagementsystem;
show databases;
use hotelmanagementsystem;
drop table login;
create table login(
username varchar(25) ,
 password varchar(25),
  primary key (username , password));

insert into login values('admin', '12345');

select * from login;
drop table employee; 
create table employee
(
name varchar(25) ,
 age varchar(10) check(age >10),
 gender varchar(15),
 job varchar(30),
 salary varchar(15),
 phone varchar(15),
 email varchar(50),
 CNIC varchar(50) primary key 

  
    );
    CREATE TABLE emplogin (
    CNIC VARCHAR(15),
    username VARCHAR(50) ,
    password VARCHAR(255) ,
    primary key (CNIC, username, password),
     FOREIGN KEY (CNIC) REFERENCES employee (CNIC),
      FOREIGN KEY (username,password) REFERENCES login(username,password)
);

CREATE TABLE roomlogin (
    roomnumber VARCHAR(15),
    username VARCHAR(50) ,
    password VARCHAR(255) ,
    primary key (roomnumber, username, password),
      FOREIGN KEY (roomnumber) REFERENCES room(roomnumber),
      FOREIGN KEY (username,password) REFERENCES login(username,password)

    );
    CREATE TABLE customeroom (
    roomnumber VARCHAR(15),
    number VARCHAR(15),
    primary key (roomnumber, number),
          FOREIGN KEY (roomnumber) REFERENCES room(roomnumber),
      FOREIGN KEY (number) REFERENCES customer(number)

    );
      CREATE TABLE empdpt (
    CNIC VARCHAR(15),
    department VARCHAR(255) ,
    primary key (CNIC, department),
          FOREIGN KEY (CNIC) REFERENCES employee(CNIC),
      FOREIGN KEY (department) REFERENCES department(department)

);
describe empolyee;
select * from employee;
CREATE TABLE room (
    roomnumber VARCHAR(10) PRIMARY KEY,
    availability VARCHAR(20),
    cleaning_status VARCHAR(20),
    price VARCHAR(20),
    bed_type VARCHAR(20) CHECK (bed_type IN ('Single Bed', 'Double Bed'))
);
drop table room;

select * from room; 


update room set availability = 'Available' where roomnumber = '103';
drop table driver;
create table driver
( 
 CNIC varchar(50) primary key ,
name varchar(20), 
age varchar(10) check (age >10),
 gender varchar(15),
 company varchar(100) ,
 brand varchar(20), 
 available varchar(20),
 location varchar(40));

select * from driver;



drop table customer;
create table customer(
document varchar(20) ,
 number varchar(30) primary key ,
 name varchar(30),
 gender varchar(15),
 country varchar(20),
 room varchar(10) ,
 checkintime varchar(80),
 deposit varchar(20),
   FOREIGN KEY (number) REFERENCES custro (roomnumber)

 
 );

select * from customer;
drop table department;
create table department(
department varchar(30) primary key,
 budget varchar(30)
 );
 
insert into department values('Front Office','500000');
insert into department values('Housekeeping', '40000');
insert into department values('Food and Beverage', '23000');
insert into department values('Kitchen or Food Production', '540000');
insert into department values('Security', '320000');

select * from department;
select * from employee;
select * from driver;
select * from customer ;