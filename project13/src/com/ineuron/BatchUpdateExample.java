package com.ineuron;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;

import com.ineuron.utility.JdbcUtility;

public class BatchUpdateExample {
    public static void main(String[] args) {
        String inputFile = "input.txt";

        try {
            Connection connection = JdbcUtility.getConnection();

            Statement statement = connection.createStatement();

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                int age = Integer.parseInt(data[2].trim());

                String sql = "INSERT INTO mytable (id, name, age) VALUES (" + id + ", '" + name + "', " + age + ")";
                statement.addBatch(sql);
            }
            reader.close();

            int[] results = statement.executeBatch();

            int totalRecords = results.length;
            int totalSuccess = 0;
            int totalFailure = 0;
            for (int result : results) {
                if (result >= 0) {
                    totalSuccess++;
                } else {
                    totalFailure++;
                }
            }

            System.out.println("Batch update completed:");
            System.out.println("Total Records: " + totalRecords);
            System.out.println("Successful Updates: " + totalSuccess);
            System.out.println("Failed Updates: " + totalFailure);

            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection error.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error reading input file.");
            e.printStackTrace();
        }
    }
}
