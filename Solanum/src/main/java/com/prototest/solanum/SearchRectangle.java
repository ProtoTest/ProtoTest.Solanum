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

    public SearchRectangle trimTop(int amount) {
        upperLeft.setLocation(upperLeft.getX(), upperLeft.getY() + amount);
        return this;
    }

    public SearchRectangle trimBottom(int amount) {
        lowerRight.setLocation(lowerRight.getX(), lowerRight.getY() - amount);

        return this;
    }
}
