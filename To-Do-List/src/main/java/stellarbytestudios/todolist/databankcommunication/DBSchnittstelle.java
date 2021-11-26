package stellarbytestudios.todolist.databankcommunication;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import stellarbytestudios.todolist.datacontainer.ToDoListe;
import stellarbytestudios.todolist.datacontainer.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class DBSchnittstelle {
    // Initialcode
    private final JdbcTemplate dataBank;

    public DBSchnittstelle(JdbcTemplate db){
        this.dataBank = db;
    }


    // Methoden
    public void saveNewUser(String newUsername){
        String sqlSave = """
                insert into User (Username)
                values (?);
                """;
        dataBank.update(sqlSave, newUsername);
    }

    public User getUserByName(String username){
        String sqlget = """
                select *
                from User
                where Username = ?
                """;
        // Ziehen der Daten aus der Datenbank
        List<User> users= dataBank.query(sqlget,this::userMappper,username);

        // Passiert, wenn der Name nicht in der Datenbank ist
        if (users.size() != 1) { return null; }
        // Normalfall
        return users.get(0);
    }

    public ToDoListe getListFromUserID(int userID) {
        String sqlget = """
                select *
                from ToDoList
                where UserIDForegin = ?                
                """;
        // Ziehen der Liste aus der Datenbank
        List<ToDoListe> liste = dataBank.query(sqlget, this::listenMapper, userID);

        // Passiert, wenn der User noch keine Liste hat
        if (liste.size() != 1) { return null; }
        // Normalfall
        return liste.get(0);
    }

    // Mapper
    private User userMappper(ResultSet rs, int i) throws SQLException {
        int userID = rs.getInt(1);
        String username = rs.getString(2);

        return new User(userID, username);
    }

    private ToDoListe listenMapper(ResultSet rs, int i) throws SQLException {
        int listID = rs.getInt(1);
        int userID = rs.getInt(2);

        return new ToDoListe(listID, userID);
    }
}
