package tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class preConditionManager {
    public static ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext("applicationContext.xml");
    public static WebDriver driver = new ChromeDriver();
    public static List<WrapperOfElements> listOfElements = ElementsReader.readAllElements();

    public WebDriver setDriverReady() {
       driver.manage().window().maximize();
       return driver;
    }

}
