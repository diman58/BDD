package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import reporting.MyLogger;

import java.util.ArrayList;
import java.util.List;

import static tools.preConditionManager.listOfElements;
import static tools.expectedResults.*;
import static tools.expectedResults.priceHighToLow;

public class ExpectedResultsDefinitions {
    public void isHomepageOfAppIsOpened(WebDriver driver) {
        String actualValue = driver.findElement(By.xpath(listOfElements.get(3).getxPath())).getText();
        Assert.assertSame(actualValue, "PRODUCTS");
    }

    public void isItemsAreFilteredIn(WebDriver driver, String string) {
        List<WebElement> templistOfElements = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<String> listOfElements = new ArrayList<>();
        for (int i = 0; i < templistOfElements.size(); i++) {
            listOfElements.add(templistOfElements.get(i).getText());
        }

        switch (string) {
            case "Name (A to Z)":
                Assert.assertSame(listOfElements, nameAtoZ);
                break;
            case "Name (Z to A)":
                Assert.assertSame(listOfElements, nameZtoA);
                break;
            case "Price (low to high)":
                Assert.assertSame(listOfElements, priceLowToHigh);
                break;
            case "Price (high to low)":
                Assert.assertSame(listOfElements, priceHighToLow);
        }
        MyLogger.logger.info("Assert");
    }

}
