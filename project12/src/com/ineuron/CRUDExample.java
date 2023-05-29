package com.ineuron;
import java.sql.*;
import java.util.Scanner;

import com.ineuron.utility.JdbcUtility;

public class CRUDExample {
    public static void main(String[] args) 
    {
        try 
        {
            Connection connection =JdbcUtility.getConnection();

            Statement statement = connection.createStatement();

            Scanner scanner = new Scanner(System.in);

            int choice;
            do {
                System.out.println("\n***** CRUD Operations *****");
                System.out.println("1. Add Record");
                System.out.println("2. View Records");
                System.out.println("3. Update Record");
                System.out.println("4. Delete Record");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        addRecord(statement, scanner);
                        break;
                    case 2:
                        viewRecords(statement);
                        break;
                    case 3:
                        updateRecord(statement, scanner);
                        break;
                    case 4:
                        deleteRecord(statement, scanner);
                        break;
                    case 0:
                        System.out.println("Exiting the program.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 0);

            statement.close();
            connection.close();
            scanner.close();
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection error.");
            e.printStackTrace();
        }
    }

    public static void addRecord(Statement statement, Scanner scanner) throws SQLException 
    {
        System.out.println("\n***** Add Record *****");

        System.out.print("Enter name: ");
        String name = scanner.next();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        String sql = "INSERT INTO user_table (name, age) VALUES ('" + name + "', " + age + ")";
        int rowsAffected = statement.executeUpdate(sql);

        if (rowsAffected > 0) {
            System.out.println("Record added successfully.");
        } else {
            System.out.println("Failed to add record.");
        }
    }

    public static void viewRecords(Statement statement) throws SQLException 
    {
        System.out.println("\n***** View Records *****");

        String sql = "SELECT * FROM user_table";
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");

            System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
        }

        resultSet.close();
    }

    public static void updateRecord(Statement statement, Scanner scanner) throws SQLException 
    {
        System.out.println("\n***** Update Record *****");

        System.out.print("Enter the ID of the record to update: ");
        int id = scanner.nextInt();

        System.out.print("Enter new name: ");
        String name = scanner.next();

        System.out.print("Enter new age: ");
        int age = scanner.nextInt();

        String sql = "UPDATE user_table SET name = '" + name + "', age = " + age + " WHERE id = " + id;
        int rowsAffected = statement.executeUpdate(sql);

        if (rowsAffected > 0) {
            System.out.println("Record updated successfully.");
        } else {
            System.out.println("Failed to update record. Invalid ID.");
        }
    }

    public static void deleteRecord(Statement statement, Scanner scanner) throws SQLException 
    {
        System.out.println("\n***** Delete Record *****");

        System.out.print("Enter the ID of the record to delete: ");
        int id = scanner.nextInt();

        String sql = "DELETE FROM user_table WHERE id = " + id;
        int rowsAffected = statement.executeUpdate(sql);

        if (rowsAffected > 0) {
            System.out.println("Record deleted successfully.");
        } else {
            System.out.println("Failed to delete record. Invalid ID.");
        }
    }
}
