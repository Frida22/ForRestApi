import dtoForRestApi.UsersDTO;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import org.apache.http.HttpStatus;

import java.util.Arrays;

import static io.restassured.RestAssured.given;


public class HomeWorkRestApiTest {
    private static final String BASE_URL = "http://5e1b2fdf31118200148f2523.mockapi.io/api/v1";
    private static final String USERS_URL = "/users";
    private static final String ID5 = "/users/5";


    @Test
    public void positiveGetAllUsersTest() {
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .build();
        ValidatableResponse response = given(requestSpecification)
                .when()
                .log().all()
                .get(USERS_URL)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void positiveGetOnIdTest() {
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .build();
        ValidatableResponse response = given(requestSpecification)
                .when()
                .get(ID5)
                .then()
                .statusCode(200);
    }

    @Test
    public void getAllUsersAndPrintTest() {
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .build();
        ValidatableResponse response = given(requestSpecification)
                .when()
                .get(USERS_URL)
                .then()
                .statusCode(200);

        UsersDTO[] actualResponse = response.extract().body().as(UsersDTO[].class);

        Arrays.asList(actualResponse).forEach(x -> { System.out.println(x.getFirstName());
            System.out.println(x.getLastName());
            System.out.println(x.getAge());
        });
    }

    @Test
    public void createAndPostUserTest() {

        UsersDTO usersDTO = new UsersDTO.UsersDTOBuilder().withId("78").withFirstName("Momomo").withLastName("Mimimi").withEmail("momo@m.mi").withAge(57).build();
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .build();

        ValidatableResponse response = (ValidatableResponse) given(requestSpecification)
                .contentType(ContentType.JSON)
                .body(usersDTO)
                .request("POST","/users")
                .then()
                .statusCode(201);
    }

    @Test
    public void updateUserOnIdTest() {
        UsersDTO usersDTO = new UsersDTO.UsersDTOBuilder().withId("78").withFirstName("Momomo").withLastName("Mimimi").withEmail("momo@m.mi").withAge(57).build();
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .build();

        ValidatableResponse response = given(requestSpecification)
                .contentType(ContentType.JSON)
                .body(usersDTO)
                .request("PUT","/users/6")
                .then()
                .statusCode(200);

    }
    @Test
    public void deleteUserTest(){
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .build();

        ValidatableResponse response = given(requestSpecification)
                .delete("/users/10")
                .then()
                .statusCode(200);

    }
}

