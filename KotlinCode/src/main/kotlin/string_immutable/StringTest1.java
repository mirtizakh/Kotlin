package string_immutable;

public class StringTest1 {

    public void test(){
        String name = "Test";
        name = "xyz";
        String name2 = "Test";
        String name3 = new String("Test");

        System.out.println(name == name2);
        System.out.println(name.equals(name2));

        System.out.println(name == name3);
        System.out.println(name.equals(name3));

        Data data = new Data();
        Data data2 = new Data();

        data.equals(data2);

    }

}

class Data{


}
