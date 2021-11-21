import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Task4 {
    public static int pairs_for_target_sum(List<Integer> numbers, int targetValue) {
        int totalPairsCount = 0;

        for (int i = 0; i < numbers.size() - 1; i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(i) + numbers.get(j) == targetValue) {
                    totalPairsCount += 1;
                }
            }
        }

        return totalPairsCount;
    }

    public static int pairs_for_target_sum_stream(List<Integer> numbers, int targetValue) {
        int totalPairsCount;

        totalPairsCount = numbers.stream()
                .map(number -> {
                    int pairs = (int) numbers.stream()
                            .filter(element -> targetValue - element == number).count();

                    if (targetValue - number == number) {
                        pairs -= 1;
                    }

                    return pairs;
                }).reduce(Integer::sum).orElse(0) / 2;

        return totalPairsCount;
    }

    public static List<Integer> getArrayFromInputStream() {
        System.out.println("Input integer array like examples:");
        System.out.println("[1, 3, 6, 2, 2, 0, 4, 5]");
        System.out.println("[1, 2, 1, 2, 0, 15]");
        System.out.print("Your array: ");
        String input = new Scanner(System.in).nextLine();

        return Arrays.stream(input.substring(1, input.length() - 1).split(","))
                .map(number -> Integer.valueOf(number.strip())).collect(Collectors.toList());
    }

    public static void exit() throws IOException {
        System.out.print("\nPress any key to exit...");
        System.in.read();
    }

    public static void main(String[] args) throws IOException {
        List<Integer> array = getArrayFromInputStream();
        System.out.print("Input target pair sum value: ");
        int target = new Scanner(System.in).nextInt();
        System.out.print("Use stream realization method or \"for\" (y/n): ");

        if (new Scanner(System.in).nextLine().compareTo("y") == 0) {
            System.out.println("Result pairs amount is: " + pairs_for_target_sum_stream(array, target));
        } else {
            System.out.println("Result pairs amount is: " + pairs_for_target_sum(array, target));
        }

        exit();
    }
}
