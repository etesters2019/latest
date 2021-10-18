package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith (Cucumber.class)
@CucumberOptions (
		
	     features="C:\\Users\\Olu\\eclipse-workspace\\vehicle_Identify_E2E\\Features",
	     
	     glue ="stepDefinition",
	     
	     dryRun = false,
	     plugin= {"pretty",
	    		 "html:test-ouput"}
	     
	     //tags= {"@fail"}
	     
	    
	)
public class Test_Runner {

}
