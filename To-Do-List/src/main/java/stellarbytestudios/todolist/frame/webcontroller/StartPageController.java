package stellarbytestudios.todolist.frame.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import stellarbytestudios.todolist.services.ToDoListService;

@Controller
public class StartPageController {
    // Initialcode
    private final ToDoListService service;

    public StartPageController(ToDoListService service) {
        this.service = service;
    }


    // * * * HTML-Mappings * * * //

    @GetMapping("/")
    public String startseite(Model m){
        return "RegistrierungsForm";
    }
}
