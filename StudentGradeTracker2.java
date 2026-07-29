import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class Student {

    String name;
    double marks;
    String grade;

    Student(String name, double marks) {
        this.name = name;
        updateMarks(marks);
    }

    void updateMarks(double marks) {
        this.marks = marks;

        if (marks >= 90)
            grade = "A+";
        else if (marks >= 80)
            grade = "A";
        else if (marks >= 70)
            grade = "B";
        else if (marks >= 60)
            grade = "C";
        else if (marks >= 50)
            grade = "D";
        else
            grade = "F";
    }
}
public class StudentGradeTracker2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        int choice;

        do {

            System.out.println("\n===== Student Grade Tracker =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student Marks");
            System.out.println("5. Delete Student");
            System.out.println("6. Show Average Marks");
            System.out.println("7. Show Highest Marks");
            System.out.println("8. Show Lowest Marks");
            System.out.println("9. Display Summary Report");
            System.out.println("10. Save Records to File");
            System.out.println("11. Exit");

            System.out.print("Enter your choice: ");
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

        System.out.println("No Student Records Found.");

    } else {

        System.out.println("\n------ Student Records ------");

        for (Student s : students) {

            System.out.println("---------------------------");
            System.out.println("Name  : " + s.name);
            System.out.println("Marks : " + s.marks);
            System.out.println("Grade : " + s.grade);
        }
    }

    break;
                case 3:

    System.out.print("Enter Student Name: ");
    String searchName = sc.nextLine();

    boolean found = false;

    for (Student s : students) {

        if (s.name.equalsIgnoreCase(searchName)) {

            System.out.println("\nStudent Found");
            System.out.println("--------------------------");
            System.out.println("Name  : " + s.name);
            System.out.println("Marks : " + s.marks);
            System.out.println("Grade : " + s.grade);

            found = true;
            break;
        }
    }

    if (!found) {
        System.out.println("Student Not Found.");
    }

    break;

case 4:

    System.out.print("Enter Student Name: ");
    String updateName = sc.nextLine();

    boolean updated = false;

    for (Student s : students) {

        if (s.name.equalsIgnoreCase(updateName)) {

            System.out.print("Enter New Marks: ");
            double newMarks = sc.nextDouble();
            sc.nextLine();

            s.updateMarks(newMarks);

            System.out.println("Student Record Updated Successfully!");

            updated = true;
            break;
        }
    }

    if (!updated) {
        System.out.println("Student Not Found.");
    }

    break;

              case 5:

    System.out.print("Enter Student Name: ");
    String deleteName = sc.nextLine();

    boolean deleted = false;

    for (int i = 0; i < students.size(); i++) {

        if (students.get(i).name.equalsIgnoreCase(deleteName)) {

            students.remove(i);
            System.out.println("Student Deleted Successfully!");
            deleted = true;
            break;
        }
    }

    if (!deleted) {
        System.out.println("Student Not Found.");
    }

    break;

case 6:

    if (students.isEmpty()) {

        System.out.println("No Student Records Found.");

    } else {

        double total = 0;

        for (Student s : students) {
            total += s.marks;
        }

        double average = total / students.size();

        System.out.printf("Average Marks: %.2f%n", average);
    }

    break;

               case 7:

    if (students.isEmpty()) {

        System.out.println("No Student Records Found.");

    } else {

        Student highest = students.get(0);

        for (Student s : students) {

            if (s.marks > highest.marks) {
                highest = s;
            }

        }

        System.out.println("\nHighest Marks");
        System.out.println("--------------------------");
        System.out.println("Name  : " + highest.name);
        System.out.println("Marks : " + highest.marks);
        System.out.println("Grade : " + highest.grade);

    }

    break;

case 8:

    if (students.isEmpty()) {

        System.out.println("No Student Records Found.");

    } else {

        Student lowest = students.get(0);

        for (Student s : students) {

            if (s.marks < lowest.marks) {
                lowest = s;
            }

        }

        System.out.println("\nLowest Marks");
        System.out.println("--------------------------");
        System.out.println("Name  : " + lowest.name);
        System.out.println("Marks : " + lowest.marks);
        System.out.println("Grade : " + lowest.grade);

    }

    break;


                case 9:

    if (students.isEmpty()) {

        System.out.println("No Student Records Found.");

    } else {

        double total = 0;

        Student highest = students.get(0);
        Student lowest = students.get(0);

        System.out.println("\n========== SUMMARY REPORT ==========");

        for (Student s : students) {

            System.out.println("--------------------------");
            System.out.println("Name  : " + s.name);
            System.out.println("Marks : " + s.marks);
            System.out.println("Grade : " + s.grade);

            total += s.marks;

            if (s.marks > highest.marks)
                highest = s;

            if (s.marks < lowest.marks)
                lowest = s;
        }

        double average = total / students.size();

        System.out.println("\nTotal Students : " + students.size());
        System.out.printf("Average Marks : %.2f%n", average);

        System.out.println("\nHighest Marks");
        System.out.println("Name  : " + highest.name);
        System.out.println("Marks : " + highest.marks);
        System.out.println("Grade : " + highest.grade);

        System.out.println("\nLowest Marks");
        System.out.println("Name  : " + lowest.name);
        System.out.println("Marks : " + lowest.marks);
        System.out.println("Grade : " + lowest.grade);
    }

    break;

               case 10:

    try {

        PrintWriter writer = new PrintWriter(new FileWriter("students.txt"));

        for (Student s : students) {

            writer.println(s.name + "," + s.marks + "," + s.grade);

        }

        writer.close();

        System.out.println("Records saved successfully to students.txt");

    } catch (IOException e) {

        System.out.println("Error while saving the file.");

    }

    break;

                case 11:

    System.out.println("Thank You!");
    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 11);

        sc.close();
    }
}