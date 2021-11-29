package stellarbytestudios.todolist.frame.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import stellarbytestudios.todolist.services.UserHandlingService;

@Controller
@RequestMapping("/registrierung")
public class RegistrierungsController {

    // Initialcode
    private final UserHandlingService service;

    public RegistrierungsController(UserHandlingService service) {
        this.service = service;
    }


    // * * * HTML-Mappings * * * //

    // Öffnet die neue Seite zum Registieren
    @GetMapping("formular")
    public String startseite(Model m){
        return "RegistrierungsForm";
    }

    // Registrierung wird durchgeführt, neuer User in der Datenbank gespeichert
    @PostMapping("registrieren")
    public String registrieren(String username){
        service.saveNewUser(username);
        System.out.println("Neuer User registriert: " + username);
        return "ErfolgreichRegistriert";
    }
}