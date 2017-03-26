import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char[] msg = scanner.next().trim().toCharArray();

        int count = 0;
        for (int i = 0; i < msg.length; i++) {
            if (i % 3 == 1) {
                if (msg[i] != 'O') {
                    count++;
                }
            } else if (msg[i] != 'S') {
                count++;
            }
        }

        System.out.println(count);
    }
}
