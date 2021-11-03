import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExtraTask1 {
    public static int nextBigger(int number) {
        List<Integer> digits = new ArrayList<>();

        while (number != 0) {
            digits.add(number % 10);
            number /= 10;
        }

        boolean swapDone = false;

        for (int i = 0; i < digits.size() - 1; i++) {
            if (digits.get(i) > digits.get(i + 1)) {
                int temporary = digits.get(i + 1);
                digits.set(i + 1, digits.get(i));
                digits.set(i, temporary);
                swapDone = true;
                break;
            }
        }

        if (swapDone == false) {
            return -1;
        } else {
            int nextNumber = 0;
            int coefficient = 1;

            for (int digit : digits) {
                nextNumber += digit * coefficient;
                coefficient *= 10;
            }

            return nextNumber;
        }
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
