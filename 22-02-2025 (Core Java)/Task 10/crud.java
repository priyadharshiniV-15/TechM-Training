import java.sql.*;
import java.util.Scanner;

public class JDBCCRUD {

    private static final String URL = "jdbc:mysql://localhost:3306/sys";
    private static final String USER = "root";
    private static final String PASSWORD = "**********";

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Scanner scanner = new Scanner(System.in)) {

            createTable(con); 

            while (true) {
                System.out.println("\n==== CRUD Operations Menu ====");
                System.out.println("1. Insert Data");
                System.out.println("2. Read Data");
                System.out.println("3. Update Data");
                System.out.println("4. Delete Data");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        insertData(con, scanner);
                        break;
                    case 2:
                        readData(con);
                        break;
                    case 3:
                        updateData(con, scanner);
                        break;
                    case 4:
                        deleteData(con, scanner);
                        break;
                    case 5:
                        System.out.println("Exiting program.");
                        return;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Create Table if it does not exist
    private static void createTable(Connection con) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS employees ("
                   + "id INT PRIMARY KEY AUTO_INCREMENT, "
                   + "name VARCHAR(100), "
                   + "age INT, "
                   + "department VARCHAR(50))";
        try (Statement stmt = con.createStatement()) {
            stmt.executeUpdate(sql);
        }
    }

    // 1. Insert Data
    private static void insertData(Connection con, Scanner scanner) throws SQLException {
        String sql = "INSERT INTO employees (name, age, department) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Enter Department: ");
            String department = scanner.nextLine();

            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, department);

            int rowsInserted = pstmt.executeUpdate();
            System.out.println(rowsInserted + " row(s) inserted.");
        }
    }

    // 2. Read Data
    private static void readData(Connection con) throws SQLException {
        String sql = "SELECT * FROM employees";
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n==== Employee Records ====");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Department: " + rs.getString("department"));
                System.out.println("---------------------------");
            }
        }
    }

    // 3. Update Data
    private static void updateData(Connection con, Scanner scanner) throws SQLException {
        String sql = "UPDATE employees SET name = ?, age = ?, department = ? WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            System.out.print("Enter Employee ID to Update: ");
            int id = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Enter New Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter New Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Enter New Department: ");
            String department = scanner.nextLine();

            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, department);
            pstmt.setInt(4, id);

            int rowsUpdated = pstmt.executeUpdate();
            System.out.println(rowsUpdated + " row(s) updated.");
        }
    }

    // 4. Delete Data
    private static void deleteData(Connection con, Scanner scanner) throws SQLException {
        String sql = "DELETE FROM employees WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            System.out.print("Enter Employee ID to Delete: ");
            int id = scanner.nextInt();
            scanner.nextLine(); 

            pstmt.setInt(1, id);
            int rowsDeleted = pstmt.executeUpdate();
            System.out.println(rowsDeleted + " row(s) deleted.");
        }
    }
}
