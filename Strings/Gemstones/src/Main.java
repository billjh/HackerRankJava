import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        String firstStone = scanner.next();

        HashSet<Character> elements = getElements(firstStone);

        for (int i = 1; i < n; i++) {
            String stone = scanner.next();
            elements.retainAll(getElements(stone));
        }

        System.out.println(elements.size());
    }

    private static HashSet<Character> getElements(String stone) {

        HashSet<Character> elements = new HashSet<>();

        for (int i = 0; i < stone.length(); i++) {
            elements.add(stone.charAt(i));
        }

        return elements;
    }
}
