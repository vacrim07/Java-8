package streams;

import java.util.ArrayList;
import java.util.List;

public class StreamsApp {

    private List<String> list;
    private List<String> numbers;

    public StreamsApp(){
        list = new ArrayList<>();
        list.add("Real Madrid");
        list.add("Liverpool");
        list.add("Bayern Munchen");
        list.add("Manchester United");
        list.add("Ajax");

        numbers = new ArrayList<>();
        numbers.add("1");
        numbers.add("2");
        numbers.add("3");
        numbers.add("4");
    }

    public void filter(){
        // Using lambda expressions
        list.stream().filter(x -> x.startsWith("A")).forEach(System.out::println);
    }

    public void order(){
        // Using lambda expressions

        // Descending
        //list.stream().sorted().forEach(System.out::println);

        // Ascending
        list.stream().sorted((x,y) -> y.compareToIgnoreCase(x)).forEach(System.out::println);
    }

    public void transform(){
        // Assigning upper case
        //list.stream().map(String::toUpperCase).forEach(System.out::println);

        // From String to Integer

        //Traditional Way
        /*for (String x : numbers) {
            Integer number = Integer.parseInt(x) + 1;
            System.out.println(number);
        }*/

        // Using lambda expressions
        numbers.stream().map(x -> Integer.parseInt(x) + 1).forEach(System.out::println);
    }

    public void limit(){
        list.stream().limit(2).forEach(System.out::println);
    }

    public void count(){
        System.out.println(list.stream().count());
    }

    public static void main(String[] args) {
        StreamsApp app = new StreamsApp();

        // filter
        //app.filter();

        // order
        //app.order();

        // transform (Use of map())
        //app.transform();

        // limit
        //app.limit();

        // count
        app.count();
    }
}
