package stellarbytestudios.todolist.webcontroller;

import org.springframework.boot.web.embedded.undertow.UndertowWebServer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import stellarbytestudios.todolist.datacontainer.User;

@Controller
public class AnmeldeRegistrierungsController {


    @GetMapping("/")
    public String startseiteRegistrierung(Model m){
        return "RegistrierungsForm";
    }

    @PostMapping("/registrieren")
    public String registrieren(Model m){
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
