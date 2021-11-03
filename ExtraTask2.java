import java.io.IOException;
import java.util.Scanner;

public class ExtraTask2 {
    public static String getIPv4fromInt(long unsignedIntValue) {
        unsignedIntValue = unsignedIntValue & 0xffffffffL;

        StringBuilder IPv4 = new StringBuilder();
        long mask = 0xffL;
        for (int i = 1; i <= 4; i++) {
            int shift = 32 - 8 * i;

            IPv4.append((unsignedIntValue >>> shift) & mask);

            if (i < 4) {
                IPv4.append(".");
            }
        }

        return IPv4.toString();
    }

    public static void exit() throws IOException {
        System.out.print("\nPress any key to exit...");
        System.in.read();
    }

    public static void main(String[] args) throws IOException {
        System.out.print("Enter an unsigned 32-bit integer number to IPv4 representation: ");
        long input = new Scanner(System.in).nextLong();
        System.out.println("Result number is " + getIPv4fromInt(input));

        exit();
    }
}
