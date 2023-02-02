package DB_Java;

import java.util.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.Document;


public class MongoJavaAtlas {
	public static void main(String []args) {
		String constr = System.getProperty("mongodb+srv://mathesh31:<Mathesh#349>@projectmat.exdo8r7.mongodb.net/?retryWrites=true&w=majority");
		try (MongoClient mongoClient = MongoClients.create(constr)) {
			List <Document> database = mongoClient.listDatabases().into(new ArrayList<>());
			database.forEach(db -> System.out.println(db.toJson()));
		}
	}
}
