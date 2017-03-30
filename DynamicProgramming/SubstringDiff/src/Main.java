import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {

            int maxDiff = scanner.nextInt();

            char[] seqA = scanner.next().toCharArray();
            char[] seqB = scanner.next().toCharArray();

            System.out.println(solve(maxDiff, seqA, seqB));
        }

    }

    private static int solve(int maxDiff, char[] seqA, char[] seqB) {

        int len = Math.min(seqA.length, seqB.length);
        int result = 0;

        for (int offset = 1 - len; offset < len; offset++) {
            ArrayList<Integer> mismatch = new ArrayList<>();

            int start = offset < 0 ? -offset : 0;
            for (int i = start, j = i + offset; j < len && i < len; i++, j++) {
                if (seqA[i] == seqB[j]) {
                    result = Math.max(result, i - start + 1);
                } else if (mismatch.size() == maxDiff) {
                    if (maxDiff > 0) {
                        start = mismatch.remove(0) + 1;
                        mismatch.add(i);
                    } else {
                        start = i + 1;
                    }
                } else {
                    result = Math.max(result, i - start + 1);
                    mismatch.add(i);
                }
            }

        }

        return result;
    }
}
