package AutomatedTellerMachine;

import java.util.*;

public class Main {
	static int id;
	static ArrayList<CustomerCreation> Customers = new ArrayList<>();
	static ArrayList<Deposit> dep_details = new ArrayList<>();
	static ArrayList<TranscationHistory> transaction = new ArrayList<>();

	public static int id() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		try {
			System.out.println("Enter ID: ");
			id = in.nextInt();
		} catch (Exception e) {
			System.out.println("Please enter valid id(Datatype int).");
			id();
		}
		return id;
	}

	public static boolean Authentication() {
		boolean flag = true;
		boolean check = false;
		CustomerCreation comp = null;
		id = id();
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);

		for (CustomerCreation i : Customers) {
			if (i.getId() == id) {
				flag = true;
				comp = i;
				break;
			} else {
				flag = false;
			}
		}
		if (flag == true) {
//			in.nextLine();
			System.out.print("Enter Pass : ");
			String Pass = in.nextLine();
			check = (comp.getPass().equals(Pass));
		} else {
			System.out.println("The entered ID is not our customer.");
		}
		return check;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int dep_amount = 0;
		boolean flag = true;
		int count = 0;
		while (flag) {
			System.out.println("Press 1 for create account.\nPress 2 for existing account.\nPress 0 for exit.");

			int a = in.nextInt();

			if (a == 1) {
				id = id();
				System.out.println("Enter Your Name: ");
				in.nextLine();
				String name = in.nextLine();
				System.out.println("Enter Your Password: ");
				String pass = in.next();
				CustomerCreation cc = new CustomerCreation(id, name, pass);
				Deposit dep = new Deposit(id, 0);
				dep_details.add(dep);
				Customers.add(cc);
				System.out.println("Your account has been created.");
				System.out.println(Customers.get(count).toString());
				count++;
			} else if (a == 2) {
				if (Authentication() == true) {
					System.out.println("Press 1 for Deposit.\nPress 2 for Withdrawal.\nPress 3 for Balance.");

					int b = in.nextInt();

					switch (b) {
					case 1:
						String transaction_type = "Deposit";
						int amount = 0;
						System.out.print("Enter the amount to deposit : ");
						dep_amount = in.nextInt();
						for (Deposit i : dep_details) {
							if (i.getId() == id) {
								amount = i.getAmount() + dep_amount;
								i.setAmount(amount);
								System.out.println("Amount deposited successfully.");
								System.out.println(i.toString());
								break;
							}
						}
						TranscationHistory trans = new TranscationHistory(id, transaction_type, dep_amount, amount);
						transaction.add(trans);
						System.out.println(transaction.toString());

					}
				} else {
					Authentication();
				}
			} else {
				System.out.print("Thank you");
				flag = false;
			}
		}
		in.close();

	}

}
