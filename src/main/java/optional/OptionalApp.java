package optional;

import java.util.Optional;

public class OptionalApp {

    public void test (String value){
        // Get Null Pointer Exception
        //System.out.println(value.contains("Liverpool"));

        // Solving exception with optional
        try{
            Optional optional = Optional.empty();
            optional.get();
        }catch (Exception e){
            System.out.println("There is no element available ");
        }

        // Basic optional
        /*Optional<String> optional = Optional.of(value);
        String s = optional.get();*/
    }

    public void orElse(String value){
        Optional<String> optional = Optional.ofNullable(value);
        System.out.println(optional.orElse("Default value"));
    }

    public void orElseThrow(String value){
        Optional<String> optional = Optional.ofNullable(value);
        System.out.println(optional.orElseThrow(NumberFormatException::new));
    }

    public void isPresent(String value){
        Optional<String> optional = Optional.ofNullable(value);
        System.out.println(optional.isPresent());
    }

    public static void main(String[] args) {
        OptionalApp app = new OptionalApp();

        // Basic optional
        //app.test("Liverpool");

        // orElse
        //app.orElse("Liverpool");

        // orElseThrow
        //app.orElseThrow("Liverpool");

        // isPresent
        app.isPresent(null);
    }
}
