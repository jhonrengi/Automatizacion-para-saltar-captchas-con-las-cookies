package speed.runners;



import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features",
        tags = "@ProductosQuimicos",
        glue = "speed.stepsDefinitions",
        snippets =  CucumberOptions.SnippetType.CAMELCASE)

public class CaptchaBreakerRunner {

}
