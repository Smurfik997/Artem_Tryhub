package responses;

import io.restassured.response.Response;
import responses.types.Error;
import responses.types.FileMetadata;

import java.util.Arrays;
import java.util.List;

public class ResponseHandler {
    public static boolean check(Response response, String expectedCode, String expectedType) {
        List<Integer> statusCodes = Arrays.stream(expectedCode.split("or"))
                .map(strCode -> {
                    strCode = strCode.trim();
                    try {
                        return Integer.valueOf(strCode.substring(0, 3));
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Invalid expected status code");
                    }
                }).toList();

        if (!statusCodes.contains(response.statusCode())) {
            return false;
        }

        switch (expectedType) {
            case "FileMetadata":
                if (FileMetadata.is(response.asString())) {
                    return true;
                }
                break;
            case "Error":
                if (Error.is(response.asString())) {
                    return true;
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid expected response data type");
        }

        return false;
    }
}
