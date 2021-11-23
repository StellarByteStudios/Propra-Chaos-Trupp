package de.proprachaostrupp.registrierungtool;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static de.proprachaostrupp.registrierungtool.DbHandling.saveStudent;

@Controller
public class WebController {

    private final JdbcTemplate db;

    public WebController(JdbcTemplate db) {
        this.db = db;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("student",new Student("Git.Name","Hannes",69, "ha100"));
        return "AnmeldeForm";
    }


    @PostMapping("/")
    public String registrieren(Model model, Student student){
        saveStudent(db, student);
        return "success";
    }

    @GetMapping("liste")
    public String listeAusgeben(Model model){
        String squGetList = """
        SELECT gitHubName, name, matrikelnr, unikennung
        FROM Student
        """;

        List<Student> students = db.query(squGetList, WebController::studentenMapper);

        model.addAttribute("students", students);

        return "AnmeldeListe";
    }

    private static Student studentenMapper(ResultSet rs, int i) throws SQLException {
        String gitHubName = rs.getString(1);
        String name = rs.getString(2);
        int matrikelnr = rs.getInt(3);
        String unikennung = rs.getString(4);

        Student stu = new Student(gitHubName, name, matrikelnr, unikennung);

        return stu;
    }
}