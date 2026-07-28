import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double marks;

    Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class StudentGradeTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        int choice;

        do {

            System.out.println("\n===== Student Grade Tracker =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Show Average Marks");
            System.out.println("4. Show Highest Marks");
            System.out.println("5. Show Lowest Marks");
            System.out.println("6. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();
                    sc.nextLine();

                    students.add(new Student(name, marks));
                    System.out.println("Student Added Successfully!");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No student records found.");
                    } else {
                        System.out.println("\nStudent Records:");
                        for (Student s : students) {
                            System.out.println("Name: " + s.name + " | Marks: " + s.marks);
                        }
                    }
                    break;

                case 3:
                    if (students.isEmpty()) {
                        System.out.println("No student records found.");
                    } else {
                        double total = 0;
                        for (Student s : students) {
                            total += s.marks;
                        }
                        double average = total / students.size();
                        System.out.println("Average Marks = " + average);
                    }
                    break;

                case 4:
                    if (students.isEmpty()) {
                        System.out.println("No student records found.");
                    } else {
                        Student highest = students.get(0);

                        for (Student s : students) {
                            if (s.marks > highest.marks) {
                                highest = s;
                            }
                        }

                        System.out.println("Highest Marks:");
                        System.out.println("Name: " + highest.name);
                        System.out.println("Marks: " + highest.marks);
                    }
                    break;

                case 5:
                    if (students.isEmpty()) {
                        System.out.println("No student records found.");
                    } else {
                        Student lowest = students.get(0);

                        for (Student s : students) {
                            if (s.marks < lowest.marks) {
                                lowest = s;
                            }
                        }

                        System.out.println("Lowest Marks:");
                        System.out.println("Name: " + lowest.name);
                        System.out.println("Marks: " + lowest.marks);
                    }
                    break;

                case 6:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}