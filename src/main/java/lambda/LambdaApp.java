package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaApp {

    public void order(){
        List<String> aList = new ArrayList<>();
        aList.add("Real Madrid");
        aList.add("Liverpool");
        aList.add("Bayern Munchen");

        // JDK < 1.7
        /*
        Collections.sort(aList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        */

        // Lambda
        Collections.sort(aList, (String p1, String p2) -> p1.compareTo(p2));

        for (String element:
             aList) {
            System.out.println(element);
        }
    }

    public void calculate(){

        // JDK < 1.7
        /*
        lambda.Operation operation = new lambda.Operation() {
            @Override
            public double calculateAverage(Integer n1, Integer n2) {
                return (n1+n2)/2;
            }
        };
        */

        // Lambda
        Operation operation = (x, y) -> (x+y)/2;

        System.out.println(operation.calculateAverage(2d,4d));
    }

    public static void main(String[] args) {
        LambdaApp app = new LambdaApp();
        app.order();
        app.calculate();
    }
}
