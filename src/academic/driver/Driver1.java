package academic.driver;

//Silvia Eklesiana Sitorus 12S24004

import academic.model.Course;
import java.util.Scanner;

public class Driver1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Menggunakan array standar Java untuk menyimpan objek Course.
        // Asumsi kapasitas awal, bisa diperluas jika diperlukan,
        // namun untuk kesederhanaan sesuai prompt, kita mulai dengan ukuran yang cukup besar.
        Course[] courses = new Course[100]; 
        int courseCount = 0; // Untuk melacak jumlah objek Course yang disimpan

        String line;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.equals("---")) {
                break; // Keluar dari loop jika input adalah "---"
            }

            // Parsing input dengan format nim#name#credit#grade
            String[] parts = line.split("#");
            if (parts.length == 4) {
                String nim = parts[0];
                String name = parts[1];
                int credit = Integer.parseInt(parts[2]);
                String grade = parts[3];

                // Membuat objek Course baru dan menyimpannya dalam array
                if (courseCount < courses.length) {
                    courses[courseCount] = new Course(nim, name, credit, grade);
                    courseCount++;
                } else {
                    System.err.println("Peringatan: Kapasitas array penuh, tidak dapat menambahkan course baru.");
                    // Implementasi yang lebih kompleks akan melibatkan resizing array di sini.
                }
            } else {
                System.err.println("Peringatan: Format input tidak valid untuk baris: " + line);
            }
        }

        // Menampilkan semua objek Course yang telah disimpan
        for (int i = 0; i < courseCount; i++) {
            System.out.println(courses[i].toString());
        }

        scanner.close();
    }
}
