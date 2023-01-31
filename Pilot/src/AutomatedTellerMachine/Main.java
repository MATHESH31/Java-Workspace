package AutomatedTellerMachine;

import java.util.*;

public class Main {
	static int id;
	static int dep_amount = 0;
	static int wid_amount = 0;
	static int balance = 0;
	static TransactionHistory last = null;
	static boolean flag = true;
	static int count = 0;
	static ArrayList<CustomerCreation> Customers = new ArrayList<>();
	static ArrayList<Deposit> dep_details = new ArrayList<>();
	static ArrayList<Withdrawal> wid_details = new ArrayList<>();
	static ArrayList<TransactionHistory> transaction = new ArrayList<>();
	static List<Integer> idList = new ArrayList<>();

	public static int id() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		try {
			System.out.print("Enter ID: ");
			id = in.nextInt();
		} catch (Exception e) {
			System.out.println("Please enter valid id(Datatype int).");
			id();
		}
		return id;
	}

	public static boolean Authentication(List<Integer> idList) {
		@SuppressWarnings("unused")
		boolean flag = true;
		boolean check = false;
		CustomerCreation comp = null;
		id = id();
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);

		if(idList.contains(id) == true) {
			flag = true;
			for (CustomerCreation i : Customers) {
				if (i.getId() == id) {
					comp = i;
					break;
				}
			}
			System.out.print("Enter Pass : ");
			String Pass = in.nextLine();
			check = (comp.getPass().equals(Pass));
		}
		else {
			System.out.println("The ID does not exist.");
			ATM();
		}
		return check;
	}

	public static int Validation() {
		int num = 0;
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		try {
			System.out.print("Please Enter your choice : ");
			num = in.nextInt();

		} catch (Exception e) {
			System.out.println("Please enter a number.");
			num = Validation();
		}
		return num;
	}

	public static int Amount() {
		int num = 0;
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		try {
			System.out.print("Please enter an amount : ");
			num = in.nextInt();

		} catch (Exception e) {
			System.out.println("Please enter a number.");
			num = Amount();
		}
		return num;
	}
	
	public static void ATM() {
		Scanner in = new Scanner(System.in);
		while (flag) {
			System.out.println("Press 1 for create account.\nPress 2 for existing account.\nPress 0 for exit.");

			int a = Validation();

			if (a == 1) {
				id = id();
				if (idList.contains(id) == false) {
					idList.add(id);
					System.out.print("Enter Your Name: ");
					String name = in.nextLine();
					System.out.print("Enter Your Password: ");
					String pass = in.nextLine();
					CustomerCreation cc = new CustomerCreation(id, name, pass, 0);
					Deposit dep = new Deposit(id, 0);
					dep_details.add(dep);
					Withdrawal wid = new Withdrawal(id, 0);
					wid_details.add(wid);
					Customers.add(cc);
					System.out.println("Your account has been created.");
					System.out.println(Customers.get(count).toString());
					count++;
				} else {
					System.out.println("This ID exists.");
				}

			} else if (a == 2) {
				if (Authentication(idList) == true) {
					for(CustomerCreation i : Customers) {
						if(i.getId() == id) {
							balance = i.getBalance();
						}
					}
					System.out.println(
							"Press 1 for Deposit.\nPress 2 for Withdrawal.\nPress 3 for Balance.\nPress 4 to see transactions.\nPress 5 to go back");

					int b = Validation();

					switch (b) {
					case 1:
						String transaction_type = "Deposit";
						dep_amount = Amount();
						for (Deposit i : dep_details) {
							if (i.getId() == id) {
								balance += dep_amount;
								i.setAmount(balance);
								System.out.println("Amount deposited successfully.");
								System.out.println(i.toString());
								break;
							}
						}
						
						for(CustomerCreation i : Customers) {
							if(i.getId() == id) {
								i.setBalance(balance);
							}
						}
						
						TransactionHistory trans = new TransactionHistory(id, transaction_type, dep_amount, balance);
						transaction.add(trans);
						last = transaction.get(transaction.size() - 1);
						System.out.println(last.toString());
						break;

					case 2:
						String transaction_type1 = "Withdrawal";
						wid_amount = Amount();
						for (Withdrawal i : wid_details) {
							if (i.getId() == id && balance > 0 && balance > wid_amount) {
								balance -= wid_amount;
								i.setAmount(balance);
								System.out.println("Please collect your cash from the dispenser.");
								System.out.println(i.toString());
							}
							else {
								System.out.println("Insufficeint Balance.");
								break;
							}
						}
						
						for(CustomerCreation i : Customers) {
							if(i.getId() == id) {
								i.setBalance(balance);
							}
						}
						
						if (balance > 0) {
							trans = new TransactionHistory(id, transaction_type1, wid_amount, balance);
							transaction.add(trans);
							last = transaction.get(transaction.size() - 1);
							System.out.println(last.toString());
						}
						break;

					case 3:
						for (TransactionHistory i : transaction) {
							if (i.getId() == id) {
								balance = i.getAmount();
							}
						}
						Balance bal = new Balance(id, balance);
						System.out.println(bal.toString());
						break;

					case 4:
						if (transaction.size() > 0) {
							for (TransactionHistory i : transaction) {
								if (i.getId() == id) {
									System.out.println(transaction.toString());
									break;
								}
							}
							System.out.println("These are your transactions.");
						} else {
							System.out.println("You have done no transactions.");
						}
					case 5:
						ATM();
						break;
					default:
						System.out.println("Please check your input");
					}
				}
				else {
					System.out.println(
							"The credentials given have no match in the system.\nPlease enter a valid ID and Password.\n");
				}
			} else {
				System.out.println("Thank you");
				flag = false;
			}
		}
		in.close();
	}

	public static void main(String[] args) {
		ATM();
	}
}
