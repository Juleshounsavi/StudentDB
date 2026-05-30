# StudentDB 
 
> Application console Java de gestion d'étudiants, construite avec JDBC et MySQL en architecture DAO.

---

## Description
 
StudentDB est un projet Java démontrant une gestion complète d'une base de données étudiants via JDBC. L'application permet d'effectuer toutes les opérations CRUD (Créer, Lire, Mettre à jour, Supprimer) sur des enregistrements étudiants à travers une interface console interactive.

Le projet met en œuvre une architecture en couches propre et plusieurs design patterns classiques du développement logiciel : DAO pour l'accès aux données et Singleton pour la gestion de la connexion.

---

## Fonctionnalités

- Menu interactif en boucle via console
- Ajouter un étudiant (nom, prénom, filière, moyenne)
- Lister tous les étudiants enregistrés
- Rechercher un étudiant par son ID
- Filtrer les étudiants par filière
- Mettre à jour les informations d'un étudiant
- Supprimer un étudiant
---
 
## Architecture
```
StudentDB/
├── src/
│   ├── Main.java                   # Point d'entrée — menu interactif (Scanner)
│   ├── model/
│   │   └── Student.java            # Entité métier (POJO)
│   ├── dao/
│   │   ├── IStudentDAO.java        # Interface DAO
│   │   └── IStudentDAOImpl.java    # Implémentation JDBC
│   ├── service/
│   │   └── StudentService.java     # Couche service — validation métier
│   └── util/
│       └── DBConnection.java       # Singleton — gestion de la connexion MySQL
└── codesql.sql                     # Script de création de la base de données
```


## Couches applicatives
 
```
[ Main / Console ]
       ↓
[ StudentService ]     ← validation métier 
       ↓
[ IStudentDAOImpl ]    ← accès base de données via JDBC
       ↓
[ MySQL — table Student ]
```
 
---
 
## Technologies
 
| Technologie | Version |
|---|---|
| Java SE | 25.0.1 |
| JDBC | 4.3 |
| MySQL | 8.0.45 |
| MySQL Connector/J | 9.7.0 |
 
---
 
## Patterns & Concepts appliqués
 
- **DAO Pattern** — séparation de la logique d'accès aux données de la logique métier
- **Singleton Pattern** — instance unique de connexion à la base de données
- **PreparedStatement** — protection contre les injections SQL
- **try-with-resources** — fermeture automatique des ressources JDBC (Connection, PreparedStatement, ResultSet)
- **Interface Java** — abstraction de la couche DAO pour faciliter la maintenabilité
---
 
## Installation & Lancement
 
### Prérequis
 
- JDK 11 ou supérieur
- MySQL 8.0 ou supérieur
- MySQL Connector/J ajouté au classpath
### 1. Créer la base de données
 
Exécuter le script SQL fourni :
 
```sql
CREATE DATABASE StudentDB;
USE StudentDB;
 
CREATE TABLE Student (
    id    INT AUTO_INCREMENT PRIMARY KEY,
    nom     VARCHAR(25),
    prenom  VARCHAR(25),
    filiere VARCHAR(25),
    moyenne FLOAT
);
```
 
### 2. Configurer la variable d'environnement
 
Le mot de passe MySQL est lu depuis une variable d'environnement pour éviter tout credential en dur dans le code.
 
**Linux / macOS :**
```bash
export DB_PASSWORD=ton_mot_de_passe
```
 
**Windows (PowerShell) :**
```powershell
$env:DB_PASSWORD="ton_mot_de_passe"
```
 
### 3. Compiler et lancer
 
```bash
javac -cp .:mysql-connector-j-8.x.x.jar -d out src/**/*.java src/Main.java
java -cp .:out:mysql-connector-j-8.x.x.jar Main
```
 
---
 
## Aperçu
 
```
===INTERFACE INTERACTIVE DE TEST DU CODE===
Quelle opperation voulez vous effectuez?
1-Ajouter un etudiant
2-Afficher la liste de tous les etudiants
3-Chercher un etudiant via son id
4-Mettre a jour les infos d'un etudiant
5-Supprimer un etudiant
6-Afficher les etudiants de la filiere de votre choix
 
Veuillez faire un choix:
```
 

























