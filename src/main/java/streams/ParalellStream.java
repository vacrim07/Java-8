package streams;

import java.util.ArrayList;
import java.util.List;

public class ParalellStream {

    private List<Integer> numbers;
    public void fill(){
        numbers = new ArrayList<>();
        for (int i = 0; i < 10 ; i++){
            numbers.add(i);
        }
    }

    public void testStream(){
        numbers.stream().forEach(System.out::println);
    }

    public void testParallel(){
        numbers.parallelStream().forEach(System.out::println);
    }

    public static void main(String[] args) {
        ParalellStream app = new ParalellStream();
        app.fill();

        // Custom stream
        //app.testStream();

        // Parallel stream
        app.testParallel();
    }
}
