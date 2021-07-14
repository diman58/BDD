package tools;

import com.google.gson.annotations.SerializedName;

public class WrapperOfElements {
    String name;
    String xPath;
    String objectToWait;

    public String getName() {
        return name;
    }

    public String getxPath() {
        return xPath;
    }

    public String getObjectToWait() {
        return objectToWait;
    }
}
