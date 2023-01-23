package AutomatedTellerMachine;

import java.util.*;

public class Main {
	static int id;
//	static Scanner in = new Scanner(System.in);
	static ArrayList<CustomerCreation> Customers = new ArrayList<>();
	
	public static int id() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
			try {
				System.out.println("Enter Your ID: ");
				id = in.nextInt();
				return id;
			}
			catch(Exception e){
				System.out.println("Please enter valid id(Datatype int).");
				id();
			}
		return id;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean flag = true;
		int count = 0;
		while(flag) {
			System.out.println("Press 1 for create account.");
			System.out.println("Press 2 for existing account.");
			System.out.println("Press 0 for exit.");
	
			int a = in.nextInt();
			
			if(a == 1) {
				id = id();
				System.out.println("Enter Your Name: ");				
				in.nextLine();
				String name = in.nextLine();
				System.out.println("Enter Your Password: ");
				String pass = in.next();
				CustomerCreation cc = new CustomerCreation(id,name,pass);
				Customers.add(cc);
				System.out.println("Your account has been created.");
				System.out.println(Customers.get(count).toString());
				count++;
			}
			else if(a == 2) {
				
			}
			else {
				System.out.print("Thank you");
				flag = false;
			}
		}
		in.close();
		
	}

}
