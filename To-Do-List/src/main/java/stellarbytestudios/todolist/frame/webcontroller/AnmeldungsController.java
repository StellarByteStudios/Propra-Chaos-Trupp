package stellarbytestudios.todolist.frame.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import stellarbytestudios.todolist.core.datacontainer.ListEntity;
import stellarbytestudios.todolist.core.datacontainer.ToDoListe;
import stellarbytestudios.todolist.core.datacontainer.User;
import stellarbytestudios.todolist.services.ToDoListService;

import java.util.List;

@Controller
@RequestMapping("/anmeldung")
public class AnmeldungsController {

   // Initialcode
    private final ToDoListService service;

    public AnmeldungsController(ToDoListService service) {
        this.service = service;
    }


    // * * * HTML-Mappings * * * //

    // Öffnet die neue Seite zum Anmelden
    @GetMapping("formular")
    public String anmeldeseite(Model m){
        return "AnmeldeForm";
    }


    // Führt die Anmeldung durch und leitet auf die User eigene Seite um
    @GetMapping("userpage")
    public String anmeldung(Model m, String username){

        // Erstmal den User aus der Datenbank holen
        User angemeldeter = service.getUserByName(username);
        // Wenn der User nicht gefunden wurde
        if(angemeldeter == null){
            System.out.println("Anmeldung ist Fehlgeschlagen");
            return "AnmeldungFehlgeschlagen";
        }
        System.out.println(angemeldeter.username() + " hat sich angemeldet");

        // Die zum User gehörige To-Do-Liste aus der Datenbank holen
        ToDoListe liste = service.getListFromUser(angemeldeter);

        // Hole alle Einträge aus der Liste
        List<ListEntity> entities = service.getAllEntities(liste);

        // Regelfall
        m.addAttribute("user", angemeldeter);
        m.addAttribute("todoliste", liste);
        m.addAttribute("entities", entities);
        return "UserAnsicht";
    }
}
