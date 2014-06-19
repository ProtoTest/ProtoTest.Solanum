package com.prototest.solanum;

import java.awt.*;
import java.io.File;

/**
 * Created by Brian on 5/12/2014.
 */
public class By {
    public final ByType type;

    public enum ByType {
        point,image,text
    }
    private String locator;
    private SearchRectangle searchRectangle;
    private File image;

    public String getLocator() {
        return locator;
    }

    public By(String locator, ByType type) {
        this.locator = locator;
        this.searchRectangle = new SearchRectangle(EggplantTestBase.driver.getScreenRectangle());
        this.type = type;
    }

    private By(String locator, SearchRectangle searchRectangle, ByType type) {
        this.locator = locator;
        this.searchRectangle = searchRectangle;
        this.type = type;
    }

    private By(String locator, SearchRectangle searchRectangle, ByType type, File image) {
        this.locator = locator;
        this.searchRectangle = searchRectangle;
        this.type = type;
        this.image = image;
    }

    public File getImageFile(){
        return image;
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
        String relativePath = Config.suitePath + "/images/" + path;
        File file = new File(relativePath);
        if(!file.isDirectory()){
            file = new File(Config.currentPath, relativePath + ".png");
            if(!file.exists()){
                file = new File(Config.currentPath, relativePath + ".tiff");
                if(!file.exists()){
                    Logger.warning("Could not find image file at : " + relativePath );
                }
            }
        }
        return new By(locatorString, searchRectangle, ByType.image,file);
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
        return new By(locatorString, searchRectangle, ByType.text);
    }

    public static By Point(Point point) {
        String locatorString = String.format("(%s,%s)", point.getX(), point.getY());
        return new By(locatorString, ByType.point);
    }

    public SearchRectangle getSearchRectangle() {
        return searchRectangle;
    }
}
