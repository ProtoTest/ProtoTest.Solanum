package com.prototest.solanum;

import com.google.common.base.Joiner;
import junit.framework.Assert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Brian on 5/12/2014.
 */
class EggplantProcess {
    private Process eggplantDrive;
    private ProcessBuilder command;
    private Thread processLogger;

    EggplantProcess() {
        String runScriptPath = Config.runScriptPath;

        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            runScriptPath = "\"" + runScriptPath + "\"";
        } else {
            runScriptPath = runScriptPath.replace(" ", "\\ ");
        }
        this.command = new ProcessBuilder(runScriptPath, "-driveport", Config.drivePort, "-drivelogging", Config.driveLoggingLevel);
        this.command.redirectErrorStream(true);

    }

    void stop() {
        try {
            eggplantDrive.destroy();
            eggplantDrive.waitFor();
        } catch (InterruptedException e) {
            Logger.error("Exception caught stopping eggplant : " + e.getMessage());
            kill();
        }
    }

    void kill() {

        Runtime rt = Runtime.getRuntime();
        try {
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                Logger.message("Executing : taskkill  /F /IM eggPlant.exe");
                rt.exec("taskkill  /F /IM eggPlant.exe");
            } else {
                Logger.message("Executing : pkill -9 -fi eggplant");
                rt.exec("pkill -9 -fi eggplant");
            }
        } catch (IOException e) {
            Logger.error("Exception caught killing eggplant : " + e.getMessage());
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }

    }

    void start() {
        String line;
        try {

            Logger.message("Executing command : " + Joiner.on(' ').join(command.command()));
            eggplantDrive = command.start();

            BufferedReader input = new BufferedReader
                    (new InputStreamReader(eggplantDrive.getInputStream()));
            while ((line = input.readLine()) != null) {
                if (Config.logDriveCommands) {
                    Logger.message(line);
                }
                if (line.contains("Maximum Users")) {
                    Assert.fail("The maximum number of simultaneous users has been exceeded for your eggPlant license.");
                }
                if (line.contains("No valid License")) {
                    Assert.fail("No valid eggplant license was found.  Please launch the eggplant GUI, add a license, and try again.");
                }
                if (line.contains("Starting eggPlant Drive")) {
                    Logger.message("eggPlant Drive started on port " + Config.drivePort);
                    processLogger = new ProcessLogger(input);
                    processLogger.start();
                    return;
                }
            }
            Logger.error("eggPlant Drive did not start.");
            input.close();
        } catch (IOException e) {
            Logger.error("Exception caught starting eggplant : " + e.getMessage());
        }
        throw new RuntimeException("Failed to start eggPlant Drive.");
    }

    private class ProcessLogger extends Thread {

        private final BufferedReader input;

        public ProcessLogger(BufferedReader input) {
            this.input = input;
        }

        @Override
        public void run() {
            String line;
                try {
                    while ((line = input.readLine()) != null) {
                        yield();

                        if (Config.logDriveCommands) {
                            Logger.message(line);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }


            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

        }
    }

}
