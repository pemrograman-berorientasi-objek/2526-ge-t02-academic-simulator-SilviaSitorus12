package academic.driver;

// Silvia Eklesiana Sitorus

import academic.model.Enrollment;
import java.util.Scanner;

public class Driver3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Enrollment[] enrollments = new Enrollment[50]; // Kapasitas array 50
        int enrollmentCount = 0;

        System.out.println("Masukkan data Enrollment (format: CourseID#StudentID#AcademicYear#Semester, ketik '---' untuk berhenti):");

        while (true) {
            String line = input.nextLine();

            if (line.equals("---")) {
                break;
            }

            if (enrollmentCount >= enrollments.length) {
                System.out.println("Kapasitas penyimpanan enrollment penuh. Data selanjutnya tidak dapat ditambahkan.");
                continue; // Lanjutkan membaca sampai '---' tapi tidak simpan
            }

            String[] parts = line.split("#");
            if (parts.length == 4) {
                String courseId = parts[0];
                String studentNim = parts[1];
                String academicYear = parts[2];
                String semester = parts[3];

                enrollments[enrollmentCount] = new Enrollment(courseId, studentNim, academicYear, semester);
                enrollmentCount++;
            } else {
                System.out.println("Error: Format input tidak sesuai untuk baris ini: " + line);
            }
        }

        System.out.println("\n--- Data Enrollment ---");
        for (int i = 0; i < enrollmentCount; i++) {
            System.out.println(enrollments[i]);
        }
        
        input.close();
    }
}
