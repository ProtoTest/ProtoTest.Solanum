package com.prototest.solanum;

import java.awt.*;

/**
 * Created by Brian on 5/12/2014.
 */
public class SearchOptions {

    public String imageName;
    public Point hotSpot;
    public String searchType;
    public Integer tolerance;
    public Integer discrepancy;
    public Boolean pulsing;
    public String collectionFilter;
    public Rectangle clipRectangle;
    public Rectangle searchRectangle;

    public String text;
    public String textStyle;
    public Boolean caseSensitive;
    public Boolean contrast;
    public String contrastColor;
    public Boolean contrastTolerance;
    public Integer dpi;
    public Boolean ignoreSpaces;
    public Boolean ignoreUnderscores;
    public String language;
    public String validCharacters;

    public String getImageString() {
        String result = "";
        if(hotSpot!=null){
            result+= String.format(", HotSpot: (%s,%s)",hotSpot.getX(),hotSpot.getY());
        }
        if(searchType!=null){
            result+= String.format(", SearchType: \"%s\"",searchType);
        }
        if(tolerance!=null){
            result+= String.format(", Tolerance: %s",tolerance);
        }
        if(discrepancy!=null){
            result+= String.format(", Discrepancy: %s",discrepancy);
        }
        if(pulsing!=null){
            result+= String.format(", Pulsing: %s",pulsing);
        }
        if(collectionFilter!=null){
            result+= String.format(", CollectionFilter: (Name: \"%s\")",collectionFilter);
        }

        if(clipRectangle==null){
            result+= String.format(", ClipRectangle: (%s,%s,%s,%s)",clipRectangle.getX(),clipRectangle.getY(),clipRectangle.getX()+clipRectangle.getWidth(),clipRectangle.getY()+clipRectangle.getHeight());
        }
        if(collectionFilter==null){
            result+= String.format(",SearchRectangle: (%s,%s,%s,%s)",searchRectangle.getX(),searchRectangle.getY(),searchRectangle.getX()+searchRectangle.getWidth(),searchRectangle.getY()+searchRectangle.getHeight());
        }
        return result;
    }

    public String getTextString() {
        String result = "";

        if(textStyle!=null){
            result+= String.format(", TextStyle: \"%s\"",textStyle);
        }
        if(caseSensitive!=null){
            result+= String.format(", CaseSensitive: %s",caseSensitive);
        }
        if(contrast!=null){
            result+= String.format(", Contrast: %s",contrast);
        }
        if(contrastColor!=null){
            result+= String.format(", ContrastColor: \"%s\"",contrastColor);
        }
        if(contrastTolerance!=null){
            result+= String.format(", ContrastTolerance: %s",contrastTolerance);
        }
        if(dpi!=null){
            result+= String.format(", DPI: %s",dpi);
        }
        if(ignoreSpaces!=null){
            result+= String.format(", IgnoreSpaces: %s",ignoreSpaces);
        }
        if(ignoreUnderscores!=null){
            result+= String.format(", IgnoreUnderscores: %s",ignoreUnderscores);
        }
        if(language!=null){
            result+= String.format(", Language: \"%s\"",ignoreSpaces);
        }
        if(validCharacters!=null){
            result+= String.format(", ValidCharacters: \"%s\"",ignoreSpaces);
        }
        return result;
    }

    public SearchOptions(String imageName){
        this.imageName = imageName;
    }
    public SearchOptions(String imageName, Rectangle searchRectangle){
        this.imageName = imageName;
        this.searchRectangle = searchRectangle;
    }


}
