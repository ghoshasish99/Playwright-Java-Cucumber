package runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(strict = true, monochrome = true,
        features = "src/test/resources/features/",
        glue = {"stepdefinitions"},
        plugin = {"junit:target/junitreport.xml","json:target/jsonreport.json"}
        
)
public class TestRunner {

    private TestRunner() {

    }
    
    
	
	  @BeforeClass 
	  public static void beforeClass() {
		 
	  
	  }
	  
	  @AfterClass 
	  public static void afterClass() {
		  
	  }
	 
}