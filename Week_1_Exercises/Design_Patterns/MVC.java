/*
 Exercise 10: Implementing the MVC Pattern
Scenario: 
You are developing a simple web application for managing student records using the MVC pattern.
Steps:
1.	Create a New Java Project:
o	Create a new Java project named MVCPatternExample.
2.	Define Model Class:
o	Create a class Student with attributes like name, id, and grade.
3.	Define View Class:
o	Create a class StudentView with a method displayStudentDetails().
4.	Define Controller Class:
o	Create a class StudentController that handles the communication between the model and the view.
5.	Test the MVC Implementation:
o	Create a main class to demonstrate creating a Student, updating its details using StudentController, and displaying them using StudentView.

 */

 // Student.java
class Student {
    private String name;
    private int id;
    private double grade;

    public Student(String name, int id, double grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}

// StudentView.java
class StudentView {
    public void displayStudentDetails(Student student) {
        System.out.println("Student Name: " + student.getName());
        System.out.println("Student ID: " + student.getId());
        System.out.println("Student Grade: " + student.getGrade());
    }
}

// StudentController.java
class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void updateStudentDetails(String name, int id, double grade) {
        model.setName(name);
        model.setId(id);
        model.setGrade(grade);
    }

    public void displayStudentDetails() {
        view.displayStudentDetails(model);
    }
}

// MVC.java
public class MVC {
    public static void main(String[] args) {
        // Create a student object
        Student student = new Student("Sewanti Dutta", 1, 85.5);

        // Create a student view object
        StudentView view = new StudentView();

        // Create a student controller object
        StudentController controller = new StudentController(student, view);

        // Display initial student details
        controller.displayStudentDetails();

        // Update student details
        controller.updateStudentDetails("Diya Dutta", 2, 90.5);

        // Display updated student details
        controller.displayStudentDetails();
    }
}