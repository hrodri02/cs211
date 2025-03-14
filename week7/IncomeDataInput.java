import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class IncomeDataInput {
    public static void main(String[] args) {
        File file = new File("finc02_1_1.csv");
        List<IncomeBracket> incomeBracketsByAge = new ArrayList<>();
        readIncomeData(file, incomeBracketsByAge);
        Collections.sort(incomeBracketsByAge, new IncomeBracket.AgeGroupsComparator());
        // Q1: What are the income brackets sorted by the number of families in each bracket?
        System.out.println(incomeBracketsByAge);
        // Q2: For each age group, how many families are making under and over $100,000/yr?
        for (int j = 0; j < 7; j++) {
            int numUnder100_000 = 0;
            int numOver100_1000 = 0;

            for (int i = 0; i < incomeBracketsByAge.size(); i++) {
                IncomeBracket incomeBracket = incomeBracketsByAge.get(i);
                Integer incomeMax = incomeBracket.getMax();
                Integer numsFamiliesInAgeGroup = incomeBracket.getAgeGroups().get(j);
                if (incomeMax < 100_000) {
                    numUnder100_000 += numsFamiliesInAgeGroup;
                }
                else {
                    numOver100_1000 += numsFamiliesInAgeGroup;
                }
            }
            String ageGroup = (15 + 10*j) + " - " + (15 + 10*j + 9);
            System.out.println(ageGroup + ": " + 
                            numUnder100_000 + " families making under $100,000, " + 
                            numOver100_1000 + " families making over $100,000.");
        }
    }

    public static void readIncomeData(File file, List<IncomeBracket> incomeBracketsByAge) {
        try (Scanner fileScan = new Scanner(new FileReader(file))) {
            // skip the first 13 lines
            skipLines(fileScan, 13);

            for (int i = 0; i < 41; i++) {
                List<Integer> numByAgeGroup = new ArrayList<>();
                String line = fileScan.nextLine();
                
                Scanner lineScan = new Scanner(line);
                lineScan.useDelimiter(",");

                skipColumns(lineScan, 3);
                String token = lineScan.next();
                int num15to24 = Integer.parseInt(token);
                numByAgeGroup.add(num15to24);

                token = lineScan.next();
                int num25to34 = Integer.parseInt(token);
                numByAgeGroup.add(num25to34);
                
                skipColumns(lineScan, 2);
                token = lineScan.next();
                int num35to44 = Integer.parseInt(token);
                numByAgeGroup.add(num35to44);

                skipColumns(lineScan, 2);
                token = lineScan.next();
                int num45to54 = Integer.parseInt(token);
                numByAgeGroup.add(num45to54);

                skipColumns(lineScan, 2);
                token = lineScan.next();
                int num55to64 = Integer.parseInt(token);
                numByAgeGroup.add(num55to64);

                skipColumns(lineScan, 3);
                token = lineScan.next();
                int num65to74 = Integer.parseInt(token);
                numByAgeGroup.add(num65to74);

                skipColumns(lineScan, 2);
                token = lineScan.next();
                int num75AndOver = Integer.parseInt(token);
                numByAgeGroup.add(num75AndOver);

                int min = i*5000;
                int max = min + 5000 - 1;
                String range = "$" + min;
                range += (i == 40)? " and over" : " - $" + (max);
                IncomeBracket bracket = new IncomeBracket.Builder()
                    .min(min)
                    .max(max)
                    .range(range)
                    .ageGroups(numByAgeGroup)
                    .build();
                incomeBracketsByAge.add(bracket);
            }
        }
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private static void skipLines(Scanner scanner, int numLines) {
        for (int i = 0; i < numLines; i++)
            scanner.nextLine();
    }

    private static void skipColumns(Scanner scanner, int numCols) {
        for (int i = 0; i < numCols; i++)
            scanner.next();
    }
}