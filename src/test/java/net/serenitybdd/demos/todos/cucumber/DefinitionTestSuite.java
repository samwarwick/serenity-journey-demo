package net.serenitybdd.demos.todos.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="classpath:features", plugin="rerun:target/rerun.txt")
public class DefinitionTestSuite {

}
