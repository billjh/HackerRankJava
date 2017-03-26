import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        Solver solver = new Solver(new int[] {1, 2, 5});

        for (int i = 0; i < t; i++) {

            int n = scanner.nextInt();

            int[] colleagues = new int[n];
            for (int j = 0; j < n; j++) {
                colleagues[j] = scanner.nextInt();
            }

            System.out.println(solver.solve(colleagues));
        }
    }
}

class Solver {

    private int[] ops;
    private int opsMax;
    private HashMap<Integer, Integer> cache;

    Solver(int[] ops) {
        this.cache = new HashMap<>();
        this.cache.put(0, 0);
        this.ops = ops;

        this.opsMax = Integer.MIN_VALUE;
        for (int op : ops) {
            opsMax = Math.max(opsMax, op);
        }
    }

    private int get(int target) {

        if (cache.containsKey(target)) {
            return cache.get(target);
        }

        int min = Integer.MAX_VALUE;
        for (int op : ops) {
            if (op > target) {
                continue;
            }
            min = Math.min(min, get(target - op) + 1);
        }

        cache.put(target, min);
        return min;
    }

    public int solve(int[] colleagues) {

        int colleagueMin = Integer.MAX_VALUE;

        for (int i = 0; i < colleagues.length; i++) {
            colleagueMin = Math.min(colleagueMin, colleagues[i]);
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < opsMax; i++) {

            int baseline = colleagueMin - i;

            int totalOps = 0;

            for (int j = 0; j < colleagues.length; j++) {
                totalOps += get(colleagues[j] - baseline);
            }

            answer = Math.min(answer, totalOps);
        }

        return answer;
    }
}