package defaultMethod;

public interface PersonB {

    default public void speak(){
        System.out.println("B is speaking");
    }
}
