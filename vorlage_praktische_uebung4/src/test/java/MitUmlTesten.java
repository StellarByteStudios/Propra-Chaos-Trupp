import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import covidtracer.CovidtracerApplication;
import covidtracer.stereotypes.ClassOnly;
import org.junit.jupiter.api.Disabled;

import java.net.URL;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;
import static com.tngtech.archunit.library.plantuml.PlantUmlArchCondition.Configurations.consideringOnlyDependenciesInDiagram;
import static com.tngtech.archunit.library.plantuml.PlantUmlArchCondition.adhereToPlantUmlDiagram;
import static com.tngtech.archunit.thirdparty.com.google.common.io.Resources.getResource;

@AnalyzeClasses(packagesOf = CovidtracerApplication.class)
public class MitUmlTesten {

//    @ArchTest
//    static ArchRule pumeltest = classes()
//            .should(adhereToPlantUmlDiagram(getResource("Plant.puml"),
//                    consideringOnlyDependenciesInDiagram()));
}
