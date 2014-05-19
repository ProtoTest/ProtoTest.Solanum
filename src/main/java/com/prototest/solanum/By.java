package com.prototest.solanum;

/**
 * Created by Brian on 5/12/2014.
 */
public class By {
    private String locator;

    public String getLocator() {
        return locator;
    }

    public By(String locator){
      this.locator = locator;
    }

    public static By Image(String path)
    {
        String locatorString = String.format("(image: \"%s\")", path);
        return new By(locatorString);
    }

    public static By Image(String path, ImageOption... options)
    {
        String locatorString = String.format("(image: \"%s\"", path);
        for(ImageOption option : options){
            locatorString += ", " + option.getText();
        }
        locatorString += ")";
        return new By(locatorString);
    }

    public static By Image(String path, SearchRectangle searchRectangle, ImageOption... options)
    {
        String locatorString = String.format("(image: \"%s\"", path);
        ImageOption rectangleOption = ImageOption.searchRectangle(searchRectangle);
        locatorString += ", " + rectangleOption.getText();
        for(ImageOption option : options){
            locatorString += ", " + option.getText();
        }
        locatorString += ")";
        return new By(locatorString);
    }

    public static By Text(String text)
    {
        String locatorString = String.format("(text: \"%s\")", text);
        return new By(locatorString);
    }

    public static By Text(String text, TextOption... options)
        {
        String locatorString = String.format("(text: \"%s\"", text);
            for(TextOption option : options){
                locatorString += ", " + option.getText();
            }
        locatorString += ")";
        return new By(locatorString);
    }

    public static By Text(String text, SearchRectangle searchRectangle, TextOption... options)
    {
        String locatorString = String.format("(text: \"%s\"", text);
        TextOption rectangleOption = TextOption.searchRectangle(searchRectangle);
        locatorString += ", " + rectangleOption.getText();
        for(TextOption option : options){
            locatorString += ", " + option.getText();
        }
        locatorString += ")";
        return new By(locatorString);
    }

}
