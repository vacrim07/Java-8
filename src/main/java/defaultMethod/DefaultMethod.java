package defaultMethod;

public class DefaultMethod implements PersonA, PersonB{

    @Override
    public void walk() {
        System.out.println("I am walking");
    }

    @Override
    public void speak() {
        PersonB.super.speak();
    }


    public static void main(String[] args) {
        DefaultMethod app = new DefaultMethod();
        app.walk();
        app.speak();
    }
}
