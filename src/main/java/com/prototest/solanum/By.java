package com.prototest.solanum;

/**
 * Created by Brian on 5/12/2014.
 */
public class By {
    private String locator;
    public By(String locator){
      this.locator = locator;
    }


    public static By Image(String path)
    {
        String locatorString = String.format("(image: \"%s\")", path);
        return new By(locatorString);
    }

    public static By Image(String path, SearchOptions options)
    {
        String locatorString = String.format("(image: \"%s\"", path);
        locatorString += options.getImageString();
        locatorString += ")";
        return new By(locatorString);
    }

    public static By Text(String text)
    {
        String locatorString = String.format("(text: \"%s\")", text);
        return new By(locatorString);
    }

    public static By Text(String text, SearchOptions options)
    {
        String locatorString = String.format("(text: \"%s\"", text);
        locatorString += options.getTextString();
        locatorString += ")";
        return new By(locatorString);
    }

    public String getLocator() {
        return locator;
    }

}
