package StepDef;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true,
        features = {"C:\\Users\\Evi\\Desktop\\FinalProject\\src\\test\\resources\\Features\\Login.feature" },
        tags = {"@Test"},
        plugin = {"pretty", "html:target/cucumber-reports"},
        monochrome = true,
        glue = {"StepDef"}
)

public class RunnerClass {};
