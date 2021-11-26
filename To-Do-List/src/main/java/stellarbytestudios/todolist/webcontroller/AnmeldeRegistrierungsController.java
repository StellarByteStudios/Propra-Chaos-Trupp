package stellarbytestudios.todolist.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
        System.out.println("Neuer User: " + username);
        return "ErfolgreichRegistriert";
    }

    // Öffnet die neue Seite zum Anmelden
    @GetMapping("/anmeldeform")
    public String anmeldeseite(Model m){
        return "AnmeldeForm";
    }

    // Führt die Anmeldung durch und leitet auf die User eigene Seite um
    @PostMapping("/anmeldung")
    public String anmeldung(Model m, String username){

        // Erstmal den User aus der Datenbank holen
        User angemeldeter = userService.getUserByName(username);
        // Wenn der User nicht gefunden wurde
        if(angemeldeter == null){
            System.out.println("Anmeldung ist Fehlgeschlagen");
            return "AnmeldungFehlgeschlagen";
        }
        System.out.println(angemeldeter.username() + "hat sich angemeldet");

        // Die zum User gehörige To-Do-Liste aus der Datenbank holen
        ToDoListe liste = userService.getListFromUser(angemeldeter);
        // Wenn der User keine Liste hat wird eine Leere erzeugt
        if (liste == null) {
            System.out.println("Dieser User hat noch keine Liste");
            liste = new ToDoListe(1, angemeldeter.userID());
        }

        // Hole alle Einträge aus der Liste
        //List<ListEntity> entities = userService.getAllEntities(liste);
        ListEntity ent1 = new ListEntity(1,"Task 1", false, 1);
        ListEntity ent2 = new ListEntity(2,"Task 2", false, 1);
        ListEntity ent3 = new ListEntity(3,"Task 3", false, 1);

        List<ListEntity> entities = List.of(ent1, ent2, ent3);

        // Regelfall
        m.addAttribute("user", angemeldeter);
        m.addAttribute("todoliste", liste);
        //m.addAttribute("entities", entities);
        return "UserAnsicht";
    }
}
