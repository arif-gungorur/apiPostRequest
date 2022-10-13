import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class API_PostRequest extends BaseUrl {
    @Test
    public void postRequest(){
        spec.pathParam("first","todos");

        Pojo expectedData=new Pojo(21,201,"Tidy your room",false);

        Response response=given().
                contentType(ContentType.JSON).
                spec(spec).
                body(expectedData).
                when().
                post("{first}");

        //response.prettyPrint();

        Pojo actualData=response.as(Pojo.class);

        assertEquals(201,response.getStatusCode());

        assertEquals(expectedData.getId(),actualData.getId());
        assertEquals(expectedData.getUserId(),actualData.getUserId());
        assertEquals(expectedData.getTitle(),actualData.getTitle());
        assertEquals(expectedData.isCompleted(),actualData.isCompleted());


    }
}
