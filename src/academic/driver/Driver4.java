package academic.driver;

import academic.model.Course;
import academic.model.Enrollment;
import academic.model.Student;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 12S24004 - Silvia Sitorus
 
 */

public class Driver4 {

    public static void main(String[] _args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Enrollment> enrollments = new ArrayList<>();

        String line;
        while (input.hasNextLine()) {
            line = input.nextLine();

            if (line.equals("---")) {
                break; // Stop reading when "---" is encountered
            }

            // Split the input line by the first '#' to separate command from data
            String[] parts = line.split("#", 2); 
            String command = parts[0];
            String data = parts[1];

            String[] segments = data.split("#");

            switch (command) {
                case "course-add":
                    if (segments.length == 4) {
                        String code = segments[0];
                        String name = segments[1];
                        int credits = Integer.parseInt(segments[2]);
                        String grade = segments[3];
                        Course course = new Course(code, name, credits, grade);
                        courses.add(course);
                    } else {
                        System.err.println("Invalid input format for course-add: " + line + ". Skipping.");
                    }
                    break;
                case "student-add":
                    if (segments.length == 4) {
                        String nim = segments[0];
                        String name = segments[1];
                        int enrollmentYear = Integer.parseInt(segments[2]);
                        String major = segments[3];
                        Student student = new Student(nim, name, enrollmentYear, major);
                        students.add(student);
                    } else {
                        System.err.println("Invalid input format for student-add: " + line + ". Skipping.");
                    }
                    break;
                case "enrollment-add":
                    if (segments.length == 4) {
                        String courseCode = segments[0];
                        String studentNim = segments[1];
                        String academicYear = segments[2];
                        String semester = segments[3];
                        // Grade defaults to "None" in the Enrollment constructor
                        Enrollment enrollment = new Enrollment(courseCode, studentNim, academicYear, semester);
                        enrollments.add(enrollment);
                    } else {
                        System.err.println("Invalid input format for enrollment-add: " + line + ". Skipping.");
                    }
                    break;
                default:
                    System.err.println("Unknown command: " + command + " in line: " + line + ". Skipping.");
                    break;
            }
        }

        // Display outputs in the specified order: Course, then Student, then Enrollment
        for (Course course : courses) {
            System.out.println(course);
        }
        for (Student student : students) {
            System.out.println(student);
        }
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }

        input.close(); // Close the scanner
    }
}