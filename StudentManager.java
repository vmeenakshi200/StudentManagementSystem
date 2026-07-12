import java.util.ArrayList;

public class StudentManager {

    ArrayList<Student> students = new ArrayList<>();

    void addStudent(Student student) {
        students.add(student);
        System.out.println("Student Added Successfully!");
    }

    void displayStudents() {

        if (students.isEmpty()) {
            System.out.println("No Students Found!");
            return;
        }

        for (Student s : students) {
            s.display();
        }
    }
}
