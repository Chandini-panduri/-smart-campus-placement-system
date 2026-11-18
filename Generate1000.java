import java.io.*;

public class Generate1000 {
    public static void main(String[] args) throws Exception {
        String[] branches = {"CSE", "ECE", "EEE", "MECH", "CIVIL"};
        String[] skills = {"Java", "Python", "C++", "SQL", "Web"};
        String[] names = {"Rahul", "Priya", "Anil", "Sneha", "Vikram", "Divya", "Kiran", "Manasa", "Arjun", "Lakshmi", "Sai", "Teja", "Naveen", "Pooja", "Harish"};

        PrintWriter pw = new PrintWriter("students.txt");
        for (int i = 1; i <= 1000; i++) {
            String name = names[i % 15] + i;
            String branch = branches[i % 5];
            String skill = skills[i % 5];
            double cgpa = 6.0 + (i % 40) / 10.0; // 6.0 to 9.9
            pw.println(i + "," + name + "," + branch + "," + cgpa + "," + skill);
        }
        pw.close();
        System.out.println("1000 Students Created Successfully!");
    }
}