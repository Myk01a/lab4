import java.util.Comparator;
import java.util.Objects;

public class Lecture implements Comparable<Lecture> {
    private String data;
    private String topic;
    private int numberStudents;

    public Lecture(String data, String topic, int numberStudents) {
        this.data = data;
        this.topic = topic;
        this.numberStudents = numberStudents;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getNumberStudents() {
        return numberStudents;
    }

    public void setNumberStudents(int numberStudents) {
        this.numberStudents = numberStudents;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "data='" + data + '\'' +
                ", topic='" + topic + '\'' +
                ", numberStudents=" + numberStudents +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lecture lecture = (Lecture) o;
        return numberStudents == lecture.numberStudents && Objects.equals(data, lecture.data) && Objects.equals(topic, lecture.topic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, topic, numberStudents);
    }

    @Override
    public int compareTo(Lecture other) {

        int wordsInTopic1 = this.getTopic().split(" ").length;
        int wordsInTopic2 = other.getTopic().split(" ").length;

//        int wordsInTopic1 = this.getTopic().length();
//        int wordsInTopic2 = other.getTopic().length();

        return Integer.compare(wordsInTopic1, wordsInTopic2);
    }
}
