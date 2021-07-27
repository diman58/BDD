package tools;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import reporting.MyLogger;
import stepDefinitions.ExpectedResultsDefinitions;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

import static tools.preConditionManager.driver;
import static tools.preConditionManager.listOfElements;

public class Actions {
    public static String background;
    public static WebElement element;

    public void openIndexPage(WebDriver driver) {
        driver.get("https://www.saucedemo.com/");
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(listOfElements.get(ElementsReader.findElementinList("Username")).getxPath())
        ));
        MyLogger.logger.info("https://www.saucedemo.com/ is opening");
    }

    public void typeIn(WebDriver driver, String string, String string2) {
        driver.findElement(By.xpath(listOfElements.get(ElementsReader.findElementinList(string)).getxPath()))
                .sendKeys(string2);
        MyLogger.logger.info("Typing in " + "\"" + listOfElements.get(ElementsReader.findElementinList(string)).getName()
                + "\"" + " next value: " + "\"" + string2 + "\"");
    }

    public void click(WebDriver driver, String string) {
        driver.findElement(By.xpath(listOfElements.get(ElementsReader.findElementinList(string)).getxPath())).click();
        MyLogger.logger.info("Clicking element " + "\"" + listOfElements.get(ElementsReader.findElementinList(string)).getName() + "\"");
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(listOfElements.get(ElementsReader.findElementinList(string)).getObjectToWait())
                )
        );
    }

    public void JSclick(WebDriver driver, String string) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();",
                driver.findElement(By.xpath(listOfElements.get(ElementsReader.findElementinList(string)).getxPath())));
        MyLogger.logger.info("Clicking element " + "\"" + listOfElements.get(ElementsReader.findElementinList(string)).getName() + "\"");
    }

    public void filter(WebDriver driver, String string) {
        Select select = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
        select.selectByVisibleText(string);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MyLogger.logger.info("Selecting next order " + "\"" + string + "\"");
    }

    public WebDriver getDriver() {
        return preConditionManager.context
                .getBean("preConditionManager", preConditionManager.class)
                .setDriverReady();
    }

    public void browserTearDown() {
        driver.close();
    }

    /*public void JSHighlight(String string) {
        element = driver.findElement(By.xpath(
                listOfElements.get(ElementsReader.findElementinList(string)).getxPath()));
        background = element.getCssValue("background");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.backgroundColor = '" + "yellow" + "'", element);
    }

    public void JSUnHighlight() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.backgroundColor = '" + background + "'", element);
        element = null;
    }*/

    public void takeScreen() {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Path path = Paths.get("D:\\screens");
            FileUtils.copyFileToDirectory(screenshot,new File(path.toAbsolutePath().toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
