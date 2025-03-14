import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IncomeDataInput {
    public static void main(String[] args) {
        File file = new File("finc02_1_1.csv");
        List<List<Integer>> incomeBracketsByAge = new ArrayList<>();
        readIncomeData(file, incomeBracketsByAge);
        int maxNumOfFamilies = 0;
        int indexOfMaxNumOfFamilies = 0;
        for (int i = 0; i < incomeBracketsByAge.size(); i++) {
            String incomeBracket = i*5000 + " - " + (i*5000 + 5000 - 1);
            int numFamilies = 0;
            List<Integer> numsByAgeGroup = incomeBracketsByAge.get(i);
            for (Integer numInAgeGroup : numsByAgeGroup) {
                numFamilies += numInAgeGroup;
            }
            if (numFamilies > maxNumOfFamilies) {
                maxNumOfFamilies = numFamilies;
                indexOfMaxNumOfFamilies = i;
            }
            // System.out.println(incomeBracket + ", num of families = " + numFamilies);
            // System.out.println(incomeBracket + ": " + numsByAgeGroup);
        }
        String incomeBracket = Integer.toString(indexOfMaxNumOfFamilies*5000);
        incomeBracket += (indexOfMaxNumOfFamilies == incomeBracketsByAge.size() - 1)? " and over" :
                            " - " + (indexOfMaxNumOfFamilies*5000 + 5000 - 1);
        System.out.println(incomeBracket + ", num of families = " + maxNumOfFamilies);
        for (int j = 0; j < 7; j++) {
            int numUnder100_000 = 0;
            int numOver100_1000 = 0;

            for (int i = 0; i < incomeBracketsByAge.size(); i++) {
                List<Integer> incomBracket = incomeBracketsByAge.get(i);
                
                Integer incomeMax = i*5000 + 5000 - 1;
                Integer numsFamiliesInAgeGroup = incomBracket.get(j);
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

    public static void readIncomeData(File file, List<List<Integer>> incomeBracketsByAge) {
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

                incomeBracketsByAge.add(numByAgeGroup);
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