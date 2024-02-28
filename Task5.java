import java.io.*;
import java.util.*;
class Student {
    String rollNumber;
    String name;
    String branch;
    int semester;
    int year;
    public Student(String rollNumber, String name, String branch, int semester, int year) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.branch = branch;
        this.semester = semester;
        this.year = year;
    }
    public String toString() {
        return rollNumber + "\t" + name + "\t" + branch + "\t" + semester + "\t" + year;
    }
}
class SeatingArrangement {
    int totalStudents;
    Map<String, Integer> seatMap;
    public SeatingArrangement(int totalStudents) {
        this.totalStudents = totalStudents;
        seatMap = new HashMap<>();
    }
    public void generateSeatingArrangement() {
        for (int i = 1; i <= totalStudents; i++) {
            seatMap.put("Seat-" + i, i);
        }
    }
    public void displaySeatingArrangement() {
        for (Map.Entry<String, Integer> entry : seatMap.entrySet()) {
            System.out.println(entry.getKey() + " -> Roll Number: " + entry.getValue());
        }
    }
}
class ExamSystem {
    Map<String, Student> studentDatabase;
    SeatingArrangement seatingArrangement;
    public ExamSystem() {
        studentDatabase = new HashMap<>();
    }
    public void registerStudent(Student student) {
        studentDatabase.put(student.rollNumber, student);
    }
    public void loginAsAdmin() {
        displayAdminMenu();
    }

    public void loginAsStudent() {
        displayStudentMenu();
    }
    public void displayAdminMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Register Student");
            System.out.println("2. Generate Seating Arrangement");
            System.out.println("3. Display Seating Arrangement");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    registerStudentFromInput();
                    break;
                case 2:
                    generateSeatingArrangement();
                    break;
                case 3:
                    displaySeatingArrangement();
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
    public void registerStudentFromInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter Student Details:");
        System.out.print("Roll Number: ");
        String rollNumber = scanner.next();
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Branch: ");
        String branch = scanner.next();
        System.out.print("Semester: ");
        int semester = scanner.nextInt();
        System.out.print("Year: ");
        int year = scanner.nextInt();
        Student student = new Student(rollNumber, name, branch, semester, year);
        registerStudent(student);
        System.out.println("Student registered successfully!");
    }
    public void generateSeatingArrangement() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the total number of students: ");
        int totalStudents = scanner.nextInt();
        seatingArrangement = new SeatingArrangement(totalStudents);
        seatingArrangement.generateSeatingArrangement();
        System.out.println("Seating arrangement generated successfully!");
    }
    public void displaySeatingArrangement() {
        if (seatingArrangement != null) {
            seatingArrangement.displaySeatingArrangement();
        } else {
            System.out.println("Seating arrangement not generated yet!");
        }
    }
    public void displayStudentMenu() {
        System.out.println("Student Menu:");
        System.out.println("1. View Seating Arrangement");
        System.out.println("2. Exit");
    }
}
public class Task5 {
    public static void main(String[] args) {
        ExamSystem examSystem = new ExamSystem();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nWelcome to Exam Seating Arrangement System!");
            System.out.println("1. Login as Admin");
            System.out.println("2. Login as Student");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    examSystem.loginAsAdmin();
                    break;
                case 2:
                    examSystem.loginAsStudent();
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }
}
