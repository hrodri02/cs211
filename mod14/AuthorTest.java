import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.ArrayList;
import java.util.HashSet;

public class AuthorTest {
    private static Random random = new Random();
    public static void main(String[] args) {
        // Thread code
        int numberOfThreads = 1000;
        int countDups = 0;
        Set<String> names = new HashSet<>();
		AuthorsMap map = new AuthorsMap();
		int ideThreadCount = Thread.activeCount();
		
		for(int i=0; i<numberOfThreads; i++) {
            String name = generateRandomName();
            if (!names.contains(name)) {
                Author author = new Author(name, new ArrayList<>());
                AuthorThread authorThread =  new AuthorThread(map, author);
			    Thread thread = new Thread(authorThread);
			    thread.start();
            }
            else {
                countDups += 1;
            }
            names.add(name);
		}
		while(Thread.activeCount()>ideThreadCount) {
			try {
				Thread.sleep(1000);
			} catch(InterruptedException ex) {}
		}
		
        System.out.println("There should be " + (numberOfThreads - countDups) + " authors on the map.");
		int mapSize = map.size();
		System.out.println("There are " + mapSize + " authors on the map.");
    }

    public static String generateRandomName() {
        // 97 - 122
        String name = "";
        for (int i = 0; i < 8; i++) {
            int num = 97 + random.nextInt(25) + 1;
            name += (char) num; 
        }
        return name;
    }
}
