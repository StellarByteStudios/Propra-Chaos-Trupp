package stellarbytestudios.todolist.services;

import stellarbytestudios.todolist.core.datacontainer.ListEntity;
import stellarbytestudios.todolist.core.datacontainer.ToDoListe;
import stellarbytestudios.todolist.core.datacontainer.User;

import java.util.List;

public interface IDBSchnittstelle {
    /* save Methods */
    // Neuen Nutzer Speichern
    void saveNewUser(String newUsername);

    // Einem Nutzer (ID) eine neue Liste geben
    void saveNewList(int id);

    // Einen neuen Eintrag in einer Liste anlegen
    void saveNewListEntity(int listid, String task);

    /* get Methods */
    // Nutzer durch den Namen aus der Datenbank holen
    User getUserByName(String username);

    // User mithilfe seiner ID aus der Datenbank fischen
    User getUserByID(int userID);

    // Liste eines Nutzers aus der Datenbank holen
    ToDoListe getListFromUserID(int userID);

    // Bekomme alle Einträge einer Liste
    List<ListEntity> getListOfEntitys(int listID);

    /* update Methods */
    void markEntityAsDone(int entityID);

    void markEntityAsNotDone(int entityID);

}
