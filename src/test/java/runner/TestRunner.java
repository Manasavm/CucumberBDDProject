package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import java.sql.SQLOutput;


@RunWith(Cucumber.class)
@CucumberOptions(glue = "steps", plugin = {"json:target/cucumber.json","html:target/site/cucumber-pretty","pretty"}, features = "src/test/java/features")

public class TestRunner {

}