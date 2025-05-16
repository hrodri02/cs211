import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AuthorsMap {
    private Map<String, List<Author>> map;

    public AuthorsMap() {
        this.map = Collections.synchronizedMap(new HashMap<>());
    }

    public void addAuthor(Author author) {
        synchronized (map) {
            String authorName = author.getName();
            if (!map.containsKey(authorName)) {
                String firstLetter = authorName.substring(0, 1);
                map.putIfAbsent(firstLetter, new ArrayList<>());
                List<Author> authorsForLetter = map.get(firstLetter);
                authorsForLetter.add(author);
            }
        }    
    }

    public void print() {
        for (String name : map.keySet()) {
            System.out.println(name + ": " + map.get(name));
        }
    }

    public int size() {
        int total = 0;
        for (String name : map.keySet()) {
            total += map.get(name).size();
        }
        return total;
    }
}
