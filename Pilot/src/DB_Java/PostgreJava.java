package DB_Java;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostgreJava {
	static Scanner in = new Scanner(System.in);
	static Connection c = null;

	public static long number() {

		long a = 0;
		try {
			a = in.nextInt();
			in.nextLine();
		} catch (Exception e) {
			System.out.print("Please enter a number : ");
			a = number();
		}
		return a;
	}

	public static String string() {
		String a = "";
		try {
			a = in.nextLine();
		} catch (Exception e) {
			System.out.print("Please enter a string : ");
			a = string();
		}
		return a;
	}

	public static void Operations() throws SQLException {
		List <Integer> ids = new ArrayList<>();
		boolean flag = true;
		while (flag) {
			System.out.println(
					"Enter 1 to Insert data.\nEnter 2 to Read data.\nEnter 3 to Update data.\nEnter 4 to Delete data.\nEnter 0 to exit");
			System.out.print("Enter your choice : ");
			int ent_op = in.nextInt();
			in.nextLine();

			switch (ent_op) {
			case 1:
				System.out.print("Enter id : ");
				int id = (int) number();
				ids.add(id);
				System.out.print("Enter name : ");
				String name = string();
				System.out.print("Enter age : ");
				int Age = (int) number();
				System.out.print("Enter phone : ");
				long phone = number();
				System.out.print("Enter address : ");
				String address = string();

				c.createStatement().executeUpdate("INSERT INTO COMPANY (ID,Name,Age,phone,Address) VALUES ('" + id
						+ "','" + name + "','" + Age + "','" + phone + "','" + address + "');");
				break;

			case 2:
				ResultSet temp = c.createStatement().executeQuery("SELECT * FROM Company;");
				while (temp.next()) {
					System.out.println("ID = " + temp.getInt("ID"));
					System.out.println("Name = " + temp.getString("Name"));
					System.out.println("Age = " + temp.getInt("Age"));
					System.out.println("Phone = " + temp.getLong("phone"));
					System.out.println("Address = " + temp.getString("Address"));
					System.out.println();
				}
				break;

			case 3:
				@SuppressWarnings("unused") int a = 0;
				System.out.print("Enter the ID : ");
				id = (int) number();
				if(ids.contains(id)) {
					System.out.print("Enter field to be updated : ");
					String upd_field = string();

					if (upd_field.equals("name")) {
						System.out.print("Enter updated name : ");
						name = string();
						a = c.createStatement()
								.executeUpdate("UPDATE Compnay SET Name = '" + name + "' WHERE ID = '" + id + "';");
					} else if (upd_field.equals("age")) {
						System.out.print("Enter updated age : ");
						Age = (int) number();
						a = c.createStatement()
								.executeUpdate("UPDATE Company SET Age = '" + Age + "' WHERE ID = '" + id + "';");
					} else if (upd_field.equals("phone")) {
						System.out.print("Enter updated phone : ");
						phone = number();
						a = c.createStatement()
								.executeUpdate("UPDATE Company SET phone = '" + phone + "' WHERE ID = '" + id + "';");
					} else if (upd_field.equals("address")) {
						System.out.print("Enter updated address : ");
						address = string();
						a = c.createStatement()
								.executeUpdate("UPDATE Company SET Address = '" + address + "' WHERE ID = '" + id + "';");
					} else {
						System.out.println("Please enter correct field");
					}
				}
				else {
					System.out.println("This ID dosent exist.");
				}
				
				break;

			case 4:
				System.out.print("Enter ID to delete : ");
				id = (int) number();
				if(ids.contains(id)) {
					@SuppressWarnings("unused") int b = c.createStatement().executeUpdate("DELETE FROM Company WHERE ID = '" + id + "' ");	
					ids.remove(id);
				}
				else {
					System.out.println("This ID dosent exist.");
				}
				break;

			case 0:
				flag = false;
				break;

			default:
				System.out.println("Please check your input.");
			}

		}
	}

	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/java_pg", "postgres", "123456");
			System.out.println("Database connected successfully");

			Operations();

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + " : " + e.getMessage());
			System.exit(0);
		}

		in.close();
	}
}
