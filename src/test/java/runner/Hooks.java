package runner;

import framework.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
	@Before
	public void startUp() {
		FrameworkConfig.page = new FrameworkInitialize().InitializePlaywrightPage();
	}
	
	@After
	public void teardown() throws Exception {
		FrameworkConfig.page.close();
	}

}
