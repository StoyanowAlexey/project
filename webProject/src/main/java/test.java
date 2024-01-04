import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test {
    public static void main(String [] args) throws SQLException {
        Connection connection = ConnectionToDataBase.ConnectionToDataBase();
        Statement statement = connection.createStatement();
        String shema = "my_shema";
        //String sql = "SET search_path TO " + shema;
        statement.execute("SET search_path TO my_shema");
        ResultSet result = statement.executeQuery("SELECT * FROM base_information");
        while (result.next()){
            String email = result.getString(1);
            String password = result.getString(2);
            System.out.println(result.getRow() + ": " + email + " " + password);
        }
        statement.executeUpdate("INSERT INTO base_information(email, password) VALUES ('misha@gmail.com', 'burirum')");
    }
}
