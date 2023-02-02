package DB_Java;

import java.util.*;

import org.bson.Document;
import org.bson.conversions.Bson;

import static com.mongodb.client.model.Updates.*;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoJavaLocal {
	static MongoClient mc = new MongoClient("localhost", 27017);
	static MongoDatabase db = mc.getDatabase("Javadb");

	public static Document file(String name, int age, long phone, String address) {
		Document doc = new Document("Name", name).append("Age", age).append("Phone", phone).append("Address", address);
		return doc;
	}

	public static void Crud() {
		boolean flag = true;
		Scanner in = new Scanner(System.in);
		MongoCollection<Document> currcol = db.getCollection("Javacol");

		while (flag) {
			System.out.println(
					"Press 1 to Insert data.\nPress 2 to Read data.\nPress 3 to Update data.\nPress 4 to Delete data.\nPress 0 to exit.");
			System.out.print("Enter your choice : ");
			int a = in.nextInt();
			in.nextLine();

			switch (a) {
			// Create document
			case 1:
				System.out.print("Enter your name : ");
				String name = in.nextLine();
				System.out.print("Enter your age : ");
				int age = in.nextInt();
				System.out.print("Enter your phone number : ");
				long phone = in.nextLong();
				in.nextLine();
				System.out.print("Enter your address : ");
				String address = in.nextLine();
				currcol.insertOne(file(name, age, phone, address));
				System.out.println("Document inserted.");
				break;

			// Read document
			case 2:
				FindIterable<Document> doc = currcol.find();
				Iterator<Document> it = doc.iterator();
				while (it.hasNext()) {
					System.out.println(it.next());
				}
				break;

			// Update document
			case 3:
				System.out.print("Enter the match field : ");
				String mat_field = in.nextLine();
				System.out.print("Enter value of the match field : ");
				String mat_value = in.nextLine();

				System.out.print("Enter Update field : ");
				String upd_field = in.nextLine();
				System.out.print("Enter Update value : ");
				String upd_value = in.nextLine();

				if (upd_field.toLowerCase() == "name" || upd_field.toLowerCase() == "age"
						|| upd_field.toLowerCase() == "phone" || upd_field.toLowerCase() == "address") {
					if (upd_field.toLowerCase() == "name" || upd_field.toLowerCase() == "address") {
						Bson match = set(mat_field, mat_value);
						Bson update = set(upd_field, upd_value);
						currcol.updateOne(match, update);
					} else if (upd_field.toLowerCase() == "age") {
						Bson match = set(mat_field, Integer.valueOf(mat_value));
						Bson update = set(upd_field, Integer.valueOf(upd_value));
						currcol.updateOne(match, update);
					} else if (upd_field.toLowerCase() == "phone") {

					} else {
						System.out.println("Please check your input.");
					}
				} else {
					System.out.println("Please check your input.");
				}

				// Remove document
			case 4:

				// Exit loop
			case 0:
				flag = false;
				System.out.println("Program ended.");
				break;

				// default message
			default:
				System.out.println("Please check your input.");

			}
		}
		in.close();
	}

	public static void main(String[] args) throws Exception {
		try {
			mc = new MongoClient("localhost", 27017);
			db = mc.getDatabase("Javadb");
			System.out.println("Database connected.");
			ArrayList<String> collections = db.listCollectionNames().into(new ArrayList<>());
			boolean check = collections.contains("Javacol");
			if (check == true) {
				Crud();
			} else {
				System.out.println("Collection doesn't exist.");
				db.createCollection("Javacol");
				System.out.println("Collection created successfully.");
				Crud();

				mc.close();
				System.out.println("Database disconnected.");
			}
		} catch (Exception e) {
			System.out.println("Database connection failed.");
		}
	}

}
