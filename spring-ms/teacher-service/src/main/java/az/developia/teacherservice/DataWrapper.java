package az.developia.teacherservice;

import java.util.List;

import lombok.Data;
@Data
public class DataWrapper {
private List<Student> students;
private Student student;
private List<Teacher> teachers;
private List<TeacherDTO> teacherDtos;
}
