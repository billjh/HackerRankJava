import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);

        char[] str = scanner.next().trim().toCharArray();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length; i++) {
            if (!stack.empty() && stack.peek() == str[i]) {
                stack.pop();
            } else {
                stack.push(str[i]);
            }
        }

        Character[] result = stack.toArray(new Character[0]);

        if (result.length == 0) {
            System.out.println("Empty String");
            return;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            builder.append(result[i]);
        }
        System.out.println(builder.toString());
    }
}