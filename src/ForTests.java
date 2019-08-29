import java.util.*;

public class ForTests {
    public static void main(String[] args) {
        Map<String, Integer> map =  new TreeMap<>(Comparator.comparing(String::toString).reversed());
        map.put("Lucas", 28);
        map.put("Maria", 12);
        map.put("Mario", 44);
        map.put("João", 33);
        map.put("Angel", 33);

        map.entrySet().forEach(System.out::println);
    }


}
