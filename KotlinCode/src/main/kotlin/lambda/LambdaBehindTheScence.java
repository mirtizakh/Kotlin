package lambda;

public class LambdaBehindTheScence {
    // When your interface has method with no implementation its call abstract method
    // When an interface only has 1 single abstract method its called a functional interface.
    // When you have a function interface you can add annotation as well like

    @FunctionalInterface
    interface Printable {
        String print(String suffix);
    }
    // Now the compiler will in force you to have 1 single method.
    // If we try to add 1 more method it will give us error
    // There are also called SAM interfaces (Single Abstract Method)


    // So Lambda is a shortcut of defining an implementation of functional interface
}
