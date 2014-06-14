package com.prototest.solanum;

import com.sun.media.jai.codec.ImageEncodeParam;
import com.sun.media.jai.codec.TIFFEncodeParam;
import com.sun.media.jai.codecimpl.TIFFCodec;
import com.sun.media.jai.codecimpl.TIFFImageDecoder;
import org.apache.commons.io.IOUtils;
import org.testng.Reporter;

import javax.imageio.ImageIO;
import javax.media.jai.JAI;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;

// Solanum's logging options

public class Logger {

    static {
        System.setProperty("org.uncommons.reportng.escape-output", "false");
    }

    public static void info(String text) {
        if (Config.logLevel > 1) return;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss SSS");
        String timestamp = sdf.format(date);
        text = String.format("[%s]   %s", timestamp, text);
        System.out.println(text.toUpperCase());
        Reporter.log(String.format("<div style=\"color:Blue\">%s</div>", text));
    }

    public static void debug(String text) {
        if (Config.logLevel > 0) return;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss SSS");
        String timestamp = sdf.format(date);
        text = String.format("[%s] %s", timestamp, text);
        System.out.println(text);
        Reporter.log(String.format("<div>%s</div>", text));
    }

    public static void warning(String text) {
        if (Config.logLevel > 2) return;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss SSS");
        String timestamp = sdf.format(date);
        text = String.format("(%s) ----! WARNING: %s", timestamp, text);

        System.out.println(text);
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        Reporter.log(String.format("<div style=\"background-color:yellow\">%s</div>", text));
    }

    public static void error(String text) {
        if (Config.logLevel > 3) return;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss SSS");
        String timestamp = sdf.format(date);
        text = String.format("(%s) !---- ERROR: %s", timestamp, text);
        System.out.println(text);
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        Reporter.log(String.format("<div style=\"background-color:red; color:white\">%s</div>", text));
    }

    public static void screenshot() {
        screenshot("", null);
    }

    public static void screenshot(Rectangle drawRectangle) {
        screenshot("", drawRectangle);
    }

    public static void screenshot(String name) {
        screenshot(name, null);
    }

    public static void screenshot(String name, Rectangle drawRectangle) {
        Logger.info("Capturing device screenshot...");
        String newScreenshot = EggplantTestBase.driver.getScreenshot(name);

        BufferedImage image = JAI.create("fileload", newScreenshot).getAsBufferedImage();

        if (drawRectangle != null) {

            Graphics2D g = (Graphics2D) image.getGraphics();
            g.setColor(new Color(255, 165, 0, 50));
            g.fillRect(drawRectangle.x, drawRectangle.y, drawRectangle.width, drawRectangle.height);
            g.setColor(Color.orange);
            g.setStroke(new BasicStroke(5));
            g.drawRect(drawRectangle.x, drawRectangle.y, drawRectangle.width, drawRectangle.height);
            g.dispose();
        }

        int resizedWidth = image.getWidth() / 2;
        int resizedHeight = image.getHeight() / 2;
        BufferedImage resizedImage = new BufferedImage(resizedWidth, resizedHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = resizedImage.createGraphics();
        g2.drawImage(image, 0, 0, resizedWidth, resizedHeight, null);
        g2.dispose();

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(newScreenshot);
            ImageIO.write(resizedImage, "png", fos);
            System.setProperty("org.uncommons.reportng.escape-output", "false");
            Reporter.log(String.format("<img src=\"%s\"/>", newScreenshot));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void image(File image) {
        if (image.exists())
            Reporter.log(String.format("<img src=\"%s\"/>", image.getAbsolutePath()));
        else
            warning("Could not log image, as the path was incorrect : " + image.getAbsolutePath());
    }

    public static void images(File[] images) {
        String outputHtml = "<div>";

        for (File image : images) {
            if (image.exists()) {
                outputHtml += String.format("<img src=\"%s\"/>", image.getAbsolutePath());
            } else
                warning("Could not log image, as the path was incorrect : " + image.getAbsolutePath());
        }
        outputHtml += "</div>";
        Reporter.log(outputHtml);

    }

}
