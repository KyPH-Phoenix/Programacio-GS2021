import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class MainWords {
    public static void main(String[] args) throws IOException {
        Reader r = new FileReader("C:\\Users\\hugon\\Desktop\\diccionario.txt");
        BufferedReader br = new BufferedReader(r);

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        while (true) {
            String word = br.readLine();z
            if (word == null) break;

            set1.add(word);
            set2.add(reverse(word));
        }

        System.out.println(set1);
        System.out.println(set2);

        for (String word : set2) {
            if (set1.contains(word)) {
                System.out.println(word + " <==> " + reverse(word));
            }
        }
    }

    private static String reverse(String word) {
        String result = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            result += word.charAt(i);
        }

        return result;
    }
}