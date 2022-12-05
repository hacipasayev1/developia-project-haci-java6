package az.developia.springmvcjdbc.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import az.developia.springmvcjdbc.model.Student;

@Repository
public class StudentRepository {
@Autowired
private DataSource dataSource;

 public List<Student> findAll(){
	List<Student> students=new ArrayList<>();
	try {
		Connection conn=dataSource.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from students");
		while(rs.next()) {
			Student s=new Student(rs.getInt("id"), rs.getString("name"), rs.getString("surname"), rs.getString("phone"), rs.getString("address"), rs.getString("email"), rs.getDate("birthday"), rs.getString("sector"));
			students.add(s);
		}conn.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return students;
	
}
 public void deleteById(Integer id) {
	 try {
			Connection conn=dataSource.getConnection();
			Statement stmt=conn.createStatement();
		stmt.executeUpdate("delete from students where id="+id);
		} catch (Exception e) {
			e.printStackTrace();
		}
}
public void save(Student s) {
	try {
		Connection conn=dataSource.getConnection();
		Statement stmt=conn.createStatement();
		if(s.getId()==null) {
			stmt.executeUpdate("insert into students "
					+ "(name,surname,phone,address,email,birthday,sector)"
					+ " values('"+s.getName()+"','"+s.getSurname()+"','"+s.getPhone()+"','"+s.getAddress()+"','"+s.getEmail()+"','"+s.getBirthday()+"','"+s.getSector()+"');");
		}else {
			stmt.executeUpdate("update students set name='"+s.getName()+"' where id="+s.getId());
		}
	
	
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}
public Student findById(Integer id) {
	Student s=new Student();
	try {
		Connection conn=dataSource.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from students where id="+id);
		if(rs.next()) {
		s=new Student(rs.getInt("id"), rs.getString("name"), rs.getString("surname"), rs.getString("phone"), rs.getString("address"), rs.getString("email"), rs.getDate("birthday"), rs.getString("sector"));
		}conn.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return s;
}
}
