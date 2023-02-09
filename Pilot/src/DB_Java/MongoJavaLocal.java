package DB_Java;

import java.util.*;

import org.bson.Document;
import org.bson.conversions.Bson;

import static com.mongodb.client.model.Filters.*;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoJavaLocal {
	static MongoClient mc = new MongoClient("localhost", 27017);
	static MongoDatabase db = mc.getDatabase("Javadb");
	static List<Integer> ids = new ArrayList<>();

	public static Document file(int id, String name, int age, long phone, String address) {
		Document doc = new Document("id", id).append("Name", name).append("Age", age).append("Phone", phone)
				.append("Address", address);
		return doc;
	}

	public static String Capitalize(String name) {
		return name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
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
				boolean flag1 = true;
				int id = 0;
				while (flag1) {
					System.out.println("Enter an ID : ");
					id = in.nextInt();
					in.nextLine();
					if (ids.contains(id)) {
						System.out.println("This id exist.");
					} else {
						ids.add(id);
						flag1 = false;
					}
				}
				ids.add(id);
				System.out.print("Enter your name : ");
				String name = in.nextLine();
				System.out.print("Enter your age : ");
				int age = in.nextInt();
				System.out.print("Enter your phone number : ");
				long phone = in.nextLong();
				in.nextLine();
				System.out.print("Enter your address : ");
				String address = in.nextLine();
				currcol.insertOne(file(id, name, age, phone, address));
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

				BasicDBObject match = new BasicDBObject();
				BasicDBObject update = new BasicDBObject();
				BasicDBObject set = new BasicDBObject();

				System.out.print("Enter Update field : ");
				String field = Capitalize(in.nextLine());
				System.out.println("Enter the id to match : ");
//				String existing_value = in.nextLine();
				int mat_id = in.nextInt();
				in.nextLine();
				System.out.print("Enter Update value : ");
				String upd_value = in.nextLine();

				if (field.equals("Name") || field.equals("Address")) {
					match.put("id", mat_id);
					update.put(field, upd_value);
					set.put("$set", update.put(field, upd_value));
					currcol.updateOne(match, set);
				} else if (field.equals("Age")) {
					match.put("id", mat_id);
					update.put(field, Integer.valueOf(upd_value));
					set.put("$set", update);
					currcol.updateOne(match, set);
				} else if (field.equals("Phone")) {
					match.put("id", mat_id);
					update.put(field, Long.parseLong(upd_value));
					set.put("$set", update);
					currcol.updateOne(match, set);
				} else {
					System.out.println("Please check your update field.");
				}

				break;

			// Remove document
			case 4:
				System.out.println("Enter the id to delete : ");
				mat_id = in.nextInt();

					Bson del = eq("id", mat_id);
					currcol.deleteOne(del);
				
				break;

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
			System.err.println(e);
			System.out.println("Database connection failed.");
		}
	}

}
