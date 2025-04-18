import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPractice {
    public static void main(String[] args) {
        String[] words = {"apple", "banana", "cherry", "date", "elderberry"};
        
        // Note: intermediate oparations are lazy and won't execute 
        // until a terminal operation uses a value from the stream
        Stream.of(words)
            .map(s -> {
                System.out.println("Mapping: " + s);
                return s.toUpperCase();
            })
            .forEach(s -> {
                System.out.println("Processing: " + s);
            });
        
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i <= 100; i++) {
            Random random = new Random();
            int randomNumber = random.nextInt(10000);
            numbers.add(randomNumber);
        }

        Stream<Integer> numberStream = numbers.stream();
        int min = numberStream.min(Integer::compare).get();
        System.out.println("Minimum number: " + min);

        try {
            List<String> lines = Files.readAllLines(Paths.get("random_words.txt"), Charset.forName("ISO-8859-1"));
            Stream<String> wordStream = lines.stream();
            String word = wordStream.max( (word1, word2) -> {
                    int word1Zcount = countChars(word1, 'z');
                    int word2Zcount = countChars(word2, 'z');
                    return Integer.compare(word1Zcount, word2Zcount);
                }
            ).get();
            System.out.println("Word with most 'z's: " + word);

            String qNoUWord = lines.stream()
                .filter(s -> s.toLowerCase().contains("q") && !s.toLowerCase().contains("u"))
                .findAny()
                .get();
            System.out.println("Word with 'q' but no 'u': " + qNoUWord);

            List<String> qNoUWords = lines.stream()
                .filter(s -> s.toLowerCase().contains("q") && !s.toLowerCase().contains("u"))
                .collect(Collectors.toList());
            System.out.println("Words with 'q' but no 'u': " + qNoUWords);

            Map<String, Integer> qNoUMap = lines.stream()
                .filter(s -> s.toLowerCase().contains("q") && !s.toLowerCase().contains("u"))
                .collect(Collectors.toMap(Function.identity(), String::length));
            System.out.println("Map of words with 'q' but no 'u': " + qNoUMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int countChars(String word, char c) {
        int count = 0;
        for (char ch : word.toCharArray()) {
            if (ch == c) {
                count++;
            }
        }
        return count;
    }
}