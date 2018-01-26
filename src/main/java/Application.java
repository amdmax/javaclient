import Commands.*;
import Commands.Exceptions.ApplicationExitException;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by amdmax on 25/01/2018.
 */
public class Application {
    private static final String baseUrl = "http://localhost:8080/";

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in).useDelimiter("\\n");

        while(true) {
            printMenu();
            try {
                int choice = scanner.nextInt();
                Command command = getUserCommand(choice);
                command.execute();
            } catch (InputMismatchException e){
                System.out.println("Sorry I didn't get that. Please try again.");
                continue;
            } catch (ApplicationExitException e){
                System.out.println("Sorry to see you go. Come again soon.");
                return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Choose one of the following options:");
        System.out.println("1. Get item by key");
        System.out.println("2. Search all items by tokens");
        System.out.println("3. Create a new document that will be parsed and split into tokens");
        System.out.println("4. Exit");
    }

    private static Command getUserCommand(int choice) {
        switch (choice) {
            case 1:
                return new GetByKeyCommand(baseUrl);
            case 2:
                return new SearchByTokensCommand(baseUrl);
            case 3:
                return new AddNewItemCommand(baseUrl);
            case 4:
                return new TerminationCommand();
            default:
                return new UnknownBehaviorCommand();
        }
    }
}
