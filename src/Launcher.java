public class Launcher {
    public static void main(String[] args) {
        System.out.println("Yas");

        java.util.Scanner scanner = new java.util.Scanner(System.in) ;
        String s = scanner.nextLine();

        if (!s.equals("quit"))
        {
            System.out.println("Unknown command");
        }
        scanner.close();
    }
}
