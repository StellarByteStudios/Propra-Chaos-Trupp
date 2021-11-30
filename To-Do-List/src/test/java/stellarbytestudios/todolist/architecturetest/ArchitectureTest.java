package stellarbytestudios.todolist.architecturetest;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stellarbytestudios.todolist.ToDoListApplication;

import static com.tngtech.archunit.library.Architectures.onionArchitecture;

public class ArchitectureTest {
    private final JavaClasses klassen =
            new ClassFileImporter().importPackagesOf(ToDoListApplication.class);


    @Test
    @Disabled
    @DisplayName("Die Anwendung hat eine Onion Architektur")
    public void rule1()
            throws Exception {
        ArchRule rule = onionArchitecture()
                .domainModels("todolist.core..")
                .domainServices("todolist.services..")
                .applicationServices("todolist.services..")
                .adapter("webcontroller", "todolist.frame.webcontroller")
                .adapter("persistence", "todolist.frame.databankcommunication");
        rule.check(klassen);
    }
}
