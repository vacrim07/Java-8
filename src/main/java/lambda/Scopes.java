package lambda;

public class Scopes {

    private static Double a1;
    private Double a2;

    public double tryLocalVariable(){
        double n3 = 3;

        // JDK < 1.7
        /*
        lambda.Operation operation = new lambda.Operation() {
            @Override
            public double calculateAverage(Integer n1, Integer n2) {
                return n3 + n1 + n2;
            }
        };
         */

        Operation operation = (x,y) -> x + y + n3;

        return operation.calculateAverage(1d,1d);
    }

    public double tryStaticVariables(){

        // JDK < 1.7
        /*
        lambda.Operation operation = new lambda.Operation() {
            @Override
            public double calculateAverage(Double n1, Double n2) {
                a1 = n1 + n2;
                a2 = n1 + n2;
                return a2;
            }
        };
         */


        // Lambda
        Operation operation = (x, y) -> {
            a1 = x + y;
            a2 = a1;
            return a2;
        };

        return operation.calculateAverage(1d,1d);
    }

    public static void main(String[] args) {
        Scopes app = new Scopes();
        System.out.println(app.tryLocalVariable());
        System.out.println(app.tryStaticVariables());
    }
}
