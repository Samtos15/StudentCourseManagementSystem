
public class Course {

    // Course details
    private String courseCode;
    private String courseTitle;
    private int unit;

    // Constructor
    public Course(String courseCode, String courseTitle, int unit) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.unit = unit;
    }

    // Get course code
    public String getCourseCode() {
        return courseCode;
    }

    // Get course title
    public String getCourseTitle() {
        return courseTitle;
    }

    // Get course unit
    public int getUnit() {
        return unit;
    }

}
