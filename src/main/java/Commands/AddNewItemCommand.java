package Commands;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Created by amdmax on 26/01/2018.
 */
public class AddNewItemCommand extends Command {
    private final String baseUrl;

    public AddNewItemCommand(String baseUrl){
        this.baseUrl = baseUrl;
    }

    public void execute() {
        System.out.println("Enter a string to add to the search engine");
        String next = getScanner().next();

        try {
            String body = "{\"input\":\"" + next + "\"}";
            HttpResponse<JsonNode> jsonNodeHttpResponse = Unirest.put(baseUrl + "search")
                    .header("Content-Type", "application/json")
                    .body(body)
                    .asJson();
            if(jsonNodeHttpResponse.getStatus() == 204){
                System.out.println("Added successfully");
            }else {
                System.out.print("Failed to add the document");
            }
        } catch (UnirestException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
