package de.proprachaostrupp.registrierungtool.db;

import static org.assertj.core.api.Assertions.assertThat;

import de.proprachaostrupp.registrierungtool.DbHandling;
import de.proprachaostrupp.registrierungtool.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

@JdbcTest
@ActiveProfiles("test")
public class RegistrierungsToolDbTest {

    @Autowired
    JdbcTemplate db;

    @Test
    @Sql({"classpath:db/migration/V1__init.sql",
            "classpath:db/migration/V2__Fill_With_Students.sql"})
    @DisplayName("Student wird abgespeichert")
    void test_1(){
        Student student = new Student("TestStudentGit", "Teststudent", 123456789, "Test123");
        DbHandling.saveStudent(db, student);
        Student geholt = DbHandling.getStudentByGitName(db, "TestStudentGit");
        assertThat(student.gitHubName()).isEqualTo(geholt.gitHubName());
        assertThat(student.name()).isEqualTo(geholt.name());
        assertThat(student.matrikelnr()).isEqualTo(geholt.matrikelnr());
        assertThat(student.unikennung()).isEqualTo(geholt.unikennung());
    }
}
