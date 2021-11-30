import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import covidtracer.CovidtracerApplication;
import covidtracer.stereotypes.ClassOnly;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;

@AnalyzeClasses(packagesOf = CovidtracerApplication.class)
public class ErsteAufgabeTest {
    // Erste Aufgabe
    @ArchTest
    static final ArchRule classesAreNotAnnotated = classes()
            .that()
            .areNotAnnotations()
            .should()
            .notBeAnnotatedWith(Deprecated.class)
            .because("Ja iss halt so");

    @ArchTest
    static final ArchRule methodsAreNotAnnotated = methods()
            .should()
            .notBeAnnotatedWith(Deprecated.class)
            .because("Ja iss halt so");

    @ArchTest
    static final ArchRule constructorsAreNotAnnotated = constructors()
            .should()
            .notBeAnnotatedWith(Deprecated.class)
            .because("Ja iss halt so");

}
