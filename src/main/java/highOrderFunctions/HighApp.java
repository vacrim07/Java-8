package highOrderFunctions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class HighApp {

    // Basic functions
    private Function<String, String> convertToLowerCase = String::toLowerCase;
    private Function<String, String> convertToUpperCase = String::toUpperCase;

    public void print(Function<String, String> function, String value){
        System.out.println(function.apply(value));
    }                                                                   

    // Basic high order functions
    private Function<String, String> show(String message){
        return (String x) -> message + x;
    }

    // With predicates and consumers
    public void filter(List<String> list, Consumer<String> consumer, Integer length, String content){
        //list.stream().filter(byLenghtLowerThan(length)).forEach(consumer);
        list.stream().filter(byContent(content)).forEach(consumer);
    }

    public Predicate<String> byLenghtLowerThan(Integer length){
        return text -> text.length() < length;
    }

    public Predicate<String> byContent(String content){
        return text -> text.contains(content);
    }

    public static void main(String[] args) {
        HighApp app = new HighApp();

        // Basic functions
        //app.print(app.convertToLowerCase, "Hello!");
        //app.print(app.convertToUpperCase, "Hello!");

        // Basic high order functions
        //System.out.println(app.show("Hi ").apply("friends"));

        // With predicates and consumers
        List<String> list = new ArrayList<>();
        list.add("Real Madrid");
        list.add("Liverpool");
        list.add("Ajax");
        //app.filter(list, System.out::println, 5, null);
        app.filter(list, System.out::println, null, "a");
    }
}
