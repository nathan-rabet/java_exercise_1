import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Yas");

        java.util.Scanner scanner = new java.util.Scanner(System.in);

        while (true) {
            String s = scanner.nextLine();

            if (s.equals("quit")) {
                break;
            }

            else if (s.equals("freq")) {
                System.out.print("Entrez un chemin : ");
                String pathString = scanner.nextLine();

                String ss;
                try {
                    Path path = Paths.get(pathString);
                    ss = Files.readString(path);
                } catch (IOException e) {
                    System.out.format("Unreadable file: '%s':%s", e.getClass().toString(), e.getMessage());
                    continue;
                }

                ss = ss.replaceAll("[.,;-_\n]", " ").toLowerCase();

                if (!ss.isBlank()) {
                    ArrayList<String> arr = new ArrayList<String>();

                    for (String w : ss.split(" ")) {
                        arr.add(w);
                    }

                    List arr2 = Arrays.asList(arr.stream()
                            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                            .entrySet()
                            .stream()
                            .sorted(Comparator.comparing(m -> ((Map.Entry<String, Long>) m).getValue()).reversed()
                                    .thenComparing(m -> ((Map.Entry<String, Long>) m).getKey()))
                            .limit(3).map(m -> m.getKey()).toArray());

                    for (var word : arr2) {
                        System.out.println(word);
                    }
                }

            }

            else if (s.equals("fibo")) {
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

            else {
                System.out.println("Unknown command");
            }
        }

        scanner.close();
    }
}
