import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {"pretty", "io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm",
                "html:target/cucumber-report/cucumber-html-reports.html",
                "json:target//cucumber-report/cucumber.json"}
)

public class TestRunner {
}
