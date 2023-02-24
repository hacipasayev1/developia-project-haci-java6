insert into authority_list
(authority,description,author,admin,manager,teacher,student,parent)
values
('author','',1,0,0,0,0,0),
('admin','',0,1,0,0,0,0),
('manager','',0,0,1,0,0,0),
('teacher','',0,0,0,1,0,0),
('student','',0,0,0,0,1,0),
('parent','',0,0,0,0,0,1),

('save:admin','Admin məlumatını yadda saxlamaq',0,1,0,0,0,0),
('save:admin:course','Admin kurs məlumatını yadda saxlamaq',1,0,0,0,0,0),
('get:admin','Admin məlumatını görmək',1,0,0,0,0,0),
('delete:admin','Admin məlumatını silmək',1,0,0,0,0,0),
('change:status:admin','Adminin Statusunu Deyismek',1,0,0,0,0,0),
('edit:admin:course','Admin Melumatini redakte etmek',1,0,0,0,0,0),
('save:manager','',0,1,0,0,0,0),
('delete:manager','',0,1,0,0,0,0),
('get:manager','',0,1,0,0,0,0),
('save:teacher','',0,0,1,0,0,0),
('delete:teacher','',0,0,1,0,0,0),
('get:teacher','',0,0,1,0,0,0),
('edit:teacher','',0,0,1,0,0,0),
('save:parent','',0,0,1,0,0,1),
('delete:parent','',0,0,1,0,0,0),
('get:parent','',0,0,1,0,0,0),
('edit:parent','',0,0,1,0,0,0),
('save:student','',0,0,1,0,0,0),
('delete:student','',0,0,1,0,0,0),
('get:student','',0,0,1,0,0,0),
('edit:student','',0,0,1,0,0,0);

insert into users
(username,password,enabled)
values
('developia','{noop}1',1),
('Perviz','{noop}1',1),
('admin2','{noop}1',1),
('manager1','{noop}1',1),
('manager2','{noop}1',1),
('adminYoxlama','{noop}1',0),
('teacher1','{noop}1',1),
('teacher2','{noop}1',1),
('teacher3','{noop}1',1),
('parent1','{noop}1',1),
('parent2','{noop}1',1),
('parent3','{noop}1',1),
('cavid','{noop}1',1),
('mehemmed1','{noop}1',1),
('adil','{noop}1',1),
('yusif','{noop}1',1);

insert into authorities
(username,authority)
values('developia','author');

insert into authorities
(username,authority)
values('Perviz','admin');




 
   
 
insert into courses
(address) values ('kurs-1');

insert into admins
(name,username,course_id,creator_username) values ('Perviz','Perviz',1,'developia');
 
 
 insert into managers
(name,username,course_id,creator_username) values ('Perviz','Perviz',1,'developia');



