import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {
        File file = new File("test.csv");
        try (Scanner fileScanner = new Scanner(new FileReader(file));
            PrintWriter printWriter = new PrintWriter(new FileOutputStream("output_one_token_per_line.txt", true))
            )
        {
            
            while (fileScanner.hasNext()) {
                String line = fileScanner.nextLine();
                Scanner lineScanner = new Scanner(line);
                lineScanner.useDelimiter(", ");
                while (lineScanner.hasNext()) {
                    String token = lineScanner.next();
                    printWriter.println(token);
                } 
            }
        }
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}