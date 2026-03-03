package academic.driver;


//Silvia Eklesiana Sitorus 12S24004


import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.Scanner;

public class Driver4 {

    private static final int MAX_CAPACITY = 50; // Kapasitas tetap untuk semua array

    private static Course[] courses = new Course[MAX_CAPACITY];
    private static int courseCount = 0;

    private static Student[] students = new Student[MAX_CAPACITY];
    private static int studentCount = 0;

    private static Enrollment[] enrollments = new Enrollment[MAX_CAPACITY];
    private static int enrollmentCount = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line;

        System.out.println("--- Masukkan data (command#data) ---");
        System.out.println("--- Commands: course-add, student-add, enrollment-add ---");
        System.out.println("--- Contoh: course-add#12S2201#PBO#3#A ---");
        System.out.println("--- Ketik '---' untuk selesai ---");

        while (input.hasNextLine()) {
            line = input.nextLine().trim();

            if (line.equals("---")) {
                break;
            }
            if (line.isEmpty()) {
                continue; // Lewati baris kosong
            }

            String[] parts = line.split("#", 2); // Split hanya pada '#' pertama untuk memisahkan command dan data
            if (parts.length < 2) {
                System.err.println("Error: Format perintah tidak sesuai: " + line);
                continue;
            }

            String command = parts[0];
            String dataString = parts[1];

            switch (command) {
                case "course-add":
                    addCourse(dataString);
                    break;
                case "student-add":
                    addStudent(dataString);
                    break;
                case "enrollment-add":
                    addEnrollment(dataString);
                    break;
                default:
                    System.err.println("Error: Perintah tidak dikenal: " + command + " pada baris: " + line);
                    break;
            }
        }

        System.out.println("\n--- Data Tersimpan ---");

        System.out.println("\n--- Courses ---");
        for (int i = 0; i < courseCount; i++) {
            System.out.println(courses[i]);
        }

        System.out.println("\n--- Students ---");
        for (int i = 0; i < studentCount; i++) {
            System.out.println(students[i]);
        }

        System.out.println("\n--- Enrollments ---");
        for (int i = 0; i < enrollmentCount; i++) {
            System.out.println(enrollments[i]);
        }
        
        input.close();
    }

    private static void addCourse(String dataString) {
        String[] data = dataString.split("#");
        if (data.length == 4) {
            try {
                String nim = data[0];
                String name = data[1];
                int credit = Integer.parseInt(data[2]);
                String grade = data[3];

                if (courseCount < MAX_CAPACITY) {
                    courses[courseCount++] = new Course(nim, name, credit, grade);
                } else {
                    System.err.println("Peringatan: Kapasitas array Course penuh. Course '" + nim + "' tidak dapat ditambahkan.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Error: Format kredit tidak valid untuk course: " + dataString);
            }
        } else {
            System.err.println("Error: Format data Course tidak sesuai (nim#name#credit#grade): " + dataString);
        }
    }

    private static void addStudent(String dataString) {
        String[] data = dataString.split("#");
        if (data.length == 4) {
            try {
                String nim = data[0];
                String name = data[1];
                int year = Integer.parseInt(data[2]);
                String studyProgram = data[3];

                if (studentCount < MAX_CAPACITY) {
                    students[studentCount++] = new Student(nim, name, year, studyProgram);
                } else {
                    System.err.println("Peringatan: Kapasitas array Student penuh. Student '" + nim + "' tidak dapat ditambahkan.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Error: Format tahun tidak valid untuk student: " + dataString);
            }
        } else {
            System.err.println("Error: Format data Student tidak sesuai (nim#name#year#studyprogram): " + dataString);
        }
    }

    private static void addEnrollment(String dataString) {
        String[] data = dataString.split("#");
        if (data.length == 4) {
            String courseId = data[0];
            String studentNim = data[1];
            String academicYear = data[2];
            String semester = data[3];

            if (enrollmentCount < MAX_CAPACITY) {
                enrollments[enrollmentCount++] = new Enrollment(courseId, studentNim, academicYear, semester);
            } else {
                System.err.println("Peringatan: Kapasitas array Enrollment penuh. Enrollment '" + courseId + "#" + studentNim + "' tidak dapat ditambahkan.");
            }
        } else {
            System.err.println("Error: Format data Enrollment tidak sesuai (CourseID#StudentID#AcademicYear#Semester): " + dataString);
        }
    }
}
