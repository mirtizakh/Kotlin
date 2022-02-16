package lambda;



public class LambdaParameters {
    interface Printable {
        void print(String suffix);
    }

    public static void main(String[] args) {
        Printable printable = (s) -> System.out.println("BMW "+s);
    }

    static void printThing(Printable printable)
    {
        printable.print("?");
    }
}
