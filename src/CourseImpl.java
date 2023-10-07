import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CourseImpl extends Course {
    public Lecture[] getLectureList() {
        return lectureList;
    }

    public void setLectureList(Lecture[] lectureList) {
        this.lectureList = lectureList;
    }

    private Lecture[] lectureList;

    public CourseImpl(String name, String teachersLastName, Lecture[] lectureList) {
        super(name, teachersLastName);
        this.lectureList = lectureList;
    }


    @Override
    String findDateLectureMinNumberStudents() {
        if (lectureList == null || lectureList.length == 0) {
            return null; // Handle empty lectureList gracefully
        }

        Lecture minStudentsLecture = lectureList[0];

        for (Lecture lecture : lectureList) {
            if (lecture.getNumberStudents() < minStudentsLecture.getNumberStudents()) {
                minStudentsLecture = lecture;
            }
        }

        return minStudentsLecture.getData();
    }

    @Override
    String[] findTopicsWithWordInTitle(String word) {
        if (word == null || word.isEmpty()) {
            return null; // Handle invalid input gracefully
        }

        List<String> topics = Arrays.stream(lectureList)
                .map(Lecture::getTopic)
                .filter(topic -> topic.contains(word))
                .collect(Collectors.toList());

        return topics.toArray(new String[0]);
    }

    @Override
    String findLastLetterTeacherLastName() {
        return null;
    }

    void sortByIncreaseNumberWordsTopic() {
        if (lectureList == null || lectureList.length <= 1) {
            return;
        }

        int n = lectureList.length;
        boolean swapped;

        do {
            swapped = false;

            for (int i = 0; i < n - 1; i++) {
                int wordsInTopic1 = lectureList[i].getTopic().split(" ").length;
                int wordsInTopic2 = lectureList[i + 1].getTopic().split(" ").length;

                if (wordsInTopic1 > wordsInTopic2) {
                    Lecture temp = lectureList[i];
                    lectureList[i] = lectureList[i + 1];
                    lectureList[i + 1] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }


    void sortByTopicAlphabet() {
        if (lectureList == null || lectureList.length <= 1) {
            return;
        }

        int n = lectureList.length;

        for (int i = 1; i < n; i++) {
            Lecture key = lectureList[i];
            int j = i - 1;

            while (j >= 0 && lectureList[j].getTopic().compareTo(key.getTopic()) > 0) {
                lectureList[j + 1] = lectureList[j];
                j = j - 1;
            }
            lectureList[j + 1] = key;
        }
    }
     public void print(){
        for (Lecture lecture : lectureList) {
            System.out.println(lecture.getTopic());
        }
    }

}
