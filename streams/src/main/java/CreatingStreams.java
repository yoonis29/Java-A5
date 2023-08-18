import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreatingStreams {
    public static void main(String[] args) {

        //Creating Stream from Array

        String[] courses = {"Java","JS", "TS"};
        Stream<String> coursesStream =Arrays.stream(courses);

        //Creating Stream from Collection
        List<String> courseList =Arrays.asList("Java","DS", "Spring");
        Stream<String> coursesStream2 =courseList.stream();

        List<Course> myCourses =Arrays.asList(
                new Course("Java",100),
                new Course("DS",101),
                new Course("Spring",102),
                new Course("MicroService", 103)
        );
        Stream<Course> myCourseStream = myCourses.stream();

        //Creating Stream from values
        Stream<Integer> stream =Stream.of(1,2,3,4);
    }
}
