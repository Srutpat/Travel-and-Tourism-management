create database travelManagement;
show databases;

use travelmanagement;
create table account(username varchar(12), name varchar(30), password varchar(8), security varchar(100), ans varchar(50));
show tables;
select * from account;

create table customer(username varchar(20) , id varchar(30), number varchar(30) , name varchar(30), gender varchar(10), country varchar(30), address varchar(50), phone varchar(10) , email varchar(30));
select * from customer;
create table bookedpackages(username varchar(20) , package varchar(30),persons int, id varchar(30), number varchar(30), phone varchar(10), total int);
select * from bookedpackages;
alter table bookedpackages modify total varchar(15);
describe bookedpackages;

create table hotel (name varchar(30),costperperson varchar(20),acRoom varchar(10),foodincluded varchar(15));
insert into hotel values('Hotel Grand Palace','6000','1000','1500');
insert into hotel values('The Royal Residency','16000','2500','1500');
insert into hotel values('Sunset Beach Resort','3800','700','500');

