package academic.model;
//Silvia Eklesiana Sitorus 12S24004

public class Course {
    private String nim;
    private String name;
    private int credit;
    private String grade;

    public Course(String nim, String name, int credit, String grade) {
        this.nim = nim;
        this.name = name;
        this.credit = credit;
        this.grade = grade;
    }

    // Getters for all attributes
    public String getNim() {
        return nim;
    }

    public String getName() {
        return name;
    }

    public int getCredit() {
        return credit;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return nim + "|" + name + "|" + credit + "|" + grade;
    }
}
