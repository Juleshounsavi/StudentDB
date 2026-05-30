package model;

public class Student {
    private int id;
    private String nom;
    private String prenom;
    private String filiere;
    private float moyenne;

    public Student(){

    }

    public Student(String nom, String prenom, String filiere, float moyenne){
        this.nom = nom;
        this.prenom = prenom;
        this.filiere = filiere;
        this.moyenne = moyenne;

    }

    public int getId(){return id;}
    public String getNom(){return nom;}
    public String getPrenom(){return prenom;}
    public String getFiliere(){return filiere;}
    public float getMoyenne(){return moyenne;}



    public void setId(int id){this.id = id;}
    public void setNom(String nom){this.nom = nom;}
    public void setPrenom(String prenom){this.prenom = prenom;}
    public void setFiliere(String filiere){this.filiere = filiere;}
    public void setMoyenne(float moyenne){this.moyenne = moyenne;}



    @Override
    public String toString(){
        String rt = "\n===INFORMATIONS DE L'ELEVE===" +
                "\nId: " + id +
                "\nNom: " + nom +
                "\nPrenom: " + prenom +
                "\nFiliere: " + filiere +
                "\nMoyenne: " + moyenne;


        return rt;
    }



}
