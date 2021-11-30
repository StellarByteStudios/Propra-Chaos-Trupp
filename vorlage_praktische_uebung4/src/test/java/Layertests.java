import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import covidtracer.CovidtracerApplication;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;
import static com.tngtech.archunit.library.Architectures.onionArchitecture;

public class Layertests {
    private final JavaClasses klassen =
            new ClassFileImporter().importPackagesOf(CovidtracerApplication.class);


    @Test
    @DisplayName("Die Anwendung hat eine Onion Architektur")
    public void rule1()
            throws Exception {
        ArchRule rule = layeredArchitecture()
                .layer("Controllers").definedBy("..controller..")
                .layer("Services").definedBy("..service..")
                .layer("Persistence").definedBy("..persistence..")

                .whereLayer("Controllers").mayNotBeAccessedByAnyLayer()
                .whereLayer("Services").mayOnlyBeAccessedByLayers("Controllers")
                .whereLayer("Persistence").mayOnlyBeAccessedByLayers("Services");

        rule.check(klassen);
    }
}
