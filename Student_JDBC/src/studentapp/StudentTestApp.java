package studentapp;

import java.sql.*;
import java.util.Scanner;

public class StudentTestApp {

    // JDBC URL for Oracle
    static final String JDBC_URL = "jdbc:oracle:thin:@192.168.1.5:1521:xe";
    static final String DB_USER = "system"; // change if using a different user
    static final String DB_PASSWORD = "admin"; // your Oracle password

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD)) {
            System.out.println("Connected to Oracle Database successfully!");

            while (true) {
                System.out.println("\n===== STUDENT_TEST MENU =====");
                System.out.println("1. Insert Student");
                System.out.println("2. View All Students");
                System.out.println("3. Update Student Age");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        insertStudent(conn, sc);
                        break;
                    case 2:
                        viewStudents(conn);
                        break;
                    case 3:
                        updateStudentAge(conn, sc);
                        break;
                    case 4:
                        deleteStudent(conn, sc);
                        break;
                    case 5:
                        System.out.println("Exiting program...");
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertStudent(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        String sql = "INSERT INTO STUDENT_TEST (ID, NAME, AGE) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, age);
            int rows = pstmt.executeUpdate();
            System.out.println(rows + " student(s) inserted.");
        }
    }

    private static void viewStudents(Connection conn) throws SQLException {
        String sql = "SELECT * FROM STUDENT_TEST";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\nID\tNAME\t\tAGE");
            System.out.println("--------------------------------");
            while (rs.next()) {
                System.out.println(rs.getInt("ID") + "\t" +
                                   rs.getString("NAME") + "\t" +
                                   rs.getInt("AGE"));
            }
        }
    }

    private static void updateStudentAge(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        System.out.print("Enter new Age: ");
        int age = sc.nextInt();

        String sql = "UPDATE STUDENT_TEST SET AGE = ? WHERE ID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, age);
            pstmt.setInt(2, id);
            int rows = pstmt.executeUpdate();
            System.out.println(rows + " student(s) updated.");
        }
    }

    private static void deleteStudent(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM STUDENT_TEST WHERE ID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            System.out.println(rows + " student(s) deleted.");
        }
    }
}
