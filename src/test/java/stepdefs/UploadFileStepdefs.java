package stepdefs;

import api.APIrequest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.io.File;
import java.util.HashMap;

import static org.junit.Assert.assertFalse;

public class UploadFileStepdefs {
    @Given("I want upload {string} to folder {string} with name {string}")
    public void iWantUploadFileToFolder(String filename, String folder, String filename_dropbox) {
        GeneralRequestsStepdefs.params = new HashMap<>();
        GeneralRequestsStepdefs.params.put("filename", filename);
        GeneralRequestsStepdefs.params.put("dropbox_path", folder + "/" + filename_dropbox);
    }

    @And("some of upload request parameters is invalid")
    public void someOfUploadRequestParametersIsInvalid() {
        assertFalse(new File(GeneralRequestsStepdefs.params.get("filename")).exists());
        assertFalse(APIrequest.isValidFilepath(GeneralRequestsStepdefs.params.get("dropbox_path")));
    }
}
