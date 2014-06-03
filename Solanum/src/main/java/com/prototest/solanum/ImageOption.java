package com.prototest.solanum;

import java.awt.*;

/**
 * Created by Brian on 5/19/2014.
 */
public class ImageOption extends Option {

    private ImageOption(String text) {
        super(text);
    }



    public static ImageOption searchType(String value){
        return new ImageOption(String.format("SearchType: \"%s\"\"",value));
    }

    public static ImageOption tolerance(String value){
        return new ImageOption(String.format("Tolerance: %s",value));
    }

    public static ImageOption discrepancy(String value){
        return new ImageOption(String.format("Discrepancy: %s",value));
    }

    public static ImageOption pulsing(String value){
        return new ImageOption(String.format("Pulsing: %s",value));
    }

    public static ImageOption waitFor(int value){
        return new ImageOption(String.format("WaitFor: %s", value));
    }

    public static ImageOption hotSpot(Point hotSpot){
        return new ImageOption(String.format("HotSpot: (%s,%s)",hotSpot.getX(),hotSpot.getY()));
    }

    public static ImageOption hotSpot(int percentX, int percentY){
        Point maxSize = EggplantTestBase.driver.getScreenSize();

        int pixelsX = (int)(maxSize.x*(percentX/100.0f));
        int pixelsY = (int)(maxSize.y*(percentY/100.0f));
        return new ImageOption(String.format("HotSpot: (%s,%s)",pixelsX,pixelsY));
    }

}
