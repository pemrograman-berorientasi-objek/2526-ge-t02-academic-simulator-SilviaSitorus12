package academic.driver;

/**
 * @author 12S24004 - Silvia Sitorus
 */
import academic.model.Course;
import java.util.ArrayList;
import java.util.Scanner; // Using ArrayList for dynamic array, as raw array size is unknown beforehand

public class Driver1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Course> courses = new ArrayList<>(); // Use ArrayList for dynamic size

        String line;
        while (input.hasNextLine()) {
            line = input.nextLine();

            if (line.equals("---")) {
                break; // Stop reading when "---" is encountered
            }

            // Split the input line into 4 segments
            String[] segments = line.split("#");

            if (segments.length == 4) {
                String code = segments[0];
                String name = segments[1];
                int credits = Integer.parseInt(segments[2]); // Convert credits to integer
                String grade = segments[3];

                // Create a new Course object and add it to the list
                Course course = new Course(code, name, credits, grade);
                courses.add(course);
            } else {
                // Handle malformed input lines if necessary (optional, as not explicitly requested)
                System.err.println("Invalid input format: " + line + ". Skipping.");
            }
        }

        // After reading all input, display all stored courses
        for (Course course : courses) {
            System.out.println(course); // Uses the overridden toString() method in Course class
        }

        input.close(); // Close the scanner
    }
}