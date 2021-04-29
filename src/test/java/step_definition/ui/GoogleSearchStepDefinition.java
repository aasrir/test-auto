package step_definition.ui;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static modules.Hooks.driver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static modules.page_objects.GoogleSearchPage.searchFor;

public class GoogleSearchStepDefinition {

    @Given("I open google search page")
    public void iOpenGoogleSearchPage() {
        driver.get("https://www.google.com/");
        try {
            WebElement securityPopUp = driver.findElement(By.id("zV9nZe"));
            if(securityPopUp.isDisplayed() && securityPopUp.isEnabled()) {
                securityPopUp.click();
            }
        }
        catch(Exception ignored) {}
    }

    @When("I lookup the word {string}")
    public void iLookupTheWord(String arg0) {
        searchFor(arg0);
    }

    @Then("search results display the word {string}")
    public void searchResultsDisplayTheWord(String arg0) {
        assertEquals(arg0 + " - Recherche Google", driver.getTitle());
    }
}
