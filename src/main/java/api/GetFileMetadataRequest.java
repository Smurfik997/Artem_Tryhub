package api;

import rest.RequestAPImethod;
import rest.RequestBody;
import rest.DataType;

import java.util.HashMap;
import java.util.Map;

public class GetFileMetadataRequest extends BaseRequest {
    public GetFileMetadataRequest(String filepath, String url) {
        super(url);
        Map<String, String> jsonObj = new HashMap<>();
        jsonObj.put("file", filepath);
        builder.setBody(new RequestBody(DataType.JSON, jsonObj));
        builder.setMethod(new RequestAPImethod(this.url, rest.RequestType.POST));
        request = builder.build();
    }
}
