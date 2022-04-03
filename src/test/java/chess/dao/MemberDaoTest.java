package chess.dao;

import static org.assertj.core.api.Assertions.assertThat;

import chess.domain.Member;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.junit.jupiter.api.Test;

class MemberDaoTest {

//    @Test
//    void connection() {
//        final MemberDao memberDao = new MemberDao();
//        final Connection connection = memberDao.getConnection();
//        assertThat(connection).isNotNull();
//    }
//
//    @Test
//    void save() {
//        final MemberDao memberDao = new MemberDao();
//        memberDao.save(new Member("ellie", "한해리"));
//    }
//
//    @Test
//    void saveWithRollback() throws SQLException {
//        final MemberDao memberDao = new MemberDao();
//        final Connection connection = memberDao.getConnection();
//        connection.setAutoCommit(false);
//        memberDao.save(new Member("lisa","라리사"));
//        connection.rollback();
//    }
//
//    @Test
//    void findById() {
//        final MemberDao memberDao = new MemberDao();
//        final Member member = memberDao.findById("ellie");
//        assertThat(member.getName()).isEqualTo("한해리");
//    }
//
//    @Test
//    void findWithRoleById() {
//        final MemberDao memberDao = new MemberDao();
//        final Member member = memberDao.findById("ellie");
//        assertThat(member.getName()).isEqualTo("한해리");
//    }
//
//    @Test
//    void findAll() {
//        final MemberDao memberDao = new MemberDao();
//        final List<Member> members = memberDao.findAll();
//        assertThat(members).isNotEmpty();
//    }
}
