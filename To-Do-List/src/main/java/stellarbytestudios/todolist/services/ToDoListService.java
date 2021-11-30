package stellarbytestudios.todolist.services;

import org.springframework.stereotype.Service;
import stellarbytestudios.todolist.frame.databankcommunication.DBSchnittstelle;
import stellarbytestudios.todolist.core.datacontainer.ListEntity;
import stellarbytestudios.todolist.core.datacontainer.ToDoListe;
import stellarbytestudios.todolist.core.datacontainer.User;

import java.util.List;

@Service
public class ToDoListService {
    // Initialcode
    private final DBSchnittstelle dataSchnittstelle;

    public ToDoListService(DBSchnittstelle db) {
        this.dataSchnittstelle = db;
    }


    // * * * Methoden * * * //
    // Neuen User in Datenbank speichern
    public void saveNewUser(String newUsername){
        dataSchnittstelle.saveNewUser(newUsername);
    }

    // Neuen Eintrag in
    public void setNewEntryInList(ToDoListe liste, String task) {
        dataSchnittstelle.saveNewListEntity(liste.ListID(), task);
    }

    // Hohle einen User aus der Datenbank mithilfe seines Namens
    public User getUserByName(String name){
        User user = dataSchnittstelle.getUserByName(name);
        return user;
    }

    // Hole einen User anhand seiner ID
    public User getUserById(int userID) {
        User user = dataSchnittstelle.getUserByID(userID);
        return user;
    }

    // Hohle die Liste eines Users aus der Datenbank
    public ToDoListe getListFromUser(User user) {
        ToDoListe liste = dataSchnittstelle.getListFromUserID(user.userID());
        // Der User hat keine Liste
        if (liste == null){
            // Neue Liste wird angelegt und wieder aus der Datenbank geholt
            dataSchnittstelle.saveNewList(user.userID());
            liste = dataSchnittstelle.getListFromUserID(user.userID());
        }
        return liste;
    }

    // Hohle die einzelnen Einträge der Liste aus der Datenbank
    public List<ListEntity> getAllEntities(ToDoListe liste){
        List<ListEntity> einträge = dataSchnittstelle.getListOfEntitys(liste.ListID());
        return einträge;
    }

    public void updateEntryWithID(int entityID, Boolean done) {
        if(done){ dataSchnittstelle.markEntityAsDone    (entityID); }
        else    { dataSchnittstelle.markEntityAsNotDone (entityID); }
    }
}
