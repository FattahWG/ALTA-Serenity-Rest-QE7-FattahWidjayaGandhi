package starter.Reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class ReqresAPI {
    public static final String URL = "https://reqres.in";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_REG_BODY = DIR + "/src/test/resources/JSON/Requestbody";
    public static final String JSON_SCHEMA = DIR+"/src/test/resources/JSON/JsonSchema";
    public static String GET_LIST_USER = URL + "/api/users?page={page}";
    public static String POST_CREATE_NEW_USER = URL + "/api/users";
    public static String PUT_UPDATE_USER = URL + "/api/users/{id}";
    public static String DELETE_USER = URL + "/api/user/{id}";
    public static String LOGIN_USER = URL + "/api/login";
    public static String REGISTER_USER = URL + "/api/register";

    @Step("Get list users")
    public void setGetListUser(int page){
        SerenityRest.given().pathParam("page", page);
    }
    @Step("Post create new user")
    public void setPostCreateNewUser(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
    @Step("Put update user")
    public void setPutUpdateUser(int id, File json){
        SerenityRest.given().pathParam("id", id).contentType(ContentType.JSON).body(json);
    }
    @Step("Delete User")
    public void deleteUser(int id){
        SerenityRest.given().pathParam("id", id);
    }

    //Tugas
    @Step("Login user with valid id")
    public void loginUser(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
    @Step("Login invalid user")
    public void loginInvalidUser(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
    @Step("Register valid user")
    public void RegisterValidUser(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
    @Step("Register invalid user")
    public void RegisterInvalidUser(File json){SerenityRest.given().contentType(ContentType.JSON).body(json);}
}
