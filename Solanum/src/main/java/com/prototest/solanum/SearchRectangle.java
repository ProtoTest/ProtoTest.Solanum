package com.prototest.solanum;


import java.awt.*;

/**
 *
 */
public class SearchRectangle {
    public Rectangle searchRectangle;
    // TODO: duplicated data; which set of fields is actually used?
    public Point upperLeft;
    public Point lowerRight;
    public int width;
    public int height;

    public SearchRectangle(Rectangle rectangle) {
        this.searchRectangle = rectangle;
        this.upperLeft = rectangle.getLocation();
        this.width = rectangle.width;
        this.height = rectangle.height;
        this.lowerRight = new Point(upperLeft.x + width, upperLeft.y + height);
    }

    public SearchRectangle(Point upperLeft, Point lowerRight) {
        this.upperLeft = upperLeft;
        this.lowerRight = lowerRight;
        this.width = Math.abs(upperLeft.x - lowerRight.x);
        this.height = Math.abs(upperLeft.y - lowerRight.y);
        this.searchRectangle = new Rectangle(upperLeft.x, upperLeft.y, this.width, this.height);

    }

    public static SearchRectangle topHalf() {
        Rectangle fullScreen = EggplantTestBase.driver.getScreenRectangle();
        return new SearchRectangle(new Point(0, 0), new Point(fullScreen.width, fullScreen.height / 2));
    }

    public static SearchRectangle bottomHalf() {
        Rectangle fullScreen = EggplantTestBase.driver.getScreenRectangle();
        return new SearchRectangle(new Point(0, fullScreen.height / 2), new Point(fullScreen.width, fullScreen.height));
    }

    public static SearchRectangle middleHalf() {
        Rectangle fullScreen = EggplantTestBase.driver.getScreenRectangle();
        int value = (int) Math.floor(fullScreen.height * .25);
        return new SearchRectangle(new Point(0, value), new Point(fullScreen.width, (int) Math.floor(fullScreen.height * .75)));
    }

    public static SearchRectangle topQuarter() {
        Rectangle fullScreen = EggplantTestBase.driver.getScreenRectangle();
        return new SearchRectangle(new Point(0, 0), new Point(fullScreen.width, fullScreen.height / 4));
    }

    public static SearchRectangle bottomQuarter() {
        Rectangle fullScreen = EggplantTestBase.driver.getScreenRectangle();
        int value = (int) Math.floor(fullScreen.height * .75);
        return new SearchRectangle(new Point(0, value), new Point(fullScreen.width, fullScreen.height));

    }

    public static SearchRectangle rightHalf() {
        Rectangle fullScreen = EggplantTestBase.driver.getScreenRectangle();
        return new SearchRectangle(new Point(fullScreen.width / 2, 0), new Point(fullScreen.width, fullScreen.height));
    }

    public static SearchRectangle leftHalf() {
        Rectangle fullScreen = EggplantTestBase.driver.getScreenRectangle();
        return new SearchRectangle(new Point(0, 0), new Point(fullScreen.width / 2, fullScreen.height));
    }

    public static SearchRectangle leftQuarter() {
        Rectangle fullScreen = EggplantTestBase.driver.getScreenRectangle();
        return new SearchRectangle(new Point(0, 0), new Point(fullScreen.width / 4, fullScreen.height));
    }

    public static SearchRectangle rightQuarter() {
        Rectangle fullScreen = EggplantTestBase.driver.getScreenRectangle();
        int value = (int) Math.floor(fullScreen.width * .75);
        return new SearchRectangle(new Point(value, 0), new Point(fullScreen.width, fullScreen.height));
    }

    public SearchRectangle trimTop(int screenPercentage) {
        height *= screenPercentage / 100.0;
        upperLeft.setLocation(upperLeft.getX(), upperLeft.getY() + height);
        return new SearchRectangle(upperLeft, lowerRight);
    }

    public SearchRectangle trimBottom(int screenPercentage) {
        height *= screenPercentage / 100.0;
        lowerRight.setLocation(lowerRight.getX(), lowerRight.getY() - height);
        return new SearchRectangle(upperLeft, lowerRight);
    }

    public SearchRectangle trimRight(int screenPercentage) {
        width *= screenPercentage / 100.0;
        lowerRight.setLocation(lowerRight.getX() - width, lowerRight.getY());
        return new SearchRectangle(upperLeft, lowerRight);
    }

    public SearchRectangle trimLeft(int screenPercentage) {
        width *= screenPercentage / 100.0;
        upperLeft.setLocation(upperLeft.getX() + width, upperLeft.getY() + height);
        return new SearchRectangle(upperLeft, lowerRight);

    }
}
