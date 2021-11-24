package tictactoe.database;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import tictactoe.game.Game;

import java.sql.ResultSet;

import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
@ActiveProfiles("test")
public class GameRepositoryTest {
    @Autowired
    JdbcTemplate db;

    private static Game gameMapper(ResultSet a, int b) {
        return null;
    }


    @Test
    @Sql({"classpath:init.sql","classpath:loadtest.sql"})
    @DisplayName("Teste, ob Datenbank vorhanden")
    void test_01(){
        String sql = "SELECT * FROM game";
        db.query(sql, GameRepositoryTest::gameMapper);
    }

    @Test
    @Sql({"classpath:init.sql","classpath:loadtest.sql"})
    @DisplayName("")
    void test_02(){

        String gameId = "ee10c6f6-ae99-4873-9e52-440df96f647f";
        GameRepositoryImpl repo = new GameRepositoryImpl(db);
        Game game = repo.loadGame(gameId);

        assertThat(game.id()).isEqualTo(gameId);
    }
}
