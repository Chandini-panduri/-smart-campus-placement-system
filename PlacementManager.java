import java.util.*;
import java.io.*;

public class PlacementManager {
    ArrayList<Student> students = new ArrayList<>();
    ArrayList<Job> jobs = new ArrayList<>();

    public PlacementManager() {
        loadStudents();
        loadJobs();
    }

    void loadStudents() {
        try {
            File f = new File("students.txt");
            if (!f.exists()) {
                students.add(new Student(1, "Rahul", "CSE", 8.5, "Java"));
                students.add(new Student(2, "Priya", "CSE", 9.0, "Python"));
                saveStudents();
                return;
            }
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if(line.isEmpty()) continue;
                String[] p = line.split(",");
                if (p.length >= 5) students.add(new Student(Integer.parseInt(p[0]), p[1], p[2], Double.parseDouble(p[3]), p[4]));
            }
        } catch (Exception e) {}
    }

    void saveStudents() {
        try {
            PrintWriter pw = new PrintWriter("students.txt");
            for (Student s : students) pw.println(s.id + "," + s.name + "," + s.branch + "," + s.cgpa + "," + s.skills);
            pw.close();
        } catch (Exception e) {}
    }

    void loadJobs() {
        try {
            File f = new File("jobs.txt");
            if (!f.exists()) {
                jobs.add(new Job(1, "TCS", "Software Developer", "Java", 7.0, 4.5));
                jobs.add(new Job(2, "Infosys", "Data Analyst", "Python", 7.5, 5.0));
                saveJobs();
                return;
            }
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if(line.isEmpty()) continue;
                String[] p = line.split(",");
                if (p.length >= 6) jobs.add(new Job(Integer.parseInt(p[0]), p[1], p[2], p[3], Double.parseDouble(p[4]), Double.parseDouble(p[5])));
            }
        } catch (Exception e) {}
    }

    void saveJobs() {
        try {
            PrintWriter pw = new PrintWriter("jobs.txt");
            for (Job j : jobs) pw.println(j.id + "," + j.company + "," + j.role + "," + j.requiredSkill + "," + j.minCgpa + "," + j.packageLpa);
            pw.close();
        } catch (Exception e) {}
    }

    void addStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Branch: ");
        String branch = sc.nextLine();
        System.out.print("Enter CGPA: ");
        double cgpa = sc.nextDouble(); sc.nextLine();
        System.out.print("Enter Skills: ");
        String skills = sc.nextLine();
        students.add(new Student(id, name, branch, cgpa, skills));
        saveStudents();
        System.out.println("Student Added Successfully!");
    }

    void viewStudents() {
        if (students.isEmpty()) { System.out.println("No Students Found!"); return; }
        for (Student s : students) System.out.println(s);
    }

    void addJob() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Job ID: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Enter Company: ");
        String comp = sc.nextLine();
        System.out.print("Enter Role: ");
        String role = sc.nextLine();
        System.out.print("Enter Required Skill: ");
        String skill = sc.nextLine();
        System.out.print("Enter Min CGPA: ");
        double cgpa = sc.nextDouble();
        System.out.print("Enter Package LPA: ");
        double pack = sc.nextDouble();
        jobs.add(new Job(id, comp, role, skill, cgpa, pack));
        saveJobs();
        System.out.println("Job Added Successfully!");
    }

    void viewJobs() {
        if (jobs.isEmpty()) { System.out.println("No Jobs Found!"); return; }
        for (Job j : jobs) System.out.println(j);
    }

    void recommendJobs() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        Student found = null;
        for (Student s : students) if (s.id == id) found = s;
        if (found == null) { System.out.println("Student Not Found!"); return; }
        System.out.println("\nRecommended Jobs for " + found.name + ":");
        boolean any = false;
        for (Job j : jobs) {
            if (j.requiredSkill.equalsIgnoreCase(found.skills) && found.cgpa >= j.minCgpa) {
                System.out.println(j);
                any = true;
            }
        }
        if (!any) System.out.println("No Matching Jobs Found!");
    }

    void searchStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student ID to Search: ");
        int id = sc.nextInt();
        for (Student s : students) {
            if (s.id == id) {
                System.out.println("FOUND: " + s);
                return;
            }
        }
        System.out.println("Student Not Found!");
    }

    void deleteStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student ID to Delete: ");
        int id = sc.nextInt();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).id == id) {
                students.remove(i);
                saveStudents();
                System.out.println("Student Deleted Successfully!");
                return;
            }
        }
        System.out.println("Student Not Found!");
    }

    void deleteJob() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Job ID to Delete: ");
        int id = sc.nextInt();
        for (int i = 0; i < jobs.size(); i++) {
            if (jobs.get(i).id == id) {
                jobs.remove(i);
                saveJobs();
                System.out.println("Job Deleted Successfully!");
                return;
            }
        }
        System.out.println("Job Not Found!");
    }
}