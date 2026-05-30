package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import model.Student;
import util.DBConnection;

public class IStudentDAOImpl implements IStudentDAO{
    @Override
    public void createStudent(Student student){

        String sql = "INSERT INTO Student(nom, prenom, filiere, moyenne) VALUES (?,?,?,?);";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1,student.getNom());
            ps.setString(2,student.getPrenom());
            ps.setString(3,student.getFiliere());
            ps.setFloat(4,student.getMoyenne());

            ps.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }



    @Override
    public List<Student> getAllStudents(){
        String sql = "SELECT * FROM Student";
        List<Student> liste = new ArrayList<>();

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Student st = new Student();
                st.setId(rs.getInt("id"));
                st.setNom(rs.getString("nom"));
                st.setPrenom(rs.getString("prenom"));
                st.setFiliere(rs.getString("filiere"));
                st.setMoyenne(rs.getFloat("moyenne"));
                liste.add(st);
            }
        }
        catch(SQLException e){
                e.printStackTrace();
        }

        return liste;
    }

    @Override
    public Student getStudentById(int id){
        String sql = "SELECT * FROM Student WHERE id =?";
        Student student = null;
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){


            ps.setInt(1,id);

            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()) {
                    student = new Student();
                    student.setId(rs.getInt("id"));
                    student.setNom(rs.getString("nom"));
                    student.setPrenom(rs.getString("prenom"));
                    student.setFiliere(rs.getString("filiere"));
                    student.setMoyenne(rs.getFloat("moyenne"));
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public void updateStudent(int id, Student nvstudent){
        String sql = "UPDATE Student SET nom = ?, prenom = ?, filiere = ?, moyenne = ? WHERE id = ?";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, nvstudent.getNom());
            ps.setString(2, nvstudent.getPrenom());
            ps.setString(3, nvstudent.getFiliere());
            ps.setFloat(4, nvstudent.getMoyenne());
            ps.setInt(5,id);

            ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }


    @Override
    public void deleteStudent(int id){
        String sql = "DELETE FROM Student WHERE id =?";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }


    @Override
    public List<Student> getStudentsByFiliere(String filiere){
        String sql = "SELECT * FROM Student WHERE filiere =?";
        List<Student> liste = new ArrayList<>();
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,filiere);

            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    Student st = new Student();
                    st.setId(rs.getInt("id"));
                    st.setNom(rs.getString("nom"));
                    st.setPrenom(rs.getString("prenom"));
                    st.setFiliere(rs.getString("filiere"));
                    st.setMoyenne(rs.getFloat("moyenne"));
                    liste.add(st);
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return liste;
    }
}
