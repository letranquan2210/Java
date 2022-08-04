
public class Student implements Comparable<Student> {

    private String id;
    private String name;
    private String course;
    private int semester;

    public Student() {
    }

    public Student(String id, String name, String course, int semester) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.semester = semester;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    @Override
    public int compareTo(Student t) {
        return this.name.compareToIgnoreCase(t.name);
    }
}