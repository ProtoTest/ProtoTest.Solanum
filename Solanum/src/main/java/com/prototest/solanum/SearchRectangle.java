package com.prototest.solanum;


import java.awt.*;

/**
 * A SearchRectangle specifies a specific section of the screen to perform a search in.  It helps improve accuracy.
 * Mainly this class is used for helper methods to generate search rectangles in a format the eggplant can digest.
 * Also contains static methods that can be used to dynamically get quadrants of the screen without needing to know the resolution or x,y coordinates.
 */
public class SearchRectangle {
    public enum Quadrants{WHOLE_SCREEN,TOP_QUARTER,TOP_HALF, BOTTOM_QUARTER, BOTTOM_HALF,LEFT_QUARTER,LEFT_HALF,RIGHT_QUARTER,RIGHT_HALF,MIDDLE_HALF}
    public Rectangle searchRectangle;
    public Point upperLeft;
    public Point lowerRight;
    public int width;
    public int height;

    /**
     * Create a SearchRectangle using a standard Rectangle class.
     * */
    public SearchRectangle(Rectangle rectangle) {
        this.searchRectangle = rectangle;
        this.upperLeft = rectangle.getLocation();
        this.width = rectangle.width;
        this.height = rectangle.height;
        this.lowerRight = new Point(upperLeft.x + width, upperLeft.y + height);
    }

    /**
     * Create a search rectangle using two points
     */
    public SearchRectangle(Point upperLeft, Point lowerRight) {
        this.upperLeft = upperLeft;
        this.lowerRight = lowerRight;
        this.width = Math.abs(upperLeft.x - lowerRight.x);
        this.height = Math.abs(upperLeft.y - lowerRight.y);
        this.searchRectangle = new Rectangle(upperLeft.x, upperLeft.y, this.width, this.height);

    }

    private void calculateSearchRectangle(){
        this.upperLeft = upperLeft;
        this.lowerRight = lowerRight;
        this.width = Math.abs(upperLeft.x - lowerRight.x);
        this.height = Math.abs(upperLeft.y - lowerRight.y);
        this.searchRectangle = new Rectangle(upperLeft.x, upperLeft.y, this.width, this.height);
    }

    public static SearchRectangle getRectangleFromQuadrant(SearchRectangle.Quadrants quadrant){
        if(quadrant==null) return null;
        switch (quadrant){
            case WHOLE_SCREEN:
                return wholeScreen();
            case TOP_HALF :
                return topHalf();
            case BOTTOM_HALF:
                return bottomHalf();
            case TOP_QUARTER:
                return topQuarter();
            case BOTTOM_QUARTER:
                return bottomQuarter();
            case MIDDLE_HALF:
                return middleHalf();
            case RIGHT_HALF:
                return rightHalf();
            case RIGHT_QUARTER:
                return rightQuarter();
            case LEFT_HALF:
                return leftHalf();
            case LEFT_QUARTER:
                return leftQuarter();
            default: return null;
        }
    }

    /**
     * Returns a search rectangle corresponding to the entire device screen.
     */
    public static SearchRectangle wholeScreen() {
        Rectangle fullScreen = EggplantTestBase.getDriver().getScreenRectangle();
        return new SearchRectangle(fullScreen);
    }

    /**
     * Returns a search rectangle corresponding to the top half of the screen
     */
    public static SearchRectangle topHalf() {
        Rectangle fullScreen = EggplantTestBase.getDriver().getScreenRectangle();
        return new SearchRectangle(new Point(0, 0), new Point(fullScreen.width, fullScreen.height / 2));
    }

    /**
     * Returns a search rectangle corresponding to the bottom half of the screen
     */
    public static SearchRectangle bottomHalf() {
        Rectangle fullScreen = EggplantTestBase.getDriver().getScreenRectangle();
        return new SearchRectangle(new Point(0, fullScreen.height / 2), new Point(fullScreen.width, fullScreen.height));
    }

