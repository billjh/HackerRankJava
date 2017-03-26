import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        char[] str = scanner.next().trim().toCharArray();

        HashSet<Integer> weights = new HashSet<>();

        int last = 0;
        for (int i = 0; i < str.length; i++) {
            char cur = str[i];
            if (cur != str[last]) {
                last = i;
            }
            weights.add((cur - 'a' + 1) * (i - last + 1));
        }

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int query = scanner.nextInt();
            System.out.println(weights.contains(query) ? "Yes" : "No");
        }
    }
}
