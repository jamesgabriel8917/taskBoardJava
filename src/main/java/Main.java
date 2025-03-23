import board.persistence.migration.MigrationStrategy;

import java.sql.SQLException;

import static board.persistence.config.ConectionConfig.getConnection;

public class Main {

    public static void main(String[] args) throws SQLException {
        try(var connection = getConnection()){
            new MigrationStrategy(connection).executeMigration();
        }
    }
}
