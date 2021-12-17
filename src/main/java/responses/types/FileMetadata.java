package responses.types;

import io.restassured.path.json.JsonPath;

public class FileMetadata {
    public static boolean is(String metadata) {
        JsonPath json = new JsonPath(metadata);
        if (json.getString("metadata") != null) {
            json.setRootPath("metadata");
        }
        return (json.getString("name") != null && json.getString("id") != null);
    }
}
