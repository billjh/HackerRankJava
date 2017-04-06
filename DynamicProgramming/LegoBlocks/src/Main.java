import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        Solver solver = new Solver(new int[]{1, 2, 3, 4});

        for (int i = 0; i < t; i++) {

            int height = scanner.nextInt();
            int width = scanner.nextInt();

            System.out.println(solver.solve(height, width));
        }

    }
}

class Solver {

    private static final int MOD = 1000000007;
    private static final int LIMIT = 1001;
    private int[] blocks;

    private long[] row;
    private long[][] all;
    private HashMap<Integer, Long> solidCache;

    Solver(int[] b) {
        this.blocks = b;

        row = new long[LIMIT];
        row[0] = 1;
        for (int width = 1; width < LIMIT; width++) {
            long s = 0;
            for (int block: blocks) {
                if (width - block >= 0) {
                    s = (s + row[width - block]) % MOD;
                }
            }
            row[width] = s;
        }

        all = new long[LIMIT][LIMIT];
        for (int width = 1; width < LIMIT; width++) {
            all[0][width] = 1;
            for (int height = 1; height < LIMIT; height++) {
                all[height][width] = all[height - 1][width] * row[width] % MOD;
            }
        }

        solidCache = new HashMap<>();
    }

    private int hash(int height, int width) {
        return height * LIMIT + width;
    }

    private long solid(int height, int width) {
        int wall = hash(height, width);
        if (solidCache.containsKey(wall)) {
            return solidCache.get(wall);
        }
        long notSolid = 0;
        for (int i = 1; i < width; i++) {
            notSolid = (notSolid + solid(height, i) * all[height][width - i] % MOD) % MOD;
        }
        long result = all[height][width] - notSolid;
        if (result < 0) {
            result += MOD;
        }
        solidCache.put(wall, result);
        return result;
    }

    public long solve(int height, int width) {
        return solid(height, width);
    }
}