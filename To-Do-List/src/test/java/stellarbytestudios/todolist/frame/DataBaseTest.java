package stellarbytestudios.todolist.frame;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import stellarbytestudios.todolist.core.datacontainer.User;
import stellarbytestudios.todolist.frame.databankcommunication.DBSchnittstelle;

import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
@ActiveProfiles("test")
public class DataBaseTest {

    @Autowired
    JdbcTemplate db;


    @Test
    @Sql({
            "classpath:db/migration/V1__CreateSchema.sql",
            "classpath:db/migration/V2__AddSomeUsers.sql",
            "classpath:db/migration/V3__FirstListFor3Users.sql",
            "classpath:db/migration/V4__TwoUsersGetEntrysInList.sql"
    })
    @DisplayName("Man findet einen User richtig durch seine ID")
    void test_1(){
        // Arrange
        DBSchnittstelle repo = new DBSchnittstelle(db);
        // Act
        User user = repo.getUserByID(1);
        // Assert
        assertThat(user).isNotNull();
        assertThat(user.username()).isEqualTo("Martin");
    }


    @Test
    @Sql({"classpath:db/migration/V1__CreateSchema.sql", "classpath:db/migration/V2__AddSomeUsers.sql", "classpath:db/migration/V3__FirstListFor3Users.sql", "classpath:db/migration/V4__TwoUsersGetEntrysInList.sql"})
    @DisplayName("Man findet einen User richtig durch seinen Namen (Zwei verschiedene Namen)")
    void test_2(){
        // Arrange
        DBSchnittstelle repo = new DBSchnittstelle(db);
        // Act
        User martin = repo.getUserByName("Martin");
        User jana = repo.getUserByName("Jana");
        // Assert
        assertThat(martin).isNotNull();
        assertThat(martin.userID()).isEqualTo(1);
        assertThat(jana).isNotNull();
        assertThat(jana.userID()).isEqualTo(2);
    }

    @Test
    //@Sql({"classpath:db/migration/V1__CreateSchema.sql", "classpath:db/migration/V2__AddSomeUsers.sql", "classpath:db/migration/V3__FirstListFor3Users.sql", "classpath:db/migration/V4__TwoUsersGetEntrysInList.sql"})
    @DisplayName("Neuen Nutzer abspeichern und wiederfinden")
    void test_3(){
        // Arrange
        DBSchnittstelle repo = new DBSchnittstelle(db);
        // Act
        repo.saveNewUser("TestUser1");
        User user = repo.getUserByName("TestUser1");
        // Assert
        assertThat(user).isNotNull();
        assertThat(user.userID()).isNotNull();
    }
}
