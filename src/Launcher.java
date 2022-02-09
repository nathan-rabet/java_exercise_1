public class Launcher {
    public static void main(String[] args) {
        System.out.println("Yas");

        java.util.Scanner scanner = new java.util.Scanner(System.in) ;
        
        while (true)
        {
            String s = scanner.nextLine();

            if (s.equals("quit"))
            {
                break;
            }
            System.out.println("Unknown command");
        }

        scanner.close();
    }
}
