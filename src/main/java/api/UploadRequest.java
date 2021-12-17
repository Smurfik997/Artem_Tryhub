package api;

import io.restassured.http.Header;
import rest.RequestAPImethod;
import rest.RequestBody;

import java.io.File;

public class UploadRequest extends BaseRequest {
    public UploadRequest(String filename, String dropbox_path, String url) {
        super(url);
        builder.addHeader(new Header("Dropbox-API-Arg", "{\"path\":\"" + dropbox_path + "\"}"));
        builder.setBody(new RequestBody(rest.DataType.FILE, new File(filename)));
        builder.setMethod(new RequestAPImethod(this.url, rest.RequestType.POST));
        request = builder.build();
    }
}
