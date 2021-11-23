package de.proprachaostrupp.registrierungtool;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DbHandling {

    public static void saveStudent(JdbcTemplate db, Student student){
        String sqlInsert = """
                INSERT INTO Student (gitHubName, name, matrikelnr, unikennung) 
                VALUES (?, ?, ?, ?)
                """;

        db.update(sqlInsert, student.gitHubName(), student.name(), student.matrikelnr(), student.unikennung());
    }

    public static Student getStudentByGitName(JdbcTemplate db, String gitName){
        String sqlGet = """
                SELECT gitHubName, name, matrikelnr, unikennung
                FROM Student
                WHERE gitHubName = ?
                """;
        List<Student> gesucht = db.query(sqlGet, DbHandling::studentMapper, gitName);
        return gesucht.get(0);
    }

    private static Student studentMapper(ResultSet rs, int i) throws SQLException {
        String gitHubName = rs.getString(1);
        String name = rs.getString(2);
        int matrikelnr = rs.getInt(3);
        String unikennung = rs.getString(4);

        Student stu = new Student(gitHubName, name, matrikelnr, unikennung);

        return stu;
    }
}
