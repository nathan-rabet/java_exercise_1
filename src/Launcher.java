import java.util.Arrays;
import java.util.List;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Yas");

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        List<Command> commands = Arrays.asList(
                new Fibo(),
                new Freq(),
                new Predict(),
                new Quit());

        boolean mustContinue = true;
        while (mustContinue) {
            String s = scanner.nextLine();

            boolean foundOne = false;
            for (Command command : commands) {
                if (command.name().equals(s)) {
                    foundOne = true;
                    mustContinue = !command.run(scanner);
                }
            }

            if (!foundOne) {
                System.out.println("Unknown command");
            }
        }

        scanner.close();
    }
}
