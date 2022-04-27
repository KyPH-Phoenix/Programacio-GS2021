import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lists {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        System.out.println(list.isEmpty() + " " + list.size());

        list.add("Hola");
        list.add("como");
        list.add("estas?");

        System.out.println(list.isEmpty() + " " + list.size());

        System.out.println(list);

        System.out.println(list.contains("Hola"));
        System.out.println(list.contains("Mayonesa"));

        String result = list.get(2);

        System.out.println(result);

        list.add(1, "mayonesa");
        list.add("mayonesa");

        System.out.println(list);

        while (list.remove("mayonesa"));

        System.out.println(list);

        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("MORENO");
    }
}
