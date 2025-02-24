package Task4;
import java.sql.*;
import java.util.Scanner;

public class Task1 {

    private static final String url = "jdbc:mysql://localhost:3306/sys";
    private static final String username = "root";
    private static final String password = "**********";

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(url,username,password);
             Scanner sc = new Scanner(System.in)) {
            
            while (true) {
                System.out.println("\nMENU");
                System.out.println("1. Insert a new Row");
                System.out.println("2. Update a Row");
                System.out.println("3. Delete a Row");
                System.out.println("4. Select a Row");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                
                int choice = sc.nextInt();
                sc.nextLine(); 
                
                switch (choice) {
                    case 1:
                        insertRows(con, sc);
                        break;
                    case 2:
                        updateRow(con, sc);
                        break;
                    case 3:
                        deleteRow(con, sc);
                        break;
                    case 4:
                        selectRow(con, sc);
                        break;
                    case 5:
                        System.out.println("Exiting program.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Task 1: Recursively Insert Multiple Rows Using PreparedStatement
    private static void insertRows(Connection con, Scanner sc) throws SQLException {
        String sql = "INSERT INTO Student (column1, column2) VALUES (?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            while (true) {
                System.out.print("Enter value for column1: ");
                String col1 = sc.nextLine();
                System.out.print("Enter value for column2: ");
                String col2 = sc.nextLine();

                pstmt.setString(1, col1);
                pstmt.setString(2, col2);
                pstmt.executeUpdate();

                System.out.print("Do you want to insert another row? (yes/no): ");
                if (!sc.nextLine().equalsIgnoreCase("yes")) {
                    break;
                }
            }
        }
    }

    // Task 2: Update a Row Using Scanner
    private static void updateRow(Connection con, Scanner sc) throws SQLException {
        String sql = "UPDATE Student SET column1 = ? WHERE id = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            System.out.print("Enter row ID to update: ");
            int id = sc.nextInt();
            sc.nextLine(); 
            System.out.print("Enter new value for column1: ");
            String Value = sc.nextLine();

            pst.setString(1, Value);
            pst.setInt(2, id);

            int rowsAffected = pst.executeUpdate();
            System.out.println(rowsAffected + " row(s) updated.");
        }
    }

    // Task 3: Delete a Row Using Scanner
    private static void deleteRow(Connection con, Scanner sc) throws SQLException {
        String sql = "DELETE FROM Student WHERE id = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            System.out.print("Enter row ID to delete: ");
            int id = sc.nextInt();
            sc.nextLine(); 

            pst.setInt(1, id);

            int rowsAffected = pst.executeUpdate();
            System.out.println(rowsAffected + " row(s) deleted.");
        }
    }

    // Task 4: Select a Row Using Scanner
    private static void selectRow(Connection con, Scanner sc) throws SQLException {
        String sql = "SELECT * FROM Student WHERE id = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            System.out.print("Enter row ID to select: ");
            int id = sc.nextInt();
            sc.nextLine(); 

            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Column1: " + rs.getString("column1"));
                System.out.println("Column2: " + rs.getString("column2"));
            }
        }
    }
}
