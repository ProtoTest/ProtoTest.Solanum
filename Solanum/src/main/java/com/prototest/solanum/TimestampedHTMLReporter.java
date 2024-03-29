package com.prototest.solanum;

import org.apache.commons.io.FileUtils;
import org.testng.ISuite;
import org.testng.ITestNGListener;
import org.testng.xml.XmlSuite;
import org.uncommons.reportng.HTMLReporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/**
 */
public class TimestampedHTMLReporter extends HTMLReporter {
    private Date now;
    private SimpleDateFormat dateFormat;

    public TimestampedHTMLReporter(){
        now = new Date();
        dateFormat = new SimpleDateFormat("MM_dd_yyyy__HH_mm");

    }
    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectoryName) {
        if (Config.timestampHtmlLog) {

            File outputDirectory = new File(outputDirectoryName, dateFormat.format(now).toString());
            outputDirectory.mkdir();
            outputDirectoryName = outputDirectory.toString();

            System.out.println("HTMLReport : " + new File(outputDirectoryName).getAbsolutePath() + "\\html\\index.html");
        }

        try {
            FileUtils.copyDirectoryToDirectory(new File("Screenshots"), new File(outputDirectoryName));
        } catch (IOException e) {
            throw new RuntimeException("Couldn't copy screenshots", e);
        }


        super.generateReport(xmlSuites, suites, outputDirectoryName);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
