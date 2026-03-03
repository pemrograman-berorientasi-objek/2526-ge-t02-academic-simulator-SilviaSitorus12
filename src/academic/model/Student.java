package academic.model;

/**
 * @author 12S24004 - Silvia Sitorus
 */
public class Student {
    private String nim;
    private String name;
    private int enrollmentYear;
    private String major;

    public Student(String nim, String name, int enrollmentYear, String major) {
        this.nim = nim;
        this.name = name;
        this.enrollmentYear = enrollmentYear;
        this.major = major;
    }

    // Getter methods for all fields
    public String getNim() {
        return nim;
    }

    public String getName() {
        return name;
    }

    public int getEnrollmentYear() {
        return enrollmentYear;
    }

    public String getMajor() {
        return major;
    }

    // Optional: Setter methods if needed
    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEnrollmentYear(int enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return nim + "|" + name + "|" + enrollmentYear + "|" + major;
    }
}