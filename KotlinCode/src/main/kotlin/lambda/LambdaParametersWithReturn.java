package lambda;



public class LambdaParametersWithReturn {
    interface Printable {
        String print(String suffix);
    }

    public static void main(String[] args) {
        Printable printable = (s) -> {
            System.out.println("BMW "+s);
            return "BMW";
        };

        /* But if your method implementation is only one expression java automatically
           read it as return value, no need to add return */

        Printable printable2 = (s) -> "BMW "+s;

    }

    static void printThing(Printable printable)
    {
        printable.print("?");
    }
}
