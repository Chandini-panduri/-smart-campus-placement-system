public class Student {
    int id;
    String name;
    String branch;
    double cgpa;
    String skills;

    public Student(int id, String name, String branch, double cgpa, String skills) {
        this.id = id;
        this.name = name;
        this.branch = branch;
        this.cgpa = cgpa;
        this.skills = skills;
    }

    public String toString() {
        return id + " | " + name + " | " + branch + " | CGPA: " + cgpa + " | Skills: " + skills;
    }
}