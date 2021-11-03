import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task1 {
    public static List<Integer> getIntegersFromList(List<Object> originalList) {
        List<Integer> targetList = new ArrayList<>();

        for (Object element : originalList) {
            if (element instanceof Integer) {
                targetList.add((Integer) element);
            }
        }

        return targetList;
    }

    public static List<Object> getArrayFromInputStream() {
        System.out.println("Input array like examples:");
        System.out.println("[1, 2, 'a', 'b']");
        System.out.println("[1, 2, 'a', 'b', 0, 15]");
        System.out.println("[1, 2, 'a', 'b', 'aasf', '1', '123', 231]");
        System.out.print("Your array: ");
        String input = new Scanner(System.in).nextLine();

        String[] substrings = input.substring(1, input.length() - 1).split(",");
        List<Object> values = new ArrayList<>();

        for (String substring : substrings) {
            if (substring.contains("\"") || substring.contains("'")) {
                values.add(substring.split("[\"']")[1]);
            } else {
                values.add(Integer.valueOf(substring.strip()));
            }
        }

        return values;
    }

    public static void exit() throws IOException {
        System.out.print("\nPress any key to exit...");
        System.in.read();
    }

    public static void main(String[] args) throws IOException {
        List<Object> array = getArrayFromInputStream();
        System.out.println("Result array: " + getIntegersFromList(array));

        exit();
    }
}
