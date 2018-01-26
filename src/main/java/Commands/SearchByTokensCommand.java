package Commands;

/**
 * Created by amdmax on 26/01/2018.
 */
public class SearchByTokensCommand extends Command {

    private final String baseUrl;

    public SearchByTokensCommand(String baseUrl){
        this.baseUrl = baseUrl;
    }

    public void execute() {
        System.out.println("Enter a coma delimited tokens string");

        String tokens = getScanner().next();
        String url = baseUrl + "search/all/" + tokens;
        requestSearchResultsWithMessage(url);
    }
}
