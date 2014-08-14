package com.prototest.solanum;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * <pre>By</pre> is used to describe how to find an element on screen..  It accepts an optional list of search options.
 * Three ways to define an element.  Using an image ({@link By#Image(String, ImageOption...)}),
 * a text value ({@link By#Text(String, SearchRectangle, TextOption...)}),
 * or a point ({@link By#Point(java.awt.Point)}).
 *
 * @see EggplantElement
 */
public class By {
    public final ByType type;

    public enum ByType {
        point,image,text
    }
    public String locator;
    private SearchRectangle.Quadrants searchRectangle;
    private File image;
    protected ArrayList<Option> options = new ArrayList<Option>();

    public String getLocator() {
        return buildLocatorString();
    }

    private By(String locator, ByType type) {
        this.locator = locator;
        this.searchRectangle = null;
        this.type = type;
    }



    private By(String locator, SearchRectangle.Quadrants searchRectangle, ByType type) {
        this.locator = locator;
        this.searchRectangle = searchRectangle;
        this.type = type;
    }

    private By(String locator, SearchRectangle.Quadrants searchRectangle, ByType type, File image) {
        this.locator = locator;
        this.searchRectangle = searchRectangle;
        this.type = type;
        this.image = image;
    }

    private By(String locator, SearchRectangle.Quadrants searchRectangle, ByType type, File image, Option... options) {
        this.locator = locator;
        this.searchRectangle = searchRectangle;
        this.type = type;
        this.image = image;
        this.options = new ArrayList<Option>(Arrays.asList(options));

    }

    public File getImageFile(){
        return image;
    }

    /**
     * Create a by using an image from the EggPlant test suite. Use a path relative to the {@link Config} suitePath.
     * @param path Path to the image asset. Can either refer to a specific file, or to an EggPlant image collection.
     * @param options Optional parameters to control search and discovery of the element.
     * @return The constructed {@link By}.
     */
    public static By Image(String path, ImageOption... options) {
        return Image(path, null, options);
    }

    /**
     * Create a by using an image from the EggPlant test suite. Use a path relative to the {@link Config} suitePath.
     * @param path Path to the image asset. Can either refer to a specific file, or to an EggPlant image collection.
     * @param searchRectangle The on-screen {@link SearchRectangle} to limit searching to.
     * @param options Optional parameters to control search and discovery of the element.
     * @return The constructed {@link By}.
     */
    public static By Image(String path, SearchRectangle.Quadrants searchRectangle, ImageOption... options) {
        String locatorString = String.format("(image: \"%s\"", path);

//        if (searchRectangle != null) {
//            locatorString += ", " + Option.searchRectangle(searchRectangle).getText();
//        }
//        for (ImageOption option : options) {
//            locatorString += ", " + option.getText();
//        }
//        locatorString += ")";
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
        return new By(locatorString, searchRectangle, ByType.image,file,options);
    }

    /**
     * Create a {@link By} using text. When used in an {@link EggplantElement}, Solanum uses EggPlant's OCR capability to locate the text.
     * @param text Text to search for.
     * @param options Optional parameters to control search and discovery of the element.
     * @return The constructed {@link By}.
     */
    public static By Text(String text, TextOption... options) {
        return Text(text, null, options);
    }
    /**
     * Create a {@link By} using text. When used in an {@link EggplantElement}, Solanum uses EggPlant's OCR capability to locate the text.
     * @param text Text to search for.
     * @param searchRectangle The on-screen {@link SearchRectangle} to limit searching to.
     * @param options Optional parameters to control search and discovery of the element.
     * @return The constructed {@link By}.
     */
    public static By Text(String text, SearchRectangle.Quadrants searchRectangle, TextOption... options) {
        String locatorString = String.format("(text: \"%s\"", text);
//        if (searchRectangle != null) {
//            locatorString += ", " + Option.searchRectangle(searchRectangle).getText();
//        }
//        for (TextOption option : options) {
//            locatorString += ", " + option.getText();
//        }
//        locatorString += ")";
        return new By(locatorString, searchRectangle, ByType.text,null, options);
    }

    /**
     * Create a {@link By} which references an on-screen pixel location.
     * @param point The on-screen pixel location.
     * @return The constructed {@link By}.
     */
    public static By Point(Point point) {
        String locatorString = String.format("(%s,%s", point.getX(), point.getY());
        return new By(locatorString, ByType.point);
    }

    public SearchRectangle getSearchRectangle() {
        return SearchRectangle.getRectangleFromQuadrant(searchRectangle);
    }

    public void updateOptions(Option... newOptions){
        ArrayList<Option> finalOptions = new ArrayList<Option>();
        for(Option newOption : newOptions){
           String[] toks =  newOption.getText().split(":");
            if(options.size()==0){
              finalOptions = new ArrayList<Option>(Arrays.asList(newOptions));
            }
            for(Option currentOption : this.options){
                if(currentOption.getText().contains(toks[0]))
                {
                    finalOptions.add(newOption);
                }
                else {
                    finalOptions.add(currentOption);
                }
            }

        }
        this.options = finalOptions;
    }

    private String buildLocatorString(){
        String fullLocatorString = locator;
        if (searchRectangle != null) {
            fullLocatorString += ", " + Option.searchRectangle(getSearchRectangle()).getText();
        }
        for (Option option : options) {
            fullLocatorString += ", " + option.getText();
        }
        fullLocatorString += ")";
        return fullLocatorString;
    }
}
