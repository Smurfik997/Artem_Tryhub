import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Task5 {
    public static String meeting(String str) {
        str = str.toUpperCase();
        List<String[]> persons = new ArrayList<>();

        for (String person : str.split(";")) {
            persons.add(person.split(":"));
        }

        // sort by name
        persons.sort(Comparator.comparing(person -> person[0]));

        // sort by lastname
        persons.sort(Comparator.comparing(person -> person[1]));

        // formatting result string
        String result = persons.stream()
                .map(person -> "(" + person[1] + ", " + person[0] + ")")
                .reduce((el1, el2) -> el1 + el2).orElse("")
                .toString();

        return result;
    }

    public static void exit() throws IOException {
        System.out.print("\nPress any key to exit...");
        System.in.read();
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Write string like next example");
        System.out.println("Fired:Corwill;Wilfred:Corwill;Barney:TornBull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill");
        System.out.print("Your input: ");
        String input = new Scanner(System.in).nextLine();
        System.out.println("Result is " + meeting(input));

        exit();
    }
}
