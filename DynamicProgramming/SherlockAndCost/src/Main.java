import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {

            int n = scanner.nextInt();
            int[] b = new int[n];

            for (int j = 0; j < n; j++) {
                b[j] = scanner.nextInt();
            }

            System.out.println(solve(b));
        }
    }

    private static int solve(int[] b) {

        // each element in array A is either 1 (low) or b_i (high)

        // optimal answer when previous item is low / high
        int pre_lo = 0, pre_hi = 0;

        for (int i = 1; i < b.length; i++) {
            // three cases: lo -> high, high -> lo, high -> high
            int lo_to_hi = Math.abs(b[i] - 1);
            int hi_to_lo = Math.abs(1 - b[i - 1]);
            int hi_to_hi = Math.abs(b[i] - b[i - 1]);

            // produce optimal answer
            int cur_lo = Math.max(pre_hi + hi_to_lo, pre_lo);
            int cur_hi = Math.max(pre_lo + lo_to_hi, pre_hi + hi_to_hi);

            pre_lo = cur_lo;
            pre_hi = cur_hi;
        }

        return Math.max(pre_lo, pre_hi);
    }
}
