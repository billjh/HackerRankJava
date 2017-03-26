import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {

            char[] s = scanner.next().toCharArray();

            boolean funny = true;
            for (int j = 1; j <= s.length/2; j++) {
                if (Math.abs(s[j] - s[j-1]) != Math.abs(s[s.length - j] - s[s.length - j - 1])) {
                    funny = false;
                    break;
                }
            }

            System.out.println(funny ? "Funny" : "Not Funny");
        }

    }
}
