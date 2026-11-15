
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        CourseManager manager = new CourseManager();
        Scanner input = new Scanner(System.in);

        int choice = 0;

        System.out.println("======================================");
        System.out.println(" STUDENT COURSE MANAGEMENT SYSTEM");
        System.out.println("======================================");

        while (choice != 7) {

            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("1. Add Course");
            System.out.println("2. View All Courses");
            System.out.println("3. Search Course by Code");
            System.out.println("4. Compute Total Units");
            System.out.println("5. Save Courses to File");
            System.out.println("6. Load Courses from File");
            System.out.println("7. Exit");
            System.out.println("===============================");

            System.out.print("Enter your choice (1-7): ");

            try {
                choice = Integer.parseInt(input.nextLine().trim());

                switch (choice) {

                    case 1:
                        addCourse(input, manager);
                        break;

                    case 2:
                        manager.displayCourses();
                        break;

                    case 3:
                        System.out.print("Enter course code: ");
                        String code = input.nextLine().trim();
                        manager.searchCourse(code);
                        break;

                    case 4:
                        manager.calculateTotalUnits();
                        break;

                    case 5:
                        manager.saveCoursesToFile();
                        break;

                    case 6:
                        manager.loadCoursesFromFile();
                        break;

                    case 7:
                        System.out.println("Thank you for using the system!");
                        break;

                    default:
                        System.out.println("Invalid choice. Please select 1-7.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        input.close();
    }

    // Add a new course
    public static void addCourse(Scanner input, CourseManager manager) {

        System.out.print("Enter course code: ");
        String code = input.nextLine().trim().toUpperCase();

        System.out.print("Enter course title: ");
        String title = input.nextLine().trim();

        System.out.print("Enter course unit: ");

        try {
            int unit = Integer.parseInt(input.nextLine().trim());

            if (code.isEmpty() || title.isEmpty() || unit < 1 || unit > 6) {
                System.out.println("Invalid course details. Course code and title cannot be empty, and course unit must be between 1 and 6.");
                return;
            }

            Course course = new Course(code, title, unit);
            manager.addCourse(course);

        } catch (NumberFormatException e) {
            System.out.println("Invalid course unit. Please enter a whole number.");
        }
    }

}