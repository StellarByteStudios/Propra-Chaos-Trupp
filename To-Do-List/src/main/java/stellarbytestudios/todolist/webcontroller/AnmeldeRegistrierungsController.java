package stellarbytestudios.todolist.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import stellarbytestudios.todolist.datacontainer.User;
import stellarbytestudios.todolist.services.UserHandlingService;

@Controller
public class AnmeldeRegistrierungsController {

    // Initialcode
    private final UserHandlingService userService;

    public AnmeldeRegistrierungsController(UserHandlingService userService) {
        this.userService = userService;
    }

    // * * * HTML-Mappings * * * //
    @GetMapping("/")
    public String startseiteRegistrierung(Model m){
        return "RegistrierungsForm";
    }

    @PostMapping("/registrieren")
    public String registrieren(User newUser){
        userService.saveNewUser(newUser);
        //System.out.println("Neuer User: " + newUser.username());
        return "ErfolgreichRegistriert";
    }

    @GetMapping("/anmeldeform")
    public String anmeldeseite(Model m){
        return "AnmeldeForm";
    }

    @PostMapping("/anmeldung")
    public String anmeldung(Model m){
        return "ErfolgreichAngemeldet";
    }

}
