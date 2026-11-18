import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PlacementManager pm = new PlacementManager();

        while (true) {
            System.out.println("\n===== SMART CAMPUS PLACEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Add Job");
            System.out.println("4. View All Jobs");
            System.out.println("5. Recommend Jobs for Student");
            System.out.println("6. Search Student");
            System.out.println("7. Delete Student");
            System.out.println("8. Delete Job");
            System.out.println("9. Exit");
            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            if (choice == 1) pm.addStudent();
            else if (choice == 2) pm.viewStudents();
            else if (choice == 3) pm.addJob();
            else if (choice == 4) pm.viewJobs();
            else if (choice == 5) pm.recommendJobs();
            else if (choice == 6) pm.searchStudent();
            else if (choice == 7) pm.deleteStudent();
            else if (choice == 8) pm.deleteJob();
            else if (choice == 9) {
                System.out.println("Thank You! Project Completed.");
                break;
            } else {
                System.out.println("Invalid Choice!");
            }
        }
    }
}