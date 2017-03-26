import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {

            char[] s = scanner.next().toCharArray();

            int deletion = 0;

            for (int j = 1; j < s.length; j++) {
                if (s[j] == s[j-1]) {
                    deletion++;
                }
            }

            System.out.println(deletion);
        }

    }
}
