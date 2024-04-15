package dev.cfernandezcairo.wastemanager.application;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-result"}
)
public class ApplicationTest {
    // Can be left empty unless otherwise needed
}
