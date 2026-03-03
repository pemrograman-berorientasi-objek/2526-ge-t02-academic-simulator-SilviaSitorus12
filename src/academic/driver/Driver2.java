package academic.driver;

//Silvia Eklesiana Sitorus 12S24004

import academic.model.Student;
import java.util.Scanner;
import java.util.Arrays; // Untuk membuat array lebih besar jika diperlukan

public class Driver2 {

    private static final int INITIAL_CAPACITY = 10; // Kapasitas awal array
    private static Student[] students = new Student[INITIAL_CAPACITY];
    private static int studentCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;

        System.out.println("Masukkan data Student (nim#name#year#studyprogram). Ketik '---' untuk berhenti:");

        while (scanner.hasNextLine() && !(line = scanner.nextLine()).equals("---")) {
            if (line.trim().isEmpty()) {
                continue; // Lewati baris kosong
            }

            String[] parts = line.split("#");
            if (parts.length == 4) {
                try {
                    String nim = parts[0];
                    String name = parts[1];
                    int year = Integer.parseInt(parts[2]);
                    String studyProgram = parts[3];

                    Student student = new Student(nim, name, year, studyProgram);
                    addStudent(student);
                } catch (NumberFormatException e) {
                    System.err.println("Error: Format tahun tidak valid pada baris: " + line);
                }
            } else {
                System.err.println("Error: Format input tidak sesuai (nim#name#year#studyprogram) pada baris: " + line);
            }
        }

        System.out.println("\n--- Data Student yang tersimpan ---");
        for (int i = 0; i < studentCount; i++) {
            System.out.println(students[i]);
        }
        
        scanner.close();
    }

    // Metode untuk menambahkan Student ke array, dengan kemampuan resize
    private static void addStudent(Student student) {
        if (studentCount == students.length) {
            // Array penuh, gandakan ukurannya
            students = Arrays.copyOf(students, students.length * 2);
            System.out.println("Kapasitas array Student diperbesar menjadi: " + students.length);
        }
        students[studentCount++] = student;
    }
}
