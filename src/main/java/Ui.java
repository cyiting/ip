import java.util.Scanner;

public class Ui {
    private static final String GREETINGS_MESSAGE = "Hello! I'm Duke\nWhat can I do for you?";
    private static final String GOODBYE_MESSAGE = "Bye. Hope to see you soon!";

    boolean acceptCommand(TaskList tasks) throws DukeException {
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        if (command.equals("bye")) {
            return true;
        }
        String printable = Parser.processCommand(command, tasks);
        System.out.println(display(printable));
        return false;
    }

    void showGreetingsMessage() {
        System.out.println(display(GREETINGS_MESSAGE));
    }

    void showGoodbyeMessage() {
        System.out.println(display(GOODBYE_MESSAGE));
    }

    void showLoadingError() {
        System.out.println(display("Error loading saving"));
    }

    void showSavingError() {
        System.out.println(display("Error saving tasks"));
    }

    void showErrorMessage(Exception e) {
        System.out.println(display(e.getMessage()));
    }

    String display(String message) {
        String horizontalLine = "\t______________________________________\n";
        String[] responseArr = message.split("\\r?\\n");
        StringBuilder responseFinal = new StringBuilder();
        for (String r: responseArr) {
            responseFinal.append("\t").append(r).append("\n");
        }
        return String.format("%s%s%s", horizontalLine, responseFinal, horizontalLine);
    }
}
