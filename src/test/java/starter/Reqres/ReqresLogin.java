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

public class ReqresLogin {
    @Steps
    ReqresAPI reqresAPI;

    //Tugas Login Succes
    @Given("Post login user with valid json")
    public void LoginUserSucces() {
        File json = new File(ReqresAPI.JSON_REG_BODY + "/login.json");
        reqresAPI.loginUser(json);
    }
    @When("Send post login user request")
    public void sendPostLoginUserRequest() {
        SerenityRest.when().post(ReqresAPI.LOGIN_USER);
    }
    @And("Response body should contain {string} as token")
    public void responBodyToken(String token){
        SerenityRest.then().body(ReqresResponses.TOKEN, equalTo(token));
    }
    @And("Validate login user with json shcema")
    public void ValidateLoginUser(){
        File json = new File(ReqresAPI.JSON_SCHEMA + "/LoginSuccesSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Tugas Login Unsucces
    @Given("Post login invalid user with valid json")
    public void postLoginInvalidUserWithValidJson() {
        File json = new File(ReqresAPI.JSON_REG_BODY + "/LoginInvalidUser.json");
        reqresAPI.loginInvalidUser(json);
    }
    @When("Send post login invalid user request")
    public void sendPostLoginInvalidUserRequest() {
        SerenityRest.when().post(ReqresAPI.LOGIN_USER);
    }
    @Then("Status code shold be {int} ERROR")
    public void statusCodeSholdBeERROR(int error) {
        SerenityRest.then().statusCode(error);
    }
    @And("Response body page should be contain {string}")
    public void responseBodyPageShouldBeContain(String error) {
        SerenityRest.then().body(ReqresResponses.ERROR, equalTo(error));
    }
    @And("Validate invalid login user with json shcema")
    public void ValidateInvalidLoginUser(){
        File json = new File(ReqresAPI.JSON_SCHEMA + "/LoginUnsuccesSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }


}
