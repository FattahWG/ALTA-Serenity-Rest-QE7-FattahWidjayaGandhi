package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import io.restassured.module.jsv.JsonSchemaValidator;
import java.io.File;
import static org.hamcrest.Matchers.equalTo;
public class listUserReqres {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Get single user with parameter user {int}")
    public void getSingleUserWithParameterUserId(int id) {
        reqresAPI.getSingleUsers(id);
    }
    @When("Send get single user request")
    public void sendGetSingleUserRequest() {
        SerenityRest.when().get(ReqresAPI.SINGLE_USER);
    }
    @And("Response body page be null")
    public void responseBodyPageBeNull() {
        SerenityRest.then().body(ReqresResponses.NOT_FOUND,equalTo(null));
    }
    @And("Valid get single user with invalid user schema")
    public void validGetSingleUserWithInvalidUserSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/GetSingleUserNotFound.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

}
