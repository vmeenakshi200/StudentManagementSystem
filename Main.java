import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        manager.loadStudents();

        int choice;

        do {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    // Check Duplicate Student ID
                    if (manager.studentExists(id)) {
                        System.out.println("Student ID already exists!");
                        break;
                    }

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();


                    System.out.print("Enter Student Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    if (age <= 0) {
                        System.out.println("Invalid Age!");
                        break;
                    }

                    System.out.print("Enter Student Course: ");
                    String course = sc.nextLine();

                    Student student = new Student(id, name, age, course);

                    manager.addStudent(student);
                    manager.saveStudents();
                    break;

                case 2:

                    manager.displayStudents();
                    break;

                case 3:

                    System.out.print("Enter Student ID to Search: ");
                    int searchId = sc.nextInt();

                    manager.searchStudent(searchId);
                    break;

                case 4:

                    System.out.print("Enter Student ID to Delete: ");
                    int deleteId = sc.nextInt();

                    manager.deleteStudent(deleteId);
                    manager.saveStudents();
                    break;

                case 5:

                    System.out.print("Enter Student ID to Update: ");
                     int updateId = sc.nextInt();

                    System.out.print("Enter New Age: ");
                    int newAge = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Course: ");
                    String newCourse = sc.nextLine();

                    manager.updateStudent(updateId, newAge, newCourse);
                    manager.saveStudents();

                     break;

                case 6:
                    manager.saveStudents();
                    System.out.println("Thank You!");
                    break;


                default:

                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}