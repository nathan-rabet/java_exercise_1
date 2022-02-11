import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Predict implements Command {

    @Override
    public String name() {
        return "predict";
    }

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

        String[] words = ss.replaceAll("[.,;_\n:!\"'-]", " ").toLowerCase().split(" ", -1);

        HashMap<String, String> frequencyMap = new HashMap<String, String>();

        for (int i = 0; i < words.length - 1; i++) {

            if (!frequencyMap.containsKey(words[i])) {
                HashMap<String, Integer> wordMap = new HashMap<String, Integer>();

                for (int j = 0; j < words.length - 1; j++) {
                    if (words[j].equals(words[i])) {
                        wordMap.put(words[j + 1], wordMap.getOrDefault(words[j + 1], 0) + 1);
                    }
                }

                frequencyMap.put(words[i], wordMap.entrySet().stream()
                        .max(Comparator
                                .comparing(es -> es
                                        .getValue()))
                        .get().getKey());

            }
        }

        System.out.print("Entrez un mot : ");
        String word = scanner.nextLine().toLowerCase();

        if (!frequencyMap.containsKey(word)) {
            System.out.println("Le mot rentré n'existe pas dans le texte analysé...");
        }

        else {
            for (int i = 0; i < 20; i++) {
                // Find word O(n)

                if (i != 19) {
                    System.out.printf("%s ", word);
                }

                else {
                    System.out.printf("%s\n", word);
                }

                word = frequencyMap.get(word);
            }
        }

        return false;
    }

}
