import java.io.IOException;
import java.util.Scanner;

public class Task3 {
    public static int digital_root(int number) {
        if (number < 10) {
            return number;
        } else {
            // sum of last digit and digital_root(number without last digit)
            return digital_root(number % 10 + digital_root(number / 10));
        }
    }

    public static void exit() throws IOException {
        System.out.print("\nPress any key to exit...");
        System.in.read();
    }

    public static void main(String[] args) throws IOException {
        System.out.print("Enter an integer number to find digital root: ");
        int input = new Scanner(System.in).nextInt();
        System.out.println("Result: " + digital_root(input));

        exit();
    }
}
