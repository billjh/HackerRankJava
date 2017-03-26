import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next().trim();

        HashSet<Character> charSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            charSet.add(s.charAt(i));
        }
        Character[] chars = charSet.toArray(new Character[0]);

        int result = 0;

        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                Character charOne = chars[i];
                Character charTwo = chars[j];

                int count = GetCount(s, charOne, charTwo);
                if (count > result) {
                    result = count;
                }
            }
        }
        System.out.println(result);
    }

    private static int GetCount(String s, Character charOne, Character charTwo) {
        int count = 0;

        boolean firstEncountered = false;
        char last = '?';

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            if (cur != charOne && cur != charTwo) {
                continue;
            }

            if (!firstEncountered || last != cur) {
                firstEncountered = true;
                count++;
                last = cur;
            } else {
                return 0;
            }
        }

        return count;
    }
}
