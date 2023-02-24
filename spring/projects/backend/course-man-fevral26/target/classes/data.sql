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
('edit:student','',0,0,1,0,0,0)
;


insert into users
(username,password,enabled)
values
('developia','{noop}1',1),
('admin1','{noop}1',1),
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
select 'developia',authority from authority_list where author=1;

insert into authorities
(username,authority)
select 'admin1',authority from authority_list where admin=1;

insert into authorities
(username,authority)
select 'admin2',authority from authority_list where admin=1;


insert into authorities
(username,authority)
select 'adminYoxlama',authority from authority_list where admin=1;


insert into authorities
(username,authority)
select 'manager1',authority from authority_list where manager=1;

insert into authorities
(username,authority)
select 'manager2',authority from authority_list where manager=1;

insert into authorities
(username,authority)
select 'student1',authority from authority_list where student=1;

insert into authorities
(username,authority)
select 'cavid',authority from authority_list where student=1;

insert into authorities
(username,authority)
select 'mehemmed1',authority from authority_list where student=1;

insert into authorities
(username,authority)
select 'adil',authority from authority_list where student=1;

insert into authorities
(username,authority)
select 'yusif',authority from authority_list where student=1;



insert into authorities
(username,authority)
select 'teacher1',authority from authority_list where teacher=1;

insert into authorities
(username,authority)
select 'teacher2',authority from authority_list where teacher=1;

insert into authorities
(username,authority)
select 'teacher3',authority from authority_list where teacher=1;



insert into authorities
(username,authority)
select 'parent1',authority from authority_list where parent=1;

insert into authorities
(username,authority)
select 'parent2',authority from authority_list where parent=1;

insert into authorities
(username,authority)
select 'parent3',authority from authority_list where parent=1;


insert into teacher
(first_name,last_name,email,phone,birthday,username,password,course_id)
values
('Yusif','Alizada','yusifedu@gmail.com',0503409032,'1999-05-05','teacher1',1,1),
('Mahmud','Iskenderov','mahmudedu@gmail.com',0708505542,'1999-05-05','teacher2',2,1),
('Elikram','Mesimov','elikramedu@gmail.com',0557855498,'1999-05-05','teacher3',3,2);

insert into student
(first_name,last_name,email,phone,birthday,username,course_id)
values
('Cavid','Huseynzade','alicavid826@gmail.com',0997896576,'1999-05-05','cavid',1),
('Mehemmed','Melikov','mehemmedmelikov2007@gmail.com',0517893120,'1999-05-05','mehemmed1',1),
('Adil','Qafarov','Adilgafarov372@gmail.com',0554567631,'1999-05-05','adil',2),
('Elvin','Suleymanli','elvins@gmail.com',0512508910,'1999-05-05','elvin1',2);

insert into manager
(first_name,last_name,address,phone,email,username,course_id)
values
('Akif','Melikov','wgehhreth','0512407896','ehetheg','manager1',1),
('Akif2','Melikov2','wgehhreth','0512407896','ehetheg','manager2',2);

insert into admin
(first_name,last_name,email,address,phone,username,creator_username,admin_course_id)
values
('Admin 1 ad','Admin 1 soyad','nihat.h.2005@gmail.com','Baki','050050050','adminYoxlama','developia',1),
('Admin 2 ad','Admin 2 soyad','nihat.h.2005@gmail.com','Baki','050050050','admin1','developia',2),
('Admin 3 ad','Admin 3 soyad','nihat.h.2005@gmail.com','Baki','050050050','admin2','developia',3);

insert into admin_course_model
(email,address,phone,creator_username,enabled)
values
('nihat.h.2005@gmail.com','Baki','050050050','developia',1),
('nihat.h.2005@gmail.com','Baki','050050050','developia',1),
('nihat.h.2005@gmail.com','Baki','050050050','developia',1),
('nihat.h.2005@gmail.com','Baki','050050050','developia',1) 
 ;




insert into author
(first_name,last_name,email,phone,address,username)
values
('Yusif','Alizada','yusifedu@gmail.com','050-050-22-22','Baki','developia');

insert into parent 
(first_name,last_name,phone,address,email,username,course_id,CREATOR_USERNAME)
values
('Mehemmed','Melikov','+9940774556623','unvan-1','mehemmedmelikov2007@gmail.com','parent1',1,'manager1'),
('Mustafa','Kerimov','+9945698344','unvan-2','mehemmedmelikov2001@gmail.com','parent2',2,'manager2'),
('Amil','Ehmedzade','+9945677823','unvan-3','mehemmedmelikov1998@gmail.com','parent3',1,'manager1');

insert into training_category 
(name)
values
('Proqramlasdirma'),
('Dizayn'),
('Avtomatika'),
('Xarici dil'),
('Layihelendirme'),
('Tikinti')
;


insert into training
(name,training_category_id)
values
('Java',1),
('Python',1),
('PHP',1),
('HTML',1),
('CSS',1),
('Autocad',2),
('Photoshop',2),
('Corel Draw',2),
('Ingilis',4),
('Fransiz',4),
('Rus',4),
('Alman',4);

insert into training_lesson
(name,training_id)
values
('Java giriş',1),
('Java dəyişənlər',1),
('Java operatorlar',1),
('Java OOP',1),
('Java Exceptions',1),
('Java Multithreading',1),
('Java JDBC',1),

('Java JDBC',1),
('Java JDBC',1),
('Java JDBC',1),


('Python giriş',2),
('Python dəyişənlər',2),
('Python operatorlar',2),
('Python OOP',2),
('Python Exceptions',2),
('Python Multithreading',2);


insert into lesson_file
(name,file_name,TRAINING_LESSON_ID,type)
values
('Java giris derslik','java_giris.txt',1,'Dərslik'),
('Java giris video izah','001.mp4',1,'Video'),
('Java deyisenler derslik','java_deyisenler.txt',2,'Dərslik'),
('Java operatorlar derslik','java_operatorlar.txt',3,'Dərslik'),
('Python giris derslik','python_giris.txt',8,'Dərslik'),
('Python deyisenler derslik','python_deyisenler.txt',9,'Dərslik');

insert into teacher_group_notes(note,group_id,register_date) 
values

('Gelen ders yeni movzu kecmek',1,'2022-07-10 12:22:34'),
('Bu grupda angular tekrar olunmalidi',1,'2022-05-10 13:10:21'),
('qeyd1',2,'2022-03-12 15:16:45'),
('qeyd2',2,'2022-01-10 14:17:01'),
('qeyd3',2,'2022-05-23 19:38:58');



create view `contract_with_emails` 
as 
(select sc.id as contract_id,s.id as
student_id,sc.group_id as group_id,s.email as email from STUDENT_CONTRACTS sc
join student s on sc.student_id=s.id );




