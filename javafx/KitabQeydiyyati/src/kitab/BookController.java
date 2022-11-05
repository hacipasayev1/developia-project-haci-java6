package kitab;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class BookController implements Initializable{
	boolean updateMode;
int selectedid;
@FXML
private TextField searchTF;
	@FXML
    private Label rowCountLabel;
    @FXML
    private ComboBox<String> novCB;
	 @FXML
	    private TableView<Book> booktable;
	  @FXML
	    private TableColumn<Book, String> authorcolumn;

	    @FXML
	    private DatePicker dateTF;

	    @FXML
	    private TableColumn<Book, String> namecolumn;

	    @FXML
	    private TextField nameTF;

	    @FXML
	    private TextField priceTF;

	    @FXML
	    private TableColumn<Book, String> pricecolumn;

	    @FXML
	    private TextField authorTF;

	    @FXML
	    private Button saveButton;

	    @FXML
	    private TableColumn<Book, LocalDate> datecolumn;

	    @FXML
	    private TableColumn<Book, Integer> codecolumn;

	    @FXML
	    void save(ActionEvent event) throws SQLException {
String name=nameTF.getText();
String author=authorTF.getText();
String price =priceTF.getText();
LocalDate date=dateTF.getValue();
String nov=novCB.getValue();
Book b=new Book(0,name, author, price, date, nov);
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/java7","root","1234");
Statement st=conn.createStatement();
if(updateMode) {
	st.executeUpdate("update books set name='"+b.getName()+"',author='"+b.getAuthor()+"',price='"+b.getPrice()+"',date='"+b.getPrice()+"',nov='"+b.getNov()+"' where id="+selectedid);
	updateMode=false;
	saveButton.setText("Yeni kitab");
}else {
st.executeUpdate("insert into books (name,author,price,date,nov)"+"values('"+b.getName()+"','"+b.getAuthor()+"','"+b.getPrice()+"','"+b.getTarix()+"','"+b.getNov()+"'");
}   
nameTF.setText("");
	    showbooks();
	    }

	    @FXML
	    void delete(ActionEvent event) throws SQLException {
	    	Book selectedbook=booktable.getSelectionModel().getSelectedItem();
	    	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/java7","root","1234");
	    	Statement st=conn.createStatement();
	    	if(selectedbook==null) {
	    		JOptionPane.showMessageDialog(null, "kitab secilmeyib");
	    		return;
	    	}
	    	st.executeUpdate("delete from books where id="+selectedbook.getId());
	    	showbooks();
	    }

	    @FXML
	    void edit(ActionEvent event) throws SQLException {
	    	Book selectedbook=booktable.getSelectionModel().getSelectedItem();
	    	if(selectedbook==null) {
	    		JOptionPane.showMessageDialog(null, "kitab secilmeyib");
	    		return;
	    	}
	    	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/java7","root","1234");
	    	Statement st=conn.createStatement();
	    	nameTF.setText(selectedbook.getName());
	    	authorTF.setText(selectedbook.getAuthor());
	    	priceTF.setText(selectedbook.getPrice());
	    	dateTF.setValue(selectedbook.getTarix());
	    	novCB.setValue(selectedbook.getNov());
	    	updateMode=true;
	    	selectedid=selectedbook.getId();
	    	saveButton.setText("Yadda saxla");
	    }
	    @FXML
	    void search(ActionEvent event) throws SQLException {
String search=searchTF.getText();
showbooks("where name like '"+search+"'");

	    }
	    @FXML
	    void searchreleased(ActionEvent event) throws SQLException {
String search=searchTF.getText();
showbooks("where name like '"+search+"'");

	    }
	    private void showbooks(String a) throws SQLException {
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/java7","root","1234");
			Statement st=conn.createStatement();
			ResultSet setirler=st.executeQuery("select * from books "+a);
			ArrayList<Book> booklist=new ArrayList<Book>();
			while(setirler.next()) {
				Book b1=new Book();
				b1.setId(setirler.getInt("id"));
				b1.setAuthor(setirler.getString("author"));
				b1.setName(setirler.getString("name"));
				b1.setNov(setirler.getString("nov"));
				b1.setPrice(setirler.getString("price"));
				b1.setTarix(setirler.getDate("date").toLocalDate());
				booklist.add(b1);
			}
			ObservableList<Book> list=FXCollections.observableArrayList();
			list.addAll(booklist);
			booktable.setItems(list);
			rowCountLabel.setText("Say="+list.size());
		}

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			novCB.getItems().add("Psixologiya");
			novCB.getItems().add("roman");
			novCB.getItems().add("Kimya");
			codecolumn.setCellValueFactory(new PropertyValueFactory("id"));
			namecolumn.setCellValueFactory(new PropertyValueFactory("name"));
			authorcolumn.setCellValueFactory(new PropertyValueFactory("author"));
			pricecolumn.setCellValueFactory(new PropertyValueFactory("price"));
			datecolumn.setCellValueFactory(new PropertyValueFactory("tarix"));
			
		}
		private void showbooks() throws SQLException {
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/java7","root","1234");
			Statement st=conn.createStatement();
			ResultSet setirler=st.executeQuery("select * from books");
			ArrayList<Book> booklist=new ArrayList<Book>();
			while(setirler.next()) {
				Book b1=new Book();
				b1.setId(setirler.getInt("id"));
				b1.setAuthor(setirler.getString("author"));
				b1.setName(setirler.getString("name"));
				b1.setNov(setirler.getString("nov"));
				b1.setPrice(setirler.getString("price"));
				b1.setTarix(setirler.getDate("date").toLocalDate());
				booklist.add(b1);
			}
			ObservableList<Book> list=FXCollections.observableArrayList();
			list.addAll(booklist);
			booktable.setItems(list);
			rowCountLabel.setText("Say="+list.size());
		}
}
