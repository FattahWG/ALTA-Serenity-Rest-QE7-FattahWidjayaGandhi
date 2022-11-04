package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import io.restassured.module.jsv.JsonSchemaValidator;
import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class ReqresRegister {
    @Steps
    ReqresAPI reqresAPI;

    //Tugas Register with invalid user
    @Given("post regist invalid user with valid json")
    public void postRegistInvalidUserWithValidJson() {
        File json = new File(ReqresAPI.JSON_REG_BODY + "/RegisterUserUnsucces.json");
        reqresAPI.RegisterInvalidUser(json);
    }
    @When("send post regist invalid user request")
    public void sendPostRegistInvalidUserRequest() { SerenityRest.when().post(ReqresAPI.REGISTER_USER);
    }
    @And("Response body page should be error {string}")
    public void responseBodyPageShouldBeError(String error) {
        SerenityRest.then().body(ReqresResponses.ERROR, equalTo(error));
    }
    @And("Validate register invalid user with json schema")
    public void validateRegisterInvalidUserWithJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA + "/RegisterInvalidUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
