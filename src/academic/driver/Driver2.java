package academic.driver;

import academic.model.Student;
import java.util.ArrayList;
import java.util.Scanner; // Menggunakan ArrayList untuk array dinamis

/**
 * @author 12S24004 - Silvia Sitorus
 */
public class Driver2 {

    public static void main(String[] _args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>(); // Gunakan ArrayList untuk ukuran yang dinamis

        String line;
        while (input.hasNextLine()) {
            line = input.nextLine();

            if (line.equals("---")) {
                break; // Berhenti membaca saat "---" ditemukan
            }

            // Pisahkan baris input menjadi 4 segmen
            String[] segments = line.split("#");

            if (segments.length == 4) {
                String nim = segments[0];
                String name = segments[1];
                int enrollmentYear = Integer.parseInt(segments[2]); // Konversi tahun masuk ke integer
                String major = segments[3];

                // Buat objek Student baru dan tambahkan ke daftar
                Student student = new Student(nim, name, enrollmentYear, major);
                students.add(student);
            } else {
                // Penanganan untuk format input yang salah (opsional, tidak diminta secara eksplisit)
                System.err.println("Invalid input format: " + line + ". Skipping.");
            }
        }

        // Setelah semua input dibaca, tampilkan semua student yang tersimpan
        for (Student student : students) {
            System.out.println(student); // Menggunakan metode toString() yang di-override di kelas Student
        }

        input.close(); // Tutup scanner
    }
}