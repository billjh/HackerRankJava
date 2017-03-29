import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {

            int n = scanner.nextInt();

            int[] sticks = new int[n];

            for (int j = 0; j < n; j++) {
                sticks[j] = scanner.nextInt();
            }

            System.out.printf("%.2f\n", solve(sticks, n));
        }
    }

    private static double solve(int[] sticks, int n) {
        // http://cs.stackexchange.com/questions/1076/how-to-approach-vertical-sticks-challenge/1114#1114

        final int stickMax= 1000;

        int[] counter = new int[stickMax + 1];

        for (int i = 0; i < n; i++) {
            counter[sticks[i]]++;
        }

        for (int i = stickMax; i > 0; i--) {
            counter[i - 1] += counter[i];
        }

        double exp = 0.0;

        for (int i = 0; i < n; i++) {
            exp += (double)(n + 1) / (counter[sticks[i]] + 1.0);
        }

        return exp;
    }
}
