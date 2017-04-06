import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {

            int n = scanner.nextInt();
            int[] prices = new int[n];

            for (int j = 0; j < n; j++) {
                prices[j] = scanner.nextInt();
            }

            System.out.println(solve(prices));
        }
    }

    private static long solve(int[] prices) {

        long profit = 0;
        int max = 0;

        for (int i = prices.length - 1; i >= 0; i--) {
            if (prices[i] > max) {
                max = prices[i];
            } else {
                profit += max - prices[i];
            }
        }

        return profit;
    }
}
