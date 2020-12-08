import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Course {
    public Course(String courseName, Teacher teacher) {
        this.courseName = courseName;
            teachers = new ArrayList<>();
            teachers.add(teacher);
            courses.add(this);
    }


    public static List<Course> courses = new ArrayList<>();
    private Map<Student, Integer> archive = new HashMap<>();
    private List<Teacher> teachers;

    private final String courseName;
    private List<Student> students = new ArrayList<>();
    private List<Integer> marks = new ArrayList<>();

    public String getCourseName() {
        return courseName;
    }

    public static List<Course> getCourses() {
        return courses;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Map<Student, Integer> getArchive() {
        return archive;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                '}';
    }
}
