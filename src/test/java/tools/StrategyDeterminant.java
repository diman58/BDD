package tools;

import io.cucumber.java.en_old.Ac;

import static tools.preConditionManager.driver;
import static tools.preConditionManager.listOfElements;

public class StrategyDeterminant {

    public void determineStrategy(String string) {
        if(listOfElements.get(ElementsReader.findElementinList(string)).getStrategy()==null) {
            //System.out.println("regular click");
            new Actions().click(driver,string);
        } else {
            //System.out.println("JSclick");
            new Actions().JSclick(driver,string);
        }
    }
}
