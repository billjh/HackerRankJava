import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] ratings = new int[n];

        for (int i = 0; i < n; i++) {
            ratings[i] = scanner.nextInt();
        }

        long[] candies = new long[n];

        candies[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        long sum = 0;
        for (long c: candies) sum += c;

        System.out.println(sum);
    }
}
