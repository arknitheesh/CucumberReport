package org.ark;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/test/resources", glue = "org.ark", monochrome = true, 
dryRun = false, snippets = SnippetType.CAMELCASE , tags = {"@Login1 ,@Login2"}, plugin = {"html:Reports",
		"junit:Reports\\iciciBank.xml" , "json:Reports\\icicibank.json"})
public class runner {

}
