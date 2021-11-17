package com.example.kw45mittwoch0830gruppe24;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class WebController {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("zins",new Zins(5000,5,2, false));
        model.addAttribute("laufzeit" ,0);
        model.addAttribute("zinssatz" ,0);
        model.addAttribute("anfangskapital" ,0);
        model.addAttribute("endkapital" ,0);
        return "Formular";
    }


    @PostMapping("/")
    public String berechnen(Model model, Zins zins){
        double endkapital = zins.endkapitalBerechnen();
        List<Zeile> zeilen = zins.tabelleBerechnen();

        model.addAttribute("laufzeit", zins.laufzeit());
        model.addAttribute("zinssatz",zins.zinssatz());
        model.addAttribute("anfangskapital", zins.anfangskapital());
        model.addAttribute("endkapital",endkapital);
        model.addAttribute("zeile", zeilen);
        return "Formular";
    }

}
