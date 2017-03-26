import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final char[] word = "hackerrank".toCharArray();

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {

            int pos = 0;

            char[] query = scanner.next().trim().toCharArray();
            for (int j = 0; j < query.length; j++) {
                if (query[j] == word[pos]) {
                    pos++;
                    if (pos >= word.length) {
                        break;
                    }
                }
            }

            System.out.println((pos >= word.length) ? "YES" : "NO");
        }
    }
}
