import java.util.Scanner;

/**
 * Quit
 */
public class Quit implements Command {

    public Quit() {
    }

    @Override
    public String name() {
        return "quit";
    }

    @Override
    public boolean run(Scanner scanner) {
        return true;
    }

}
