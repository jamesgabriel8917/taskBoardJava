package board.persistence.dao;

import board.persistence.entity.BoardColumnEntity;
import board.persistence.entity.BoardColumnKindEnum;
import board.persistence.entity.BoardEntity;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class BoardColumnDAO {

    private final Connection connection;

    public BoardColumnEntity insert(final BoardColumnEntity entity){
        var sql = "INSERT INTO BOARDS_COLUMNS (name, order, kind, board_id) VALUES (?, ?, ?, ?);";

        try (var statement = connection.prepareStatement(sql)){
            var i =1;
            statement.setString(i++, entity.getName());
            statement.setInt(i++, entity.getOrder());
            statement.setString(i++, entity.getKind().name());
            statement.setLong(i++, entity.getBoard().getId());

            statement.executeUpdate();

            return entity;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<BoardColumnEntity> findByBoardId(Long id) throws SQLException {
        List<BoardColumnEntity> entities = new ArrayList<>();
        var sql = "SELECT id, name, order FROM BOARD_COLUMNS WHERE board_id = ? ORDER BY ORDER";

        try (var statement = connection.prepareStatement(sql)){
            statement.setLong(1, id);
            statement.executeQuery();

            var resultSet = statement.getResultSet();

            while (resultSet.next()) {
                var entity = new BoardColumnEntity();

                entity.setId(resultSet.getLong("id"));
                entity.setName(resultSet.getNString("name"));
                entity.setOrder(resultSet.getInt("order"));
                entity.setKind(BoardColumnKindEnum.findByName(resultSet.getString("kind")));
                entities.add(entity);
            }
            return entities;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }
}
