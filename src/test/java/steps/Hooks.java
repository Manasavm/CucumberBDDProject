package steps;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import pages.DriverBase;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;


public class Hooks {
  @After
  public void embedScreenshot(Scenario scenario) {
    System.out.println("<==========Completed Execution of Scenario:==========>" + scenario.getName().toString());
    DriverBase.get().quitDriver();
  }

}
