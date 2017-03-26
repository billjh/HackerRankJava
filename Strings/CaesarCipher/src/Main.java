import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        char[] str = scanner.next().toCharArray();

        int k = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            str[i] = flip(str[i], k);
        }

        System.out.println(new String(str));
    }

    private static char flip(char c, int k) {
        if (c >= 'a' && c <= 'z') {
            return (char) ('a' + (c - 'a' + k) % 26);
        }
        if (c >= 'A' && c <= 'Z') {
            return (char) ('A' + (c - 'A' + k) % 26);
        }
        return c;
    }
}
