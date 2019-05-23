package functionalInterface;

public class FuncInterApp {

    public Double operate(Double x, Double y){
        Operation op = (n1,n2) -> n1 + n2;
        return op.calculate(x,y);
    }

    public static void main(String[] args) {
        FuncInterApp app = new FuncInterApp();
        Double answer = app.operate(2d,3d);
        System.out.println(answer);
    }
}
