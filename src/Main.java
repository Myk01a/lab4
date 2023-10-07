public class Main {
    public static void main(String[] args) {

        Lecture lecture1 = new Lecture("2023-10-10", "Introduction to Java", 50);
        Lecture lecture2 = new Lecture("2023-10-12", "Object-Oriented Programming", 40);
        Lecture lecture3 = new Lecture("2023-10-15", "Data Structures", 45);
        Lecture lecture4 = new Lecture("2023-10-17", "Data", 42);
        Lecture lecture5 = new Lecture("2023-10-19", "Data Structures 91", 31);

        Lecture[] lectureList = {lecture1, lecture2, lecture3, lecture4, lecture5};
        CourseImpl course = new CourseImpl("Java Course", "Smith", lectureList);
        System.out.println();

        System.out.println("Course Name: " + course.getName());
        System.out.println();
        System.out.println("Teacher's Last Name: " + course.getTeachersLastName());
        System.out.println();

        String minStudentsDate = course.findDateLectureMinNumberStudents();
        System.out.println("Date of Lecture with Minimum Students: " + minStudentsDate);
        System.out.println();

        String[] topicsWithWord = course.findTopicsWithWordInTitle("Data");
        System.out.println("Topics with 'Data' in Title:");
        for (String topic : topicsWithWord) {
            System.out.println(topic);
        }
        System.out.println();

        course.sortByIncreaseNumberWordsTopic();
        System.out.println("Lectures Sorted by Increasing Words in Topic:");
        course.print();
        System.out.println();

        course.sortByTopicAlphabet();
        System.out.println("Lectures Sorted by Topic in Alphabetical Order:");
        course.print();
        System.out.println();

        CourseSort course2 = new CourseSort("Python Course", "Dou", lectureList);
        course2.sortByIncreaseNumberWordsTopic();
        System.out.println("Lectures Sorted by Increasing Words in Topic:");
        course2.print();

        System.out.println();
        course2.sortByTopicAlphabet();
        System.out.println("Lectures Sorted by Topic in Alphabetical Order:");
        course2.print();
    }
}

