package api;

import io.restassured.response.Response;

import java.util.Map;

public class APIrequest {
    BaseRequest request;

    public APIrequest(String url, Map<String, String> params) {
        if (url.matches("^.*/upload$")) {
            request = new UploadRequest(
                    "src/test/resources" + params.get("filename"), params.get("dropbox_path"), url
            );
        } else if (url.matches("^.*/get_file_metadata$")) {
            request = new GetFileMetadataRequest(params.get("filepath"), url);
        } else if (url.matches("^.*/delete_v2$")) {
            request = new DeleteRequest(params.get("filepath"), url);
        } else {
            throw new IllegalArgumentException("Invalid request url");
        }
    }

    public Response send() {
        return request.sendRequest();
    }

    public static boolean isValidFilepath(String path) {
        if (!path.matches("(/(.|[\r\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)")) {
            return false;
        }

        if (path.contains("//")) {
            return false;
        }

        return true;
    }
}
