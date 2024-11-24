import com.github.javafaker.Faker;
import io.restassured.response.Response;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

class Base {
    public Response res;
    public FileReader reader;
    public Properties props;
    String filePath = "src/main/resources/mealplan.json";
    String requestBody = new String(Files.readAllBytes(Paths.get(filePath)));

    Base() throws IOException {
        reader = new FileReader("src/main/resources/TestData.properties");
        props = new Properties();
        props.load(reader);
    }
    public String name(){
        return Thread.currentThread().getStackTrace()[3].getMethodName();
    }
    public void print_response(String name) {
        System.out.println( "Response of method " + name + " of "+ getClass() +" ----\n" + res.getBody().asString());
    }
}