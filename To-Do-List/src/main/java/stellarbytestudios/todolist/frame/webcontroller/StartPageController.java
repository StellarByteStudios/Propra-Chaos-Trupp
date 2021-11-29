package stellarbytestudios.todolist.frame.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import stellarbytestudios.todolist.services.UserHandlingService;

@Controller
public class StartPageController {
    // Initialcode
    private final UserHandlingService service;

    public StartPageController(UserHandlingService userService) {
        this.service = userService;
    }


    // * * * HTML-Mappings * * * //

    @GetMapping("/")
    public String startseite(Model m){
        return "RegistrierungsForm";
    }
}
