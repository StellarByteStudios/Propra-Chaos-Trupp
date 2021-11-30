import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import covidtracer.CovidtracerApplication;
import covidtracer.stereotypes.ClassOnly;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;

@AnalyzeClasses(packagesOf = CovidtracerApplication.class)
public class ZweiteAufgabeTest {
    // Zweite Aufgabe
    @ArchTest
    static final ArchRule AllPublicClassesWhenNotAnnected = classes()
            .that()
            .areNotAnnotatedWith(ClassOnly.class)
            .should()
            .bePublic()
            .because("Ja iss halt so");

    @ArchTest
    static final ArchRule AllPublicConstructorsWhenNotAnnected = constructors()
            .that()
            .areNotAnnotatedWith(ClassOnly.class)
            .should()
            .bePublic()
            .because("Ja iss halt so");

    @ArchTest
    static final ArchRule AllPublicMethodsWhenNotAnnected = methods()
            .that()
            .arePublic()
            .should()
            .notBeAnnotatedWith(ClassOnly.class)
            .because("Ja iss halt so");
}
