package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import static org.hamcrest.Matchers.equalTo;
import starter.postcodes.PostCodeAPI;

import java.io.File;

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
    public void responseBody(int page){
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

    @Given("Put update user with valid json with {int}")
    public void putUpdateUserWithValidJson(int id) {
        File json = new File(ReqresAPI.JSON_REG_BODY+"/UpdateUser.json");
        reqresAPI.setPutUpdateUser(id,json);

    }
    @When("Send put update user")
    public void sendPutUpdateUser() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }

    //Scenario 4
    @Given("Delete user with id {int}")
    public void deleteUserWithId(int id){
        reqresAPI.deleteUser(id);
    }
    @When("Send delete user request")
    public void sendDeleteUserRequest(){
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
    }
    @Then("Status code should be {int} No Content")
    public void StatusCodeShouldBeNoContent(int noContent){
        SerenityRest.then().statusCode(noContent);
    }
}
