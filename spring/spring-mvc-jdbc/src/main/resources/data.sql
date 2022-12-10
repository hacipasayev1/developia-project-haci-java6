CREATE TABLE students (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(45) DEFAULT NULL,
  surname varchar(45) DEFAULT NULL,
  phone varchar(45) DEFAULT NULL,
  address varchar(245) DEFAULT NULL,
  sector varchar(45) DEFAULT NULL,
   birthday date DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  PRIMARY KEY (id)
) ;


insert into students
(name,surname,phone,email,address,birthday,sector) values
('ad1','soyad1','033','email1@mail.ru','unvan1','2000-06-09','Az'),
('ad2','soyad1','033','email1@mail.ru','unvan1','2000-06-09','Az'),
('ad3','soyad1','033','email1@mail.ru','unvan1','2000-06-09','Az'),
('ad4','soyad1','033','email1@mail.ru','unvan1','2000-06-09','Az');


create table users (username varchar(50),
password varchar(150),
enabled int);


create table authorities (username varchar(50),
authority varchar(50));


insert into users
(username,password,enabled)
values
('Haci','{bcrypt}$2a$12$Fqzq0ZlFEaZ/6h1zBbCvaeHmGB7iZ3PHYX8CH94gAIyoFUL5h5Uf',1),
('Anar','{bcrypt}$2a$12$11rFLZ1WEyqUkaaV6Ahj1upUQIdQQPUG9ZidmkGEiEKaOamm9iuLi',1),
('Perviz','{noop}1234',0),
('Orxan','{noop}5678',1),
('Kenan','{noop}2356',0);

insert into authorities
(username,authority)
values
('Haci','Admin'),
('Anar','teacher'),
('Perviz','parent'),
('Orxan','manager'),
('Kenan','receptionist');