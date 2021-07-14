package stepDefinitions;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import tools.ElementsReader;
import tools.ScenarioHooks;

import java.util.ArrayList;
import java.util.List;

import static tools.ScenarioHooks.listOfElements;
import static tools.expectedResults.*;

public class StepDefinitions {
    WebDriver driver;
    @Given("indexpage of app is opened")
    public void openIndexPage() {
        driver = ScenarioHooks.driver;
        driver.get("https://www.saucedemo.com/");
        new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(listOfElements.get(ElementsReader.findElementinList("Username")).getxPath())
        ));
    }

    @When("^user type in ([\\w]+) ([\\w]+)$")
    public void userTypeIn(String arg0, String arg1) {
       driver.findElement(By.xpath(listOfElements.get(ElementsReader.findElementinList(arg0)).getxPath()))
               .sendKeys(arg1);
    }

    @And("^user click ([\\w]+)$")
    public void userClick(String arg0) {
        driver.findElement(By.xpath(listOfElements.get(ElementsReader.findElementinList(arg0)).getxPath())).click();
        new WebDriverWait(driver,10).until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(listOfElements.get(ElementsReader.findElementinList(arg0)).getObjectToWait())
                )
        );
    }

    @Then("homepage of app is opened")
    public void homepageOfAppIsOpened() {
        String actualValue = driver.findElement(By.xpath(listOfElements.get(3).getxPath())).getText();
        Assert.assertSame(actualValue, "PRODUCTS");
    }

    @When("^user filter (\\w.+)$")
    public void userFilter(String arg0) {
        Select select = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
        select.selectByVisibleText(arg0);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^items are filtered in (\\w.+)$")
    public void itemsAreFilteredIn(String arg0) {
        List<WebElement> templistOfElements = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<String> listOfElements = new ArrayList<>();
        for (int i = 0; i < templistOfElements.size(); i++) {
            listOfElements.add(templistOfElements.get(i).getText());
        }

        switch (arg0) {
            case "Name (A to Z)":
                Assert.assertSame(listOfElements, nameAtoZ);
                break;
            case "Name (Z to A)":
                Assert.assertSame(listOfElements,nameZtoA);
                break;
            case "Price (low to high)":
                Assert.assertSame(listOfElements,priceLowToHigh);
                break;
            case "Price (high to low)":
                Assert.assertSame(listOfElements, priceHighToLow);
        }
    }

}
