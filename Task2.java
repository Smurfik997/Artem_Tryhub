import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task2 {
    public static Character first_non_repeating_letter(String str) {
        // letter in lowercase -> index of first entry | str.length() if more than one
        HashMap<Character, Integer> letters = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            Character symbol = Character.toLowerCase(str.charAt(i));

            if (letters.containsKey(symbol)) {
                letters.replace(symbol, str.length());
            } else {
                letters.put(symbol, i);
            }
        }

        // first unique symbol
        int minIndex = str.length();
        for (Map.Entry<Character, Integer> entry : letters.entrySet()) {
            if (entry.getValue() < minIndex) {
                minIndex = entry.getValue();
            }
        }

        // return result with O(N) algorithm complexity
        if (minIndex != str.length())
            return str.charAt(minIndex);
        else
            return null;
    }

    public static void exit() throws IOException {
        System.out.print("\nPress any key to exit...");
        System.in.read();
    }

    public static void main(String[] args) throws IOException {
        System.out.print("Enter a string line to find first non-repetitive symbol: ");
        String input = new Scanner(System.in).nextLine();
        System.out.println("Result: " + first_non_repeating_letter(input));

        exit();
    }
}
