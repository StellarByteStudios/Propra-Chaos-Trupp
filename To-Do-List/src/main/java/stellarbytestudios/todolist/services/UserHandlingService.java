package stellarbytestudios.todolist.services;

import org.springframework.stereotype.Service;
import stellarbytestudios.todolist.databankcommunication.DBSchnittstelle;
import stellarbytestudios.todolist.datacontainer.ListEntity;
import stellarbytestudios.todolist.datacontainer.ToDoListe;
import stellarbytestudios.todolist.datacontainer.User;

import java.util.List;

@Service
public class UserHandlingService {
    // Initialcode
    private final DBSchnittstelle dataSchnittstelle;

    public UserHandlingService(DBSchnittstelle db) {
        this.dataSchnittstelle = db;
    }


    // * * * Methoden * * * //
    // Neuen User in Datenbank speichern
    public void saveNewUser(String newUsername){
        dataSchnittstelle.saveNewUser(newUsername);
    }

    // Hohle einen User aus der Datenbank mithilfe seines Namens
    public User getUserByName(String name){
        User user = dataSchnittstelle.getUserByName(name);
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
}
