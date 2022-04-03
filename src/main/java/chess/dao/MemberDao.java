package chess.dao;

import chess.domain.Member;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {

    private static final String URL = "jdbc:mysql://localhost:3306/chess";
    private static final String USER = "user";
    private static final String PASSWORD = "password";

    public Connection getConnection() {
        loadDriver(); // 없어도 자동으로 로딩 됨
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (final SQLException exception) {
            exception.printStackTrace();
        }
        return connection;
    }

    private void loadDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public void save(final Member member) {
        final Connection connection = getConnection();
        final String sql = "insert into member (id, name) values (?, ?)";
        try {
            final PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, member.getId());
            statement.setString(2, member.getName());
            statement.execute();
        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }

    public Member findById(final String id) {
        final Connection connection = getConnection();
        final String sql = "select id, name from member where id = ?";
        try {
            final PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            final ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                return null;
            }
            return new Member(
                    resultSet.getString("id"),
                    resultSet.getString("name")
            );
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Member findWithRoleById(final String id) {
        // 3개 자원 회수 필요
        // 커넥션을 미리 2개정도 만들어서 사용한다. 캐싱, 커넥션 풀
        final Connection connection = getConnection();
        final String sql = "select id, name, type from member inner join role on member.id = role.user_id where id = ?";
        try {
            final PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            final ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                return null;
            }
            return new Member(
                    resultSet.getString("id"),
                    resultSet.getString("name")
                    // new Role(resultSet.getString("type"))
            );
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Member> findAll() {
        final Connection connection = getConnection();
        final String sql = "select id, name from member";
        final List<Member> members = new ArrayList<>();
        try {
            final Statement statement = connection.createStatement();
            final ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                members.add(new Member(
                        resultSet.getString("id"),
                        resultSet.getString("name")));
            }
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return members;
    }
}
