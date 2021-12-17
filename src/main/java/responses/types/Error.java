package responses.types;

public class Error {
    public static boolean is(String message) {
        return (message.toLowerCase().contains("error"));
    }
}
