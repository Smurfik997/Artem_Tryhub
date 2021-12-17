package api;

import rest.RequestAPImethod;

public class Authentication extends BaseRequest {
    public Authentication(String url) {
        super(url);
        builder.setMethod(new RequestAPImethod(this.url, rest.RequestType.POST));
        request = builder.build();
    }
}
