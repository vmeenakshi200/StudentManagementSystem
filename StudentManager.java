import java.io.*;
import java.util.*;

public class StudentManager {

    ArrayList<Student> students = new ArrayList<>();

    // Add Student
    void addStudent(Student student) {

        if (studentExists(student.id)) {
            System.out.println("Student ID already exists!");
            return;
        }

        students.add(student);
        System.out.println("Student Added Successfully!");
        saveStudents();
    }

    // Display Students
    void displayStudents() {

        if (students.isEmpty()) {
            System.out.println("No Students Found!");
            return;
        }

        System.out.println("\n===== STUDENT LIST =====");

        for (Student s : students) {
            System.out.println(
                "ID: " + s.id +
                ", Name: " + s.name +
                ", Age: " + s.age +
                ", Course: " + s.course
            );
        }
    }

    // Search Student
    void searchStudent(int id) {

        for (Student s : students) {

            if (s.id == id) {
                System.out.println("\nStudent Found!");
                System.out.println("ID: " + s.id);
                System.out.println("Name: " + s.name);
                System.out.println("Age: " + s.age);
                System.out.println("Course: " + s.course);
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    // Delete Student
    void deleteStudent(int id) {

        for (Student s : students) {

            if (s.id == id) {
                students.remove(s);
                System.out.println("Student Deleted Successfully!");
                saveStudents();
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    // Check Student ID
    boolean studentExists(int id) {

        for (Student s : students) {

            if (s.id == id) {
                return true;
            }
        }

        return false;
    }

    // Update Student
    void updateStudent(int id, int newAge, String newCourse) {

        for (Student s : students) {

            if (s.id == id) {

                s.age = newAge;
                s.course = newCourse;

                System.out.println("Student Updated Successfully!");
                saveStudents();
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    // Save Students
    void saveStudents() {

        try {

            PrintWriter writer = new PrintWriter("students.txt");

            for (Student s : students) {

                writer.println(
                    s.id + "," +
                    s.name + "," +
                    s.age + "," +
                    s.course
                );
            }

            writer.close();

            System.out.println("Students Saved Successfully!");

        } catch (Exception e) {

            System.out.println("Error Saving File!");
        }
    }

    // Load Students
    void loadStudents() {

        try {

            File file = new File("students.txt");

            if (!file.exists()) {
                return;
            }

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();

                String[] data = line.split(",");

                if (data.length == 4) {

                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    int age = Integer.parseInt(data[2]);
                    String course = data[3];

                    students.add(
                        new Student(id, name, age, course)
                    );
                }
            }

            scanner.close();

        } catch (Exception e) {

            System.out.println("Error Loading File!");
        }
    }
}