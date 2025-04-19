import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class HomeworkM11Streams {

	public static List<Customer> customerList = null;
		
	public static void main(String[] args) throws Exception {

		customerList = new ArrayList<>();
		fillList(customerList);	
	
		// Q1: How many customers in CA?
		System.out.print("Q1: How many customers in CA?\nExpected: 20\n  Actual: ");
		long caCustomers = q1();
		System.out.println(caCustomers);
		
		// Q2: Create a list of all priority customers in MA.
		System.out.print("\nQ2: List of MA priority customers.\nExpected: [ Sasin, Anna (ID: AS1G) (Priority Customer),  Case, Justin (ID: JCT1) (Priority Customer)]\n  Actual: ");
		List<Customer> maPriorityList = q2();
		System.out.println(maPriorityList);

		// Q3: How much money have all customers spent (combined)?
		System.out.print("\nQ3: How much money have all customers spent (combined)?\nExpected: 330518.0\n  Actual: ");
		double total = q3();
		System.out.println(total);
		
		// Q4: How much money have all priority customers spent (combined)?
		System.out.print("\nQ4: How much money have all priority customers spent (combined)?\nExpected: 226177.0\n  Actual: ");
		double priorityTotal = q4();
		System.out.println(priorityTotal);
		
		// Q5: Create a map of all WY priority customers (key=id, value=customer)
		System.out.print("\nQ5: Map of WY priority customers\nExpected: {BS20= Seville, Barbara (ID: BS20) (Priority Customer), BCG5= Cade, Barry (ID: BCG5) (Priority Customer), LK71= King, Leigh (ID: LK71) (Priority Customer), PTC8= Turner, Paige (ID: PTC8) (Priority Customer)}\n  Actual: ");
		Map<String, Customer> wyCustomers = q5();
		System.out.println(wyCustomers);
		
		// Q6: What is the greatest amount of money spent by a NY priority customer?
		System.out.print("\nQ6: What is the greatest amount of money spent by a NY priority customer?\nExpected: 9207.0\n  Actual: ");
		double nyHighAmount = q6();
		System.out.println(nyHighAmount);
		
		//Q7: Find all customers that spent > 9000.
		// Create a comma-separated String of all customer IDs for customers that spent > 9000:
		System.out.print("\nQ7: Customers that spent > 9000.\nExpected: AD62,AS1G,CV62,HW32,JCT1,KA74,OB63,PTC8,WP90\n  Actual: ");
		String highIDList = q7();
		System.out.println(highIDList);
		
		//Q8: Find any customer that has spent > 9800. 
		// Print the amount spent by the customer. If there is none, nothing should be printed.
		// Note: you can test your code with a lower amount, too.
		System.out.println("\nQ8: Any customer that has spent > 9800. \nExpected: <nothing should print>\n  Actual: ");
		q8();
		
		// Q9: Find the sum of the numbers represented in an String array.
		String[] numWords = {"1", "2", "3", "4", "5", "6"};
		int sum = q9(numWords);
		System.out.println("\nQ9: The sum of the numbers represented in an String array.\nExpected: 21\n  Actual: " + sum);
		
		// Q10: Create a String of the numbers represented in the array, separated by semicolons.
		Integer[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		String concat = q10(nums);
		System.out.println("\nQ10: String of the numbers represented in the array, separated by semicolons.\nExpected: 1;2;3;4;5;6;7;8;9;10 \n  Actual: " + concat);
		
		// Q11: Create an infinite stream of random integers in the range 1-100.
		// Keep only the numbers that are multiples of 3.
		// Print the first 5 of these numbers.
		System.out.println("\nQ11: Expected: 5 random numbers that are multiples of 3 between 1-100.\n  Actual: ");
		q11();
		
		// Q12: Print the top 9-highest-scoring scrabble words in the list.
		// Note: a method is provided below to convert from char to score.
		// Hint: you might consider writing another method to find the score of a word!
		List<String> scrabbleWords = Files.readAllLines(Paths.get("words.txt"), Charset.forName("Cp1252"));
		System.out.println("\nQ12 Top 9-highest-scoring scrabble words.\nExpected: \npizzazz worth 45 points"+"\npizazz worth 35 points" +"\njazzily worth 35 points" +
				"\nquizzed worth 35 points" + "\njacuzzi worth 34 points" + "\nquizzer worth 34 points" +
				"\nquizzes worth 34 points" + "\njazzy worth 33 points" + "\njazzing worth 33 points" +"\nActual: "); 
		q12(scrabbleWords);

	}
	
	public static long q1() {
		// Q1: How many customers in CA?
		return customerList.stream()
				.filter(customer -> customer.getState().equals("CA"))
				.count();
	}
	public static List<Customer> q2 () {
		// Q2: Create a list of all priority customers in MA.
		return customerList.stream()
				.filter(customer -> customer.isPriority() && customer.getState().equals("MA"))
				.toList();
	}
	public static double q3() {
		// Q3: How much money have all customers spent (combined)?
		return customerList.stream()
				.mapToDouble(Customer::getAmountSpent)
				.sum();
	}
	public static double q4() {
		// Q4: How much money have all priority customers spent (combined)?
		return customerList.stream()
				.filter(Customer::isPriority)
				.mapToDouble(Customer::getAmountSpent)
				.sum();
	}
	public static Map<String, Customer> q5() {
		// Q5: Create a map of all WY priority customers (key=id, value=customer)
		return customerList.stream()
				.filter(customer -> customer.isPriority() && customer.getState().equals("WY"))
				.collect(Collectors.toMap(
					Customer::getId,
					Function.identity()
				));
	}
	public static double q6() {
		// Q6: What is the greatest amount of money spent by a NY priority customer?
		return customerList.stream()
				.filter(customer -> customer.isPriority() && customer.getState().equals("NY"))
				.mapToDouble(Customer::getAmountSpent)
				.max()
				.orElse(0.0);
	}
	public static String q7() {
		//Q7: Find all customers that spent > 9000.
		// Create a comma-separated String of all customer IDs for customers that spent > 9000:
		return customerList.stream()
				.filter(customer -> customer.getAmountSpent() > 9000)
				.map(Customer::getId)
				.collect(Collectors.joining(","));
	}
	public static void q8() {
		//Q8: Find any customer that has spent > 9800. 
		// Print the amount spent by the customer. If there is none, nothing should be printed.
		// Note: you can test your code with a lower amount, too.
		customerList.stream()
			.filter(customer -> customer.getAmountSpent() > 9800)
			.forEach(System.out::println);
	}
	public static int q9(String[] numWords) {
		// Q9: Find the sum of the numbers represented in an String array.
		return Stream.of(numWords)
			.mapToInt(Integer::parseInt)
			.sum();
	}
	public static String q10(Integer[] nums) {
		// Q10: Create a String of the numbers represented in the array, separated by semicolons.
		return Stream.of(nums)
				.map(String::valueOf)
				.collect(Collectors.joining(";"));
	}
	public static void q11() {
		// Q11: Create an infinite stream of random integers in the range 1-100.
		// Keep only the numbers that are multiples of 3.
		// Print the first 5 of these numbers.
		Random random = new Random();
		Stream.generate(() -> 1 + random.nextInt(100))
			.filter(number -> number % 3 == 0)
			.limit(5)
			.forEach(System.out::println);
	}
	public static void q12(List<String> scrabbleWords) {
		// Q12: Print the top 9-highest-scoring scrabble word in the list.
		// Note: a method is provided below to convert from char to score.
		// Hint: you might consider writing another method to find the score of a word! 
		scrabbleWords.stream()
			.sorted((word1, word2) -> -1*Integer.compare(wordToScore(word1), wordToScore(word2)))
			.limit(9)
			.forEach(word -> System.out.println(word + " worth " + wordToScore(word) + " points"));
	}

	public static int wordToScore(String word) {
		int score = 0;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			score += charToScore(c);
		}
		return score;
	}
	
	public static int charToScore(char c) {
		switch (c) {
			case 'a': case 'e': case 'i': case 'o': case 'u':
			case 'n': case 'r': case 't': case 'l': case 's':
				return 1;
			case 'g': case 'd': 
				return 2;
			case 'b': case 'c': case 'm': case 'p': 
				return 3;	
			case 'f': case 'h': case 'v': case 'w': case 'y':
				return 4;	
			case 'k': 
				return 5;
			case 'j': case 'x': 
				return 8;
			case 'q': case 'z': 
				return 10;		
			default:
				return -1;
		}
	}
	
	public static void fillList(List<Customer> list) {
		try (Scanner fileScan = new Scanner(
				new FileReader(new File("Customers.csv")))) {

			
			while(fileScan.hasNext()) {
				String line = fileScan.nextLine();
				Scanner lineScan = new Scanner(line);
				lineScan.useDelimiter(",");
				String firstName = lineScan.next();
				String lastName = lineScan.next();
				String id = lineScan.next();
				String state = lineScan.next();
				boolean priority = Boolean.parseBoolean(lineScan.next());
				double amount = Double.parseDouble(lineScan.next());
				Customer c = new Customer(firstName, lastName, id, state, priority, amount);
				list.add(c);
			}
		} catch (IOException ex){
			ex.printStackTrace();
		}
	}
}
