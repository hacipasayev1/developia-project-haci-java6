
insert into students
(name,surname,phone,email,address,birthday,sector) values
('ad1','soyad1','033','email1@mail.ru','unvan1','2000-06-09','Az'),
('ad2','soyad1','033','email1@mail.ru','unvan1','2000-06-09','Az'),
('ad3','soyad1','033','email1@mail.ru','unvan1','2000-06-09','Az'),
('ad4','soyad1','033','email1@mail.ru','unvan1','2000-06-09','Az');

insert into users
(username,password,enabled)
values
('u1','{noop}p1',1),
('u2','{noop}p2',1),
('u3','{noop}p3',1),
('u4','{noop}p4',1);

insert into authorities
(username,authority)
values
('u1','student:find:all'),
('u1','student:find:one'),
('u1','student:delete'),
('u2','student:find:one'),
('u3','student'),
('u4','manager');
