import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        char[] sentence = scanner.nextLine().trim().toCharArray();

        HashSet<Integer> charSet = new HashSet<>();
        final int alphabet = 26;

        for (int i = 0; i < sentence.length && charSet.size() < alphabet ; i++) {
            char c = sentence[i];
            if (c >= 'a' && c <= 'z') {
                charSet.add(c - 'a');
            } else if (c > 'A' && c <= 'Z') {
                charSet.add(c - 'A');
            }
        }

        System.out.println((charSet.size() < alphabet) ? "not pangram" : "pangram");

    }
}
