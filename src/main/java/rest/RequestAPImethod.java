package rest;

import java.net.URL;

public class RequestAPImethod {
    private final URL url;
    private final RequestType type;

    public RequestAPImethod(URL url, RequestType type) {
        this.url = url;
        this.type = type;
    }

    public String getURL() {
        return url.getProtocol() + "://" + url.getHost();
    }

    public String getPath() {
        return url.getPath();
    }

    public RequestType getType() {
        return type;
    }
}