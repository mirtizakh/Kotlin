package lambda;

interface Printable {
    void print();
}

class Car implements Printable {

    String name;
    @Override
    public void print() {
        System.out.println("BMW");
    }
}

public class Lambda {
    public static void main(String[] args) {
        Car car = new Car();
        car.print();

        // Also

        printThing(car);

        // 1- We are just passing in the specific implementation directly
        /*
         printThing(

         public void print() {
            System.out.println("BMW");
         }

         );
         */

        /* 2- Now we need to remove the return type , access level and function name ,
         to make it valid Lambda syntax add an arrow */
         printThing(
          () -> {
            System.out.println("BMW");
             }
         );

         /* Basically instead of sending an object which contains an action ,
            we are just sending in the action itself above.
          printThing(car);
         */

        // 3- We can even simply write  our lambda expression
        printThing(() -> System.out.println("BMW"));

        // 4- We can also write like
        Printable printable = () -> System.out.println("BMW");
        printThing(printable);

        // So lambdas in java give you the ability to make method implementations into objects like any others .
        // They can save into variables and pass into methods as parameters.
    }
    static void printThing(Printable printable)
    {
        // Lambda allow us to just pass in specific implementation of this print method as the Printable parameter
        printable.print();
    }
}
