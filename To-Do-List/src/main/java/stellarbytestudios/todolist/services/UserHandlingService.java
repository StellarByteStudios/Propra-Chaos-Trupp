package stellarbytestudios.todolist.services;

import org.springframework.stereotype.Service;
import stellarbytestudios.todolist.databankcommunication.DBSchnittstelle;
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


    //* * * Methoden * * * //
    // Neuen User in Datenbank speichern
    public void saveNewUser(String newUsername){
        dataSchnittstelle.saveNewUser(newUsername);
    }

    // Hohle einen User aus der Datenbank mithilfe seines Namens

    public User getUserByName(String name){
        User user = dataSchnittstelle.getUserByName(name);
        return user;
    }

    public ToDoListe getListFromUser(User user) {
        ToDoListe liste = dataSchnittstelle.getListFromUserID(user.userID());
        return null;
    }
}
