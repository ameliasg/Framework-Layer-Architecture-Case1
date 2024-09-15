package Case;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Shop {
	private HashMap<String, Customer> customers = new HashMap<>();
	private ArrayList<Tofu> tofuList = new ArrayList<>();
	private Scanner scanner = new Scanner(System.in);

	public Shop() {
		tofuList.add(new Tofu("Medium Black Tofu", 20000));
		tofuList.add(new Tofu("Firm Block Tofu", 10000));
		tofuList.add(new Tofu("Smoked Black Tofu", 30000));
	}

	public void authenticationMenu() {
		while (true) {
			System.out.println("## Toppo Shop ##");
			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.println("3. Exit");
			System.out.println("Choose >> ");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				login();
				break;
			case 2:
				register();
				break;
			case 3:
				System.out.println("Exiting");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice, You must choice between 1-3");
			}
		}
	}

	private void register() {
		System.out.println("Input username [length must be more than 5]: ");
		String username = scanner.nextLine();
		System.out.println("Input password [length must be more than 5]: ");
		String password = scanner.nextLine();
		System.out.println("Input member type [must be 'gold'or 'silver' (insensitive) ");
		String memberType = scanner.nextLine().toLowerCase();

		DiscountType discountType = null;

		if (memberType.equals("gold")) {
			discountType = new GoldDiscount();
		} else if (memberType.equals("silver")) {
			discountType = new SilverDiscount();
		} else {
			System.out.println("Invalid membership type");
			return;
		}
		customers.put(username, new Customer(username, password, discountType));
		System.out.println("Registration is successfull!");
	}

	private void login() {
		System.out.println("Input username: ");
		String username = scanner.nextLine();
		System.out.println("Ënter Password: ");
		String password = scanner.nextLine();

		if (customers.containsKey(username) && customers.get(username).getPassword().equals(password)) {
			System.out.println("Redirect to menu page..");
			System.out.println("Press enter continue...");
			mainMenu(customers.get(username));
		} else {
			System.out.println("Wrong credentials");
		}
	}

	public void mainMenu(Customer customer) {
		ArrayList<Tofu> cart = new ArrayList<>();
		while (true) {
			System.out.println("\nMenu");
			System.out.println("\n=============================");
			for (int i = 0; i < tofuList.size(); i++) {
				System.out.println((i + 1) + ". " + tofuList.get(i).toString());
			}

			System.out.println("\nYour Cart: " + cart);
			System.out.println("\nchoose menu that you want to purchase [Enter '0' to checkout]: ");
			System.out.println(">> ");

			int choice = scanner.nextInt();
			scanner.nextLine();

			if (choice == 0) {
				checkout(customer, cart);
				break;
			} else if (choice > 0 && choice <= tofuList.size()) {
				cart.add(tofuList.get(choice - 1));
				System.out.println("Added " + tofuList.get(choice - 1).getName() + "to your cart");
			} else {
				System.out.println("Invalid choice");
			}
		}
	}

	private void checkout(Customer customer, ArrayList<Tofu> cart) {
		if (cart.isEmpty()) {
			System.out.println("Your cart is empty!");
			return;
		}

		double totalPrice = 0;
		for (Tofu tofu : cart) {
			totalPrice += tofu.getPrice();
		}

		double finalPrice = customer.discountType(totalPrice);

		System.out.println("Total price before discount: " + totalPrice);
		System.out.println("Final price after discount: " + finalPrice);

		while (true) {
			System.out.print("Enter your payment: ");
			double payment = scanner.nextDouble();

			if (payment >= finalPrice) {
				double change = payment - finalPrice;
				System.out.println("Payment successful! Your change is " + change);
				break;
			} else {
				System.out.println("Insufficient payment, please try again.");
			}
		}
	}
}
