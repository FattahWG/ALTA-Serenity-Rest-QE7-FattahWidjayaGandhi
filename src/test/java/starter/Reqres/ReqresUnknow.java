package starter.Reqres;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import io.restassured.module.jsv.JsonSchemaValidator;

import static org.hamcrest.Matchers.equalTo;


public class ReqresUnknow {
    @Steps
    ReqresAPI reqresAPI;

        @Given("Get unknow list page {int}")
        public void getUnknowListWithValidJson(int page) {
            reqresAPI.setGetUnkow(page);
        }
        @When("Send get unkow list request")
        public void sendGetUnkowListRequest() {
            SerenityRest.when().get(ReqresAPI.UNKNOW_LIST);
        }
        @And("Response body page should be page {int}")
        public void responseBodyPageShouldBeIdIdAndNameName(int page) {
            SerenityRest.then().body(ReqresResponses.PAGE, equalTo(page));
        }

    @Given("get unknow page {int}")
    public void getUnknowPage(int page) { reqresAPI.getUnkowPage(page);
    }
    @When("Send get unknow single list")
    public void sendGetUnkowRequest() {SerenityRest.when().get(ReqresAPI.UNKNOW_PAGE);
    }
    @And("Response body page should be id {int} and name {string}")
    public void ResponId(int id, String name) {
            SerenityRest.then().body(ReqresResponses.DATA_ID, equalTo(id))
                    .body(ReqresResponses.DATA_NAME, equalTo(name));
    }
}
