import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char[] s = scanner.next().trim().toCharArray();

        int count = 0;

        if (s.length > 0) {

            for (int i = 0; i < s.length; i++) {
                if (s[i] >= 'A' && s[i] <= 'Z') {
                    count++;
                }
            }
        }

        System.out.println(count + 1);
    }
}
