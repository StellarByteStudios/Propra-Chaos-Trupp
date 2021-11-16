package de.stellarbytestudios.registrierungstool;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class WebController {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("student",new Student("Git.Name","Hannes",69, "ha100"));
        return "AnmeldeForm";
    }


//    @PostMapping("/")
//    public String berechnen(Model model, Zins zins){
//        double endkapital = zins.endkapitalBerechnen();
//        List<Zeile> zeilen = zins.tabelleBerechnen();
//
//        model.addAttribute("laufzeit", zins.laufzeit());
//        model.addAttribute("zinssatz",zins.zinssatz());
//        model.addAttribute("anfangskapital", zins.anfangskapital());
//        model.addAttribute("endkapital",endkapital);
//        model.addAttribute("zeile", zeilen);
//        return "Formular";
//    }

}