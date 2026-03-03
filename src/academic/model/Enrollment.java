package academic.model;

/**
 * @author 12S24004 - Silvia Sitorus
 
 */
public class Enrollment {
    private String courseCode;
    private String studentNim;
    private String academicYear;
    private String semester;
    private String grade; // Default to "None" based on output example

    public Enrollment(String courseCode, String studentNim, String academicYear, String semester) {
        this.courseCode = courseCode;
        this.studentNim = studentNim;
        this.academicYear = academicYear;
        this.semester = semester;
        this.grade = "None"; // Default grade as per output example
    }

    // Optional constructor if grade is provided directly upon creation
    public Enrollment(String courseCode, String studentNim, String academicYear, String semester, String grade) {
        this.courseCode = courseCode;
        this.studentNim = studentNim;
        this.academicYear = academicYear;
        this.semester = semester;
        this.grade = grade;
    }

    // Getter methods for all fields
    public String getCourseCode() {
        return courseCode;
    }

    public String getStudentNim() {
        return studentNim;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public String getSemester() {
        return semester;
    }

    public String getGrade() {
        return grade;
    }

    // Optional: Setter methods if needed, for example to update grade later
    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return courseCode + "|" + studentNim + "|" + academicYear + "|" + semester + "|" + grade;
    }
}