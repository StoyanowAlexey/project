import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToDataBase {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String login = "postgres";
    private static final String password = "31416";

    public static Connection ConnectionToDataBase () throws SQLException {
         return DriverManager.getConnection(URL,login,password);
    }
}
