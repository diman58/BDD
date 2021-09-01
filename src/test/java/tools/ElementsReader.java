package tools;

import io.cucumber.messages.internal.com.google.gson.Gson;
import io.cucumber.messages.internal.com.google.gson.JsonArray;
import io.cucumber.messages.internal.com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static tools.preConditionManager.listOfElements;

public class ElementsReader {

    public static List<WrapperOfElements> readAllElements() {
        Gson gson = new Gson();
        WrapperOfElements[] temp = null;
        try {
            JsonReader jsonReader = new JsonReader(new FileReader(
                    ""src/test/java/tools/elements.json""));
            temp = gson.fromJson(jsonReader,WrapperOfElements[].class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return Arrays.asList(temp);
    }

    public static int findElementinList(String arg) {
        int number = -1;
        for (int i = 0; i < listOfElements.size(); i++) {
            if (listOfElements.get(i).getName().equals(arg)) {
               number = i;
            }
        }
        return number;
    }
}