    /**
     * Returns a search rectangle corresponding to the middle part of the screen.  This is essentially the 25-75% of the screen height.
     */
    public static SearchRectangle middleHalf() {
        Rectangle fullScreen = EggplantTestBase.getDriver().getScreenRectangle();
        int value = (int) Math.floor(fullScreen.height * .25);
        return new SearchRectangle(new Point(0, value), new Point(fullScreen.width, (int) Math.floor(fullScreen.height * .75)));
    }

    /**
     * Returns a search rectangle corresponding to the top quarter of the screen
     */
    public static SearchRectangle topQuarter() {
        Rectangle fullScreen = EggplantTestBase.getDriver().getScreenRectangle();
        return new SearchRectangle(new Point(0, 0), new Point(fullScreen.width, fullScreen.height / 4));
    }

    /**
     * Returns a search rectangle corresponding to the bottom quarter of the screen
     */
    public static SearchRectangle bottomQuarter() {
        Rectangle fullScreen = EggplantTestBase.getDriver().getScreenRectangle();
        int value = (int) Math.floor(fullScreen.height * .75);
        return new SearchRectangle(new Point(0, value), new Point(fullScreen.width, fullScreen.height));

    }

    /**
     * Returns a search rectangle corresponding to the right half of the screen
     */
    public static SearchRectangle rightHalf() {
        Rectangle fullScreen = EggplantTestBase.getDriver().getScreenRectangle();
        return new SearchRectangle(new Point(fullScreen.width / 2, 0), new Point(fullScreen.width, fullScreen.height));
    }

    /**
     * Returns a search rectangle corresponding to the left half of the screen
     */
    public static SearchRectangle leftHalf() {
        Rectangle fullScreen = EggplantTestBase.getDriver().getScreenRectangle();
        return new SearchRectangle(new Point(0, 0), new Point(fullScreen.width / 2, fullScreen.height));
    }

    /**
     * Returns a search rectangle corresponding to the top quarter of the screen
     */
    public static SearchRectangle leftQuarter() {
        Rectangle fullScreen = EggplantTestBase.getDriver().getScreenRectangle();
        return new SearchRectangle(new Point(0, 0), new Point(fullScreen.width / 4, fullScreen.height));
    }

    /**
     * Returns a search rectangle corresponding to the right quarter of the screen
     */
    public static SearchRectangle rightQuarter() {
        Rectangle fullScreen = EggplantTestBase.getDriver().getScreenRectangle();
        int value = (int) Math.floor(fullScreen.width * .75);
        return new SearchRectangle(new Point(value, 0), new Point(fullScreen.width, fullScreen.height));
    }

    /**
     * Removes a section from a search rectangle corresponding to a percentage from the top.
     */
    public SearchRectangle trimTop(int screenPercentage) {
        height *= screenPercentage / 100.0;
        upperLeft.setLocation(upperLeft.getX(), upperLeft.getY() + height);
        return new SearchRectangle(upperLeft, lowerRight);
    }

    /**
     * Removes a section from a search rectangle corresponding to a percentage from the bottom.
     */
    public SearchRectangle trimBottom(int screenPercentage) {
        height *= screenPercentage / 100.0;
        lowerRight.setLocation(lowerRight.getX(), lowerRight.getY() - height);
        return new SearchRectangle(upperLeft, lowerRight);
    }
    /**
     * Removes a section from a search rectangle corresponding to a percentage from the right
     */
    public SearchRectangle trimRight(int screenPercentage) {
        width *= screenPercentage / 100.0;
        lowerRight.setLocation(lowerRight.getX() - width, lowerRight.getY());
        return new SearchRectangle(upperLeft, lowerRight);
    }
    /**
     * Removes a section from a search rectangle corresponding to a percentage from the left.
     */
    public SearchRectangle trimLeft(int screenPercentage) {
        width *= screenPercentage / 100.0;
        upperLeft.setLocation(upperLeft.getX() + width, upperLeft.getY() + height);
        return new SearchRectangle(upperLeft, lowerRight);

    }
}
