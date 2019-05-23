package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CollectionApp {

    private List<String> aList;

    public void fillTheList(){
        aList = new ArrayList<>();

        aList.add("Real Madrid");
        aList.add("Liverpool");
        aList.add("Ajax");
    }

    public void useForEach(){
        // Traditional Way
        /*for (String element : aList) {
            System.out.println(element);
        }*/

        // Lambda Way
        //aList.forEach(x -> System.out.println(x));

        // Reference methods way
        aList.forEach(System.out::println);
    }

    public void useRemoveIf(){
        // Traditional Way  -> ConcurrentModificationException
        /*for (String element : aList) {
            if(element.equalsIgnoreCase("Real Madrid")){
                aList.remove(element);
            }
        }*/

        // Iterator Way -> Solves the exception
        Iterator<String> i = aList.iterator();
        /*while (i.hasNext()){
            if(i.next().equalsIgnoreCase("Real Madrid")){
                i.remove();
            }
        }*/

        // RemoveIf Way
        aList.removeIf(s -> s.equalsIgnoreCase("Real Madrid"));

        aList.forEach(System.out::println);
    }

    public void useSort(){
        // Lambda Way
        //aList.sort((x,y) -> x.compareToIgnoreCase(y));

        // Reference Methods Way
        aList.sort(String::compareToIgnoreCase);

        aList.forEach(System.out::println);
    }

    public static void main(String[] args) {
        CollectionApp app = new CollectionApp();
        app.fillTheList();

        // forEach
        //app.useForEach();

        // removeIf
        //app.useRemoveIf();

        // sort
        app.useSort();
    }
}
