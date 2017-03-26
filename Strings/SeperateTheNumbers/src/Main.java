import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {

            String s = scanner.next();

            System.out.println(solve(s));
        }

    }

    private static String solve(String s) {

        if (s.length() > 0 && s.charAt(0) == '0') {
            return "NO";
        }

        for (int i = 1; i <= s.length()/2; i++) {

            String first = s.substring(0, i);

            // skip if next number start with 0
            if (s.charAt(i) == '0') {
                continue;
            }

            BigInteger one = new BigInteger("1");
            BigInteger next = new BigInteger(first).add(one);

            for (int j = i; j <= s.length(); next = next.add(one)) {

                if (j == s.length()) {
                    return "YES " + first;
                }

                String nextStr = next.toString();

                if (j + nextStr.length() > s.length() || !nextStr.equals(s.substring(j, j + nextStr.length()))) {
                    break;
                }

                j += nextStr.length();
            }
        }

        return "NO";
    }
}
