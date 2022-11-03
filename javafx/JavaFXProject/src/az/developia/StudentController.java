package az.developia;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class StudentController implements Initializable {
	

	

    @FXML
    private TextField surnameTF;

    @FXML
    private TextField nameTF;

    @FXML
    private ToggleGroup gender;

    @FXML
    private ComboBox<String> sectorCB;

    @FXML
    private Label rowCountLabel;

    @FXML
    private DatePicker birthdayDP;

    @FXML
    private TableColumn<Student, LocalDate> birthdayColumn;

    @FXML
    private TableColumn<Student, String> genderColumn;

    @FXML
    private RadioButton femaleRB;

    @FXML
    private TableColumn<Student, String> surnameColumn;

    @FXML
    private RadioButton maleRB;

    @FXML
    private TableColumn<Student, String> nameColumn;

    @FXML
    private TableColumn<Student, String> sectotColumn;

    @FXML
    private TableView<Student> studentsTable;

    @FXML
    private TableColumn<Student, Integer> idColumn;

    @FXML
    void saveButtonAction(ActionEvent event) throws SQLException {
String name=nameTF.getText();
if(name.isEmpty()) {
	JOptionPane.showMessageDialog(null, "adi yaz");
	return;
}
String surname=surnameTF.getText();
LocalDate birthday=birthdayDP.getValue();
String sector=sectorCB.getValue();
String gender="";
if(maleRB.isSelected()) {
	gender="Kisi";
}else {
	gender="Qadin";
}
Student student=new Student(0, name, surname, birthday, sector, gender);
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/java6", "root", "1234");
Statement st=conn.createStatement();
st.executeUpdate("insert into students (name,surname,birthday,sector,gender)"+"values('"+student.getName()+"','"+student.getSurname()+"','"+student.getBirthday()+"','"+student.getSector()+"','"+student.getGender()+"')");
   showStudents();//bu metod nece bele cagrilir?
    }
/**
 * @throws SQLException
 */
private void showStudents() throws SQLException {
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/java6", "root", "1234");
	Statement st=conn.createStatement();
	ResultSet setirler=st.executeQuery("select * from students");
	ArrayList<Student> studentsList=new ArrayList<Student>();
	while(setirler.next()) {
		Student s=new Student();
		s.setId(setirler.getInt("id"));
		s.setName(setirler.getString("name"));
		s.setSurname(setirler.getString("surname"));
		s.setBirthday(setirler.getDate("birthday").toLocalDate());
		s.setSector(setirler.getString("sector"));
		s.setGender(setirler.getString("gender"));
		studentsList.add(s);
	}
	ObservableList<Student> list=FXCollections.observableArrayList();
	list.addAll(studentsList);
	studentsTable.setItems(list);
	rowCountLabel.setText("Say="+list.size());
}
    @FXML
    void deleteButtonAction(ActionEvent event) {

    }

    @FXML
    void editButtonAction(ActionEvent event) {

    }

	/**
	 *
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		idColumn.setCellValueFactory(new PropertyValueFactory("id"));//burda id deyisendi yoxsa sutun adidi?
		nameColumn.setCellValueFactory(new PropertyValueFactory("name"));
		surnameColumn.setCellValueFactory(new PropertyValueFactory("surname"));
		birthdayColumn.setCellValueFactory(new PropertyValueFactory("birthday"));
		sectotColumn.setCellValueFactory(new PropertyValueFactory("sector"));
		genderColumn.setCellValueFactory(new PropertyValueFactory("gender"));
try {
	showStudents();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		
	}


}
