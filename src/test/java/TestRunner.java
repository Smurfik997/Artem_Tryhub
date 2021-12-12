import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {"pretty",
                "io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm",
                "html:target/cucumber-report/cucumber-html-reports.html",
                "json:target//cucumber-report/cucumber.json"},
        monochrome = true, glue = {"stepdefs"}
)
public class TestRunner {
    @BeforeClass
    public static void setIdOffset() {
        System.setProperty("idOffset", String.valueOf((int) (Math.random() * 999)));
    }
}
