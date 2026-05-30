package service;
import model.Student;
import dao.IStudentDAO;
import dao.IStudentDAOImpl;
import java.util.*;

public class StudentService {
    private IStudentDAO studentDAO;

    public StudentService(IStudentDAO studentDAO){
        this.studentDAO = studentDAO;
    }

    public void createStudent(Student student){
        if (student == null) {
            System.out.println("Student null");
            return;
        }

        if (student.getNom() == null || student.getNom().isBlank()) {
            System.out.println("Nom invalide");
            return;
        }

        if (student.getPrenom() == null || student.getPrenom().isBlank()) {
            System.out.println("Prenom invalide");
            return;
        }

        if (student.getFiliere() == null || student.getFiliere().isBlank()) {
            System.out.println("Filiere invalide");
            return;
        }

        if (student.getMoyenne() < 0 || student.getMoyenne() > 20) {
            System.out.println("Moyenne invalide (0-20)");
            return;
        }

        studentDAO.createStudent(student);

    }


    public List<Student> getAllStudents(){
        return studentDAO.getAllStudents();
    }

    public Student getStudentById(int id){
        if(id<=0){
            System.out.println("ID invalide.");
            return null;
        }
        return studentDAO.getStudentById(id);
    }


    public void updateStudent(int id, Student nvstudent){
        if (nvstudent == null || nvstudent.getId() <= 0) {
            System.out.println("Student invalide");
            return;
        }
        studentDAO.updateStudent(id, nvstudent);
    }


    public void deleteStudent(int id){
        if (id <= 0) {
            System.out.println("ID invalide");
            return;
        }
        studentDAO.deleteStudent(id);
    }


    public List<Student> getStudentsByFiliere(String filiere){
        return studentDAO.getStudentsByFiliere(filiere);
    }



}
