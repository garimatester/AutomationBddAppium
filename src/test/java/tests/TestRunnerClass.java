package tests;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = "src/test/resources/features",
glue = {"tests"},
tags = {"@smoke"}

)
public class TestRunnerClass extends AbstractTestNGCucumberTests{

}
