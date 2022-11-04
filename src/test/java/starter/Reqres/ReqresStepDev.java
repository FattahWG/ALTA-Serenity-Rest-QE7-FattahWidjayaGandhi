package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import io.restassured.module.jsv.JsonSchemaValidator;
import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class ReqresStepDev {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Get list user with parameters page {int}")
    public void getListUserWithParameters(int page) {
        reqresAPI.setGetListUser(page);
    }
    @When("Send Get list user request")
    public void sendGetListUserRequest() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USER);
    }
    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }
    @And("Response body page should be {int}")
    public void responseBody(int page) {
        SerenityRest.then().body(ReqresResponses.PAGE, equalTo(page));
    }

    //Scenario 2
    @Given("Post create user with valid json")
    public void postCreateUserWithValidJson() {
        File json = new File(ReqresAPI.JSON_REG_BODY + "/CreateUser.json");
        reqresAPI.setPostCreateNewUser(json);
    }
    @When("Send post create user request")
    public void sendPostCreateUserRequest() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_NEW_USER);
    }
    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int Created) {
        SerenityRest.then().statusCode(Created);
    }
    @And("Response body should contain name {string} and job {string}")
    public void responseBodyShouldContainNameAndJob(String name, String job) {
        SerenityRest.then()
                .body(ReqresResponses.NAME, equalTo(name))
                .body(ReqresResponses.JOB, equalTo(job));
    }

    //Scenario 3
    @Given("Put update user with valid json with {int}")
    public void putUpdateUserWithValidJson(int id) {
        File json = new File(ReqresAPI.JSON_REG_BODY + "/UpdateUser.json");
        reqresAPI.setPutUpdateUser(id, json);
    }
    @When("Send put update user")
    public void sendPutUpdateUser() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }

    //Scenario 4
    @Given("Delete user with id {int}")
    public void deleteUserWithId(int id) {
        reqresAPI.deleteUser(id);
    }
    @When("Send delete user request")
    public void sendDeleteUserRequest() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
    }
    @Then("Status code should be {int} No Content")
    public void StatusCodeShouldBeNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }

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

    //Tugas Login with Invalid User
    @Given("post regist valid user with valid json")
    public void postRegistValidUserWithValidJson() {
        File json = new File(reqresAPI.JSON_REG_BODY + "/RegisterUserSucces.json");
        reqresAPI.RegisterValidUser(json);
    }
    @When("send post regist valid user request")
    public void sendPostRegistValidUserRequest() {
        SerenityRest.when().post(ReqresAPI.REGISTER_USER);
    }
    @And("Response body page should be id {int} and token {string}")
    public void responseBodyPageShouldBeIdAndToken(int id, String token) {
        SerenityRest.then().body(ReqresResponses.ID, equalTo(id))
                            .body(ReqresResponses.TOKEN, equalTo(token));
    }
    @And("Validate register user with json shcema")
    public void ValidateRegisUser(){
        File json = new File(ReqresAPI.JSON_SCHEMA + "/RegisterValidUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

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
