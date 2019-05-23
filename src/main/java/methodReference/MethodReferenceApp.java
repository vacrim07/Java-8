package methodReference;

import java.time.Period;
import java.util.Arrays;
import java.util.Comparator;

public class MethodReferenceApp {

    public static void referenceStaticMethod(){
        System.out.println("Static method referenced");
    }

    public void referenceRandomMethodInstanceObject(){
        String[] names = {"Real Madrid", "Liverpool", "Ajax"};

        // Traditional Way (Anonymous Class)
        /*Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });*/

        // Lambda way
        //Arrays.sort(names, (o1, o2) -> o1.compareToIgnoreCase(o2));

        // Method Reference Way
        Arrays.sort(names, String::compareToIgnoreCase);

        System.out.println(Arrays.toString(names));
    }

    public void referenceParticularMethodInstanceObject(){
        System.out.println("Referred Method Particular Object Instance");
    }

    public void referenceConstructor(){

        // Traditional Way
        /*IPerson person = new IPerson() {
            @Override
            public Person create(Integer id, String name) {
                return new Person(id, name);
            }
        };*/

        // Lambda way
        //IPerson person = (x,y) -> (new Person(x,y));

        //Method reference way
        IPerson person = Person::new;

        Person p = person.create(1,"Vlado");
        System.out.println(p.getId() + "-" + p.getName());
    }

    public void operate(){
        /*lambda.Operation op = () -> MethodReferenceApp.referenceStaticMethod();
        op.sayHello();*/

        Operation op2 = MethodReferenceApp::referenceStaticMethod;
        op2.sayHello();
    }

    public static void main(String[] args) {
        MethodReferenceApp app = new MethodReferenceApp();

        // referenceStaticMethod
        //app.operate();

        // referenceRandomMethodInstanceObject
        //app.referenceRandomMethodInstanceObject();

        // referenceParticularMethodInstanceObject
        //lambda.Operation op = app::referenceParticularMethodInstanceObject;
        //op.sayHello();

        // referenceConstructor
        app.referenceConstructor();
    }
}
