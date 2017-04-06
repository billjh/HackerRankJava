import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        int[] n = new int[t];
        int max = 0;

        for (int i = 0; i < t; i++) {
            n[i] = scanner.nextInt();
            max = Math.max(max, n[i]);
        }

        Solver solver = new Solver(max);

        for (int i = 0; i < t; i++) {
            System.out.println(solver.solve(n[i]));
        }
    }
}

class Solver {

    private int[] bricks = new int[]{1, 4};
    private int[] wall;
    private Integer[] primesArray;

    Solver(int max) {

        wall = new int[max+1];

        wall[0] = 1;
        for (int i = 1; i <= max; i++) {
            int sum = 0;
            for (int b: bricks) {
                if (i - b >= 0) {
                    sum += wall[i - b];
                }
            }
            wall[i] = sum;
        }

        ArrayList<Integer> primes = new ArrayList<>();

        if (wall[max] < 2) {
            return;
        }

        primes.add(2);

        for (int i = 3; i <= wall[max]; i += 2) {
            boolean isPrime = true;
            for (int j = 3; j*j <= i && isPrime; j += 2) {
                isPrime = (i % j > 0);
            }
            if (isPrime) {
                primes.add(i);
            }
        }

        primesArray = primes.toArray(new Integer[0]);
    }

    int solve(int n) {
        for (int pos = 0; pos < primesArray.length; pos++) {
            if (wall[n] < primesArray[pos]) {
                return pos;
            }
        }
        return primesArray.length;
    }
}
