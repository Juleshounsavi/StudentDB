package dao;
import java.util.*;
import model.Student;

public interface IStudentDAO {
    void createStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(int id);
    void updateStudent(int id, Student nvstudent);
    void deleteStudent(int id);
    List<Student> getStudentsByFiliere(String filiere);
}
