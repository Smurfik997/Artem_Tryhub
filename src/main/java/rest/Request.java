package rest;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.util.HashMap;

import static io.restassured.config.EncoderConfig.encoderConfig;

public class Request {
    private final Headers headers;
    private final RequestBody requestBody;
    private final RequestType methodType;
    private final String methodName;
    private final RequestSpecification request;

    public Request(Headers headers, RequestBody requestBody, RequestAPImethod method) {
        this.headers = headers;
        if (requestBody == null) {
            requestBody = new RequestBody(DataType.JSON, new HashMap<>());
        }
        this.requestBody = requestBody;
        this.methodType = method.getType();
        this.methodName = method.getPath();

        RestAssured.config = RestAssured
                .config()
                .encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false));
        this.request = RestAssured
                .given()
                .baseUri(method.getURL())
                .basePath(method.getPath())
                .headers(headers)
                .contentType(requestBody.getType().asString());

        if (requestBody.getType() == DataType.FILE) {
            request.body((File) requestBody.getObject());
        } else if (requestBody.getType() == DataType.JSON) {
            request.body(requestBody.getObject());
        } else {
            throw new IllegalArgumentException("Invalid request body data type");
        }
    }

    public Response send() {
        Response response;

        if (methodType == RequestType.POST) {
            response = request.post();
        } else if (methodType == RequestType.GET) {
            response = request.get();
        } else {
            throw new IllegalArgumentException("Invalid request method type");
        }

        return response;
    }
}
