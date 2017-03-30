import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] a = new int[n];
        int[] b = new int[m];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        for (int j = 0; j < m; j++) {
            b[j] = scanner.nextInt();
        }

        int[][] C = new int[n + 1][m + 1];

        // tabulation
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    C[i][j] = 0;
                } else if (a[i - 1] == b[j - 1]) {
                    C[i][j] = C[i - 1][j - 1] + 1;
                } else {
                    C[i][j] = Math.max(C[i - 1][j], C[i][j - 1]);
                }
            }
        }

        int[] subseq = new int[C[n][m]];
        int i = n, j = m;

        while (C[i][j] > 0) {

            if (C[i][j] == C[i - 1][j]) {
                i--;
            } else if (C[i][j] == C[i][j - 1]) {
                j--;
            } else {
                subseq[C[i][j] - 1] = a[i - 1];
                i--;
                j--;
            }
        }

        for (int s: subseq) {
            System.out.printf("%d ", s);
        }
    }
}