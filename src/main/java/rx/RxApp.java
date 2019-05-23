package rx;

import rx.functions.Action1;

import java.util.ArrayList;
import java.util.List;

public class RxApp {

    private List<Integer> list1;
    private List<Integer> list2;

    public RxApp(){
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        this.fillLists();
    }

    public void fillLists() {
        for (int i = 0; i < 10000; i++){
            list1.add(i);
            list2.add(i);
        }
    }

    public void search(){
        Observable<Integer> observable1 = Observable.from(list1);
        Observable<Integer> observable2 = Observable.from(list2);

        // Using anonymous classes
        /*
        Observable.merge(observable1, observable2).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer number) {
                if(number == 1) System.out.println(number);
            }
        });
         */

        // Using lambda
        Observable.merge(observable1, observable2).filter(x -> x == 1).subscribe(System.out::println);
    }

    public static void main(String[] args) {
        // Intro to Observers
        /*
        List<String> list = new ArrayList<>();
        list.add("Real Madrid");
        list.add("Liverpool");
        list.add("Bayern Munchen");

        Observable<String> observable = Observable.from(list);
        observable.subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(s);
            }
        });
        */

        RxApp app = new RxApp();

        // Using merge (use two observers at the same time)
        app.search();
    }
}
