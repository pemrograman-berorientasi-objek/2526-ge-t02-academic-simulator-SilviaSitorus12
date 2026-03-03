package academic.driver;

import academic.model.Enrollment;
import java.util.ArrayList;
import java.util.Scanner; // Menggunakan ArrayList untuk array dinamis

/**
 * @author 12S24004 - Silvia Sitorus
 
 */
public class Driver3 {

    public static void main(String[] _args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Enrollment> enrollments = new ArrayList<>(); // Gunakan ArrayList untuk ukuran yang dinamis

        String line;
        while (input.hasNextLine()) {
            line = input.nextLine();

            if (line.equals("---")) {
                break; // Berhenti membaca saat "---" ditemukan
            }

            // Pisahkan baris input menjadi 4 segmen
            String[] segments = line.split("#");

            if (segments.length == 4) {
                String courseCode = segments[0];
                String studentNim = segments[1];
                String academicYear = segments[2];
                String semester = segments[3];

                // Buat objek Enrollment baru (grade akan default ke "None")
                Enrollment enrollment = new Enrollment(courseCode, studentNim, academicYear, semester);
                enrollments.add(enrollment);
            } else {
                // Penanganan untuk format input yang salah (opsional, tidak diminta secara eksplisit)
                System.err.println("Invalid input format: " + line + ". Skipping.");
            }
        }

        // Setelah semua input dibaca, tampilkan semua enrollment yang tersimpan
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment); // Menggunakan metode toString() yang di-override di kelas Enrollment
        }

        input.close(); // Tutup scanner
    }
}