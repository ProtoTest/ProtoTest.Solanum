package com.prototest.solanum;

import com.sun.javafx.css.Size;

import java.awt.*;

/**
 * Created by Brian on 5/12/2014.
 */
public class SearchRectangle {
    public Rectangle searchRectangle = null;
    public Point upperLeft;
    public Point lowerRight;
    public int width;
    public int height;
    public static String xPoint;
    public static String yPoint;
    public static SearchRectangle fullScreen;


    public SearchRectangle(Rectangle rectangle)
    {
        this.searchRectangle = rectangle;
        this.upperLeft = rectangle.getLocation();
        this.width = upperLeft.x - lowerRight.y;
        this.height = upperLeft.x - lowerRight.y;
        this.lowerRight = new Point(upperLeft.x+width,upperLeft.y+height);
        //this.fullScreen = EggplantTestBase.driver.getScreenRectangle();
    }

    public SearchRectangle(Point upperLeft, Point lowerRight)
    {
        this.upperLeft = upperLeft;
        this.lowerRight = lowerRight;
        this.width = Math.abs(upperLeft.x - lowerRight.x);
        this.height = Math.abs(upperLeft.y - lowerRight.y);
        this.searchRectangle = new Rectangle(upperLeft.x,upperLeft.y,this.width,this.height);
        //this.fullScreen = EggplantTestBase.driver.getScreenRectangle();
    }

    public static SearchRectangle topHalf()
    {
        return new SearchRectangle(new Point(0,0),new Point(fullScreen.width,fullScreen.height/2));
    }

    public static SearchRectangle bottomHalf()
    {
        return new SearchRectangle(new Point(0, fullScreen.height/2), new Point(fullScreen.width, fullScreen.height));
    }

    public static SearchRectangle middleHalf()
    {
            int value = (int) Math.floor(fullScreen.height*.25);
            return new SearchRectangle(new Point(0, value), new Point(fullScreen.width, (int)Math.floor(fullScreen.height * .75)));
    }

    public static SearchRectangle topQuarter()
    {
       return new SearchRectangle(new Point(0, 0), new Point(fullScreen.width, fullScreen.height / 4));
    }

    public static SearchRectangle bottomQuarter()
    {
        int value = (int) Math.floor(fullScreen.height*.75);
        return new SearchRectangle(new Point(0, value), new Point(fullScreen.width, fullScreen.height));

    }
}
