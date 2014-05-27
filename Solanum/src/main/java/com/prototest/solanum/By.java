package com.prototest.solanum;

import java.awt.*;

/**
 * Created by Brian on 5/12/2014.
 */
public class By {
    private String locator;
    private SearchRectangle searchRectangle;


    public String getLocator() {
        return locator;
    }

    public By(String locator) {
        this.locator = locator;
        this.searchRectangle = new SearchRectangle(EggplantTestBase.driver.getScreenRectangle());
    }

    private By(String locator, SearchRectangle searchRectangle) {
        this.locator = locator;
        this.searchRectangle = searchRectangle;
    }

    public static By Image(String path, ImageOption... options) {
        return Image(path, null, options);
    }

    public static By Image(String path, SearchRectangle searchRectangle, ImageOption... options) {
        String locatorString = String.format("(image: \"%s\"", path);
        if (searchRectangle != null) {
            locatorString += ", " + Option.searchRectangle(searchRectangle).getText();
        }
        for (ImageOption option : options) {
            locatorString += ", " + option.getText();
        }
        locatorString += ")";
        return new By(locatorString, searchRectangle);
    }

    public static By Text(String text, TextOption... options) {
        return Text(text, null, options);
    }

    public static By Text(String text, SearchRectangle searchRectangle, TextOption... options) {
        String locatorString = String.format("(text: \"%s\"", text);
        if (searchRectangle != null) {
            locatorString += ", " + Option.searchRectangle(searchRectangle).getText();
        }
        for (TextOption option : options) {
            locatorString += ", " + option.getText();
        }
        locatorString += ")";
        return new By(locatorString, searchRectangle);
    }

    public static By Point(Point point) {
        String locatorString = String.format("(%s,%s)", point.getX(), point.getY());
        return new By(locatorString);
    }

}
