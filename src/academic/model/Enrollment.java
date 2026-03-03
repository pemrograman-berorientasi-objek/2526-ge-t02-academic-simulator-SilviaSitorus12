package academic.model;

//Silvia Eklesiana Sitorus 12S24004

public class Enrollment {
    private String courseId;
    private String studentNim;
    private String academicYear;
    private String semester;
    private String grade; // Default grade is "None"

    public Enrollment(String courseId, String studentNim, String academicYear, String semester) {
        this.courseId = courseId;
        this.studentNim = studentNim;
        this.academicYear = academicYear;
        this.semester = semester;
        this.grade = "None"; // Default grade as per output example
    }

    // Getters
    public String getCourseId() {
        return courseId;
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

    // Optional: Setter for grade if it can be updated later
    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return courseId + "|" + studentNim + "|" + academicYear + "|" + semester + "|" + grade;
    }
}
