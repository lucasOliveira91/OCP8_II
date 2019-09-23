import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ForTests {
    static class Student {
        String course, name, city;
        public Student (String name, String course, String city) {
            this.course = course; this.name = name; this.city = city;
        }
        public String toString() {
            return course + ":" + name + ":" + city;
        }

        String getCourse() {
            return this.course;
        }
    }

        public static void main(String[] args) {
            List<Student> stds = Arrays.asList(
                    new Student ("Jessy", "Java ME", "Chicago"),
                    new Student ("Helen", "Java EE", "Houston"),
                    new Student ("Mark", "Java ME", "Chicago"));
            stds.stream()
                    .collect(Collectors.groupingBy(Student::getCourse))
                    .forEach((src, res) -> System.out.println(src + res));
        }
}



