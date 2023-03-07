package ThreadAndTransaction;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.*;

import org.bson.Document;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.logging.Logger;
import java.util.logging.Level;

public class TTMain {

	static MongoClient mc;
	static MongoDatabase db;
	static String account_id;
	static String holder_name;
	static int amount;
	static int current_balance;
	static List<Document> auth_lis = new ArrayList<>();

	static Scanner in = new Scanner(System.in);

	public static void Connection() {
		try {
			String uri = "mongodb+srv://mathesh:okw1D2c6n0p3mphr@pilot.elauiph.mongodb.net/?retryWrites=true&w=majority";
			MongoClient mc = MongoClients.create(uri);
			db = mc.getDatabase("Lantrasoft_bank");
			System.out.println("DATABASE IS CONNECTED.\n");
		} catch (Exception e) {
			System.err.println(e);
			System.out.println("DATABASE CONNECTION FAILED.");
		}

	}

	public static Document CreateAccountfile(String name, String account_id, String account_type, String branch,
			String pan_id, LocalDate dOB, long phone, String address, int balance, int pin) {
		Document cus_doc = new Document("Name", name).append("Account_id", account_id)
				.append("Account_type", account_type).append("Branch", branch).append("Pan_id", pan_id)
				.append("DOB", dOB).append("Phone", phone).append("Address", address).append("Balance", balance)
				.append("PIN", pin);
		return cus_doc;
	}

	public static Document Transaction(String name, String account_id, LocalDate date, int amount, int balance) {
		Document bank_doc = new Document("Name", name).append("Account_id", account_id)
				.append("Date_Time_Of_transaction", date).append("Amount", amount).append("Balance", balance);
		return bank_doc;

	}

	public static boolean Authentication() {
		MongoCollection<Document> customer_collection = db.getCollection("Customers");

		System.out.println("Enter your Account_id : ");
		account_id = in.nextLine();
		System.out.println("Enter your PIN : ");
		int pin = in.nextInt();
		in.nextLine();
		List<Document> auth_lis = customer_collection
				.aggregate(Arrays
						.asList(new Document("$match", new Document("Account_id", account_id).append("PIN", pin))))
				.into(new ArrayList<>());
		if (auth_lis.size() > 0) {
			holder_name = auth_lis.get(0).getString("Name");
			current_balance = auth_lis.get(0).getInteger("Balance");
			return true;
		} else {
			return false;
		}
	}

	public static void CreateAccount() throws ParseException {
		MongoCollection<Document> customer_collection = db.getCollection("Customers");

		System.out.println("Enter your name : ");
		String name = in.nextLine();
		System.out.println("Enter your account type(Savings / Current) : ");
		String account_type = in.nextLine();
		System.out.println("Enter your branch : ");
		String branch = in.nextLine();
		System.out.println("Enter your DOB(YYYY-MM-DD) : ");
		String[] temp_date = in.nextLine().split("-");
		LocalDate dOB = LocalDate.of(Integer.parseInt(temp_date[0]), Integer.parseInt(temp_date[1]),
				Integer.parseInt(temp_date[2]));
		System.out.println("Enter your phone number : ");
		Long phone = in.nextLong();
		in.nextLine();
		System.out.println("Enter your address : ");
		String address = in.nextLine();
		int balance = 0;
		int pin = in.nextInt();
		account_id = "LSB" + Long.toString(phone).substring(6, 10);
		String pan_id = name.substring(0, 3) + Long.toString(phone).substring(0, 4);
		customer_collection.insertOne(
				CreateAccountfile(name, account_id, account_type, branch, pan_id, dOB, phone, address, balance, pin));
		System.out.println("Your Account has been created.");
	}

	public static void Banking() {
		MongoCollection<Document> customer_collection = db.getCollection("Customers");
		MongoCollection<Document> customer_transaction = db.getCollection("Transactions");

		boolean Level2 = true;
		BasicDBObject match = new BasicDBObject();
		BasicDBObject update = new BasicDBObject();
		BasicDBObject set = new BasicDBObject();

		if (Authentication() == true) {
			while (Level2) {
				System.out.println(
						"To deposit --- Enter 1\nTo Withdraw --- Enter 2\nTo see Transactions --- Enter 3\nTo go back --- Enter 0\n");
				System.out.print("Your choice : ");
				int operation = in.nextInt();
				in.nextLine();
				switch (operation) {
				case 1:
					System.out.print("Enter amount to deposit : ");
					amount = in.nextInt();
					in.nextLine();
					match.put("Account_id", account_id);
					update.put("Balance", amount);
					set.put("$set", update);
					customer_collection.updateOne(match, set);
					customer_transaction.insertOne(Transaction(holder_name,account_id,LocalDate.now(),amount,current_balance+amount));
					System.out.println("Amount is credited.");
					break;

				case 2:
					System.out.print("Enter amount to widthdraw : ");
					amount = in.nextInt();
					in.nextLine();
					match.put("Account_id", account_id);
					update.put("Balance", amount);
					set.put("$set", update);
					customer_collection.updateOne(match, set);
					customer_transaction.insertOne(Transaction(holder_name,account_id,LocalDate.now(),amount,current_balance-amount));
					System.out.println("Amount is debited.");
					break;

				case 3:

					break;

				case 0:
					Level2 = false;
					break;

				default:
					System.out.println("Please enter a valid option.");
					break;
				}
			}
		} else {
			System.out.println("Authentication Failed....");
			Banking();
		}
		auth_lis.clear();

	}

	public static void main(String[] args) throws ParseException {
		Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
		mongoLogger.setLevel(Level.SEVERE);
		boolean Level1 = true;
		Connection();
		while (Level1) {
			System.out.println(
					"To create an account --- Enter 1\nFor banking --- Enter 2\nFor UPI --- Enter 3\nTo Exit -- Enter 0");
			System.out.print("Your choice : ");
			int process = in.nextInt();
			in.nextLine();
			switch (process) {
			case 1:
				CreateAccount();
				break;

			case 2:
				Banking();
				break;

			case 3:

				break;

			case 0:
				Level1 = false;
				System.out.println("Database is safely disconnected.");
				break;

			default:
				System.out.println("Please enter a valid option.");
				mc.close();
			}
		}
	}

}
