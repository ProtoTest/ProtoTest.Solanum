package com.prototest.solanum;


import java.awt.*;

/**
 * Created by Brian on 5/12/2014.
 */
public class SearchRectangle {
    public Rectangle searchRectangle;
    public Point upperLeft;
    public Point lowerRight;
    public int width;
    public int height;

    public SearchRectangle(Rectangle rectangle)
    {
        this.searchRectangle = rectangle;
        this.upperLeft = rectangle.getLocation();
        this.width = rectangle.width;
        this.height = rectangle.height;
        this.lowerRight = new Point(upperLeft.x+width,upperLeft.y+height);
    }

    public SearchRectangle(Point upperLeft, Point lowerRight)
    {
        this.upperLeft = upperLeft;
        this.lowerRight = lowerRight;
        this.width = Math.abs(upperLeft.x - lowerRight.x);
        this.height = Math.abs(upperLeft.y - lowerRight.y);
        this.searchRectangle = new Rectangle(upperLeft.x,upperLeft.y,this.width,this.height);

    }

    public static SearchRectangle topHalf()
    {
        Rectangle fullScreen = EggplantTestBase.driver.getScreenRectangle();
        return new SearchRectangle(new Point(0,0),new Point(fullScreen.width,fullScreen.height/2));
    }

    public static SearchRectangle bottomHalf()
    {
        Rectangle fullScreen = EggplantTestBase.driver.getScreenRectangle();
        return new SearchRectangle(new Point(0, fullScreen.height/2), new Point(fullScreen.width, fullScreen.height));
    }

    public static SearchRectangle middleHalf()
    {
        Rectangle fullScreen = EggplantTestBase.driver.getScreenRectangle();
            int value = (int) Math.floor(fullScreen.height*.25);
            return new SearchRectangle(new Point(0, value), new Point(fullScreen.width, (int)Math.floor(fullScreen.height * .75)));
    }

    public static SearchRectangle topQuarter()
    {
        Rectangle fullScreen = EggplantTestBase.driver.getScreenRectangle();
       return new SearchRectangle(new Point(0, 0), new Point(fullScreen.width, fullScreen.height / 4));
    }

    public static SearchRectangle bottomQuarter()
    {
        Rectangle fullScreen = EggplantTestBase.driver.getScreenRectangle();
        int value = (int) Math.floor(fullScreen.height*.75);
        return new SearchRectangle(new Point(0, value), new Point(fullScreen.width, fullScreen.height));

    }

    public static SearchRectangle rightHalf()
    {
        Rectangle fullScreen = EggplantTestBase.driver.getScreenRectangle();
        return new SearchRectangle(new Point(fullScreen.width/2,0),new Point(fullScreen.width,fullScreen.height));
    }

    public static SearchRectangle leftHalf()
    {
        Rectangle fullScreen = EggplantTestBase.driver.getScreenRectangle();
        return new SearchRectangle(new Point(0, 0), new Point(fullScreen.width/2, fullScreen.height));
    }

    public static SearchRectangle leftQuarter()
    {
        Rectangle fullScreen = EggplantTestBase.driver.getScreenRectangle();
        return new SearchRectangle(new Point(0, 0), new Point(fullScreen.width/4, fullScreen.height));
    }

    public static SearchRectangle rightQuarter() {
        Rectangle fullScreen = EggplantTestBase.driver.getScreenRectangle();
        int value = (int) Math.floor(fullScreen.width * .75);
        return new SearchRectangle(new Point(value, 0), new Point(fullScreen.width, fullScreen.height));
    }

    public SearchRectangle trimTop(int amount) {
        upperLeft.setLocation(upperLeft.getX(), upperLeft.getY() + amount);
    public SearchRectangle trimTop(int screenPercentage) {
        Rectangle fullScreen = EggplantTestBase.driver.getScreenRectangle();
        upperLeft.setLocation(upperLeft.getX(), upperLeft.getY() + fullScreen.getHeight()*screenPercentage/100.0);
        return this;
    }

    public SearchRectangle trimBottom(int screenPercentage) {
        Rectangle fullScreen = EggplantTestBase.driver.getScreenRectangle();
        lowerRight.setLocation(lowerRight.getX(), lowerRight.getY() - fullScreen.getHeight()*screenPercentage/100.0);
        return this;
    }

    public SearchRectangle trimRight(int screenPercentage) {
        Rectangle fullScreen = EggplantTestBase.driver.getScreenRectangle();
        lowerRight.setLocation(lowerRight.getX() - fullScreen.getHeight()*screenPercentage/100.0, lowerRight.getY());
        return this;
    }

    public SearchRectangle trimLeft( int screenPercentage) {
        Rectangle fullScreen = EggplantTestBase.driver.getScreenRectangle();
        lowerRight.setLocation(upperLeft.getX() + fullScreen.getHeight()*screenPercentage/100.0, lowerRight.getY());
        return this;

    }
}
