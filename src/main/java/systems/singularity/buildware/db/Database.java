package systems.singularity.buildware.db;

import systems.singularity.buildware.Main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.prefs.Preferences;

public final class Database {
    private static Connection connection;

    static {
        try {
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());

            Database.initializeDatabase();
            Database.initializeTables();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Database() {
        // Avoid class instantiation
    }

    private static void initializeDatabase() throws SQLException {
        Preferences prefs = Preferences.userNodeForPackage(Main.class);
        String url = String.format("jdbc:oracle:thin:@%s:%s:%s", prefs.get("hostConnection", "oracle11g.cin.ufpe.br"), prefs.get("portConnection", "1521"), prefs.get("sidConnection", "Instance01"));
        Database.connection = DriverManager.getConnection(url, prefs.get("userConnection", "g172if686cc_eq01"), prefs.get("passwordConnection", "rwzgrjls"));
        Database.connection.setAutoCommit(true);
    }

    private static void initializeTables() throws SQLException, IOException {
        Statement statement = Database.connection.createStatement();
        // TODO: CREATE TABLE IF NOT EXISTS
    }

    public static Connection getConnection() throws SQLException {
        if (Database.connection.isClosed())
            Database.initializeDatabase();

        return Database.connection;
    }

    public static boolean verifyConnection(String host, String port, String sid, String user, String password) {
        try {
            Connection conn = DriverManager.getConnection(String.format("jdbc:oracle:thin:@%s:%s:%s", host, port, sid), user, password);
            return conn.isValid(8);
        } catch (SQLException e) {
            return false;
        }
    }
}
