package board.persistence.dao;

import board.persistence.entity.BoardEntity;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

@AllArgsConstructor
public class BoardDAO {

    private final Connection connection;

    public BoardDAO(Connection connection) {
        this.connection = connection;
    }

    private BoardEntity insert(final BoardEntity entity) throws SQLException {

    }

    private BoardEntity delete(final Long id) throws SQLException {

    }


    private Optional<BoardEntity> findById(final Long id) throws SQLException {
        var sql = "SELECT id, name FROM BOARDS WHERE id = ?";
        try(var statement = connection.prepareStatement(sql)){
            statement.setLong( 1, id);
            statement.executeQuery();
            var resultSet = statement.getResultSet();

            if (resultSet.next()){
                var entity = new BoardEntity();
                entity.setId(resultSet.getLong("id"));
            }
            return Optional.empty();
        }
    }

    private boolean exists(final Long id) throws SQLException {
       var sql = "SELECT 1 FROM BOARDS WHERE id = ?";
        try(var statement = connection.prepareStatement(sql)){
            statement.setLong( 1, id);
            statement.executeQuery();
            return statement.getResultSet().next();
        }
    }



}
