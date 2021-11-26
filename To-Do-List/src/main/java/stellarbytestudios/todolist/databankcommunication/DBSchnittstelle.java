package stellarbytestudios.todolist.databankcommunication;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import stellarbytestudios.todolist.datacontainer.User;

@Component
public class DBSchnittstelle {
    // Initialcode
    private final JdbcTemplate dataBank;

    public DBSchnittstelle(JdbcTemplate db){
        this.dataBank = db;
    }

    // Methoden
    public void saveNewUser(User newUser){
        String sqlSave = """
                insert into User (Username)
                values (?);
                """;
        dataBank.update(sqlSave, newUser.username());
    }


    // Mapper

}
