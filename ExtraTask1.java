import java.io.IOException;
import java.util.*;

public class ExtraTask1 {
    public static int nextBigger(int number) {
        List<Integer> digits = new ArrayList<>();

        while (number != 0) {
            digits.add(number % 10);
            number /= 10;
        }


        int firstGreaterDigit = -1; // index of first digit greater than next
        for (int i = 0; i < digits.size() - 1; i++) {
            if (digits.get(i) > digits.get(i + 1)) {
               firstGreaterDigit = i + 1;
               break;
            }
        }

        if (firstGreaterDigit == -1) {
            return -1;
        }

        int minIndex = 0;
        for (int i = 0; i < firstGreaterDigit; i++) {
            if (digits.get(minIndex) > digits.get(i)) {
                minIndex = i;
            }
        }

        int temporary = digits.get(firstGreaterDigit);
        digits.set(firstGreaterDigit, digits.get(minIndex));
        digits.set(minIndex, temporary);

        Collections.sort(digits.subList(0, firstGreaterDigit));
        Collections.reverse(digits.subList(0, firstGreaterDigit));

        // restore number from digits
        int nextNumber = 0;
        int coefficient = 1;

        for (int digit : digits) {
            nextNumber += digit * coefficient;
            coefficient *= 10;
        }

        return nextNumber;
    }

    public static void exit() throws IOException {
        System.out.print("\nPress any key to exit...");
        System.in.read();
    }

    public static void main(String[] args) throws IOException {
        System.out.print("Enter an integer number to find next bigger: ");
        int input = new Scanner(System.in).nextInt();
        System.out.println("Result number is " + nextBigger(input));

        exit();
    }
}
