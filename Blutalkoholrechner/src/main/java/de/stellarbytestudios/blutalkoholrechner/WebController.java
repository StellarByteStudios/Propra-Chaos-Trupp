package de.stellarbytestudios.blutalkoholrechner;

import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/webpage")
public class WebController {

    @GetMapping("moin")
    public void index(HttpServletResponse resp) throws IOException {
        resp.setContentType("Text/html");
        resp.getWriter().println("Moooooin");
    }

    @GetMapping("tag/{name}/{intens}")
    public @ResponseBody String index(@PathVariable("name") String name,
                                      @PathVariable("intens")int intens) throws IOException {
        //String name = "";
        String ausrufzeichen = "";
        for (int i = 0; i < intens; i++) {
            ausrufzeichen += "!";
        }
        //String ausrufzeichen = Stream.generate(() -> "!").limit(Integer.parseInt(intens)).collect(Collectors.joining());
        return "<h1>" + "Guten Tag " + name + " " + ausrufzeichen + "</h1>";
    }

}
