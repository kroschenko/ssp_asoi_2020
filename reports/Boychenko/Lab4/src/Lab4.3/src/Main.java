public class Main {

    public static void main(String[] args) {
        Teacher teacher = new Teacher("t1", 25, "b");
        Teacher teacher1 = new Teacher("t2", 28, "m");
        Course course = teacher.createCourse("course1");
        Course course1 = teacher1.createCourse("course2");
        Student student = new Student("s1", 20, "AS51");
        Student student1 = new Student("s2", 21, "AS50");
        student.signForCourse("course1");
        System.out.println(Course.getCourses());
        System.out.println(student);
        System.out.println(teacher.getCourses());
        System.out.println(teacher);
        student1.signForCourse("course1");
        System.out.println(course.getStudents());
        student1.signForCourse("course2");
        System.out.println(student1.getCourses());
        teacher.addTeacher(teacher1, course);
        System.out.println(course.getTeachers());
        teacher.finishCourseAndGiveMarks(course);
        System.out.println(course.getArchive());

    }
}
