package DB_Java;

import java.sql.Connection;
import java.sql.DriverManager;

public class PostgreJava {
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Connection c = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5050/java_pg","postgres","123456");
			System.out.println("Database connected successfully");
		} catch(Exception e) {
			System.out.print("Heloooooooo!");
			e.printStackTrace();
			System.err.println(e.getClass().getName()+" : "+e.getMessage());
			System.exit(0);
		}

	}

}
