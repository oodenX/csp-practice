package api;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        stream.forEach(x -> System.out.printf("%s ", x));
        // System.out.println("List: " + list);
        Stream<Integer> infiniteStream = Stream.iterate(0, n -> n + 2);
        Set<Integer> evenNumbers = infiniteStream.limit(10).collect(Collectors.toSet());
        for (Integer evenNumber : evenNumbers) {
            System.out.print(evenNumber + " ");
        }
    }
}
