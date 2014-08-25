package com.prototest.solanum;

import org.testng.Reporter;

import javax.imageio.ImageIO;
import javax.media.jai.JAI;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * This class contains global logging methods, using the config file to configure level and format.
 */
public class Logger {

    /**
     * Log Info, this is the highest level of logging. Should be used for logging test intent, and actions.
     */
    public static void info(String text) {
        if (Config.logLevel > 1) return;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
        String timestamp = sdf.format(date);
        text = String.format("INFO : [%s] (%s)  %s", timestamp, CurrentContext.getCurrentContext(), text);
        System.out.println(text);
        Reporter.log(String.format("<div style=\"color:Blue\">%s</div>", text));
    }

    /**
     * Log Debug, this is designed for debug information, used to determine why a test is failing.
     */
    public static void debug(String text) {
        if (Config.logLevel > 0) return;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
        String timestamp = sdf.format(date);
        text = String.format("DEBUG : [%s] (%s)  %s", timestamp, CurrentContext.getCurrentContext(), text);
        System.out.println(text);
        Reporter.log(String.format("<div>%s</div>", text));
    }

    /**
     * Log A Warning.  Use this when something went wrong, but may not be critical for test success.  Will show up yellow in the report.
     */
    public static void warning(String text) {
        if (Config.logLevel > 2) return;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
        String timestamp = sdf.format(date);
        text = String.format("WARNING : [%s] (%s)  %s", timestamp, CurrentContext.getCurrentContext(), text);
        System.out.println(text);
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        Reporter.log(String.format("<div style=\"background-color:yellow\">%s</div>", text));
    }
    /**
     * Log an Error.  Used when something went terminally wrong, but test execution doesn't need to be stopped.  Will show up red in the HTML log.
     */
    public static void error(String text) {
        if (Config.logLevel > 3) return;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
        String timestamp = sdf.format(date);
        text = String.format("ERROR : [%s] (%s)  %s", timestamp, CurrentContext.getCurrentContext(), text);
        System.out.println(text);
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        Reporter.log(String.format("<div style=\"background-color:red; color:white\">%s</div>", text));
    }

    /**
     * Capture a screenshot and include it in the log, using a random file name.
     */
    public static void screenshot() {
        screenshot("", null);
    }


    /**
     * Capture a screenshot and include it in the log, using a random file name.
     * Highlight the given search rectangle, to show where the search was looking.
     */
    public static void screenshot(Rectangle drawRectangle) {
        screenshot("", drawRectangle);
    }


    /**
     * Capture a screenshot and include it in the log, using the specified file path.
     */
    public static void screenshot(String name) {
        screenshot(name, null);
    }

    /**
     * Capture a screenshot and include it in the log, using the specified file path.
     * Highlight the given search rectangle, to show where the search was looking.
     */
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
            String[] fileSplitPath = newScreenshot.split("\\\\/?");
            String relativePath = "../Screenshots/" + fileSplitPath[fileSplitPath.length-1];
            ImageIO.write(resizedImage, "png", fos);
            System.setProperty("org.uncommons.reportng.escape-output", "false");
            Reporter.log(String.format("<img src=\"%s\"/>", relativePath));
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

    /**
     * Log an image to the report that already exists, using a specific file name.
     */
    public static void image(File image) {
        if (image.exists())
            Reporter.log(String.format("<img src=\"%s\"/>", image.getAbsolutePath()));
        else
            warning("Could not log image, as the path was incorrect : " + image.getAbsolutePath());
    }

    /**
     * Log a list of images paths to the HTML report.  They should already exist.
     */
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
