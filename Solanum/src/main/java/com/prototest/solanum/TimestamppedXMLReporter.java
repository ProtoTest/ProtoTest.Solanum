package com.prototest.solanum;

import org.testng.ISuite;
import org.testng.reporters.XMLReporter;
import org.testng.xml.XmlSuite;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 */
public class TimestamppedXMLReporter extends XMLReporter {
    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectoryName) {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM_dd_yyyy__HH_mm");
        File outputDirectory = new File(outputDirectoryName, dateFormat.format(now).toString());
        outputDirectory.mkdir();

        super.generateReport(xmlSuites, suites, outputDirectory.toString());    //To change body of overridden methods use File | Settings | File Templates.
    }
}
