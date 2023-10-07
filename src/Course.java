import java.lang.reflect.Array;
import java.util.Objects;

public abstract class Course {
    private String name;
    private String teachersLastName;

    public Course(String name, String teachersLastName) {
        this.name = name;
        this.teachersLastName = teachersLastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeachersLastName() {
        return teachersLastName;
    }

    public void setTeachersLastName(String teachersLastName) {
        this.teachersLastName = teachersLastName;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", teachersLastName='" + teachersLastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(name, course.name) && Objects.equals(teachersLastName, course.teachersLastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, teachersLastName);
    }

    abstract String findDateLectureMinNumberStudents();

    abstract String[] findTopicsWithWordInTitle(String word);

    abstract String findLastLetterTeacherLastName();

}
