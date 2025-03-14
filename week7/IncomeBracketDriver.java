import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class IncomeBracketDriver {
    public static void main(String[] args) {
        File file = new File("finc02_1_1_clean.csv");
        List<IncomeBracket> incomeBracketsByAge = new ArrayList<>();
        Map<String, List<IncomeBracket>> rangesToIncomeBrackets = new HashMap<>();
        readIncomeData(file, incomeBracketsByAge, rangesToIncomeBrackets);
        Collections.sort(incomeBracketsByAge);
        // Q1: What are the income brackets sorted by the number of families in each bracket?
        System.out.println("Top five income brackets with the most families.");
        for (int i = 0; i < 5; i++) 
            System.out.println(incomeBracketsByAge.get(i));
        System.out.println();
        // Q2: For each age group, how many families are making under and over $100,000/yr?
        System.out.println("Number of families making under and over $100,000/yr by age group.");
        for (int j = 0; j < 7; j++) {
            int numUnder100_000 = 0;
            int numOver100_1000 = 0;

            for (int i = 0; i < incomeBracketsByAge.size(); i++) {
                IncomeBracket incomeBracket = incomeBracketsByAge.get(i);
                Integer incomeMax = incomeBracket.getMax();
                Integer numsFamiliesInAgeGroup = incomeBracket.getNumOfFamiliesInAgeGroups().get(j);
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
        System.out.println();
        // Q3: If we broke up the income brackets into $50,000 brackets, how many families are in each braket?
        System.out.println("Number of familiies in income brackets of $50,000.");
        for (String bracket : rangesToIncomeBrackets.keySet()) {
            List<IncomeBracket> brackets = rangesToIncomeBrackets.get(bracket);
            int numOfFamilies = 0;
            for (IncomeBracket b : brackets) {
                numOfFamilies += b.getTotalNumOfFamilies();
            }
            System.out.println(bracket + ", number of families = " + numOfFamilies);
        }
    }

    public static void readIncomeData(
                                    File file, 
                                    List<IncomeBracket> incomeBracketsByAge,
                                    Map<String, List<IncomeBracket>> rangesToIncomeBrackets) 
    {
        try (Scanner fileScan = new Scanner(new FileReader(file))) {
            int i = 0;
            while (fileScan.hasNext()) {
                List<Integer> numByAgeGroup = new ArrayList<>();
                String line = fileScan.nextLine();
                
                Scanner lineScan = new Scanner(line);
                lineScan.useDelimiter(",");

                String token = lineScan.next();
                int num15to24 = Integer.parseInt(token);
                numByAgeGroup.add(num15to24);

                token = lineScan.next();
                int num25to34 = Integer.parseInt(token);
                numByAgeGroup.add(num25to34);
                
                token = lineScan.next();
                int num35to44 = Integer.parseInt(token);
                numByAgeGroup.add(num35to44);

                token = lineScan.next();
                int num45to54 = Integer.parseInt(token);
                numByAgeGroup.add(num45to54);

                token = lineScan.next();
                int num55to64 = Integer.parseInt(token);
                numByAgeGroup.add(num55to64);

                token = lineScan.next();
                int num65to74 = Integer.parseInt(token);
                numByAgeGroup.add(num65to74);

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
                    .numOfFamiliesInAgeGroups(numByAgeGroup)
                    .build();
                incomeBracketsByAge.add(bracket);
                if (max < 50_000) {
                    if (rangesToIncomeBrackets.containsKey("under $50,000")) {
                        List<IncomeBracket> brackets = rangesToIncomeBrackets.get("under $50,000");
                        brackets.add(bracket);
                    }
                    else {
                        List<IncomeBracket> brackets = new ArrayList<IncomeBracket>();
                        brackets.add(bracket);
                        rangesToIncomeBrackets.put("under $50,000", brackets);
                    }
                }
                else if (max < 100_000) {
                    if (rangesToIncomeBrackets.containsKey("$50,000 - $99,999")) {
                        List<IncomeBracket> brackets = rangesToIncomeBrackets.get("$50,000 - $99,999");
                        brackets.add(bracket);
                    }
                    else {
                        List<IncomeBracket> brackets = new ArrayList<IncomeBracket>();
                        brackets.add(bracket);
                        rangesToIncomeBrackets.put("$50,000 - $99,999", brackets);
                    }
                }
                else if (max < 150_000) {
                    if (rangesToIncomeBrackets.containsKey("$100,000 - $149,999")) {
                        List<IncomeBracket> brackets = rangesToIncomeBrackets.get("$100,000 - $149,999");
                        brackets.add(bracket);
                    }
                    else {
                        List<IncomeBracket> brackets = new ArrayList<IncomeBracket>();
                        brackets.add(bracket);
                        rangesToIncomeBrackets.put("$100,000 - $149,999", brackets);
                    }
                }
                else if (max < 200_000) {
                    if (rangesToIncomeBrackets.containsKey("$150,000 - $199,999")) {
                        List<IncomeBracket> brackets = rangesToIncomeBrackets.get("$150,000 - $199,999");
                        brackets.add(bracket);
                    }
                    else {
                        List<IncomeBracket> brackets = new ArrayList<IncomeBracket>();
                        brackets.add(bracket);
                        rangesToIncomeBrackets.put("$150,000 - $199,999", brackets);
                    }
                }
                else {
                    if (rangesToIncomeBrackets.containsKey("$200,000 and over")) {
                        List<IncomeBracket> brackets = rangesToIncomeBrackets.get("$200,000 and over");
                        brackets.add(bracket);
                    }
                    else {
                        List<IncomeBracket> brackets = new ArrayList<IncomeBracket>();
                        brackets.add(bracket);
                        rangesToIncomeBrackets.put("$200,000 and over", brackets);
                    }
                }

                i++;
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