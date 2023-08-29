import org.junit.Test;

import java.sql.*;

public class DbTest {
    @Test
    public void test (){
        String url = String.format(
                "jdbc:mysql://%s:%s/%s",
                "localhost",
                "3306",
                "opencart-db"
        );
        String username = "opencart";
        String password = "opencart";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            ///////-INSERT-/////
            String insertQuery = "INSERT INTO homework_user_data (first_name, last_name) VALUES (?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setString(1, "Sammie");
            insertStatement.setString(2, "Smith");
            insertStatement.executeUpdate();
            insertStatement.close();

            String insertQuery2 = "INSERT INTO homework_user_data (first_name, last_name) VALUES (?, ?)";
            PreparedStatement insertStatement2 = connection.prepareStatement(insertQuery2);
            insertStatement2.setString(1, "Samantha");
            insertStatement2.setString(2, "Jones");
            insertStatement2.executeUpdate();
            insertStatement2.close();

            String insertQuery3 = "INSERT INTO homework_user_data (first_name, last_name) VALUES (?, ?)";
            PreparedStatement insertStatement3 = connection.prepareStatement(insertQuery3);
            insertStatement3.setString(1, "Barry");
            insertStatement3.setString(2, "Golds");
            insertStatement3.executeUpdate();
            insertStatement3.close();


            //////-SELECT-/////
            String updateQuery = "UPDATE homework_user_data SET first_name = ? WHERE last_name = ?";
            PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
            updateStatement.setString(1, "Annie");
            updateStatement.setString(2, "Smith");
            updateStatement.executeUpdate();
            updateStatement.close();

            //////-SELECT-/////
            String selectQuery = "SELECT * FROM homework_user_data ";
            PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                String column1Value = resultSet.getString("first_name");
                String column2Value = resultSet.getString("last_name");
                System.out.println("First Name: " + column1Value + ", Last Name: " + column2Value);
            }
            resultSet.close();
            selectStatement.close();

            //////-DELETE-/////
            String deleteQuery = "DELETE FROM homework_user_data WHERE id = ?";
            PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
            deleteStatement.setInt(1, 7);
            deleteStatement.executeUpdate();
            deleteStatement.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException("Could not connect to database", e);
        }
    }
}
