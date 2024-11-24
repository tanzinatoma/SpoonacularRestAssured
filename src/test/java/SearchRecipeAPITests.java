
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class SearchRecipeAPITests extends Base {

    SearchRecipeAPITests() throws IOException {
    }

    @Test
    public void testSearchRecipesByIngredient() {
        res = given()
                .queryParam("ingredients", "tomato,cheese")
                .queryParam("number", 2000)
                .queryParam("apiKey", props.getProperty("apiKey"))
                .when()
                .get(props.getProperty("url")+"/recipes/findByIngredients");
       res.then()
                .statusCode(200)
                .body("size()", greaterThan(0))
                .body("id", hasItem(645696))
                .body("missedIngredients.aisle.flatten()", hasItems("Produce", "Spices and Seasonings"));
       print_response(name());
    }
    @Test
    public void testSearchRecipesByCuisine() {
        res = given()
                .queryParam("cuisine", "Italian")
                .queryParam("number", 5)
                .queryParam("apiKey", props.getProperty("apiKey"))
                .when()
                .get(props.getProperty("url")+"/recipes/complexSearch");
        res.then()
                .statusCode(200)
                .body("results.title", hasItem("Salmon Quinoa Risotto"));
        print_response(name());
    }
    @Test
    public void testSearchRecipesByDietaryRestriction() {
        res  = given()
                .queryParam("diet", "vegan")
                .queryParam("number", 5)
                .queryParam("apiKey", props.getProperty("apiKey"))
                .when()
                .get(props.getProperty("url")+"/recipes/complexSearch");

        res.then()
                .statusCode(200)
                .body("results.title", hasItems("Garlicky Kale", "Red Kidney Bean Jambalaya"));
        print_response(name());
    }
    @Test
    public void testGetRecipeInformationById() {
        res = given()
                .queryParam("apiKey", props.getProperty("apiKey"))
                .pathParam("id", 42312)
                .when()
                .get(props.getProperty("url")+"/recipes/{id}/information");

        res.then()
                .statusCode(200)
                .body("title", not(empty()))
                .body("extendedIngredients.size()", greaterThan(0))
                .body("instructions", not(empty()));
        print_response(name());
    }
}
