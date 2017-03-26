import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final int MOD = 1000000007;

        char[] numStr = scanner.next().toCharArray();

        long result = 0;
        long digits = 1;

        for (int i = numStr.length - 1; i >= 0; i--) {
            result = (result + (numStr[i] - '0') * digits * (i + 1)) % MOD;
            digits = (digits * 10 + 1) % MOD;
        }

        System.out.println(result);

    }
}
