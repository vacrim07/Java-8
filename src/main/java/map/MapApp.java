package map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class MapApp {

    private Map<Integer, String> map;

    public void populateMap(){
        map = new HashMap<>();
        map.put(1, "Real Madrid");
        map.put(2, "Liverpool");
        map.put(3, "Bayern Munchen");
        map.put(4, "Ajax");
    }

    public void printWithJavaV7(){
        for(Entry<Integer, String> e : map.entrySet()){
            System.out.println("Key: " + e.getKey() + " Value: " + e.getValue());
        }
    }

    public void printWithJavaV8(){
        //map.forEach((k,v) -> System.out.println("Key: " + k + " Value: " + v ));
        map.entrySet().forEach(System.out::println);
    }

    public void insertIfIsAbsent(){
        map.putIfAbsent(5 , "AC Milan");

        printWithJavaV8();
    }

    public void computeIfIsPresent(){
        map.computeIfPresent(2,  (k,v) -> k + v);
        System.out.println(map.get(2));
    }

    public void getOrDefault(){
        System.out.println(map.getOrDefault(6, "Olympique Marseille"));
    }

    public void collect(){
        Map<Integer, String> newMap = map.entrySet().stream()
                .filter(e -> e.getValue().contains("a"))
                .collect(Collectors.toMap(p -> p.getKey(), Entry::getValue));

        newMap.entrySet().forEach(System.out::println);
    }

    public static void main(String[] args) {
        MapApp app = new MapApp();
        app.populateMap();

        // Using JDK <= 1.7
        //app.printWithJavaV7();

        // Using JDK <= 1.8
        //app.printWithJavaV8();

        // Insert if the key is absent
        //app.insertIfIsAbsent();

        // Compute if the key is present
        //app.computeIfIsPresent();

        // Default value
        //app.getOrDefault();

        // Collect
        app.collect();
    }
}
