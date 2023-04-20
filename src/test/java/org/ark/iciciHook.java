package org.ark;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class iciciHook extends BaseClass {
	
	@Before
	public void OpenChrome() {
		launchBrowserChrome();

	}

	
	@After
	public void closeChrome() {
		driver.close();

	}
}
