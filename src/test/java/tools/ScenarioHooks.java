package tools;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.bs.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ScenarioHooks {
    public static WebDriver driver;
    public static List<WrapperOfElements> listOfElements;

    @Before
    public void driverSetUp() {
        listOfElements = ElementsReader.readAllElements();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void driverTearDown() {
        driver.quit();
        driver = null;
    }
}
