import java.util.Scanner;

public class Fibo implements Command {

    public Fibo() {
    }

    @Override
    public String name() {
        return "fibo";
    }

    @Override
    public boolean run(Scanner scanner) {
        System.out.print("Fibo of ? : ");
        int n = scanner.nextInt();

        int i0 = 0;
        int i1 = 1;

        for (int i = 1; i < n; i++) {
            int tmp = i0 + i1;
            i0 = i1;
            i1 = tmp;
        }

        System.out.println(i1);
        scanner.nextLine();
        return false;
    }

}
