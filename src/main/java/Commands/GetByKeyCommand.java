package Commands;

/**
 * Created by amdmax on 26/01/2018.
 */
public class GetByKeyCommand extends Command {
    private final String baseUrl;

    public GetByKeyCommand(String baseUrl){

        this.baseUrl = baseUrl;
    }

    public void execute() {
        System.out.println("Enter Key");
        String key = getScanner().next();
        String url = baseUrl + "search/" + key;
        requestSearchResultsWithMessage(url);
    }

}
