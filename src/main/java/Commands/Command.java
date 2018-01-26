package Commands;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;

import java.util.Scanner;

public abstract class Command{
    public abstract void execute();

    protected static void requestSearchResultsWithMessage(String url) {
        try {
            HttpResponse<JsonNode> jsonNodeHttpResponse = Unirest.get(url).asJson();
            JSONArray items = jsonNodeHttpResponse.getBody().getObject().getJSONArray("items");
            if(items.length() == 0) {
                System.out.println("No items matching your request");
            }
            for (Object item : items) {
                System.out.println(item);
            }
        } catch (UnirestException ex) {
            System.out.println(ex.getMessage());
        }
    }

    protected Scanner getScanner(){
        return new Scanner(System.in).useDelimiter("\\n");
    }

}
