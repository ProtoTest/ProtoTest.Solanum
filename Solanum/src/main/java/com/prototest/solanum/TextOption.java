package com.prototest.solanum;

import java.awt.*;

/**
 * This class helps build optional search parameters for use in the By class.  Contains methods for all available options when searching by text (OCR).
 * Full list available here : http://docs.testplant.com/?q=content/text-commands-and-functions
 * http://docs.testplant.com/?q=content/finding-text
 */
public class TextOption extends Option {

    /**
     * Create a TextOption using a string in the format "Option : \"Value\""
     */
    public TextOption(String text) {
        super(text);
    }

    /**
     * Specify whether contrast is on.  Use this for basic two color text values (like white text with a red background).
     */
    public static  TextOption contrast(boolean contrastOn){
        if(contrastOn){
            return new TextOption("Contrast: \"On\"");
        }
        return new TextOption("Contrast: \"Off\"");
    }

//    public static TextOption searchRectangle(SearchRectangle searchRectangle){
//        return new TextOption(String.format("SearchRectangle: (%s,%s,%s,%s)",searchRectangle.upperLeft.x,searchRectangle.upperLeft.y,searchRectangle.lowerRight.x,searchRectangle.lowerRight.y));
//    }

    /**
     * Specify internal eggplant wait time.
     */
    public static TextOption waitFor(int value){
        return new TextOption(String.format("WaitFor: %s", value));
    }

    /**
     * Specify whether the text search should be case sensitive.
     */
    public static TextOption caseSensitive(boolean caseSensitive){
        if(caseSensitive){
            return new TextOption("CaseSensitive: \"Yes\"");
        }
        return new TextOption("CaseSensitive: \"No\"");
    }

    /**
     * Specify the background color for use in the OCR search.
     */
    public static TextOption contrastColor(String value){
            return new TextOption(String.format("ContrastColor: \"%s\"",value));
    }

    /**
     * Specify the TextStyle used in the OCR search.  This is a specific value from the eggplant documentation.
     */
    public static TextOption textStyle(String value){
        return new TextOption(String.format("TextStyle: \"%s\"",value));
    }

    /**
     * When contrast is on, this is the number of pixels that can differ from the contrast color and still match.
     */
    public static TextOption contrastTolerance(String value){
        return new TextOption(String.format("ContrastTolerance: %s",value));
    }

    /**
     * Dots per inch of the screen.
     */
    public static TextOption dpi(String value){
        return new TextOption(String.format("DPI: %s",value));
    }

    /**
     * Ignore spaces when searching for text.
     */
    public static TextOption ignoreSpaces(boolean ignoreSpaces){
        return new TextOption(String.format("IgnoreSpaces: %s",ignoreSpaces));
    }

    /**
     * Ignore underscores when searching for text.
     */
    public static TextOption ignoreUnderscores(boolean ignoreSpaces){
        return new TextOption(String.format("IgnoreUnderscores: %s",ignoreSpaces));
    }

    /**
     * Specify the language used in the application. Possible values : English, French, German, etc.
     */
    public static TextOption language(String value){
        return new TextOption(String.format("Language: \"%s\"",value));
    }

    /**
     * Specify the valid characters associated with a search.  Use this to eliminate characters from the search.
     */
    public static TextOption validCharacters(String value){
        return new TextOption(String.format("ValidCharacters: \"%s\"",value));
    }

    /**
     * Specify the HotSpot using a point.  These values will be added to the actual x,y coordinates of the image for any actions, like clicking.
     * Use this to click next to an image, instead of on top of it.
     */
    public static TextOption hotSpot(Point hotSpot){
        return new TextOption(String.format("HotSpot: (%s,%s)",hotSpot.getX(),hotSpot.getY()));
    }

    /**
     * Specify a hotSpot using percentages, which get the current screen size and adjust dynamically.
     */
    public static TextOption hotSpot(int percentX, int percentY){
        Point maxSize = EggplantTestBase.getDriver().getScreenSize();

        int pixelsX = (int)(maxSize.x*(percentX/100.0f));
        int pixelsY = (int)(maxSize.y*(percentY/100.0f));
        return new TextOption(String.format("HotSpot: (%s,%s)",pixelsX,pixelsY));
    }
}
