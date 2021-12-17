package api;

import io.restassured.http.Header;
import io.restassured.response.Response;
import rest.Request;
import rest.RequestBuilder;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class BaseRequest {
    protected RequestBuilder builder;
    protected Request request;
    protected URL url;

    public BaseRequest(String url) {
        try {
            this.url = new URL(url);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid request url");
        }
        builder = new RequestBuilder();
        builder.addHeader(new Header("Authorization", "Bearer " + Configurations.ACCESS_TOKEN));
        builder.addHeader(new Header("Host", this.url.getHost()));
    }

    public Response sendRequest() {
        return request.send();
    }
}
