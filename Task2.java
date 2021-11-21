import java.io.IOException;
import java.util.Scanner;

public class Task2 {
    public static Character first_non_repeating_letter(String str) {
        String strInLowerCase = str.toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            char currentLetter = strInLowerCase.charAt(i);
            if (strInLowerCase.chars().filter(letter -> letter == currentLetter).count() == 1) {
                return str.charAt(i);
            }
        }

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
