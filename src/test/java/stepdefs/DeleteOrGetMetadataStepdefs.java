package stepdefs;

import api.APIrequest;
import io.cucumber.java.en.And;

import java.util.HashMap;

import static org.junit.Assert.assertFalse;

public class DeleteOrGetMetadataStepdefs {
    @And("I want to (get metadata of)/delete file by existing path/filepath {string}")
    public void iWantToGetMetadataByFilepath(String filepath) {
        GeneralRequestsStepdefs.params = new HashMap<>();
        GeneralRequestsStepdefs.params.put("filepath", filepath);
    }

    @And("I want to (get metadata of)/delete file by invalid path/filepath {string}")
    public void iWantToGetMetadataByInvalidFilepath(String filepath) {
        assertFalse(APIrequest.isValidFilepath(filepath));
        GeneralRequestsStepdefs.params = new HashMap<>();
        GeneralRequestsStepdefs.params.put("filepath", filepath);
    }
}
