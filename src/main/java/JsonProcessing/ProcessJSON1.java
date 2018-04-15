package JsonProcessing;

import com.sun.org.apache.xml.internal.serializer.utils.Utils;
import org.json.JSONObject;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ProcessJSON1 {
    //public static String jsonObjectFile ="E:\\Training\\JsonProcessing\\src\\main\\java\\JsonProcessing\\jsonData.json\\";
    public static String jsonObjectFile ="src/main/java/JsonProcessing/jsonData.json";

    public static void main(String args[]) throws Exception{
        ProcessJSON1 processJSON1 = new ProcessJSON1();
        //ONE
        /*ProcessJSON1 processJSON1 = new ProcessJSON1();
        JsonObject object = processJSON1.loadJsonData();
        System.out.println(object);*/

        //TWO
        JsonObject jsonObjectBuilder = processJSON1.buildJsonObject();
        System.out.println(jsonObjectBuilder);
    }

    public JsonObject loadJsonData () throws FileNotFoundException {
        JsonReader jsonReader = Json.createReader(new FileReader(jsonObjectFile));
        JsonObject jsonObject = jsonReader.readObject();
        return jsonObject;
    }

    public JsonObject buildJsonObject(){
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("name", "praveen")
                .add("profession", "Software Developer")
                .add("hobbies", Json.createArrayBuilder().add("cricket")
                                                            .add("programmer")
                                                            .add("traveller").build())
                .add("place", "noida")
                .add("age", 25)
                .build();
        return jsonObject;
    }
}
