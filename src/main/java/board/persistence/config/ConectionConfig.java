package board.persistence.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ConectionConfig {

    public static Connection getConnection() throws SQLException {
        var connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/board", "root", "mypassword");
        return connection;
    };

}
