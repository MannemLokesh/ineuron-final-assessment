package in.ineuron;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ineuron.utility.JdbcUtility;

@WebServlet("/userlist")
public class UserListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = JdbcUtility.getConnection();

            statement = connection.createStatement();

            String sql = "SELECT * FROM student";
            resultSet = statement.executeQuery(sql);

            response.setContentType("text/html");

            PrintWriter out = response.getWriter();

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Student List</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Student List</h1>");
            out.println("<table>");
            out.println("<tr><th>ROLL</th><th>CITY</th><th>NAME</th></tr>");
            
            while (resultSet.next()) {
                int roll = resultSet.getInt("roll");
                String name = resultSet.getString("name");
                String city = resultSet.getString("city");
                
                out.println("<tr><td>" + roll + "</td><td>" + city + "</td><td>" + name + "</td></tr>");
            }
            
            out.println("</table>"); 
            out.println("</body>");
            out.println("</html>");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection error.");
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing database resources.");
                e.printStackTrace();
            }
        }
    }
}
