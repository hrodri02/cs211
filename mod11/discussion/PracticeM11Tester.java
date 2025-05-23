import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class PracticeM11Tester {
	
	public static void main(String[] args) {
		List<Client> clientList = new ArrayList<Client>();
		fillList(clientList);
		// see a sample of the list
		for(int i=0; i<5; i++) {
			System.out.println(clientList.get(i));
		}
		// Q4: Which client spent the most money? 
		Client client = clientList.stream().max(
			(client1, client2) -> {
				double total1 = client1.getOrders().stream().mapToDouble(Order::getTotal).sum();
				double total2 = client2.getOrders().stream().mapToDouble(Order::getTotal).sum();
				return Double.compare(total1, total2);
			}
		).get();
		System.out.println(client);
	}

	private static void fillList(List<Client> clientList) {
		try (Scanner clientFileScan = new Scanner(new FileReader(new File("ClientData.csv")));
				Scanner orderFileScan = new Scanner(new FileReader(new File("OrderData.csv")))) {

			/* create a list of orders */
			List<Order> orderList = new ArrayList<Order>();
			while (orderFileScan.hasNext()) {
				String orderLine = orderFileScan.nextLine();
				Scanner orderLineScan = new Scanner(orderLine);
				orderLineScan.useDelimiter(",");
				String allOrderString = orderLineScan.next();
				double total = Double.parseDouble(orderLineScan.next());
				
				List<String> itemList = new ArrayList<String>();
				Scanner allOrderStringScan = new Scanner(allOrderString);
				allOrderStringScan.useDelimiter(";");
				while (allOrderStringScan.hasNext()) {
					itemList.add(allOrderStringScan.next());
				}
				Order order = new Order(itemList, total);
				orderList.add(order);
			}
			int orderNum = 0;

			while (clientFileScan.hasNext()) {
				String clientLine = clientFileScan.nextLine();
				Scanner clientLineScan = new Scanner(clientLine);
				clientLineScan.useDelimiter(",");
				String firstName = clientLineScan.next();
				String lastName = clientLineScan.next();
				int age = Integer.parseInt(clientLineScan.next());
				String genderString = clientLineScan.next();
				Gender gender;
				if (genderString.equalsIgnoreCase("M")) {
					gender = Gender.MALE;
				} else if (genderString.equalsIgnoreCase("F")) {
					gender = Gender.FEMALE;
				} else {
					gender = Gender.OTHER_OR_UNSPECIFIED;
				}
				String streetNumber = clientLineScan.next();
				String street = clientLineScan.next();
				String city = clientLineScan.next();
				String state = clientLineScan.next();
				String zip = clientLineScan.next();
				int numOrders = Integer.parseInt(clientLineScan.next());
				Client c = new Client(firstName, lastName, age, gender,
						new Address(streetNumber, street, city, state, zip));
				clientList.add(c);
				for (int i = 0; i < numOrders; i++) {
					c.addOrder(orderList.get(orderNum));
					orderNum = (orderNum + 1) % orderList.size();
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
