package com.prototest.solanum;

import java.awt.*;

/**
 * Created by Brian on 5/19/2014.
 */
public class TextOption {

    private String text;

    public String getText(){
        return text;
    }
    private TextOption(String text){
        this.text = text;
    }

    public static  TextOption contrast(boolean contrastOn){
        if(contrastOn){
            return new TextOption("Contrast: \"On\"");
        }
        return new TextOption("Contrast: \"Off\"");
    }

    public static TextOption searchRectangle(SearchRectangle searchRectangle){
        return new TextOption(String.format("SearchRectangle: (%s,%s,%s,%s)",searchRectangle.upperLeft.x,searchRectangle.upperLeft.y,searchRectangle.lowerRight.x,searchRectangle.lowerRight.y));
    }

    public static TextOption waitFor(int value){
        return new TextOption(String.format("WaitFor: %s", value));
    }

    public static TextOption caseSensitive(boolean caseSensitive){
        if(caseSensitive){
            return new TextOption("CaseSensitive: \"Yes\"");
        }
        return new TextOption("CaseSensitive: \"No\"");
    }

    public static TextOption contrastColor(String value){
            return new TextOption(String.format("ContrastColor: \"%s\"",value));
    }

    public static TextOption textStyle(String value){
        return new TextOption(String.format("TextStyle: \"%s\"",value));
    }

    public static TextOption contrastTolerance(String value){
        return new TextOption(String.format("ContrastTolerance: %s",value));
    }

    public static TextOption dpi(String value){
        return new TextOption(String.format("DPI: %s",value));
    }

    public static TextOption ignoreSpaces(boolean ignoreSpaces){
        return new TextOption(String.format("IgnoreSpaces: %s",ignoreSpaces));
    }

    public static TextOption ignoreUnderscores(boolean ignoreSpaces){
        return new TextOption(String.format("IgnoreUnderscores: %s",ignoreSpaces));
    }

    public static TextOption language(String value){
        return new TextOption(String.format("Language: \"%s\"",value));
    }

    public static TextOption validCharacters(String value){
        return new TextOption(String.format("ValidCharacters: \"%s\"",value));
    }

    public TextOption hotSpot(Point hotSpot){
        return new TextOption(String.format("HotSpot: (%s,%s)",hotSpot.getX(),hotSpot.getY()));
    }
}
