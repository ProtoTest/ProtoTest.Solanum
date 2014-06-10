package com.prototest.solanum;

import org.testng.Assert;
import org.testng.annotations.*;

import java.awt.*;

public class ElementTests {
    @Test(groups = {"ElementName"})
    public void ElementName() {
        EggplantElement element = new EggplantElement("EmailIcon", By.Image("/path/to/image"));
        Assert.assertEquals("EmailIcon", element.getName());
    }

    @Test(groups = {"ElementName"})
    public void ElementNameDefault() {
        EggplantElement element = new EggplantElement(By.Image("/path/to/image"));
        Assert.assertEquals(element.getName(),"image--path-to-image");
    }
    @Test(groups = {"ElementName"})
    public void ElementNameWithRectangle() {
        EggplantElement element = new EggplantElement(By.Image("/path/to/image", new SearchRectangle(new Point(0,0),new Point(100,100))));
        Assert.assertEquals(element.getName(),"image--path-to-image");
    }
    @Test(groups = {"ElementName"})
    public void ElementTextNameDefault() {
        EggplantElement element = new EggplantElement(By.Text("Text Value"));
        Assert.assertEquals(element.getName(),"text-Text-Value");
    }

    @Test(groups = {"ElementLocator"})
    public void ElementByImageWithRectangle() {
        EggplantElement element = new EggplantElement("EmailIcon", By.Image("/path/to/image", new SearchRectangle(new Rectangle(0, 0, 100, 200))));
        Assert.assertEquals("(image: \"/path/to/image\", SearchRectangle: (0,0,100,200))", element.getBy().getLocator());

    }

    @Test(groups = {"ElementLocator"})
    public void ElementByImageWithImageOptions() {
        EggplantElement element = new EggplantElement("EmailIcon", By.Image("/path/to/image", new SearchRectangle(new Rectangle(0, 0, 100, 200))));
        Assert.assertEquals("(image: \"/path/to/image\", SearchRectangle: (0,0,100,200))", element.getBy().getLocator());

    }

    @Test(groups = {"ElementLocator"})
    public void ElementByTextWithPoints() {
        EggplantElement element = new EggplantElement("EmailIcon", By.Text("Email",
                new SearchRectangle(new Point(0, 0), new Point(100, 200)),
                TextOption.contrast(true), TextOption.contrastColor("AutoDetect")));
        Assert.assertEquals("(text: \"Email\", SearchRectangle: (0,0,100,200), Contrast: \"On\", ContrastColor: \"AutoDetect\")", element.getBy().getLocator());

    }



}
