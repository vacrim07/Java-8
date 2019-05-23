package defaultMethod;

public interface PersonA {

    public void walk();

    default public void speak(){
        System.out.println("A is speaking");
    }
}
