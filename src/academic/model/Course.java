package academic.model;

/**
 * @author 12S24004 - Silvia Sitorus
 */
public class Course {
    private String code;
    private String name;
    private int credits;
    private String grade;

    public Course(String code, String name, int credits, String grade) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.grade = grade;
    }

    // Getter methods for all fields
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public String getGrade() {
        return grade;
    }

    // Optional: Setter methods if needed, but not explicitly requested
    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return code + "|" + name + "|" + credits + "|" + grade;
    }
}