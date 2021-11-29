package stellarbytestudios.todolist.databankcommunication;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import stellarbytestudios.todolist.datacontainer.ListEntity;
import stellarbytestudios.todolist.datacontainer.ToDoListe;
import stellarbytestudios.todolist.datacontainer.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DBSchnittstelle {
    // Initialcode
    private final JdbcTemplate dataBank;

    public DBSchnittstelle(JdbcTemplate db){
        this.dataBank = db;
    }


    // * * * Methoden * * * //

    /* save Methods */
    // Neuen Nutzer Speichern
    public void saveNewUser(String newUsername){
        String sqlSave = """
                insert into User (Username)
                values (?);
                """;
        dataBank.update(sqlSave, newUsername);
    }

    // Einem Nutzer (ID) eine neue Liste geben
    public void saveNewList(int id){
        String sqlSave = """
                insert into ToDoList (UserIDForegin)
                values (?);              
                """;
        dataBank.update(sqlSave, id);
    }

    // Einen neuen Eintrag in einer Liste anlegen
    public void saveNewListEntity(int listid, String task){
        String sqlSave = """
                insert into ListEntity (ListeIDForegin, DisplayName)
                values (?,?);              
                """;
        dataBank.update(sqlSave, listid, task);
    }

    /* get Methods */
    // Nutzer durch den Namen aus der Datenbank holen
    public User getUserByName(String username){
        String sqlget = """
                select *
                from User
                where Username = ?;
                """;
        // Ziehen der Daten aus der Datenbank
        List<User> users= dataBank.query(sqlget, DBSchnittstelle::userMappper,username);

        // Passiert, wenn der Name nicht in der Datenbank ist
        if (users.size() != 1) { return null; }
        // Normalfall
        return users.get(0);
    }

    // User mithilfe seiner ID aus der Datenbank fischen
    public User getUserByID(int userID) {
        String sqlget = """
                select *
                from User
                where UserID = ?;
                """;
        // Ziehen der Daten aus der Datenbank
        List<User> users= dataBank.query(sqlget, DBSchnittstelle::userMappper,userID);

        // Passiert, wenn der Name nicht in der Datenbank ist
        if (users.size() != 1) { return null; }
        // Normalfall
        return users.get(0);
    }

    // Liste eines Nutzers aus der Datenbank holen
    public ToDoListe getListFromUserID(int userID) {
        String sqlget = """
                select *
                from ToDoList
                where UserIDForegin = ?;              
                """;
        // Ziehen der Liste aus der Datenbank
        List<ToDoListe> liste = dataBank.query(sqlget, DBSchnittstelle::listenMapper, userID);

        // Passiert, wenn der User noch keine Liste hat
        if (liste.size() != 1) { return null; }

        // Normalfall
        return liste.get(0);
    }

    // Bekomme alle Einträge einer Liste
    public List<ListEntity> getListOfEntitys(int listID) {
        String sqlget = """
                select *
                from ListEntity
                where ListeIDForegin = ?;              
                """;
        // Ziehen der Liste aus der Datenbank
        List<ListEntity> einträge = dataBank.query(sqlget, DBSchnittstelle::entityMapper, listID);

        // Normalfall
        return einträge;
    }



    // * * * Mapper * * * //
    private static User userMappper(ResultSet rs, int i) throws SQLException {
        int userID = rs.getInt(1);
        String username = rs.getString(2);

        return new User(userID, username);
    }

    private static ToDoListe listenMapper(ResultSet rs, int i) throws SQLException {
        int listID = rs.getInt(1);
        int userID = rs.getInt(2);

        return new ToDoListe(listID, userID);
    }

    private static ListEntity entityMapper(ResultSet rs, int i) throws SQLException {
        int id = rs.getInt(1);
        String task = rs.getString(2);
        boolean done = rs.getBoolean(3);
        int listID = rs.getInt(4);

        return new ListEntity(id, task, done, listID);
    }


}
