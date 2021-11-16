package de.stellarbytestudios.blutalkoholrechner;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/alk")
public class AlkoholWebController {


//    @GetMapping("alkoholeingabe")
//    public @ResponseBody String ausgabe(Alkdaten alkdaten){
//        return alkdaten.alkZustand();
//    }

    @GetMapping("alkoholeingabe")
    public String ausgabe(Alkdaten alkdaten, Model model){
        model.addAttribute("Promille", alkdaten.getPromille());
        return "promillewert";
    }
}
