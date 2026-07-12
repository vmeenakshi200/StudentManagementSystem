public class Main {

    public static void main(String[] args) {

        StudentManager manager = new StudentManager();

        Student s1 = new Student(101, "Meenakshi", 20, "BCA");
        Student s2 = new Student(102, "Rahul", 21, "B.Tech");

        manager.addStudent(s1);
        manager.addStudent(s2);

        System.out.println("\nStudent List:");
        manager.displayStudents();
    }
}
