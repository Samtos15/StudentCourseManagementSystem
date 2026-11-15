import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class CourseManager {

    // Store all courses in an ArrayList
    private ArrayList<Course> courses;

    // Constructor
    public CourseManager() {
        courses = new ArrayList<>();
    }

    // Add a new course
    public void addCourse(Course course) {

        for (Course existingCourse : courses) {

            if (existingCourse.getCourseCode()
                    .equalsIgnoreCase(course.getCourseCode())) {

                System.out.println("Error: This course code already exists!");
                return;
            }
        }

        courses.add(course);
        System.out.println("Course added successfully!");
    }

    // Display all courses
    public void displayCourses() {

        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }

        System.out.println("\n===== LIST OF COURSES =====");

        for (Course course : courses) {
            System.out.println("Course Code: " + course.getCourseCode());
            System.out.println("Course Title: " + course.getCourseTitle());
            System.out.println("Course Unit: " + course.getUnit());
            System.out.println("----------------------------");
        }
    }

    // Search for a course by course code
    public void searchCourse(String courseCode) {

        for (Course course : courses) {

            if (course.getCourseCode().equalsIgnoreCase(courseCode)) {

                System.out.println("\nCourse Found!");
                System.out.println("Course Code: " + course.getCourseCode());
                System.out.println("Course Title: " + course.getCourseTitle());
                System.out.println("Course Unit: " + course.getUnit());

                return;
            }
        }

        System.out.println("Course not found.");
    }

    // Calculate total units using recursion
    public void calculateTotalUnits() {

        int totalUnits = calculateTotalUnitsRecursive(0);

        System.out.println("Total Course Units: " + totalUnits);
    }

    // Recursive method
    private int calculateTotalUnitsRecursive(int index) {

        // Base case: stop when all courses have been counted
        if (index >= courses.size()) {
            return 0;
        }

        // Add the current course unit and move to the next course
        return courses.get(index).getUnit()
                + calculateTotalUnitsRecursive(index + 1);
    }

    // Save courses to a file
    public void saveCoursesToFile() {

        try (PrintWriter writer = new PrintWriter(new FileWriter("courses.txt"))) {

            for (Course course : courses) {
                writer.println(course.getCourseCode() + ","
                        + course.getCourseTitle() + ","
                        + course.getUnit());
            }

            System.out.println("Courses saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving courses: " + e.getMessage());
        }
    }

    // Load courses from a file
    public void loadCoursesFromFile() {

        try (BufferedReader reader = new BufferedReader(new FileReader("courses.txt"))) {

            String line;
            courses.clear();

            while ((line = reader.readLine()) != null) {

                String[] details = line.split(",", 3);

                if (details.length == 3) {
                    String courseCode = details[0].trim();
                    String courseTitle = details[1].trim();
                    int unit = Integer.parseInt(details[2].trim());

                    Course course = new Course(courseCode, courseTitle, unit);
                    courses.add(course);
                }
            }

            System.out.println("Courses loaded successfully!");

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading courses: " + e.getMessage());
        }
    }

    // Get the total number of courses
    public int getCourseCount() {
        return courses.size();
    }
}
