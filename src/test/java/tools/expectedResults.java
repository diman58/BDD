package tools;

import io.cucumber.java.bs.A;

import java.util.Arrays;
import java.util.List;

public class expectedResults {
    public static List<String> nameAtoZ = Arrays.asList("Sauce Labs Backpack","Sauce Labs Bike Light"
            ,"Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie"
            , "Test.allTheThings() T-Shirt (Red)" );
    public static List<String> nameZtoA = Arrays.asList("Test.allTheThings() T-Shirt (Red)" ,"Sauce Labs Onesie"
            ,"Sauce Labs Fleece Jacket","Sauce Labs Bolt T-Shirt","Sauce Labs Bike Light",
            "Sauce Labs Backpack");
    public static List<String> priceLowToHigh = Arrays.asList("Sauce Labs Onesie", "Sauce Labs Bike Light"
            , "Sauce Labs Bolt T-Shirt", "Test.allTheThings() T-Shirt (Red)", "Sauce Labs Backpack"
            , "Sauce Labs Fleece Jacket" );
    public static List<String> priceHighToLow = Arrays.asList("Sauce Labs Fleece Jacket", "Sauce Labs Backpack"
            , "Sauce Labs Bolt T-Shirt", "Test.allTheThings() T-Shirt (Red)", "Sauce Labs Bike Light"
            , "Sauce Labs Onesie");
}
