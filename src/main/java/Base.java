import io.restassured.response.Response;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

class Base {
    public Response res;
    public FileReader reader;
    public Properties props;
    Base() throws IOException {
        reader = new FileReader("src/main/resources/TestData.properties");
        props = new Properties();
        props.load(reader);
    }
    public String name(){
        return Thread.currentThread().getStackTrace()[3].getMethodName();
    }
    public void print_response(String name_got) {
        System.out.println( name_got + "----\n" + res.getBody().asString());
    }
}