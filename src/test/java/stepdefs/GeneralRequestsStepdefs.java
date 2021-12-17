package stepdefs;

import api.APIrequest;
import api.Authentication;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import responses.ResponseHandler;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GeneralRequestsStepdefs {
    public Response response;
    public static Map<String, String> params;

    @Given("I am authorized dropbox user")
    public void iAmAuthorizedDropboxUser() {
        assertEquals(
                200,
                new Authentication("https://api.dropboxapi.com/2/check/user").sendRequest().statusCode()
        );
    }

    @When("I send POST request to {string}")
    public void iSendPostRequest(String url) {
        response = new APIrequest(url, params).send();
    }

    @Then("I will get response with status code {string}, which contains {string}")
    public void iWillGetResponseWithStatusCodeWhichContains(String code, String response_type) {
        assertTrue(ResponseHandler.check(response, code, response_type));
    }
}
