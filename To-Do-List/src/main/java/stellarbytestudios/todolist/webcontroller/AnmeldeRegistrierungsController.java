package stellarbytestudios.todolist.webcontroller;

import org.springframework.boot.web.embedded.undertow.UndertowWebServer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import stellarbytestudios.todolist.datacontainer.User;

@Controller
public class AnmeldeRegistrierungsController {


    @GetMapping("/")
    public String Registrierung(Model m){

        //User defaultUser = new User(1, "Gib hier deinen Namen ein");
        //m.addAttribute(defaultUser);
        return "RegistrierungsForm";
    }
}
