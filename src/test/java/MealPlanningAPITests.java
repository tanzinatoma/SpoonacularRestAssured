import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

public class MealPlanningAPITests extends Base {
    MealPlanningAPITests() throws IOException {

    }
    //@Test
    public void testGenerateMealPlan() {
        res = given()
                .queryParam("diet", "vegan")
                .queryParam("exclude", "shellfish, olives")
                .queryParam("targetCalories", 1500)
                .queryParam("timeFrame", "week")
                .queryParam("apiKey", props.getProperty("apiKey"))
                .when()
                .get(props.getProperty("url")+"/mealplanner/generate");
        res.then()
                .statusCode(200)
                .body("week.size()", greaterThan(0))
                .body("week.monday.meals.size()", greaterThan(0));
        print_response(name());
    }

    @Test
    public void addMealPlanTemplate(){
        res = given()
                .header("Content-Type", "application/json")
                .queryParam("apiKey", props.getProperty("apiKey"))
                .queryParam("hash", props.getProperty("hash"))
                .body(requestBody)
                .post(props.getProperty("url")+"/mealplanner/"+props.getProperty("username")+"/templates");

        res.then().statusCode(200);
        print_response(name());
    }

}
