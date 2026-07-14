import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {

    ArrayList<Student> students = new ArrayList<>();

    // Add Student
    void addStudent(Student student) {
        students.add(student);
        System.out.println("Student Added Successfully!");
    }

    // Display Students
    void displayStudents() {

        if (students.isEmpty()) {
            System.out.println("No Students Found!");
            return;
        }

        for (Student s : students) {
            s.display();
        }
    }

    // Search Student
    void searchStudent(int id) {

        for (Student s : students) {
            if (s.id == id) {
                System.out.println("Student Found!");
                s.display();
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    // Delete Student
    void deleteStudent(int id) {

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).id == id) {
                students.remove(i);
                System.out.println("Student Deleted Successfully!");
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    // Update Student
    void updateStudent(int id, int newAge, String newCourse) {

        for (Student s : students) {
            if (s.id == id) {
                s.age = newAge;
                s.course = newCourse;
                System.out.println("Student Updated Successfully!");
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
                writer.println(s.id + "," + s.name + "," + s.age + "," + s.course);
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

            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {

                String line = sc.nextLine();
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                String course = data[3];

                students.add(new Student(id, name, age, course));
            }

            sc.close();

        } catch (Exception e) {
            System.out.println("Error Loading File!");
        }
    }
    boolean studentExists(int id) {

    for (Student s : students) {
        if (s.id == id) {
            return true;
        }
    }

    return false;
}
}