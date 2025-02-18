package Database;

import java.sql.*;
import java.util.Scanner;

public class Employees {

	static String url = "jdbc:mysql://localhost:3306/sys";
	static String username = "root";
	static String password = "priya1509@";

	public static void main(String[] args) throws SQLException {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter your Choice: 1.Create 2.Select 3.Update 4.Delete");
		int ch = sc.nextInt();
		switch (ch) {
		case 1: {
			System.out.println("Do you want to create a table or insert the elements? \n 1.Table 2.Insert");
			int a = sc.nextInt();
			if (a == 1) {
				createtable();
			} else if (a == 2) {
				System.out.println("Enter the details to be inserted:");
				int empid = sc.nextInt();
				sc.nextLine(); // Consume newline
				String name = sc.nextLine();
				String email = sc.nextLine();
				String position = sc.nextLine();
				double salary = sc.nextDouble();
				insertdetails(empid, name, email, position, salary);
			} else
				System.out.println("Invalid choice!");
			break;

		}
		case 2:
			SelectRecords();
			break;
		case 3:

			UpdateValues(sc);
			break;

		case 4:
			deletevalues(sc);
			break;
		}
		sc.close();

	}

	public static void createtable() throws SQLException {
		String query = "create table IF NOT EXISTS employees(" + "empid int PRIMARY KEY AUTO_INCREMENT,"
				+ "name varchar(20)," + "email varchar(50)," + "position varchar(10)," + "salary decimal(10,2))";
		Connection con = DriverManager.getConnection(url, username, password);
		Statement st = con.createStatement();
		st.executeUpdate(query);
		System.out.println("Table created Successfully.");
		con.close();
	}

	public static void insertdetails(int empid, String name, String email, String position, double salary)
			throws SQLException {

		String query = "INSERT INTO employees (empid, name, email, position, salary) VALUES (?, ?, ?, ?, ?)";
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement pst = con.prepareStatement(query);
		{
			pst.setInt(1, empid);
			pst.setString(2, name);
			pst.setString(3, email);
			pst.setString(4, position);
			pst.setDouble(5, salary);
			int row = pst.executeUpdate();
			System.out.println("Values inserted successfully." + "rows affected:" + row);

			con.close();
		}

	}

	public static void SelectRecords() throws SQLException {
		String query = "select * from employees";
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement pst = con.prepareStatement(query);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			System.out.println(" " + rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " "
					+ rs.getString(4) + " " + rs.getDouble(5));
		}
		con.close();
	}

	public static void UpdateValues(Scanner sc) throws SQLException {
		System.out.println("Enter Employee ID to update salary:");
		int empid = sc.nextInt();
		System.out.println("Enter new salary:");
		double salary = sc.nextDouble();

		String query = "update employees set salary=" + salary + " where empID=" + empid + ";";

		Connection con = DriverManager.getConnection(url, username, password);
		Statement st = con.createStatement();

		System.out.println("Number of rows affected:" + st.executeUpdate(query));
		con.close();
	}

	public static void deletevalues(Scanner sc) throws SQLException {
		System.out.println("Enter Employee ID to delete:");
		int empid = sc.nextInt();
		String query = "delete from employees where empid=" + empid + ";";
		Connection con = DriverManager.getConnection(url, username, password);
		Statement st = con.createStatement();
		int row = st.executeUpdate(query);
		System.out.println("Rows affected:" + row);

		con.close();
	}

}
