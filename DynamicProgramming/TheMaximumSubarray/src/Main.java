import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();

            int[] arr = new int[n];

            for (int j = 0; j < n; j++) {
                arr[j] = scanner.nextInt();
            }

            System.out.printf("%d %d\n", maxSubarray(arr), maxSubsequence(arr));
        }

    }

    private static int maxSubarray(int[] arr) {
        int pre_max = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            pre_max = Math.max(arr[i], arr[i] + pre_max);
            max = Math.max(max, pre_max);
        }
        return max;
    }

    private static int maxSubsequence(int[] arr) {
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum = Math.max(Math.max(sum, sum + arr[i]), arr[i]);
        }
        return sum;
    }
}
