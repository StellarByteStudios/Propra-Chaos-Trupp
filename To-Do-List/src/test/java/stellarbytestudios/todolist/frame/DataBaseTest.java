package stellarbytestudios.todolist.frame;

//
//@JdbcTest
//@ActiveProfiles("test")
//public class DataBaseTest {
//
//    @Autowired
//    JdbcTemplate db;
//
//
//    @Test
//    @Sql({
//          "classpath:db/migration/V1__CreateSchema.sql",
//          "classpath:db/migration/V2__AddSomeUsers.sql",
//          "classpath:db/migration/V3__FirstListFor3Users.sql",
//          "classpath:db/migration/V4__TwoUsersGetEntrysInList.sql"
//    })
//    @DisplayName("Man findet einen User richtig durch seine ID")
//    void test_1(){
//        DBSchnittstelle repo = new DBSchnittstelle(db);
//        User user = repo.getUserByID(1);
//        assertThat(user).isNotNull();
//        assertThat(user.username()).isEqualTo("Martin");
//    }
//}
