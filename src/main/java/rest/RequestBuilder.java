package rest;

import io.restassured.http.Header;
import io.restassured.http.Headers;

import java.util.ArrayList;
import java.util.List;

public class RequestBuilder {
    private List<Header> headers = new ArrayList<>();
    private RequestBody requestBody;
    private RequestAPImethod method;

    public void addHeader(Header header) {
        headers.add(header);
    }

    public void setBody(RequestBody requestBody) {
        this.requestBody = requestBody;
    }

    public void setMethod(RequestAPImethod method) {
        this.method = method;
    }

    public Request build() {
        return new Request(new Headers(headers), requestBody, method);
    }
}
