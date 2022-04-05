package chess.dao;

import chess.db.MySqlConnector;
import chess.dto.BoardDto;
import chess.dto.PieceDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class BoardDao {

    private final Connection connection;

    public BoardDao() {
        this(MySqlConnector.getConnection());
    }

    public BoardDao(final Connection connection) {
        this.connection = connection;
    }

    public void save(final BoardDto board) {
        final String sql = "INSERT INTO board (game_id, position, type, color) values (?, ?, ?, ?)";

        final Map<String, PieceDto> pieces = board.getBoard();
        for (String position : pieces.keySet()) {
            savePiece(sql, board.getGameId(), position, pieces.get(position));
        }
    }

    public void savePiece(final String sql, final Integer gameId, final String position, final PieceDto piece) {
        try (final PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, gameId);
            statement.setString(2, position);
            statement.setString(3, piece.getType());
            statement.setString(4, piece.getColor());
            statement.execute();
        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateOnePosition(final Integer gameId, final String position, final PieceDto piece) {
        final String sql = "INSERT INTO board (game_id, position, type, color) VALUES (?, ?, ?, ?) ON DUPLICATE KEY UPDATE type = ?, color = ?";

        try (final PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, gameId);
            statement.setString(2, position);
            statement.setString(3, piece.getType());
            statement.setString(4, piece.getColor());
            statement.setString(5, piece.getType());
            statement.setString(6, piece.getColor());
            statement.execute();
        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }

    public BoardDto findByGameId(final Integer gameId) {
        final String sql = "SELECT * FROM board WHERE game_id = ?";

        try (final PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, gameId);

            final ResultSet resultSet = statement.executeQuery();
            final Map<String, PieceDto> board = new HashMap<>();
            while (resultSet.next()) {
                board.put(resultSet.getString("position"),
                        new PieceDto(resultSet.getString("type"), resultSet.getString("color")));
            }

            return new BoardDto(gameId, board);
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
