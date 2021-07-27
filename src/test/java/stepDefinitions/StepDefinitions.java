package stepDefinitions;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_old.Ac;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import tools.*;



public class StepDefinitions {
    WebDriver driver;

    @Given("indexpage of app is opened")
    public void openIndexPage() {
        driver = new Actions().getDriver();
        new Actions().openIndexPage(driver);
    }

    @When("^user type in ([\\w]+) ([\\w]+)$")
    public void userTypeIn(String arg0, String arg1) {
        new Actions().typeIn(driver, arg0, arg1);
    }

    @And("^user click ([\\w]+)$")
    public void userClick(String arg0) {
        new StrategyDeterminant().determineStrategy(arg0);
        //new Actions().click(driver,arg0);
    }

    @Then("homepage of app is opened")
    public void homepageOfAppIsOpened() {
        new ExpectedResultsDefinitions().isHomepageOfAppIsOpened(driver);
    }

    @When("^user filter (\\w.+)$")
    public void userFilter(String arg0) {
        new Actions().filter(driver,arg0);
    }

    @Then("^items are filtered in (\\w.+)$")
    public void itemsAreFilteredIn(String arg0) {
        new ExpectedResultsDefinitions().isItemsAreFilteredIn(driver, arg0);
    }
}
