package stellarbytestudios.todolist.services;

import org.springframework.stereotype.Service;
import stellarbytestudios.todolist.databankcommunication.DBSchnittstelle;
import stellarbytestudios.todolist.datacontainer.User;

@Service
public class UserHandlingService {
    // Initialcode
    private final DBSchnittstelle dataSchnittstelle;

    public UserHandlingService(DBSchnittstelle db) {
        this.dataSchnittstelle = db;
    }


    //* * * Methoden * * * //
    // Neuen User in Datenbank speichern
    public void saveNewUser(User newUser){
        dataSchnittstelle.saveNewUser(newUser);
    }
}
