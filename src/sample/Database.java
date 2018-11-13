package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    static final String DB_URL = "jdbc:sqlserver://CoT-CIS3365-12.cougarnet.uh.edu:1433;database=PrimaryPluming_ParagonTechDB";
    static final String USER = "cbknight";
    static final String PASS = "fuckyou12";

    public Database() {
    }

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection("jdbc:sqlserver://CoT-CIS3365-12.cougarnet.uh.edu:1433;database=PrimaryPluming_ParagonTechDB", "cbknight", "fuckyou12");
            System.out.println("Loading database...");
            stmt = conn.createStatement();
            System.out.println("Database sql statement successfully...");
        } catch (SQLException var19) {
            var19.printStackTrace();
        } catch (Exception var20) {
            var20.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException var18) {
                ;
            }

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException var17) {
                var17.printStackTrace();
            }

        }

        System.out.println("Goodbye!");
    }
}
