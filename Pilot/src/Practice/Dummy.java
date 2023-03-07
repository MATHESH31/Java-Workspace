package Practice;

import org.bson.Document;

import java.text.ParseException;
import java.util.*;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

class HelloWorld {

	static MongoClient mc = null;
	static MongoDatabase db = null;
	static MongoCollection<Document> customer_collection = db.getCollection("Customers");
	
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

	public static boolean Authentication() {

		System.out.println("Enter your Account_id : ");
		String account_id = in.nextLine();
		System.out.println("Enter your PIN : ");
		int pin = in.nextInt();
		in.nextLine();
		Document auth_lis = (Document) Arrays.asList(new Document("$match", new Document("Account_id", account_id)));
		if ((int) auth_lis.get("PIN") == pin) {
			return true;
		} else {
			return false;
		}

	}

	public static void main(String[] args) throws ParseException {
		Connection();
		Authentication();
		mc.close();
	}
}
