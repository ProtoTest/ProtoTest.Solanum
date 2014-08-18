package com.prototest.solanum;

import java.io.*;

/**
 * Created by Brian on 7/25/2014.
 */
public class EggplantGUIHook {
    private FileWriter writer = null;
    private String scriptPath;
    private String batchFile;
    private By by;
    public EggplantGUIHook(By by){
        this.by = by;
        scriptPath = getSuitePath() + "\\scripts\\test.script";
        batchFile = getSuitePath() + "\\scripts\\runDiagnostic.bat";
    }

    private void createTempScriptFile() {
        try {
            writer = new FileWriter(scriptPath);
            writer.write (String.format("OpenSuite \"%s\"%s", Config.suitePath.replace(".suite","").split("/")[1],System.getProperty("line.separator","\r\n")));
            writer.write (String.format("Connect (ServerID:\"%s\", portNum: \"%s\")%s", Config.hostName, Config.hostPort,System.getProperty("line.separator","\r\n")));
            writer.write(String.format("WaitFor 2, %s %s",this.by.getLocator(),System.getProperty("line.separator","\r\n")));
        } catch (IOException ex) {
            // report
        } finally {
            try {
                writer.close();
            } catch (Exception ex) {
            }
        }
    }

    private String getSuitePath(){
        String suite = Config.suitePath;
        File suiteFile = new File(suite);
        if (! suiteFile.isAbsolute()) {
            suite = new File(System.getProperty("user.dir"), suite).toString();
        }
        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            suite = suite.replace('/', '\\');
        }
        return suite;
    }

    private void createBatchFile(String runscriptPath){

        try {

            writer = new FileWriter(batchFile);
            writer.write(String.format("%s -RestoreConnection no -QuitAfterRun no -RunOnLaunch \"%s\"",runscriptPath,scriptPath));
        } catch (IOException ex) {
            // report
        } finally {
            try {writer.close();} catch (Exception ex) {}
        }
    }

    public void runBatch() {

        Process process;
        ProcessBuilder builder;
        String runScriptPath;

            if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                runScriptPath = "\"" + Config.windowsScriptPath + "\"";
            } else {
                runScriptPath = Config.unixScriptPath;
            }
        createTempScriptFile();
        createBatchFile(runScriptPath);

        builder= new ProcessBuilder(batchFile);
        try {
            process = builder.start();
            process.waitFor();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

