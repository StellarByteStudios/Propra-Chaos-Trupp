package stellarbytestudios.todolist.frame.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import stellarbytestudios.todolist.core.datacontainer.ToDoListe;
import stellarbytestudios.todolist.core.datacontainer.User;
import stellarbytestudios.todolist.services.ToDoListService;

@Controller
@RequestMapping("/userpage")
public class UserPageController {

    // Initialcode
    private final ToDoListService service;

    public UserPageController(ToDoListService service) {
        this.service = service;
    }


    // * * * HTML-Mappings * * * //

    // Es wird ein neuer Eintrag angelegt und abgespeichert
    @PostMapping("eintragAnlegen/{userID}")
    public String eintragAnlegen(@PathVariable int userID, String task, RedirectAttributes readds){
        // Erstmal den User und seine Liste aus der Datenbank holen
        User angemeldeter = service.getUserById(userID);
        ToDoListe liste = service.getListFromUser(angemeldeter);

        // Neuen Eintrag abspeichern
        service.setNewEntryInList(liste, task);

        // Konsolenausgabe
        System.out.println("Der User: " + angemeldeter.username() + " hat die Aufgabe: '" + task + "' abgesetzt");

        // redirect vorbereiten
        readds.addAttribute("username", angemeldeter.username());

        return "redirect:/anmeldung/userpage";
    }

    // Abhakten eines Eintrags wird in der Datenbank gespeichert
    @PostMapping("eintragUpdaten/{userID}/{entityID}")
    public String eintragabhaken(@PathVariable int userID,
                                 @PathVariable int entityID,
                                 Boolean done,
                                 RedirectAttributes readds){

        // Erstmal den User und seine Liste aus der Datenbank holen
        User angemeldeter = service.getUserById(userID);

        // Input validieren (wenn checkbox false -> done == null)
        if(done == null){ done = false; }
        // Eintragsänderung durchführen
        service.updateEntryWithID(entityID, done);

        // Konsolenausgabe
        System.out.println("Der User: " + angemeldeter.username() + " hat eine Aufgabe gesetzt auf: " + done);

        // redirect vorbereiten
        readds.addAttribute("username", angemeldeter.username());

        return "redirect:/anmeldung/userpage";
    }
}
