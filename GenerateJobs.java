import java.io.*;

public class GenerateJobs {
    public static void main(String[] args) throws Exception {
        String[] companies = {"TCS", "Infosys", "Wipro", "Accenture", "TechMahindra", "HCL", "Cognizant", "IBM", "Capgemini", "Deloitte"};
        String[] skills = {"Java", "Python", "C++", "SQL", "Web"};
        String[] roles = {"Software Developer", "Data Analyst", "Web Developer", "Backend Developer", "Tester"};

        PrintWriter pw = new PrintWriter("jobs.txt");
        for (int i = 1; i <= 100; i++) {
            String comp = companies[i % 10];
            String skill = skills[i % 5];
            String role = roles[i % 5];
            double minCgpa = 6.0; // Andariki ravali ani 6.0 pettam
            double pack = 3.5 + (i % 10) * 0.5;
            pw.println(i + "," + comp + "," + role + "," + skill + "," + minCgpa + "," + pack);
        }
        pw.close();
        System.out.println("100 Jobs Created Successfully!");
    }
}