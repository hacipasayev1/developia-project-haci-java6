package az.developia.Kitabqeydiyyati.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import az.developia.Kitabqeydiyyati.model.Book;

@Repository
public class BookRepository {
	@Autowired
	private DataSource datasource;
public List<Book> findAll(){
List<Book> books=new ArrayList<>();
try {
	Connection conn=datasource.getConnection();
	Statement stmt=conn.createStatement();
	ResultSet rs=stmt.executeQuery("select * from books");
	while(rs.next()) {
		Book b=new Book(rs.getInt("id"), rs.getString("name"), rs.getInt("price"), rs.getDate("printdate"),rs.getString("author"));
		books.add(b);
	}
} catch (Exception e) {
	e.printStackTrace();
}
return books;
}
public void save(Book b) {
	if(b.getId()==null){
		try {
			Connection conn=datasource.getConnection();
			Statement stmt=conn.createStatement();
			stmt.executeUpdate("insert into books"
					+ " (name,price,printdate,author) "
					+ "values ('"+b.getName()+"','"+b.getPrice()+"','"+b.getPrintdate()+"','"+b.getAuthor()+"');");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		}else {
			try {
				Connection conn=datasource.getConnection();
				Statement stmt=conn.createStatement();
				stmt.executeUpdate("update books set name='"+b.getName()+"',price='"+b.getPrice()+"',printdate='"+b.getPrintdate()+"',author='"+b.getAuthor()+"' where id="+b.getId() );
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
}
public void deleteById(Integer id) {
	 try {
			Connection conn=datasource.getConnection();
			Statement stmt=conn.createStatement();
			stmt.executeUpdate("delete from books where id="+id);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
}
public Book findById(Integer id) {
Book b=new Book();
	
	try {
		Connection conn=datasource.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from books where id="+id);
		if (rs.next()) {
		 b=new Book(rs.getInt("id"), rs.getString("name"), rs.getInt("price"), rs.getDate("printdate"), rs.getString("author"));
			
		}
		conn.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return b;
}
}
