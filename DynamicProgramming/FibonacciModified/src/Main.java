import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BigInteger t1 = new BigInteger(scanner.next());
        BigInteger t2 = new BigInteger(scanner.next());

        FibonacciModified fib = new FibonacciModified(t1, t2);

        int n = scanner.nextInt();

        System.out.println(fib.get(n).toString());

    }
}

class FibonacciModified {

    private HashMap<Integer, BigInteger> map = new HashMap<>();

    FibonacciModified(BigInteger t1, BigInteger t2) {
        this.map.put(1, t1);
        this.map.put(2, t2);
    }

    public BigInteger get(int n) {

        if (n < 1) {
            throw new IllegalArgumentException();
        }

        if (this.map.containsKey(n)) {
            return this.map.get(n);
        }

        return get(n - 2).add(get(n - 1).multiply(get(n - 1)));
    }
}