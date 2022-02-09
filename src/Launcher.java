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

            if (s.equals("fibo"))
            {
                System.out.print("Fibo of : ");
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
            }

            else
            {
                System.out.println("Unknown command");
            }
        }

        scanner.close();
    }
}
