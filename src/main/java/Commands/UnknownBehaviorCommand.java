package Commands;

/**
 * Created by amdmax on 26/01/2018.
 */
public class UnknownBehaviorCommand extends Command{

    public void execute() {
        System.out.println("Sorry I didn't get that. Please try again.");
    }
}
