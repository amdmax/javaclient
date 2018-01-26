package Commands;

import Commands.Exceptions.ApplicationExitException;

/**
 * Created by amdmax on 26/01/2018.
 */
public class TerminationCommand extends Command{

    public void execute() {
        throw new ApplicationExitException();
    }
}
