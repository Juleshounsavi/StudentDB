import dao.*;
import model.Student;
import service.StudentService;
import java.util.*;

public class Main {
    public static void main(String[] args){

        IStudentDAO dao = new IStudentDAOImpl();
        StudentService service = new StudentService(dao);


        Scanner scanner = new Scanner(System.in);


        int choix = -1;
        while(choix != 0){
            System.out.println("===INTERFACE INTERACTIVE DE TEST DU CODE===");
            System.out.println("Que opperation voulez vous effectuez?");
            System.out.println("1-Ajouter un etudiant");
            System.out.println("2-Afficher la liste de tous les etudiants");
            System.out.println("3-Chercher un etudiant via son id");
            System.out.println("4-Mettre a jour les infos d'un etudiant");
            System.out.println("5-Supprimer un etudiant");
            System.out.println("6-Afficher les etudiants de la filiere de votre choix");

            System.out.println("\nVeuillez faire un choix:");
            choix = scanner.nextInt();
            scanner.nextLine();

            if(choix == 1){
                System.out.println("Nom de l'etudiant:");
                String nom = scanner.nextLine();

                System.out.println("Prenom de l'etudiant:");
                String prenom = scanner.nextLine();

                System.out.println("Filiere de l'etudiant:");
                String filiere = scanner.nextLine();

                System.out.println("Moyenne de l'etudiant:");
                float moyenne = scanner.nextFloat();

                Student st = new Student(nom, prenom, filiere, moyenne);
                service.createStudent(st);
            } else if(choix == 2) {
                List<Student> liste = service.getAllStudents();
                for(Student s:liste){
                    System.out.println(s);
                }
            } else if(choix == 3) {
                System.out.println("Entrer le id de l'etudiant:");
                int id = scanner.nextInt();
                Student s = service.getStudentById(id);
                System.out.println(s);
            } else if(choix == 4){
                System.out.println("Entrer le id de l'etudiant:");
                int id = scanner.nextInt();

                scanner.nextLine();

                System.out.println("Nouveau nom de l'etudiant:");
                String nom = scanner.nextLine();

                System.out.println("Nouveau prenom de l'etudiant:");
                String prenom = scanner.nextLine();

                System.out.println("Nouvelle filiere de l'etudiant:");
                String filiere = scanner.nextLine();

                System.out.println("Nouvelle moyenne de l'etudiant:");
                float moyenne = scanner.nextFloat();

                Student nvst = new Student(nom, prenom, filiere, moyenne);
                nvst.setId(id);
                service.updateStudent(id,nvst);
            } else if(choix == 5){
                System.out.println("Entrer le id de l'etudiant:");
                int id = scanner.nextInt();
                service.deleteStudent(id);
                scanner.nextLine();
            } else if(choix == 6){
                System.out.println("Entrer le nom de la filiere:");
                String filiere = scanner.nextLine();
                List<Student> liste = service.getStudentsByFiliere(filiere);
                for(Student s:liste){
                    System.out.println(s);
                }
            }
        }
    }
}
