import java.util.Scanner;
import java.io.IOException;
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

public class Freq implements Command {

    public Freq() {
    }

    @Override
    public String name() {
        return "freq";
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean run(Scanner scanner) {
        System.out.print("Entrez un chemin : ");
        String pathString = scanner.nextLine();

        String ss;
        try {
            Path path = Paths.get(pathString);
            ss = Files.readString(path);
        } catch (IOException e) {
            System.out.format("Unreadable file: '%s':%s", e.getClass().toString(), e.getMessage());
            return false;
        }

        ss = ss.replaceAll("[ .,;_\n-]", " ").toLowerCase();

        if (!ss.isBlank()) {
            ArrayList<String> arr = new ArrayList<String>();

            for (String w : ss.split(" ")) {
                arr.add(w);
            }

            List<Object> arr2 = Arrays.asList(arr.stream()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet()
                    .stream()
                    .sorted(Comparator.comparing(m -> ((Map.Entry<String, Long>) m).getValue()).reversed()
                            .thenComparing(m -> ((Map.Entry<String, Long>) m).getKey()))
                    .limit(3).map(m -> m.getKey()).toArray());

            for (var word : arr2) {
                System.out.printf("%s ", word);
            }
        }
        return false;
    }

}
