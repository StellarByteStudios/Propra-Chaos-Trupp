package stellarbytestudios.todolist.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import stellarbytestudios.todolist.datacontainer.ListEntity;
import stellarbytestudios.todolist.datacontainer.ToDoListe;
import stellarbytestudios.todolist.datacontainer.User;
import stellarbytestudios.todolist.services.UserHandlingService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class AnmeldeRegistrierungsController {

    // Initialcode
    private final UserHandlingService userService;

    public AnmeldeRegistrierungsController(UserHandlingService userService) {
        this.userService = userService;
    }

    // * * * HTML-Mappings * * * //
    // Startseite / Registrierung
    @GetMapping("/")
    public String startseiteRegistrierung(Model m){
        return "RegistrierungsForm";
    }

    // Registrierung wird durchgeführt, neuer User in der Datenbank gespeichert
    @PostMapping("/registrieren")
    public String registrieren(String username){
        userService.saveNewUser(username);
        System.out.println("Neuer User registriert: " + username);
        return "ErfolgreichRegistriert";
    }

    // Öffnet die neue Seite zum Anmelden
    @GetMapping("/anmeldeform")
    public String anmeldeseite(Model m){
        return "AnmeldeForm";
    }

    // Führt die Anmeldung durch und leitet auf die User eigene Seite um
    @GetMapping("/anmeldung")
    public String anmeldung(Model m, String username){

        // Erstmal den User aus der Datenbank holen
        User angemeldeter = userService.getUserByName(username);
        // Wenn der User nicht gefunden wurde
        if(angemeldeter == null){
            System.out.println("Anmeldung ist Fehlgeschlagen");
            return "AnmeldungFehlgeschlagen";
        }
        System.out.println(angemeldeter.username() + " hat sich angemeldet");

        // Die zum User gehörige To-Do-Liste aus der Datenbank holen
        ToDoListe liste = userService.getListFromUser(angemeldeter);

        // Wenn der User keine Liste hat wird eine Leere erzeugt
        // - - - - - - - Muss noch überarbeitet werden - - - - - - - - - //
//        if (liste == null) {
//            System.out.println("Dieser User hat noch keine Liste");
//            liste = new ToDoListe(1, angemeldeter.userID());
//        }

        // Hole alle Einträge aus der Liste
        List<ListEntity> entities = userService.getAllEntities(liste);

        // Regelfall
        m.addAttribute("user", angemeldeter);
        m.addAttribute("todoliste", liste);
        m.addAttribute("entities", entities);
        return "UserAnsicht";
    }

    // Es wird ein neuer Eintrag angelegt und abgespeichert

    @PostMapping("/eintragAnlegen/{userID}")
    public String eintragAnlegen(@PathVariable int userID, String task, RedirectAttributes readds){
        // Erstmal den User und seine Liste aus der Datenbank holen
        User angemeldeter = userService.getUserById(userID);
        ToDoListe liste = userService.getListFromUser(angemeldeter);

        // Neuen Eintrag abspeichern
        userService.setNewEntryInList(liste, task);

        // Konsolenausgabe
        System.out.println("Der User: " + angemeldeter.username() + " hat die Aufgabe: '" + task + "' abgesetzt");

        // redirect vorbereiten
        readds.addAttribute("username", angemeldeter.username());

        return "redirect:/anmeldung";
    }
}