package com.prototest.solanum;

import java.awt.*;

/**
 * This class helps build optional search parameters for use int he By class.  Contains static methods for building all available options when searching for images.
 */
public class ImageOption extends Option {

    /**
     * Creates an image option using the specified text value.  Should use format Option: Value.
     * However all currently available options can be gotten using static methods below.
     * http://docs.testplant.com/?q=content/image-references
     */
    private ImageOption(String text) {
        super(text);
    }

    /**
     * Specify the SearchType: Precise, Tolerant, or Text
     */
    public static ImageOption searchType(String value){
        return new ImageOption(String.format("SearchType: \"%s\"",value));
    }

    /**
     * Specify the Tolerance : integar value that represents the acceptable color difference between each pixels
     */
    public static ImageOption tolerance(String value){
        return new ImageOption(String.format("Tolerance: %s",value));
    }

    /**
     * Specify the Discrepency (integer) : the percentage of pixels that can differ
     */
    public static ImageOption discrepancy(String value){
        return new ImageOption(String.format("Discrepancy: %s",value));
    }
    /**
     * Specify whether the search allows for Pulsing images
     */
    public static ImageOption pulsing(String value){
        return new ImageOption(String.format("Pulsing: %s",value));
    }

    /**
     * Specify the amount of internal eggplant wait Time.
     */
    public static ImageOption waitFor(int value){
        return new ImageOption(String.format("WaitFor: %s", value));
    }

    /**
     * Specify the HotSpot using a point.  These values will be added to the actual x,y coordinates of the image for any actions, like clicking.
     * Use this to click next to an image, instead of on top of it.
     */
    public static ImageOption hotSpot(Point hotSpot){
        return new ImageOption(String.format("HotSpot: (%s,%s)",hotSpot.getX(),hotSpot.getY()));
    }

    /**
     * Specify a hotSpot using percentages, which get the current screen size and adjust dynamically.
     */
    public static ImageOption hotSpot(int percentX, int percentY){
        Point maxSize = EggplantTestBase.driver.getScreenSize();

        int pixelsX = (int)(maxSize.x*(percentX/100.0f));
        int pixelsY = (int)(maxSize.y*(percentY/100.0f));
        return new ImageOption(String.format("HotSpot: (%s,%s)",pixelsX,pixelsY));
    }

}
