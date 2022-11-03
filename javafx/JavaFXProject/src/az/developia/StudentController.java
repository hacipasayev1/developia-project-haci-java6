package az.developia;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

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
	
	public ArrayList<Student>  students=new ArrayList<Student>();
	{
		students.add(new Student(1, "Haci", "Pasayev", LocalDate.of(1995, 10, 26), "Az", "Kisi"));
		students.add(new Student(2, "Perviz", "Veliyev", LocalDate.of(1996, 11, 12), "Az", "Kisi"));
		students.add(new Student(3, "James", "Gosling", LocalDate.of(1905, 10, 26), "Ingilis", "Kisi"));
		students.add(new Student(4, "Leman", "Kerimli", LocalDate.of(2002, 11, 13), "Az", "Qadin"));
	}

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
    void saveButtonAction(ActionEvent event) {
System.out.println(students);
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
		idColumn.setCellValueFactory(new PropertyValueFactory("id"));
		nameColumn.setCellValueFactory(new PropertyValueFactory("name"));
		surnameColumn.setCellValueFactory(new PropertyValueFactory("surname"));
		birthdayColumn.setCellValueFactory(new PropertyValueFactory("birthday"));
		sectotColumn.setCellValueFactory(new PropertyValueFactory("sector"));
		genderColumn.setCellValueFactory(new PropertyValueFactory("sector"));
	ObservableList<Student> list=FXCollections.observableArrayList();
	list.addAll(students);
	studentsTable.setItems(list);
		
	}


}
