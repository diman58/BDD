import tools.ElementsReader;
import tools.WrapperOfElements;

import java.util.ArrayList;
import java.util.List;

public class tester {
    public static void main(String[] args) {
        List<WrapperOfElements> list = new ElementsReader().readAllElements();
        list.forEach(System.out::println);
        System.out.println(list.indexOf("Username"));

    }
}
